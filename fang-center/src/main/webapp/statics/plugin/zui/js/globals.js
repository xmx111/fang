var Global = function(){
    var defaultOptions;
    return {
        hashCode: function (e) {
            var d = 0;
            if (e.length == 0) {
                return d;
            }
            for (var i = 0; i < e.length; i++) {
                var c = e.charCodeAt(i);
                d = ((d << 5) - d) + c;
                d = d & d;
            }
            if (d < 0) {
                d = - d;
            }
            return d;
        },
        notify : function (message, type, place) {
            var msg = new $.zui.Messager(message, {
                type : !!type ? (type == 'error' ? 'danger' : type) : 'default',
                placement: !!place ? place : 'center'
            });
            msg.show();
        },
        post : function (url, data, success, failure){
            $.ajax({
                type: 'POST',
                dataType: 'json',
                url: url,
                data: data,
                success: function(result){
                    if (result && result.status == "succeed") {
                        var message = result.message == '' ? '操作成功' : result.message;
                        Global.notify(message, 'success', 'bottom-right');
                        if (!!success){
                            success();
                        }
                    } else {
                        if (!!failure) {
                            failure(result);
                        }
                        var message = result.message == '' ? '555~~~,操作失败了，再来一次吧！' : result.message;
                        Global.notify(message, 'error');
                    }
                },
                error: function(jqXHR, textStatus, errorThrown){
                    Global.notify(jqXHR.responseText, 'error');
                }
            });
        },
        initGlobal : function(){
            defaultOptions = {
                datatype: 'json',
                gridview: true,
                rownumbers: false,
                autowidth: true,
                rowNum: 20,
                rowList: [10,20,30,40,50,100],
                // pager: '#gridPager',
                // sortname: 'orderdate',
                viewrecords: true,
                sortorder: 'desc',
                // caption: 'Preserving Selection on Client-side sorting',
                height: '100%'
            };
            $.fn.ajaxGetUrl = function(url, data, callback) {
                var div = $(this);
                $.ajax({
                    type: 'GET',
                    cache: false,
                    url: url,
                    data: data,
                    dataType: 'html',
                    success: function (htmlStr) {
                        div.html(htmlStr);
                        if (callback) {
                            callback.call();
                        }
                        $(window).resize();
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        div.html('<h4>页面内容加载失败</h4>' + jqXHR.responseText);
                        div.show();
                    },
                    statusCode: {
                        301: function () {
                            Global.notify('会话超时，请重新登录', 'error')
                        },
                        403: function () {
                            Global.notify('未授权访问', 'error')
                        },
                        404: function () {
                            Global.notify('页面未找到：' + url + '，请联系管理员', 'error')
                        }
                    }
                });
            };
            /**
             options 结构
             url : 数据url,
             addurl : 新增url,
             editurl : 修改url,
             deleteurl : 删除url,
             colModel : 列属性对象数组[] - {
                label:列的显示名称,
                name:表格列的名称，所有关键字，保留字都不能作为名称使用包括subgrid, cb and rn,
                width:列宽,
                align:水平位置 left, center, right,
                hidden:是否隐藏,
                editable:单元格是否可编辑,
                formatter:格式化
            }
             **/
            $.fn.initJqGrid = function (options) {
                var table = $(this);
                var colNames = new Array();
                var colModels = new Array();
                for (var i = 0; i < options.colModel.length; i ++){
                    colNames.push(options.colModel[i]['lable']);
                    var model = {};
                    model['name'] = options.colModel[i]['name'];
                    model['width'] = options.colModel[i]['width'];
                    model['align'] = options.colModel[i]['align'];
                    model['hidden'] = options.colModel[i]['hidden'];
                    model['editable'] = options.colModel[i]['editable'];
                    model['formatter'] = options.colModel[i]['formatter'];
                    colModels.push(model);
                }
                var _options = $.extend(defaultOptions, options);
                _options['colNames'] = colNames;
                _options['colModel'] = colModels;
                // 加分页div
                if (!options['pager']){
                    pagerId = table.attr('id') + '-pager';
                    $('<div id=\'' + pagerId + '\'/>') .insertAfter(table);
                    _options['pager'] = '#' + pagerId;
                }
                table.jqGrid(_options);
                // 查询
                table.closest('.grid-main').find('.btn-query').click(function(){
                    var form = $(this).closest('form');
                    table.jqGrid({
                        url: _options['url'] + (options['url'].indexOf('?')>0 ? '&' : '?') + form.serialize()
                    }).trigger("reloadGrid");
                });
                table.closest('.grid-main').find('.btn-repeat').click(function(){
                    $(this).closest('form').reset();
                    table.jqGrid({
                        url: _options['url']
                    }).trigger("reloadGrid");
                });
                table.closest('.grid-main').find('.btn-export').click(function(){
                    
                });
                // 加增删改
                var pagerId = _options['pager'];
                table.navGrid(pagerId, {edit:false,add:false,del:false,search:false});
                if (!!options['deleteUrl']) {
                    table.navButtonAdd(pagerId, {
                        caption: "",
                        buttonicon: "ui-icon-trash",
                        onClickButton: function () {
                            if (!table.jqGrid('getGridParam', 'selrow'))
                                $.zui.messager.show('请选择一行！', {type: 'warning', placement: 'center', time: '1500'});
                            $.zui.modalTrigger.show({
                                title: '删除',
                                custom: '<div class="form-input"><div class="row"><div class="col-md-12">'
                                + '是否删除所选记录？'
                                + '</div></div></div><div class="form-footer"><button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <button type="button" id="btn-nm-delete" class="btn btn-primary">确认</button> </div>',
                                size: 'sm'
                            });
                            $('#btn-nm-delete').click(function(){
                                Global.post(options['deleteUrl'], {id:table.jqGrid('getRowData', table.jqGrid('getGridParam', 'selrow')).id}, function(){
                                    table.trigger("reloadGrid");
                                });
                            });
                        },
                        position: "first"
                    });
                }
                if (!!options['editUrl']) {
                    table.navButtonAdd(pagerId, {
                        caption: "",
                        buttonicon: "ui-icon-pencil",
                        onClickButton: function () {
                            if (!table.jqGrid('getGridParam', 'selrow'))
                                $.zui.messager.show('请选择一行！', {type: 'warning', placement: 'center', time: '1500'});
                            $.zui.modalTrigger.show({
                                title: '修改',
                                size: 'lg',
                                remote: options['editUrl'] + (options['deleteUrl'].indexOf('?')>0 ? '&' : '?')  + 'id=' + table.jqGrid('getRowData', table.jqGrid('getGridParam', 'selrow')).id
                            });
                        },
                        position: "first"
                    });
                }
                if (!!options['addUrl']) {
                    table.navButtonAdd(pagerId, {
                        caption: "",
                        buttonicon: "ui-icon-plus",
                        onClickButton: function () {
                            $.zui.modalTrigger.show({
                                title: '新增',
                                size: 'lg',
                                remote: options['addUrl']
                            });
                        },
                        position: "first"
                    });
                }
                table.jqGrid('gridResize', {
                    minWidth: 500,
                    minHeight: 200
                });
            };
            $.fn.queryJqGrid = function (options) {
                // 查询
            };
            $(window) .resize(function () {
                if ($.fn.jqGrid) {
                    $('table.ui-jqgrid-btable:visible') .each(function () {
                        var table = $(this);
                        var width = table.jqGrid('getGridParam', 'width');
                        var height = table.jqGrid('getGridParam', 'height');
                        var parentWidth = table.closest('div.ui-jqgrid').parent('div') .width();
                        var parentHeight = table.closest('div.ui-jqgrid').closest('div#mainContent') .height() - 179;
                        if (width != parentWidth || height != parentHeight) {
                            if (width != parentWidth) table.jqGrid('setGridWidth', parentWidth);
                            if (height != parentHeight) table.jqGrid('setGridHeight', parentHeight);
                            var e = $(this) .jqGrid('getGridParam', 'groupHeader');
                            if (e) {
                                table.jqGrid('destroyGroupHeader');
                                table.jqGrid('setGroupHeaders', e)
                            }
                        }
                    });
                }
            });
            // 菜单加标签
            $('body').on('click', '.container-main > .sidebar > nav a', function(e){
                e.preventDefault();
                $('.container-main .menu li .sub-menu i').removeClass("icon-spin");
                $(this).find('.icon').addClass("icon-spin");
                var a = $(this);
                var url = a.attr('data-url');
                if (!url || url == 'javascript:;')
                    return;
                $('#mainContent').ajaxGetUrl(url);
            });
        }
    }
}();