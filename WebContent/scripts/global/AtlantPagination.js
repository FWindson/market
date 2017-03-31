var AtlantPagination = (function () {
    function AtlantPagination(_reqUrl, _callbackDataFun, _reqMethod, postData, _rootDom) {
    	debugger
        //根节点无元素(采用JQuery表达式)，如".pageContainer"
        this.rootDom = ".pageContainer";
        //请求方式：默认GET，非GET即POST
        this.reqMethod = "GET";
        //唯一键
        this.unionKey = parseInt((1000000 * Math.random()).toString()).toString();
        //总记录数
        this.totalRecord = 0;
        //每页记录数
        this.pageSize = 10;
        //总页数
        this.totalPage = 1;
        //当前页
        this.pageIndex = 1;
        this.reqUrl = _reqUrl;
        this.callbackDataFun = _callbackDataFun;
        if (_reqMethod) {
            this.reqMethod = _reqMethod;
            if (_reqMethod.toLowerCase() == 'post') {
                this.postData = postData;
            }
        }
        if (_rootDom) {
            this.rootDom = _rootDom;
        }
        this.render();
        this.initPageEvent();
        this.getData();
    }
    //渲染分页控件并显示
    AtlantPagination.prototype.render = function () {
        this.Id_pageSizeComp = "pageSizeComp" + this.unionKey;
        this.Id_InputPageComp = "InputPageComp" + this.unionKey;
        this.Id_TotalPageComp = "TotalPageComp" + this.unionKey;
        this.Id_RefreshPageBtn = "RefreshPageBtn" + this.unionKey;
        this.Id_FirstPageBtn = "FirstPageBtn_" + this.unionKey;
        this.Id_LastPageBtn = "LastPageBtn_" + this.unionKey;
        this.Id_BeforePageBtn = "BeforePageBtn_" + this.unionKey;
        this.Id_AfterPageBtn = "AfterPageBtn_" + this.unionKey;
        var _html = "";
        _html += "<div style='font-size: 1.2em; padding: 10px; height: 55px; background-color:#DFDFDF;'>";
        _html += "  <div class='col-md-3'>";
        _html += "      <select id='" + this.Id_pageSizeComp + "' class='form-control' style='width:auto;'>";
        _html += "          <option value='10'>每页10条</option>";
        _html += "          <option value='15'>每页15条</option>";
        _html += "          <option value='20'>每页20条</option>";
        _html += "          <option value='25'>每页25条</option>";
        _html += "      </select>";
        _html += "  </div>";
        _html += "  <div class='col-md-9'>";
        _html += "      <div class='pull-right'>";
        _html += "          <span class='glyphicon glyphicon-refresh' id='" + this.Id_RefreshPageBtn + "'></span>";
        _html += "          <span class='glyphicon glyphicon-step-backward' id='" + this.Id_FirstPageBtn + "' style='margin-left: 15px;'></span>";
        _html += "          <span class='glyphicon glyphicon-backward' id='" + this.Id_BeforePageBtn + "' style= 'margin-left: 10px; margin-right:10px;'></span>";
        _html += "          <span>";
        _html += "              <span style='margin-right:10px;'>转至</span>";
        _html += "              <input id='" + this.Id_InputPageComp + "' type='text' class='form-control' style='width: 40px; text-align: center; display: inline;' value='1' />";
        _html += "              <span style='margin-left:10px;'>页</span>/<span id='" + this.Id_TotalPageComp + "'></span>";
        _html += "          </span>";
        _html += "          <span class='glyphicon glyphicon-forward' id='" + this.Id_AfterPageBtn + "' style= 'margin-left: 10px; margin-right:10px;'></span>";
        _html += "          <span class='glyphicon glyphicon-step-forward' id='" + this.Id_LastPageBtn + "'></span>";
        _html += "      </div>";
        _html += "  </div>";
        _html += "</div>";
        $(this.rootDom).empty();
        $(this.rootDom).append(_html);
    };
    //初始化分页控件事件
    AtlantPagination.prototype.initPageEvent = function () {
        var _this = this;
        //每页记录数选择事件
        $("#" + this.Id_pageSizeComp).on('change', function () {
            _this.pageSize = $(this).val();
            _this.goToPage(_this.pageIndex);
        });
        //页数跳转事件
        $("#" + this.Id_InputPageComp).on('keydown', function (e) {
            if (e.keyCode == 13) {
                var _reg = /^[1-9]\d*$/;
                var _tmpVa = $(this).val().trim();
                if (_reg.test(_tmpVa)) {
                    _this.goToPage(_tmpVa);
                }
            }
        });
        //刷新点击事件
        $("#" + this.Id_RefreshPageBtn).on('click', function () {
            _this.goToPage(_this.pageIndex);
        });
        //首页点击事件
        $("#" + this.Id_FirstPageBtn).on('click', function () {
            _this.goToPage(1);
        });
        //尾页点击事件
        $("#" + this.Id_LastPageBtn).on('click', function () {
            _this.goToPage(_this.totalPage);
        });
        //上一页点击事件
        $("#" + this.Id_BeforePageBtn).on('click', function () {
            _this.goToPage(_this.pageIndex - 1);
        });
        //下一页点击事件
        $("#" + this.Id_AfterPageBtn).on('click', function () {
            _this.goToPage(_this.pageIndex + 1);
        });
    };
    //跳转到指定页
    AtlantPagination.prototype.goToPage = function (toPage) {
        this.pageIndex = toPage;
        if (toPage < 1) {
            this.pageIndex = 1;
        }
        if (toPage > this.totalPage) {
            this.pageIndex = this.totalPage;
        }
        this.getData();
    };
    //刷新分页信息
    AtlantPagination.prototype.refreshPageInfo = function (totalRecord) {
        this.totalRecord = totalRecord;
        this.totalPage = parseInt((this.totalRecord / this.pageSize).toString());
        if (this.totalRecord % this.pageSize > 0) {
            this.totalPage = this.totalPage + 1;
        }
        if (this.totalPage < 1) {
            this.totalPage = 1;
        }
        $('#' + this.Id_InputPageComp).val(this.pageIndex.toString());
        $('#' + this.Id_TotalPageComp).html(this.totalPage.toString());
    };
    //获取数据
    AtlantPagination.prototype.getData = function () {
        var _this = this;
        var _tmpReqUrl = this.reqUrl;
        if (this.reqUrl.indexOf("?") < 1) {
            _tmpReqUrl = _tmpReqUrl + "?1=1";
        }
        _tmpReqUrl = _tmpReqUrl + "&pageIndex=" + this.pageIndex + "&pageSize=" + this.pageSize;
        var ajaxObject = {
            url: _tmpReqUrl,
            method: this.reqMethod,
            success: function (_data) {
                _this.callbackDataFun(_data);
                _this.refreshPageInfo(_data.TotalRecord);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.responseText);
                console.log(XMLHttpRequest.responseText);
                console.log(textStatus);
                console.log(errorThrown);
            }
        };
        if (this.postData != null) {
            ajaxObject.data = this.postData;
        }
        $.ajax(ajaxObject);
    };
    //改变查条件
    AtlantPagination.prototype.changeReqUrl = function (_changeUrl) {
        this.reqUrl = _changeUrl;
        this.goToPage(1);
    };
    //更改POST数据
    AtlantPagination.prototype.changePostData = function (_postData) {
        this.postData = _postData;
        this.goToPage(1);
    };
    //重新加载
    AtlantPagination.prototype.reload = function () {
        this.goToPage(this.pageIndex);
    };
    return AtlantPagination;
}());
//# sourceMappingURL=AtlantPagination.js.map