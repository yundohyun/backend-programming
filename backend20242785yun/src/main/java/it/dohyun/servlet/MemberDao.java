package it.dohyun.servlet;

import java.sql.*;

public class MemberDao {
	public boolean login(MemberDto member) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = JDBCConnectUtil.getConnection();
			st = con.prepareStatement("select * from membertbl where memberid=? and password=?;");
			st.setString(1, member.getMemberid());
			st.setString(2, member.getPassword());
			rs = st.executeQuery();
			result = rs.next();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCConnectUtil.close(con, st, rs);
		}
		return result;
	}
}
