var Data_Globals;

var operInterval = '&nbsp;|&nbsp;';

/**
 * 定义一个通用对象来处理相关联的表格、对话框、表单之间的操作， 这些参数都必须是关联在一起的，否则发生未知错误，
 * 只适用于大部分的通用流程，特殊的可以重写方法 该js依赖于esayUI插件
 *
 * @param options
 *            为json对象，主要包含如下参数 grid 表格id form 表单id dialog 对话框id detailGrid
 *            明细表格id urlMap 相关两的增删改查操作所对应的地址add,update,del
 * @returns {Globals}
 */
function Globals(options) {
	var oper = 'query';
	var grid = '#Data_Grid';
	var form = '#Data_Form';
	var dialog = '#Data_Dialog';
	var treeDialog = '#Select_Tree_Data_Dialog';
	var queryBox = '#Query_Box';
	var tabs = '#Data_Tabs';
	var urlMap = config.urlMap;
	var isQuery=false;
	if (options) {
		if (options.grid) {
			grid = options.grid;
		}
		if (options.form) {
			form = options.form;
		}
		if (options.dialog) {
			dialog = options.dialog;
		}
		if (options.queryBox) {
			queryBox = options.queryBox;
		}
		if (options.urlMap) {
			urlMap = options.urlMap;
		}
		if (options.tabs) {
			tabs = options.tabs;
		}
	}
	/*
	 * this.setOper=function(operation){ oper=operation; }
	 *
	 * this.getOper=function(){ return oper; }
	 */

	this.getGrid=function(){
		return grid;
	}
	this.setGrid=function(newGrid){
		grid=newGrid;
	}


	/**
	 * 获取单选行的数据，若没有选择或多选则返回null,并给出相应的提示信息
	 */
	getSingleSelectData = function() {
		try {
			// 获取表格所有被选择的行
			var data = $(grid).datagrid('getSelections');
			if (data.length == 1) {// 判断是否只选择一行记录
				return data[0];
			} else if (data.length == 0) {
				$.messager.alert('友情提示', '请选择数据', 'info');
				return;
			} else {
				$.messager.alert('友情提示', '不能同时操作多条数据', 'info');
				return;
			}
		} catch (e) {
			alert(e);
		}
	};

	/**
	 * From表单默认验证事件
	 */
	this.onSubmit = function() {
		try {
			return $(form).form('validate');
		} catch (e) {
			alert(e);
		}
	}
	/**
	 * 查询数据
	 *
	 * @param isVali
	 *            是否验证,false默认不验证
	 */
	this.query = function(isVali) {
		try {
			if ($(grid).length<1){
				return;
			}
			var params;
			/* 数据验证 */
			if (isVali == null)
				isVali = true;

			if (isVali && $(queryBox + ' form')[0]) {

				var isPass = $($(queryBox + ' form')[0]).form('validate');
				if (!isPass) {
					return false;
				}
			}
			/* 封装所有参数 */
			// $(grid).datagrid("options").queryParams={};
			params = $(queryBox + ' input');
			for ( var i = 0; i < params.length; i++) {
				$(grid).datagrid("options").queryParams[params[i].name] = params[i].value;
			}
			params = $(queryBox + ' select');
			for ( var i = 0; i < params.length; i++) {
				$(grid).datagrid("options").queryParams[params[i].name] = params[i].value;
			}
			/* 更新表单 */
			$(grid).datagrid({
				//url : urlMap.query + ((urlMap.query).indexOf('?') == -1 ? '?_input_charset=UTF-8' : '&_input_charset=UTF-8'),// 乱码问题
				url : urlMap.query,
				pageNumber : 1,
				queryParams : $(grid).datagrid('options').queryParams
			});
			if($(grid)){
				isQuery=true;
			}

		} catch (e) {
			alert(e);
		}
	};

	this.queryById = function(url, gridId, boxId) {
		try {
			if ($(gridId).length<1){
				return;
			}
			var params;
			/* 封装所有参数 */
			params = $(boxId + ' input');
			for ( var i = 0; i < params.length; i++) {
				$(gridId).datagrid("options").queryParams[params[i].name] = params[i].value;
			}
			params = $(boxId + ' select');
			for ( var i = 0; i < params.length; i++) {
				$(gridId).datagrid("options").queryParams[params[i].name] = params[i].value;
			}
			/* 更新表单 */
			$(gridId).datagrid({
				url : url + '&_input_charset=UTF-8',// 乱码问题
				pageNumber : 1,
				queryParams : $(gridId).datagrid('options').queryParams
			});
		} catch (e) {
			alert(e);
		}
	};

	/**
	 * 打开新增对话框的操作,参数为JSON格式
	 *
	 * @param options
	 *            为json对象，主要包含如下参数 title:String 窗口标题 url:添加数据访问的URL
	 *            validate：function 窗口打开前的验证函数 init:function 打开窗口前的初始化函数
	 *            afterOpen:function 窗口打开后执行的函数
	 */
	this.add = function(options) {
		try {
			oper = 'add';
			var result = true; // 验证结果，默认true表示验证通过
			// 自定义窗口打开前的验证操作，返回false组织窗口打开
			if (options && options.validate) {
				result = options.validate();
			}
			if (result) {
				$(form).trigger("reset");
				// 设置表单提交的地址
				$(form).attr('action', urlMap.add);
				// 传入参数的处理
				var titleTemp = '新增'; // 默认窗口的标题
				if (options) {
					if (options.title) { // 自定义窗口标题
						titleTemp = options.title;
					}
					if (options.init) {
						options.init(); // 打开窗口前的执行函数
					}
				}
				// 初始化窗口一些参数
				$(dialog).dialog('setTitle', titleTemp);
				// 打开窗口
				$(dialog).dialog('open');
				// 窗口打开后执行的函数
				if (options && options.afterOpen) {
					options.afterOpen();
				}
			}
		} catch (e) {
			alert(e);
		}
	};

	/**
	 * 打开操作对话框的操作,参数为JSON格式
	 *
	 * @param options
	 *            为json对象，主要包含如下参数 title:String 窗口标题 url:添加数据访问的URL
	 *            validate：function 窗口打开前的验证函数 init:function 打开窗口前的初始化函数
	 *            afterOpen:function 窗口打开后执行的函数
	 */
	this.operator = function(options) {
		try {
			if (!options)return false;
			var optType = options.type ? options.type : 'add';
			var result = true; // 验证结果，默认true表示验证通过
			// 自定义窗口打开前的验证操作，返回false组织窗口打开
			if (options.validate) {
				result = options.validate();
			}
			if (result) {
				// 初始化窗口一些参数
				$(dialog).dialog({
					title : options.title ? options.title : '新窗口',
					width : options.width ? options.width : 500,
					modal : true,
					href : (optType == 'add' ? config.urlMap.addView : config.urlMap.modifyView) + (options.data ? '?' + options.data : ''),
					maximizable : true,
					onLoad : function() {
						$(dialog).dialog('center');
						$(dialog).find(form).attr('action', optType == 'add' ? config.urlMap.add : config.urlMap.modify);
						if (options.onLoad) {
							options.onLoad();
						}
					}
				});
				// 打开窗口
				$(dialog).dialog('open');
				// 窗口打开后执行的函数
				if (options.afterOpen) {
					options.afterOpen();
				}
			}
		} catch (e) {
			alert(e);
		}
	};

	/**
	 * 打开修改对话框的操作，对应表格单选的行,参数为JSON格式
	 *
	 * @param options
	 *            为json对象，主要包含如下参数
	 *            validate(data)：function 窗口打开前的验证函数
	 *            title:String 窗口标题
	 *            init:function 打开窗口前的初始化函数
	 *            afterOpen:function窗口打开后执行的函数
	 *            url:如果在URL，那么打开窗口时远程加载数据
	 *            params:远程加载数据参数
	 *            index:选择的数据的行数
	 */
	this.update = function(options) {
		try {
			oper = 'update';
			var data;
			// 获取数据,如果没有传入ID这默认使用选择的行
			if (!(options && options.params && options.params.id)) {
				//如果有传入行号，则根据行号选择
				if (options && options.index != null) {
					data = $(grid).datagrid('getData').rows[options.index];
				}
				//否则系统自动判断选择的数据
				else {
					data = getSingleSelectData();
				}
			}

			// 如果是远程加载数据，根据选中的数据的ID进行远程加载
			if (options && options.url) {

				// 封装请求的ID
				if (!options.params) {
					options['params'] = {
						id : data.id
					};
				} else {
					// 如果没有传ID，则使用选择的数据的ID
					if (!options.params.id) {
						options.params['id'] = data.id;
					}
				}

				// 远程请求加载数据
				$.post(options.url, options.params,
						function(rd) {
							if (rd.status == "succeed") {
								open(rd.data.data);
							} else {
								$.messager.alert('错误提示', '远程加载数据失败，请联系管理员',
										'error');
							}
						});
			} else {
				open(data);
			}
		} catch (e) {
			alert(e);
		}

		/**
		 * 打修改对话框
		 */
		function open(data) {
			if (data) {
				var result = true;
				// 窗口打开前的验证操作，返回false组织窗口打开
				if (options && options.validate) {
					result = options.validate(data);
				}
				if (result) {
					// 清空表单数据
					// $(form).trigger("reset");
					// 设置表单提交地址
					$(form).attr('action', urlMap.update);
					// 初始化表单数据
					$(form).form('load', data);
					var titleTemp = '编辑';
					// 自定义操作处理
					if (options) {
						if (options.title) {
							titleTemp = options.title;
						}
						if (options.init) {
							options.init();
						}
					}
					// 初始化窗口一些参数
					$(dialog).dialog('setTitle', titleTemp);
					// 打开窗口
					$(dialog).dialog('open');
					// 窗口打开后执行的函数
					if (options && options.afterOpen) {
						options.afterOpen();
					}
				}
			}
		}
	};

	/**
	 * @param url
	 *            删除的url默认是为urlMap的delete
	 * @param id
	 *            要删除的ID,默认为选择的数据,如果使用默认，必须有对应grid
	 * @param msg
	 *            提示信息,默认不进行提示
	 * @param params
	 *            其他参数 必须为json格式
	 * @param single
	 *            默认为false
	 * @param succees
	 *            回调函数，如果发送请求成功，调用回调函数，会传给函数ajax请求返回的数据
	 *
	 */
	this.del = function(options) {
		try {
			var url = config.urlMap['delete'], param = {}, data, result = true;
			/* 如果有params就是用params */
			if (options && options.params) {
				param = options.params;
			}
			/* 如果有url就是用url */
			if (options && options.url) {
				url = options.url;
			}
			if(url.indexOf('?')>0){
				url = url+'&_input_charset=UTF-8';
			}else{
				url = url+'?_input_charset=UTF-8';
			}
			/* 判断操作类型，是单选还是多选 */
			if (options && options.single) {
				/* 如果没有id，是用页面上被选择的数据的id */
				if (options && options.id) {
					param['id'] = options.id;
					data = DataGrid.getDataById(grid, options.id);
				} else {
					var idField = $(grid).datagrid('options').idField;
					data = getSingleSelectData();
					if (!data) {
						return;
					}
					param[idField] = data[idField];
				}
			}
			/* 如果没有指定选择类型，默认为多行选择 */
			else {
				var idField = $(grid).datagrid('options').idField;
				if (options && options.id) {
					idField = options.id;
				}
				data = $(grid).datagrid('getSelections');
				if (data.length == 0) {
					$.messager.alert('友情提示', '请选择数据!', 'info');
					return;
				}
				var idArray = new Array;
				for ( var i = 0; i < data.length; i++) {
					if(options && options.filter){
						var filter = options.filter;
						if(data[i][filter.field]==filter.value){
							idArray.push(data[i][idField]);
						}
					}else{
						idArray.push(data[i][idField]);
					}
				}
				param[idField] = idArray;
			}
			/* 判断是否提示 */
			if (options && options.msg) {
				$.messager.confirm('友情提示', options.msg, function(ok) {
					if (ok) {
						$.post(url, param, succeed);
					}
				});
			} else {
				$.post(url, param, succeed);
			}
		} catch (e) {
			alert(e);
		}

		/**
		 * 远程请求数据
		 */
		function succeed(result) {
			if (result && result.status == "succeed") {
				var message = result.message == '' ? '操作成功' : result.message;
				$.messager.show({
					'title' : '提示信息',
					'msg' : message
				});
				$(grid).datagrid('reload');
				if (options && options.success) {
					options.success(result);
				}
			} else {
				if (options && options.failure) {
					options.failure(result);
				}
				var message = result.message == '' ? '555~~~,操作失败了，再来一次吧！'
					: result.message;
				$.messager.alert('提示', message, 'error');

			}
		}
	}

	/**
	 * @param url
	 *            修改状态的url默认是为urlMap的batchUpdate
	 * @param id
	 *            要修改状态的ID,默认为选择的数据,如果使用默认，必须有对应grid
	 * @param msg
	 *            提示信息,默认不进行提示
	 * @param params
	 *            其他参数 必须为json格式
	 * @param single
	 *            默认为false
	 * @param succees
	 *            回调函数，如果发送请求成功，调用回调函数，会传给函数ajax请求返回的数据
	 *
	 */
	this.batchUpdate = function(options) {
		try {
			var url = config.urlMap.batchUpdate, param = {}, data, result = true;
			/* 如果有url就是用url */
			if (options && options.params) {
				param = options.params;
			}
			/* 如果有url就是用url */
			if (options && options.url) {
				url = options.url;
			}
			if(url.indexOf('?')>0){
				url = url+'&_input_charset=UTF-8';
			}else{
				url = url+'?_input_charset=UTF-8';
			}
			/* 判断操作类型，是单选还是多选 */
			if (options && options.single) {
				/* 如果没有id，是用页面上被选择的数据的id */
				if (options && options.id) {
					param['id'] = options.id;
					data = DataGrid.getDataById(grid, options.id);
				} else {
					var idField = $(grid).datagrid('options').idField;
					data = getSingleSelectData();
					if (!data) {
						return;
					}
					param[idField] = data[idField];
				}
			}
			/* 如果没有指定选择类型，默认为多行选择 */
			else {
				var idField = $(grid).datagrid('options').idField;
				if (options && options.id) {
					idField = options.id;
				}
				data = $(grid).datagrid('getSelections');
				if (data.length == 0) {
					$.messager.alert('友情提示', '请选择数据!', 'info');
					return;
				}
				var idArray = new Array;
				for ( var i = 0; i < data.length; i++) {
					if(options && options.filter){
						var filter = options.filter;
						if(data[i][filter.field]==filter.value){
							idArray.push(data[i][idField]);
						}
					}else{
						idArray.push(data[i][idField]);
					}
				}
				param[idField] = idArray;
			}
			if (options && options.validate) {
				result = options.validate(data);
			}
			if (result) {
				/* 判断是否提示 */
				if (options && options.msg) {
					$.messager.confirm('友情提示', options.msg, function(ok) {
						if (ok) {
							$.post(url, param, succeed);
						}
					});
				} else {
					$.post(url, param, succeed);
				}
			}
		} catch (e) {
			alert(e);
		}

		/**
		 * 远程请求数据
		 */
		function succeed(result) {
			//var result;
			//try {
			//	result = eval('(' + data + ')');// 将字符串转化为json格式
			//} catch (e) {
			//	$.messager.alert('错误提示', '系统故障或网络出现错误，请联系管理员', 'error');
			//	return;
			//}
			if (result && result.status == "succeed") {
				var message = result.message == '' ? '操作成功' : result.message;
				$.messager.show({
					'title' : '提示信息',
					'msg' : message
				});
				$(grid).datagrid('reload');
				if (options && options.success) {
					options.success(result);
				}
			} else {
				if (options && options.failure) {
					options.failure(result);
				}
				var message = result.message == '' ? '555~~~,操作失败了，再来一次吧！'
						: result.message;
				$.messager.alert('提示', message, 'error');

			}
		}
	}
	
	/**
	 * 重置查询条件
	 */
	this.resetQuery=function(){
		$($(queryBox + ' form')[0]).trigger("reset");
		$.each($(queryBox + 'input[type=hidden]'),function(i,n){
			$(n).val('');
		});
	}
	
	/**
	 * 重置查询条件,订单列表查询用到,不需要重置隐藏域
	 */
	this.resetOrderListQuery=function(){
		$($(queryBox + ' form')[0]).trigger("reset");
	}

	/**
	 * 提交数据 options: beforeSubmit success: 参数为function提交成功以后的处理函数
	 * fail:参数为function提交失败以后的处理函数
	 *
	 */
	this.submit = function(options) {
		try {
			var url;
			var queryUrl = urlMap.query;
			var onSubmit = this.onSubmit;
			if (options && options.onSubmit) {
				onSubmit = options.onSubmit;
			}
			if (oper == 'add') {
				url = urlMap.add;
			} else if (oper == 'update') {
				url = urlMap.update;
			}
			if (options && options.url) {
				url = options.url;
			}
			$(form).form('submit', {
				'url' : url,
				'onSubmit' : onSubmit,
				'success' : success
			});
		} catch (e) {
			alert(e);
		}

		function success(data) {
			var result;
			try {
				result = eval('(' + data + ')');// 将字符串转化为json格式
			} catch (e) {
				$.messager.alert('错误提示', '系统故障或网络出现错误，请联系管理员', 'error');
			}
			var message;
			message = $.trim(result.message) == '' ? '操作成功' : result.message;
			if (result.status == "succeed") {
				if (options && options.success) {
					options.success(result);
				}
				if ($(grid) && oper == 'update' && $(grid)) {
					$(grid).datagrid('reload');
				} else if ($(grid) && oper == 'add') {
					$(grid).datagrid({
						url : queryUrl,// 乱码问题
						pageNumber : 1
					});
				}
				$.messager.show({
					'title' : '提示信息',
					'msg' : message
				});
				$(form).trigger("reset");
				if ($(dialog)) {
					$(dialog).dialog('close');
				}
			} else {
				if (options && options.failure) {
					options.failure(result);
				}
				message = $.trim(result.message) == '' ? '555~~~,操作失败了，再来一次吧！'
						: result.message;
				$.messager.alert('错误提示', message, 'error');
			}
			
		}
	};

	/**
	 * 默认初始化操作
	 */
	this.init = function() {
		/* 初始化Data_Grid */
		if ($(grid)) {
			$(grid).datagrid({
				pageList:[10,20,30,40,50,100],
				pageSize:20,
				idField : 'id',
				//fit : true,
				striped : true,
				rownumbers : true,
				pagination : true,
				remoteSort:false,
				showFooter : true,
				pageSum : false,
				//fitColumns : true,
				border : false,
				onLoadSuccess : function(data) {
					$(grid).datagrid('clearSelections');

					// 加合计 by hekang
					Data_Globals.addSumToFooter(grid);
				}
			});
		}
		if ($(dialog)) {
			$(dialog).dialog({
				closed : true,
				collapsible : true,
				maximizable : true,
				modal : true,
				draggable:false
			});
		}

	};

	/**
	 * 增加window页面 add by zhangzhiwen@hitao 2012.8.31
	 * @param id 窗口的唯一标识
	 * @param options.src 嵌套的iframe页面路径
	 * @param options.title 需要增加的window页面标题
	 */
	this.openWindow = function(id, options){
		var winHtml = '<div id = "' + id + '" class="easyui-window" inline="true" style="overflow:hidden">'
			+ '<iframe src="'+ options.src + '" scrolling="no" frameborder="0"  height="100%" width="100%" />'
			+ '</div>';	
		$('body').append(winHtml);
		var win = $("#" + id);
		var _resize = false;
		if(options&&options.resizable){
			_resize = options.resizable;
		}
		var _draggable = false;
		if(options&&options.draggable){
			_draggable = options.draggable;
		}
		
		win.window({
			title: options.title,
			width: parseInt(options.width),
			modal: true,
			shadow: false,
			closed: true,
			draggable: _draggable,
			minimizable: false,
			maximizable: true,
			collapsible: false,
			closable: true,
			resizable: _resize,
			height: parseInt(options.height),
			onClose: function(){$(this).remove();}
		});
		$.parser.parse(win);
		win.window('open');	
	}
	
	this.closeWindow = function(id, options) {
		try{
			if (options) {
				if (!options.data){
					this.closeWindow(id);
					if(options.reload){
						// 刷新指定的列表
						if (options.datagrid){
							$("#" + options.datagrid).datagrid('reload');
						}
					}
					return ;
				}
				var result;
				try {
					result = eval('(' + options.data + ')');// 将字符串转化为json格式
				} catch (e) {
					$.messager.alert('错误提示', '系统故障或网络出现错误，请联系管理员',
							'error');
					return;
				}
				if (result.status == "succeed") {
					var message;
					message = $.trim(result.message) == '' ? '操作成功' : result.message;
						$.messager.show({
							'title' : '提示信息',
							'msg' : message
						});
					this.closeWindow(id);
					if(options.reload){
						// 刷新指定的列表
						if (options.datagrid){
								$("#" + options.datagrid).datagrid('reload');
						}
					}
				} else {
					var message = $.trim(result.message) == '' ? '操作失败！'
							: result.message;
					$.messager.alert('错误提示', message, 'error');
				}
			}else{
				var win = $("#" + id);
				win.window('close');
			}
		}catch(e){
			
		}
	}
	
	/**
	 * 增加Tab页面
	 * @param options.src 嵌套的iframe页面路径
	 * @param options.title 需要增加的Tab页面标题
	 */
	this.addTab = function(options){
		var tab = $(tabs);
		var title = "tab";
			
		if(options.title){
			title = options.title;
		}
		if(tab){
//			if(tab.tabs('exists',title)){

//				tab.tabs('select',title);
//			}else{
				$(tabs).tabs('close', options.title);
				tab.tabs('add',{
					title:title,
					closable:true,
					bodyCls:'overflow-hidden',
					content:'<iframe src="'+ options.src + ' "scrolling="auto" frameborder="0"  height="100%" width="100%" />'
				});
//			}
		}
	}
	
	/**
	 * 关闭Tab页面,
	 * @param options.data 远程请求的数据,要来判断操作是否成功
	 * @param options.title 需要关闭的Tab页面标题，如果不传，则关闭当前活动的tab页
	 * @param options.reload 是否需要重新加载datagrid数据
	 */
	this.closeTab = function(options) {
		try{
			var tab=$(tabs).tabs('getSelected');
			var title='';
			if (options && options.title ){
				title=options.title;
			}else{
				title=$(tab).panel('options').title;
			}
			if (options) {
				if (!options.data){
					$(tabs).tabs('close', title);
					if(options.reload){
						// 刷新原来的列表
						if ($(grid).length>0){
							if (isQuery){//如果被查询过
								$(grid).datagrid('reload');
							}else{//否则进行查询
								this.query();
							}
						}else if(reload){
							location.reload();
						}
					}
					return ;
				}
				var result;
				try {
					result = eval('(' + options.data + ')');// 将字符串转化为json格式
				} catch (e) {
					$.messager.alert('错误提示', '系统故障或网络出现错误，请联系管理员',
							'error');
					return;
				}
				if (result.status == "succeed") {
					// 关闭当前新增的Tab页面
					var message;
					message = $.trim(result.message) == '' ? '操作成功' : result.message;
						$.messager.show({
							'title' : '提示信息',
							'msg' : message
						});
					// 关闭指定Title的Tab页面
					$(tabs).tabs('close', title);
					if(options.reload){
						
						// 刷新原来的列表
						if ($(grid).length>0){
							if (isQuery){//如果被查询过
								$(grid).datagrid('reload');
							}else{//否则进行查询
								this.query();
							}
						}else if(reload){
							location.reload();
						}
						//$(grid).datagrid('reload');
					}
				} else {
					var message = $.trim(result.message) == '' ? '操作失败！'
							: result.message;
					$.messager.alert('错误提示', message, 'error');
				}
			}else{
				$(tabs).tabs('close', title);
			}
		}catch(e){
			
		}
		
	}


	this.submitTabForm = function(options){
		var tab = options.tab;
		var form = tab.form;
		$(form).form('submit', {
	        url : tab.url,	// 主tab页面声明好的URL地址
	        onSubmit: function(){
	        	try {
		        	if(options.onSubmit){
		        		return ($(form).form('validate'))&&(options.onSubmit());
		        	}else{
		        		return $(form).form('validate');
		        	}
	        	} catch (e) {
        			return false;
        		}
	        },
	        success:function(data){
	        	var result;
				try {
					result = eval('(' + data + ')');// 将字符串转化为json格式
				} catch (e) {
					$.messager.alert('错误提示', '系统故障或网络出现错误，请联系管理员',
							'error');
					return;
				}
				if (result.status == "succeed") {
					if (options && options.success) {
						options.success(result);
					}
					try{
						if(self.frameElement&&(self.frameElement.tagName=="IFRAME")){
							  // 页面在iframe中时处理,关闭当前新增的Tab页面
							self.parent.Data_Globals.closeTab({'reload':true});
						}else if(window==top||self==top){
							window.location.href=options.redirectTo;
						}
					}catch(e){

					}

				} else {
					if (options && options.failure) {
						options.failure(result);
					}
					var message = $.trim(result.message) == '' ? '操作失败！'
							: result.message;
					$.messager.alert('错误提示', message, 'error');
				}
	        }
		});
	}

	/**
	 * datagrid 页脚加合计行，只有列属性sum为true的才显示
	 * datagrid属性pageSum为true统计当页小计
	 * @param gridId
	 */
	this.addSumToFooter = function(gridId){
		if ($(gridId).datagrid('options').showFooter == true){
			var rows = $(gridId).datagrid("getRows");
			// 无数据则退出
			if (rows.length == 0) return;

			var sumColFields = new Array(); // 需要合计的列
			// 取合计列(列属性sum为true的进行合计)
			var cols = $(gridId).datagrid('options').columns;
			var ct = 0;
			for (var i = 0; i < cols[0].length; i ++ ){
				if (!!cols[0][i].sum) {
					sumColFields[ct] = cols[0][i].field;
					ct ++;
				}
			}
			// 无合计列则退出
			if (ct == 0) {
				$(gridId).datagrid('reloadFooter', []);
				return;
			}

			// 合计行只保留合计列，清理不需要的数据
			var footerRows = !$(gridId).datagrid('getFooterRows') ? [] : $(gridId).datagrid('getFooterRows'); // 接收的合计行
			var cleanFooterRows = new Array(); // 清理后的合计行
			for (var i = 0; i < footerRows.length; i ++){
				var cleanFooterRow = new Object();
				for (var j = 0; j < sumColFields.length; j ++){
					cleanFooterRow[sumColFields[j]] = footerRows[i][sumColFields[j]];
				}
				cleanFooterRows[i] = cleanFooterRow;
			}

			// 是否加当页小计
			if ($(gridId).datagrid('options').pageSum == true) {
				cleanFooterRows.unshift(this.calePageSum(gridId, sumColFields));
			}

			// reloadFooter会调用renderFooter方法，renderFooter调用renderRow方法,renderRow调用formatter方法（操作列会formatter合计行）
			$(gridId).datagrid('reloadFooter', cleanFooterRows);

			// 页脚最后一行的第一列显示'合计'
			var footerView = $(gridId).datagrid('getPanel').find(
					'div.datagrid-footer');
			if (footerView.find('td[field="opt"]').length > 0)
			// 有操作列，则最后一行操作列显示'合计'
				footerView.find('td[field="opt"]:last > div').html('合计');
			else
			// 没操作列，则最后一行第一列显示'合计'
				footerView.find('tr:last > td:first > div').html('合计');
		}
	}



	/**
	 *
	 * @param gridId
	 * @param sumColFields	需要合计的行
	 * @returns {Object}
	 */
	this.calePageSum = function(gridId, sumColFields){
		var rows = $(gridId).datagrid("getRows");
		// 加当前页小计
		var footerData = new Object();
		footerData[cols[0][0].field] = '小计';
		for (var i = 0; i < rows.length; i++){
			for (var j = 0; j < sumColFields.length; j ++ ){
				footerData[sumColFields[j]] = ((!footerData[sumColFields[j]] ?0 : parseFloat(footerData[sumColFields[j]])) + parseFloat(!rows[i][sumColFields[j]] ? 0 : rows[i][sumColFields[j]])).toFixed(2);
			}
		}
		return footerData;
	}

	/**
	 * 通用树形选择对话框
	 * @param options {title, url, ischeck, single, cascade, callback} 对话框标题，数据url，是否单选（默认否），是否级联（默认是），回调函数
     */
	this.selectTree = function(options) {
		var setting = {
			check: {
				enable: options.ischeck == undefined || options.ischeck == true,
				chkType: options.single == undefined || options.single == false ? 'checkbox' : 'radio',
				radioType: 'all',
				chkboxType: options.cascade == undefined || options.cascade == true ? { "Y": "ps", "N": "ps" } : { "Y": "", "N": "" }
			},
			data: {
				key: {
					name: 'text'
				}
			},
			callback: {
				onClickOk : options.callback
			}
		};
		$.post(options.url, options.data, function(result){
			var treeObj = $.fn.zTree.init($(treeDialog).find('#select_tree'), setting, result);
			//var nodes = treeObj.getNodesByParam("type", "app", null);
			//for (var i=0, l=nodes.length; i<l; i++) {
			//	nodes[i].nocheck = true;
			//	treeObj.updateNode(nodes[i]);
			//}
			treeObj.expandAll(true);
			if (options.title)
				$(treeDialog).dialog('setTitle', options.title);
			$(treeDialog).dialog('open');
		});
	}

	/**
	 * 通用树形选择对话框
	 * @param options {dialogId, title, url, single, callback} 对话框标题，数据url，是否单选（默认否），回调函数
	 */
	this.selectGrid = function(options) {
		/**
		 * 初始化用户列表
		 */
		$('#'+options.dialogId).find(grid).datagrid({
			url:options.url,
			idField:'id',
			fit:true,
			singleSelect:!!options.single,
			rownumbers : true,
			striped:true,
			sortable:true,
			pagination : true,
			fitColumns:false,
			nowrap:true,
			frozenColumns:[[
				{field:'ck',checkbox:true}
			]],
			callback:options.callback,
			onLoadSuccess:function(){
				// 清除勾选
				$('#'+options.dialogId).find(grid).datagrid('clearChecked');
			}
		});
		if (options.title)
			$('#'+options.dialogId).dialog('setTitle', options.title);
		$('#'+options.dialogId).dialog('open');
	}
};

