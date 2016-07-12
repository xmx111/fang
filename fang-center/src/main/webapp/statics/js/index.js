var homeIndexPathName = "首页";

$(function() {
	var tab = $('#Globals_Data_Tab');
	
	//关闭所有tab后自动打开首页
	tab.tabs(
	{
		onClose:function(title){
			 var tabs = tab.tabs('tabs');
			if(tabs.length == 0) {
				addHomeTab();
			}
		}
	});
	
	var targetUrl = config.targetUrl;
	if(targetUrl != "" && config.targetPathName != homeIndexPathName) {
		addGlobalsTab({'src': config.targetUrl, 'pathName':config.targetPathName});
	} else {
		addHomeTab();
	}

	bindTabEvent();
	bindTabMenuEvent();
});

function addHomeTab() {
		var tab = $('#Globals_Data_Tab');
		var title = "首页";
		if(!tab.tabs('exists',title)) {
			tab.tabs('add',{
		    title: title,
		    //content:'<div class="easyui-tabs" id="Data_Tabs" fit="true" border="false"><div title="我的面板"  ><div class="index"><br>&nbsp;&nbsp;欢迎您登录HiTaoERP系统！ </div></div></div>',
			content:'<iframe src="/main.htm" scrolling="no" frameborder="0"  height="98%" width="100%"/><div name="pathName" style="display:none">'+homeIndexPathName+'</div>',
		    closable:false
			});
		} 
}

function addGlobalsTab(options) {
	var tab = $('#Globals_Data_Tab');
    var tabs = tab.tabs('tabs');
	if(tabs.length > 10) {
		$.messager.alert('提示','tab页打开过多，请关闭几个再打开!');
		return false;	
	}
	
	var src = options.src;
	var pathName = options.pathName;
	
	//默认以三级菜单的名称做标题，如果指定了标题，则使用指定标题
	var title = "tab";
	if(options.title) {
		title = options.title;
	} else {
		title = pathName;
	}

	if(tab){
		tab.tabs('close', title);
		tab.tabs('add',{
			title:title,
			closable:true,
			bodyCls:'overflow-hidden',
			content: createFrame(src, pathName)
		});
	} 
}

function createFrame(src, pathName) {
	return '<iframe src="'+ src + '" scrolling="no" frameborder="0"  height="100%" width="100%"/><div name="pathName" style="display:none">'+ pathName +'</div>';
}

//绑定tab的双击事件、右键事件
function bindTabEvent(){
	var tab = $('#Globals_Data_Tab');
	$(document).on('dblclick','.tabs-inner',function(){
        var subtitle = $(this).children("span").text();
        if($(this).next().is('.tabs-close')){
	        tab.tabs('close',subtitle);
        }
    });

	$(document).on('contextmenu','.tabs-inner',function(e){

		//如果是首页，只纸质刷新，和关闭全部
		if($(this).text() == '首页') {
			$('#mm-tabcopytab').attr('style','display:none');
			$('#mm-tablock').attr('style','display:none');
			$('#mm-tabunlock').attr('style','display:none');
			$('#mm-tabclose').attr('style','display:none');
			$('#mm-tabcloseleft').attr('style','display:none');
			$('#mm-tabcloseright').attr('style','display:none');
			$('#mm-tabcloseother').attr('style','display:none');
			$('#mm-newwindow').attr('style','display:block');
			$('#mm-newiframewindow').attr('style','display:block');
			$('.menu-sep').attr('style','display:none');
		} else {
			$('#mm-tabcopytab').attr('style','display:block');
			$('#mm-tablock').attr('style','display:block');
			$('#mm-tabunlock').attr('style','display:block');
			$('#mm-tabclose').attr('style','display:block');
			$('#mm-tabcloseleft').attr('style','display:block');
			$('#mm-tabcloseright').attr('style','display:block');
			$('#mm-tabcloseother').attr('style','display:block');
			$('#mm-newwindow').attr('style','display:block');
			$('#mm-newiframewindow').attr('style','display:block');
			$('.menu-sep').attr('style','display:block');
		}
		
		var currtab_title = $(this).text();
		var currentTab = tab.tabs('getTab', currtab_title); 
		var iframe = $(currentTab.panel('options').content);
		var src = iframe.attr('src');
		
		//shopware的右键菜单不支持复制，新窗口
		if(isShopwareMenu(src)) {
			$('#mm-tabcopytab').attr('style','display:none');
			$('#mm-newiframewindow').attr('style','display:none');
			$($('.menu-sep')[0]).attr('style','display:none');
		}
		
        $('#mm').menu('show', {
            left: e.pageX,
            top: e.pageY
     	});
	
	     var subtitle =$(this).children("span").text();
	     $('#mm').data("currtab",subtitle);
	     return false;
	});
 }
 
