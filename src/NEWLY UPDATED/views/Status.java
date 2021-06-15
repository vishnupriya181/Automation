package com.vishnu.views;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.vishnu.config.JDBCConnection;
import com.vishnu.model.User;


public class Status{
		
		JFrame frame = new JFrame("Status");
		
		public Status(User user) throws ClassNotFoundException, SQLException {
			Connection con=JDBCConnection.getDBConnection();
	
			JTable table=new JTable();
			DefaultTableModel model = new DefaultTableModel(new String[]{"JobId", "JobTitle", "JobDescription", "CompanyName", 
					"Location", "KeySkill", "Salary", "Experience", "Status"}, 0);
			PreparedStatement ps = con.prepareStatement("select * from appliedjob where UserId=?");
			ps.setInt(1, user.getId());
			ResultSet rst= ps.executeQuery();
			while(rst.next())
			{
				int a = rst.getInt("JobId");
			    String b = rst.getString("JobTitle");
			    String c = rst.getString("JobDescription");
			    String d = rst.getString("CompanyName");
			    String e = rst.getString("Location");
			    String f = rst.getString("KeySkill");
			    String g = rst.getString("Salary");
			    String h = rst.getString("Experience");
			    String i = rst.getString("Status");
			    model.addRow(new Object[] {a,b,c,d,e,f,g,h,i});
			    table.setModel(model);
			    JScrollPane sp=new JScrollPane(table);
			    frame.add(sp);
			    frame.add(table);
			    table.setBounds(10,10,900,650);
			    frame.setVisible(true);
			    frame.setBounds(250,60,900,650);
			    frame.setTitle("Status");
			}
		}

}

