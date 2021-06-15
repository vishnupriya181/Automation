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

public class DeleteJob {

	JFrame frame = new JFrame("DELETE JOB");
	JobController jobcontroller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteJob window = new DeleteJob();
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
	public DeleteJob() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		JTextField tJobId = new JTextField("");
		tJobId.setBounds(159, 30, 145, 30);
		frame.getContentPane().add(tJobId);
		
		JButton bDelete = new JButton("DELETE");
		bDelete.setBounds(205,97, 99, 43);
		frame.getContentPane().add(bDelete);
		jobcontroller = new JobController();
		bDelete.addActionListener(new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent e) {			 
				 try {
					 int JID;
					 JID = Integer.parseInt(tJobId.getText());
					 jobcontroller.deleteJob(JID);
					 tJobId.setText("");
				} catch (Exception e1) {
					e1.printStackTrace();
				} 		 }
		 });
		
		JButton bBack = new JButton("BACK");
		bBack.setBounds(68,97, 99, 43);
		frame.getContentPane().add(bBack);
		bBack.addActionListener(new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 frame.dispose();
			 }
				 	 });
		
		
		frame.setBounds(480,250,368,200);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTER JOB ID");
		lblNewLabel.setBounds(44, 30, 113, 30);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
		frame.setResizable(false);
	}

}
