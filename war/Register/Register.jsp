<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register with PassportPro</title>
</head>
<body>

<h3>Register with Passport Pro</h3>

<% UserService userService = UserServiceFactory.getUserService();
User user = userService.getCurrentUser(); %>

<form method="post" action="submit.do">
<input type="hidden" name="regType" value="user" />
Name: <input type="text" name="name" value="<%= user.getNickname()%>" required maxlength="25" pattern="[A-z ]{3,25}" title="Only letters from A-z or space"/><br/>
Email: <strong><%= user.getNickname() %> </strong>This email will be used for communication<br/>
Contact Number: +91 <input type="number" name="contactNum" maxlength="10" size="10" required/><br/>
<input type="submit" value="Submit">
</form>

<a href="/logout.do">sign out</a>
</body>
</html>