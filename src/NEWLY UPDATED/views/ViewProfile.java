package com.vishnu.views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.vishnu.model.User;

import java.awt.Font;

public class ViewProfile {

	JFrame frame = new JFrame("VIEW PROFILE");
	private JTextField txtDetailsOfThe;
	ViewProfile(User user) throws ClassNotFoundException, SQLException {

		JLabel lUserId1=new JLabel("USER ID");
		lUserId1.setBounds(60, 100, 100, 30);
		JLabel lUserId2=new JLabel(user.getUserId());
		lUserId2.setBounds(190, 100, 200, 30);
		frame.getContentPane().add(lUserId1);
		frame.getContentPane().add(lUserId2);
		lUserId1.setForeground(Color.BLACK);
		lUserId2.setForeground(Color.BLACK);
		
		JLabel lFirstName1=new JLabel("FIRST NAME");
		lFirstName1.setBounds(60, 150, 100, 30);
		JLabel lFirstName2=new JLabel(user.getFirstName());
		lFirstName2.setBounds(190, 150, 200, 30);
		frame.getContentPane().add(lFirstName1);
		frame.getContentPane().add(lFirstName2);
		lFirstName1.setForeground(Color.BLACK);
		lFirstName2.setForeground(Color.BLACK);
		
		JLabel lLastName1=new JLabel("LAST NAME");
		lLastName1.setBounds(60, 200, 100, 30);
		JLabel lLastName2=new JLabel(user.getLastName());
		lLastName2.setBounds(190, 200, 200, 30);
		frame.getContentPane().add(lLastName1);
		frame.getContentPane().add(lLastName2);
		lLastName1.setForeground(Color.BLACK);
		lLastName2.setForeground(Color.BLACK);
		
		JLabel lGender1=new JLabel("GENDER");
		lGender1.setBounds(60, 250, 100, 30);
		JLabel lGender2=new JLabel(user.getGender());
		lGender2.setBounds(190, 250, 200, 30);
		frame.getContentPane().add(lGender1);
		frame.getContentPane().add(lGender2);
		lGender1.setForeground(Color.BLACK);
		lGender2.setForeground(Color.BLACK);
		
		JLabel lPhone1=new JLabel("PHONE NUMBER");
		lPhone1.setBounds(60, 300, 100, 30);
		JLabel lPhone2=new JLabel(user.getPhoneNumber());
		lPhone2.setBounds(190,300,200,30);
		frame.getContentPane().add(lPhone1);
		frame.getContentPane().add(lPhone2);
		lPhone1.setForeground(Color.BLACK);
		lPhone2.setForeground(Color.BLACK);
		
		JLabel lSkill1=new JLabel("SKILL");
		lSkill1.setBounds(60, 350, 100, 30);
		JLabel lSkill2=new JLabel(user.getSkill());
		lSkill2.setBounds(190, 350, 200, 30);
		frame.getContentPane().add(lSkill1);
		frame.getContentPane().add(lSkill2);
		lSkill1.setForeground(Color.BLACK);
		lSkill2.setForeground(Color.BLACK);
		
		JButton bBack=new JButton("BACK");
		bBack.setBounds(148, 402, 100, 30);
		frame.getContentPane().add(bBack);
		bBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					frame.dispose();
			}
			
		});
		
		
		frame.setBounds(480,80,420,503);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		
		txtDetailsOfThe = new JTextField();
		txtDetailsOfThe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDetailsOfThe.setText("DETAILS OF THE USER");
		txtDetailsOfThe.setHorizontalAlignment(SwingConstants.CENTER);
		txtDetailsOfThe.setBounds(0, 0, 414, 39);
		frame.getContentPane().add(txtDetailsOfThe);
		txtDetailsOfThe.setColumns(10);
		frame.setVisible(true);
		
	}

}
