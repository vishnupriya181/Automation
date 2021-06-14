package com.vishnu.view.user;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import com.vishnu.model.User;

public class ViewProfile {
		
		JFrame frame = new JFrame("VIEW PROFILE");
		
		ViewProfile(User user) throws ClassNotFoundException, SQLException {
			
			
			
			JLabel lEmployeeId1=new JLabel("USER ID");
			lEmployeeId1.setBounds(30, 100, 100, 30);
			JLabel lEmployeeId2=new JLabel(user.getUserId());
			lEmployeeId2.setBounds(160, 100, 200, 30);
			frame.add(lEmployeeId1);
			frame.add(lEmployeeId2);
			
			JLabel lFirstName1=new JLabel("FIRST NAME");
			lFirstName1.setBounds(30, 150, 100, 30);
			JLabel lFirstName2=new JLabel(user.getFirstName());
			lFirstName2.setBounds(160, 150, 200, 30);
			frame.add(lFirstName1);
			frame.add(lFirstName2);
			
			JLabel lLastName1=new JLabel("LAST NAME");
			lLastName1.setBounds(30, 200, 100, 30);
			JLabel lLastName2=new JLabel(user.getLastName());
			lLastName2.setBounds(160, 200, 200, 30);
			frame.add(lLastName1);
			frame.add(lLastName2);
			
			JLabel lGender1=new JLabel("GENDER");
			lGender1.setBounds(30, 250, 100, 30);
			JLabel lGender2=new JLabel(user.getGender());
			lGender2.setBounds(160, 250, 200, 30);
			frame.add(lGender1);
			frame.add(lGender2);
			
			JLabel lRole1=new JLabel("PHONE NUMBER");
			lRole1.setBounds(30, 300, 100, 30);
			JLabel lRole2=new JLabel(user.getPhoneNumber());
			lRole2.setBounds(160,300,200,30);
			frame.add(lRole1);
			frame.add(lRole2);
			
			JLabel lActive1=new JLabel("SKILL");
			lActive1.setBounds(30, 350, 100, 30);
			JLabel lActive2=new JLabel(user.getSkill());
			lActive2.setBounds(160, 350, 200, 30);
			frame.add(lActive1);
			frame.add(lActive2);
			
			JButton bBack=new JButton("BACK");
			bBack.setBounds(160, 450, 100, 30);
			frame.add(bBack);
			bBack.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						new UserPortal(user);
						frame.dispose();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
			});
			
			
			frame.setBounds(480,80,400,600);
			frame.setLayout(null);
			frame.setVisible(true);
			frame.setResizable(false);
		}
}


