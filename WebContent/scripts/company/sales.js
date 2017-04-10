$(function(){
	var url = HOST + 'api/company/getSales?keyword=';
	var method = 'POST';
	var pagination = new AtlantPagination(url, function(response) {
		var _this = this;
		var result = response.result;
		var html = '';
		for (var i = 0; i < result.length; i++) {
			var item = result[i];
			var createTime = new Date(item.createTime);
			html += '<tr>';
			html += '	<td>' + item.name +'</td>';
			html += '	<td>' + item.mobileNumber +'</td>';
			html += '	<td>' + getBasicDataLabel(BasicData_GoodsStatus,item.status) +'</td>';
			html += '	<td>' + item.commision +'</td>';
			html += '	<td>' + createTime.format('yyyy-MM-dd') +'</td>';
			html += '	<td><div class="btn btn-success btn-edit" sid="'+item.id+'">查看</div></td>';
			html += '</tr>';
		}
		$('#table-body').html(html);
		$('.btn-edit').click(function(){
			var uuid = $(this).attr('sid');
			location.href = HOST + 'company/sales_detail?salesId=' + uuid;
		});
	}, method, null, '#table-footer');
});