$(function() {
	var url = HOST + 'api/admin/getOrders?status=&keyword=&orderby=';
	var method = 'POST';
	var pagination = new AtlantPagination(url, function(response) {
		console.log(response);
		var _this = this;
		var result = response.result;
		var html = '';
		for (var i = 0; i < result.length; i++) {
			var item = result[i];
			var createTime = new Date(item.createTime);
			html += '<tr>';
			html += '	<td>' + item.code +'</td>';
			html += '	<td>' + getBasicDataLabel(BasicData_OrderStatus,item.status) +'</td>';
			html += '	<td>' + item.customerName +'</td>';
			html += '	<td>' + item.totalPrice +'</td>';
			html += '	<td>' + createTime.format('yyyy-MM-dd hh:mm:ss') +'</td>';
			html += '	<td><div class="btn btn-info btn-edit" oid="'+item.id+'">查看</div></td>';
			html += '</tr>';
		}
		$('#table-body').html(html);
		$('.btn-edit').click(function(){
			var oid = $(this).attr('oid');
			location.href = HOST + 'admin/order_edit?orderId=' + oid;
		});
		
	}, method, null, '#table-footer');

});
