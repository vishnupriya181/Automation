package com.vishnu.config;

import java.sql.*;

public class JDBCConnection {
	
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException{
		String url="jdbc:h2:tcp://localhost/~/test";
		String username="sa";
		String password="";
		
		Class.forName("org.h2.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		return con;
	}
}