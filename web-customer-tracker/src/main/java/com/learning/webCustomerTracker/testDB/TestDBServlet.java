package com.learning.webCustomerTracker.testDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Setup connection variables:
		String username = "sphbstudent";
		String password = "sphbstudent";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		//Get Connection to DB:
		Connection conn= null;
		
		try {
			PrintWriter out= response.getWriter();
			
			out.println("Connecting to DB: "+jdbcUrl);
			
			Class.forName(driver);
			
			conn = DriverManager.getConnection(jdbcUrl, username, password);
			
			if (conn!=null) {
				out.println("Connection obtained!!!");
				
				conn.close();
			} else
				out.println("Connection couldn't be obtained");
			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ServletException(ex);
		} finally {
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
}