package com.shma.common.dbcp;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.log4j.Logger;

public class DBManager {

	private static final Logger logger = Logger.getLogger(DBManager.class);
	
	private static final String configFileName = "jdbc.properties";
	
	private static DataSource dataSource;
	
	static {
		 Properties dbProperties = new Properties();
		  try {
		   dbProperties.load(DBManager.class.getClassLoader()
		     .getResourceAsStream(configFileName));
		   dataSource = BasicDataSourceFactory.createDataSource(dbProperties);
		   Connection conn = getConnection();
		   DatabaseMetaData mdm = conn.getMetaData();
		   logger.info("Connected to " + mdm.getDatabaseProductName() + " "
		     + mdm.getDatabaseProductVersion());
		   if (conn != null) {
		    conn.close();
		   }
		  } catch (Exception e) {
			  logger.error("初始化连接池失败：" + e);
		  }
	}
	
	private DBManager() {
	}
	
	public static final Connection getConnection() {
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
		} catch(SQLException e) {
			logger.error("获取数据库连接失败：" + e.getMessage());
		}
		
		return conn;
	}
	
	public static void closeConnection(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.setAutoCommit(true);
				conn.close();
			}
		} catch (SQLException e) {
			logger.error("关闭数据库连接失败：" + e);
		}
	}
}
