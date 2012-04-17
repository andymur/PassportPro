$(function(){
	$('form').ajaxForm({
			//target: '#output',
			beforeSubmit: function(arr, $form, options){options.context = $form; $form.siblings(".msg").fadeOut("fast");},
			async: false,
			dataType: "json",
			resetForm: false,
			success: function(data){$(this).siblings('form').remove();
									$(this).children(':submit').remove();
									$(this).next('.msg').text(data.msg || "SUCCESS").fadeIn('slow');
									console.log("SUCCESS");},
			error: function(d){
						console.log(this);
						$(this).siblings('.msg').text("Request Failed, please try again.").fadeIn('slow');
					}

	});
	
});