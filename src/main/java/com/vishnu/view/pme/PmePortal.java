package com.vishnu.view.pme;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import com.vishnu.view.hr.AdminLogin;

public class PmePortal {

	JFrame f = new JFrame("PME PORTAL");
	JButton bAddSkill, bAddJob, bViewAllJobs,bViewJobId,bDeleteJob,bDeleteSkill,bUpdateJob, bLogout;
	
	public PmePortal() throws ClassNotFoundException, SQLException{
		
		JLabel lTitle = new JLabel("WELCOME TO PME PORTAL");
		lTitle.setBounds(100, 50, 300, 30);
		f.add(lTitle);
		
		bAddJob = new JButton("ADD JOB");
		bAddJob.setBounds(100,100,300,30);
		f.add(bAddJob);	
		bAddJob.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new AddJob();
					f.dispose();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			}
			
		});

		
	/*	bAddSkill = new JButton("ADD SKILL");
		bAddSkill .setBounds(100,200,300,30);
		f.add(bAddSkill);	
		bAddSkill.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new AddSkill();
					f.dispose();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			}
			
		});*/


		bDeleteJob = new JButton("DELETE JOB");
		bDeleteJob.setBounds(100,200,300,30);
		f.add(bDeleteJob);	
		bDeleteJob.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new DeleteJob();
					//f.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
/*		bDeleteSkill = new JButton("DELETE SKILL");
		bDeleteSkill.setBounds(100,300,300,30);
		f.add(bDeleteSkill);
		bDeleteSkill.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new DeleteSkill();
					f.dispose();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			}
			
		});

	*/	
		
		bUpdateJob = new JButton("UPDATE JOB");
		bUpdateJob.setBounds(100,150,300,30);
		f.add(bUpdateJob);
		bUpdateJob.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new UpdateJob();
					f.dispose();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			}
			
		});

		
		bViewAllJobs = new JButton("VIEW ALL JOBS");
		bViewAllJobs.setBounds(100,250,300,30);
		f.add(bViewAllJobs);	
		bViewAllJobs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new ViewAllJob();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			}
			
		});

		
		bViewJobId = new JButton("VIEW JOB");
		bViewJobId.setBounds(100,300,300,30);
		f.add(bViewJobId);	
		bViewJobId.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new ViewJobId();
					f.dispose();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			}
			
		});

		bLogout = new JButton("LOGOUT");
		bLogout.setBounds(100,350,300,30);
		f.add(bLogout);
		bLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new AdminLogin();
					f.dispose();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			}
			
		});

		
		f.setVisible(true);
		f.setLayout(null);
		f.setBounds(440,60,450,580);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);

	}
	
	public static void main(String args[])
	{
		try {
			new PmePortal();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
