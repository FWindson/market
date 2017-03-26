$(function(){
	
	$('#btn-submit').click(function(){
		var productForm = $('#form-product').serializeJSON();
		if(productForm.stock == null || productForm.stock == '') {
			productForm.stock = -709394
		}
		console.log(productForm);
		$.ajax({
			url : HOST + 'api/admin/addProduct',
			type : 'POST',
			data : productForm,
			success : function(response) {
				if(response.status == 200) {
					$('#message-box-success').addClass('open');
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