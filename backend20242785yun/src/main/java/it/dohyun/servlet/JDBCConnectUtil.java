package it.dohyun.servlet;

import java.sql.*;

public class JDBCConnectUtil {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb", "root", "dongyang");
	}
	public static void close(Connection con, PreparedStatement st) throws SQLException {
		st.close();
		con.close();
	}
	public static void close(Connection con, PreparedStatement st, ResultSet rs) throws SQLException {
		rs.close();
		st.close();
		con.close();
	}
}
