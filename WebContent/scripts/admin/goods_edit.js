$(function(){
	var goodsId = $('#input-goodsid').val();

	Dropzone.autoDiscover = false;
	var goodsImageDropzone = null;
	// 初始化图片插件
	initDropzone();

	$('#btn-submit').click(function(){
		submit();
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
	
	$.ajax({
		url : HOST + 'api/admin/getGoodsDetail?goodsId=' + goodsId,
		type : 'POST',
		success:function(response) {
			console.log('商品详情',response);
			var goods = response.result.goods;
			var products = response.result.products;
			var images = response.result.images;
			console.log(goodsImageDropzone);
			for(var i = 0; i < images.length; i++) {
				var imageUrl = HOST + images[i].relativePath;
				var mockFile = { 
					name: "Filename", 
					imageId : images[i].id,
					size: ''
				};
				goodsImageDropzone.emit("addedfile", mockFile);
				goodsImageDropzone.emit("thumbnail", mockFile, imageUrl);
			}
			var p_html = '';
			// 产品列
			for(var i = 0;i<products.length;i++) {
				var name = products[i].name;
				var productId = products[i].id;
				var quantity = products[i].quantity;
				p_html += '<div class="panel panel-primary">';
				p_html += '	<div class="panel-body">';
				p_html += '		<div class="col-md-9">';
				p_html += '			<h3 style="margin:0;line-height:28px;">' + name + '</h3>';
				p_html += '		</div>';
				p_html += '		<div class="col-md-2">';
				p_html += '			<input type="number" class="form-control" placeHolder="数量" pid="' + productId + '" name="product-item" value="'+quantity+'"/>';
				p_html += '		</div>';
				p_html += '		<div class="col-md-1">';
				p_html += '			<div class="btn btn-danger pull-right btn-remove-product">删除</div>';
				p_html += '		</div>';
				p_html += '	</div>';
				p_html += '</div>';
			}
			$('input[name="name"]').val(goods.name);
			$('input[name="price"]').val(goods.price);
			$('input[name="markePrice"]').val(goods.marketPrice);
			$('select[name="status"]').selectpicker('val',goods.status.toString());
			$('#textarea-intro').code(goods.intro);
			$('#textarea-desc').code(goods.description);
			
			$('#panel-product-seleted').html(p_html);
			$('.btn-remove-product').click(function(){
				$(this).parent().parent().parent().remove();
			});
		}
	});

	function initDropzone() {
		 goodsImageDropzone = new Dropzone("#goods-dropzone");
		 // 上传结束
		 goodsImageDropzone.on("success", function (file,response) {
			 if (response.status == 200) {
				file.imageId = response.result[0].id;
			 }
         });
         // 删除文件
		 goodsImageDropzone.on("removedfile", function (file) {
             var imageId = file.imageId;
             $.ajax({
            	 url : HOST + 'api/admin/deleteGoodsImage?imageId=' + imageId,
            	 type : 'POST',
            	 success : function(response) {
            		 if(response.status == 400) {
            			 alert('删除图片异常');
            			 console.log(response);
            		 }
            	 },
            	 error : function(res) {
            		 alert('删除图片异常');
            		 console.log(res);
            	 }
             });
         });
	}
	
	// 保存编辑结果
	function submit() {
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
		
		$.ajax({
			url : HOST + 'api/admin/updateGoods',
			type : 'POST',
			data : goodsForm,
			dataType: 'json',  
			contentType:'application/json;charset=UTF8',
			data:JSON.stringify(goodsForm),
			success : function(response){
				if(response.status == 200) {
					popSuccessMessageBox();
				}
				else {
					popErrorMessageBox(response.message);
				}
			},
			error : function(res){
				popErrorMessageBox('请查看控制台');
				console.log(res);
			}
		});
	}
	
	
});