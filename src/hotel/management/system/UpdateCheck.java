package hotel.management.system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.sql.*;

public class UpdateCheck extends JFrame implements ActionListener{
	
	Choice ccustomer;
	JTextField tfroom, tfname, tfcheckin, tfpaid,tfpending;
	JButton check, update, back;

	UpdateCheck()
	{
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel text = new JLabel("Update Status");
		text.setFont(new Font("Tahoma", Font.PLAIN,20));
		text.setBounds(90,20,200,30);
		text.setForeground(Color.blue);
		add(text);
		
		JLabel lblid = new JLabel("Customer Id");
		lblid.setFont(new Font("Tahoma", Font.PLAIN,20));
		lblid.setBounds(30,80,150,20);
		add(lblid);
		
		JLabel lblroom = new JLabel("Room Number");
		lblroom.setFont(new Font("Tahoma", Font.PLAIN,20));
		lblroom.setBounds(30,120,150,20);
		add(lblroom);
		
		tfroom = new JTextField();
		tfroom.setBounds(200,120,150,25);
		add(tfroom);
		
		JLabel lblname = new JLabel("Name");
		lblname.setFont(new Font("Tahoma", Font.PLAIN,20));
		lblname.setBounds(30,160,150,20);
		add(lblname);
		
		tfname = new JTextField();
		tfname.setBounds(200,160,150,25);
		add(tfname);
		
		JLabel lblcheckintime = new JLabel("Checkin Time");
		lblcheckintime.setFont(new Font("Tahoma", Font.PLAIN,20));
		lblcheckintime.setBounds(30,200,150,20);
		add(lblcheckintime);
		
		tfcheckin = new JTextField();
		tfcheckin.setBounds(200,200,150,25);
		add(tfcheckin);
		
		JLabel lblpaid = new JLabel("Amount Paid");
		lblpaid.setFont(new Font("Tahoma", Font.PLAIN,20));
		lblpaid.setBounds(30,240,150,20);
		add(lblpaid);
		
		tfpaid = new JTextField();
		tfpaid.setBounds(200,240,150,25);
		add(tfpaid);
		
		JLabel lblpending = new JLabel("Pending Amount");
		lblpending.setFont(new Font("Tahoma", Font.PLAIN,20));
		lblpending.setBounds(30,280,150,20);
		add(lblpending);
		
		tfpending = new JTextField();
		tfpending.setBounds(200,280,150,25);
		add(tfpending);
		
		ccustomer =new Choice();
		ccustomer.setBounds(200,80,150,25);
		add(ccustomer);
		
		try
		{
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer;");
			while(rs.next())
			{
				ccustomer.add(rs.getString("number"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		check = new JButton("Check");
		check.setBackground(Color.black);
		check.setForeground(Color.white);
		check.setBounds(30,340,100,30);
		check.addActionListener(this);
		add(check);
		
		update = new JButton("Update");
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		update.setBounds(140,340,100,30);
		update.addActionListener(this);
		add(update);
		
		back = new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setBounds(250,340,100,30);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(400,50,500,300);
		add(image);
		
		
		setBounds(150,100,980,500);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()== check)
		{
			String id = ccustomer.getSelectedItem();
			String query = "select * from customer where number = '"+id+"';";
			try
			{
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query);	
				while(rs.next())
				{
					tfroom.setText(rs.getString("room"));
					tfname.setText(rs.getString("name"));
					tfcheckin.setText(rs.getString("chickintime"));
					tfpaid.setText(rs.getString("diposit"));
				}
				
				ResultSet rs2= c.s.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");
				while(rs2.next())
				{
					String price = rs2.getString("price");
					int amountPaid = Integer.parseInt(price) - Integer.parseInt(tfpaid.getText());
					tfpending.setText(""+amountPaid);
					
				}
				
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(ae.getSource()== update)
		{
			String number = ccustomer.getSelectedItem();
			String room = tfroom.getText();
			String name = tfname.getText();
			String checkin = tfcheckin.getText();
			String deposit = tfpaid.getText();
			try
			{
				Conn c = new Conn();
				c.s.executeUpdate("update customer set room ='"+room+"', name = '"+name+"', chickintime = '"+checkin+"', diposit = '"+deposit+"' where number = '"+number+"'");
				
				JOptionPane.showMessageDialog(null,"Data Updated Successfully");
				
				setVisible(false);
				new Reception();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		else if(ae.getSource()== back)
		{
			setVisible(false);
			new Reception();
		}
	}
	
	public static void main(String[] args) {
		new UpdateCheck();
	}
}
