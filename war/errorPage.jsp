<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>You Encountered an Error</title>
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
	<body bgcolor="red">
	
		<div color="white">
		<h2>WHOAAAA! You encountered an Error, Kindly back trace the path you are coming from.</h2>
		
		<h1>Report</h1>
		<h4>Report this issue by mailing us at <%=getServletContext().getInitParameter("errorEmail")%></h4>
		
		</div>
	</body>
</html>