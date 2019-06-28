package com.bridgelabz;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail=request.getParameter("mail");
		String password=request.getParameter("password");
		String conpassword=request.getParameter("conpassword");
		PersonDaoWithJdbc personDaoWithJdbc=new PersonDaoWithJdbc();
		if(conpassword.equals(password))
	    {
			personDaoWithJdbc.doChangePassword(mail,password);
			response.sendRedirect("PasswordChanged.jsp");

	    }
		else
			response.sendRedirect("ChangePassword.html");

	}

}
