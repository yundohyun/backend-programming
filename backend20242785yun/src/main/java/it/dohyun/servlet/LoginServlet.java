package it.dohyun.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("Init Method Called!");
	}
	
	private void doLogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		System.out.println("ID: " + id + ", PW: " + password);
		
		MemberDto memberDto = new MemberDto();
		memberDto.setMemberid(id);
		memberDto.setPassword(password);
		
		MemberDao memberDao = new MemberDao();
		
		try {
			boolean accountExist = memberDao.login(memberDto);

			ServletContext ctx = req.getServletContext();
			if (accountExist) ctx.setAttribute("user", id);
			else ctx.setAttribute("message", "유저 정보를 찾을 수 없습니다.");
			
			res.sendRedirect("index.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		
//		boolean accountExist = id.equals("admin") && password.equals("admin");
//		
//		// JSP Redirect
//		res.sendRedirect(accountExist ? "loginOk.jsp" : "loginFail.jsp");
//
//		if (accountExist) {
//			HttpSession session = req.getSession();
//			session.setAttribute("id", id);
//		}
//		
//		// JSP Rendering
//		RequestDispatcher rd = req.getRequestDispatcher(accountExist ? "loginOk.jsp" : "loginFail.jsp");
//		rd.forward(req, res);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doGet Method Called in /login.do!");
		this.doLogin(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doPost Method Called in /login.do!");
		this.doLogin(req, res);
	}
}
