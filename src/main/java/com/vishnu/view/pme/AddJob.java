package com.vishnu.view.pme;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;

import javax.swing.*;

import com.vishnu.controller.JobController;

public class AddJob {
		
		JFrame frame = new JFrame("ADD JOB");
		JobController jobcontroller;
		
		AddJob() throws ClassNotFoundException, SQLException {
						
			
			JTextField tJobTitle=new JTextField("JOB TITLE");
			tJobTitle.setBounds(100, 30, 200, 30);
			frame.add(tJobTitle);
			tJobTitle.addFocusListener(new FocusListener() {

				@Override
				public void focusGained(FocusEvent e) {
					if(tJobTitle.getText().equals("JOB TITLE")) {
					tJobTitle.setText("");}
				}

				@Override
				public void focusLost(FocusEvent e) {
					if(tJobTitle.getText().equals("")) {
					tJobTitle.setText("JOB TITLE");}
				}

			});

			
			JTextField tJobDescrip=new JTextField("JOB DESCRIPTION");
			tJobDescrip.setBounds(100, 70, 200, 30);
			frame.add(tJobDescrip);
			tJobDescrip.addFocusListener(new FocusListener() {

				@Override
				public void focusGained(FocusEvent e) {
					if(tJobDescrip.getText().equals("JOB DESCRIPTION")) {
					tJobDescrip.setText("");}
				}

				@Override
				public void focusLost(FocusEvent e) {
					if(tJobDescrip.getText().equals("")) {
					tJobDescrip.setText("JOB DESCRIPTION");}
				}

			});

			
			
			JTextField tCompanyName=new JTextField("COMPANY NAME");
			tCompanyName.setBounds(100, 110, 200, 30);
			frame.add(tCompanyName);
			tCompanyName.addFocusListener(new FocusListener() {

				@Override
				public void focusGained(FocusEvent e) {
					if(tCompanyName.getText().equals("COMPANY NAME")) {
					tCompanyName.setText("");}
				}

				@Override
				public void focusLost(FocusEvent e) {
					if(tCompanyName.getText().equals("")) {
					tCompanyName.setText("COMPANY NAME");}
				}

			});

			
			
			JTextField tLocation=new JTextField("LOCATION");
			tLocation.setBounds(100, 150, 200, 30);
			frame.add(tLocation);
			tLocation.addFocusListener(new FocusListener() {

				@Override
				public void focusGained(FocusEvent e) {
					if(tLocation.getText().equals("LOCATION")) {
					tLocation.setText("");}
				}

				@Override
				public void focusLost(FocusEvent e) {
					if(tLocation.getText().equals("")) {
					tLocation.setText("LOCATION");}
				}

			});

			
			
			JTextField tKeySkill=new JTextField("KEY SKILL");
			tKeySkill.setBounds(100,190,200,30);
			frame.add(tKeySkill);
			tKeySkill.addFocusListener(new FocusListener() {

				@Override
				public void focusGained(FocusEvent e) {
					if(tKeySkill.getText().equals("KEY SKILL")) {
					tKeySkill.setText("");}
				}

				@Override
				public void focusLost(FocusEvent e) {
					if(tKeySkill.getText().equals("")) {
					tKeySkill.setText("KEY SKILL");}
				}

			});

			
			JTextField tSalary=new JTextField("SALARY");
			tSalary.setBounds(100, 230, 200, 30);
			frame.add(tSalary);
			tSalary.addFocusListener(new FocusListener() {

				@Override
				public void focusGained(FocusEvent e) {
					if(tSalary.getText().equals("SALARY")) {
					tSalary.setText("");}
				}

				@Override
				public void focusLost(FocusEvent e) {
					if(tSalary.getText().equals("")) {
					tSalary.setText("SALARY");}
				}

			});

			JTextField tExp=new JTextField("EXPERIENCE");
			tExp.setBounds(100, 270, 200, 30);
			frame.add(tExp);
			tExp.addFocusListener(new FocusListener() {

				@Override
				public void focusGained(FocusEvent e) {
					if(tExp.getText().equals("EXPERIENCE")) {
					tExp.setText("");}
				}

				@Override
				public void focusLost(FocusEvent e) {
					if(tExp.getText().equals("")) {
					tExp.setText("EXPERIENCE");}
				}

			});

			
			JButton bSubmit=new JButton("SUBMIT");
			bSubmit.setBounds(100, 310, 200, 30);
			frame.add(bSubmit);
			jobcontroller=new JobController();
			bSubmit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String JT, JD, CN, LOC, KS, SAL,EXP; 
					JT=tJobTitle.getText();
					JD=tJobDescrip.getText();
					CN=tCompanyName.getText();
					LOC=tLocation.getText();
					KS=tKeySkill.getText();
					SAL=tSalary.getText();
					EXP=tExp.getText();
					
					jobcontroller.addJob(JT, JD, CN, LOC, KS, SAL, EXP);		
				}
			});
			
			JButton bBack= new JButton("BACK");
			bBack.setBounds(100, 350, 200, 30);
			frame.add(bBack);
			bBack.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						new PmePortal();
						frame.dispose();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			

			
			
			frame.setBounds(440,60,450,580);
			frame.setLayout(null);
			frame.setVisible(true);
			frame.setResizable(false);
		}
}