/**
 * 初始化操作
 */
$(function() {
	Data_Globals = new Globals();
	Data_Globals.init();
	
	/* 回车查询事件 */
	$(document).keydown(function(event){
	   	event = event || window.event;
	   	var obj = event.target || event.srcElement;
	   	var key = event.keyCode;
	   	if (Data_Globals && key == 13) {
	   		event.preventDefault(); //这里取消掉键盘触发的默认事件
	   		if (obj.className=='pagination-num'){
				return;
			}else{
				Data_Globals.query();
			}
	   	}else{
	   		preventBSK(event);
	   	}
   	});
	
	//输入框输入长度提示
	$('#Data_Form input[showInputSize]').each(function(){
		var obj = this;
		var showInputSize = $(obj).attr('showInputSize');
		var message = '文本长度不能大于'+showInputSize+'个字符';
		$(obj).val(message);
		$(obj).css("color","gray");
		$(obj).focus(function(){
			if(obj.value==message){
		    	  $(obj).val("");
		    	  $(obj).css("color","black");
		      }
		});
	});
	
	//去掉输入框前后空格
	$('#Data_Form input').blur(function(){
		var value = $(this).val();
		 $(this).val(value.replace(/(^\s*)|(\s*$)/g,""));
	});
/*
	$('#Query_Box input').keydown(function(){
		if (event.keyCode===13){
 		Data_Globals.query();
		}
	});

	$('#Query_Box select').keydown(function(){
		if (event.keyCode===13){
 		Data_Globals.query();
		}
	});
*/
	setTimeout(
			function(){
				// 来一个 table 适应函数
				var adaptTable = function(){

					var adapt = function(){
						if ($(".tabs-wrap").length==0){
							return;
						}
						if (!$('#Data_Grid')[0])
							return;
						var VIEWHEIGHT = $(window).height(),
							VIEWWIDTH  = $(window).width(),
							offsetT  = $(".tabs-wrap").offset().top + $(".tabs-wrap").outerHeight()+ ($("#Query_Box").length !== 0 ? $("#Query_Box").outerHeight() : 0),
							offsetL  = parseInt($(".tabs-wrap").offset().left) - !!$(".tabs-wrap").closest('.tabs-container').find('.layout-panel-west')[0] ? $(".tabs-wrap").closest('.tabs-container').find('.layout-panel-west').width() : 0;
						$('#Data_Grid').datagrid('resize',{
							height:(VIEWHEIGHT - offsetT - 1),
							width :(VIEWWIDTH  - offsetL - 1)
						});
					}

					return adapt;
				}();


				// window 的 load 和 resize 都绑定一个
				$(window).bind("load resize", function(e){
					if(e && e.type == "resize"){

						$(".condition form").css({
							height : 'auto'
						});

						$(".trigger").addClass("open").removeClass("off");

						setTimeout(adaptTable, 200);
					}else{
						adaptTable();
					}
				})

				// 加载时判断condition高度小于两行 且 没有加载触发器
				if($(".condition form").height() > 60 && !$(".condition .trigger").length && $(".toolbar").length !== 0){

					// 加载触发器
					$(".condition").append("<div class='trigger off'><span><i></i>查询条件</span></div>");
					if($(".toolbar").first().html() === ''){
						$(".toolbar").first().css({
							height : '18px'
						})
					}

					// 设置条件表单高度为两行
					$(".condition form").css({
						height : $(".condition li").outerHeight()*2,
						overflow : "hidden"
					});

					// 绑定触发器 taggle 事件
					$(".trigger").bind("click",	function(){

						$(".condition form").css({
							display : "block"
						})

						if($(this).hasClass("off")){
							$(this).addClass("open").removeClass("off");

							// 来一个动画效果
							$(this).prev().animate({
								height : $(".condition ul").outerHeight()
							}, 100, "" ,adaptTable);


						}else{

							$(this).addClass("off").removeClass("open");

							$(this).prev().animate({
								height : $(".condition li").outerHeight()*2
							}, 100, "" ,adaptTable);
						}
					})
				}
				adaptTable();
			}, 1);






			/*##################################TEXTAREA 加入maxlength属性###############################*/
		function onmyinput(o,maxLength)
		{
		if(o.value.length>= maxLength)
		{
		if(o.value.length> maxLength)
		value = o.value.substring(0,maxLength);
		return false;
		}
		return true;
		}
		function mygetclipdata()
		{
		if(!document.all)
		{
		netscape.security.PrivilegeManager.enablePrivilege('UniversalXPConnect');
		var clip = Components.classes['@mozilla.org/widget/clipboard;1'].createInstance(Components.interfaces.nsIClipboard);
		var trans = Components.classes['@mozilla.org/widget/transferable;1'].createInstance(Components.interfaces.nsITransferable);
		trans.addDataFlavor('text/unicode');
		var str = Components.classes["@mozilla.org/supports-string;1"].createInstance(Components.interfaces.nsISupportsString);
		clip.getData(trans,clip.kGlobalClipboard);
		var str=new Object();
		var strLength=new Object();
		trans.getTransferData("text/unicode",str,strLength);
		if (str)
		str=str.value.QueryInterface(Components.interfaces.nsISupportsString);
		var pastetext;
		if (str)
		pastetext=str.data.substring(0,strLength.value / 2);
		return pastetext;
		}
		else
		{
		return window.clipboardData.getData("Text");
		}
		}
		function mysetclipdata(o)
		{
		if(!document.all)
		{
		netscape.security.PrivilegeManager.enablePrivilege('UniversalXPConnect');
		var clip = Components.classes['@mozilla.org/widget/clipboard;1'].createInstance(Components.interfaces.nsIClipboard);
		var trans = Components.classes['@mozilla.org/widget/transferable;1'].createInstance(Components.interfaces.nsITransferable);
		trans.addDataFlavor("text/unicode");
		var str = Components.classes["@mozilla.org/supports-string;1"].createInstance(Components.interfaces.nsISupportsString);
		str.data=o;
		trans.setTransferData("text/unicode",str,o.length*2);
		var clipid=Components.interfaces.nsIClipboard;
		clip.setData(trans,null,clipid.kGlobalClipboard);
		}
		else
		{
		window.clipboardData.setData("Text",o);
		}
		}
		function onmypaste(o, maxLength)
		{
		var nMaxLen=o.getAttribute? parseInt(maxLength):"";
		
		if(!document.all)
		{
		// alert("不可能执行的代码");
		}
		else
		{
		
		if(document.selection.createRange().text.length>0)
		{
		   var ovalueandclipboarddata = o.value +window.clipboardData.getData("Text");
		   if(o.getAttribute && ovalueandclipboarddata.length-document.selection.createRange().text.length>nMaxLen)
		   {
		    if(window.clipboardData.getData("Text").substring(0,document.selection.createRange().text.length+nMaxLen-o.value.length)!="")
		     window.clipboardData.setData("Text",window.clipboardData.getData("Text").substring(0,document.selection.createRange().text.length+nMaxLen-o.value.length));
		    else
		     return false;
		   }
		}
		else
		{
		   var ovalueandclipboarddata = o.value +window.clipboardData.getData("Text");
		   if(o.getAttribute && ovalueandclipboarddata.length>nMaxLen)
		   {
		    if(ovalueandclipboarddata.substring(0,nMaxLen-o.value.length)!="")
		     window.clipboardData.setData("Text",ovalueandclipboarddata.substring(0,nMaxLen-o.value.length));
		    else
		     return false;
		   }
		}
		return true;
		}
		}
		function onmykeypress(o, maxLength)
		{
		if(!document.all)
		{
		var nMaxLen=o.getAttribute? parseInt(maxLength):"";
		
		if(onmykeypress.caller.arguments[0].ctrlKey == true)
		{
		   if(onmykeypress.caller.arguments[0].which==118)
		   {
		
		    if(o.selectionStart<o.selectionEnd)
		    {
		     var ovalueandclipboarddata = o.value + mygetclipdata();
		     if(o.getAttribute && (ovalueandclipboarddata.length-o.selectionEnd + o.selectionStart>nMaxLen))
		     {
		      if(mygetclipdata().substring(0,o.selectionEnd - o.selectionStart+nMaxLen-o.value.length)!="")
		       mysetclipdata(mygetclipdata().substring(0,o.selectionEnd - o.selectionStart+nMaxLen-o.value.length));
		      else
		       return false;
		     }
		    }
		    else
		    {
		     var ovalueandclipboarddata = o.value +mygetclipdata();
		     if(o.getAttribute && ovalueandclipboarddata.length>nMaxLen)
		     {
		      if(ovalueandclipboarddata.substring(0,nMaxLen-o.value.length)!="")
		       mysetclipdata(ovalueandclipboarddata.substring(0,nMaxLen-o.value.length));
		      else
		       return false;
		     }
		    }
		    return true;
		
		   }
		}
		
		
		if(onmykeypress.caller.arguments[0].which==0 || onmykeypress.caller.arguments[0].which==8)
		   return true;
		if(o.value.length>= maxLength)
		{
		   if(o.selectionStart<o.selectionEnd)
		    return true;
		   if(o.value.length> maxLength)
		    o.value = o.value.substring(0, maxLength);
		   return false;
		}
		else
		   return true;
		
		}
		else
		{
		if(document.selection.createRange().text.length>0)
		   return true;
		if(o.value.length>= maxLength)
		   return false;
		else
		   return true;
		}
		}
		window.onload = init_MaxLength;
		function init_MaxLength ()
		{
		var textAreaObj = document.getElementsByTagName("textarea");
		var maxLength;
		for (var i = 0; i < textAreaObj.length; i++) {
		      maxLength = textAreaObj[i].getAttribute("maxLength") == null ? 0 : textAreaObj[i].getAttribute("maxLength");
		      if (maxLength == 0) continue;
		          textAreaObj[i].onpaste = function(){ return onmypaste(this,maxLength)};
		          textAreaObj[i].onkeypress = function(){ return onmykeypress(this,maxLength)};
		          textAreaObj[i].onpropertychange = function(){ onmyinput(this,maxLength)};
		        if(!document.all){
		          textAreaObj[i].setAttribute("oninput","return onmyinput(this," + maxLength + ")");
		        }
		}
		}
	
});

