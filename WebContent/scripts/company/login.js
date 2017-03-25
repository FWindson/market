$(function(){
	
	$('#btn-login').click(function() {
		var form = {
			name : $('input[name="name"]').val(),
			password : $('input[name="password"]').val()
		};
		$.ajax({
			url : HOST + 'api/company/login',
			type : 'POST',
			data : form,
			success : function(response){
				if(response.status == 200) {
					var returnUrl = $('#input-returnUrl').val();
					if(returnUrl != ''){
						location.href = returnUrl;
					}
					else{
						location.href = HOST + 'company/dashboard';
					}
				}
				else {
					toggleNoty();
				}
			},
			error: function(errMsg) {
				console.log(errMsg);
			}
		});
	});
	
	$('.mb-control-close').click(function(){
		toggleNoty();
	});
	
	function toggleNoty(){
		var $messageBox = $('.message-box');
		if($messageBox.hasClass('open')) {
			$messageBox.removeClass('open');
		}
		else {
			$messageBox.addClass('open');
		}
	}
	
});