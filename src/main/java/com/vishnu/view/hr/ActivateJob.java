package com.vishnu.view.hr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import javax.swing.*;

import com.vishnu.controller.JobController;

public class ActivateJob {
	JFrame frame = new JFrame("ACTIVATE EMPLOYEE JOB");
	JobController jobcontroller;
	
	ActivateJob() throws ClassNotFoundException, SQLException{
		jobcontroller = new JobController();
		
		JTextField tJobId = new JTextField("ENTER JOB ID");
		tJobId.setBounds(100, 30, 200, 30);
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

		
		JButton bDeactivate = new JButton("ACTIVATE JOB");
		bDeactivate.setBounds(100,70, 200, 30);
		frame.add(bDeactivate);
		bDeactivate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int ID;
				ID=Integer.parseInt(tJobId.getText());
				jobcontroller.activateJob(ID);
				
			}
			
		});

		JButton bCancel = new JButton("CANCEL");
		bCancel.setBounds(100,110, 200, 30);
		frame.add(bCancel);
		bCancel.addActionListener(new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 frame.dispose();
			 }
				 	 });

		
		frame.setBounds(440,200,450,200);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
	}
}


