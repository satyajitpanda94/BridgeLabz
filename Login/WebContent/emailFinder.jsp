<%@page import="java.sql.ResultSet"%>
<%@page import="com.mysql.jdbc.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%  
String email=request.getParameter("email");  
if(email.contains("@")&&email.contains(".")){  
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=123456789");  
PreparedStatement ps=(PreparedStatement)con.prepareStatement("select * from Resistration.resistration where mail=?");  
ps.setString(1,email);  
ResultSet rs=ps.executeQuery();  
if(rs.next()){  
out.print("Unavailable !");  
}else{  
out.print("Available");  
}  
}catch(Exception e){out.print(e);}  
}else{  
out.print("Invalid email !");  
}  
%>  
