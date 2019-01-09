package com.deus.store.testc3p0;

//import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.beanutils.BeanUtils;

import com.deus.store.domain.Character;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestC3P0 {
	private static Connection conn;
	private static ResultSet rs;
	private static PreparedStatement pstmt;
	public static void main(String[] args) throws SQLException{
		ComboPooledDataSource db = new ComboPooledDataSource("mysql");
//		try {
//			db.setDriverClass("com.mysql.cj.jdbc.Driver");
//			db.setUser("root");
//			db.setPassword("root");
//			db.setJdbcUrl("jdbc:mysql://localhost:3306/ccdatabase?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false");
//			
//		} catch (PropertyVetoException e1) {
//			e1.printStackTrace();
//		}
		
		try {
			conn = db.getConnection();
			String sql = "select * from ccdatabase.character";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			ArrayList<Character> al = new ArrayList<Character>();
			while(rs.next()) {
				Character c = new Character();
				for(int i =  0; i < count; i++) {
					String columnName = rsmd.getColumnName(i + 1);
					Object value = rs.getObject(columnName);
					BeanUtils.copyProperty(c, columnName, value);
					System.out.println("" + columnName + value); 
				}
				al.add(c);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	
		
	}
}
