$(function() {
	var pagination = null;
	var url = HOST + 'api/admin/goods?keyword=&orderby=';
	var method = 'POST';
	
	$('#btn-delete-goods-confirm').click(function(){
		deleteGoods($('#input-goods-to-delete').val());
	});
	
	pagination = new AtlantPagination(url, function(response) {
		console.log(response);
		var _this = this;
		var result = response.result;
		var html = '';
		for (var i = 0; i < result.length; i++) {
			var item = result[i];
			var stock = item.stock == -709394 ? '无限' : item.stock;
			var createTime = new Date(item.createTime);
			html += '<tr>';
			html += '	<td>' + item.name +'</td>';
			html += '	<td>' + item.price +'</td>';
			html += '	<td>' + item.marketPrice +'</td>';
			html += '	<td>' + getBasicDataLabel(BasicData_GoodsStatus,item.status) +'</td>';
			html += '	<td>' + stock +'</td>';
			html += '	<td>' + createTime.format('yyyy-MM-dd') +'</td>';
			html += '	<td>' + item.createBy +'</td>';
			html += '	<td><div class="btn btn-success btn-edit" uuid="'+item.id+'">编辑</div> <div class="btn btn-danger btn-del" uuid="'+item.id+'">删除</div></td>';
			html += '</tr>';
		}
		$('#table-goods-body').html(html);
		$('.btn-edit').click(function(){
			var uuid = $(this).attr('uuid');
			location.href = HOST + 'admin/goods_edit?goodsId=' + uuid;
		});
		$('.btn-del').click(function(){
			var uuid = $(this).attr('uuid');
			$('#input-goods-to-delete').val(uuid);
			$('#message-box-warning').addClass('open');
		});
	}, method, null, '#table-goods-footer');


	// 删除商品
	function deleteGoods(goodsId){
		$.ajax({
			url : HOST + 'api/admin/deleteGoods?goodsId=' + goodsId,
			type : 'POST',
			success : function(response){
				$('#message-box-warning').removeClass('open');
				if(response.status == 200){
					$('#message-box-success').addClass('open');
					pagination.reload();
				} else {
					$('#message-box-danger').addClass('open');
					console.log(response);
				}
			}
		});
	}
	
});
