<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=8" />
    <meta charset="utf-8" />
    <title>ERP管理系统</title>
    <#--<link rel="icon" href="http://img01.taobaocdn.com/tps/i1/T1aEtTXe4mXXXXXXXX-16-16.png" type="image/x-icon" />-->
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <link rel="stylesheet" type="text/css" href="/statics/css/css.css"/>
    <link rel="stylesheet" type="text/css" href="/statics/css/reset.css"/>
    <script type="text/javascript" src="/statics/plugin/jquery/jquery-1.12.0.min.js"></script>
    <base target="_self" />
</head>

<body class="erpgo">
<!--[if lte IE 7]>
<style type="text/css">
    .box{
        display: none !important;
    }
    body{
        background:#D2C0B4;
    }
</style>
<div id="ie6-users">
    <div id="ie6-users-wrap">
        亲爱的IE6、IE7内核用户,web技术在发展而您一直停留在过去，因为你使用的是过时的浏览器。<img alt="Ie7" src="/statics/css/images/ie7.png" /><br/><br/>
        本网站使用的技术，你的旧浏览器并不支持。<br/>
        请安装一个更聪明的浏览器，或升级IE到IE8+。比如：<br/>
        <a id="ie8" href="http://windows.microsoft.com/zh-CN/internet-explorer/downloads/ie-8/">IE 8+</a>
    </div>
</div>
<![endif]-->
    <div class="box">
        <div class="login">
            <form name="loginForm" action="/doLogin.htm" method="post">
                <div class="wrongwrap"></div>
                <ul>
                    <li>
                        <label>用户名：</label>
                        <input type="text" name="username" value="" maxlength="20" tabindex="1" />
                    </li>
                    <li>
                        <label>密　码：</label>
                        <input type="password" name="password" value="" maxlength="20" tabindex="2" />
                    </li>
                </ul>
                <div>
                    <button name="">登 录</button>
                    <a style="color:#fff; font-size:14px;" href="" target="_blank">忘记密码？</a>
                </div>
            </form>
        </div>
    </div>
</body>
</html>