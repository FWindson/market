$(function(){
	var customerId = $('#input-customerId').val();
	
	// 请求该客户信息
	$.ajax({
		url : HOST + 'api/admin/getCustomer?customerId=' + customerId,
		type : 'POST',
		success:function(response) {
			console.log(response);
			var customer = response.result;
			$('#customer-name').html(customer.name);
			$('#customer-salesName').html(customer.salesName || '无');
			$('#customer-createTime').html(new Date(customer.createTime).format('yyyy-MM-dd hh:mm:ss'));
			$('#customer-expense').html(customer.name);
		}
	});
	
	// 请求该客户订单
	var url = HOST + 'api/admin/getOrders?customerId=' + customerId + '&keyword=&orderby=';
	var method = 'POST';
	var pagination = new AtlantPagination(url, function(response) {
		console.log(response);
		var result = response.result;
		var html = '';
		for (var i = 0; i < result.length; i++) {
			var item = result[i];
			var createTime = new Date(item.createTime);
			html += '<tr>';
			html += '	<td>' + item.code +'</td>';
			html += '	<td>' + getBasicDataLabel(BasicData_OrderStatus,item.status) +'</td>';
			html += '	<td>' + item.totalPrice +'</td>';
			html += '	<td>' + createTime.format('yyyy-MM-dd hh:mm:ss') +'</td>';
			html += '</tr>';
		}
		$('#table-order-body').html(html);
		
	}, method, null, '#table-footer');
});