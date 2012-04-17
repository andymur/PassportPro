var districts ={
		'AHD': {"1":"AHMEDABAD","2":"AHMEDABAD - RURAL","3":"AMRELI  ","4":"ANAND  ","5":"BANASKANTHA ","6":"BARODA     ","7":"BARODA - RURAL","9":"BHAVNAGAR","29":"DAHOD","10":"DAMAN AND  DIU (UT)","12":"GANDHINAGAR","13":"JAMNAGAR","14":"JUNAGUDH","15":"KHEDA","16":"KUTCH","17":"MAHESENA","27":"PANCHMAHALS","18":"PATAN","19":"PORBANDAR","20":"RAJKOT","21":"RAJKOT - RURAL","22":"SABARKANTHA","25":"SURENDRANAGAR"},
     	'BPL': {"66":"ALIRAJPUR","63":"ANUPPUR","64":"ASHOK NAGAR","1":"BADWANI","2":"BALAGHAT","4":"BETUL","5":"BHIND","6":"BHOPAL","65":"BURHANPUR","8":"CHHATARPUR","9":"CHHINDWARA","10":"DAMOH","12":"DATIA","13":"DEWAS","15":"DHAR","16":"DINDORI","18":"GUNA","19":"GWALIOR","20":"HARDA","21":"HOSHANGABAD","22":"INDORE","23":"JABALPUR","26":"JHABUA","28":"KATNI","30":"KHANDWA","31":"KHARGONE","34":"MANDLA","35":"MANDSAUR","37":"MORENA","38":"NARSINGHPUR","39":"NEEMUCH","40":"PANNA","43":"RAISEN","44":"RAJGARH","46":"RATLAM","47":"REWA","48":"SAGAR","49":"SATNA","50":"SEHORE","51":"SEONI","52":"SHAHDOL","53":"SHAJAPUR","54":"SHEOPUR","55":"SHIVPURI","56":"SIDHI","67":"SINGRAULI","58":"TIKAMGARH","59":"UJJAIN","60":"UMARIYA","61":"VIDISHA"},
     	'BHU': {"1":"ANGUL","3":"BALASORE","6":"BARAGARH","2":"BERHAMPUR","5":"BHADRAK","34":"BHUBANESWAR CITY","4":"BOLANGIR","7":"BOUDH","8":"CUTTACK","35":"CUTTACK CITY","10":"DEOGARH","9":"DHENKANAL","12":"GAJAPATI","11":"GANJAM ","13":"JAGATSINGHPUR ","14":"JAJPUR ","15":"JHARSUGUDA ","33":"KALAHAND","19":"KANDHAMALA ","17":"KENDRAPARA ","32":"KEONJHAR ","16":"KHURDA ","18":"KORAPUT ","21":"MALKANGIRI ","20":"MAYURBHANJ ","24":"NAWARANGPUR ","22":"NAYAGARH ","23":"NUAPADA ","26":"PHULBANI ","25":"PURI ","28":"RAYAGADA ","27":"ROURKELA ","29":"SAMBALPUR ","31":"SONEPUR ","30":"SUDARGARH "},
     	'COC': {"3":" ALLEPPEY","1":" ERNAKULAM CITY","2":" ERNAKULAM RURAL","4":" IDUKKI","5":" KOTTAYAM","6":" LAKSHADWEEP","7":"TRICHUR CITY","8":"TRICHUR RURAL"},
     	'DLH': {"1":" NEW DELHI","3":"FARIDABAD","2":"GURGAON","9":"JHAJJAR","7":"MAHENDERGARH","8":"NUH","6":"REWARI","4":"ROHTAK","5":"SONIPET"},
     	'GZB': {"11":"AGRA","12":"ALIGARH","13":"BAGPAT","14":"BULANDSHAR","10":"GHAZIABAD ","15":"HATHRAS","16":"MATHURA","17":"MEERUT","18":"MUZZAFRNAGER","19":"NOIDA","20":"SAHARANPUR"},
     	'GUW': {"28":"1682FPO-RANGIA-21MDPU","44":"694FP0-TENGA-5MDPU","29":"784FPO-DINJEN-2MDPU","78":"832FPO-SHILLONG-101AREAPU","60":"939FPO-DIMAPUR-3CORPSPU","81":"AIZAWL ","47":"ANJAW","26":"BAKSA","14":"BARPETA","70":"BISHNUPUR","15":"BONGAIGAON","19":"CACHAR ","86":"CHAMPHAI","65":"CHANDAL","38":"CHANGLANG","83":"CHHIMTUIPUI","27":"CHIRANG ","55":"CHUMUKIDEMA","61":"CHURACHANDPUR ","12":"DARRANG","9":"DHEMAJI","16":"DHUBRI ","36":"DIBANG VALLEY","2":"DIBRUGARH","52":"DIMAPUR","74":"EAST GARO HILLS","43":"EAST KAMENG","71":"EAST KHASI HILLS","34":"EAST SIANG","18":"GOALPARA ","5":"GOLAGHAT","24":"GUWAHATI CITY ","21":"HAILAKANDI ","62":"IMPHAL EAST ","63":"IMPHAL WEST","73":"JAINTIA HILLS","69":"JIRIBAM","4":"JORHAT","8":"KAMRUP","23":"KARBI ANGLONG ","20":"KARIMGANJ ","92":"KEPHRIE","51":"KOHIMA","17":"KOKRAJHAR ","85":"KOLASIB","46":"KURUNG KURNEY","88":"LAWNGTLAI","33":"LOHIT","93":"LONGLENG","45":"LOWER DIBANG VALLEY","35":"LOWER SUBANSIRI","82":"LUNGLEI","87":"MAMIT","53":"MOKOKCHUNG","56":"MON","7":"MORIGAON ","6":"NAGAON","13":"NALBARI","22":"NORTH CACHAR HILLS","10":"NORTH LAKHIMPUR","32":"PAPUMPARE","91":"PEREN","58":"PHEK","75":"RI BHOI DIST","90":"SADAR HILLS","89":"SAIHA","64":"SENAPATI","84":"SERCHHIP","3":"SIBSAGAR","11":"SONITPUR","77":"SOUTH GARO HILLS","67":"TAMENGLONG ","42":"TAWANG","66":"THOUBAL","1":"TINSUKIA","37":"TIRAP","57":"TUENSANG","25":"UDALGURI ","68":"UKHRUL","39":"UPPER SIANG","41":"UPPER SUBANSIRI","76":"WEST GARO HILLS ","31":"WEST KAMENG","72":"WEST KHASI HILLS","40":"WEST SIANG","54":"WOKHA","59":"ZUNHEBOTO"},
     	'HYD': {"1":"ADILABAD","2":"ANANTAPUR","3":"CHITTOOR","4":"CUDDAPAH","19":"CYBERABAD ","6":"GUNTUR ","7":"HYDERABAD ","8":"KARIMNAGAR ","9":"KHAMMAM ","10":"KRISHNA ","11":"KURNOOL ","12":"MAHBOOBNAGAR ","13":"MEDAK ","14":"NALGONDA ","15":"NELLORE ","16":"NIZAMABAD ","17":"PRAKASAM ","18":"RANGAREDDY ","24":"VIJAYAWADA ","22":"WARANGAL ","5":"YANAM"},
     	'JPR': {"1":"AJMER","2":"ALWAR","3":"BANSWARA","4":"BARAN","5":"BARMER","6":"BHARATPUR","7":"BHILWARA","8":"BIKANER","9":"BUNDI","10":"CHITTORGARH","11":"CHURU","12":"DAUSA","13":"DHOLPUR","14":"DUNGARPUR","15":"HANUMANGARH","17":"JAIPUR","32":"JAIPUR- RURAL","16":"JAISALMER","18":"JALORE","19":"JHALAWAR","20":"JHUNJHUNU","21":"JODHPUR","33":"KAROLI","22":"KOTA","23":"NAGAUR","24":"PALI","34":"PRATAPGARH","25":"RAJSAMAND","26":"SAWAI MADHOPUR","27":"SIKAR","28":"SIROHI","29":"SRIGANGANAGAR","30":"TONK","31":"UDAIPUR"},
     	'JAL': {"11":"Hoshiarpur","10":"Jalandhar","15":"Kapurthala ","12":"Nawanshahar"},
     	'JMU': {"2":"DODA","1":"JAMMU","3":"KATHUA","9":"KISHTWAR","4":"POONCH","5":"RAJOURI","8":"RAMBAN","10":"REASI","7":"SAMBA","6":"UDHAMPUR"},
     	'CAL': {"5":"24-PARAGANAS-N","4":"24-PARAGANAS-S","10":"BANKURA ","8":"BIRBHUM ","9":"BURDWAN ","16":"COOCHBIHAR ","15":"DARJEELING ","17":"DINAJPUR-N ","18":"DINAJPUR-S ","3":"HOOGHLY","2":"HOWRAH","14":"JALPAIGURI ","1":"KOLKATA SB","12":"MALDAH ","21":"MEDINIPUR-EAST","22":"MEDINIPUR-WEST","13":"MURSHIDABAD ","6":"NADIA ","11":"PURULIA ","19":"SIKKIM ","20":"TRIPURA "},
     	'KOZ': {"6":"KANNUR","8":"KASRAGOD ","1":"KOZHIKODE","2":"KOZHIKODE RURAL","5":"MAHE-UT","7":"WAYNAD"},
     	'LKO': {"1":"ALLAHABAD","40":"AMBEDKARNAGAR","47":"AURAIYA","2":"AZAMGARH","3":"BAHRAICH","4":"BALLIA","41":"BALRAMPUR","7":"BANDA","6":"BARABANKI","5":"BASTI","8":"BHADOHI","42":"CHANDAULI","49":"CHHATRAPATI SAHUJI MAHRAJ NAGAR","48":"CHITRAKUT","9":"DEORIA","10":"ETAWAH","11":"FAIZABAD","12":"FARRUKHABAD","13":"FATEHPUR","14":"GHAZIPUR","16":"GONDA","15":"GORAKHPUR","18":"HAMIRPUR","17":"HARDOI","21":"JALAUN","19":"JAUNPUR","20":"JHANSI","44":"KANNAUJ","22":"KANPUR","46":"KAUSHAMBHI","31":"KUSHINAGAR","24":"LAKHIMPUR","25":"LALITPUR","26":"LUCKNOW","27":"MAHARAJGANJ","39":"MAHOBA","28":"MAU","29":"MIRZAPUR","30":"PRATAPGARH","32":"RAEBARELI","23":"RAMABAI NAGAR","43":"SANT KABIRNAGAR","45":"SHRAWASTI","35":"SIDDARTHNAGAR","34":"SITAPUR","36":"SONBHADRA","33":"SULTANPUR","37":"UNNAO ","38":"VARANASI"},
     	'BOM': {"4":"AURANGABAD","5":"BEED","19":"DAD NAG HAVELI","14":"DAMAN","1":"MUMBAI","7":"RATNAGIRI","13":"SINDHUDURG"},
     	'PAT': {"1":"ARARIA","60":"ARWAL","2":"AURANGABAD","3":"BANKA","4":"BEGUSARAI","5":"BHABHUA","6":"BHAGALPUR","7":"BHOJPUR ","9":"BUXAR","11":"DARBHANGA","15":"EAST CHAMPARAN","18":"GAYA","21":"GOPALGANJ","24":"JAMUI","25":"JEHANABAD ","26":"KAIMUR","27":"KATIHAR ","28":"KHAGARIA","29":"KISHANGANJ","31":"LAKHISARAI","34":"MADHEPURA","35":"MADHUBANI","36":"MUNGER","37":"MUZAFFARPUR","38":"NALANDA","39":"NAWADA","42":"PATNA","43":"PURNEA","45":"ROHTAS","46":"SAHARSA","48":"SAMASTIPUR","49":"SARAN","51":"SHEIKHPURA","52":"SHEOHAR","54":"SITAMARHI","55":"SIWAN","57":"VAISHALI","58":"WEST CHAMPARAN"},
     	'SUR': {"3":"BHARUCH","7":"DANGS","5":"NARMADA","6":"NAVSARI","1":"SURAT CITY","2":"SURAT RURAL","10":"TAPI","4":"VALSAD"},
     	'ASR': {"13":"AMRITSAR","16":"BATALA","15":"FARIDKOT","20":"FEROZEPUR","14":"GURDASPUR","17":"MAJITHA","37":"MUKTSAR","18":"TARN TARAN"},
     	'BLY': {"2":"BADAUN","1":"BAREILLY","14":"BIJNOR","3":"ETAH","28":"FIROZABAD","11":"JYOTI BA PHULE NAGAR","32":"KANSHIRAM NAGAR","27":"MAINPURI","15":"MORADABAD","18":"PILIBHIT","16":"RAMPUR","17":"SHAHJAHANPUR"},
     	'DND': {"23":"ALMORA","30":"BAGESHWAR","29":"CHAMOLI","25":"CHAMPAWAT","13":"DEHRADUN","12":"HARIDWAR","20":"NANITAL","21":"PAURI GARHWAL","24":"PITHORAGARH","31":"RUDRA PRAYAG","22":"TEHRI GARHWAL","19":"UDHAM SINGH NAGAR","26":"UTTAR KASHI"},
     	'MLP': {"1":"MALAPPURAM","2":"PALKAAD"},
     	'NGP': {"9":"AKOLA ","7":"AMRAVATI","2":"BHANDARA","11":"BULDANA ","5":"CHANDRAPUR","18":"DRUG ","4":"GADCHIROLI","3":"GONDIA","12":"HINGOLI ","15":"JALNA ","16":"LATUR ","1":"NAGPUR","13":"NANDED ","17":"OSMANABAD ","14":"PARBHANI ","6":"WARDHA ","10":"WASHIM ","8":"YAWATMA "},
     	'GOA': {"10":"NORTH GOA","11":"SOUTH GOA"},
     	'PNE': {"9":"AHMEDNAGAR","16":"KOLHAPUR","2":"PUNE","10":"SANGLI","11":"SATARA","12":"SOLAPUR"},
     	'RPR': {"3":"BASTAR","7":"BILASPUR ","11":"DANTEWADA","14":"DHAMTARI","17":"DURG","24":"JANJGIR","25":"JASHPUR","27":"KANKER ","29":"KAWARDHA ","32":"KORBA","33":"KORIYA","36":"MAHASAMUND","41":"RAIGARH","42":"RAIPUR","45":"RAJNANDGAON","57":"SARGUJA"},
     	'RCH': {"2":"BOKARO","13":"CHATRA","8":"DEOGHAR","6":"DHANBAD","7":"DUMKA","3":"EAST SINGHBHUM","11":"GARHWA","19":"GIRIDIH","10":"GODDA","17":"GUMLA","5":"HAZARIBAGH","15":"JAMTARA","23":"KHUNTI","21":"KODERMA","12":"LATEHAR","14":"LOHARDAGGA","9":"PAKUR","18":"PALAMU","24":"RAMGARH","1":"RANCHI","22":"SAHIBGANJ","16":"SARAIKELA-KHARSWA","20":"SIMDEGA ","4":"WEST SINGHBHUM "},
     	'SML': {"13":"BILASPUR","17":"CHAMBA","21":"HAMIRPUR","25":"KANGRA","29":"KINNAUR","27":"KULLU","33":"LAHULSPITI","38":"MANDI","46":"SHIMLA","47":"SIRAMAUR","45":"SOLAN","49":"UNA"},
     	'SGR': {"4":"ANANTNAG","2":"BADGAM","9":"BANDIPORA","3":"BARAMULLA","10":"GANDERBAL","8":"KARGIL ","11":"KULGAM","6":"KUPWARA ","7":"LEH ","5":"PULWAMA","12":"SHOPIAN","1":"SRINAGAR"},
     	'THN': {"6":"DHULE","15":"JALGAON","20":"NANDURBAR","17":"NASIK","18":"NAVI MUMBAI","8":"RAIGAD","3":"THANE CITY","23":"THANE RURAL"},
     	'TVM': {"4":" PATHANAMTHITTA","1":" TVM-CITY ","2":" TVM-RURAL ","3":"KOLLAM CITY","5":"KOLLAM RURAL"}
     };
