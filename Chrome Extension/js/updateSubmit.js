
$(document).ready(function($) {
	

	$('body').prepend("<div style='height: 150px; width: 750px'></div>");
	$('body').append("<div id='PP-updateSubmit-Container'><form method='POST' action='http://authagentpro.appspot.com/desk/applicationSave.do' id='PP-updateSubmit'>"+
		"<input type='hidden' id='formId' name='formId' class='formId'/>"+
		"<input type='hidden' name='submissionDate' id='submissionDate'/>"+
		"<input type='hidden' name='onlineFileNo' class='submissionDate'/>"+
		"<input type='hidden' name='savetype' value='updateSubmit'/>"+
		"Save information for formId <span class='formId'><span/> of applicant <span id='nameDisplay'></span><br/>"+
		"Submission Date is <span id='dateDisplay'></span> with File No. <span id='onlineFileNoDisplay' class='onlineFileNo></span>'"+
		"<input type='submit'  value='Update Form'/>"+
		"</form><div id='PP-MSG'></div></div>");

	$("#PP-updateSubmit-Container").dialog({position:"top", height:"150", width:"400"});

	$('[name|="MONTH"]').change(updateDialog);
	$('[name|="DATE"]').change(updateDialog);
	updateDialog();

	$('#PP-updateSubmit').live('submit', function(e){
		e.preventDefault();
		$(this).ajaxSubmit({
			//target: '#output',
			dataType: "json",
			resetForm: false,
			success: fill,
			error: notFetched,
			async: false,
			beforeSubmit: validate
			
		});	
	});

});


function updateDialog(){
	var onlineFileNo=$('form[name|="example"] > table tr:nth-child(5)  td:nth-child(2) > span > span').text();
	onlineFileNo=$.trim(onlineFileNo);
	var name=$('form[name|="example"] > table  tr:nth-child(4)  td:nth-child(2) > span > b').text();
	name=$.trim(name);
	var date=$('[name|="DATE"]').val();

	var currentApplication = JSON.parse(sessionStorage.getItem("currentApplication"));
	var formId=currentApplication.formId;

	
	if(name != currentApplication.name+" "+currentApplication.surname){
		alert("There was some error, Submission details of this application cannot be saved, Kindly save it manually from Edit Form Tab");
		return;
	}
	$('#nameDisplay').text(name);
	$('.formId').val(formId);

	if(date) $("#dateDisplay").html(date); else $("#dateDisplay").html("<span style='color: red'>Not yet chosen</span>"); 

	$("#submissionDate").val(new Date(date));
	$('#onlineFileNo').val(onlineFileNo);
	$('#onlineFileNoDisplay').text(onlineFileNo);
}

function validate(arr,form,opt){
	var date=$("#submissionDate").val();
	if(date=="Not yet chosen" || date || date==""){
		alert("Choose the date correctly");
		return false;
	}
}

//https://passport.gov.in/pms/pool1.jsp?HIGHT=165&APPLDOB=01/03/1985&fileno=BPLI01118612&PIA=BPL&APPLNAME=TASNEEM%20BURHANPURWALA
//https://passport.gov.in/pms/pdf/GUWI00257312MO0102.pdf