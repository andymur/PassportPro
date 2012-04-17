<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="ptag" uri="proTags" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/resources/css/style.css" rel="stylesheet" type="text/css" media="screen" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="/resources/Jquery/css/blitzer/jquery-ui-1.8.16.custom.css" rel="stylesheet" />
<script type='text/javascript' src="/resources/Jquery/js/jquery-1.6.2.min.js"></script>
<script type='text/javascript' src="/resources/Jquery/js/jquery-ui-1.8.16.custom.min.js"></script>
<script type='text/javascript' src="/resources/Jquery/js/myJS.js"></script>
<title>${sessionScope.proUser.name}'s Dashboard</title>
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
			<li><a href="/logout.do">Logout</a></li>
		</ul>
	</div>
</div>
<div id="content">
	<div id="page">
		<div id="column1">
Hi ${sessionScope.proUser.name}<br/>
Your Pro User Key is: ${sessionScope.proUser.key}
<br/>
<strong>You can login to only one of the following at a time,<br/>
to change your selection later come back to this page.</strong><br/>
<a href="AgentRegistration.jsp">Register as an Authorised Agent</a><br/>
<a href="SubAgentRegistration.jsp">Register as a Sub Agent</a>
<br/><br/>

<table>
<h2>Agent's Desk</h2>
<ptag:agents userId="${sessionScope.proUser.key}" >

		<form action="gotodesk.do" method="post">
			<input type="hidden" name="type" value="Agent"/>
			<input type="hidden" name="id" value="${agent.id }"/>
			<input type="hidden" name="name" value="${agent.name }"/>
			<input type="hidden" name="email" value="${agent.email}"/>
			<input type="hidden" name="isAdmin" value="${isAdmin }"/>

			<input type=submit value="Login to ${agent.name }"/>
		</form>
</ptag:agents>
</table>
<br/>
<table>

<h2>Sub Agent's Desk</h2>
<ptag:subagents userId="${sessionScope.proUser.key}" >

		<form action="gotodesk.do" method="post">
			<input type="hidden" name="type" value="Sub-Agent"/>
			<input type="hidden" name="id" value="${subAgent.id }"/>
			<input type="hidden" name="name" value="${subAgent.name }"/>
			<input type="hidden" name="isAdmin" value="${isAdmin }"/>
			<input type=submit value="Login to ${subAgent.name }"/>
		</form>

</ptag:subagents>
</table>



<div class='demo'>
<div id='tabsWrapper'>

	<ul>
		<li><a href="#Requests">Requests</a></li>
		<!-- <li><a href="#Relationships">Relationships</a></li>  -->
	</ul>

<div id='Requests' placeholder='Requests' name='Requests'>

	<h2>Requests Made By You</h2>
	<h4>To Agents</h4>
		<ptag:requests to='agent' from='user' page='userDashboard' id='{sessionScope.proUser.id}' fromto='from'>
			<form action="cancel.do" method="post"><input type="hidden" value="${requestId }"><input type="submit" value="Cancel Request"/></form>
		</ptag:requests>
	<h4>To Sub Agents</h4>
		<ptag:requests to='subagent' from='user' page='userDashboard' id='{sessionScope.proUser.id}' fromto='from'>
			<form action="cancel.do" method="post"><input type="hidden" value="${requestId }"><input type="submit" value="Cancel Request"/></form>
		</ptag:requests>
	
	
	
	
	<h2>Requests Made to You</h2>
	<h4>By Agents</h4>
	<ptag:requests to='master' from='opposite' page='userDashboard'  id='{sessionScope.proUser.id}' fromto='to'>
		<form action="approve.do" method="post"><input type="hidden" value="${requestId }"><input type="submit" value="Approve"/></form>
		<form action="reject.do" method="post"><input type="hidden" value="${requestId }"><input type="submit" value="Reject"/></form>
	</ptag:requests>
	
	<h4>By Sub Agents</h4>
	<ptag:requests to='master' from='user' page='userDashboard'  id='{sessionScope.proUser.id}' fromto='to'>
		<form action="approve.do" method="post"><input type="hidden" value="${requestId }"><input type="submit" value="Approve"/></form>
		<form action="reject.do" method="post"><input type="hidden" value="${requestId }"><input type="submit" value="Reject"/></form>
	</ptag:requests>
</div>



<!--  <%-- 
<div id='RelationShips' placeholder='RelationShips' name='RelationShips'>
<h2>Relationships with</h2>
<h4> Agents</h4>
<ptag:userRelationships filter='userId' isAgent='true' page='userDashboard' id='${sessionScope.proUser.key}' opposite=''>
	${hostName }<form action="cancel.do" method="post"><input type="hidden" value="${relId }"><input type="submit" value="Remove"/></form>
</ptag:userRelationships>

<h4>Sub Agents</h4>
<ptag:userRelationships filter='userId' isAgent='false' page='userDashboard' id='${sessionScope.proUser.key}' opposite=''>
	${hostName }<form action="cancel.do" method="post"><input type="hidden" value="${relId }"><input type="submit" value="Remove"/></form>
</ptag:userRelationships>
</div>
--%> -->


</div></div>
</div></div></div>
</body>
</html>