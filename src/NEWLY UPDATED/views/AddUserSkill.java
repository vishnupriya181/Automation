package com.vishnu.views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.vishnu.controller.UserController;
import com.vishnu.model.User;

import javax.swing.JLabel;




public class AddUserSkill {

	JFrame frame = new JFrame("ADD SKILL");
	UserController usercontroller;
		AddUserSkill(User user) throws ClassNotFoundException, SQLException {

		
	JTextField tSkill=new JTextField("");
	tSkill.setBounds(188, 44, 179, 30);
	frame.getContentPane().add(tSkill);
	
	
				
	JButton bSubmit=new JButton("SUBMIT");
	bSubmit.setBounds(70, 120, 121, 42);
	frame.getContentPane().add(bSubmit);
	usercontroller=new UserController();
	bSubmit.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String UID,SN;
			UID = user.getUserId();	
			SN=tSkill.getText();
			usercontroller.addUserSkill(UID , SN);		
		}
	});
	
	JButton bBack = new JButton("BACK");
	bBack.setBounds(221,120, 121, 42);
	frame.getContentPane().add(bBack);
	bBack.addActionListener(new ActionListener(){
		 @Override
		 public void actionPerformed(ActionEvent e) {
			 frame.dispose();
		 }
			 	 });

	
	
	frame.setBounds(480,250,420,244);
	frame.getContentPane().setBackground(Color.LIGHT_GRAY);
	frame.getContentPane().setLayout(null);
	
	JLabel lblNewLabel = new JLabel("ENTER SKILLS");
	lblNewLabel.setBounds(48, 44, 130, 30);
	frame.getContentPane().add(lblNewLabel);
	frame.setVisible(true);
	
}


}
