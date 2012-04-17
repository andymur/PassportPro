<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="ptag" uri="proTags" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="/resources/css/style.css" rel="stylesheet" type="text/css" media="screen" />
<link type="text/css" href="/resources/Jquery/css/blitzer/jquery-ui-1.8.16.custom.css" rel="stylesheet" />
<script type='text/javascript' src="/resources/Jquery/js/jquery-1.6.2.min.js"></script>
<script type='text/javascript' src="/resources/Jquery/js/jquery-ui-1.8.16.custom.min.js"></script>
<script type='text/javascript' src="/resources/Jquery/js/verifiable.js"></script>

<script type='text/javascript' src="/resources/Jquery/js/ajaxForm.js"></script>
<script type='text/javascript' src="/resources/Jquery/js/manage.js"></script>

<title>Manage ${sessionScope.type } Account</title>
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
<c:if test="${sessionScope.role eq 'Admin' }">
<input type="button" id='addUserButton' value="Add User"/>

<div id='addUser'>
	<form action='admin/adduser.do' method='POST'>
		<input type='number' name='userid' placeholder='User Id'/> OR <input type='email' name='useremail' placeholder='Email Id'/>
		<input type='submit'/>
	</form><div class='msg'></div>

</div>
<script type='text/javascript'>
$(document).ready(function(){ 
	$('#addUser').dialog({autoOpen: false, modal: true, });
	$('#addUserButton').click(function(e){
		$('#addUser').dialog('open');
	});
}); 

</script>
</c:if>

<div id='tabsWrapper'>
<div id='Requests' placeholder='Requests' name='Requests'>

<h2>Requests Made By You</h2>
<h4>To ${sessionScope.opposite }</h4>
<ptag:requests to='opposite' from='master' page='manage' id='${sessionScope.master.id}' fromto='from'>
<div>
	${toName }
	<form action="admin/cancel.do" method="post"><input name='requestId' type="hidden" value="${requestId }"><input type="submit" value="Cancel Request"/>
	</form><div class='msg'/>
</div>
</ptag:requests>

<h4>To Users</h4>
<ptag:requests to='user' from='master' page='manage' id='${sessionScope.master.id}' fromto='from'>
<div>
	${toName }
	<form action="admin/cancel.do" method="post"><input type="hidden" name='requestId' value="${requestId }"><input type="submit" value="Cancel Request"/></form>
	<div class='msg'/>
</div>
</ptag:requests>



<h2>Requests Made to You</h2>
<h4>By ${sessionScope.opposite }</h4>
<ptag:requests to='master' from='opposite' page='manage'  id='${sessionScope.master.id}' fromto='to'>
<div>
	${fromName}
	<form action="admin/approve.do" method="post"><input name='requestId' type="hidden" value="${requestId }"><input type="submit" value="Approve"/></form>
	<form action="admin/reject.do" method="post"><input  name='requestId' type="hidden" value="${requestId }"><input type="submit" value="Reject"/></form>
	<div class='msg'/>
</div>
</ptag:requests>

<h4>By Users</h4>
<ptag:requests to='master' from='user' page='manage'  id='${sessionScope.master.id}' fromto='to'>
<div>
	${fromName}
	<form action="admin/approve.do" method="post"><input type="hidden" name='requestId'  value="${requestId }"><input type="submit" value="Approve"/></form>
	<form action="admin/reject.do" method="post"><input type="hidden"  name='requestId' value="${requestId }"><input type="submit" value="Reject"/></form>
	<div class='msg'/>
</div>
</ptag:requests>
</div>

<div id='RelationShips' placeholder='RelationShips' name='RelationShips'>

<h2>Relationships with</h2>
<h4> ${sessionScope.opposite }</h4>
<ptag:selectMap map="${sessionScope.selectMap}" >
<div>
	${name }<form action="admin/breakup.do" method="post"><input type="hidden" name='oppositeId' value="${value }"><input type="submit" value="Remove"/></form>
	<div class='msg'/>
</div>
</ptag:selectMap>

<h4>Users</h4>
<ptag:userRelationships filter='hostId' page='manage' id='${sessionScope.master.id}' opposite='${sessionScope.opposite }'>
<div>
	${userName }  <c:if test= '${isAdmin eq true }'>is Admin</c:if>
	<c:if test='${sessionScope.role eq "isAdmin"}'> 
		<form action="admin/breakup.do" method="post"><input type="hidden" name='relId' value="${relId }"><input type="submit" value="Remove"/></form>
		<form action="admin/toggleAdmin.do" method="post"><input type="hidden" name='relId' value="${relId }"><input type="submit" 
			value="<c:if test= '${isAdmin eq true }'>Revoke</c:if> 
		<c:if test= '${isAdmin eq false }'>Grant</c:if> Admin Rights"/></form><div class='msg'/>
	</c:if>
</div>
</ptag:userRelationships>

</div>
</div>
</div></div></div>

</body>
</html>