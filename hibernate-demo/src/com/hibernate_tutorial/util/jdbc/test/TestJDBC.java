package com.hibernate_tutorial.util.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		System.out.println("Attempting JDBC Connection to: "+jdbcUrl);
		
		try(Connection conn = DriverManager.getConnection(jdbcUrl, user, pass)) {
			if (conn!=null)
				System.out.println("DB Connection successful!");
			else
				System.out.println("DB Connection failed!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
