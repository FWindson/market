$(function(){
	var url = HOST + 'api/admin/getCompanys?keyword=&orderby=';
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
			html += '	<td>' + getBasicDataLabel(BasicData_CompanyStatus,item.status) +'</td>';
			html += '	<td>' + item.fund +'</td>';
			html += '	<td>' + item.freezedFund +'</td>';
			html += '	<td>' + createTime.format('yyyy-MM-dd') +'</td>';
			html += '	<td>' + item.createBy +'</td>';
			html += '	<td><div class="btn btn-success btn-edit" cid="'+item.id+'">查看</div></td>';
			html += '</tr>';
		}
		$('#table-body').html(html);
		$('.btn-edit').click(function(){
			var uuid = $(this).attr('cid');
			location.href = HOST + 'admin/company_edit?companyId=' + uuid;
		});
	}, method, null, '#table-footer');
});