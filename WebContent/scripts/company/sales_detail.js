$(function() {
	var salesId =  $('#input-salesId').val();
	var url_getCustomers = HOST + 'api/company/getSalesCustomers?salesId=' + salesId;
	var url_getSalesDetail =  HOST + 'api/company/getSalesDetail?salesId=' + salesId;
	var url_getSalesCommisions = HOST + 'api/company/getCommisionRecords?applicantId=' + salesId + '&applicantType=2';
	var method = 'POST';

	// 销售员详情
	$.ajax({
		url : url_getSalesDetail,
		type : method,
		success:function(response){
			console.log('员工详情',response);
			var sales = response.result;
			$('#sales_name').html(sales.name);
			$('#sales_status').html(getBasicDataLabel(BasicData_SalesStatus,sales.status));
			$('#sales_commision_total').html(sales.commision);
		}
	});
	// 员工客户
	var page_Customer = new AtlantPagination(url_getCustomers, function(response) {
		var _this = this;
		var result = response.result;
		console.log('客户列表',response);
		var html = '';
		for (var i = 0; i < result.length; i++) {
			var item = result[i];
			html += '<tr>';
			html += '<td>' + item.name +'</td>';
			html += '</tr>';
		}
		$('#table-customer-body').html(html);
	}, method, null, '#table-customer-footer');


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
		$('#table-commision-body').html(html);
	}, method, null, '#table-commision-footer');
	
});