(function( $ ) {
		$.widget( "ui.combobox", {
			_create: function() {
				var self = this,
					select = this.element.hide(),
					selected = select.children( ":selected" ),
					value = selected.val() ? selected.text() : "";
				var input = this.input = $( "<input>" )
					.insertAfter( select )
					.val( value )
					.autocomplete({
						delay: 0,
						minLength: 0,
						source: function( request, response ) {
							var matcher = new RegExp( $.ui.autocomplete.escapeRegex(request.term), "i" );
							response( select.children( "option" ).map(function() {
								var text = $( this ).text();
								if ( this.value && ( !request.term || matcher.test(text) ) )
									return {
										label: text.replace(
											new RegExp(
												"(?![^&;]+;)(?!<[^<>]*)(" +
												$.ui.autocomplete.escapeRegex(request.term) +
												")(?![^<>]*>)(?![^&;]+;)", "gi"
											), "<strong>$1</strong>" ),
										value: text,
										option: this
									};
							}) );
						},
						select: function( event, ui ) {
							ui.item.option.selected = true;
							self._trigger( "selected", event, {
								item: ui.item.option
							});
						},
						change: function( event, ui ) {
							if ( !ui.item ) {
								var matcher = new RegExp( "^" + $.ui.autocomplete.escapeRegex( $(this).val() ) + "$", "i" ),
									valid = false;
								select.children( "option" ).each(function() {
									if ( $( this ).text().match( matcher ) ) {
										this.selected = valid = true;
										return false;
									}
								});
								if ( !valid ) {
									// remove invalid value, as it didn't match anything
									$( this ).val( "" );
									select.val( "" );
									input.data( "autocomplete" ).term = "";
									return false;
								}
							}
						}
					})
					.addClass( "ui-widget ui-widget-content ui-corner-left" );

				input.data( "autocomplete" )._renderItem = function( ul, item ) {
					return $( "<li></li>" )
						.data( "item.autocomplete", item )
						.append( "<a>" + item.label + "</a>" )
						.appendTo( ul );
				};

				this.button = $( "<button type='button'>&nbsp;</button>" )
					.attr( "tabIndex", -1 )
					.attr( "title", "Show All Items" )
					.insertAfter( input )
					.button({
						icons: {
							primary: "ui-icon-triangle-1-s"
						},
						text: false
					})
					.removeClass( "ui-corner-all" )
					.addClass( "ui-corner-right ui-button-icon" )
					.click(function() {
						// close if already visible
						if ( input.autocomplete( "widget" ).is( ":visible" ) ) {
							input.autocomplete( "close" );
							return;
						}

						// work around a bug (likely same cause as #5265)
						$( this ).blur();

						// pass empty string as value to search for, displaying all results
						input.autocomplete( "search", "" );
						input.focus();
					});
			},

			destroy: function() {
				this.input.remove();
				this.button.remove();
				this.element.show();
				$.Widget.prototype.destroy.call( this );
			}
		});
	})( jQuery );	

