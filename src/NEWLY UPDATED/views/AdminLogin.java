package com.vishnu.views;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.vishnu.controller.*;
import com.vishnu.model.*;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AdminLogin {

	private JFrame frmLoginForm;
	private JTextField tUserId;
	private JPasswordField tPassword;
	AdminController admincontroller;
	JButton bLogin, bRegister, bUserLogin;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new AdminLogin();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public AdminLogin() throws ClassNotFoundException, SQLException {
		frmLoginForm = new JFrame();
		frmLoginForm.setTitle("LOGIN FORM");
		frmLoginForm.setBounds(100, 100, 476, 357);
		frmLoginForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginForm.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USER ID");
		lblNewLabel.setBounds(106, 65, 129, 35);
		frmLoginForm.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(106, 131, 129, 35);
		frmLoginForm.getContentPane().add(lblPassword);
	
		JButton bLogin = new JButton("CHECK IN !");
		bLogin.setBounds(30, 222, 120, 41);
		frmLoginForm.getContentPane().add(bLogin);
		
		admincontroller = new AdminController(); 
		bLogin.addActionListener(new ActionListener() {  
		@Override	
		public void actionPerformed(ActionEvent arg) {
				    try {
				    	String UID, UP;
				    	Admin admin=new Admin();
				    	UID = tUserId.getText();
				    	UP  = new String(tPassword.getPassword());
				    	admin = admincontroller.checkLogin(UID);
				 
				    if(admin.getPassword().equals(UP)) {
				    		if(admin.getRole().equals("HR")) {
				    		frmLoginForm.dispose();
				    		new HrHome(); 
				    		}
				    	else {
				    			frmLoginForm.dispose();
					    	new PmePortal();
				    		}
				    	}

				    	else {
				    			JFrame frame = new JFrame();
				    			JOptionPane.showMessageDialog(frame,"Wrong Passord or Register");} 	    		
				    }
				    catch(Exception e) {		
				   		e.printStackTrace();
				   		}
				    }
			});
		
		JButton bUserLogin = new JButton("USER LOGIN");
		bUserLogin.setBounds(171, 222, 133, 41);
		frmLoginForm.getContentPane().add(bUserLogin);
		
		bUserLogin.addActionListener(new ActionListener() {
		    	@Override
		    	public void actionPerformed(ActionEvent arg) {
		    		try {
		    			frmLoginForm.dispose();
						new UserLogin();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
		    	}
		    });
		
		JButton bRegister = new JButton("USER REGISTER !");
		bRegister.setBounds(314, 222, 120, 41);
		frmLoginForm.getContentPane().add(bRegister);
		
		bRegister.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent arg) {
	    		try {
	    			frmLoginForm.dispose();
					new UserRegistration();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	    	}
	    });
	    
		
		tUserId = new JTextField();
		tUserId.setBounds(245, 68, 129, 28);
		frmLoginForm.getContentPane().add(tUserId);
		tUserId.setColumns(10);
		
		tPassword = new JPasswordField();
		tPassword.setBounds(245, 131, 129, 28);
		
		frmLoginForm.getContentPane().add(tPassword);
		frmLoginForm.setVisible(true);
		frmLoginForm.getContentPane().setBackground(Color.LIGHT_GRAY);
	}
}


