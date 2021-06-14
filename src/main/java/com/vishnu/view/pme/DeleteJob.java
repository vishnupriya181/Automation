package com.vishnu.view.pme;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import javax.swing.*;

import com.vishnu.controller.JobController;

public class DeleteJob {
	JFrame frame = new JFrame("Delete Job");
	JobController jobcontroller;
	
	DeleteJob() throws ClassNotFoundException, SQLException{
		JTextField tJobId = new JTextField("ENTER JOB ID");
		tJobId.setBounds(100, 30, 200, 30);
		frame.add(tJobId);
		tJobId.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(tJobId.getText().equals("ENTER JOB ID")) {
				tJobId.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(tJobId.getText().equals("")) {
				tJobId.setText("ENTER JOB ID");
				}
			}

	    });

		
		JButton bDelete = new JButton("DELETE");
		bDelete.setBounds(100,70, 200, 30);
		frame.add(bDelete);
		jobcontroller = new JobController();
		bDelete.addActionListener(new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent e) {			 
				 try {
					 int JID;
					 JID = Integer.parseInt(tJobId.getText());
					 jobcontroller.deleteJob(JID);
				} catch (Exception e1) {
					e1.printStackTrace();
				} 		 }
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
