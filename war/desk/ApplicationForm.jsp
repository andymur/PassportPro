<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="ptag" uri="proTags" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.example{font-family: 'monotype corsiva'; color: #0F0F0F;}
</style>
<link href="/resources/css/style.css" rel="stylesheet" type="text/css" media="screen" />
<link type="text/css" href="/resources/Jquery/css/blitzer/jquery-ui-1.8.16.custom.css" rel="stylesheet" />
<script type='text/javascript' src="/resources/Jquery/js/jquery-1.6.2.min.js"></script>
<script type='text/javascript' src="/resources/Jquery/js/jquery-ui-1.8.16.custom.min.js"></script>
<script type='text/javascript' src="/resources/Jquery/js/verifiable.js"></script>
<script type='text/javascript' src="/resources/Jquery/js/bigupper.js"></script>
<script type='text/javascript' src="/resources/Jquery/js/ajaxForm.js"></script>
<script type='text/javascript' src="/resources/Jquery/js/myJS.js"></script>
<style>
	.ui-button { margin-left: -1px; }
	.ui-button-icon-only .ui-button-text { padding: 0.35em; } 
	.ui-autocomplete-input { margin: 0; padding: 0.48em 0 0.47em 0.45em; }
	#PIA{max-height : 150px;}
	#district{max-height : 150px;}
	.hidden{visibility: hidden;}
</style>

<title>Fill up a form</title>
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
<div id="submitted" class="visibility hidden" style="background-color: #00CC00; height: 500; width: 500;">
The application form of <span class="name"></span> has been successfully submitted with id <span class="id"></span>
<a href="#" onclick='javascript: $(".visibility").toggleClass("hidden");fillDefaults()'>Click here to fill another form</a>
</div>


<div class='ui-widget visibility'> 
<form id="applicationForm" action="applicationSave.do" title="Passport Form" method='POST'>
<input type='hidden' id="type" name='${sessionScope.type }' value='${sessionScope.master.id }'/>
<input type='hidden' id="savetype" name='savetype' value='new'/>
<table>
<tr><td>

<select placeholder='Application Type' id='applicationType' name='applicationType' class='' required='required'>
	<option value="1">Online</option>
	<option value="2">Offline</option>						
	<option value="3">Tatkal</option>						
	<option value="5">Other</option>
</select></td>
<td>
<select name='${sessionScope.opposite }' id="opposite" class='combobox' required='required'>
<option value="!valid"  selected="selected">${sessionScope.opposite }</option>

	<ptag:selectMap map="${sessionScope.selectMap}" >
		<option value='${value }'>${name }</option>
	</ptag:selectMap>
	
</select> <button id="add">Add</button>
</td>
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
	<option id="!valid" value='!valid'>Select District</option> 
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
</select></td></tr></table>

<!-- Name -->
<table>
<tr><td>Surname</td><td><input type=text id='surname' name='surname' placeholder='Surname' maxlength='36' class='bestupper name' pattern="[A-z ]{0,}" title="Only Letters from A-Za-z or space" autocomplete='true'/></td></tr>
<tr><td>First Name</td><td><input type=text id='name' name='name' placeholder='First Name' maxlength='37' class='bestupper name' required='required' pattern="[A-z ]{3,}" title="Only Letters from A-Za-z or space. At least three letters required"/></td></tr>
</table>

<table><tr><td>
<input type="checkbox" id="isNameChanged" name="isNameChanged" value="nameChange"/> 
If you have ever changed your name click this <label for="isNameChanged">box</label> and indicate your previous name in full.</td></tr></table>	
<table>
	<tr><td>Previous Name</td><td><input type="text" id="previousName" name="previousName" maxlength="50" class="name bestupper" disabled='true' placeholder='Previous Name' pattern="[A-z ]{3,}" title="Only Letters from A-Za-z or space. At least three letters required" /></td></tr>
	<tr><td>Gender</td><td><div id="sex" name="gender" class='required' required='required'>
	<select name='sex' required>
			<option  id="male" 	  value='M'/> <label for="male">Male</label>
			<option  id="female"  value='F'/> <label for="female">Female</label>
			<option  id="other"   value='X'/> <label for="other">Other</label>
	</select>
	</div></td></tr>
</table>

<table>
<!-- Date of Birth -->
<tr><td>Date Of Birth</td><td><input type='text' class='date' id='dob' name="dob" maxlength='10' placeholder='dd/mm/yyyy' required='required'/></td></tr>

<!-- POB to height -->
<tr><td>Place Of Birth</td><td><input maxlength="50" id="pob" name="pob" size="33" type="text" class='bestupper name' placeholder='Place of Birth' required='required' pattern="[A-z ]{3,}" title="Only Letters from A-Za-z or space and At least three letters required"/></td>
	<td>District</td><td><input maxlength="50" id="birthdist" name="pobDistrict" size="33" type="text" class='bestupper name' placeholder='District or Country' required='required' pattern="[A-z ]{3,}" title="Only Letters from A-Za-z or space. At least three letters required"/></td></tr>
	<tr>
	<td>Education</td><td><input maxlength="20" id="education" name="education" name= size="33" type="text" class='bestupper name' placeholder='Qualification' pattern="[A-z 0-9a#:/,.)(b]{0,}" title="Only Letters from A-Za-z numbers 0-9 or symbols # ()-:/,"/></td>
	<td>Profession</td><td><input maxlength="20" id="profession" name="profession" size="33" type="text" class='bestupper name' placeholder='Profession' pattern="[A-z ]{1,}"/></td></tr>
	<tr>
	<td>Identification Mark</td><td><input maxlength="35" id="imark" name="imark" size="33" type="text" class='bestupper name' placeholder='Visible Mark' required='required' pattern="[A-z ]{1,}" title="Only Letters from A-Za-z or space"/></td>
	<td>Height</td><td><input maxlength="3" id="height" name="height" type="number" size='6' min='20' max='200' step='1' placeholder='Height' required='required'pattern="[0-9]{2,3}" title="Height in cms, less than 200 cms"/></td></tr>
</table>


<!-- Address -->
<table>
<tr><td>Present Address</td><td>Permanent Address</td></tr>
<tr><td>
<table>
<tr><td><input maxlength="35" id="presadd1" name="presadd1" size="33" type="text" placeholder="Present Address Line 1" class="bestupper replicate" required='required'/></td></tr>
<tr><td><input maxlength="35" id="presadd2" name="presadd2" size="33" type="text" placeholder="Present Address Line 2" class="bestupper replicate" required='required'/></td></tr>
<tr><td><input maxlength="35" id="presadd3" name="presadd3" size="33" type="text" placeholder="Present Address Line 3" class="bestupper replicate"/></td></tr>
</table></td>
<td><table>
<tr><td><input maxlength="35" id="permadd1" name="permadd1" size="33" type="text" placeholder="Permanent Address Line 1" class="bestupper" required='required'/></td></tr>
<tr><td><input maxlength="35" id="permadd2" name="permadd2" size="33" type="text" placeholder="Permanent Address Line 2" class="bestupper" required='required'/></td></tr>
<tr><td><input maxlength="35" id="permadd3" name="permadd3" size="33" type="text" placeholder="Permanent Address Line 3" class="bestupper"/></td></tr>
</table></td></tr>
<tr>
<td></td><td>Residing Since<input maxlength="10" id="residingSince" name="residingSince" size="13" type="text" class='date' placeholder='Residing Since' required/></td>
</tr></table>
<br/><br/>

<table>
<tr><td>Contact Number</td><td><input maxlength="15" id="phone" name="phone" size="15" type="text"  placeholder='Phone Number' pattern="[0-9 +]{0,}"/>
<input id="mobileno" name="mob" maxlength="15"  size="15" type="text"  placeholder='Mobile Number'/></td></tr>
<tr><td>Email</td><td><input maxlength="50" id="email" name="email" size="38" type="email" placeholder='Email Id'/></td><td><div class='example'>Example: john.doe@example.com</div></td></tr>
</table>

<!-- FAMILY -->
<table><tr>
Applicant's Family Information ( All Names should be in full (including surname if any). Initials and titles are not allowed)</tr>
<tr><td>Marital Status</td><td>
<select name="maritalStatus" class="checkbox maritalStatus" id="maritalStatus" onchange="" required>
                <option value="!valid">Select Marital Status</option>
                <option value="M">Married</option>
                <option value="S">Single</option>
                <option value="W">Widow/Widower </option>
                <option value="D">Divorcee</option>
</select></td>
<td class='spouse hidden'>Spouse's Name<input type="text" name="spouse" id="spouse" maxlength="75" size='40' class='bestupper name'  pattern="[A-z ]{3,}" title="Only Letters from A-Za-z or space. At least three letters required"/></td></tr>
<tr><td>Father's Name</td><td><input type=text id='father' name='father' placeholder="Father's Name" maxlength='75' class='bestupper name' required='required' pattern="[A-z ]{3,}" title="Only Letters from A-Za-z or space. At least three letters required"/></td></tr>
<tr><td>Mother's Name</td><td><input type=text id='mother' name='mother' placeholder="Father's Name" maxlength='75' class='bestupper name' required='required' pattern="[A-z ]{3,}" title="Only Letters from A-Za-z or space. At least three letters required"/></td></tr>
</table>

<!-- OLD ADDRESS -->
<table><tr>
 If you are not residing at the Present Address for the last one year, click on this box <input name="isAddChange" type="checkbox" value="addChange" id="isAddChange"> and furnish addresses of the other place(s) of residence in the last one year along with the duration(s) of living there.</tr>   
<tr class='prevAddressFields' style="display:none">
<td><table>
<tr><td><input type='text' class='date prev' id='from1' name="from1" maxlength='10' placeholder='From Date'  title="From Date (DD/MM/YYYY)"/></td></tr>
<tr><td><input type='text' class='date prev' id='to1' name="to1" maxlength='10' placeholder='To Date'  title="To Date (DD/MM/YYYY)"/></td></tr>
<tr><td><input maxlength="35" id="prevadd11" name="prevadd11" size="33" type="text" placeholder="Previous Address 1 Line 1" class="bestupper prev" /></td></tr>
<tr><td><input maxlength="35" id="prevadd12" name="prevadd12" size="33" type="text" placeholder="Previous Address 1 Line 2" class="bestupper prev" /></td></tr>
<tr><td><input maxlength="35" id="prevadd13" name="prevadd13" size="33" type="text" placeholder="Previous Address 1 Line 3" class="bestupper prev"/></td></tr>
</table></td>

<td><table>
<tr><td><input type='text' class='date prev' id='from2' name="from2" maxlength='10' placeholder='From Date' title="From Date (DD/MM/YYYY)"/></td></tr>
<tr><td><input type='text' class='date prev' id='to2' name="to2" maxlength='10' placeholder='To Date'  title="To Date (DD/MM/YYYY)"/></td></tr>
<tr><td><input maxlength="35" id="prevadd21" name="prevadd21" size="33" type="text" placeholder="Previous Address 2 Line 1" class="bestupper prev" /></td></tr>
<tr><td><input maxlength="35" id="prevadd22" name="prevadd22" size="33" type="text" placeholder="Previous Address 2 Line 2" class="bestupper prev" /></td></tr>
<tr><td><input maxlength="35" id="prevadd23" name="prevadd23" size="33" type="text" placeholder="Previous Address 2 Line 3" class="bestupper prev"/></td></tr>
</table></td>
</tr>
</table>

<!-- DD -->
 If you have a Demand Draft, click on this box <input name="isDD" id="isDD" type="checkbox" value="DD" />   and fill the details below:<br/>
 <div class='ddD' style='display:none'>
 <input maxlength="10" name="ddNO" size="12" type="text" class='dd' placeholder="DD Number">
 <input maxlength="10" name="ddDATE" size="20" type="text" class='dd date'  placeholder="DD Date (dd/mm/yyyy)">
<select name="bank" tabindex="47" class='dd'>
                <option value="1">State Bank of India</option>
                <option value="2">Overseas bank of India</option>
                <option value="3">Punjab National Bank</option>
                <option value="4">Corporation  Bank</option>
                <option value="5">Punjab and Sindh Bank</option>
                <option value="5">Canara Bank</option>
                <option value="5">Vijaya Bank</option>
                <option value="5">HDFC Bank</option>
                <option value="5">ICICI Bank</option>
                <option value="6">Others</option>
</select>
</div>

<!-- OLD PP -->
 If you have held a passport or hold a passport at present, click on this box <input type='checkbox' name='isRenew' value="renew"/> 
  and fill the details below:
<div id='oldPassport' style="display:none">
<table>
<tr><td><h3>Old Passport Details</h3></td></tr>
<tr>
<td>Passport Number</td><td><input maxlength="10" id="oldPPno" name="oldPassportNo" size="15" type="text" placeholder='Passport Number' class='bestupper'></td>
<td>Issue Date</td><td><input maxlength="10" name="oldIssueDate" size="15" type="text" class='date' placeholder='Issue Date'></td>
</tr>
<tr>
<td>Place Of Issue</td><td><input maxlength="15" id="placeOfIssue" name='placeOfIssue' size="15" type="text" class='bestupper' placeholder='Place of Issue' pattern="[A-z0-9]{1,}" title="Only Letters from A-Za-z or numbers 0-9"/></td>
<td>File Number</td><td><input maxlength="15" name="oldFileNo" size="15" type="text" class='bestupper' placeholder='File Number' pattern="[A-z0-9]{1,}" title="Only Letters from A-Za-z or numbers 0-9"/></td></tr>

<tr><td>Expiry Date</td><td><input maxlength="10" id="oldExpiry" name='oldExpiry' size="15" type="text" class='date' placeholder='Expiry Date'/></td></tr>
</table>
</div>
<div class="demo">
<input type='Submit' value='Submit' class="button"/>
<input type='Reset' value='Reset' class="button"/>
</div>
</form>
</div></div></div></div>

<div id="subAgentDialogue" class='dialog' title="Add SubAgent">
<div id='Sub-AgentTabs'>
<ul>
<li><a href="#addRegisteredSub-Agent">Add Registered</a> </li>
<li><a href="#addProxySub-Agent">Add Non-Registered</a> </li>
</ul>
<div id="addRegisteredSub-Agent">
Id <input type="text" size="35" id="subAgentId" name="subAgentId" placeholder="Sub-Agent PassportPro Id" value="" pattern="[^\d+$]{1,}"/><br/>
<input type="button" value="Send Request" name="subAgentSendRequest" id="subAgentSendRequest"/><br/>

</div>

<div id="addProxySub-Agent">
<input type="text" name="proxySubAgentName" id="proxySubAgentName" placeholder="Name of the Sub-Agent" value="" class='bestupper din'/><br/>
<h2>Contact Info</h2>
<input type="text" id="subAgentSpoc" placeholder="Contact Person" class="din"/><br/>
<input type="text" id="address" placeholder="Sub-Agent Address" class="din"/><br/>
<input type="text" id="subAgentPhone" placeholder="Phone Number" class="din"/><br/>
<input type="text" id="subAgentCell" placeholder="Cell Number" class="din"/><br/>
<input type="email" id="subAgentEmail" placeholder="Email" class="din"/><br/>
<input type="button" value="Add proxy Sub-Agent" name="addProxySubAgent" id="addProxySubAgent" class="din"/><br/>

</div>
</div>
</div>

<div id="agentDialogue" class='dialog' title="Add New Agent">
<div id="addRegisteredSub-Agent">
Id <input type="text" size="35" name="agentId" id="agentId" placeholder="Agent PassportPro Id" value="" class="din"/><br/>
<input type="button" value="Send Request" name="agentSendRequest" id="agentSendRequest" class="din"/><br/>
</div>
<div id="msgdialog"><span id="msg" class="msg"></span></div>
${session}
</body>
</html>