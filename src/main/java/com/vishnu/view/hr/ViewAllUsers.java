package com.vishnu.view.hr;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import com.vishnu.config.*;

import java.sql.*;
import javax.swing.*;

public class ViewAllUsers{
	JFrame frame = new JFrame();
	
	public ViewAllUsers() throws ClassNotFoundException, SQLException {
		Connection con=JDBCConnection.getDBConnection();
		Statement st=con.createStatement();
		JTable table=new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[]{"Id", "FirstName", " LastName","Phonenumber","Gender", "Skill"}, 0);
		ResultSet rst=st.executeQuery("select * from user");
		while(rst.next())
		{
		    int a = rst.getInt("Id");
		    String b = rst.getString("FirstName");
		    String c = rst.getString("LastName");
		    String d = rst.getString("Phonenumber");
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
		    frame.setTitle("VIEW ALL USERS");
		}
	}

}
