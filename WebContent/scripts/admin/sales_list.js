$(function(){
	var url = HOST + 'api/admin/getSales?companyId=&status=&keyword=&orderby=';
	var method = 'POST';
	var pagination = new AtlantPagination(url, function(response) {
		var _this = this;
		console.log(response);
		var result = response.result;
		var html = '';
		for (var i = 0; i < result.length; i++) {
			var item = result[i];
			var createTime = new Date(item.createTime);
			var companyName = item.companyName || '无';
			html += '<tr>';
			html += '	<td>' + item.name +'</td>';
			html += '	<td>' + companyName +'</td>';
			html += '	<td>' + item.mobileNumber +'</td>';
			html += '	<td>' + getBasicDataLabel(BasicData_SalesStatus,item.status) +'</td>';
			html += '	<td>' + createTime.format('yyyy-MM-dd') +'</td>';
			html += '	<td><div class="btn btn-success btn-edit" sid="'+item.id+'">查看</div></td>';
			html += '</tr>';
		}
		$('#table-body').html(html);
		$('.btn-edit').click(function(){
			var sid = $(this).attr('sid');
			location.href = HOST + 'admin/sales_edit?salesId=' + sid;
		});
	}, method, null, '#table-footer');
});