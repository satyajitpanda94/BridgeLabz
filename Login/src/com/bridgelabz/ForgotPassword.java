package com.bridgelabz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String emailTo = request.getParameter("mail");
			System.out.println(emailTo);
			final String fromEmail = "pandabridgelanbz@gmail.com";
			final String password = "123$panda";
			String subject = "Reset your password.";
			
			System.out.println("step1");
			
			 Properties props = new Properties();    
	          props.put("mail.smtp.host", "smtp.gmail.com");    
	          props.put("mail.smtp.socketFactory.port", "465");    
	          props.put("mail.smtp.socketFactory.class",    
	                    "javax.net.ssl.SSLSocketFactory");    
	          props.put("mail.smtp.auth", "true");    
	          props.put("mail.smtp.port", "465");    
			
			System.out.println("step2");

			  Session session = Session.getDefaultInstance(props,    
			           new javax.mail.Authenticator() {    
			           protected PasswordAuthentication getPasswordAuthentication() {    
			           return new PasswordAuthentication(fromEmail,password);  
			           }    
			          });   
			
			System.out.println("step3");
			
			 MimeMessage message = new MimeMessage(session);    
	           message.addRecipient(Message.RecipientType.TO,new InternetAddress(emailTo));    
	           message.setSubject(subject);    
	           message.setText("http://localhost:8082/Login/ChangePassword.html");    
			
			System.out.println("step4");

			Transport.send(message);
			
			System.out.println("step5");

			PrintWriter out=response.getWriter();
			out.print("mail send successfully.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
//		String emailTo = request.getParameter("mail");
//		PrintWriter out=response.getWriter();
//		out.print("mail send successfully."+emailTo);
	}
}