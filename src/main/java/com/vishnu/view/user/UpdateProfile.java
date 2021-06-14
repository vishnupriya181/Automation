package com.vishnu.view.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import javax.swing.*;

import com.vishnu.controller.*;
import com.vishnu.model.User;

public class UpdateProfile{

	JFrame frame = new JFrame("UPDATE PROFILE");
	
	private JLabel lTitle= new  JLabel("UPDATE PROFILE");
	private JTextField tFirstName;
	private JTextField tLastName;
	private JComboBox<String> cGender;
	String gender[] = {"Male","Female","Others"};
	private JPasswordField tPassword;
	private JPasswordField tConfirmPassword;
	private JTextField tPhoneNumber;
	private JButton bSubmit,bBack;
	public static UserController usercontroller= null;
	
	UpdateProfile(User user) throws ClassNotFoundException, SQLException{
		
		lTitle.setBounds(100,50,180,30);
		frame.add(lTitle);
		
		tFirstName = new JTextField("CHANGE FIRST NAME");
		tFirstName.setBounds(100,100,180,30);
		frame.add(tFirstName);
		tFirstName.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(tFirstName.getText().equals("CHANGE FIRST NAME")) {
				tFirstName.setText("");}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(tFirstName.getText().equals("")) {
				tFirstName.setText("CHANGE FIRST NAME");}
			}

		});


	
		tLastName = new JTextField("CHANGE LAST NAME");
		tLastName.setBounds(100,150,180,30);
		frame.add(tLastName);
		tLastName.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(tLastName.getText().equals("CHANGE LAST NAME")) {
				tLastName.setText("");}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(tLastName.getText().equals("")) {
				tLastName.setText("CHANGE LAST NAME");}
			}

		});

		cGender = new JComboBox<String>(gender);
		cGender.setBounds(100,200,180,30);
		frame.add(cGender);
		
		tPassword = new JPasswordField();
		tPassword.setEchoChar((char)0);
		tPassword.setText("CHANGE PASSWORD");
		tPassword.setBounds(100,250,180,30);
		frame.add(tPassword);
		tPassword.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(new String(tPassword.getPassword()).equals("CHANGE PASSWORD")) {
				tPassword.setText("");
				tPassword.setEchoChar('*');
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(new String(tPassword.getPassword()).equals("")) {
				tPassword.setText("CHANGE PASSWORD");
				tPassword.setEchoChar((char)0);
				}
			}

		});


		tConfirmPassword = new JPasswordField();
		tConfirmPassword.setEchoChar((char)0);
		tConfirmPassword.setText("CONFIRM CHANGED PASSWORD");
		tConfirmPassword.setBounds(100,300,180,30);
		frame.add(tConfirmPassword);
		tConfirmPassword.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(new String(tConfirmPassword.getPassword()).equals("CONFIRM CHANGED PASSWORD")) {
				tConfirmPassword.setText("");}
				tConfirmPassword.setEchoChar('*');
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(new String(tConfirmPassword.getPassword()).equals("")) {
				tConfirmPassword.setText("CONFIRM CHANGED PASSWORD");
				tConfirmPassword.setEchoChar((char)0);
				}
			}

		});
		
		/*tSkill = new JTextField("UPDATE SKILL");
		tSkill.setBounds(100,350,180,30);
		frame.add(tSkill);
		tSkill.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(tSkill.getText().equals("UPDATE SKILL")) {
				tSkill.setText("");}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(tSkill.getText().equals("")) {
				tSkill.setText("UPDATE SKILL");}
			}

		});
*/

		
		tPhoneNumber = new JTextField("CHANGE PHONE NUMBER");
		tPhoneNumber.setBounds(100,400,180,30);
		frame.add(tPhoneNumber);
		tPhoneNumber.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(tPhoneNumber.getText().equals("CHANGE PHONE NUMBER")) {
				tPhoneNumber.setText("");}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(tPhoneNumber.getText().equals("")) {
				tPhoneNumber.setText("CHANGE PHONE NUMBER");}
			}

		});

		bSubmit = new JButton("SUBMIT");
		bSubmit.setBounds(100,450,180,30);
		frame.add(bSubmit);
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
	//			US = tSkill.getText();
				UCP=new String(tConfirmPassword.getPassword());
				
				
				if(UP.equals(UCP)) {
					usercontroller.UpdateProfile(UID,UFN, ULN, UP, UPN, UG);		
					try {
						new UserPortal(user);
						frame.dispose();
					} catch (ClassNotFoundException | SQLException e1) {
				
						e1.printStackTrace();
					}

				}else {
					JOptionPane.showMessageDialog(frame, "Password mismatch please check and try again");
				}
			}
		});
		
		bBack = new JButton("BACK");
		bBack.setBounds(100,500,180,30);
		frame.add(bBack);
		bBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					try {
						new UserPortal(user);
						frame.dispose();
					} catch (ClassNotFoundException | SQLException e1) {
				
						e1.printStackTrace();
					}

				}
		});

				
		frame.setBounds(480,80,400,600);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
			
}		
