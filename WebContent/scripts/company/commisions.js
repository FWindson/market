$(function() {
	var url_getSalesCommisions = HOST + 'api/company/getCommisionRecords?applicantType=1";
	var method = 'POST';

	var page_Commisions = new AtlantPagination(url_getSalesCommisions, function(response) {
		var _this = this;
		var result = response.result;
		console.log('佣金收入记录：',response);
		var html = '';
		for (var i = 0; i < result.length; i++) {
			var item = result[i];
			var createTime = new Date(item.createTime);
			html += '<tr>';
			html += '<td>' + item.orderCode +'</td>';
			html += '<td>' + item.goodsName +'</td>';
			html += '<td>' + item.quantity +'</td>';
			html += '<td>' + item.totalPrice +'</td>';
			html += '<td>' + createTime.format('yyyy-MM-dd') +'</td>';
			html += '<td>' + item.number +'</td>';
			html += '</tr>';
		}
		$('#table-body').html(html);
	}, method, null, '#table-footer');
	
});
