package it.dohyun.servlet;

import java.sql.SQLException;

public class MemberDao {
	public void test() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
	}
}
