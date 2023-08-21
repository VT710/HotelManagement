package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class Department extends JFrame implements ActionListener  {

	JTable table;
	JButton back;
	
	Department()
	{
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		
		JLabel l1 = new JLabel("Department");
		l1.setBounds(80,10,100,20);
		add(l1);
		
		JLabel l2 = new JLabel("Budget");
		l2.setBounds(340,10,100,20);
		add(l2);

		
				
		back = new JButton("Back");
		back.setBounds(250, 500, 120,30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		
		table = new JTable();
		table.setBounds(50, 40, 500,400);
		add(table);
		
		
		try
		{
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from department");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		setBounds(350, 60,600, 600);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
		new Reception();
	}
	
	public static void main(String[] args) {
		new Department();
	}
}
