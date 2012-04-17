<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ page import= "com.appspot.authagentpro.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.authagentpro.appspot.com">
<head>
<link rel="chrome-webstore-item"
    href="https://chrome.google.com/webstore/detail/pmhdefpphdcjknccfegiiflcmnnnlean">
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Passport Pro Manager</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/resources/css/style.css" rel="stylesheet" type="text/css" media="screen" />
<link type="text/css" href="/resources/Jquery/css/blitzer/jquery-ui-1.8.16.custom.css" rel="stylesheet" />
<script type='text/javascript' src="/resources/Jquery/js/jquery-1.6.2.min.js"></script>
<script type='text/javascript' src="/resources/Jquery/js/jquery-ui-1.8.16.custom.min.js"></script>
<script type='text/javascript' src="/resources/Jquery/js/myJS.js"></script>
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
<noscript>
      <div style="width: 22em; position: absolute; left: 50%; margin-left: -11em; color: red; background-color: white; border: 1px solid red; padding: 4px; font-family: sans-serif">
        Your web browser must have JavaScript enabled
        in order for this application to display and function correctly.
      </div>
</noscript>
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
			<div class="box1">
				<h2>Welcome to Passport Pro Manager</h2>
				<p>Passport Pro Manager is an online service which you can use to avail various services required to apply for passport. You will have your unique accounts here. All the consultation will be provided on this portal. You can fill all details of your clients here and all the documents, Affidavits and paper works will be prepared automatically. You can also check the status of your client's passport. The database of your clients will be stored here and you can also add your agent or subagent in your account. The database will be on the Google server hence it will be safe and will be available to you anywhere where internet access is there.</p></br></br>
				
				<h2>Why us?</h2>
				<p><img class='large' src="/resources/images/passport.jpg" alt="" />
<ul>
<li>Makes your tedious and time consuming task of document preparation easier.</li>
<li>Eliminates your errors due to multiple entries of single data by maintaining a single database and using only that copy everywhere.</li>
<li>Making whole process online which will save your human resources and time.</li>
<li>Autofill tool will be provided to you which will minimize error and save your time.</li>
<li>Increase your quality of service provided to the customer.</li>
</ul>
</p>

<h2>
Passport Pro Chrome Extension
<a href='http://chrome.google.com/webstore/detail/pmhdefpphdcjknccfegiiflcmnnnlean' target='_blank'>
<img src='http://lh6.googleusercontent.com/25kF7YSVhDtMAR56VQIg6_mHhzIYJAvvmBhufkO3ht1yYdBh0MXBD-WTtx7fJLlYdRieGYWw=s72-h72-e365'/>
</a>
</h2>
<p>
Download Google <a href='#' onclick='chrome.webstore.install()'>
Chrome extension</a> For Passport Pro to take advantage of Auto Form Fill Feature. Using this you can auto fill forms on http://passport.gov.in 
with the ones you filled on this site. 
</p>
			
			</div>
		</div>
		<div id="column2">
		<h3>Quick Links</h3>
<a class="menu-right" href='#' onclick='chrome.webstore.install()'>PassportPro Chrome Ext</a>
<a class="menu-right" href="http://passportstatus.nic.in/passmain.php?" target="_blank">Check your status here</a>
<a class="menu-right" href="https://passport.gov.in/pms/OnlineRegistration.jsp" target="_blank">Tatkaal Form</a>
<a class="menu-right" href="https://passport.gov.in/pms/Agent_login.jsp" target="_blank">Agent login Form</a>
<a class="menu-right" href="https://passport.gov.in/cpv/Affidavits.htm" target="_blank">Affidavits Format</a></br></br>
			<!-- <h3>Login or Register with your Google Account</h3>  -->
			

<form method='post' action='dashboard/userDashboard.jsp'>
<input type='hidden' value='login'/>
<div class="demo">
<input type="submit"  value="Login/Register with your Google Account">
</div>
</form><br/><br/>
<!-- AddThis Button BEGIN -->
<h3>Share</h3>
<div class="addthis_toolbox addthis_default_style addthis_32x32_style">
<a class="addthis_button_preferred_1"></a>
<a class="addthis_button_preferred_2"></a>
<a class="addthis_button_preferred_3"></a>
<a class="addthis_button_preferred_4"></a>
<a class="addthis_button_compact"></a>
<a class="addthis_counter addthis_bubble_style"></a>
</div>
<script type="text/javascript" src="http://s7.addthis.com/js/250/addthis_widget.js#pubid=ra-4e9811d458acca31"></script>
<!-- AddThis Button END -->			
</div></div></div>			

<div id='footer' style="height: 15em;">
<p></p>

</div>
</body>
