package com.shma.jcip.chapter03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.shma.jcip.annotation.ThreadSafe;

@ThreadSafe
public class ConnectionDispenser {

	private static final String DB_URL = "jdbc:mysql://localhost/mydatabase";
	
	private ThreadLocal<Connection> connHolder = new ThreadLocal<Connection>() {

		@Override
		protected Connection initialValue() {
			try {
				return DriverManager.getConnection(DB_URL);
			} catch (SQLException e) {
				throw new RuntimeException("Unable to acquire Connection, e");
			}
		}
		
	};
	
	public Connection getConnection() {
		return connHolder.get();
	}
}