$(document).ready(function(){	
	var addressCopy = true;
	$("#subAgentDialogue").dialog({
		autoOpen: false,
		modal: true,
		height: 550,
		width: 515,
		buttons: {Close: function(){$( this ).dialog( "close" );}}
	});
	$("#agentDialogue").dialog({
		autoOpen: false,
		modal: true,
		height: 250,
		width: 450,
		buttons: {Close: function(){$( this ).dialog( "close" );}}
	});
	$("#msgdialog").dialog({
		autoOpen: false,
		modal: true,
		buttons: {Ok: function(){$( this ).dialog( "close" );}}
	});
	$("#tabsWrapper").tabs({selected:1});
	
	$("#Sub-AgentTabs").tabs();
	$(".date").datepicker({
		constrainInput: true,
		changeMonth: true,	// Drop down for month
		changeYear: true,	// Drop down for year
		minDate: "-100Y",	// Oldest date is 90 years old
		maxDate: 0,			// Latest date todays date   
		constrainInput: true, 	//  
		yearRange: '1900:2100',	// Year range in year dropdown
		dateFormat: "dd/mm/yy",
		altFormat: "@"
	});	//Invoke datepicker
	
	
	//Append '/' after day and month 
	$(".date").keyup(function(){
		if ($(this).val().length==2 || $(this).val().length==5){			
			$(this).val($(this).val()+"/");
		}
	});
	
	//Combobox
	$( ".combobox" ).combobox();
	
	// Previousname is disabled by default
	//$("#previousName").attr("disabled",true); 
	
	//Name change Toggle
	$("#isNameChanged").click(function() {
		// If checked
		if ($(this).is(":checked"))	{
			$("#previousName").removeAttr("disabled");
		} 
		else {
			$("#previousName").val('').attr("disabled", true);
		}
	});
	
	//Radios
	$( ".radio" ).buttonset();
	$( "input:submit, input:reset, input:button" ).button();
	
	$("#add").button({
		icons: {primary: "ui-icon-circle-plus"}
	}).click(function(e){
		e.preventDefault(); 
		if(document.getElementById("type").name == "Agent"){ console.log("Agent"); $("#subAgentDialogue").dialog("open");}
		else if (document.getElementById("type").name == "Sub-Agent"){console.log("SUBAGENT"); $("#agentDialogue").dialog("open");}
	});
	//Verifiable
/*	$('#applicationForm').verifiable(
	          {
	            complete: function () {
	              $('#applicationForm input[type=submit]').removeAttr('disabled');
	            },
	            incomplete: function () {
	              $('#applicationForm input[type=submit]').attr('disabled', 'disabled');
	            },
	            goodValue: function (field) {
	              field.css('background', '#000000');
	            },
	            badValue: function (field) {
	              field.css('background', '#ff9999');
	            }
	          },
	          {
	            'textOnly' : function (fieldValue) {
	              return (/^([A-Za-z])$/).test(fieldValue);
	            }
	          }
	        );*/

	//Convert to Upper Case
	try{
		$('.bestupper').bestupper();	
	}catch(e){}
	
	
	
	//COPY Address
	/*$('#presadd1').keyup(function(){
		$('#permadd1').val($(this).val());
	});
	$('#presadd2').keyup(function(){
		$('#permadd2').val($(this).val());
	});
	$('#presadd3').keyup(function(){
		$('#permadd3').val($(this).val());
	});*/
	$('.replicate').keyup(function copy(){
		if(addressCopy){
			$('#permadd1').val($('#presadd1').val());
			$('#permadd2').val($('#presadd2').val());
			$('#permadd3').val($('#presadd3').val());
		}
	});
	//$('.replicate').keyup(copy());
	
	//Show Old Passport Fields
	$('input[name="isRenew"]').click(function(){
		if ($(this).is(':checked')){
			$('#oldPassport').slideDown('slow');
		}
		else $('#oldPassport').slideUp('slow');
	});
	
	// Load Passport Office
	$('#PIA').combobox({
		maxheight: '100px',
		selected: function(e,u){
					$('#district').html("<option id='firstOpt' value='!valid'>Select District</option>");
					$.each(districts[$(this).val()], function(key, value){
						$('#district').append("<option value='"+key+"'>"+value+"</option>");
					});
				}
	});
	/********************************************/
	
	$("#subAgentSendRequest").click(function(e){
		e.preventDefault();
		$(".msg").text("");
		var id = $("#subAgentId").val();
		if(id =="") {alert("Please enter an Id");return;}
		var regexp = /^\d+$/;
		if(!regexp.test(id)) {alert("Only Numbers accepted in Id");return;}
		var url = "/desk/add.do?type=subagent&id="+id;
		var data=add(url);
	});
	$("#addProxySubAgent").click(function(e){
		e.preventDefault();
		$("#msg").text("");
		var name = $("#proxySubAgentName").val();
		var spoc = $("#subAgentSpoc").val();
		var address = $("#address").val();
		var phone = $("#subAgentPhone").val();
		var cell = $("#subAgentCell").val();
		var email = $("#subAgentEmail").val();
		
		if(name =="") {alert("Please enter a name");return;}
		var regexp = /^(?=[^ ]* ?[^ ]*(?: [^ ]*)?$)(?=[^-]*-?[^-]*$)(?=[^,]*,?[^,]*$)[a-zA-Z ,-]*$/;
		if(!regexp.test(name)) {alert("Only Alphabets accepted in Name, minimum 3 characters long, max 25 characters");return;}
		var url = "/desk/add.do?type=proxy&name="+name+"&spoc="+spoc+"&address="+address+"&phone="+phone+"&cell="+cell+"&email="+email;
		var data = add(url);
		if(data.id && data.name && data["status"]=="SUCCESS"){
			$("#opposite").append("<option value="+data.id+">"+data.name+"</option>");
		}
	});

	$("#agentSendRequest").click(function(e){
		e.preventDefault();
		$("#msg").text("");
		var id = $("#agentId").val();
		if(id =="") {alert("Please enter an Id");return;}
		var regexp = /^\d+$/;
		if(!regexp.test(id)) {alert("Only Numbers accepted in Id");return;}
		var url = "/desk/add.do?type=agent&id="+id;
		var data=add(url);
	});
	
	function add(url){
		try{
			$.getJSON(url, function(data) {
				//console.log(data);
				$(".dialog").dialog("close");
				//$(".din").clearForm();
				$("#msgdialog").text(""+data.status+":"+data.message);
				$("#msgdialog").dialog("open");
				return data;
			});
		}catch(e){$("#msgdialog").text(e);$("#msgdialog").dialog("open");}
	}
	// FORM SUBMIT AJAXIFY
	$('#applicationForm').bind('submit', function(e) {
		e.preventDefault(); // <-- important
		
		$(this).ajaxSubmit({
			beforeSubmit: validated,
			dataType: "json",
			resetForm: "true",
			success: successfullySubmitted
		});
	});
	

	//});
	// MARITAL STATUS
	$("#maritalStatus").change(function(){
		if ($(this).val()!="!valid" && $(this).val()!="S" ){ 
			$(".spouse").removeClass("hidden").removeAttr("disabled").attr('required','required');
		}
		else {
			$(".spouse").addClass("hidden").attr('disabled',true);
			$("#spouse").val("").removeAttr('required');
		}
	});
	//PREVIOUS ADDRESS
	$("#isAddChange").click(function(){
		$(".prev").val("");
		$(this).is(":checked") ? $(".prevAddressFields").slideDown('slow').removeAttr('disabled') :
			$(".prevAddressFields").slideUp('slow').attr('disabled',true);
	});
	
	$("#isDD").click(function(){
		$('.dd').val('');$(this).is(':checked')?
				$('.ddD').slideDown('slow').removeAttr('disabled').attr('required','required'):
					$('.ddD').slideUp().attr('disabled',true).removeAttr('required');
	});
	

});


function validated(){
	var dropdowns = $("select");
	console.log(dropdowns);
	var flag=true;
	var i=0;
	for(;i<dropdowns.length;i++){
		if(dropdowns[i].value=="!valid"){
			flag=false;
			dropdowns[i].classList.add("ui-state-error");
			//dropdowns[i].prepend('<span class="ui-icon ui-icon-alert" style="float: left; margin-right: .3em;"></span>');
		}
		else{
			dropdowns[i].classList.remove("ui-state-error");
		}
	}
	return flag;
}

function successfullySubmitted (app, status, xhr, elem){

	$("#submitted > .name").text(app.name+" "+app.surname);
	$("#submitted > .id").text(app["formId"]);
	$(".visibility").toggleClass("hidden");
	//$("#submitted").scrollIntoView();
}













