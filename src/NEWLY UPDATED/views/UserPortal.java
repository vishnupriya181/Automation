package com.vishnu.views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.vishnu.model.User;

import java.awt.Font;

public class UserPortal {

	JFrame frame;
	User user;

	public UserPortal(User user) throws ClassNotFoundException, SQLException{
		
		frame = new JFrame("USER PORTAL");
		frame.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame.setBounds(480,80,420,430);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		
		JLabel lTitle = new JLabel("WELCOME HUMAN");
		lTitle.setBackground(Color.WHITE);
		lTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lTitle.setForeground(Color.BLACK);
		lTitle.setBounds(0, 0, 414, 46);
		frame.getContentPane().add(lTitle);

		JButton bViewProfile = new JButton("VIEW PROFILE");
		bViewProfile.setBounds(100, 65, 200, 30);
		frame.getContentPane().add(bViewProfile);
		bViewProfile.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new ViewProfile(user);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton bUpdateProfile = new JButton("UPDATE PROFILE");
		bUpdateProfile.setBounds(100, 120, 200, 30);
		frame.getContentPane().add(bUpdateProfile);
		bUpdateProfile.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new UpdateProfile(user);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		JButton bAddSkill = new JButton("ADD/UPDATE SKILL");
		bAddSkill.setBounds(100, 173, 200, 30);
		frame.getContentPane().add(bAddSkill);
		bAddSkill.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new AddUserSkill(user);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
				
		JButton bApplyJob = new JButton("APPLY JOB");
		bApplyJob.setBounds(100, 226, 200, 30);
		frame.getContentPane().add(bApplyJob);
		bApplyJob.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new ApplyJob(user);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton bStatus = new JButton("APPLIED STATUS");
		bStatus.setBounds(100, 282, 200, 30);
		frame.getContentPane().add(bStatus);
		bStatus.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new Status(user);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton bLogout = new JButton("LOGOUT");
		bLogout.setBounds(100, 339, 200, 30);
		frame.getContentPane().add(bLogout);
		bLogout.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				try {
					new UserLogin();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	
	}

}
