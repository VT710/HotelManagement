package hotel.management.system;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;

public class Dashboard  extends JFrame implements ActionListener{
	Dashboard()
	{
		setBounds(0,0,1280,680);
		
		setLayout(null);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/third1.jpg"));
		Image i2= i1.getImage().getScaledInstance(1280,680, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1280,680);
		add(image);
		
		JLabel text = new JLabel("VT GROUP WELCOMES YOU");
		text.setBounds(300,40,1000,50);
		text.setFont(new Font("Tahoma", Font.BOLD, 46));
		text.setForeground(Color.white);
		image.add(text);
	
		
		JMenuBar mb = new JMenuBar();
		mb.setBounds(0,0,1280,30);
		
		JMenu hotel = new JMenu("HOTEL MANAGEMENT");
		hotel.setForeground(Color.red);
		mb.add(hotel);
		image.add(mb);
		
		JMenuItem reception = new JMenuItem("RECEPTION");
		reception.addActionListener(this);
		hotel.add(reception);
		
		JMenu admin = new JMenu("ADMIN");
		admin.setForeground(Color.blue);
		mb.add(admin);
		image.add(mb);
		
		JMenuItem addemployee= new JMenuItem("ADD EMPLOYEE");
		addemployee.addActionListener(this);
		admin.add(addemployee);
		
		JMenuItem addrooms= new JMenuItem("ADD ROOM");
		addrooms.addActionListener(this);
		admin.add(addrooms);
		
		JMenuItem adddrivers= new JMenuItem("ADD DRIVER");
		adddrivers.addActionListener(this);
		admin.add(adddrivers);
		
		setVisible(true);
		
//		
//		setVisible(true);
//		
//		while(true)
//		{
//			text.setVisible(false);
//			try
//			{
//				Thread.sleep(500);
//				
//			}
//			catch(Exception e)
//			{
//				e.printStackTrace();
//			}
//			text.setVisible(true);
//			try
//			{
//				Thread.sleep(500);
//				
//			}
//			catch(Exception e)
//			{
//				e.printStackTrace();
//			}
//		}
		
	}
	

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals("ADD EMPLOYEE"))
		{
			new AddEmployee();
		}
		else if(ae.getActionCommand().equals("ADD ROOM"))
		{
			new AddRooms();
		}
		else if(ae.getActionCommand().equals("ADD DRIVER"))
		{
			new AddDriver();
		}
		else if(ae.getActionCommand().equals("RECEPTION"))
		{
			new Reception();
		}
	}
	public static void main(String[] args) {
		
		new Dashboard();
		
	}
}
