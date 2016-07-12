<dl class="menu-nav">
	<dd class="navcontent">
		<ul>
		<#--<#list menuList as menuDO>-->
			<#--<#list menuDO.nomalChildMenusWithoutOperations as firstMenu>-->
			<#--<li>-->
               <#--<a href="#" class="channel"><span>${firstMenu.name!''}</span><i class="icon">></i></a>-->
               <#--<dl>-->
				<#--<#list firstMenu.nomalChildMenusWithoutOperations as secondMenu>-->
					<#--<dt>${secondMenu.name!''}</dt>-->
					<#--<dd>-->
					<#--<#list secondMenu.nomalChildMenusWithoutOperations as thirdMenu>-->
                        <#--&nbsp;&nbsp;|&nbsp;-->
						<#--<#assign targetUrl="/" + thirdMenu.menuUrl />-->
						<#--<#assign pathName=thirdMenu.name?trim />-->
						<#--<#assign targetTitle=thirdMenu.name?trim />-->
                        <#--<a href="javascript:void(0)" onclick="javascript:addGlobalsTab({'src':'${targetUrl!""}', 'pathName':'${pathName!""}'});return false;">${targetTitle!""}</a>-->
					<#--</#list>-->
					<#--</dd>-->
				<#--</#list>-->
                <#--</dl>-->
            <#--</li>-->
			<#--</#list>-->
		<#--</#list>-->
			<#--<li>&nbsp;</li>-->
			<li>
            	<a href="#" class="channel"><span>系统管理</span><i class="icon">></i></a>
                <dl>
					<dt>用户管理</dt>
					<dd>
                        <a href="javascript:void(0)" onclick="javascript:addGlobalsTab({'src':'/user/index.htm', 'pathName':'用户管理'});return false;">用户管理</a>
					</dd>
					<dt>字典管理</dt>
					<dd>
						<a href="javascript:void(0)" onclick="javascript:addGlobalsTab({'src':'/currency/index.htm', 'pathName':'字典管理'});return false;">字典管理</a>
					</dd>
				</dl>
            </li>
		</ul>
	</dd>
</dl>