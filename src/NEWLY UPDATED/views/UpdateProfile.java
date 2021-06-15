package com.vishnu.views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.vishnu.controller.UserController;
import com.vishnu.model.User;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;


public class UpdateProfile {
JFrame frame = new JFrame("UPDATE PROFILE");
	
	private JLabel lTitle= new  JLabel("UPDATE YOUR PROFILE");
	private JTextField tFirstName;
	private JTextField tLastName;
	private JTextField tPhoneNumber;
	private JButton bSubmit,bBack;
	public static UserController usercontroller= null;
	private JLabel lblNewLabel;
	private JLabel lblChangeLastName;
	private JLabel lblChangePassword;
	private JLabel lblConfirmChangedPassword;
	private JLabel lblChangePhoneNumber;
	private JPasswordField tPassword;
	private JPasswordField tConfirmPassword;
	
	
	public UpdateProfile(User user) throws ClassNotFoundException, SQLException {
		lTitle.setBackground(Color.WHITE);
		lTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lTitle.setBounds(0,11,404,46);
		lTitle.setForeground(Color.BLACK);
		frame.getContentPane().add(lTitle);
		
		tFirstName = new JTextField("");
		tFirstName.setBounds(201,68,163,30);
		frame.getContentPane().add(tFirstName);

		tLastName = new JTextField("");
		tLastName.setBounds(201,124,163,30);
		frame.getContentPane().add(tLastName);
		
		tPhoneNumber = new JTextField("");
		tPhoneNumber.setBounds(201,338,163,30);
		frame.getContentPane().add(tPhoneNumber);
		
		JComboBox cGender = new JComboBox();
		cGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Others"}));
		cGender.setBounds(201, 174, 163, 30);
		frame.getContentPane().add(cGender);

		bSubmit = new JButton("SUBMIT");
		bSubmit.setBounds(66,420,108,42);
		frame.getContentPane().add(bSubmit);
		usercontroller=new UserController();
		bSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String UID, UFN, ULN, UP, UCP, UG, UPN;
				UID = user.getUserId();
				UFN=tFirstName.getText();
				ULN=tLastName.getText();
				UP=new String(tPassword.getPassword());
				UG=cGender.getSelectedItem().toString();
				UPN=tPhoneNumber.getText();
				UCP=new String(tConfirmPassword.getPassword());
				
				
				if(UP.equals(UCP)) {
					usercontroller.UpdateProfile(UID,UFN, ULN, UP, UPN, UG);	
					tFirstName.setText("");
					tLastName.setText("");
					tPassword.setText("");
					tPassword.setEchoChar((char)0);
					tPhoneNumber.setText("");
					tConfirmPassword.setText("");
					tConfirmPassword.setEchoChar((char)0);
				}else {
					JOptionPane.showMessageDialog(frame, "Password mismatch please check and try again");
				}
			}
		});
		
		bBack = new JButton("BACK");
		bBack.setBounds(243,420,108,42);
		frame.getContentPane().add(bBack);
		bBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
						frame.dispose();
				}
		});

				
		frame.setBounds(480,80,420,533);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("CHANGE FIRST NAME");
		lblNewLabel.setBounds(33, 68, 158, 30);
		frame.getContentPane().add(lblNewLabel);
		
		lblChangeLastName = new JLabel("CHANGE LAST NAME");
		lblChangeLastName.setBounds(33, 124, 158, 30);
		frame.getContentPane().add(lblChangeLastName);
		
		lblChangePassword = new JLabel("CHANGE PASSWORD");
		lblChangePassword.setBounds(33, 221, 158, 30);
		frame.getContentPane().add(lblChangePassword);
		
		lblConfirmChangedPassword = new JLabel("CONFIRM CHANGED PASSWORD");
		lblConfirmChangedPassword.setBounds(33, 278, 158, 30);
		frame.getContentPane().add(lblConfirmChangedPassword);
		
		lblChangePhoneNumber = new JLabel("CHANGE PHONE NUMBER");
		lblChangePhoneNumber.setBounds(33, 338, 158, 30);
		frame.getContentPane().add(lblChangePhoneNumber);
		
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setBounds(33, 180, 158, 24);
		frame.getContentPane().add(lblGender);
		
		tPassword = new JPasswordField();
		tPassword.setBounds(199, 226, 165, 30);
		frame.getContentPane().add(tPassword);
		
		tConfirmPassword = new JPasswordField();
		tConfirmPassword.setBounds(201, 277, 163, 30);
		frame.getContentPane().add(tConfirmPassword);
		frame.setVisible(true);
		}
}
