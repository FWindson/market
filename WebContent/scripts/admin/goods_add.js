$(function(){
	
	$('#btn-submit').click(function(){
		var goodsForm = $('#form-goods').serializeJSON();
		var textareaIntroVal = $('#textarea-intro').code();
		var textareaDescVal = $('#textarea-desc').code();
		goodsForm.intro = textareaIntroVal;
		goodsForm.description = textareaDescVal;
		var productArray = [];
		$('input[name="product-item"]').each(function(){
			var quantity = $(this).val();
			var pid = $(this).attr('pid');

			productArray.push({
				id : pid,
				quantity : quantity
			});
		});
		goodsForm.products = productArray;
		/*var postData = {
			goods : goodsForm,
			products : productArray
		};*/
		var postData = {
				goods : goodsForm
			};

		$.ajax({
			url:HOST + 'api/admin/addGoods',
			type:'POST',
			dataType: 'json',  
			contentType:'application/json;charset=UTF8',
			data:JSON.stringify(goodsForm),
			success:function(response){
				if(response.status == 200) {
					popSuccessMessageBox('添加成功');
				}
			},
			error :function(res){
				console.log(res);
			}
		});
	});
	
	$('.list-item-product').click(function(){
		var pid = $(this).attr('pid');
		var existed = false;
		$('input[name="product-item"]').each(function(){
			var _pid = $(this).attr('pid');
			if(_pid == pid) {
				existed = true;
			}
		});
		if(existed){
			return;
		}
		var name = $(this).text();
		var html = '';
		html += '<div class="panel panel-primary">';
		html += '	<div class="panel-body">';
		html += '		<div class="col-md-9">';
		html += '			<h3 style="margin:0;line-height:28px;">' + name + '</h3>';
		html += '		</div>';
		html += '		<div class="col-md-2">';
		html += '			<input type="number" class="form-control" placeHolder="数量" pid="' + pid + '" name="product-item" value="0"/>';
		html += '		</div>';
		html += '		<div class="col-md-1">';
		html += '			<div class="btn btn-danger pull-right btn-remove-product">删除</div>';
		html += '		</div>';
		html += '	</div>';
		html += '</div>';
		$('#panel-product-seleted').append(html);
		$('.btn-remove-product').click(function(){
			$(this).parent().parent().parent().remove();
		});
	});
});