$(function(){
	var orderId = $('#input-orderId').val();
	
	$.ajax({
		url : HOST + 'api/admin/getCompleteOrder?orderId=' + orderId,
		type : 'POST',
		success:function(response) {
			console.log(response);
			var order = response.result;
			var basicForm = order.order;
			var influences = order.orderInfluences;
			debugger
			if(influences.length == 0) {
				$('#row-orderInfluence').hide();
			}
			else {
				$('#row-orderInfluence').show();
				var oi_html = '';
				for(var i = 0;i < influences.length; i++){
					oi_html +='<tr>';
					oi_html +='<td>'+getBasicDataLabel(BasicData_OrderInfluenceCalculateType,influences[i].influenceType)+'</td>';
					oi_html +='<td>'+influences[i].influenceValue+'</td>';
					oi_html +='</tr>';
				}
				$('#table-influence-body').html(oi_html);
			}
			var orderDetails = order.orderDetailModels;
			var originalPrice = 0;
			var od_html = '';
			for(var i = 0;i<orderDetails.length;i++) {
				var detail = orderDetails[i];
				originalPrice += detail.originalPrice;
				od_html += '<tr>';
				od_html += '<td>'+detail.goodsName+'</td>';
				od_html += '<td>'+detail.price+'</td>';
				od_html += '<td>'+detail.quantity+'</td>';
				od_html += '<td>'+detail.originalPrice+'</td>';
				od_html += '<td>'+detail.totalPrice+'</td>';
				od_html += '</tr>';
			}
			$('#table-orderDetail-body').html(od_html);
			$('#order-code').html(basicForm.code);
			$('#order-status').html(getBasicDataLabel(BasicData_OrderStatus,basicForm.status));
			$('#order-customer').html(basicForm.customerName);
			$('#order-totalPrice').html(basicForm.totalPrice);
			$('#order-oldPrice').html(originalPrice);
			$('#order-createTime').html(new Date(basicForm.createTime).format('yyyy-MM-dd hh:mm:ss'));
			
		}
	});

	
});