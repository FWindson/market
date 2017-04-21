$(function(){
	var salesApplyId = $('#input-salesApplyId').val();
	
	requestSalesApply();

	$('#btn-accept').click(function() {
		accept();
	});
	
	// 拒绝
	$('#btn-refuse').click(function() {
		resuse();
	});
	
	/* 方法 */
	// 获取销售员申请详情
	function requestSalesApply() {
		$.ajax({
			url : HOST + 'api/admin/getSalesApply?salesApplyId=' + salesApplyId,
			type : 'POST',
			success : function(response){
				var item = response.result;
				console.log(item);
				$('#sales-apply-name').html(item.name);
				$('#sales-apply-mobileNumber').html(item.mobileNumber);
				$('#sales-apply-status').html(getBasicDataLabel(BasicData_SalesApplyStatus,item.status));
				$('#sales-apply-companyName').html(item.companyName);
				$('#sales-apply-comment').html(item.comment);
				$('#sales-apply-createTime').html(new Date(item.createTime).format('yyyy-MM-dd'));
				var handlerByName = item.handlerByName || '无';
				$('#sales-apply-handlerBy').html(handlerByName);
			}
		});
	}
	
	// 接受
	function accept() {
		$.ajax({
			url : HOST + 'api/admin/acceptSalesApply?salesApplyId=' + salesApplyId,
			type : 'POST',
			success : function(response){
				if(response.status == 200) {
					$('#message-box-success').addClass('open');
					requestSalesApply();
				}
				else {
					$('#message-box-danger').addClass('open');
				}
			}
		});
	}
	
	// 拒绝
	function resuse() {
		$.ajax({
			url : HOST + 'api/admin/refuseSalesApply?salesApplyId=' + salesApplyId,
			type : 'POST',
			success : function(response){
				if(response.status == 200) {
					$('#message-box-success').addClass('open');
					requestSalesApply();
				}
				else {
					$('#message-box-danger').addClass('open');
				}
			}
		});
	}
	/* 方法 结束 */
});