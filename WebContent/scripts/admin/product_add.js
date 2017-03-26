$(function(){
	
	$('#btn-submit').click(function(){
		var productForm = $('#form-product').serializeJSON();
		console.log(productForm);
		$.ajax({
			url : HOST + 'api/admin/addProduct',
			type : 'POST',
			data : productForm,
			success : function(response) {
				console.log(response);
			},
			error : function(errorMsg) {
				console.log(errorMsg.responseText);
			}
		});
	});
});