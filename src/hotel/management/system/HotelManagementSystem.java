package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;
public class HotelManagementSystem extends JFrame implements ActionListener {

	HotelManagementSystem(){

		setBounds(0,100,1280,500);
		setVisible(true);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/first2.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(0,0,1320,530);
		add(image);
		
		JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
		text.setBounds(150, 50, 1000, 60);
		text.setForeground(Color.white);
		text.setFont(new Font("serif",Font.BOLD,60));
		image.add(text); 
		

		
		JButton next = new JButton("Next");
		next.setBounds(600, 200, 110, 40);
		next.setBackground(Color.white);
		next.setForeground(Color.magenta);
		next.addActionListener(this);
		next.setFont(new Font("serif", Font.BOLD, 24));
		image.add(next);
		
		setVisible(true);
		
		while(true)
		{
			text.setVisible(false);
			try
			{
				Thread.sleep(500);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			text.setVisible(true);
			try
			{
				Thread.sleep(500);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
		new Login();
	}
	public static void main(String[] args) {
		new HotelManagementSystem();
	}
}
