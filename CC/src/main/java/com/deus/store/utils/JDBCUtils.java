package com.deus.store.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	private static DataSource ds;
	static {
		 ds = new ComboPooledDataSource("mysql");
	}
	/**
	 * 获取连接池
	 * 
	 * @return DataSource
	 * @throws SQLException
	 */ 
	
	public static DataSource getDataSource(){
		return ds;
	}
	
	
	/**
	 * 获取连接
	 * 
	 * @return Connection
	 * @throws SQLException
	 */ 
	
	public static Connection getConnection() throws SQLException{
		Connection conn = ds.getConnection();
		return conn;
	}
	/**
	 * 释放连接
	 * @throws SQLException
	 * 
	 */
	public static void releaseConnection(Connection conn) throws SQLException{
		if(conn != null) {
			conn.close();
		}
	}
	
}
