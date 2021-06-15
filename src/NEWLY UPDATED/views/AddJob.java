package com.vishnu.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.vishnu.controller.JobController;

import javax.swing.JLabel;

public class AddJob {

	JFrame frame = new JFrame("ADD JOB");
	JobController jobcontroller;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddJob window = new AddJob();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddJob() throws ClassNotFoundException, SQLException {
		initialize();
	}

	private void initialize() throws ClassNotFoundException, SQLException {
		JTextField tJobTitle=new JTextField("");
		tJobTitle.setBounds(188, 34, 200, 30);
		frame.getContentPane().add(tJobTitle);
	
		JTextField tJobDescrip=new JTextField("");
		tJobDescrip.setBounds(188, 75, 200, 30);
		frame.getContentPane().add(tJobDescrip);
	
		JTextField tCompanyName=new JTextField("");
		tCompanyName.setBounds(188, 116, 200, 30);
		frame.getContentPane().add(tCompanyName);
				
		JTextField tLocation=new JTextField("");
		tLocation.setBounds(188, 157, 200, 30);
		frame.getContentPane().add(tLocation);
		
		JTextField tKeySkill=new JTextField("");
		tKeySkill.setBounds(188,198,200,30);
		frame.getContentPane().add(tKeySkill);

		JTextField tSalary=new JTextField("");
		tSalary.setBounds(188, 239, 200, 30);
		frame.getContentPane().add(tSalary);
		
		JTextField tExp=new JTextField("");
		tExp.setBounds(188, 280, 200, 30);
		frame.getContentPane().add(tExp);
		
		JButton bSubmit=new JButton("SUBMIT");
		bSubmit.setBounds(106, 350, 89, 30);
		frame.getContentPane().add(bSubmit);
		
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
				
				tJobTitle.setText(""); 
				tJobDescrip.setText("");
				tCompanyName.setText("");
				tLocation.setText("");
				tKeySkill.setText("");
				tSalary.setText("");
				tExp.setText(""); 
				
			}
		});
		
		JButton bBack= new JButton("BACK");
		bBack.setBounds(239, 350, 89, 30);
		frame.getContentPane().add(bBack);
		bBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					frame.dispose();
			}
		});
		
		frame.setBounds(480,80,420,463);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("JOB TITLE");
		lblNewLabel.setBounds(38, 34, 112, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblJobDescription = new JLabel("JOB DESCRIPTION");
		lblJobDescription.setBounds(38, 75, 112, 30);
		frame.getContentPane().add(lblJobDescription);
		
		JLabel lblCompanyName = new JLabel("COMPANY NAME");
		lblCompanyName.setBounds(38, 116, 112, 30);
		frame.getContentPane().add(lblCompanyName);
		
		JLabel lblLocation = new JLabel("LOCATION");
		lblLocation.setBounds(38, 157, 112, 30);
		frame.getContentPane().add(lblLocation);
		
		JLabel lblKeySkill = new JLabel("KEY SKILL");
		lblKeySkill.setBounds(38, 198, 112, 30);
		frame.getContentPane().add(lblKeySkill);
		
		JLabel lblSalary = new JLabel("SALARY");
		lblSalary.setBounds(38, 239, 112, 30);
		frame.getContentPane().add(lblSalary);
		
		JLabel lblExperience = new JLabel("EXPERIENCE");
		lblExperience.setBounds(38, 280, 112, 30);
		frame.getContentPane().add(lblExperience);
		frame.setVisible(true);
	
	}


}
