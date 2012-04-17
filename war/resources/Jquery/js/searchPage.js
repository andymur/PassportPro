var PP = new Object();
PP.DOCS = {
    "A-illitrate": "              <title>ANNEXURE 'A'</title>       <div style='width:600px' >     <div style='height:390px;' ></div>     <div style='text-align:center;' ><h2><u>ANNEXURE - 'A'</u></h2></div>     <div >                 I <span style='font-size:18px;font-weight:bold;'>${ name } ${ surname } ${sowodo(this)} </span><br />     Presently residing at: <span style='font-size:18px;font-weight:bold;'>${address}</span> <br />     Hereby state as follows:<br /><br />           1. That, I was born on <span style='font-size:18px;font-weight:bold;'> ${dob}</span> at <span style='font-size:18px;font-weight:bold;'>${ pob }</span> situated in the district <span style='font-size:18px;font-weight:bold;'>${pobDistrict}</span> In the state of <span style='font-size:18px;font-weight:bold;'> ${prompt('Please enter state of '+pobDistrict) } </span> I have no documentary proof in support of my place and date of birth.<br />     2.That, I do not possess any educational qualifications and I am an illiterate person.<br /><br />                 I take oath and solemnly declare/affirm that the particulars furnished by me above are correct and that I have not concealed or misrepresented any facts.     <table width='100%'>     <tr>     <td colspan='2' align='left'>     Place:     </td>     </tr>     <tr>     <td align='left'>Date:</td>     <td align='right'>Deponent: __________</td>     </tr>     </table>           <div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Verified on&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Date) that the contents of my above affidavit are true and correct to the best of my knowledge and belief and nothing in material has been concealed there from.</div>           <div style='padding-left:40px;'>The contents of the affidavit have been read out of me.</div>           <table width='100%'>     <tr>     <td align='right'>Deponent: __________</td>     </tr>     </table>     </div>     </div>                     ",
    "A-Literate": "                                         <div style='width:600px' >     <div style='height:390px;' ></div>     <div style='text-align:center;' ><h2><u>ANNEXURE - 'A'</u></h2></div>     <div>           I <span style='font-size:18px;font-weight:bold;'>${ name } ${ surname }  ${sowodo(this)} </span> <br />     Presently residing at: <span style='font-size:18px;font-weight:bold;'>${address}</span> <br />     Hereby state as follows:<br /><br />           1. That, I was born on <span style='font-size:18px;font-weight:bold;'> ${dob}</span> at <span style='font-size:18px;font-weight:bold;'>${ pob }</span> situated in the district <span style='font-size:18px;font-weight:bold;'>${pobDistrict}</span> In the state of <span style='font-size:18px;font-weight:bold;'>${promp('Enter state of Place of Birth')} </span> I have no documentary proof in support of my place and date of birth.<br/><br />     2. That I possess educational qualifications up to <span style='font-size:18px;font-weight:bold;'>${qualification}</span> and I am a literate person.<br/><br />           I take oath and solemnly declare/affirm that the particulars furnished by me above are correct and that I have not concealed or misrepresented any facts.     <table width='100%'>     <tr>     <td colspan='2' align='left'>     Place:     </td>     </tr>     <tr>     <td align='left'>Date:</td>     <td align='right'>Deponent: __________</td>     </tr>     </table>           <div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Verified on&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Date) that the contents of my above affidavit are true and correct to the best of my knowledge and belief and nothing in material has been concealed there from.</div>           <div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;The contents of the affidavit have been read out of me.</div>           <table width='100%'>     <tr>     <td align='right'>Deponent: __________</td>     </tr>     </table>           </div>           </div>                     ",
    "A-POB": "              <title>ANNEXURE 'A'</title>     <style type='text/css'>     body     {     font-family:Arial Verdana;     line-height:22px;     }     </style>                     <div style='width:600px' >     <div style='height:390px;' ></div>     <div style='text-align:center;font-size:18px;' ><b><u>AFFIDAVIT</u></b></div>     <div>     <br /><br />           I <span style='font-size:18px;font-weight:bold;'>${ name } ${ surname } S/o D/o W/o ${father} or ${spouse}</span> <br />     Presently residing at: <span style='font-size:18px;font-weight:bold;'> ${address = new String[2]}</span> <br />     Hereby state as follows:<br /><br />           1. That, I was born on <span style='font-size:18px;font-weight:bold;'> ${dob}</span> at <span style='font-size:18px;font-weight:bold;'>${ pob }</span> situated in the district <span style='font-size:18px;font-weight:bold;'> ${pobDistrict}</span> In the state of <span style='font-size:18px;font-weight:bold;'> ${pobState } </span> I have no documentary proof in support of my place of birth.<br /><br />     2. I am submitting this affidavit in support of my place of birth.<br /><br />           I take oath and solemnly declare/affirm that the particulars furnished by me above are correct and that I have not concealed or misrepresented any facts.           <table width='100%'>     <tr>     <td colspan='2' align='left'>     Place:........................     </td>     </tr>     <tr>     <td align='left'>Date:</td>     <td align='right'>DEPONENT: __________</td>     </tr>     </table>           <div >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Verified on&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Date) that the contents of my above affidavit are true and correct to the best of my knowledge and belief and nothing in material has been concealed there from.</div>           <div style='padding-left:40px;'>The contents of the affidavit have been read out of me.</div>           <table width='100%'>     <tr>     <td align='right'>Deponent: __________</td>     </tr>     </table>           </div>           </div>                     ",
    "I": "                        <title>Annexure I</title>                     <div style='width:700px' >     <div style='height:390px;' ></div>     <div style='text-align:center;' >     <h2><u>ANNEXURE - 'I'</u></h2>     </div>     <div>                       <ol>     <li>     NAME: <span style='font-size:14px;font-weight:bold;'> ${ name } ${ surname } ${sowodo(this)} </span><br />     Residing at: <span style='font-size:14px;font-weight:bold;'>${address },A, </span> <br />     Date of birth: <span style='font-size:14px;font-weight:bold;'>${dob}</span> <br />     <br />     (i)FATHER <span style='font-size:14px;font-weight:bold;'>${father}</span> (ii) MOTHER: <span style='font-size:14px;font-weight:bold;'>${mother}</span> <br />     (iii)HUSBAND/WIFE: <span style='font-size:14px;font-weight:bold;'>${spouse}</span> <br />     Being an application for issue of passport, do hereby solemnly affirm and state as follows:-     </li>     <li>That I am continuously resident at the above mentioned address from: <span style='font-size:14px;font-weight:bold;'> ${residingSince}</span></li>     <li>That I am citizen of India by birth/descent/registration/naturalization and that I have neither acquired the citizenship of another country nor have surrendered or been terminated/deprived of my citizenship of India.</li>     <li>That I have not, at any time during the period of five years immediately preceding the date of this affidavit, been convicted by any court in India for any offence involving moral turpitude and sentenced in respect thereof to imprisonment for not less than two years:</li>     <li>That no proceedings in respect of any criminal offence alleged to have been committed by me are pending before any criminal court in India.</li>     <li>That no warrant or summons for my appearance, and no warrant for my arrest, has been issued by a court under any law for the time being force, and that my departure from India has not been prohibited by order of any such court.</li>     <li>That I have never been repatriated from abroad back to India at the expense of Government of India/ I was repatriated from abroad back to India at the expense of Government of India.</li>     <li>That I will not engage outside India in activities prejudicial to the sovereignty and integrity of India.</li>     <li>That my departure from India will not be detrimental to the security of India.</li>     <li>That my presence outside India will not prejudice the friendly relations of India with any foreign country.</li>     </ol>                 <table width='100%'>     <tr>     <td align='left' style='padding-left:65%' >     DEPONENT     </td>     </tr>     <tr>     <td align='left' >     Verification: Verified on ................................... (Date) at .................................................................     </td>     </tr>     <tr>     <td align='left' >     (Place) that the contents of the above mentioned affidavit are true and correct and nothing material has been concealed.     </td>     </tr>     <tr>     <td align='left' style='padding-left:65%' >     DEPONENT     </td>     </tr>           </table>                 </div>           </div>                           ",
    "D": "                          <div style='width:600px' >     <div style='height:390px;' ></div>     <div style='text-align:center;font-size:20px;' >     <b><u>ANNEXURE 'D'</u></b><br /><br />     </div>     <div>     <span style='font-size:18px;font-weight:bold;'>1 ${ PP.previousNameHolder(this) }</span> (Maiden name of wife)<br /><br />     <span style='font-size:18px;font-weight:bold;'>2 ${PP.saver(spouse)}</span> (Name of husband)<br /><br />           Residing at: <span style='font-size:18px;font-weight:bold;'>${address }</span><br />     Solemnly declare and affirm as under:     <br /><br />           1. That we are married under CUSTOM Marriage Act /Customs and are living together as married couple since <span style='font-size:18px;font-weight:bold;'>${prompt('Please enter date of marriage')}</span> (date of marriage)<br /><br />     2. That <span style='font-size:18px;font-weight:bold;'>${ PP.previousNameHolder(this) }</span> (Maiden name of wife)<br /> would henceforth be known as <span style='font-size:18px;font-weight:bold;'>${ name } ${ surname }</span> (Name of wife after marriage) by virtue of our marriage.<br /><br />     3. That our joint photograph is affixed below.<br /><br />                             <table width='100%'>     <tr>     <td align='left' width='30%'>     Date:     </td>     <td align='left' >           </td>     </tr>     <tr>     <td></td>     <td align='right'>Signature & address of Deponents</td>     </tr>     <tr>     <td></td>     <td align='right'>1..............................................</td>     </tr>     <tr>     <td></td>     <td align='right'>2..............................................</td>     </tr>     </table>                 </div>           </div>                           ",
    "E": "                    <div style='width:600px' >     <div style='height:390px;' ></div>     <div style='text-align:center;' >     <h2><u>ANNEXURE 'E'</u> </h2><br />     <b>SPECIMEN AFFIDAVIT FOR CHANGE IN NAME/DEED POLL/SWORN AFFIDAVIT</b>     </div>     <div>           By this deed I, the undersigned <span style='font-size:14px;font-weight:bold;'>${ name } ${ surname }</span> (New Name) previously called <span style='font-size:14px;font-weight:bold;'>${ previousName }</span> (Old name), doing <span style='font-size:14px;font-weight:bold;'>${profession}</span> (give profession or vocation) and resident of <span style='font-size:14px;font-weight:bold;'>${address = new String[2]} </span> (address) solemnly declare:-<br />     <br />           1. That for and on behalf of myself and my wife and children and remitter issue wholly Renounce/relinquish and abandon the use of my former name/surname of <span style='font-size:14px;font-weight:bold;'>${ previousName }</span> and in place thereof I do hereby assume from this date the name/surname <span style='font-size:14px;font-weight:bold;'>${ name } ${ surname }</span> and so that I and my wife/husband, children and remitter issue may here after be called, known and distinguished not by my former name/surname, but assumed name/surname of <span style='font-size:14px;font-weight:bold;'>${ name } ${ surname }</span><br />     2. That for the purpose of evidencing such my determination declare that I shall at all times hereafter in all records, deeds and writings and in all proceedings, dealings and transactions, private as well as upon all occasions whatsoever use and sign the name of <span style='font-size:14px;font-weight:bold;'>${ name } ${ surname }</span> as my name/surname in place and in substitution of my former name/surname.<br />     3. That I expressly authorize and request all persons in general and relatives and friends in particular, at all times hereafter to designate and Address me, my wife, my children, and remitter issue by such assumed name/surname of ${ name } ${ surname } accordingly.<br />     4. In witness where of I have here unto subscribed my former and adopted name/surname of     <span style='font-size:14px;font-weight:bold;'>${ previousName }</span> and <span style='font-size:14px;font-weight:bold;'>${ name } ${ surname }</span> affix my signature and seal, if any, this ___________Day of ____________ Month & _______ of the Year.<br />     <br />     <table width='100%'>     <tr>     <td colspan='2' align='right'>     Signed sealed and delivered by the above name     </td>     </tr>     <tr>     <td colspan='2' align='left'>Date...................... </td>     </tr>     <tr>     <td align='left'>In the presence of:</td>     <td align='right'>Former name: <span style='font-size:14px;font-weight:bold;'>${ previousName }</span></td>     </tr>     <tr>     <td align='left'>Name...................... </td>     <td align='right'>Name: <span style='font-size:14px;font-weight:bold;'>${ name } ${ surname }</span></td>     </tr>     <tr>     <td colspan='2'>&nbsp;</td>     </tr>     <tr>     <td align='left'>Address....................</td>     <td align='right'>Address: <span style='font-size:14px;font-weight:bold;'>${address = new String[2]},A,</span></td>     </tr>     </table>                 </div>           </div>                     ",
    "H": "                    <title>ANNEXURE - 'H'</title>                     <div style='width:600px;padding:3px;' >     <div style='height:10px;' ></div>           <div style='text-align:center;' >     <h2><u>ANNEXURE - 'H'</u></h2><br />     DECLARATION OF APPLICANT PARENT OR GUARDIAN IF     PASSPORT IS FOR MINOR: ON PLANE PAPER     </div>     <div>           <div >           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;I / We affirm that the particulars given above are in respect of (name of the Child) <span style='font-size:18px;font-weight:bold;'>${ name } ${ surname }</span>. S/O Shri <span style='font-size:18px;font-weight:bold;'>${father}</span> And Shrimati <span style='font-size:18px;font-weight:bold;'>${mother}</span> Of whom I/ We are the Parents/ Applicant Parents/Guardians.     <br /><br />     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;He/She is a Citizen of India. His/Her date of birth <span style='font-size:18px;font-weight:bold;'>${dob}</span> Place     of Birth is <span style='font-size:18px;font-weight:bold;'>${ pob }</span> Dist. <span style='font-size:18px;font-weight:bold;'>${pobDistrict} ${pobState}</span> I/We undertake the entire responsibility for his/her expenses.     I/We solemnly declare that he / she has not lost, surrendered or been deprived of his/her     citizenship of India and that the information given in respect of him/her in this     application is true. It is also certified that I/We are holding / not holding valid     Indian passport(s) and the name of the child mentioned is not included in Passport of     either parent.     </div>     <br /><br />     <table width='100%'>     <tr>     <td align='left' width='50%'>     ...........................................     </td>     <td align='left' >     ...........................................     </td>     </tr>     <tr>     <td align='left' width='65%'>     Father (Signature)<br /><br /> <br />     </td>     <td align='left' >     Mother (Signature)<br /><br /><br />     </td>     </tr>     <tr>     <td align='left' >     OR........................................     </td>     <td align='left' >     Legal Guardian (Signature)     </td>     </tr>     </table>                 </div>           </div>                           ",
    "ThanaVC": "              <table cellpadding='7' width='600px' >     <tr>     <td colspan='3' align='center'>     <h2>     <u >ANNEXURE - 'F'<br />     VERIFICATION CERTIFICATE</u>     </h2>     </td>     </tr>     <tr>     <td></td>     <td colspan='2' align='right' >     Ref:______________           </td>     </tr>     <tr>     <td></td>     <td colspan='2' align='right' >     Date:______________           </td>     </tr>     <tr>     <td style='padding-top:60px;' colspan='3' >     This is to certify that <span style='font-size:18px;font-weight:bold;'> ${ name } ${ surname } S/o D/o W/o ${father} or ${spouse} </span>     Whose personal particulars are given below has good moral character and reputation and that after having read the provisions of section 6 (2) of the passports Act 1967. I certify that these provisions are not attracted in case of this applicant and I recommend issue of an Indian passport to him/her. Applicant has been staying at his/her address continuously last one year.     </td>     </tr>     <tr>     <td style='font-size:18px;'>Date of Birth </td>     <td>:</td>     <td><span style='font-size:18px;font-weight:bold;'> ${ dob } </span></td>     </tr>     <tr>     <td style='font-size:18px;'>Place of Birth</td>     <td>:</td>     <td><span style='font-size:18px;font-weight:bold;'>${ pob } DISTT. ${ (pobDistrict } )</span></td>     </tr>     <tr>     <td style='font-size:18px;'>Educational Qualification</td>     <td>:</td>     <td><span style='font-size:18px;font-weight:bold;'>${qualification}</span></td>     </tr>     <tr>     <td style='font-size:18px;'>Profession: (Govt. /Private<br />Service/Others)</td>     <td>:</td>     <td><span style='font-size:18px;font-weight:bold;'>${profession}</span></td>     </tr>     <tr>     <td style='font-size:18px;'>Present Address</td>     <td>:</td>     <td><span style='font-size:18px;font-weight:bold;'> ${address = new String[2]}</span></td>     </tr>     <tr>     <td style='font-size:18px;'>Permanent Address</td>     <td>:</td>     <td><span style='font-size:18px;font-weight:bold;'>${ permAddress = new String[2]}</span></td>     </tr>     <tr>     <td colspan='3'>&nbsp;<br /></td>     </tr>     <tr>     <td style='font-size:18px;' valign='top' >PLACE: </td>     <td></td>     <td style='font-size:18px;' valign='top' >     SIGNATURE:-<br />     Full Name: <br />     ID Card No.:<br />     Designation <br />     Tel. No. (O): <br />     MOB.NO.: <br />     </td>     </tr>     </table>                     ",
    "B": "       <div style='width:700px'> <div style='text-align:center;'> <b>OFFICE OF THE ADDILTIONAL DG OF POLICE (ADMIN.)</b><br /> <b>POLICE HEADQUARTERS M.P. BHOPAL</b><br /> <table width='100%' cellpadding='3'> <tr> <td width='75%' align='left' style='padding-left:40px;'> Ref. No. </td> <td align='left'> Date </td> </tr> </table> <b>Annexure 'B'</b><br /> <br /> </div> <div> Certified that ${ name } ${ surname } ${sowodo(this)} of is a temporary/permanent employee of this office- DISTRICT POLICE INDORE from 14/03/2004 (Date) and is at present holding the post of INSPECTOR of Police. ${ name } is/are a dependent family member(s) of ${father} and his/her identity is certified. This Ministry/Department/Organization has no objection to his/her acquiring Indian Passport. The undersigned is duly authorized to sign this Identity Certificate. I have read the provisions of Section 6(2) of the Passports Act, 1967 and certify that these are not attracted in case of this applicant. I recommend issue of an Indian Passport to him/her. It is certified that this organization is a central / State Government / Public Sector / undertaking / statutory body. The Identity Card Number of Shri/Smt (employee) ${ name } is DT. 31/03/2005 <br /><br /> <table width='100%'> <tr> <td align='left' width='65%'></td> <td align='left'> INSPECTOR GENERAL OF POLICE<br /> INDORE ZONE, INDORE (M.P.)<br /> OFFICE TEL NO: </td> </tr> </table> </div> </div>   "
};




