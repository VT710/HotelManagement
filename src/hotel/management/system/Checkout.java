package hotel.management.system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.sql.*;
import java.util.Date;
public class Checkout extends JFrame implements ActionListener{
	
	Choice c1;
	JLabel lblroomnumber,lblcheckintime,lblcheckouttime;
	JButton checkout, back;

	Checkout()
	{
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(400, 225,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(300,0,500,305);
        add(image);
        
        JLabel text = new JLabel("Check Out");
		text.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text.setBounds(70, 11, 140, 35);
		add(text);

		JLabel lblid = new JLabel("Customer Id");
		lblid.setBounds(20, 85, 80, 14);
		add(lblid);
		
		c1 = new Choice();
		c1.setBounds(130,82,150,20);
		add(c1);
	      
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i5 = i4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel tick = new JLabel(i6);
        tick.setBounds(290,82,20,20);
        add(tick);
		
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(20, 130, 100, 30);
		add(lblroom);
        
		lblroomnumber = new JLabel();
	    lblroomnumber.setBounds(130, 130, 100, 30);
	    add(lblroomnumber);
	        
	    JLabel lblcheckin = new JLabel("Checkin Time");
	    lblcheckin.setBounds(20, 180, 100, 30);
		add(lblcheckin);
        
		lblcheckintime = new JLabel();
		lblcheckintime.setBounds(130, 180, 140, 30);
	    add(lblcheckintime);
	        
	    JLabel lblcheckout = new JLabel("Checkout Time");
	    lblcheckout.setBounds(20, 230, 100, 30);
		add(lblcheckout);
		
		Date date = new Date();
		lblcheckouttime =new JLabel(""+date);
		lblcheckouttime.setBounds(130,230,140,30);
		add(lblcheckouttime);
		
		checkout = new JButton("Checkout");
		checkout.setBackground(Color.black);
		checkout.setForeground(Color.white);
		checkout.setBounds(30,280,120,30);
		checkout.addActionListener(this);
		add(checkout);
		
		back = new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setBounds(170,280,120,30);
		back.addActionListener(this);
		add(back);
		
		try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next())
            {
                c1.add(rs.getString("number")); 
                lblroomnumber.setText(rs.getString("room"));
                lblcheckintime.setText(rs.getString("chickintime"));
            }
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
		
		
		setBounds(220,150,800,400);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == checkout)
		{
			String q1 = "delete from customer where number = '"+c1.getSelectedItem()+"'";
			String q2 = "update room set availability = 'Available' where roomnumber ='"+lblroomnumber.getText()+"'";
			
			try
			{
				Conn c = new Conn();
				c.s.executeUpdate(q1);
				c.s.executeUpdate(q2);
				
				JOptionPane.showMessageDialog(null, "Checkout Done");
				setVisible(false);
				new Reception();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			setVisible(false);
			new Reception();
		}
	}
	
	public static void main(String[] args) {
		new Checkout();
	}
}
