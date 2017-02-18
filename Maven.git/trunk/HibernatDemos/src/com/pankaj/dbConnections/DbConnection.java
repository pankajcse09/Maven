package com.pankaj.dbConnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.pankaj.constants.ApplicationConstants;
import com.pankaj.util.PropertyUtils;

public class DbConnection {
	private static Connection conn = null;

	private static Connection getConnection(String database) throws ClassNotFoundException {
		try {
			if (ApplicationConstants.MY_SQL_DB.equalsIgnoreCase(database)) {
				Class.forName(PropertyUtils.getPropertyValue(ApplicationConstants.MY_SQL_DRIVER));
				conn = DriverManager.getConnection(PropertyUtils.getPropertyValue(ApplicationConstants.MY_SQL_URL));
			}else if(ApplicationConstants.DERBY_DB.equalsIgnoreCase(database)){
				Class.forName(PropertyUtils.getPropertyValue(ApplicationConstants.DERBY_DB_DRIVER));
				conn = DriverManager.getConnection(PropertyUtils.getPropertyValue(ApplicationConstants.DERBY_DB_URL),"user","pwd");
			}else if(ApplicationConstants.MONGO_DB.equalsIgnoreCase(database)){
				Class.forName(PropertyUtils.getPropertyValue(ApplicationConstants.MONGO_DB_DRIVER));
				conn = DriverManager.getConnection(PropertyUtils.getPropertyValue(ApplicationConstants.MONGO_DB_URL));
			}else if(ApplicationConstants.ORACLE_DB.equalsIgnoreCase(database)){
				Class.forName(PropertyUtils.getPropertyValue(ApplicationConstants.ORACLE_DB_DRIVER));
				conn = DriverManager.getConnection(PropertyUtils.getPropertyValue(ApplicationConstants.DERBY_DB_URL));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}
}
