package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class SearchRoom extends JFrame implements ActionListener  {

	JTable table;
	JButton back, submit;
	JComboBox bedType;
	JCheckBox available;
	
	SearchRoom()
	{
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		 
		JLabel text = new JLabel("Search for Rooms");
		text.setFont(new Font("Tahoma", Font.PLAIN,20));
		text.setBounds(400,20,200,30);
		add(text);
				
		 
		JLabel lblbed = new JLabel("Bed Type");
		lblbed.setFont(new Font("Tahoma", Font.PLAIN,20));
		lblbed.setBounds(50,100,100,20);
		add(lblbed);
		
		bedType =new JComboBox(new String[] {"Single Bed", "Double Bed"});
		bedType.setBounds(150,100,150,25);
		bedType.setBackground(Color.white);
		add(bedType);
		
		available = new JCheckBox("Only Disply Available");
		available.setBounds(650,100,150,25);
		available.setBackground(Color.white);
		add(available);
		
		JLabel l1 = new JLabel("Room Number");
		l1.setBounds(50,180,100,20);
		add(l1);
		
		JLabel l2 = new JLabel("Availability ");
		l2.setBounds(250,180,100,20);
		add(l2);

		JLabel l3 = new JLabel("Status");
		l3.setBounds(500,180,100,20);
		add(l3);
		
		JLabel l4 = new JLabel("Price");
		l4.setBounds(700,180,100,20);
		add(l4);
		
		JLabel l5 = new JLabel("Bed Type");
		l5.setBounds(850,180,100,20);
		add(l5);
				
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
			ResultSet rs = c.s.executeQuery("select * from room");
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
				String query1 = "select * from room where bed_type = '"+bedType.getSelectedItem()+ "'";
				String query2 = "select * from room where availability = 'Available' AND bed_type='"+bedType.getSelectedItem()+ "'";
				
				Conn conn = new Conn();
				
				ResultSet rs;
				if(available.isSelected())
				{
					rs = conn.s.executeQuery(query2);
				}
				else
				{
					rs = conn.s.executeQuery(query1);			
				}
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
		new SearchRoom();
	}
}
