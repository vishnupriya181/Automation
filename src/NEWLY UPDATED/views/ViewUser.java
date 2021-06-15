package com.vishnu.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.vishnu.controller.UserController;

import javax.swing.JLabel;



public class ViewUser {

	JFrame frame = new JFrame("VIEW USER");
	UserController usercontroller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewUser window = new ViewUser();
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
	public ViewUser() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException  {
			
			JTextField tUserId = new JTextField("");
			tUserId.setBounds(175, 52, 200, 30);
			frame.getContentPane().add(tUserId);

			JButton bViewUser = new JButton("VIEW USER");
			bViewUser.setBounds(74, 138, 128, 43);
			frame.getContentPane().add(bViewUser);
			usercontroller = new UserController();
			bViewUser.addActionListener(new ActionListener(){
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int EID;
					EID =Integer.parseInt(tUserId.getText());
					usercontroller.viewUser(EID);
					tUserId.setText("");
				}
			});
			
			JButton bBack = new JButton("BACK");
			bBack.setBounds(230,138, 128, 43);
			frame.getContentPane().add(bBack);
			bBack.addActionListener(new ActionListener(){
				 @Override
				 public void actionPerformed(ActionEvent e) {
					 frame.dispose();
				 }
					 	 });
			
			
			frame.setBounds(480,250,420,265);
			frame.getContentPane().setBackground(Color.LIGHT_GRAY);
			frame.getContentPane().setLayout(null);
			
			JLabel lblNewLabel = new JLabel("ENTER USER ID");
			lblNewLabel.setBounds(63, 52, 139, 30);
			frame.getContentPane().add(lblNewLabel);
			frame.setVisible(true);
			
			
		}

}
