$(function() {
	var companyId = $('#input-companyId').val();
	
	$.ajax({
		url : HOST + 'api/admin/getCompany?companyId=' + companyId,
		type : 'POST',
		success :function(response){
			$('#form-company').find('input[name="name"]').val(response.result.name);
		}
	});
	
	$('#btn-add-straight').click(function() {
		var $straight = $('#template-configuration-straight').clone();
		$straight.css('display', '');
		$straight.removeAttr('id');
		$straight.find('.btn').click(function() {
			$straight.remove();
		});
		$('#first-tab .none-configuration-tip').remove();
		$('#panel-commision-configuration').append($straight);
	});
	$('#btn-add-bySales').click(function() {
		var $bySales = $('#template-configuration-bySales').clone();
		$bySales.css('display', '');
		$bySales.removeAttr('id');
		$bySales.find('.btn').click(function() {
			$bySales.remove();
		});
		$('#first-tab .none-configuration-tip').remove();
		$('#panel-commision-configuration').append($bySales);
	});
	$('#sales_btn-add-configuration').click(function() {
		var $bySales = $('#sales_template-configuration').clone();
		$bySales.css('display', '');
		$bySales.removeAttr('id');
		$bySales.find('.btn').click(function() {
			$bySales.remove();
		});
		$('#second-tab .none-configuration-tip').remove();
		$('#panel-commision-salesConfiguration').append($bySales);
	});
	$('#btn-submit').click(function() {
		var formCompany = $('#form-company').serializeJSON();
		var password = '';
		if ($('#checkbox-resetPassword').prop('checked')) {
			password = formCompany.password;
		}
		$.ajax({
			url: HOST + 'api/admin/updateCompany?companyId=' + formCompany.id + '&companyName=' + formCompany.name + '&password=' + password,
			type: 'POST',
			success: function(response) {
				popSuccessMessageBox();
			}
		});
	});
	$('#btn-removeConfiguration').click(function() {
		var cid = $('#input-configurationToRemove').val();
		if (cid == '')
			return;
		$.ajax({
			url: HOST + 'api/admin/deleteCommisionConfiguration?id=' + cid,
			type: 'POST',
			success: function(response) {
				$('#dialog-configurationRemoveConfirm').removeClass('open');
				if (response.status == 200) {
					var elementQuery = '';
					if ($('a[href="#first-tab"]').hasClass('active')){
						elementQuery = '.template-configuration';
					}
					else if($('a[href="#second-tab"]').hasClass('active')) {
						elementQuery = '.sales_template-configuration';
					}
					$(elementQuery).each(function() {
						var _templateId = $(this).attr('template-id');
						console.log(_templateId);
						console.log($(this));
						if (_templateId == cid)
							$(this).remove();
					});
				} else {
					$('#message-box-danger').addClass('open');	
				}
			}
		});
	});
	$('#btn-save-commisionConfiguration').click(function() {
		saveCommisionConfiguration($('#first-tab'), $('.template-configuration'), 1);
	});
	$('#sales_btn-save-commisionConfiguration').click(function() {
		saveCommisionConfiguration($('#first-tab'), $('.sales_template-configuration'), 2);
	});

	function saveCommisionConfiguration($tab, $template, paramTargetType) {
		var commisionConfigurations = new Array();
		var goodsId = '';
		$tab.find('.goods-item').each(function() {
			if ($(this).hasClass('active')) {
				goodsId = $(this).attr('gid');
				return;
			}
		});
		$template.each(function() {
			if ($(this).attr('id') == null) {
				var id = $(this).find('input[name="id"]').val();
				var number = $(this).find('input[name="number"]').val();
				var calculateType = $(this).find('select[name="calculateType"]').val();
				var minSales = $(this).find('input[name="minSales"]').val();
				var maxSales = $(this).find('input[name="maxSales"]').val();
				var salesType = 1;
				if ($(this).hasClass('template-configuration-bySales')) {
					salesType = 2;
				}
				var configuration = {
					id: id,
					calculateValue: number,
					calculateType: calculateType,
					goodsId: goodsId,
					minSales: minSales,
					maxSales: maxSales,
					salesType: salesType
				};
				commisionConfigurations.push(configuration);
			}
		});
		var postData = {
			targetType: paramTargetType,
			targetId: $('#input-companyId').val(),
			commisionConfigurations: commisionConfigurations
		};

		$.ajax({
			url: HOST + 'api/admin/setCommisionConfigurations',
			type: 'POST',
			data: JSON.stringify(postData),
			contentType: "application/json;charset=utf-8",
			success: function(response) {
				if (response.status == 200) {
					$('#message-box-success').addClass('open');
					setTimeout(function() {
						$('#message-box-success').removeClass('open');
					}, 1000);
				} else {
					$('#mb-content-danger p').text(errorMsg.responseText);
					$('#message-box-danger').addClass('open');
				}
			}
		});
	}

	// 获取商品列表
	$.ajax({
		url: HOST + 'api/goods/getAll',
		type: 'GET',
		success: function(list) {
			var html = '';
			for (var i = 0; i < list.length; i++) {
				var item = list[i];
				html += '<a href="#" class="list-group-item goods-item" gid="' + item.id + '">' + item.name + '</a>';
			}
			// 请求公司配置商品列表
			renderCompanyConfigurationGoods(html);
			// 请求公司配置商品列表
			renderSalesConfigurationGoods(html);
		}
	});

	// 请求公司配置商品列表
	function renderCompanyConfigurationGoods(goodsListHtml) {
		$('#list-goods').html(goodsListHtml);
		// 商品项点击事件
		$('.goods-item').click(function() {
			$('.template-configuration').each(function() {
				if ($(this).attr('id') != 'template-configuration-straight' && $(this).attr('id') != 'template-configuration-bySales') {
					$(this).remove();
				}
			});
			$('#first-tab .none-configuration-tip').remove();
			var goodsId = $(this).attr('gid');
			var name = $(this).text();
			$('.goods-item').removeClass('active');
			$(this).addClass('active');
			// 获取配置
			$.ajax({
				url: HOST + 'api/admin/getCommisionsConfigurationByGoodsId?goodsId=' + goodsId + '&targetType=1&targetId=' + $('#input-companyId').val() + '&orderby=',
				type: 'POST',
				success: function(response) {
					requestCompanyConfigurationCallback(response);
				}
			});
		});
	}

	// 获取公司配置回调
	function requestCompanyConfigurationCallback(response) {
		if (response.status == 200) {
			var commisions = response.result;
			if (commisions.length == 0) {
				var noneHtml = '<h3 class="text-center none-configuration-tip">暂无配置</h3>';
				$('#panel-commision-configuration').append(noneHtml);
			}
			for (var i = 0; i < commisions.length; i++) {
				var item = commisions[i];
				var $template = null;
				if (item.salesType == 1) {
					$template = $('#template-configuration-straight').clone();
				} else if (item.salesType == 2) {
					$template = $('#template-configuration-bySales').clone();
				}
				$template.css('display', '');
				$template.removeAttr('id');
				$('#panel-commision-configuration').append($template);
				$template.find('input[name="id"]').val(item.id);
				$template.find('input[name="number"]').val(item.calculateValue);
				$template.find('select[name="calculateType"]').val(item.calculateType);
				$template.find('input[name="minSales"]').val(item.minSales);
				$template.find('input[name="maxSales"]').val(item.maxSales);
				$template.attr('template-id',item.id);
				$template.find('.btn').attr('cid', item.id);
				// 删除配置事件
				$template.find('.btn').click(function() {
					var _templateId = $(this).attr('cid');
					$('#input-configurationToRemove').val(_templateId);
					$('#dialog-configurationRemoveConfirm').addClass('open');
				});
			}
		}
	}

	// 初始化销售员配置商品列表请求
	function renderSalesConfigurationGoods(goodsListHtml) {
		$('#sales-list-goods').html(goodsListHtml);
		$('#second-tab .goods-item').click(function() {
			$('.sales_template-configuration').each(function() {
				if ($(this).attr('id') != 'sales_template-configuration') {
					$(this).remove();
				}
			});
			$('#second-tab .none-configuration-tip').remove();
			var goodsId = $(this).attr('gid');
			var name = $(this).text();
			$('#second-tab .goods-item').removeClass('active');
			$(this).addClass('active');
			// 获取配置
			$.ajax({
				url: HOST + 'api/admin/getCommisionsConfigurationByGoodsId?goodsId=' + goodsId + '&targetType=2&targetId=' + $('#input-companyId').val() + '&orderby=',
				type: 'POST',
				success: function(response) {
					requestSalesConfigurationCallback(response);
				}
			});
		});
	}

	// 获取销售员配置回调
	function requestSalesConfigurationCallback(response) {
		if (response.status == 200) {
			var commisions = response.result;
			if (commisions.length == 0) {
				var noneHtml = '<h3 class="text-center none-configuration-tip">暂无配置</h3>';
				$('#panel-commision-salesConfiguration').append(noneHtml);
			}
			for (var i = 0; i < commisions.length; i++) {
				var item = commisions[i];
				var $template = null;
				$template = $('#sales_template-configuration').clone();
				$template.css('display', '');
				$template.removeAttr('id');
				$('#panel-commision-salesConfiguration').append($template);
				$template.find('input[name="id"]').val(item.id);
				$template.find('input[name="number"]').val(item.calculateValue);
				$template.find('select[name="calculateType"]').val(item.calculateType);
				$template.find('input[name="minSales"]').val(item.minSales);
				$template.find('input[name="maxSales"]').val(item.maxSales);
				$template.attr('template-id',item.id);
				$template.find('.btn').attr('cid', item.id);
				$template.find('.btn').click(function() {
					var _templateId = $(this).attr('cid');
					$('#input-configurationToRemove').val(_templateId);
					$('#dialog-configurationRemoveConfirm').addClass('open');
				});
			}
		}
	}


});