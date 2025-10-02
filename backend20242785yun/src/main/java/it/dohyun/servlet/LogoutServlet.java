package it.dohyun.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout.do")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private void doLogout(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	ServletContext ctx = req.getServletContext();
		ctx.removeAttribute("user");
		res.sendRedirect("loginForm.jsp");
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doGet Method Called in /logout.do!");
		this.doLogout(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doPost Method Called in /logout.do!");
		this.doLogout(req, res);
	}
}