$(document).ready(function () {
	$.each(PP.DOCS, function(key, value){
		$("#docCardContainer > p").append($('<input>', {type:'button', 'data-docName':key, class:"docMarker",  value:key, rel:"#docContainer"}));
	});
	
	
	$(".docMarker input[rel]").overlay({
        //effect: 'apple'
    });
	//$("#docArea").ckeditor();
    $(".timestamp").datepicker("option", "maxdate", "+1m");

    $("#loggedAtFromUI").datepicker("option", "altField", "#loggedAtFrom");
    $("#loggedAtToUI").datepicker("option", "altField", "#loggedAtTo");
    $("#submittedAtFromUI").datepicker("option", "altField", "#submittedAtFrom");
    $("#submittedAtToUI").datepicker("option", "altField", "#submittedAtTo");

    $(".date").keyup(function (event) {
        if (!$(this).val().length > 0) {
            $($(this).datepicker("option", "altField")).val("");
        }
    }).blur(function () {
        if (!$(this).val().length > 0) $($(this).datepicker("option", "altField")).val("");
    });

    $(".rs").live('mouseover', function (e) {
        //event.preventDefault();
    	//console.log();
       $('.AppData').text(JSON.stringify($.tmplItem($(this))['data']));
    });

    $('#searchForm').bind('submit', function (e) {
        e.preventDefault(); // <-- important
        $(".msg").fadeOut();
        //$("#resultContainer").fadeOut("fast");
        //if(!validated()) {alert("Please enter at least one search criterion");return false;}
        $(this).ajaxSubmit({
            //target: '#output',
            async: false,
            dataType: "json",
            resetForm: false,
            success: PP.fetched,
            error: function () {
                $(".msg").text("Request Failed!").fadeIn("fast");
            }
        });
    });

    var resultTemplate = "<div data-app =" + '${this}' + " class='rs' style='border:5px solid black; width:950px; height:150px'><strong>Form Id: <span class='formId'>${formId}</span></strong>" + "<img src='/folder-docs.png' class='doc-icon'/>" +
    //"<a href='https://passport.gov.in/pms/${onlineFileNo}/pdf' target='_blank' ${PP.pdfLink(onlineFileNo)}><img src='/pdf.png'/></a>" +
    " <br/>Applicant Name: ${name} ${surname} Date of Birth: ${dob} " + "District: ${districts[poId][districtId]}<br/>Contact Number: ${mob} Email Id: ${email }Agent: ${agent}  Sub Agent: ${subAgent} " + "Submission Date: ${submittedAt}<br/>Logged by: ${loggedBy} Logged At: ${PP.getLocalDate(loggedAt)}</div>";
    
    $.template("resultset", resultTemplate);
    	//console.log("doc marker clicked");
    $(".docMarker").live("click", function(e){
    	if(PP.editor) PP.editor.destroy();
    	var app = JSON.parse($(".AppData").text());
        $('#docArea').empty();
        console.log($.tmpl($(e.target).attr('data-docName'), app, app));
        $.tmpl($(e.target).attr('data-docName'), app, app).appendTo("#docArea");
        PP.editor = CKEDITOR.replace('docArea',{height : '480', width : '850', skin : "office2003"});
        /*for (instance in CKEDITOR.instances) {
            CKEDITOR.instances[instance].updateElement();
        }*/
    });
    
    $.each(PP.DOCS, function (key, value) {
		 $.template(key, value);
	});
});


