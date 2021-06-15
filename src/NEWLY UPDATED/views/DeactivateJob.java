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

public class DeactivateJob {

	JFrame frame = new JFrame("DEACTIVATE JOB");
	JobController jobcontroller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeactivateJob window = new DeactivateJob();
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
	public DeactivateJob() throws ClassNotFoundException, SQLException {
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
		tJobId.setBounds(205, 48, 200, 30);
		frame.getContentPane().add(tJobId);
		
		JButton bDeactivate = new JButton("DEACTIVATE JOB");
		bDeactivate.setBounds(80,129, 136, 45);
		frame.getContentPane().add(bDeactivate);
		bDeactivate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int ID;
				ID=Integer.parseInt(tJobId.getText());
				jobcontroller.deactivateJob(ID);
				tJobId.setText("");
			}
			
		});

		JButton bBack = new JButton("BACK");
		bBack.setBounds(250,129, 143, 45);
		frame.getContentPane().add(bBack);
		bBack.addActionListener(new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 frame.dispose();
			 }
				 	 });

		
		frame.setBounds(480,250,476,244); 
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTER JOB ID");
		lblNewLabel.setBounds(54, 48, 117, 30);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
