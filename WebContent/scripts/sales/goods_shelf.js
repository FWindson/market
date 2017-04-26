$(function() {
	var param = {
		url : HOST + 'api/sales/getGoodsShelf',
		method : 'POST',
		params : 'keyword=&orderb=',
		onload :function(response) {
			console.log(response);
			var listGoods = response.result;
			var html = '';
			for(var i = 0;i < listGoods.length;i++) {
				var goods = listGoods[i];
				html += '<div class="gs-g-i">';
				html += '	<div class="gs-g-i-img">';
				html += '		<img src="<%=basePath%>images/g1.jpg">';
				html += '	</div>';
				html += '	<div class="gs-g-i-name">速霸1000四升两次保养</div>';
				html += '	<div class="gs-g-i-price">￥ 899</div>';
				html += '	<div class="gs-g-i-btn">';
				html += '		<div class="gs-g-i-btn-qrcode">二维码</div>';
				html += '		<div class="gs-g-i-btn-detail">详情</div>';
				html += '	</div>';
				html += '</div>';
			}
			$('#gs-body').append(html);
		},
		element: '#gs-body'
	};
	var wechatPagination = new WechatPagination(param);
});