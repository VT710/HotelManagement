package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class Pickup extends JFrame implements ActionListener  {

	JTable table;
	JButton back, submit;
	Choice typeofcar;
	JCheckBox available;
	
	Pickup()
	{
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		 
		JLabel text = new JLabel("Search for Rooms");
		text.setFont(new Font("Tahoma", Font.PLAIN,20));
		text.setBounds(400,20,200,30);
		add(text);
				
		 
		JLabel lblbed = new JLabel("Type of Car");
		lblbed.setFont(new Font("Tahoma", Font.PLAIN,20));
		lblbed.setBounds(50,100,150,20);
		add(lblbed);
		
		typeofcar = new Choice();
		typeofcar.setBounds(200,100,150,25);
		add(typeofcar);
		try
		{
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from driver");
			while(rs.next())
			{
				typeofcar.add(rs.getString("brand"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		JLabel l1 = new JLabel("Name");
		l1.setBounds(20,180,100,20);
		add(l1);
		
		JLabel l2 = new JLabel("Age ");
		l2.setBounds(180,180,100,20);
		add(l2);

		JLabel l3 = new JLabel("Gender");
		l3.setBounds(320,180,100,20);
		add(l3);
		
		JLabel l4 = new JLabel("Company");
		l4.setBounds(460,180,100,20);
		add(l4);
		
		JLabel l5 = new JLabel("Brand");
		l5.setBounds(620,180,100,20);
		add(l5);
		
		JLabel l6 = new JLabel("Availability");
		l6.setBounds(750,180,100,20);
		add(l6);
				
		JLabel l7 = new JLabel("Location");
		l7.setBounds(910,180,100,20);
		add(l7);
		
		back = new JButton("Back");
		back.setBounds(500, 500, 120,30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		submit = new JButton("Submit");
		submit.setBounds(350, 500, 120,30);
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.addActionListener(this);
		add(submit);
		
		
		
		table = new JTable();
		table.setBounds(20, 200, 1000,300);
		add(table);
		
		
		try
		{
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from driver");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		setBounds(120, 60,1050, 600);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		
		if(ae.getSource() == submit)
		{
			try
			{
				String query = "select * from driver where brand = '"+typeofcar.getSelectedItem()+ "'";
				
				Conn conn = new Conn();
				
				ResultSet rs;
				rs = conn.s.executeQuery(query);
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
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
		new Pickup();
	}
}
