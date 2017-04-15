$(function(){
	var url = HOST + 'api/goods/getAll';
	var method = 'GET';
	// 确认删除后要删除的配置项
	var $elementConfigurationToRemove = null;
	
	$('#btn-add-straight').click(function(){
		var $straight = $('#template-configuration-straight').clone();
		$straight.css('display','');
		$straight.removeAttr('id');
		$straight.find('.btn').click(function(){
			$straight.remove();
		});
		$('#panel-commision-configuration').append($straight);
	});
	$('#btn-add-bySales').click(function(){
		var $bySales = $('#template-configuration-bySales').clone();
		$bySales.css('display','');
		$bySales.removeAttr('id');
		$bySales.find('.btn').click(function(){
			$bySales.remove();
		});
		$('#panel-commision-configuration').append($bySales);
	});
	$('#btn-submit').click(function(){
		var formCompany = $('#form-company').serializeJSON();
		var password = '';
		if($('#checkbox-resetPassword').prop('checked')){
			password = formCompany.password;
		}
		console.log(password);
		$.ajax({
			url : HOST + 'api/admin/updateCompany?companyId=' + formCompany.id + '&companyName=' + formCompany.name + '&password=' + password,
			type : 'POST',
			success : function(response) {
				popSuccessMessageBox();
			}
		});
	});
	$('#btn-removeConfiguration').click(function(){
		var cid = $('#input-configurationToRemove').val();
		if(cid == '')
			return;
		$.ajax({
			url : HOST + 'api/admin/deleteCommisionConfiguration?id=' + cid,
			type : 'POST',
			success:function(response) {
				$('#dialog-configurationRemoveConfirm').removeClass('open');
				if(response.status == 200)
					$elementConfigurationToRemove.remove();
				else {
					$('#message-box-danger').addClass('open');
				}
			}
		});
	});
	$('#btn-save-commisionConfiguration').click(function(){
		var commisionConfigurations = new Array();
		var goodsId = '';
		$('.goods-item').each(function(){
			if($(this).hasClass('active')) {
				goodsId = $(this).attr('gid');
				return;
			}
		});
		console.log('goodsId',goodsId);
		$('.template-configuration').each(function(){
			if($(this).attr('id') == null){
				var id = $(this).find('input[name="id"]').val();
				var number = $(this).find('input[name="number"]').val();
				var calculateType = $(this).find('select[name="calculateType"]').val();
				var minSales = $(this).find('input[name="minSales"]').val();
				var maxSales = $(this).find('input[name="maxSales"]').val();
				var salesType = 1;
				if($(this).hasClass('template-configuration-bySales')){
					salesType = 2;
				}
				var configuration = {
					id : id,
					calculateValue : number,
					calculateType : calculateType,
					goodsId : goodsId,
					minSales : minSales,
					maxSales : maxSales,
					salesType : salesType
				};
				commisionConfigurations.push(configuration);
			}
		});
		var postData = {
			targetType : 1,
			targetId : $('#input-companyId').val(),
			commisionConfigurations : commisionConfigurations
		};
		
		console.log(JSON.stringify(postData));
		$.ajax({
			url : HOST + 'api/admin/setCommisionConfigurations',
			type : 'POST',
			data : JSON.stringify(postData),
			contentType : "application/json;charset=utf-8", 
			success : function(response){
				if(response.status == 200){
					$('#message-box-success').addClass('open');
					setTimeout(function(){
						$('#message-box-success').removeClass('open');
					},1000);
				}
				else{
					$('#mb-content-danger p').text(errorMsg.responseText);
					$('#message-box-danger').addClass('open');
				}
			}
		});
	});
	// 商品列表
	$.ajax({
		url : url,
		type : method,
		success:function(list){
			var html = '';
			for(var i = 0;i<list.length;i++){
				var item = list[i];
				html += '<a href="#" class="list-group-item goods-item" gid="'+item.id+'">'+ item.name + '</a>';
			}
			$('#list-goods').html(html);
			$('.goods-item').click(function(){
				$('.template-configuration').each(function(){
					if($(this).attr('id') != 'template-configuration-straight' && $(this).attr('id') != 'template-configuration-bySales'){
						$(this).remove();
					}
				});
				$('.none-configuration-tip').remove();
				var goodsId = $(this).attr('gid');
				var name = $(this).text();
				$('.goods-item').removeClass('active');
				$(this).addClass('active');
				// 获取配置
				$.ajax({
					url : HOST + 'api/admin/getCommisionsConfigurationByGoodsId?goodsId=' + goodsId + '&targetType=1&targetId=' + $('#input-companyId').val() + '&orderby=',
					type : 'POST',
					success: function(response){
						console.log(response);
						if(response.status == 200) {
							var commisions = response.result;
							if(commisions.length == 0){
								var noneHtml = '<h3 class="text-center none-configuration-tip">暂无配置</h3>';
								$('#panel-commision-configuration').append(noneHtml);
							}
							for(var i = 0;i < commisions.length;i++){
								var item = commisions[i];
								var $template = null;
								if(item.salesType == 1){
									$template = $('#template-configuration-straight').clone();
								}
								else if(item.salesType == 2){
									$template = $('#template-configuration-bySales').clone();
								}
								$template.css('display','');
								$template.removeAttr('id'); 
								$template.find('.btn').click(function(){
									$('#input-configurationToRemove').val(item.id);
									$('#dialog-configurationRemoveConfirm').addClass('open');
									$elementConfigurationToRemove = $template;
								});
								$('#panel-commision-configuration').append($template);
								$template.find('input[name="id"]').val(item.id);
								$template.find('input[name="number"]').val(item.calculateValue);
								$template.find('select[name="calculateType"]').val(item.calculateType);
								$template.find('input[name="minSales"]').val(item.minSales);
								$template.find('input[name="maxSales"]').val(item.maxSales);
							}
						}
					}
				});
			});
		}
	});
//	var pagination = new AtlantPagination(url, function(response) {
//		var _this = this;
//		var result = response.result;
//		var html = '';
//		for (var i = 0; i < result.length; i++) {
//			var item = result[i];
//			var createTime = new Date(item.createTime);
//			html += '<tr>';
//			html += '	<td>' + item.name +'</td>';
//			html += '	<td>' + getBasicDataLabel(BasicData_CompanyStatus,item.status) +'</td>';
//			html += '	<td>' + item.fund +'</td>';
//			html += '	<td>' + item.freezedFund +'</td>';
//			html += '	<td>' + createTime.format('yyyy-MM-dd') +'</td>';
//			html += '	<td>' + item.createBy +'</td>';
//			html += '	<td><div class="btn btn-success btn-edit" cid="'+item.id+'">查看</div></td>';
//			html += '</tr>';
//		}
//		$('#table-body').html(html);
//		$('.btn-edit').click(function(){
//			var uuid = $(this).attr('cid');
//			location.href = HOST + 'admin/company_edit?companyId=' + uuid;
//		});
//	}, method, null, '#table-footer');
});