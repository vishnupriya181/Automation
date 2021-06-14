package com.vishnu.view.hr;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.*;
import javax.swing.*;

import com.vishnu.config.*;
import com.vishnu.controller.AdminController;

public class Request{
	JFrame frame = new JFrame();
	AdminController admincontroller;
	int RID;
	
	
	public Request() throws ClassNotFoundException, SQLException {
		admincontroller= new  AdminController();
		Connection con=JDBCConnection.getDBConnection();
		Statement st=con.createStatement();
		JTable table=new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[]{"JobTitle","KeySkill","Experience","RequestedId","UserName","Mobile","Gender","Skill"}, 0);
		ResultSet rst=st.executeQuery("select * from appliedjob");
		while(rst.next())
		{
			 String a = rst.getString("JobTitle");
			 String b = rst.getString("KeySkill");
			 String c = rst.getString("Experience");
			 String d = rst.getString("RequestedId");
			 String e = rst.getString("UserName");
			 String f = rst.getString("Mobile");
			 String g = rst.getString("Gender");
			 String h = rst.getString("Skill");
		    model.addRow(new Object[] {a,b,c,d,e,f,g,h});
		    table.setModel(model);
		    table.setBounds(10,10,800,900);
		    JScrollPane sp=new JScrollPane(table);
		    
		    
		    JTextField tReqId = new JTextField("ENTER REQUEST ID");
			tReqId.setBounds(100, 500, 100, 30);
			frame.add(tReqId);
			tReqId.addFocusListener(new FocusListener() {

				@Override
				public void focusGained(FocusEvent e) {
					if(tReqId.getText().equals("ENTER REQUEST ID")) {
					tReqId.setText("");
					}
				}

				@Override
				public void focusLost(FocusEvent e) {
					if(tReqId.getText().equals("")) {
					tReqId.setText("ENTER REQUEST ID");
					}
				}

		    });
			
			JButton bSelected = new JButton("SELECTED");
			bSelected.setBounds(210,500, 100, 30);
			frame.add(bSelected);
			bSelected.addActionListener(new ActionListener(){
				 @Override
				 public void actionPerformed(ActionEvent e) {			 
					 try {
						 RID = Integer.parseInt(tReqId.getText());
						 admincontroller.selectReq(RID);
					} catch (Exception e1) {
						e1.printStackTrace();
					} 		 
					
				}
			 });
			
			JButton bRejected = new JButton("REJECTED");
			bRejected.setBounds(320,500, 100, 30);
			frame.add(bRejected);
			bRejected.addActionListener(new ActionListener(){
				 @Override
				 public void actionPerformed(ActionEvent e) {			 
					 try {
						 RID = Integer.parseInt(tReqId.getText());
						 admincontroller.rejectReq(RID);
					} catch (Exception e1) {
						e1.printStackTrace();
					} 		 }
			 });
			
			JButton bDelete = new JButton("DELETE");
			bDelete.setBounds(430,500, 100, 30);
			frame.add(bDelete);
			
			bDelete.addActionListener(new ActionListener(){
				 @Override
				 public void actionPerformed(ActionEvent e) {			 
					 try {
						 RID = Integer.parseInt(tReqId.getText());
						 admincontroller.deleteAppliedJob(RID);
					} catch (Exception e1) {
						e1.printStackTrace();
					} 		 }
			 });
			
			JButton bBack = new JButton("BACK");
			bBack.setBounds(540,500, 100, 30);
			frame.add(bBack);
			
			bBack.addActionListener(new ActionListener(){
				 @Override
				 public void actionPerformed(ActionEvent e) {			 
					 try {
						 new HrHome();
					} catch (Exception e1) {
						e1.printStackTrace();
					} 		 }
			 });
	

		
		frame.add(sp);
	    frame.add(table);
	    frame.setVisible(true);
	    frame.setBounds(250,60,1000,800);
	    frame.setTitle("VIEW ALL REQUESTS");
	}
		
}	
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		new Request();
	}
}


