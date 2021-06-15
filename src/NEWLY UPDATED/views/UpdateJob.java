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
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.vishnu.controller.JobController;

import java.awt.Font;




public class UpdateJob {

	JFrame frame = new JFrame("UPDATE JOB");
	
	private JLabel lTitle= new  JLabel("UPDATE POSTED JOB DETAILS");
	private JTextField tLocation, tJobId;
	private JTextField tSalary;
	private JTextField tExp;
	private JButton bSubmit, bBack;
	public static JobController jobcontroller= null;
	private JLabel lblNewLabel;
	private JLabel lblUpdateLocation;
	private JLabel lblUpdateSalary;
	private JLabel lblUpdateExperience;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateJob window = new UpdateJob();
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
	public UpdateJob() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		lTitle.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lTitle.setHorizontalAlignment(SwingConstants.CENTER);

		lTitle.setBounds(0,0,404,47);
		lTitle.setForeground(Color.BLACK);
		frame.getContentPane().add(lTitle);
		
		tJobId = new JTextField("");
		tJobId.setBounds(189,91,180,30);
		frame.getContentPane().add(tJobId);
		
		
		tLocation = new JTextField("");
		tLocation.setBounds(189,147,180,30);
		frame.getContentPane().add(tLocation);
	
		tSalary = new JTextField("");
		tSalary.setBounds(189,206,180,30);
		frame.getContentPane().add(tSalary);
		
		tExp = new JTextField("");
		tExp.setBounds(189,259,180,30);
		frame.getContentPane().add(tExp);
		
		bSubmit = new JButton("SUBMIT");
		bSubmit.setBounds(99,329,79,37);
		frame.getContentPane().add(bSubmit);
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
				
				tJobId.setText("");
				tLocation.setText("");
				tSalary.setText("");
				tExp.setText("");
			}
		});
		
		bBack = new JButton("BACK");
		bBack.setBounds(240,329,79,37);
		frame.getContentPane().add(bBack);
		bBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
		});

				
		frame.setBounds(480,80,420,455);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("ENTER JOB ID");
		lblNewLabel.setBounds(53, 91, 125, 30);
		frame.getContentPane().add(lblNewLabel);
		
		lblUpdateLocation = new JLabel("UPDATE LOCATION");
		lblUpdateLocation.setBounds(53, 147, 125, 30);
		frame.getContentPane().add(lblUpdateLocation);
		
		lblUpdateSalary = new JLabel("UPDATE SALARY");
		lblUpdateSalary.setBounds(53, 206, 125, 30);
		frame.getContentPane().add(lblUpdateSalary);
		
		lblUpdateExperience = new JLabel("UPDATE EXPERIENCE");
		lblUpdateExperience.setBounds(54, 259, 125, 30);
		frame.getContentPane().add(lblUpdateExperience);
		frame.setVisible(true);
		}

}
