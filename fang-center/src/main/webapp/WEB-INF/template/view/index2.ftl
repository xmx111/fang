<!DOCTYPE html>
<html lang="zh-cn">
    <head>
        <#assign webroot="${request.getContextPath()}">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Hello world!</title>
        <!-- zui -->
        <link href="${webroot}/statics/plugin/zui/css/zui.css" rel="stylesheet" />
        <link href="${webroot}/statics/plugin/jqgrid/css/ui.jqgrid.css" rel="stylesheet" />
        <link href="/statics/plugin/jqueryui/jquery-ui.css"rel="stylesheet" />
        <link href="${webroot}/statics/css/index.css" rel="stylesheet" />
    </head>
    <body class="compact-mode compact-mode-in">
        <!-- 在此处挥洒你的创意 begin -->
        <!-- head -->
        <header id="header" class="bg-primary with-shadow">
            <div class="navbar navbar-inverse navbar-fixed-top" id="navbar" role="banner">
                <div class="container">
                    <div class="navbar-header">
                        <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".zui-navbar-collapse">
                            <span class="sr-only">切换导航</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a href="/" class="navbar-brand"><span class="path-zui-36"><i class="path-1"></i><i class="path-2"></i></span> <span class="brand-title">管理系统</span><small class="zui-version"></small> <i data-toggle="tooltip" id="compactTogger" data-placement="bottom" class="icon icon-home"></i></a>
                    </div>
                    <nav class="collapse navbar-collapse zui-navbar-collapse">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a title="用户信息" href="https://github.com/easysoft/zui" target="_blank"><i class="icon icon-user"></i><span> 用户</span></a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </header>
        <!-- head -->
        <!-- container -->
        <div class="container-main container-fluid" contenteditable="false">
            <div class="col-sm-3 col-md-2 sidebar">
                <nav class="menu" data-toggle="menu">
                    <ul class="nav nav-primary">
                        <li class="nav-parent">
                            <a href="javascript:;"><i class="icon-download-alt"></i> 房源采集<i class="icon-chevron-right nav-parent-fold-icon"></i></a>
                            <ul class="nav">
                                <li><a href="javascript:;" data-url="${webroot}/collect/housesource/index.htm" class="sub-menu"><i class="icon icon-cog"></i> 个人房源信息 </a></li>
                                <li><a href="javascript:;" data-url="${webroot}/test.htm" class="sub-menu"><i class="icon icon-cog"></i> 我收藏的房源 </a></li>
                                <li><a href="javascript:;" data-url="" class="sub-menu"><i class="icon icon-cog"></i> 采集网站申请 </a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:;"><i class="icon-list"></i> 房源列表<i class="icon-chevron-right nav-parent-fold-icon"></i></a>
                            <ul class="nav">
                                <li><a href="javascript:;" data-url="" class="sub-menu"><i class="icon icon-cog"></i> 出售房源管理 </a></li>
                                <li><a href="javascript:;" data-url="" class="sub-menu"><i class="icon icon-cog"></i> 出租房源管理 </a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:;"><i class="icon-rocket"></i> 房源发布<i class="icon-chevron-right nav-parent-fold-icon"></i></a>
                            <ul class="nav">
                                <li><a href="javascript:;" data-url="" class="sub-menu"><i class="icon icon-cog"></i> 出售房源录入 </a></li>
                                <li><a href="javascript:;" data-url="" class="sub-menu"><i class="icon icon-cog"></i> 出售房源发布 </a></li>
                                <li><a href="javascript:;" data-url="" class="sub-menu"><i class="icon icon-cog"></i> 出租房源发布 </a></li>
                                <li><a href="javascript:;" data-url="" class="sub-menu"><i class="icon icon-cog"></i> 出租房源录入 </a></li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="col-sm-9 col-md-10 main">
                <div id="mainContent">
                    <p>口是心非你深情的承诺</p>
                    <p>都随着西风飘渺远走</p>
                    <p>痴人梦话我钟情的倚托</p>
                    <p>就像枯萎凋零的花朵</p>
                </div>
            </div>
        </div>
        <!-- main -->
        <!-- 在此处挥洒你的创意 end -->
        <script language="JavaScript">
            var ctx = '${webroot}';
        </script>
        <!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
        <script src="${webroot}/statics/plugin/jquery/jquery-1.12.0.min.js"></script>
        <!-- ZUI Javascript组件 -->
        <script src="${webroot}/statics/plugin/zui/js/zui.js"></script>
        <!-- jqGrid Javascript组件 -->
        <script src="${webroot}/statics/plugin/jqgrid/js/i18n/grid.locale-cn.js"></script>
        <script src="${webroot}/statics/plugin/jqgrid/js/jquery.jqGrid.min.js"></script>
        <!-- 全局 Javascript -->
        <script src="${webroot}/statics/plugin/zui/js/globals.js"></script>
        <script src="${webroot}/statics/js/index2.js"></script>
    </body>
</html>