/**
 *  将javascript数据类型转换为json字符串的方法。** @public* @param  {object}  需转换为json字符串的对象, 一般为Json 【支持object,array,string,function,number,boolean,regexp *】* @return 返回json字符串**/
jQuery.extend({
	toJSONString: function(object) {
		if (object === null) return 'null';
		var type = typeof object;
		if ('object' == type) {
			if (Array == object.constructor)
				type = 'array';
			else if (RegExp == object.constructor) type = 'regexp';
			else type = 'object';
			}
		switch (type) {
			case 'undefined':
			case 'unknown':
				return; break;
			case 'function':
			case 'boolean':
			case 'regexp':
				return object.toString();   break;
			case 'number':
				return isFinite(object) ? object.toString() : 'null';        break;
			case 'string':
				return '"' + object.replace(/(\\|\")/g, "\\$1").replace(/\n|\r|\t/g, function() {
					var a = arguments[0];
					return (a == '\n') ? '\\n': (a == '\r') ? '\\r': (a == '\t') ? '\\t': ""
						}) + '"';        break;
			case 'object':
				if (object === null) return 'null';
				var results = [];
				for (var property in object) {
					var value = jQuery.toJSONString(object[property]);
					if (value !== undefined)
						results.push(jQuery.toJSONString(property) + ':' + value);
					}
				return '{' + results.join(',') + '}';        break;
			case 'array':
				var results = [];
				for (var i = 0; i < object.length; i++) {
					var value = jQuery.toJSONString(object[i]);
					if (value !== undefined) results.push(value);
					}
				return '[' + results.join(',') + ']';        break;
				}
		}
});

