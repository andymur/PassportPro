<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% User user =  UserServiceFactory.getUserService().getCurrentUser();%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sub Agent Registration</title>
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-26341235-1']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
</head>
<body>
<form action="createMaster.do" method="post">
	<input type="hidden" name="regType" value="subAgent"/> 
	Name:<input type="text" size="20" maxlength="25" name="name" placeholder="Name of your Company/Organization" pattern="[A-z .]{3,25}"/>
	AccountEmail:<input type="email" name="email" value="<%= user.getEmail() %>"/> (This will be the emailId with which your agency will be identified by Sub Agent)
	
	<h3>Contact Info</h3><br/>
	Contact Person: <input type="text" name="spoc"/>
	Address: <input type="textarea" name="address"/>
	Phone: +91 <input type="text" name="phone" maxlength="10"/>
	Contact Emails: <input type="email" name="contEmail" placeholder="You can put more than one separated by comma"/>
	Cell Number: +91 <input type="text" name="cell" maxlength="10"/>
	<br/>
	
	<input type="submit" value="Create Sub Agent"/>
</form>
</body>
</html>