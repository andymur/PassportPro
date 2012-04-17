<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="ptag" uri="proTags" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="org.json.*"%>
<meta http-equiv="X-UA-Compatible" content="chrome=1">
<html>
<head>
<link type="text/css" href="/resources/Jquery/css/blitzer/jquery-ui-1.8.16.custom.css" rel="stylesheet" />
<style>
	.simple_overlay {
 
    /* must be initially hidden */
    display:none;
 
    /* place overlay on top of other elements */
    z-index:10000;
 
    /* styling */
    background-color:#333;
 
    width:675px;
    min-height:200px;
    border:1px solid #666;
 
    /* CSS3 styling for latest browsers */
    -moz-box-shadow:0 0 90px 5px #000;
    -webkit-box-shadow: 0 0 90px #000;
}
 
/* close button positioned on upper right corner */
.simple_overlay .close {
    background-image:url(http://jquerytools.org/media/img/overlay/close.png);
    position:absolute;
    right:-15px;
    top:-15px;
    cursor:pointer;
    height:35px;
    width:35px;
}
</style>
<link href="/resources/css/style.css" rel="stylesheet" type="text/css" media="screen" />
<script type='text/javascript' src="/resources/Jquery/js/jquery-1.6.2.min.js"></script>
<script type='text/javascript' src="/resources/Jquery/js/jquery-ui-1.8.16.custom.min.js"></script>
<script type='text/javascript' src="/resources/Jquery/js/jquery.tools.min.js"></script>
<script type='text/javascript' src="/resources/Jquery/js/verifiable.js"></script>
<script type='text/javascript' src="/resources/Jquery/js/bigupper.js"></script>
<script type='text/javascript' src="/resources/Jquery/js/ajaxForm.js"></script>
<script type='text/javascript' src="/resources/Jquery/js/myJS.js"></script>
<script type='text/javascript' src="/resources/Jquery/js/searchPage.js"></script>
<script type='text/javascript' src="/resources/Jquery/js/hovercard.js"></script>
<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="/resources/ckeditor/adapters/jquery.js"></script>
<script type='text/javascript' src="/resources/jquery-jquery-tmpl-04b5af0/jquery.tmpl.min.js"></script>
<script type='text/javascript' src="/resources/jquery-jquery-tmpl-04b5af0/jquery.tmplPlus.min.js"></script>
<script type='text/javascript'>
var master="${sessionScope.master}";
console.log(master);
</script>
<style>
	.ui-button { margin-left: -1px; }
	.ui-button-icon-only .ui-button-text { padding: 0.35em; } 
	.ui-autocomplete-input { margin: 0; padding: 0.48em 0 0.47em 0.45em; }
	#PIA{max-height : 150px;}
	#district{max-height : 150px;}
	.hidden{visibility: hidden;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search an application</title>
Your master id is: ${sessionScope.master.id}
Your user id is: ${sessionScope.proUser.key}
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
<form action="search.do" method="POST" id="searchForm">
<div class='ui-widget visibility'> 
<table><tr><td>
<input type="text" id="formId" name="formId" class="formId" placeholder="Form Id" value="" pattern="^\d+$" title="Only Numbers"/></td>
</tr><tr></tr>
<tr><td>
<select name='opposite' id="opposite" class='combobox' value="">
	<option value="!valid"  selected="selected">${sessionScope.opposite }</option>
	<ptag:selectMap map="${sessionScope.selectMap}" >
	<option value='${value }'>${name }</option>
	</ptag:selectMap>
</select>
</td></tr></table>
<br/>
<table>
<tr><!-- <td>Surname</td>  --> <td><input type=text id='surname' name='surname' placeholder='Surname' maxlength='36' class='bestupper name' pattern="[A-z ]{0,}" title="Only Letters from A-Za-z or space" autocomplete='true'/></td></tr>
<tr><!-- <td>First Name</td>  --><td><input type=text id='name' name='name' placeholder='First Name' maxlength='37' class='bestupper name' pattern="[A-z ]{3,}" title="Only Letters from A-Za-z or space. At least three letters required"/></td></tr>
<tr><td>
<select name='sex' required>
			<option value="!valid">Gender</option>
			<option  id="male" 	  value='M'/> <label for="male">Male</label>
			<option  id="female"  value='F'/> <label for="female">Female</label>
			<option  id="other"   value='X'/> <label for="other">Other</label>
</select></td></tr>

<tr>
<td><input type="text" id="dob" name="dob" class="dob date" placeholder="Date of Birth"/></td>
</tr>
<tr><td><input type="text" id="loggedAtFromUI"  class="date timestamp" placeholder="Logged From"/>
		<input type="hidden"  name="loggedAtFrom" id="loggedAtFrom"/></td>
<td><input type="text" id="loggedAtToUI" class="date timestamp" placeholder="Logged To"/>
	<input type="hidden"  name="loggedAtTo" id="loggedAtTo" value=""/></td>
</tr>
<tr><td><input type="text" id="submittedAtFromUI" class="date timestamp" placeholder="Submitted From"/>
		<input type="hidden"  name="submittedAtFrom" id="submittedAtFrom"/></td>
<td><input type="text" id="submittedAtToUI"  class="date timestamp" placeholder="Submitted To"/>
	<input type="hidden"  name="submittedAtTo" id="submittedAtTo"/></td>
</tr>
<tr><td>
<select id="PIA" name="PIA"  tabindex="2" class='combobox' required='required' placeholder="Select Office">
                <option value="!valid">Select Office</option>
                <option value='AHD'>AHEMDABAD</option>
                <option value='BPL'>BHOPAL</option>
                <option value='BHU'>BHUBNESWAR</option>
                <option value='COC'>COCHIN</option>
                <option value='DLH'>DELHI</option>
                <option value='GZB'>GHAZIABAD</option>
                <option value='GUW'>GUWAHATI</option>
                <option value='HYD'>HYDERABAD</option>
                <option value='JPR'>JAIPUR</option>
                <option value='JAL'>JALANDHAR</option>
                <option value='JMU'>JAMMU</option>
                <option value='CAL'>KOLKATA</option>
                <option value='KOZ'>KOZHIKODE</option>
                <option value='LKO'>LUCKNOW</option>
                <option value='BOM'>MUMBAI</option>
                <option value='PAT'>PATNA</option>
                <option value='SUR'>SURAT</option>
                <option value='ASR'>AMRITSAR</option>
                <option value='BLY'>BAREILLY</option>
                <option value='DDN'>DEHRADUN</option>
                <option value='MLP'>MALAPPURAM</option>
                <option value='NGP'>NAGPUR</option>
                <option value='GOA'>PANAJI</option>
                <option value='PNE'>PUNE</option>
                <option value='RPR'>RAIPUR</option>
                <option value='RCH'>RANCHI</option>
                <option value='SML'>SHIMLA</option>
                <option value='SGR'>SRINAGAR</option>
                <option value='THN'>THANE</option>
                <option value='TVM'>TRIVANDRUM</option>
</select>
</td>	
<!--  District -->
<td><div class="ui-widget" id='distPop'>
<select id='district' name='district' tabindex="2" class='combobox'>  
	<option id="!valid" value='-1'>Select District</option>  
</select>  </div>
</td></tr>

<!-- Service Desired -->
<tr><td>
<select id="service" name='service' type='combobox' required='required' class="combobox">
	<option value="!valid">Select Service</option>						
	<option value="11">Fresh Passport </option>						
	<option value="14">New Passport in lieu of Damaged/Lost Passport</option>						
	<option value="10">Passport for Children upto 15 Years of Age</option>						
	<option value="12">Re-issue of Passport / Additional Booklet</option>
</select></td></tr></table></div>

<input type="submit" value="Search"/>
<input type="reset" value="Reset"/>
</form>
<a href="#ui-state-highlight" id="topview" >
<div class="ui-state-highlight ui-corner-all" id="ui-state-highlight" style="margin-top: 20px; padding: 0 .7em;"> 
	<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
	<strong class='msg' name="msg"></strong>
</div></a>
<div name="topview"></div>
<div id="resultContainer" class="resultContainer" name="resultContainer">
</div><br/>





<a title="Back To Search" style="display:block; position: fixed; right: 5px; bottom: 5px; outline: medium none; border: 0px none;" href="#">Back to Search</a>
<div hidden='hidden' class='AppData' style='display:none'>None</div>
<div hidden='hidden' id='docCardContainer'>
	<p>
		<!-- <input type='button' data-docName="A-illitrate" class="docMarker"  value="A-il" rel="#docContainer"/>
		<input type='button' data-docName="D" class="docMarker" value='D' rel="#docContainer"/>
		<input type='button' data-docName="H" class="docMarker" value='H' rel="#docContainer"/>
		<input type='button' data-docName="B" class="docMarker" value='E' rel="#docContainer"/>
		<input type='button' data-docName="I" class="docMarker" value='I' rel="#docContainer"/>
		<input type='button' data-docName="ThanaVC" class="docMarker" value='ThanaVC' rel="#docContainer"/> -->
	</p>
</div>

<div id='docContainer' name ="docContainer" class=''>
	<div id='docArea' name='docArea'></div>
</div>
</div></div></div>
</body>
</html>