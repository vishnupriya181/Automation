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


public class ActivateJob {

	JFrame frame = new JFrame("ACTIVATE JOB");
	JobController jobcontroller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActivateJob window = new ActivateJob();
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
	public ActivateJob() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
jobcontroller = new JobController();
		
		JTextField tJobId = new JTextField("");
		tJobId.setBounds(189, 61, 200, 30);
		frame.getContentPane().add(tJobId);

		
		JButton bActivate = new JButton("ACTIVATE JOB");
		bActivate.setBounds(70,130, 125, 30);
		frame.getContentPane().add(bActivate);
		bActivate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int ID;
				ID=Integer.parseInt(tJobId.getText());
				jobcontroller.activateJob(ID);
				tJobId.setText("");
			}
			
		});

		JButton bBack = new JButton("BACK");
		bBack.setBounds(236,130, 133, 30);
		frame.getContentPane().add(bBack);
		bBack.addActionListener(new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 frame.dispose();
			 }
				 	 });

		
	
		frame.setBounds(480,250,420,237);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTER JOB ID");
		lblNewLabel.setBounds(34, 61, 149, 30);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
		
	}
}
