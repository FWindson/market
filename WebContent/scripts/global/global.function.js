Date.prototype.format = function(format) {
	var date = {
		"M+" : this.getMonth() + 1,
		"d+" : this.getDate(),
		"h+" : this.getHours(),
		"m+" : this.getMinutes(),
		"s+" : this.getSeconds(),
		"q+" : Math.floor((this.getMonth() + 3) / 3),
		"S+" : this.getMilliseconds()
	};
	if (/(y+)/i.test(format)) {
		format = format.replace(RegExp.$1, (this.getFullYear() + '')
				.substr(4 - RegExp.$1.length));
	}
	for ( var k in date) {
		if (new RegExp("(" + k + ")").test(format)) {
			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? date[k]
					: ("00" + date[k]).substr(("" + date[k]).length));
		}
	}
	return format;
}

/**
 * 弹出成功提示对话框
 * @param message 弹框内容
 * @returns
 */
function popSuccessMessageBox(message){
	var $box = $('#message-box-success');
//	if($box == null) {
//		var _html = ''; 
//		_html += '<div class="message-box message-box-success animated fadeIn" id="message-box-success">';
//		_html += '	<div class="mb-container">';
//		_html += '		<div class="mb-middle">';
//		_html += '			<div class="mb-title">';
//		_html += '				<span class="fa fa-check"></span> 成功';
//		_html += '			</div>';
//		if(message != null || message != ''){
//			_html += '			<div class="mb-content" id="mb-content-success">' + message + '</div>';
//		}
//		_html += '			<div class="mb-footer">';
//		_html += '				<button class="btn btn-default btn-lg pull-right mb-control-close">Close</button>';
//		_html += '			</div>';
//		_html += '		</div>';
//		_html += '	</div>';
//		_html += '</div>';
//		$('body').append(_html);
//		$box = $('#message-box-success');
//	}
	$box.addClass('open');
}

/**
 * 弹出失败提示对话框
 * @param message 弹框内容
 * @returns
 */
function popErrorMessageBox(message){
	var $box = $('#message-box-danger');
//	if($box == null) {
//		var _html = ''; 
//		_html += '<div class="message-box message-box-danger animated fadeIn" id="message-box-danger">';
//		_html += '	<div class="mb-container">';
//		_html += '		<div class="mb-middle">';
//		_html += '			<div class="mb-title">';
//		_html += '				<span class="fa fa-check"></span> 失败';
//		_html += '			</div>';
//		if(message != null || message != ''){
//			_html += '			<div class="mb-content" id="mb-content-danger">' + message + '</div>';
//		}
//		_html += '			<div class="mb-footer">';
//		_html += '				<button class="btn btn-default btn-lg pull-right mb-control-close">Close</button>';
//		_html += '			</div>';
//		_html += '		</div>';
//		_html += '	</div>';
//		_html += '</div>';
//		$('body').append(_html);
//		$box = $('#message-box-danger');
//	}
	$box.addClass('open');
}
