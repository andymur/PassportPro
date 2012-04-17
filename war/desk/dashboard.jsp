<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ page import="com.appspot.authagentpro.ProUser" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% ProUser proUser=(ProUser)session.getAttribute("proUser");
	int offset = proUser.getOffset();
%>
<style>
	.ui-button { margin-left: -1px; }
	.ui-button-icon-only .ui-button-text { padding: 0.35em; } 
	.ui-autocomplete-input { margin: 0; padding: 0.48em 0 0.47em 0.45em; }
</style>
<link href="/resources/css/style.css" rel="stylesheet" type="text/css" media="screen" />
<link type="text/css" href="/resources/Jquery/css/blitzer/jquery-ui-1.8.16.custom.css" rel="stylesheet" />
<script type='text/javascript' src="/resources/Jquery/js/jquery-1.6.2.min.js"></script>
<script type='text/javascript' src="/resources/Jquery/js/jquery-ui-1.8.16.custom.min.js"></script>
<script type='text/javascript' src="/resources/Jquery/js/deskdashboard.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var x =${sessionScope.proUser.offset};
	getOnlineOffset(x);
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${sessionScope.master.name }'s Desk</title>
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
<div id="header">
	<div id="logo">
		<h1><a href="http://www.authagentpro.appspot.com" >Passport Pro Manager</a></h1>
		<p>Helps you organize your work professionally</p>
	</div>
	<div id="navigation">
		<ul>
			<li><a href="/PassportPro.jsp" class="first">Home</a></li>
			<li><a href='/dashboard/userDashboard.jsp'>Dashboard</a></li>
			<li><a href="/desk/Search.jsp">Search Form</a></li>
			<li><a href="/desk/ApplicationForm.jsp">Fill an Application</a></li>
			<li><a href="/desk/manage.jsp">Manage</a></li>
			<li><a href="/logout.do">Logout</a></li>
		</ul>
	</div>
</div>
<div id="content">
	<div id="page">
		<div id="column1">
You are at
<h2>${sessionScope["type"] }  ${sessionScope.master["name"] }'s Desk</h2> logged in as ${sessionScope.role }
<a href="ApplicationForm.jsp">Applicaion Form</a><br/>
<a href="Search.jsp">Search Applicaion Form</a><br/>
<a href="manage.jsp">Manage</a><br/>
<div class='demo ui-widget'>
<div class="datepicker" id="onlineCalendar"></div>
</div>


<br/><br/><a href="/logout.do">sign out</a>
</div></div></div>
</body>
</html>

