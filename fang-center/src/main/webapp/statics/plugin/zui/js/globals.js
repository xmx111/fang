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
                type : type == 'error' ? 'danger' : type,
                placement: !place ? 'center' : place
            });
            msg.show();
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
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        div.html('<h4>页面内容加载失败</h4>' + jqXHR.responseText);
                        div.show();
                    },
                    statusCode: {
                        301: function () {
                            Global.notify('error', 'URL: ' + url, '会话超时，请重新登录')
                        },
                        403: function () {
                            Global.notify('error', 'URL: ' + url, '未授权访问')
                        },
                        404: function () {
                            Global.notify('error', '页面未找到：' + url + '，请联系管理员', '请求资源未找到')
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
                    pagerId = table.attr('id') + '_pager';
                    $('<div id=\'' + pagerId + '\'/>') .insertAfter(table);
                    _options['pager'] = '#' + pagerId;
                }
                table.jqGrid(_options);
                table.jqGrid('gridResize', {
                    minWidth: 500,
                    minHeight: 100
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
                        var parentWidth = table.closest('div.ui-jqgrid').parent('div') .width();
                        if (width != parentWidth) {
                            table.jqGrid('setGridWidth', parentWidth);
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