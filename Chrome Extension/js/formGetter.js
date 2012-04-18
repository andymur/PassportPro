jQuery(	document).ready(function($) {
	
	$('body').prepend("<div style='height: 150px; width: 750px'></div>");
	$('body').append("<div class='demo'><div id='PP-formGetter-Container'><form method='POST' action='http://authagentpro.appspot.com/desk/search.do' id='PP-formGetter'>"+
		"<input type='text' id='formId' name='formId' placeholder='Form Id' pattern='\\d+' title='Enter only number without spaces' required/>"+
		"<input type='submit' id='fetch' class='fetch' value='Fetch Form'/>"+
		"</form><div id='PP-MSG'></div></div></div>");

	$("#PP-formGetter-Container").dialog({position:"top", height:"130", width:"400"});

	$('#PP-formGetter').live('submit', function(e){
		e.preventDefault();
		$(this).ajaxSubmit({
			beforeSubmit: hideMsg,
			dataType: "json",
			resetForm: false,
			success: fill,
			error: notFetched,
			async: false
			
		});	
	});

});

function fill(data, status, xhr, elem){
	if(xhr.status!=200) alert("There was no response from the server, Try relogging into Application");
	if(!data["Found"]){
		//alert(data.msg);
		$("#PP-MSG").html(data.msg).slideDown(600);
	}else{
		var app=data.rs[0];
		
		sessionStorage.setItem("currentApplication",JSON.stringify(app));
		$("#PP-MSG").html("Form of "+app.name+" "+app.surname+" filled").slideDown(500);

		$('[name="PIA"]').val(app.poId); 
		$('[name="PIA"]').change();
		
		$('[name="SERVICE"]').val(ValidateAndFill(app.service));
		$('input[name="SURNAME"]').val(ValidateAndFill(app.surname));
		$('input[name="APPLNAME"]').val(ValidateAndFill(app.name));
		
		if(app.isNameChanged){
			document.getElementsByName("CHNAME")[0].click();
			$('input[name="PRVNAME"]').val(ValidateAndFill(app.previousName));
		}
		/*else{
			$('input[name="CHNAME"]').attr('checked', false);
			$('input[name="PRVNAME"]').attr('disabled',true).val("");
		}*/

		$('[name="APPLSEX"]').val(ValidateAndFill(app.sex));

		$('input[name="APPLDOB"]').val(ValidateAndFill(app.dob));
		$('input[name="PLACBRTH"]').val(ValidateAndFill(app.pob));
		$('input[name="BRTHDIST"]').val(ValidateAndFill(app.pobDistrict));
		$('input[name="EDUQ"]').val(ValidateAndFill(app.qualification));
		$('input[name="PROF"]').val(ValidateAndFill(app.profession));
		$('input[name="IMARK"]').val(ValidateAndFill(app.visibleMark));
		$('input[name="HIGHT"]').val(ValidateAndFill(app.height));


		$('input[name="PRESADD1"]').val(ValidateAndFill(app.address[0]));
		$('input[name="PRESADD2"]').val(ValidateAndFill(app.address[1]));
		$('input[name="PRESADD3"]').val(ValidateAndFill(app.address[2]));
		//++//
		$('input[name="PERMADD1"]').val(ValidateAndFill(app.permAddress[0]));
		$('input[name="PERMADD2"]').val(ValidateAndFill(app.permAddress[1]));
		$('input[name="PERMADD3"]').val(ValidateAndFill(app.permAddress[2]));


		$('input[name="RESDATE"]').val(ValidateAndFill(app.residingSince));
		$('input[name="PHONENO"]').val(ValidateAndFill(app.phone));
		$('input[name="MOBILENO"]').val(ValidateAndFill(app.mob));
		$('input[name="EMAIL"]').val(ValidateAndFill(app.email));
		document.getElementsByName("MRTLSTATUS")[0].value=ValidateAndFill(app.maritalStatus);
		$('input[name="MRTLSTATUS"]').change();

		/*if(app.maritalStatus=="M" || app.maritalStatus=="W"){	
			$('[name|="SPOUSENAME"]').removeAttr('disabled').val(ValidateAndFill(app.spouse));
		}*/
		/*else {
			$('[name|="SPOUSENAME"]').attr('disabled',true).val("");
		}*/

		
		$('input[name="FTHRNAME"]').val(ValidateAndFill(app.father));
		$('input[name="MTHRNAME"]').val(ValidateAndFill(app.mother));


		if( app.isAddChange){
			document.getElementsByName("LASTADD")[0].click();
			/*$('select[name="select1"]').removeAttr('disabled').val("");
			$('select[name="select2"]').removeAttr('disabled').val("");
			$('select[name="select3"]').removeAttr('disabled').val("");
			$('select[name="select4"]').removeAttr('disabled').val("");*/
			$('input[name="PRVADD1"]').val(ValidateAndFill(app.prevAdd1[0]));
			$('input[name="PRVADD2"]').val(ValidateAndFill(app.prevAdd1[1]));
			$('input[name="PRVADD3"]').val(ValidateAndFill(app.prevAdd1[2]));
			/*$('select[name="select5"]').removeAttr('disabled').val("");
			$('select[name="select6"]').removeAttr('disabled').val("");
			$('select[name="select7"]').removeAttr('disabled').val("");
			$('select[name="select8"]').removeAttr('disabled').val("");*/
			$('input[name="PRVADD11"]').val(ValidateAndFill(app.prevAdd2[0]));
			$('input[name="PRVADD12"]').val(ValidateAndFill(app.prevAdd2[1]));
			$('input[name="PRVADD13"]').val(ValidateAndFill(app.prevAdd2[2]));
		}
		/*else{
			$('select[name="select1"]').val("").attr('disabled',true);
			$('select[name="select2"]').val("").attr('disabled',true);
			$('select[name="select3"]').val("").attr('disabled',true);
			$('select[name="select4"]').val("").attr('disabled',true);
			$('input[name="PRVADD1"]').val("").attr('disabled',true);
			$('input[name="PRVADD2"]').val("").attr('disabled',true);
			$('input[name="PRVADD3"]').val("").attr('disabled',true);
			$('select[name="select5"]').val("").attr('disabled',true);
			$('select[name="select6"]').val("").attr('disabled',true);
			$('select[name="select7"]').val("").attr('disabled',true);
			$('select[name="select8"]').val("").attr('disabled',true);
			$('input[name="PRVADD11"]').val("").attr('disabled',true);
			$('input[name="PRVADD12"]').val("").attr('disabled',true);
			$('input[name="PRVADD13"]').val("").attr('disabled',true);
		}*/




		if(app.isDD){
			document.getElementsByName('pmntmode')[0].click();
			document.getElementsByName("DDNO")[0].value=ValidateAndFill(app.ddNo);
			document.getElementsByName("DDDATE")[0].value=ValidateAndFill(app.ddDate);
			document.getElementsByName("BANKCODE")[0].value=ValidateAndFill(app.bank);
		}

		
		if(app.renew){
			document.getElementsByName('oldpassport')[0].click();
			$('input[name="OLDPPTNO"]').val(ValidateAndFill(app.oldPassportNo));
			$('input[name="OLDPPTISSUDATE"]').val(ValidateAndFill(app.issueDate));
			$('input[name="OLDISSUPLAC"]').val(ValidateAndFill(app.placeOfIssue));
			$('input[name="OLDFILENO"]').val(ValidateAndFill(app.oldFileNo));
			$('input[name="OLDPPTEXPIRY"]').val(ValidateAndFill(app.expiry));
			/*$('input[name="oldpassport"]').focus().click().click().attr('checked',false).attr('checked',true)*/;
		}
		
		setTimeout("$('select[name=\"DIST\"]').val("+app.districtId+");",3000);
		setTimeout("$('select[name=\"DIST\"]').val("+app.districtId+");",1000);
		setTimeout("$('select[name=\"DIST\"]').val("+app.districtId+");",1000);
		setTimeout("$('select[name=\"DIST\"]').val("+app.districtId+");",1000);
		setTimeout("$('select[name=\"DIST\"]').val("+app.districtId+");",3000);
		setTimeout("$('select[name=\"DIST\"]').val("+app.districtId+");",6000);
		setTimeout("$('select[name=\"DIST\"]').val("+app.districtId+");",9000);

		//$('input[name="oldpassport"]').click().click();
	}
}

function hideMsg(){$("#PP-MSG").slideUp(50);$('form[name="OnlineForm"]')[0].reset();}

function ValidateAndFill(value){console.log(value); return !!value?value:'';}

function notFetched(){
	$("#PP-MSG").html("There was no response from the server, try <a href='http://authagentpro.appspot.com' target='_blank'>Logging into PassportPro</a> again")
		.slideDown('slow');
}

//https://passport.gov.in/pms/pdf/JMUI00018012AE0301.pdf