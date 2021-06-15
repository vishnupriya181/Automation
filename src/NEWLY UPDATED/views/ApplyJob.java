package com.vishnu.views;

import javax.swing.table.DefaultTableModel;

import com.vishnu.config.JDBCConnection;
import com.vishnu.controller.JobController;
import com.vishnu.model.User;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.*;
import javax.swing.*;


public class ApplyJob{
	JFrame frame = new JFrame();
	JobController jobcontroller;
	
	public ApplyJob(User user) throws ClassNotFoundException, SQLException {
		Connection con=JDBCConnection.getDBConnection();
		Statement st=con.createStatement();
		jobcontroller = new JobController();
		
		
		JTable table=new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[]{"JobId", "JobTitle", "JobDescription", "CompanyName","Location", "KeySkill","Salary", "Experience"}, 0);
		ResultSet rst=st.executeQuery("select * from Job where Active ='Yes'");
		while(rst.next())
 		{
		    int a = rst.getInt("JobId");
		    String b = rst.getString("JobTitle");
		    String c = rst.getString("JobDescription");
		    String d = rst.getString("CompanyName");
		    String e = rst.getString("Location");
		    String f= rst.getString("KeySkill");
		    String g = rst.getString("Salary");
		    String h = rst.getString("Experience");
		    model.addRow(new Object[] {a,b,c,d,e,f,g,h});
		    table.setModel(model);
		    JScrollPane sp=new JScrollPane(table);
		    
		    
		    JTextField tJobId = new JTextField("ENTER JOB ID");
		    tJobId.setBounds(130,500, 200, 30);
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

			
			JButton bActive = new JButton("APPLY");
			bActive.setBounds(350,500, 200, 30);
			frame.add(bActive);
			bActive.addActionListener(new ActionListener(){
				 @Override
				 public void actionPerformed(ActionEvent e) {			 
					 try {
						 int ID, JID; 
						 JID = Integer.parseInt(tJobId.getText());
						 PreparedStatement ps = con.prepareStatement("select * from job where JobId=?");
						 ps.setInt(1,JID);
						 ResultSet rs= ps.executeQuery();
						 
						 if(rs.next()) {
							 String JT, JD, CN, KS, LOC, SAL, EXP;
							 JT = rs.getString("JobTitle");
							 JD= rs.getString("JobDescription");
							 CN = rs.getString("CompanyName");
							 KS = rs.getString("KeySkill");
							 LOC = rs.getString("Location");
							 SAL = rs.getString("Salary");
							 EXP = rs.getString("Experience");
						 String N, PN, G, SK;
						 ID = user.getId();
						 N = user.getFirstName()+" "+user.getLastName();
						 PN = user.getPhoneNumber();
						 G = user.getGender();
						 SK = user.getSkill();
						 jobcontroller.addAppliedJob(JID,JT,JD,CN,KS,LOC,SAL,EXP,ID,N,PN,G,SK);
						 }
					} catch (Exception e1) {
						e1.printStackTrace();
					} 		 
				} 
			}); 
			
			JButton bBack = new JButton("BACK");
			bBack.setBounds(570,500, 200, 30);
			frame.add(bBack);
			bBack.addActionListener(new ActionListener(){
				 @Override
				 public void actionPerformed(ActionEvent e) {
					 frame.dispose();
				 }
					 	 });
			

		    
		    
		    frame.add(sp);
		    frame.add(table);
		    table.setBounds(10,10,900,650);
		    frame.setBounds(250,60,900,650);
			frame.setBackground(Color.LIGHT_GRAY);
		    frame.setVisible(true);
		    frame.setTitle("All JOBS");
		}
	}

}
