$(function() {
	var url = HOST + 'api/admin/products';
	var method = 'POST';

	var pagination = new AtlantPagination(url, function(response) {
		var _this = this;
		var result = response.result;
		var html = '';
		for (var i = 0; i < result.length; i++) {
			var item = result[i];
			console.log(item);
			var stock = item.stock == -709394 ? '无限' : item.stock;
			var createTime = new Date(item.createTime);
			html += '<tr>';
			html += '<td>' + item.name +'</td>';
			html += '<td>' + item.price +'</td>';
			html += '<td>' + getBasicDataLabel(BasicData_ProductNature,item.nature) +'</td>';
			html += '<td>' + stock +'</td>';
			html += '<td>' + createTime.format('yyyy-MM-dd') +'</td>';
			html += '<td>' + item.createBy +'</td>';
			html += '<td><div class="btn btn-success btn-edit" uuid="'+item.id+'">编辑</div> <div class="btn btn-danger btn-del" uuid="'+item.id+'">删除</div></td>';
			html += '</tr>';
		}
		$('#table-product-body').html(html);
		$('.btn-edit').click(function(){
			var uuid = $(this).attr('uuid');
			location.href = HOST + 'admin/product_edit?uuid=' + uuid;
		});
		$('.btn-del').click(function(){
			var uuid = $(this).attr('uuid');
			$.ajax({
				url : HOST + 'api/admin/deleteProduct?uuid=' + uuid,
				type : 'POST',
				success : function(response){
					if(response.status == 200){
						$('#message-box-success').addClass('open');
					}
					else {
						$('#message-box-danger').addClass('open');
					}
				}
			});
			_this.reload();
		});
	}, method, null, '#table-product-footer');

});
