
	// COMBO BOX
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

/*	$(function() {
		$( "#combobox" ).combobox();
		$( "#toggle" ).click(function() {
			$( "#combobox" ).toggle();
		});
	});*/
	
	
	

$(document).ready(function(){	
	var addressCopy = true;
	$(".date").datepicker({

		changeMonth: true,	// Drop down for month
		changeYear: true,	// Drop down for year
		minDate: "-100Y",	// Oldest date is 90 years old
		maxDate: 0,			// Latest date todays date   
		constrainInput: true, 	//  
		yearRange: '1900:2100'	// Year range in year dropdown

	});	//Invoke datepicker
	$(".date").datepicker( "option", "dateFormat", "dd/mm/yy" ); //Format Date dd/mm/yyyy
	
	
	//Append '/' after day and month 
	$(".date").keyup(function(){
		if ($(this).val().length==2 ||$(this).val().length==5){			
			$(this).val($(this).val()+"/");
		}
	});
	
	//Combobox
	$( ".combobox" ).combobox();
	
	// Previousname is disabled by default
	$("#previousName").attr("disabled",true); 
	
	//Name change Toggle
	$("#isNameChanged").button().click(function() {
		// If checked
		if ($("#isNameChanged").is(":checked"))	{
			$("#previousName").removeAttr("disabled");
		} 
		else {
			$("#previousName").val('');
			$("#previousName").attr("disabled", true);
		}
	});
	
	//Radios
	$( ".radio" ).buttonset();
	$( "input:submit, input:reset", ".demo" ).button();

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
	$('.bestupper').bestupper();	
	
	
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
	$('#service').change(function(){
		if ($(this).val() == 12 || $(this).val() == 14){
			$('#oldPassport').show();
		}
		else $('#oldPassport').hide();
	});
	
	

});
