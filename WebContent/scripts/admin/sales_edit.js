$(function(){
	var salesId = $('#input-salesId').val();
	$.ajax({
		url : HOST + 'api/admin/getSalesDetail?salesId=' + salesId,
		type : 'POST',
		success : function(response){
			var sales = response.result;
			console.log(sales);
			$('#sales-name').html(sales.name);
			$('#sales-mobileNumber').html(sales.mobileNumber);
			$('#sales-status').html(getBasicDataLabel(BasicData_SalesStatus,sales.status));
			$('#sales-companyName').html(sales.companyName);
			$('#sales-commision').html(sales.commision);
			$('#sales-freezeCommision').html(sales.freezeCommision);
			$('#sales-totalCommision').html(sales.totalCommision);
			$('#sales-createTime').html(new Date(sales.createTime).format('yyyy-MM-dd'));
		}
	});
	// 客户列表
	var url = HOST + 'api/admin/getCustomers?salesId=' + salesId + '&keyword=&orderby=';
	var method = 'POST';
	var pagination = new AtlantPagination(url, function(response) {
		console.log(response);
		var _this = this;
		var result = response.result;
		var html = '';
		for (var i = 0; i < result.length; i++) {
			var item = result[i];
			var setSalesTime = new Date(item.setSalesTime);
			html += '<tr>';
			html += '	<td>' + item.name +'</td>';
			html += '	<td>' + setSalesTime.format('yyyy-MM-dd hh:mm:ss') +'</td>';
			html += '	<td><div class="btn btn-success btn-edit" cid="'+item.id+'">查看</div></td>';
			html += '</tr>';
		}
		$('#table-body').html(html);
		$('.btn-edit').click(function(){
			var cid = $(this).attr('cid');
			location.href = HOST + 'admin/customer_edit?customerId=' + cid;
		});
		
	}, method, null, '#table-footer');
});