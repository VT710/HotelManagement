package hotel.management.system;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {
	
	JButton add, cancel;
	JTextField tfroom, tfprice;
	JComboBox availablecombo, cleancombo, typecombo;
	
	
	AddRooms(){
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel heading = new JLabel("Add Rooms");
		heading.setFont(new Font("Tahoma", Font.BOLD, 18));
		heading.setBounds(150,20,200,20);
		add(heading);
		
		JLabel lblroomno = new JLabel("Room Number");
		lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblroomno.setBounds(60,80,120,30);
		add(lblroomno);
		
		tfroom = new JTextField();
		tfroom.setBounds(200, 80, 150, 30);
		add(tfroom);
		
		JLabel lblavailable = new JLabel("Available");
		lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblavailable.setBounds(60,130,120,30);
		add(lblavailable);
		
		String availableOption[] = {"Available", "Occupied"};
		availablecombo = new JComboBox(availableOption);
		availablecombo.setBounds(200,130,150,30);
		availablecombo.setBackground(Color.white);
		add(availablecombo);
		
		JLabel lblclean = new JLabel("Cleaning Status");
		lblclean.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblclean.setBounds(60,180,120,30);
		add(lblclean);
		
		String cleanOption[] = {"Cleaned", "Dirty"};
		cleancombo = new JComboBox(cleanOption);
		cleancombo.setBounds(200,180,150,30);
		cleancombo.setBackground(Color.white);
		add(cleancombo);
		
		
		JLabel lblprice = new JLabel("Price");
		lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblprice.setBounds(60,230,120,30);
		add(lblprice);
		
		tfprice = new JTextField();
		tfprice.setBounds(200, 230, 150, 30);
		add(tfprice);
		
		JLabel lbltype = new JLabel("Type");
		lbltype.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbltype.setBounds(60,280,120,30);
		add(lbltype);
		
		String typeOptions[] = {"Single Bed", "Double Bed"};
		typecombo = new JComboBox(typeOptions);
		typecombo.setBounds(200,280,150,30);
		typecombo.setBackground(Color.white);
		add(typecombo);
		
		
		add = new JButton("Add Room");
		add.setForeground(Color.white);
		add.setBackground(Color.black);
		add.setBounds(60, 350, 130, 30);
		add.addActionListener(this);
		add(add);
		
		
		cancel = new JButton("Cancel");
		cancel.setForeground(Color.white);
		cancel.setBackground(Color.black);
		cancel.setBounds(220, 350, 130, 30);
		cancel.addActionListener(this);
		add(cancel);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(400,30,500,300);
		add(image); 
		
		
		setBounds(200,130,940,470);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == add)
		{
			String roomnumber = tfroom.getText();
			if(roomnumber.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Room number should not be empty");
				return;
			}
			String availability = (String) availablecombo.getSelectedItem();
			String status = (String) cleancombo.getSelectedItem();
			String price = tfprice.getText();
			if(price.equals(""))
			{
				JOptionPane.showMessageDialog(null,"PRICE should not be empty");
				return;
			}
			
			String bed = (String) typecombo.getSelectedItem();
			
			try
			{
				Conn conn = new Conn();				
				String query = "insert into room values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+bed+"')";
				
				conn.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "New Room Added Successfully");
				setVisible(false);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		else 
		{
			setVisible(false);
		}
		
	}
	
	public static void main(String[] args) {
		new AddRooms();
		
	}


}


