package com.vishnu.view.hr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

import com.vishnu.view.pme.ViewAllJob;
import com.vishnu.view.pme.ViewJobId;

public class HrHome {
		
	JFrame f = new JFrame("HR PORTAL");
	private JButton /*bActiveUsers,bDeactiveEmp,*/bActivateJob,bDeactivateJob,bViewAllEmp;
	JButton bViewJob,bViewEmpById,bAddSkill,bViewSkill,bActivateSkill,bDeactivateSkill,bDelete, bViewAllJob, bRequest, bLogout;
	JLabel lTitle;

 	HrHome() throws ClassNotFoundException, SQLException{
	
	lTitle = new JLabel("WELCOME TO HR PORTAL");
	lTitle.setBounds(100, 30, 200, 30);
	f.add(lTitle); 
	
	/*bActiveUsers = new JButton("ACTIVE EMPLOYEE");
	bActiveUsers.setBounds(100,70,200,30);
	f.add(bActiveUsers);   
	bActiveUsers.addActionListener(new ActionListener(){
		 @Override
		 public void actionPerformed(ActionEvent e) {			 
			 try {
				new ActivateEmployee();
			} catch (Exception e1) {
				e1.printStackTrace();
			} 		 }
	 });

	
	bDeactiveEmp = new JButton("DEACTIVATE EMPLOYEE");
	bDeactiveEmp.setBounds(100,110,200,30);
	f.add(bDeactiveEmp);
	bDeactiveEmp.addActionListener(new ActionListener(){
		 @Override
		 public void actionPerformed(ActionEvent e) {			 
			 try {
				new DeactivateEmployee();
			} catch (Exception e1) {
				e1.printStackTrace();
			} 		 }
	 });*/
	
	bActivateJob = new JButton("ACTIVATE JOB");
	bActivateJob.setBounds(100,230,200,30);
	f.add(bActivateJob);
	bActivateJob.addActionListener(new ActionListener(){
		 @Override
		 public void actionPerformed(ActionEvent e) {			 
			 try {
				new ActivateJob();
			} catch (Exception e1) {
				e1.printStackTrace();
			} 		 }
	 });
	
	bDeactivateJob = new JButton("DEACTIVATE JOB");
	bDeactivateJob.setBounds(100,270,200,30);
	f.add(bDeactivateJob);
	bDeactivateJob.addActionListener(new ActionListener(){
		 @Override
		 public void actionPerformed(ActionEvent e) {			 
			 try {
				new DeactivateJob();
			} catch (Exception e1) {
				e1.printStackTrace();
			} 		 }
	 });
	
	bViewAllEmp = new JButton("VIEW ALL USERS");
	bViewAllEmp.setBounds(100,110,200,30);
	f.add(bViewAllEmp);    
	bViewAllEmp.addActionListener(new ActionListener(){
		 @Override
		 public void actionPerformed(ActionEvent e) {			 
			 try {
				new ViewAllUsers();
			} catch (Exception e1) {
				e1.printStackTrace();
			} 		 }
	 });
	
	bViewEmpById = new JButton("VIEW USER");
	bViewEmpById.setBounds(100,70,200,30);
	f.add(bViewEmpById);
	bViewEmpById.addActionListener(new ActionListener(){
		 @Override
		 public void actionPerformed(ActionEvent e) {			 
			 try {
				new ViewUser();
			} catch (Exception e1) {
				e1.printStackTrace();
			} 		 }
	 });
	
	/*bViewSkill = new JButton("VIEW ALL SKILL");
	bViewSkill.setBounds(100,310,200,30);
	f.add(bViewSkill);
	bViewSkill.addActionListener(new ActionListener(){
		 @Override
		 public void actionPerformed(ActionEvent e) {			 
			 try {
				new ActivateEmployee();
			} catch (Exception e1) {
				e1.printStackTrace();
			} 		 }
	 });*/
	
	bViewJob = new JButton("VIEW JOB");
	bViewJob.setBounds(100,150,200,30);
	f.add(bViewJob);
	bViewJob.addActionListener(new ActionListener(){
		 @Override
		 public void actionPerformed(ActionEvent e) {			 
			 try {
				new ViewJobId();
			} catch (Exception e1) {
				e1.printStackTrace();
			} 		 }
	 });
	
	bViewAllJob = new JButton("VIEW ALL JOB");
	bViewAllJob.setBounds(100,190,200,30);
	f.add(bViewAllJob);
	bViewAllJob.addActionListener(new ActionListener(){
		 @Override
		 public void actionPerformed(ActionEvent e) {			 
			 try {
				new ViewAllJob();
			} catch (Exception e1) {
				e1.printStackTrace();
			} 		 }
	 });

	
/*	bActivateSkill = new JButton("ACTIVATE SKILL");
	bActivateSkill.setBounds(100,390,200,30);
	f.add(bActivateSkill);
	bActivateSkill.addActionListener(new ActionListener(){
		 @Override
		 public void actionPerformed(ActionEvent e) {			 
			 try {
				new ActivateEmployeeSkill();
			} catch (Exception e1) {
				e1.printStackTrace();
			} 		 }
	 });
	
	bDeactivateSkill = new JButton("DEACTIVATE SKILL");
	bDeactivateSkill.setBounds(100,430,200,30);
	f.add(bDeactivateSkill); 
	bDeactivateSkill.addActionListener(new ActionListener(){
		 @Override
		 public void actionPerformed(ActionEvent e) {			 
			 try {
				new ActivateEmployee();
			} catch (Exception e1) {
				e1.printStackTrace();
			} 		 }
	 });
	*/
	bDelete = new JButton("DELETE USER");
	bDelete.setBounds(100,310,200,30);
	bDelete.addActionListener(new ActionListener(){
		 @Override
		 public void actionPerformed(ActionEvent e) {			 
			 try {
				new DeleteUser();
			} catch (Exception e1) {
				e1.printStackTrace();
			} 		 }
	 });	
	f.add(bDelete);
	
	bRequest = new JButton("VIEW ALL REQUEST");
	bRequest.setBounds(100,350,200,30);
	bRequest.addActionListener(new ActionListener(){
		 @Override
		 public void actionPerformed(ActionEvent e) {			 
			 try {
				new Request();
			} catch (Exception e1) {
				e1.printStackTrace();
			} 		 }
	 });	
	f.add(bRequest);

	
	bLogout = new JButton("LOGOUT");
	bLogout.setBounds(100,390,200,30);
	bLogout.addActionListener(new ActionListener(){
		 @Override
		 public void actionPerformed(ActionEvent e) {
			 JOptionPane.showMessageDialog(f,"YOUR SUCCESSFULLY LOGGED OUT");
			 f.dispose();
		 }
	 });
	f.add(bLogout);
	
	
	f.setBounds(440,60,450,580);
	f.setLayout(null);
	f.setVisible(true);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setResizable(false);
	}
		
}
	

