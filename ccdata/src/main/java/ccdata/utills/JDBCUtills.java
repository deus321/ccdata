package ccdata.utills;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtills {
	public static final String USERNAME = "root";
	public static final String PASSWORD = "root";
	public static final String URL = "jdbc:mysql://localhost:3306/ccdatabase?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
	public static Connection conn = null;
	static {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (ClassNotFoundException e) {
			System.out.println("class not find");
		}catch(SQLException e) {
			System.out.println("connection not linked");
		}
	}
	public static Connection getConnection() {
		return conn;
	}
	public static Statement getStatement() {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}
	public static PreparedStatement getPreparedStatement(String sql) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}
}
