package com.kimyunjae.util.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try { 
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.40:1521:xe","J01","J01");
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","pproject","1234");
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","example","1234");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","personalProject","1234");
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","pproject","1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
