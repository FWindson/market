$(function(){
	var url = HOST + 'api/admin/getCustomers?keyword=&orderby=';
	var method = 'POST';
	var pagination = new AtlantPagination(url, function(response) {
		var _this = this;
		console.log(response);
		var result = response.result;
		var html = '';
		for (var i = 0; i < result.length; i++) {
			var item = result[i];
			var createTime = new Date(item.createTime);
			var salesName = item.salesName || '无';
			html += '<tr>';
			html += '	<td>' + item.name +'</td>';
			html += '	<td>' + salesName +'</td>';
			html += '	<td>' + createTime.format('yyyy-MM-dd') +'</td>';
//			html += '	<td>' + item.expense +'</td>';
			html += '	<td><div class="btn btn-success btn-edit" cid="'+item.id+'">查看</div></td>';
			html += '</tr>';
		}
		$('#table-body').html(html);
		$('.btn-edit').click(function(){
			var uuid = $(this).attr('cid');
			location.href = HOST + 'admin/customer_edit?customerId=' + uuid;
		});
	}, method, null, '#table-footer');
});