/*
function enterQuery(){
	
	if (Data_Globals && event.keyCode===13 ){
		event = event || window.event;
		alert(1);
		event.preventDefault();
		if (event.srcElement.className=='pagination-num'){
			return;
		}else{
			Data_Globals.query();
		}
	}else{
		preventBSK();
	}
}
*/
//防止回退，同时不影响文本编辑

function preventBSK(event)
{
    var bskEventCancel = false;
    var _EVENT = event||window.event;
    if(_EVENT == undefined) { //FF没有windwo.event事件
    	return bskEventCancel;
    }
    var obj = _EVENT.target || _EVENT.srcElement;
    
    bskEventCancel = _EVENT && _EVENT.altKey && (_EVENT.keyCode == 8 || _EVENT.keyCode == 37 || _EVENT.keyCode == 39);
    if(_EVENT.keyCode == 8)
    {
        var tagName = obj.tagName.toUpperCase();
        if(tagName == "TEXTAREA" || tagName == "INPUT" )//文本操作不受影响
            bskEventCancel = obj.readOnly;
        else
            bskEventCancel = true;
    }
    _EVENT.cancelBubble = bskEventCancel;
    _EVENT.returnValue = !bskEventCancel;
    return !bskEventCancel;
}

//cookie操作插件
jQuery.cookie = function(name, value, options) {
	if (typeof value != 'undefined') { // name and value given, set cookie
		options = options || {};
		if (value === null) {
			value = '';
			options.expires = -1;
		}
		var expires = '';
		if (options.expires && (typeof options.expires == 'number' || options.expires.toUTCString)) {
			var date;
			if (typeof options.expires == 'number') {
				date = new Date();
				date.setTime(date.getTime() + (options.expires * 24 * 60 * 60 * 1000));
			} else {
				date = options.expires;
			}
			expires = '; expires=' + date.toUTCString(); // use expires attribute, max-age is not supported by IE
		}
		var path = options.path ? '; path=' + options.path : '';
		var domain = options.domain ? '; domain=' + options.domain : '';
		var secure = options.secure ? '; secure' : '';
		document.cookie = [name, '=', encodeURIComponent(value), expires, path, domain, secure].join('');
	} else { // only name given, get cookie
		var cookieValue = null;
		if (document.cookie && document.cookie != '') {
			var cookies = document.cookie.split(';');
			for (var i = 0; i < cookies.length; i++) {
				var cookie = jQuery.trim(cookies[i]);
				// Does this cookie string begin with the name we want?
				if (cookie.substring(0, name.length + 1) == (name + '=')) {
					cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
					break;
				}
			}
		}
		return cookieValue;
	}
};

