package com.vishnu.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.vishnu.controller.JobController;

import javax.swing.JLabel;


public class ViewJobId {

	JFrame frame = new JFrame("VIEW JOB");
	JobController jobcontroller;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewJobId window = new ViewJobId();
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
	public ViewJobId() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		JTextField tJobId = new JTextField("");
		tJobId.setBounds(185, 36, 186, 30);
		frame.getContentPane().add(tJobId);
		
		
		JButton bViewJob = new JButton("VIEW JOB");
		bViewJob.setBounds(66, 119, 125, 42);
		frame.getContentPane().add(bViewJob);
		jobcontroller = new JobController();
		bViewJob.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int JId;
				JId = Integer.parseInt(tJobId.getText());
				jobcontroller.ViewJobId(JId);
				tJobId.setText("");
			}
		});
		
		JButton bBack = new JButton("BACK");
		bBack.setBounds(227,119, 125, 42);
		frame.getContentPane().add(bBack);
		bBack.addActionListener(new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 frame.dispose();
			 }
				 	 });
		
		
		frame.setBounds(480,250,420,248);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTER JOB ID");
		lblNewLabel.setBounds(52, 36, 111, 30);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
		
	}

}
