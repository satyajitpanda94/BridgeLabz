<%@page import="com.bridgelabz.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="universal-css.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
<div class="title">
                <h1>
                <%
                response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
                
                Person person=(Person)session.getAttribute("person");
    		    out.print("Hi "+person.getName()+" Welcome.");
                %>
                </h1>
          </div>
<form action="Logout">
<input type="submit" value="Logout">
</form>
</body>
</html>