//---------------------------------------------------
// 判断闰年
//---------------------------------------------------
Date.prototype.isLeapYear = function()
{
	return (0==this.getYear()%4&&((this.getYear()%100!=0)||(this.getYear()%400==0)));
}

//---------------------------------------------------
// 日期格式化
// 格式 YYYY/yyyy/YY/yy 表示年份
// MM/M 月份
// W/w 星期
// dd/DD/d/D 日期
// hh/HH/h/H 时间
// mm/m 分钟
// ss/SS/s/S 秒
//---------------------------------------------------

Date.prototype.Format = function(formatStr)
{
	var str = formatStr;
	var Week = ['日','一','二','三','四','五','六'];
	str=str.replace(/yyyy|YYYY/,this.getFullYear());
	str=str.replace(/yy|YY/,(this.getYear() % 100)>9?(this.getYear() % 100).toString():'0' + (this.getYear() % 100));
	str=str.replace(/MM/,(this.getMonth() + 1)>9?(this.getMonth() + 1).toString():'0' + (this.getMonth() + 1));
	str=str.replace(/M/g,this.getMonth() + 1);
	str=str.replace(/w|W/g,Week[this.getDay()]);
	str=str.replace(/dd|DD/,this.getDate()>9?this.getDate().toString():'0' + this.getDate());
	str=str.replace(/d|D/g,this.getDate());
	str=str.replace(/hh|HH/,this.getHours()>9?this.getHours().toString():'0' + this.getHours());
	str=str.replace(/h|H/g,this.getHours());
	str=str.replace(/mm/,this.getMinutes()>9?this.getMinutes().toString():'0' + this.getMinutes());
	str=str.replace(/m/g,this.getMinutes());
	str=str.replace(/ss|SS/,this.getSeconds()>9?this.getSeconds().toString():'0' + this.getSeconds());
	str=str.replace(/s|S/g,this.getSeconds());
	return str;
}

