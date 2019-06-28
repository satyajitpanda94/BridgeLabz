package com.bridgelabz;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String mail=request.getParameter("mail");
		String phone=request.getParameter("mobile");
		String password=request.getParameter("password");
		String conpassword=request.getParameter("conpassword");
		System.out.println("step 1");
		Person person=new Person();
		if(password.equals(conpassword) && !password.isEmpty()&& !mail.isEmpty()&&!name.isEmpty()&&!phone.isEmpty())
		{
			PersonDaoWithJdbc personDaoWithJdbc=new PersonDaoWithJdbc();
			person=personDaoWithJdbc.doSignup(name,mail,phone,password);
			if(person==null)
    			response.sendRedirect("signup-html.html");
			else
			    response.sendRedirect("Welcom.jsp");
		}else {
			response.sendRedirect("signup-html.html");
		}
		
		System.out.println("step 2");
		
	}

}
