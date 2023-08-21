package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class CustomerInfo extends JFrame implements ActionListener  {

	JTable table;
	JButton back;
	
	CustomerInfo()
	{
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		
		JLabel l1 = new JLabel("Document Type");
		l1.setBounds(20,10,100,20);
		add(l1);
		
		JLabel l2 = new JLabel("Id Number ");
		l2.setBounds(140,10,100,20);
		add(l2);

		JLabel l3 = new JLabel("Name");
		l3.setBounds(270,10,100,20);
		add(l3);
		
		JLabel l4 = new JLabel("Gender");
		l4.setBounds(390,10,100,20);
		add(l4);
		
		JLabel l5 = new JLabel("Country");
		l5.setBounds(520,10,100,20);
		add(l5);
				
		JLabel l6 = new JLabel("Room Number");
		l6.setBounds(640,10,100,20);
		add(l6);
				
		JLabel l7 = new JLabel("Checkin time");
		l7.setBounds(770,10,100,20);
		add(l7);
				
		JLabel l8 = new JLabel("Deposit");
		l8.setBounds(900,10,100,20);
		add(l8);
				
		back = new JButton("Back");
		back.setBounds(420, 500, 120,30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		
		table = new JTable();
		table.setBounds(0, 40, 1000,400);
		add(table);
		
		
		try
		{
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer ");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		setBounds(120, 60,1000, 600);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
		new Reception();
	}
	
	public static void main(String[] args) {
		new CustomerInfo();
	}
}
