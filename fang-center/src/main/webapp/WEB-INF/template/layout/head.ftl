<#if Session["loginStatus"]=="login">
<#assign isLogin = true />
</#if>
<#assign username=Session["_na_"] />
	    <a href="/index.htm">
		<div class="logo">
			嗨淘网ERP系统
		</div>
		</a>
		
		<div class="userinfo">
		<#if isLogin?exists>
			<span>Hi ! ${username!''}</span>
			&nbsp;
			<a href="/logout.htm">退出</a>
			&nbsp;|&nbsp;
			<a href="javascript:void(0);" onclick="UI.open('Modify_Password_Data_Dialog')">修改密码</a>
			
        <#else>
        	<div><span>未登录</span><span>[<a href='/login.htm'>登录</a>]</span></div>
		</#if>
		
		</div>