//+---------------------------------------------------
//| 求两个时间的天数差 日期格式为 YYYY-MM-dd
//+---------------------------------------------------
function daysBetween(DateOne,DateTwo)
{
	var OneMonth = DateOne.substring(5,DateOne.lastIndexOf('-'));
	var OneDay = DateOne.substring(DateOne.length,DateOne.lastIndexOf('-')+1);
	var OneYear = DateOne.substring(0,DateOne.indexOf('-'));
	var TwoMonth = DateTwo.substring(5,DateTwo.lastIndexOf('-'));
	var TwoDay = DateTwo.substring(DateTwo.length,DateTwo.lastIndexOf('-')+1);
	var TwoYear = DateTwo.substring(0,DateTwo.indexOf('-'));
	var cha=((Date.parse(OneMonth+'/'+OneDay+'/'+OneYear)- Date.parse(TwoMonth+'/'+TwoDay+'/'+TwoYear))/86400000);
	return Math.abs(cha);
}

//+---------------------------------------------------
//| 日期计算
//+---------------------------------------------------
Date.prototype.DateAdd = function(strInterval, number) {
	var dtTmp = this;
	switch (strInterval) {
	case 's' :return new Date(Date.parse(dtTmp.toGMTString()) + (1000 * number));
	case 'n' :return new Date(Date.parse(dtTmp.toGMTString()) + (60000 * number));
	case 'h' :return new Date(Date.parse(dtTmp.toGMTString()) + (3600000 * number));
	case 'd' :return new Date(Date.parse(dtTmp.toGMTString()) + (86400000 * number));
	case 'w' :return new Date(Date.parse(dtTmp.toGMTString()) + ((86400000 * 7) * number));
	//FIXME 以下两种对跨年的增加有异常
//	case 'q' :return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number*3, dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
//	case 'm' :return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number, dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
	case 'y' :return new Date((dtTmp.getFullYear() + number), dtTmp.getMonth(), dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
	}
}

//+---------------------------------------------------
//| 比较日期差 dtEnd 格式为日期型或者 有效日期格式字符串
//+---------------------------------------------------
Date.prototype.DateDiff = function(strInterval, dtEnd) {
	var dtStart = this;
	if (typeof dtEnd == 'string' )//如果是字符串转换为日期型
	{
	dtEnd = StringToDate(dtEnd);
	}
	switch (strInterval) {
	case 's' :return parseInt((dtEnd - dtStart) / 1000);
	case 'n' :return parseInt((dtEnd - dtStart) / 60000);
	case 'h' :return parseInt((dtEnd - dtStart) / 3600000);
	case 'd' :return parseInt((dtEnd - dtStart) / 86400000);
	case 'w' :return parseInt((dtEnd - dtStart) / (86400000 * 7));
	case 'm' :return (dtEnd.getMonth()+1)+((dtEnd.getFullYear()-dtStart.getFullYear())*12) - (dtStart.getMonth()+1);
	case 'y' :return dtEnd.getFullYear() - dtStart.getFullYear();
	}
}

//+---------------------------------------------------
//| 日期输出字符串，重载了系统的toString方法
//+---------------------------------------------------
Date.prototype.toString = function(showWeek)
{
	var myDate= this;
	var str = myDate.toLocaleDateString();
	if (showWeek)
	{
	var Week = ['日','一','二','三','四','五','六'];
	str += ' 星期' + Week[myDate.getDay()];
	}
	return str;
}

//+---------------------------------------------------
//| 输入控制
//+---------------------------------------------------
function inputControl(ob, regx) {
    if (!ob.value.match(regx)) {
    	if (ob.t_value && ob.t_value.match(regx)){
    		ob.value = ob.t_value;
    	}else {
    		ob.value = '';
    	}
	} else {
		ob.t_value = ob.value; 
	}
}

/**
 * 此函数针对明细页面，基本详情table 初始化显示的行数，若实际行数大于初始化显示的行
 * 数，则在表格中下方出现“更多详情”可点击展开所有table行
 * 1.table必须处于class为 baseInfo的div中
 * @param num table 初始化显示的行数
 */
function showBaseInfo(num){
	 if (!num) {
			num = -1;
		}
	// 加载时判断condition高度小于两行 且 没有加载触发器
	if(($(".baseinfo table").height() > $(".baseinfo tr").outerHeight()*num )&& !$(".baseinfo .trigger").length ){
		// 加载触发器
		$(".baseinfo").append("<div class='trigger off'><span><i></i>更多详情</span></div>");
		
		// 来一个 table 显示行数的函数
		var showTableRow = function(num){
			var rows = $(".baseinfo tr");
			if (!num || num<0) {
				for ( var i = 0; i < rows.length; i++) {
					$(rows[i]).show();
				}
			}else{
				for ( var i = num; i < rows.length; i++) {
					$(rows[i]).hide();
				}
			}
		};
		showTableRow(num);
		// 绑定触发器 taggle 事件
		$(".baseinfo .trigger").bind("click",	function(){
			
			if($(this).hasClass("off")){
				$(this).addClass("open").removeClass("off");
				showTableRow();
			}else{
				
				$(this).addClass("off").removeClass("open");
				showTableRow(num);
			}
		})
	}
}

