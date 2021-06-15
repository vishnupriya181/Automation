package com.vishnu.daoimpl;

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
import com.vishnu.model.User;



public class UserImplementDao {
	Connection con;
	JFrame frame = new JFrame();
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
					user.setSkill(rs.getString(8));
				}
			} 	    		
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return user;
	}

		
			
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
				JOptionPane.showMessageDialog(frame, "Registration Failed");
			}
		}
			catch(SQLException ex) {
				System.out.println(ex.getMessage());
				
			}	
	}
			
					
			
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
					    table.setBounds(10,10,900,650);
					    frame.setVisible(true);
					    frame.setBounds(250,60,900,650);
					    frame.setTitle("VIEW USER");
					}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
			
			
		
			public void UpdateProfile(User user){
				try {
					PreparedStatement pst= con.prepareStatement("update user set FirstName = ?, LastName = ?, Password = ?, PhoneNumber =?, Gender= ? where UserId=?");
					pst.setString(1, user.getFirstName());
					pst.setString(2, user.getLastName());
					pst.setString(3, user.getPassword());
					pst.setString(4, user.getPhoneNumber());
					pst.setString(5, user.getGender());
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
			
			
		
			public User addUserSkill(User user){
				try {
					
					PreparedStatement pst=con.prepareStatement("update User set Skill=? where UserId =?");
					pst.setString(1, user.getSkill());
					pst.setString(2, user.getUserId());
					int i=pst.executeUpdate();
					JFrame g=new JFrame();
					if(i==1){
						JOptionPane.showMessageDialog(g, "Skill Added Successfully");
					}
					else {
						JOptionPane.showMessageDialog(g, "Error");
					}
				}
				catch(SQLException ex) {
					System.out.println(ex.getMessage());
				}
				return user;
			}
}
