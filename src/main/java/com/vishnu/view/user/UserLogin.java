 package com.vishnu.view.user;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;

import javax.swing.*;

import com.vishnu.controller.UserController;
import com.vishnu.model.User;  
	
	class UserLogin{
		JFrame frame= new JFrame("User Login");
		JLabel lTitle;
		JTextField tUserId;
	    JPasswordField tPassword;
	    JButton bLogin, bRegister;
	    UserController usercontroller;
	    //User user;
		
	public static void main(String args[]){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			try {
				new UserLogin();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	});		
}
			
		  
	UserLogin() throws ClassNotFoundException, SQLException{

		usercontroller = new UserController();
		
	    lTitle = new JLabel("USER LOGIN");
	    lTitle.setBounds(100,100,200,30);
	    frame.add(lTitle);
	    
	    tUserId = new JTextField("USER ID");
	    tUserId.setBounds(100,150,200,30);
	    frame.add(tUserId);
	    tUserId.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(tUserId.getText().equals("USER ID")) {
				tUserId.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(tUserId.getText().equals("")) {
				tUserId.setText("USER ID");
				}
			}

	    });
	    

	    
	    
	    
	    tPassword = new JPasswordField("PASSWORD");
	    tPassword.setEchoChar((char)0);
	    tPassword.setBounds(100,200,200,30);
	    frame.add(tPassword);
	    tPassword.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(new String(tPassword.getPassword()).equals("PASSWORD")) {
				tPassword.setText("");}
				tPassword.setEchoChar('*');
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(new String(tPassword.getPassword()).equals("")) {
				tPassword.setText("PASSWORD");
				tPassword.setEchoChar((char)0);
				}
			}

	    });

	    
	    bLogin = new JButton("LOGIN");
	    bLogin.setBounds(100,250,200,30);
	    frame.add(bLogin);
	    usercontroller = new UserController();
	    //user = new User();
	    bLogin.addActionListener(new ActionListener() {
	    
	    @Override	
	    public void actionPerformed(ActionEvent arg) {
	    	try {
	    		User user= new User();
	    	String UID, UP;
	    	UID = tUserId.getText();
	    	UP  = new String(tPassword.getPassword());
	    	user = usercontroller.checkLogin(UID);	  
	    	if(user.getPassword().equals(UP)) {
	    		frame.dispose();
	    		new UserPortal(user); 
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

	    
	    bRegister = new JButton("REGISTER");
	    bRegister.setBounds(100,300,200,30);
	    frame.add(bRegister);
	    bRegister.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent arg) {
	    		try {
					new UserRegistration();
					frame.dispose();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	    	}
	    });
	    
	      
	    frame.setBounds(440,60,450,580);
	    frame.setLayout(null);  
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
	}  
	
}

