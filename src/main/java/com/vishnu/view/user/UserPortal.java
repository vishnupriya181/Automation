package com.vishnu.view.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

import com.vishnu.model.User;


public class UserPortal {

	JFrame frame;
	User user;
	
	public UserPortal(User user) throws ClassNotFoundException, SQLException {
		
		frame = new JFrame("EMPLOYEE HOME PAGE");
		frame.setBounds(480,80,400,600);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setResizable(false);
		
		
		JLabel lTitle = new JLabel("EMPLOYEE HOME PAGE");
		lTitle.setBounds(100, 50, 300, 30);
		frame.add(lTitle);

		JButton bViewProfile = new JButton("VIEW PROFILE");
		bViewProfile.setBounds(100, 100, 150, 30);
		frame.add(bViewProfile);
		bViewProfile.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new ViewProfile(user);
					frame.dispose();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton bUpdateProfile = new JButton("UPDATE PROFILE");
		bUpdateProfile.setBounds(100, 150, 150, 30);
		frame.add(bUpdateProfile);
		bUpdateProfile.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new UpdateProfile(user);
					frame.dispose();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		JButton bAddSkill = new JButton("ADD/UPDATE SKILL");
		bAddSkill.setBounds(100, 200, 150, 30);
		frame.add(bAddSkill);
		bAddSkill.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new AddUserSkill(user);
					frame.dispose();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
				
		JButton bApplyJob = new JButton("APPLY JOB");
		bApplyJob.setBounds(100, 250, 150, 30);
		frame.add(bApplyJob);
		bApplyJob.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new ApplyJob(user);
					frame.dispose();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton bStatus = new JButton("STATUS");
		bStatus.setBounds(100, 300, 150, 30);
		frame.add(bStatus);
		bStatus.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new Status(user);
					frame.dispose();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton bLogout = new JButton("LOGOUT");
		bLogout.setBounds(100, 400, 150, 30);
		frame.add(bLogout);
		bLogout.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new UserLogin();
					frame.dispose();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
	
	}
	
	
}
