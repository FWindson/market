$(function(){
	$('#btn-submit').click(function(){
		var form = $('#form-company').serializeJSON();
		console.log(form);
		$.ajax({
			url : HOST + 'api/admin/addCompany',
			type : 'POST',
			data : form,
			success : function(response) {
				console.log(response);
				if(response.status == 200) {
					$('#message-box-success').addClass('open');
					setTimeout(function(){
						location.href = HOST + 'admin/company_list';
					},1500)
				}
				else {
					$('#mb-content-danger h4').html(response.Message);
					$('#message-box-danger').addClass('open');
				}
			},
			error : function(errorMsg) {
				$('#mb-content-danger p').text(errorMsg.responseText);
				$('#message-box-danger').addClass('open');
				console.log(errorMsg);
			}
		});
	});
});