package it.dohyun.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

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
		
		boolean accountExist = id.equals("admin") && password.equals("admin");
		
//		// JSP Redirect
//		res.sendRedirect(accountExist ? "loginOk.jsp" : "loginFail.jsp");
		
		// JSP Rendering
		RequestDispatcher rd = req.getRequestDispatcher(accountExist ? "loginOk.jsp" : "loginFail.jsp");
		rd.forward(req, res);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doGet Method Called!");
		this.doLogin(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doPost Method Called!");
		this.doLogin(req, res);
	}
}
