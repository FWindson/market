/**
 * status：LOADING | WAITING | DATA_NULL | DATA_NO_MORE
 */
var WechatPagination = (function(){

	function WechatPagination(param) {
		
		this.url = param.url;
		this.method = param.method || 'GET';
		this.pageIndex = 1;
		this.pageSize = 10;
		this.onload = param.onload;
		this.status = "LOADING";
		this.addParams = param.addParams || true;
		this.firstLoad = true;
		this.element = param.element;
		
		this.loadingId = 'pinterest_loading_' + (Math.random() * 100000).toString().replace('.', '').substr(0, 5);
        this.nodataId = 'pinterest_noData_' + (Math.random() * 100000).toString().replace('.', '').substr(0, 5);
		
		var wechatPagination = this;
		this.load();
		
        $(window).scroll(function () {
        	var scrollTop = $(this).scrollTop();
            var scrollHeight = $(document).height();
            var windowHeight = $(this).height();
            if (scrollTop + windowHeight >= scrollHeight - 30) {
                if (wechatPagination.status == "WAITING") {
                	console.log(wechatPagination.status);
                	wechatPagination.status = "LOADING";
                	console.log(wechatPagination.status);
                	wechatPagination.load();
                }
            }
        });
	}
	
	WechatPagination.prototype.load = function(callback) {
        var wechatPagination = this;
        var params = '';
        if (wechatPagination.addParams) {
            if (wechatPagination.url.indexOf('?') >= 0) {
            	params = "&pageIndex=" + wechatPagination.pageIndex + "&pageSize=" + wechatPagination.pageSize;
            }
            else {
            	params = "?pageIndex=" + wechatPagination.pageIndex + "&pageSize=" + wechatPagination.pageSize;
            }
        }
        var tmpUrl = wechatPagination.url + params;
        var ajaxObject = {
            url: tmpUrl,
            type: wechatPagination.method,
            success: function (response) {
                if (callback != null) {
                    callback();
                }
                wechatPagination.status = "WAITING";
                wechatPagination.pageIndex++;
                wechatPagination.removeLoading();
                wechatPagination.onload(response);
                
                if(wechatPagination.firstLoad && response.totalRecord == 0) {
                	wechatPagination.onDataNull();
                }
                else if(!wechatPagination.firstLoad && response.totalRecord == 0) {
                	wechatPagination.onDataNoMore();
                }
                wechatPagination.firstLoad = false;
            },
            error: function (response) {
                alert('抱歉', '系统出了点小问题，请重试');
                console.log(response);
            }
        };
        if (wechatPagination.method == 'POST') {
            if (wechatPagination.postData != null) {
                ajaxObject.data = wechatPagination.postData;
            }
        }
        $.ajax(ajaxObject);
    }
	
	WechatPagination.prototype.onDataNull = function() {
		var windowWidth = $(window).width();
        var windowHeight = $(window).height();
        var scrollTop = $(this.element).offset().top;
        var noDataDivHeight = windowHeight - scrollTop;
        var imageLong = 120;
        $(this.element).height(noDataDivHeight);
        $(this.element).html('<div class="dataNull_background"><h4 class="text-center">无数据</h4></div>');
        $('.dataNull_background').width(windowWidth);
        $('.dataNull_background').height('100%');
        $('.dataNull_background').css('background-color', '#eeeeee');
        $('.dataNull_background').children().eq(0).width(imageLong);
        $('.dataNull_background').children().eq(0).height(imageLong);
        $('.dataNull_background').css('padding-top', (noDataDivHeight - imageLong) / 2 - 50);
        $('.dataNull_background').children().eq(0).css('margin-left', 'auto');
        $('.dataNull_background').children().eq(0).css('margin-right', 'auto');
        $('.dataNull_background').children().eq(1).css('margin-top', '20px');
        $('.dataNull_background').children().eq(1).css('color', '#C4C4C4');
	}
	
	WechatPagination.prototype.onDataNoMore = function() {
		$(this.element).height('auto');
        $('#' + this.nodataId).remove();
        var noDataHtml = '<div class="pinterest_noData" id="' + this.nodataId + '">到底了...</div>';
        $(this.element).append(noDataHtml);
        $(this.element).css('height', 'auto');
        var $noData = $('#' + this.nodataId);
        $noData.css('float', 'left');
        $noData.css('width', '100%');
        $noData.css('height', '40px');
        $noData.css('background-color', '#eeeeee');
        $noData.css('text-align', 'center');
        $noData.css('line-height', '43px');
        $noData.css('color', 'black');
        $noData.css('box-shadow', 'inset 0px 3px 3px #C4C4C4');
        this.loadStatus = paginationProLoadingStatus["null"];
	}
	
	WechatPagination.prototype.removeLoading = function () {
        var $loading = $('#' + this.loadingId);
        $loading.remove();
    };
	
	return WechatPagination;
	
}());