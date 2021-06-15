package com.vishnu.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.vishnu.controller.AdminController;

import javax.swing.JLabel;


public class DeleteUser {

	JFrame frame = new JFrame("DELETE USER");
	AdminController admincontroller;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteUser window = new DeleteUser();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public DeleteUser() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {

		JTextField tUserId = new JTextField("");
		tUserId.setBounds(184, 63, 200, 30);
		frame.getContentPane().add(tUserId);
		
		JButton bDelete = new JButton("DELETE");
		bDelete.setBounds(80,137, 112, 40);
		frame.getContentPane().add(bDelete);
		admincontroller = new AdminController();
		bDelete.addActionListener(new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent e) {			 
				 try {
					 String UID;
					 UID = tUserId.getText();
					 admincontroller.deleteUser(UID);
					 tUserId.setText("");
				} catch (Exception e1) {
					e1.printStackTrace();
				} 		 }
		 });
		
		JButton bBack = new JButton("BACK");
		bBack.setBounds(238,137, 119, 40);
		frame.getContentPane().add(bBack);
		bBack.addActionListener(new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 frame.dispose();
			 }
				 	 });
		
		
		frame.setBounds(480,250,420,267);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTER THE USER ID");
		lblNewLabel.setBounds(35, 63, 128, 30);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
		frame.setResizable(false);
	}

}
