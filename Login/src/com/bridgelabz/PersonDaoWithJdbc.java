package com.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDaoWithJdbc {

	private String url = "jdbc:mysql://localhost:3306?user=root&password=123456789";

	public Person doLogin(String mailOrPhone, String password) {
		String query = "select * from Resistration.resistration where (mail=? or mobile=?) and password=?";
		Person person = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("step 11");
			Connection connection = DriverManager.getConnection(url);
			System.out.println("step 12");
			PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
			pst.setString(1, mailOrPhone);
			pst.setString(2, mailOrPhone);
			pst.setString(3, password);
			System.out.println("step 13");
			ResultSet rs = pst.executeQuery();
			System.out.println("step 14");
			if(rs.next()) {
				person=new Person();
				System.out.println("step 31");
				person.setMail(rs.getString("mail"));
				person.setName(rs.getString("name"));
				person.setPhone(rs.getString("mobile"));
				person.setPassword(rs.getString("password"));
				System.out.println("Step 32");
			}
			System.out.println("step 15");
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return person;
	}

	public Person doSignup(String name, String mail, String phone, String password) {
		String query = "insert into Resistration.resistration values(?,?,?,?)";
		Person person = null;
		if(checkAvailabilty(mail)) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("step 11");
			Connection connection = DriverManager.getConnection(url);
			System.out.println("step 12");
			PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
			pst.setString(1, name);
			pst.setString(2, mail);
			pst.setString(3, phone);
			pst.setString(4, password);
			System.out.println("step 13");
			pst.executeUpdate();
			connection.close();
			person = new Person(name, mail, phone, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}}

		return person;
	}

	private boolean checkAvailabilty(String mail) {
		
		if(mail.contains("@")&&mail.contains(".")){  
			try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=123456789");  
			PreparedStatement ps=(PreparedStatement)con.prepareStatement("select * from Resistration.resistration where mail=?");  
			ps.setString(1,mail);  
			ResultSet rs=ps.executeQuery();  
			if(rs.next()){  
			   return false;  
			}else{  
			   return true;
			}  
			}catch(Exception e){e.getStackTrace();
			}  
			}else{  
			return false; 
			}  
		return false;
		
	}

	public void doChangePassword(String mail, String password) {
		String query = "update Resistration.resistration set password=? where mail=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("step 11");
			Connection connection = DriverManager.getConnection(url);
			System.out.println("step 12");
			PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
			pst.setString(1, password);
			pst.setString(2, mail);
			System.out.println("step 13");
			pst.executeUpdate();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
