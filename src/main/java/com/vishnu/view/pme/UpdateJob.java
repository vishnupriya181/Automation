package com.vishnu.view.pme;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import javax.swing.*;

import com.vishnu.controller.*;

public class UpdateJob{

	JFrame frame = new JFrame("UPDATE JOB");
	
	private JLabel lTitle= new  JLabel("UPDATE JOB");
	private JTextField tLocation, tJobId;
	private JTextField tSalary;
	private JTextField tExp;
	private JButton bSubmit, bBack;
	public static JobController jobcontroller= null;
	
	UpdateJob() throws ClassNotFoundException, SQLException{
		
		lTitle.setBounds(100,50,180,30);
		frame.add(lTitle);
		
		tJobId = new JTextField("ENTER JOB ID");
		tJobId.setBounds(100,100,180,30);
		frame.add(tJobId);
		tJobId.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(tJobId.getText().equals("ENTER JOB ID")) {
				tJobId.setText("");}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(tJobId.getText().equals("")) {
				tJobId.setText("ENTER JOB ID");}
			}

		});

		
		
		tLocation = new JTextField("UPDATE LOCATION");
		tLocation.setBounds(100,150,180,30);
		frame.add(tLocation);
		tLocation.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(tLocation.getText().equals("UPDATE LOCATION")) {
				tLocation.setText("");}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(tLocation.getText().equals("")) {
				tLocation.setText("UPDATE LOCATION");}
			}

		});


	
		tSalary = new JTextField("UPDATE SALARY");
		tSalary.setBounds(100,200,180,30);
		frame.add(tSalary);
		tSalary.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(tSalary.getText().equals("UPDATE SALARY")) {
				tSalary.setText("");}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(tSalary.getText().equals("")) {
				tSalary.setText("UPDATE SALARY");}
			}

		});

		
		
		tExp = new JTextField("UPDATE EXPERIENCE");
		tExp.setBounds(100,250,180,30);
		frame.add(tExp);
		tExp.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(tExp.getText().equals("UPDATE EXPERIENCE")) {
				tExp.setText("");}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(tExp.getText().equals("")) {
				tExp.setText("UPDATE EXPERIENCE");}
			}

		});

		bSubmit = new JButton("SUBMIT");
		bSubmit.setBounds(100,300,180,30);
		frame.add(bSubmit);
		jobcontroller=new JobController();
		bSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int JID;
				String LOC, SAL, EXP;
				JID = Integer.parseInt(tJobId.getText());
				LOC=tLocation.getText();
				SAL=tSalary.getText();
				EXP=tExp.getText();
			
				jobcontroller.updateJob(JID,LOC,SAL,EXP);
			}
		});
		
		bBack = new JButton("BACK");
		bBack.setBounds(100,350,180,30);
		frame.add(bBack);
		bBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					try {
						new PmePortal();
						frame.dispose();
					} catch (ClassNotFoundException | SQLException e1) {
				
						e1.printStackTrace();
					}

				}
		});

				
		frame.setBounds(480,80,400,600);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
			
}		
