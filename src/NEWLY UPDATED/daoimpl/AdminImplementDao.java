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
import com.vishnu.model.Admin;



public class AdminImplementDao {

	Connection con;	
	Admin admin = new Admin();
	public AdminImplementDao() throws ClassNotFoundException, SQLException{	
	con =JDBCConnection.getDBConnection();}

		public Admin checkAdminLogin(Admin admin) {
		try {
			
			PreparedStatement pst=con.prepareStatement("select * from admin where  UserId=?");
			pst.setString(1, admin.getUserId());
			ResultSet rs =pst.executeQuery();
			if(rs!=null) {
				if(rs.next()) {
					
					admin.setUserId(rs.getString(1));
					admin.setFirstName(rs.getString(2));
					admin.setLastName(rs.getString(3));
					admin.setPassword(rs.getString(4));
					admin.setRole(rs.getString(5));
					admin.setGender(rs.getString(6));
					admin.setEmployeeId(rs.getInt(8));
				}
			} 	    		
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return admin;
	}
		
		public Admin deleteUser(Admin admin) {
			try {
				PreparedStatement pst=con.prepareStatement("delete from User where Id=?");
				pst.setString(1, admin.getUserId());
				int i =pst.executeUpdate();
				JFrame f = new JFrame();
					if(i==1) {
						JOptionPane.showMessageDialog(f,"User Deleted");
					}
					else {
						JOptionPane.showMessageDialog(f,"No User Found");
					}
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return admin;
	}

		

		public Admin viewUser(Admin admin) {
			try {
				JFrame frame =new JFrame();
				PreparedStatement pst=con.prepareStatement("select * from user where  UserId=?");
				pst.setString(1, admin.getUserId());
				ResultSet rst=pst.executeQuery();
				JTable table=new JTable();
				DefaultTableModel model = new DefaultTableModel(new String[]{"UserID","FirstName", "LastName", "PhoneNumber","Gender", "Skill"}, 0);
				while(rst.next())
				{
				    String a = rst.getString("UserId");
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
			return admin;			}

		
		public void deleteAppliedJob(Admin admin) {
			try {
				PreparedStatement pst=con.prepareStatement("delete from appliedjob where RequestedId=?");
				pst.setInt(1, admin.getId());
				int i =pst.executeUpdate();
				JFrame f = new JFrame();
					if(i==1) {
						JOptionPane.showMessageDialog(f,"Request Deleted");
					}
					else {
						JOptionPane.showMessageDialog(f,"No Requested Id Found");
					}
		}catch(Exception e) {
			e.printStackTrace();
		}
			
	}

	
		public void rejectReq(Admin admin) {
				try {
					
					PreparedStatement pst=con.prepareStatement("update appliedjob set Status='Rejected' where RequestedId=? ");
					pst.setInt(1, admin.getId());
					int i= pst.executeUpdate();
					JFrame frame=new JFrame();
					if(i==1){
						JOptionPane.showMessageDialog(frame,"User Rejected");
					}
					else {
						JOptionPane.showMessageDialog(frame,"No Id Found");
					}
				}
				catch(SQLException ex) {
					System.out.println(ex.getMessage());
				}
				
			}

	

	
		public void selectReq(Admin admin) {
			try {
				PreparedStatement pst=con.prepareStatement("update appliedjob set Status='Selected' where RequestedId=? ");
				pst.setInt(1, admin.getId());
				int i= pst.executeUpdate();
				JFrame frame=new JFrame();
				if(i==1){
					JOptionPane.showMessageDialog(frame,"User Selected");
				}
				else {
					JOptionPane.showMessageDialog(frame,"No Id Found");
				}
			}
			catch(SQLException ex) {
				System.out.println(ex.getMessage());
			}

		}				

}
