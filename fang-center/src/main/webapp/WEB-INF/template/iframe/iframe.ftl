<#macro html js_config js_url title="后台管理系统" description="后台管理系统" bodyAttributes="" >
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
    <#--jQuery js文件-->
    <script type="text/javascript" src="${webroot}/statics/plugin/jquery/jquery-1.12.0.min.js"></script>
    <#--easyUI js文件-->
    <script type="text/javascript" src="${webroot}/statics/plugin/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${webroot}/statics/plugin/easyui/locale/easyui-lang-zh_CN.js"></script>
    <#--ztree js文件-->
    <script type="text/javascript" src="${webroot}/statics/plugin/ztree/js/jquery.ztree.all.js"></script>
    <#--日期控件 js文件-->
    <script type="text/javascript" src="${webroot}/statics/plugin/My97DatePicker/WdatePicker.js"></script>
    <#--验证js-->
    <script type="text/javascript" src="${webroot}/statics/js/validata.js"></script>
    <#--js工具包-->
    <script type="text/javascript" src="${webroot}/statics/js/utils.js"></script>
    <#--附件上传-->
    <script type="text/javascript" src="${webroot}/statics/plugin/swfupload/swfupload.js"></script>
    <script type="text/javascript" src="${webroot}/statics/plugin/swfupload/swfupload.queue.js"></script>
    <script type="text/javascript" src="${webroot}/statics/plugin/swfupload/fileprogress.js"></script>
    <script type="text/javascript" src="${webroot}/statics/plugin/swfupload/handlers.js"></script>

    <#--config-->
    <script>
        var config={
        <#list js_config as config>
            ${config}<#if config_has_next>,</#if>
        </#list>
        };
    </script>
    <#--js全局js，使用的了config，必须放在cofig下面-->
    <script type="text/javascript" src="${webroot}/statics/js/globals.js"></script>
    <#--页面功能script文件-->
    <#list js_url as src>
    <script type="text/javascript" src="${src}"></script>
    </#list>
    <script>
        $(function(){
            $('.erpnav').parent().parent().css({'overflow':'visible','z-index':4, 'padding-top':5})
        });
    </script>
</head>
<body ${bodyAttributes} class="easyui-layout" onKeyDown="preventBSK()">
<!--[if lte IE 7]>
<style type="text/css">
    #main{
        display: none !important;
    }
    body{
        background:#e3f0f8;
    }
</style>
<div id="ie6-users">
    <div id="ie6-users-wrap">
        亲爱的IE6、IE7内核用户,web技术在发展而您一直停留在过去，因为你使用的是过时的浏览器。<img alt="Ie7" src="$statics/css/images/ie7.png" /><br/><br/>
        本网站使用的技术，你的旧浏览器并不支持。<br/>
        请安装一个更聪明的浏览器，或升级IE到IE8+。比如：<br/>
        <a id="ie8" href="http://windows.microsoft.com/zh-CN/internet-explorer/downloads/ie-8/">IE 8+</a>
    </div>
</div>
<![endif]-->
<#nested/>
</body>
</html>
</#macro>