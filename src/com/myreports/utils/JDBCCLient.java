package com.myreports.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class JDBCCLient {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			String sql = "select * from student";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/college", "ash", "password");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("Id     name     lastname     subject");
			System.out.println("=======================================");
			while(rs.next()) {
				System.out.println(rs.getString(1) +"      " + rs.getInt
						(2)+"    " + rs.getString(3)+"    " + rs.getString(4));
				System.out.println("--------------------------------------");
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
