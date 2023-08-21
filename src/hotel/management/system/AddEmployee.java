package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{
	
	JTextField tfname, tfemail, tfage, tfphone, tfsalary, tfaadhar;
	JRadioButton rbmale, rbfemale;
	JButton submit, back;
	JComboBox cbjob;
	
	
	
	AddEmployee(){
		setLayout(null);
		
		JLabel lblname = new JLabel("NAME");
		lblname.setBounds(60, 30, 120, 30);
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblname);
		
		tfname = new JTextField();
		tfname.setBounds(200, 30, 150, 30);
		add(tfname);
		
		JLabel lblage = new JLabel("AGE");
		lblage.setBounds(60, 80, 120, 30);
		lblage.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblage);
		
		tfage = new JTextField();
		tfage.setBounds(200, 80, 150, 30);
		add(tfage);
		
		JLabel lblgender = new JLabel("GENDER");
		lblgender.setBounds(60,130, 120, 30);
		lblgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblgender);
		
		rbmale = new JRadioButton("Male");
		rbmale.setBounds(200, 130, 70, 30);
		rbmale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbmale.setBackground(Color.white);
		add(rbmale);
		
		rbfemale = new JRadioButton("Female");
		rbfemale.setBounds(280, 130, 70, 30);
		rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbfemale.setBackground(Color.white);
		add(rbfemale);
		
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbmale);
		bg.add(rbfemale);
		
		
		JLabel lbljob = new JLabel("JOB");
		lbljob.setBounds(60,180, 120, 30);
		lbljob.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lbljob);
		
		String str[] = {"Front Desk Clerk", "Porters", "Housekeeping", "Kitchen Staff", "Room Service","Chefs", "Waiter/Waitress", "Manager", "Accountants"};
		cbjob = new JComboBox(str);
		cbjob.setBounds(200, 180, 150, 30);
		cbjob.setBackground(Color.white);
		add(cbjob);
		
		
		JLabel lblsalary = new JLabel("SALARY");
		lblsalary.setBounds(60,230, 120, 30);
		lblsalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblsalary);
				
		tfsalary = new JTextField();
		tfsalary.setBounds(200, 230, 150, 30);
		add(tfsalary);
		
		
		JLabel lblphone = new JLabel("PHONE");
		lblphone.setBounds(60,280, 120, 30);
		lblphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblphone);
				
		tfphone = new JTextField();
		tfphone.setBounds(200, 280, 150, 30);
		add(tfphone);
		

		JLabel lblemail = new JLabel("EMAIL");
		lblemail.setBounds(60,320, 120, 30);
		lblemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblemail);
				
		tfemail = new JTextField();
		tfemail.setBounds(200, 320, 150, 30);
		add(tfemail);
		
		JLabel lblaadhar = new JLabel("AADHAR");
		lblaadhar.setBounds(60,370, 120, 30);
		lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblaadhar);
				
		tfaadhar = new JTextField();
		tfaadhar.setBounds(200, 370, 150, 30);
		add(tfaadhar);
		
		submit = new JButton("SUBMIT");
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.setBounds(200, 430,150,30);
		submit.addActionListener(this);
		add(submit);
		
		back = new JButton("BACK");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setBounds(30, 430,150,30);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
		Image i2 = i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(380, 60, 450, 370);
		add(image);
		
		
		
		getContentPane().setBackground(Color.white);
		setBounds(200, 130, 850, 540);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String name = tfname.getText();
		
		if(name.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Name should not be empty");
			return;
		}
		String age = tfage.getText();
		
		if(age.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Age should not be empty");
			return;
		}
		
		String salary = tfsalary.getText();
		if(salary.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Salary should not be empty");
			return;
		}
		
		String phone = tfphone.getText();
		
		if(phone.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Phone should not be empty");
			return;
		}
		String email = tfemail.getText();
		
		if(email.equals("") )
		{
			JOptionPane.showMessageDialog(null,"Email should not be empty");
			return;
		}
		
		String aadhar = tfaadhar.getText();
		
		if(aadhar.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Aadhar should not be empty");
			return;
		}
		
		
		
		
		
		String gender = null;
		
		if(rbmale.isSelected())
		{
			gender ="Male";
		}
		else if(rbfemale.isSelected())
		{
			gender = "Female";
		}
		
		String job = (String) cbjob.getSelectedItem();
		
		try {
			Conn conn = new Conn();
			
			String query = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
			
			conn.s.executeUpdate(query);
			
			JOptionPane.showMessageDialog(null, "Employee added successfully");
			
			setVisible(false);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		new AddEmployee();
		
	}

}