//绑定tab右键菜单事件
function bindTabMenuEvent() {
	var tab = $('#Globals_Data_Tab');

	//刷新当前
	$('#mm-tabrefresh').click(function() {
		var currtab_title = $('#mm').data("currtab");
		var currentTab = tab.tabs('getTab', currtab_title); 
		var iframe = $(currentTab.panel('options').content);
		var src = iframe.attr('src');
		tab.tabs('update', {
		tab: currentTab,
		options: {
		content: createFrame(src, currentTab.children("div[name='pathName']").text())
		}
		}); 
		tab.tabs('select', currtab_title);
	});

	//关闭当前
	$("#mm-tabclose").click(function(){
       var currtab_title = $('#mm').data("currtab");
		$('.tabs-inner span').each(function(i, n) {
			if ($(this).parent().next().is('.tabs-close')) {
				var t = $(n).text();
				if (t == currtab_title)
					tab.tabs('close', t);
			}
		});
    });
	
	//全部关闭
	$('#mm-tabcloseall').click(function() {
		$('.tabs-inner span').each(function(i, n) {
			if ($(this).parent().next().is('.tabs-close')) {
				var t = $(n).text();
				tab.tabs('close', t);
			}
		});
	});
	
	//关闭除当前之外的TAB
	$('#mm-tabcloseother').click(function() {
		var currtab_title = $('#mm').data("currtab");
		$('.tabs-inner span').each(function(i, n) {
			if ($(this).parent().next().is('.tabs-close')) {
				var t = $(n).text();
				if (t != currtab_title)
					tab.tabs('close', t);
			}
		});
	});
	
	//关闭当前右侧的TAB
	$('#mm-tabcloseright').click(function() {
		var nextall = $('.tabs-selected').nextAll();
		if (nextall.length == 0) {
			return false;
		}
		nextall.each(function(i, n) {
			if ($('a.tabs-close', $(n)).length > 0) {
				var t = $('a:eq(0) span', $(n)).text();
				tab.tabs('close', t);
			}
		});
		return false;
	});
	
	//关闭当前左侧的TAB
	$('#mm-tabcloseleft').click(function() {
		var prevall = $('.tabs-selected').prevAll();
		if (prevall.length == 1) {
			return false;
		}
		prevall.each(function(i, n) {
			if ($('a.tabs-close', $(n)).length > 0) {
				var t = $('a:eq(0) span', $(n)).text();
				tab.tabs('close', t);
			}
		});
		return false;
	});
	
	//新窗口打开TAB，带菜单
	$('#mm-newiframewindow').click(function() {
		var currtab_title = $('#mm').data("currtab");
		var currentTab = tab.tabs('getTab', currtab_title); 
		var iframe = $(currentTab.panel('options').content);
		var src = iframe.attr('src');
		$("#link").attr("href", src);
		$("#link")[0].click();
	});
	
	//新框架窗口打开TAB,不带菜单
	$('#mm-newwindow').click(function() {
		var currtab_title = $('#mm').data("currtab");
		var currentTab = tab.tabs('getTab', currtab_title); 
		var href = config.homeUrl;
		if(currentTab.panel('options').title != '首页') {
			var iframe = $(currentTab.panel('options').content);
			var src = iframe.attr('src');
			var pathName = currentTab.children("div[name='pathName']").text();
			var encodeSrc = encodeURI(src);
			var encodePathName = encodeURI(pathName);
			href = config.homeUrl + "?tu=" + encodeSrc + "&pn=" + encodePathName + "&_input_charset=UTF-8";
		}
		$("#link").attr("href", href);
		$("#link")[0].click();
	});
	
	//锁定当前tab
	$('#mm-tablock').click(function() {
		var currentTab = tab.tabs('getSelected'); 
		var currtab_title = $('#mm').data("currtab");
		$('.tabs-inner span').each(function(i, n) {
			if(currentTab.panel('options').title != '首页') {
				if ($(this).parent().next().is('a.tabs-close')) {
					var t = $(n).text();
					if (t == currtab_title) {
						$(this).parent().next().remove();
					}
				}
			}
		});
		tab.tabs('select', currtab_title);
	});
	
		//解锁当前tab
	$('#mm-tabunlock').click(function() {
		var tabcolseTag = '<a class="tabs-close" href="javascript:void(0)"></a>';
		var currtab_title = $('#mm').data("currtab");
		var currentTab = tab.tabs('getTab', currtab_title); 
		$('.tabs-inner span').each(function(i, n) {
			if(currentTab.panel('options').title != '首页') {
				if (!$(this).parent().next().is('a.tabs-close')) {
					var t = $(n).text();
					if (t == currtab_title) {
						$(this).parent().parent().append(tabcolseTag);
					}
				}
			}
		});
		tab.tabs('select', currtab_title);
	});
	
		//复制当前tab
	$('#mm-tabcopytab').click(function() {
		var currtab_title = $('#mm').data("currtab");
		var currentTab = tab.tabs('getTab', currtab_title); 
		if(currentTab.panel('options').title != '首页') {
			var iframe = $(currentTab.panel('options').content);
			var src = iframe.attr('src');
			var title = currentTab.panel('options').title;
			do {
				title = title + '#';
			} while(tab.tabs('exists',title));
			addGlobalsTab({'src':src,'pathName': currentTab.children("div[name='pathName']").text(),'title':title});
		}
	});
}
