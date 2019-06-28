package com.bridgelabz;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mailOrMobile=request.getParameter("mailorphone");
		String password=request.getParameter("password");
		System.out.println(mailOrMobile);
		System.out.println(password);
		PersonDaoWithJdbc personDaoWithJdbc=new PersonDaoWithJdbc();
		Person person=personDaoWithJdbc.doLogin(mailOrMobile, password);
		HttpSession session=request.getSession();
		if(person!=null)
		{
			session.setAttribute("person", person);
			response.sendRedirect("LoginWelcome.jsp");
		}
		else
			response.sendRedirect("login-html.html");

	}

}
