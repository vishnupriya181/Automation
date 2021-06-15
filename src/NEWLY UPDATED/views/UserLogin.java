package com.vishnu.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.vishnu.controller.UserController;
import com.vishnu.model.User;

import javax.swing.JPasswordField;
import javax.swing.JButton;

public class UserLogin {

	private JFrame frame;
	private JTextField tUserId;
	private JPasswordField tPassword;
	 UserController usercontroller;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
						new UserLogin();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public UserLogin() throws ClassNotFoundException, SQLException {
		usercontroller = new UserController();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 565, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USER ID");
		lblNewLabel.setBounds(82, 52, 130, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(82, 113, 130, 33);
		frame.getContentPane().add(lblPassword);
		
		tUserId = new JTextField();
		tUserId.setBounds(222, 55, 130, 27);
		frame.getContentPane().add(tUserId);
		tUserId.setColumns(10);
		
		tPassword = new JPasswordField();
		tPassword.setBounds(222, 119, 130, 27);
		frame.getContentPane().add(tPassword);
		
		JButton bLogin = new JButton("LOGIN");
		bLogin.setBounds(34, 232, 130, 43);
		frame.getContentPane().add(bLogin);
		
		 bLogin.addActionListener(new ActionListener() {  
			    @Override	
			    public void actionPerformed(ActionEvent arg) {
			    	try {
			    	User user= new User();
			    	String UID, UP;
			    	UID = tUserId.getText();
			    	UP  = new String(tPassword.getPassword());
			    	user = usercontroller.checkLogin(UID);
			    //	System.out.println(user.getUserId());
			 	
			    	if(user.getUserId().equals(UID)) {
			    		if(user.getPassword().equals(UP)) {
			    			frame.dispose();
			    			new UserPortal(user);
			    		}
			    		else{
			    			JFrame frame = new JFrame();
			    		JOptionPane.showMessageDialog(frame,"Wrong Passord or Register");
			    		}
			    	}
			    	else {	
			    		JFrame frame = new JFrame();
			    			JOptionPane.showMessageDialog(frame,"Wrong UserName or Register");} 	    		
			    }
			    catch(Exception e) {		
			   		e.printStackTrace();
			   		}
			    }
		});
		
		JButton bRegister = new JButton("REGISTER");
		bRegister.setBounds(207, 232, 130, 43);
		frame.getContentPane().add(bRegister);
	  bRegister.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent arg) {
	    		try {
	    			frame.dispose();
					new UserRegistration();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	    	}
	    });
	
		JButton bAdminLogin = new JButton("ADMIN LOGIN");
		bAdminLogin.setBounds(368, 232, 130, 43);
		frame.getContentPane().add(bAdminLogin);
		bAdminLogin.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent arg) {
	    		frame.dispose();
				try {
					new AdminLogin();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    });
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setVisible(true);
	}

}
