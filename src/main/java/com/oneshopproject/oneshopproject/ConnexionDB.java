package com.oneshopproject.oneshopproject;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionDB {
	static Connection conn = null;
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/oneshop?serverTimezone=UTC","root","123");
		System.out.println("Connected to database");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}