PP.fetched = function (data, status, xhr, elem) {
    console.log("FETCHED");
    if (xhr.status == 200) {
        //var container = $("#resultContainer");
        $(".msg").text(data.msg).fadeIn("fast");
        if (data.Found) {
            console.log("FOUND");
            $(".rs").remove();
            $("#resultContainer").html("");
            console.log("rs container emptied");

            $.tmpl("resultset", data.rs, data.rs).appendTo('#resultContainer').slideDown(1000, function () {
                console.log("APPENDING rs");
            });
            console.log("APPENDED");

            $('.doc-icon').hovercard({
                detailsHTML: $("#docCardContainer").html(),
                width: 400
            });
            $("#resultContainer").slideDown(5000, function () {
                document.getElementById("topview").scrollIntoView(true);
            });
            console.log("intoview");
        }

    } else {
        $(".msg").text("Request Failed");
    }
}
PP.getLocalDate = function (dateString) {
    console.log("dateString: " + dateString);
    return (new Date(dateString)).toLocaleDateString();
}
PP.pdfLink = function (olno) {
    if (!olno) return "hidden";
    return "";
}
PP.sowodo = function (app) {
    if (app.sex.toLowerCase() == 'm') return 's/o ' + app.father;
    else if (app.sex.toLowerCase() == 'f') {
        if (app.spouse && app.spouse != 'undefined') return 'w/o ' + app.spouse;
        else return 'w/o ' + app.spouse;
    }
}

PP.previousNameHolder = function(app){
	if(app.previousName && app.previousName != 'undefined') return app.previousName;
	else return app.name+" "+app.surname;
	
}

PP.saver = function(name){
	return name || "";
}