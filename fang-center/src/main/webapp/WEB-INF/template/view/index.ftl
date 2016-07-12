<!DOCTYPE html>
<html>
<head>
    <#assign webroot="${request.getContextPath()}">
    <title>${title}</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="description" content="${description}"/>
    <#--easyUI样式文件-->
    <link rel="stylesheet" type="text/css" href="${webroot}/statics/plugin/easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="${webroot}/statics/plugin/easyui/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="${webroot}/statics/css/css.css"/>
    <link rel="stylesheet" type="text/css" href="${webroot}/statics/css/reset.css"/>
    <#list css_url as src>
        <link rel="stylesheet" type="text/css" href="${src}"/>
    </#list>
    <#--jQuery js文件-->
    <script type="text/javascript" src="${webroot}/statics/plugin/jquery/jquery-1.12.0.min.js"></script>
    <script type="text/javascript" src="${webroot}/statics/plugin/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${webroot}/statics/plugin/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${webroot}/statics/js/validata.js"></script>
    <script type="text/javascript" src="${webroot}/statics/js/utils.js"></script>

    <#--config-->
    <script>
        $(function(){
            $('.menu-nav').parent().parent().css({'overflow':'visible','z-index':4, 'padding-top':5}
            );
        });
        var config={
            'targetUrl':'',
            'targetPathName':'首页',
            'homeUrl':'/index.htm'
        };
    </script>

    <#--js全局js，使用的了config，必须放在cofig下面-->
    <script type="text/javascript" src="${webroot}/statics/js/globals.js"></script>
    <#--页面功能script文件,必须放在globals.js后面-->
    <script type="text/javascript" src="${webroot}/statics/js/index.js"></script>

    <#--用于调整菜单自适应页面-->
    <script>
        jQuery(function($){
            $('.navcontent li dl').each(function(item){
                var dlHeight = $(this).outerHeight(),
                        toTop = $(this.parentNode).offset().top + parseInt($(this.parentNode).css('height')),
                        toBottom = $(window).height() - $(this.parentNode).offset().top;
                if(dlHeight <= toBottom){
                    return
                }else{
                    if(dlHeight <= toTop){
                        $(this).css('bottom', '-1px');
                        $(this).css('top', 'auto');
                    }else{
                        var tempTop = dlHeight/2;
                        if(tempTop <= $(this.parentNode).offset().top){
                            $(this).css('top', -tempTop + 'px');
                        }else{
                            $(this).css('top', -$(this.parentNode).offset().top + 'px');
                        }
                        $(this).css('bottom', 'auto');
                    }
                }
            })
        });
    </script>
</head>
<body class="easyui-layout" ${bodyAttributes} style="background:#8DB2E3" >
<!--[if lte IE 7]>
<style type="text/css">
    #header, #nva-layout, #content-layout {
        display: none !important;
    }
    body{
        background:#e3f0f8;
    }
</style>
<div id="ie6-users">
    <div id="ie6-users-wrap">
        亲爱的IE6、IE7内核用户,web技术在发展而您一直停留在过去，因为你使用的是过时的浏览器。
        <img alt="Ie7" src="$statics/css/images/ie7.png" />
        <br/>
        <br/>
        本网站使用的技术，你的旧浏览器并不支持。
        <br/>
        请安装一个更聪明的浏览器，或升级IE到IE8+。比如：
        <br/>
        <a id="ie8" href="http://windows.microsoft.com/zh-CN/internet-explorer/downloads/ie-8/">IE 8+</a>
    </div>
</div>
<![endif]-->
<div id="header" region="north" border="false">
    <#include "layout/head.ftl"/>
</div>
<div id="nva-layout" region="west" border="false" >
    <#include "layout/menu.ftl"/>
</div>
<div id="mm" class="easyui-menu" style="width:150px;">
    <div id="mm-newwindow">新建窗口打开</div>
    <div id="mm-newiframewindow">新建框架窗口打开</div>
    <div id="mm-tabcopytab">复制标签打开</div>
    <div class="menu-sep"></div>
    <div id="mm-tabrefresh">刷新</div>
    <div class="menu-sep"></div>
    <div id="mm-tabclose">关闭</div>
    <div id="mm-tabcloseall">关闭全部</div>
    <div id="mm-tabcloseother">关闭其他</div>
    <div class="menu-sep"></div>
    <div id="mm-tabcloseright">关闭右侧标签</div>
    <div id="mm-tabcloseleft">关闭左侧标签</div>
    <div class="menu-sep"></div>
    <div id="mm-tablock">锁定标签</div>
    <div id="mm-tabunlock">解锁标签</div>
    <div style="display:none;"><a id="link" href="javascript:void(0);" target="_blank">link</a></div>
</div>
<div id="content-layout" region="center" border="false">
    <div class="easyui-layout"  fit="true" border="false">
        <div id="main-layout" region="center" border="false">
            <div class="easyui-tabs" id="Globals_Data_Tab" fit="true" border="false">

            </div>
            <#--密码弹出框-->
            <#--$control.setTemplate('hrs/common/modifyPassword.vm')-->
        </div>
    </div>
</div>
</body>
</html>