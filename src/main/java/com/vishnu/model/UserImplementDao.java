package com.vishnu.model;

import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.vishnu.config.JDBCConnection;


public class UserImplementDao implements UserDao{
	
Connection con;	
User user = new User();
public UserImplementDao() throws ClassNotFoundException, SQLException{	
con =JDBCConnection.getDBConnection();}

	public User checkUserLogin(User user) {
	try {
		
		PreparedStatement pst=con.prepareStatement("select * from user where  UserId=?");
		pst.setString(1, user.getUserId());
		ResultSet rs =pst.executeQuery();
		if(rs!=null) {
			if(rs.next()) {
				
				user.setId(rs.getInt(1));
				user.setFirstName(rs.getString(2));
				user.setLastName(rs.getString(3));
				user.setUserId(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setPhoneNumber(rs.getString(6));
				user.setGender(rs.getString(7));
				user.setStatus(rs.getString(8));
				user.setSkill(rs.getString(9));
			}
		}else {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame,"Wrong Username or Register");} 	    		
	}
	catch(SQLException ex) {
		System.out.println(ex.getMessage());
	}
	return user;
}
	
	

	/*public void checkStaffLogin(emp emp) {
		try {
			PreparedStatement pst=con.prepareStatement("select * from employee where  empId=? and Password=?");
			pst.setString(1, emp.getempId());
			pst.setString(2, emp.getPassword());
			ResultSet rs=pst.executeQuery();
			if(rs!=null) {
				if(rs.next()) {
					emp.setempId(rs.getInt(8));
					emp.setFirstName(rs.getString(2));
					emp.setLastName(rs.getString(3));
					emp.setempId(rs.getString(1));
					emp.setPassword(rs.getString(4));
					emp.setRole(rs.getString(5));
					emp.setGender(rs.getString(6));
					emp.setActive(rs.getString(7));
					
				}
				else {
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame,"Wrong Passord or Register");
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
*/
		@Override
		public void addUser(User user){
			try {
		PreparedStatement pst= con.prepareStatement("insert into user(UserId, FirstName, LastName, Password, PhoneNumber, Gender) values (?,?,?,?,?,?)");
		pst.setString(1, user.getUserId());
		pst.setString(2, user.getFirstName());
		pst.setString(3, user.getLastName());
		pst.setString(4, user.getPassword());
		pst.setString(5, user.getPhoneNumber());
		pst.setString(6, user.getGender());
		int i=pst.executeUpdate();
		con.close();
		JFrame frame =new JFrame();
		if(i==1){
			JOptionPane.showMessageDialog(frame, "Registration Successful");
		}
		else {
			JOptionPane.showConfirmDialog(frame, "Registration Failed");
		}
	}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
			
		}	
}
		
		
		
		
	/*	public void activateemployee(emp emp) {
			try {
				PreparedStatement pst=con.prepareStatement("select employeeId from employee where  employeeId=?");
				pst.setInt(1, emp.getempId());
				ResultSet rs=pst.executeQuery();
				JFrame f = new JFrame();
				if(rs!=null) {
					PreparedStatement ps=con.prepareStatement("update employee set Active = 'yes' where employeeId=?");
					ps.setInt(1, emp.getempId());
					int i =ps.executeUpdate();
					if(i==1) {
						
						JOptionPane.showMessageDialog(f,"emp Activated");
					}
				}else {
					JOptionPane.showMessageDialog(f,"No employee Exists");
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
		
		public void deactivateemployee(emp emp) {
			try {
				PreparedStatement pst=con.prepareStatement("select employeeId from employee where  employeeId=?");
				pst.setInt(1, emp.getempId());
				ResultSet rs=pst.executeQuery();
				JFrame f = new JFrame();
				if(rs!=null) {
					PreparedStatement ps=con.prepareStatement("update employee set Active = 'No' where employeeId=?");
					ps.setInt(1, emp.getempId());
					int i =ps.executeUpdate();
					if(i==1) {
						JOptionPane.showMessageDialog(f,"emp Deactivated");
					}
				}else {
					JOptionPane.showMessageDialog(f,"No employee Exists");
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}*/
		
		
		public void viewUser(User user) {
			try {
				JFrame frame =new JFrame();
				PreparedStatement pst=con.prepareStatement("select * from user where  Id=?");
				pst.setInt(1, user.getId());
				ResultSet rst=pst.executeQuery();
				JTable table=new JTable();
				DefaultTableModel model = new DefaultTableModel(new String[]{"ID","FirstName", "LastName", "PhoneNumber","Gender", "Skill"}, 0);
				while(rst.next())
				{
				    String a = rst.getString("Id");
				    String b = rst.getString("FirstName");
				    String c = rst.getString("LastName");
				    String d = rst.getString("PhoneNumber");
				    String e = rst.getString("Gender");
				    String f = rst.getString("Skill");
				    model.addRow(new Object[] {a,b,c,d,e,f});
				    table.setModel(model);
				    JScrollPane sp=new JScrollPane(table);
				    frame.add(sp);
				    frame.add(table);
				    table.setBounds(10,10,800,900);
				    frame.setVisible(true);
				    frame.setBounds(250,60,780,580);
				    frame.setTitle("VIEW USER");
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
		
		@Override
		public void UpdateProfile(User user){
			try {
				PreparedStatement pst= con.prepareStatement("update user set FirstName = ?, LastName = ?, Password = ?, PhoneNumber =?, Gender= ? where UserId=?");
				pst.setString(1, user.getFirstName());
				pst.setString(2, user.getLastName());
				pst.setString(3, user.getPassword());
				pst.setString(4, user.getPhoneNumber());
				pst.setString(5, user.getGender());
				//pst.setString(6, user.getSkill());
				pst.setString(6, user.getUserId());
				int i=pst.executeUpdate();
				con.close();
				JFrame frame =new JFrame();
				if(i==1){
					JOptionPane.showMessageDialog(frame, "Updated Successfully");
				}
				
			}
				catch(SQLException ex) {
					System.out.println(ex.getMessage());
					
				}
				
		}
		
/*
		public void deleteemployee(emp emp) {
			try {
				PreparedStatement pst=con.prepareStatement("delete from employee where employeeId=?");
				pst.setInt(1, emp.getempId());
				int i =pst.executeUpdate();
				JFrame f = new JFrame();
					if(i==1) {
						JOptionPane.showMessageDialog(f,"Emlpoyee Deleted");
					}
					else {
						JOptionPane.showMessageDialog(f,"No employee Exits");
					}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		*/
		
		@Override
		public User addUserSkill(User user){
			try {
				
				PreparedStatement pst=con.prepareStatement("update User set Skill=? where UserId =?");
				pst.setString(1, user.getSkill());
				pst.setString(2, user.getUserId());
				int i=pst.executeUpdate();
				JFrame g=new JFrame();
				if(i==1){
					JOptionPane.showMessageDialog(g, "You have successfully added a Skill..");
				}
				else {
					JOptionPane.showMessageDialog(g, "Oh no.. Insertion Failed..");
				}
			}
			catch(SQLException ex) {
				System.out.println(ex.getMessage());
			}
			return user;
		}

		
		
}


