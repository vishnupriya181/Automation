package com.vishnu.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.vishnu.config.JDBCConnection;

public class ImplementJobDao implements JobDao {
		
		Connection con;
		
		public ImplementJobDao() throws ClassNotFoundException, SQLException{
				con=JDBCConnection.getDBConnection();
		}
		
		@Override
		public void addJob(Job job){
			try {
				
				PreparedStatement pst=con.prepareStatement("insert into Job(JobTitle, JobDescription, CompanyName, Location, KeySkill, Experience,  Salary, Active) values(?,?,?,?,?,?,?,?)");
				pst.setString(1, job.getJobTitle());
				pst.setString(2, job.getJobDescription());
				pst.setString(3, job.getCompanyName());
				pst.setString(4, job.getLocation());
				pst.setString(5, job.getKeySkill());
				pst.setString(6, job.getSalary());
				pst.setString(7, job.getExperience());
				pst.setString(8, job.getActive());
				int i=pst.executeUpdate();
				
				JFrame frame=new JFrame();
				if(i==1){
					JOptionPane.showMessageDialog(frame,"Successfully added a Job");
				}
				else {
					JOptionPane.showMessageDialog(frame,"Unable to add a Job");
				}
			}
			catch(SQLException ex) {
				System.out.println(ex.getMessage());
			}
			
		}
		
		
		
		@Override
		public void updateJob(Job job) {
			try {
				
				PreparedStatement pst=con.prepareStatement("update Job set Location=?, Salary = ? ,Experience = ? where JobId=? ");
				pst.setString(1, job.getLocation());
				pst.setString(2, job.getSalary());
				pst.setString(3, job.getExperience());
				pst.setInt(4, job.getJobId());
				int i=pst.executeUpdate();
				JFrame frame=new JFrame();
				if(i==1){
					JOptionPane.showMessageDialog(frame,"Updated Successfully");
				}
				else {
					JOptionPane.showMessageDialog(frame,"Updation error");
				}
			}
			catch(SQLException ex) {
				System.out.println(ex.getMessage());
			}
			
		}
		
		public void ViewJobId(Job job) {
			try {
				JFrame frame =new JFrame();
				PreparedStatement pst=con.prepareStatement("select * from Job where  JobId=?");
				pst.setInt(1, job.getJobId());
				ResultSet rst=pst.executeQuery();
				JTable table=new JTable();
				DefaultTableModel model = new DefaultTableModel(new String[]{"JobId" ,"JobTitle", "JobDescription"," CompanyName", "Location", "KeySkill", "Experience", "Salary", "Active"}, 0);
				while(rst.next())
				{
				    int a = rst.getInt("JobId");
				    String b = rst.getString("JobTitle");
				    String c = rst.getString("JobDescription");
				    String d = rst.getString("CompanyName");
				    String e = rst.getString("Location");
				    String f = rst.getString("KeySkill");
				    String g = rst.getString("Experience");
				    String h = rst.getString("Salary");
				    String i = rst.getString("Active");
				    model.addRow(new Object[] {a,b,c,d,e,f,g,h,i});
				    table.setModel(model);
				    JScrollPane sp=new JScrollPane(table);
				    frame.add(sp);
				    frame.add(table);
				    table.setBounds(10,10,800,900);
				    frame.setVisible(true);
				    frame.setBounds(250,60,780,580);
				    frame.setTitle("VIEW JOB BY ID");
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

		
		
		@Override
		public void activateJob(Job job) {
			try {
				
				PreparedStatement pst=con.prepareStatement("update Job set Active='Yes' where JobId=? ");
				pst.setInt(1, job.getJobId());
				int i=pst.executeUpdate();
				JFrame frame=new JFrame();
				if(i==1){
					JOptionPane.showMessageDialog(frame, "Job activated Succesfully");
					
				}
				else {
					JOptionPane.showMessageDialog(frame, "Job activation failed");

				}
			}
			catch(SQLException ex) {
				System.out.println(ex.getMessage());
			}
			
		}

		
		
		@Override
		public void deactivateJob(Job job) {
			try {
				PreparedStatement pst=con.prepareStatement("update Job set Active='No' where JobId=? ");
				pst.setInt(1, job.getJobId());
				int i=pst.executeUpdate();
				JFrame frame=new JFrame();
				if(i==1){
					JOptionPane.showConfirmDialog(frame, "Job Deactivated successfully");
					
				}
				else {
					JOptionPane.showConfirmDialog(frame, "Deactivation failed");
				}
			}
			catch(SQLException ex) {
				System.out.println(ex.getMessage());
			}
			
		}

	@Override
	public void deleteJob(Job job) {
		try {
			PreparedStatement pst=con.prepareStatement("delete from Job where JobId=?");
			pst.setInt(1, job.getJobId());
			int i=pst.executeUpdate();
			JFrame g=new JFrame();
			if(i==1){
				JOptionPane.showMessageDialog(g, "You have successfully deleted a Job");
			}
			else {
				JOptionPane.showMessageDialog(g, "Deletion Failed");
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}

	@Override
	public void addAppliedJob(Job job, User user) {
		try {
			
			PreparedStatement pst=con.prepareStatement("insert into appliedjob(JobTitle, JobDescription, CompanyName, KeySkill, Location, "
			+ "Salary ,Experience, UserID, UserName, Mobile, Gender, Skill, JobId) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pst.setString(1, job.getJobTitle());
			pst.setString(2,job.getJobDescription());
			pst.setString(3, job.getCompanyName());
			pst.setString(4, job.getKeySkill());
			pst.setString(5, job.getLocation());
			pst.setString(6, job.getSalary());
			pst.setString(7, job.getExperience());
			pst.setInt(8, user.getId());
			pst.setString(9, user.getName());
			pst.setString(10, user.getPhoneNumber());
			pst.setString(11, user.getGender());
			pst.setString(12, user.getSkill());
			pst.setInt(13, job.getJobId());
			int i=pst.executeUpdate();
			con.close();
			JFrame frame=new JFrame();
			if(i==1){
				JOptionPane.showMessageDialog(frame,"SuccessFully Applied a Job");
			}
			else {
				JOptionPane.showMessageDialog(frame,"Unable to Apply For a Job");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	
}

