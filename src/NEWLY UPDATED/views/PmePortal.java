package com.vishnu.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import java.awt.Font;

public class PmePortal {

	JFrame frame = new JFrame("PME PORTAL");
	JButton bAddJob, bViewAllJobs, bViewJob, bDeleteJob, bUpdateJob, bLogout;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PmePortal window = new PmePortal();
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
	public PmePortal() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws ClassNotFoundException, SQLException{
		
		JLabel lTitle = new JLabel("WELCOME TO PME PORTAL");
		lTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lTitle.setForeground(Color.BLACK);
		lTitle.setBounds(0, 0, 414, 41);
		frame.getContentPane().add(lTitle);
		
		bAddJob = new JButton("ADD JOB");
		bAddJob.setBounds(100,65,200,30);
		frame.getContentPane().add(bAddJob);	
		bAddJob.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new AddJob();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}			}
			
		});



		bDeleteJob = new JButton("DELETE JOB");
		bDeleteJob.setBounds(100,185,200,30);
		frame.getContentPane().add(bDeleteJob);	
		bDeleteJob.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new DeleteJob();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
		
		bUpdateJob = new JButton("UPDATE JOB");
		bUpdateJob.setBounds(100,125,200,30);
		frame.getContentPane().add(bUpdateJob);
		bUpdateJob.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new UpdateJob();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}			}
			
		});

		
		bViewAllJobs = new JButton("VIEW ALL JOBS");
		bViewAllJobs.setBounds(100,291,200,30);
		frame.getContentPane().add(bViewAllJobs);	
		bViewAllJobs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new ViewAllJob();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}			}
			
		});

		
		bViewJob = new JButton("VIEW JOB");
		bViewJob.setBounds(100,236,200,30);
		frame.getContentPane().add(bViewJob);	
		bViewJob.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new ViewJobId();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}			}
			
		});

		bLogout = new JButton("LOGOUT");
		bLogout.setBounds(100,342,200,30);
		frame.getContentPane().add(bLogout);
		bLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				try {
					new AdminLogin();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			}
			
		});

		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(480,80,420,480);
		frame.setVisible(true);
		frame.setResizable(false);

	}
	
	}
