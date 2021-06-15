package com.vishnu.views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.vishnu.controller.UserController;

import java.awt.Font;
import javax.swing.DefaultComboBoxModel;


public class UserRegistration {


	JFrame frame = new JFrame("USER REGISTERATION");
	private JLabel lTitle= new  JLabel("USER REGISTERATION FORM");
	private JTextField tFirstName;
	private JTextField tLastName;
	private JComboBox<String> cGender;
	private JPasswordField tPassword;
	private JPasswordField tConfirmPassword;
	private JTextField tUserId;
	private JTextField tPhoneNumber;
	private JButton bSubmit;
	public static UserController usercontroller= null;
	private JLabel lblNewLabel;
	private JLabel lblEnterYourLast;
	private JLabel lblGender;
	private JLabel lblEnterPassword;
	private JLabel lblEnterConfirmPassword;
	private JLabel lblEnterUserId;
	private JLabel lblEnterPhoneNumber;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		 new UserRegistration();
	}
	public UserRegistration() throws ClassNotFoundException, SQLException {

		lTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		lTitle.setBounds(10,11,404,30);
		lTitle.setForeground(Color.BLACK);
		frame.getContentPane().add(lTitle);
		
		tFirstName = new JTextField("");
		tFirstName.setBounds(196,70,168,30);
		frame.getContentPane().add(tFirstName);

		tLastName = new JTextField("");
		tLastName.setBounds(196,123,168,30);
		frame.getContentPane().add(tLastName);

		
		tPassword = new JPasswordField();
		tPassword.setBounds(196,230,168,30);
		frame.getContentPane().add(tPassword);

		tConfirmPassword = new JPasswordField();
		tConfirmPassword.setBounds(196,282,168,30);
		frame.getContentPane().add(tConfirmPassword);
		
		tUserId = new JTextField("");
		tUserId.setBounds(196,337,168,30);
		frame.getContentPane().add(tUserId);
		
		tPhoneNumber = new JTextField("");
		tPhoneNumber.setBounds(196,389,168,30);
		frame.getContentPane().add(tPhoneNumber);
		
		cGender = new JComboBox();
		cGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Others"}));
		cGender.setBounds(196, 178, 168, 30);
		frame.getContentPane().add(cGender);
		
		bSubmit = new JButton("SUBMIT");
		bSubmit.setBounds(79,451,107,35);
		frame.getContentPane().add(bSubmit);
		
		usercontroller = new UserController();
		bSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String UID, UFN, ULN, UP, UCP, UG, UPN;
				UID=tUserId.getText();
				UFN=tFirstName.getText();
				ULN=tLastName.getText();
				UP=new String(tPassword.getPassword());
				UG=cGender.getSelectedItem().toString();
				UPN=tPhoneNumber.getText();
				UCP=new String(tConfirmPassword.getPassword());
				

				if(UP.equals(UCP))
				{
					usercontroller.addUser(UID, UFN, ULN, UP, UPN, UG);							
					frame.dispose();
					try {
						new UserLogin();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}else {
					JOptionPane.showMessageDialog(frame, "Mismatch in Password and ConfirmPassword");
				}
			}
		});
		
		JButton bUserLogin = new JButton("USER LOGIN");
		bUserLogin.setBounds(226,451, 102, 35);
		frame.getContentPane().add(bUserLogin);
		bUserLogin.addActionListener(new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 frame.dispose();
				 try {
					new UserLogin();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 }
			});

		frame.setBounds(480,80,420,600);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("ENTER YOUR FIRST NAME");
		lblNewLabel.setBounds(36, 70, 150, 30);
		frame.getContentPane().add(lblNewLabel);
		
		lblEnterYourLast = new JLabel("ENTER YOUR LAST NAME");
		lblEnterYourLast.setBounds(36, 123, 150, 30);
		frame.getContentPane().add(lblEnterYourLast);
		
		lblGender = new JLabel("GENDER");
		lblGender.setBounds(36, 178, 150, 30);
		frame.getContentPane().add(lblGender);
		
		lblEnterPassword = new JLabel("ENTER PASSWORD");
		lblEnterPassword.setBounds(36, 230, 150, 30);
		frame.getContentPane().add(lblEnterPassword);
		
		lblEnterConfirmPassword = new JLabel("ENTER CONFIRM PASSWORD");
		lblEnterConfirmPassword.setBounds(36, 282, 150, 30);
		frame.getContentPane().add(lblEnterConfirmPassword);
		
		lblEnterUserId = new JLabel("ENTER USER ID");
		lblEnterUserId.setBounds(36, 337, 150, 30);
		frame.getContentPane().add(lblEnterUserId);
		
		lblEnterPhoneNumber = new JLabel("ENTER PHONE NUMBER");
		lblEnterPhoneNumber.setBounds(36, 389, 150, 30);
		frame.getContentPane().add(lblEnterPhoneNumber);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

}
