package com.vishnu.views;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import com.vishnu.config.JDBCConnection;

import java.sql.*;
import javax.swing.*;

public class ViewAllJob{
	JFrame frame = new JFrame();
	
	public ViewAllJob() throws ClassNotFoundException, SQLException {
		Connection con=JDBCConnection.getDBConnection();
		Statement st=con.createStatement();
		JTable table=new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[]{"JobTitle", "JobDescription"," CompanyName", "Location", "KeySkill", "Experience", "Salary"}, 0);
		ResultSet rst=st.executeQuery("select * from Job where Active='Yes'");
		while(rst.next())
		{
		    String a = rst.getString("JobTitle");
		    String b = rst.getString("JobDescription");
		    String c = rst.getString("CompanyName");
		    String d = rst.getString("Location");
		    String e = rst.getString("KeySkill");
		    String f = rst.getString("Experience");
		    String g = rst.getString("Salary");
		    model.addRow(new Object[] {a,b,c,d,e,f,g});
		    table.setModel(model);
		    JScrollPane sp=new JScrollPane(table);
		    frame.add(sp);
		    frame.add(table);
		    table.setBounds(10,10,900,650);
		    frame.setVisible(true);
		    frame.setBounds(250,60,900,650);
		    frame.setTitle("ALL JOBS");
		}
	}

}
