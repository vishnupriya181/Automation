package com.vishnu.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class HrHome {

	JFrame frame = new JFrame("HRA PORTAL");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HrHome window = new HrHome();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HrHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		JLabel lTitle = new JLabel("WELCOME TO HR PORTAL");
		lTitle.setBackground(Color.LIGHT_GRAY);
		lTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lTitle.setBounds(0, 0, 414, 46);
		frame.getContentPane().add(lTitle); 
		
		
		JButton bActivateJob = new JButton("ACTIVATE JOB");
		bActivateJob.setBounds(100,250,200,30);
		frame.getContentPane().add(bActivateJob);
		bActivateJob.addActionListener(new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent e) {			 
				 try {				 
					new ActivateJob();
				} catch (Exception e1) {
					e1.printStackTrace();
				} 		 }
		 });
		
		JButton bDeactivateJob = new JButton("DEACTIVATE JOB");
		bDeactivateJob.setBounds(100,295,200,30);
		frame.getContentPane().add(bDeactivateJob);
		bDeactivateJob.addActionListener(new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent e) {			 
				 try {
					new DeactivateJob();
				} catch (Exception e1) {
					e1.printStackTrace();
				} 		 }
		 });
		
		JButton bViewAllUsers = new JButton("VIEW ALL USERS");
		bViewAllUsers.setBounds(100,115,200,30);
		frame.getContentPane().add(bViewAllUsers);    
		bViewAllUsers.addActionListener(new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent e) {			 
				 try {
					new ViewAllUsers();
				} catch (Exception e1) {
					e1.printStackTrace();
				} 		 }
		 });
		
		JButton bViewUser = new JButton("VIEW USER");
		bViewUser.setBounds(100,70,200,30);
		frame.getContentPane().add(bViewUser);
		bViewUser.addActionListener(new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent e) {			 
				 try {
					new ViewUser();
				} catch (Exception e1) {
					e1.printStackTrace();
				} 		 }
		 });
		
		
		JButton bViewJob = new JButton("VIEW JOB");
		bViewJob.setBounds(100,160,200,30);
		frame.getContentPane().add(bViewJob);
		bViewJob.addActionListener(new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent e) {			 
				 try {
					new ViewJobId();
				} catch (Exception e1) {
					e1.printStackTrace();
				} 		 }
		 });
		
		JButton bViewAllJob = new JButton("VIEW ALL JOB");
		bViewAllJob.setBounds(100,205,200,30);
		frame.getContentPane().add(bViewAllJob);
		bViewAllJob.addActionListener(new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent e) {			 
				 try {
					new ViewAllJob();
				} catch (Exception e1) {
					e1.printStackTrace();
				} 		 }
		 });

		
		JButton bDelete = new JButton("DELETE USER");
		bDelete.setBounds(100,340,200,30);
		frame.getContentPane().add(bDelete);
		bDelete.addActionListener(new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent e) {			 
				 try {
					new DeleteUser();
				} catch (Exception e1) {
					e1.printStackTrace();
				} 		 }
		 });	
		
		
		JButton bRequest = new JButton("VIEW ALL REQUEST");
		bRequest.setBounds(100,385,200,30);
		frame.getContentPane().add(bRequest);
		bRequest.addActionListener(new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent e) {			 
				 try {
					new Request();
				} catch (Exception e1) {
					e1.printStackTrace();
				} 		 }
		 });	
		

		
		JButton bLogout = new JButton("LOGOUT");
		bLogout.setBounds(100,430,200,30);
		frame.getContentPane().add(bLogout);
		bLogout.addActionListener(new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 try {
					new AdminLogin();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
			 }
		 });
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(480,80,420,600);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		}

}
