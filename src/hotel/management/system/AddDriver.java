package hotel.management.system;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener {
	
	JButton add, cancel;
	JTextField tfname, tfage,tfcompany,tfmodel,tflocation;
	JComboBox availablecombo, gendercombo;
	
	
	AddDriver(){
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel heading = new JLabel("Add Drivers");
		heading.setFont(new Font("Tahoma", Font.BOLD, 18));
		heading.setBounds(150,10,200,20);
		add(heading);
		
		JLabel lblroomno = new JLabel("Name");
		lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblroomno.setBounds(60,40,120,30);
		add(lblroomno);
		
		tfname = new JTextField();
		tfname.setBounds(200, 40, 150, 30);
		add(tfname);
		
		JLabel lblage = new JLabel("Age");
		lblage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblage.setBounds(60,80,120,30);
		add(lblage);
		
		tfage = new JTextField();
		tfage.setBounds(200, 80, 150, 30);
		add(tfage);
		
		
		JLabel lblclean = new JLabel("Gender");
		lblclean.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblclean.setBounds(60,120,120,30);
		add(lblclean);
		
		String cleanOption[] = {"Male", "Female"};
		gendercombo = new JComboBox(cleanOption);
		gendercombo.setBounds(200,120,150,30);
		gendercombo.setBackground(Color.white);
		add(gendercombo);
		
		

		
		JLabel lblprice = new JLabel("Car Company");
		lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblprice.setBounds(60,160,120,30);
		add(lblprice);
		
		tfcompany = new JTextField();
		tfcompany.setBounds(200, 160, 150, 30);
		add(tfcompany);
		
		JLabel lbltype = new JLabel("Car Model");
		lbltype.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbltype.setBounds(60,200,120,30);
		add(lbltype);
		
		tfmodel = new JTextField();
		tfmodel.setBounds(200, 200, 150, 30);
		add(tfmodel);
		
		
		JLabel lblavailable = new JLabel("Available");
		lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblavailable.setBounds(60,240,120,30);
		add(lblavailable);
		
		String driverOption[] = {"Available", "Busy"};
		availablecombo = new JComboBox(driverOption);
		availablecombo.setBounds(200,240,150,30);
		availablecombo.setBackground(Color.white);
		add(availablecombo);
		
		JLabel lbllocation = new JLabel("Location");
		lbllocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbllocation.setBounds(60,280,120,30);
		add(lbllocation);
		
		tflocation = new JTextField();
		tflocation.setBounds(200, 280, 150, 30);
		add(tflocation);
		
		add = new JButton("Add Driver");
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
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
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
			String name = tfname.getText();
			String age = tfage.getText();
			String gender = (String) gendercombo.getSelectedItem();
			String company = tfcompany.getText();
			String brand = tfmodel.getText();
			String available = (String) availablecombo.getSelectedItem();
			String location = tflocation.getText();
			
			if(name.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Name should not be empty");
				return;
			}
			

			if(age.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Age should not be empty");
				return;
			}
			

			if(company.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Car Company should not be empty");
				return;
			}
			

			if(brand.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Car Model should not be empty");
				return;
			}
			

			if(location.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Location should not be empty");
				return;
			}
			
			
			try
			{
				Conn conn = new Conn();				
				String query = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";
				
				conn.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "New Driver Added Successfully");
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
		new AddDriver();
		
	}


}


