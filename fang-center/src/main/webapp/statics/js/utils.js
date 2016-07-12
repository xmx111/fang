/*
function easyuiAlert(msg,icon,fn){
	jQuery.messager.alert('提示信息',msg,icon,fn);
}
var show=jQuery.messager.show;
var alert=easyuiAlert;
var confirm=jQuery.messager.confirm;
var prompt=jQuery.messager.prompt
 */
var Remote = new Remote();
var DataGrid = new DataGrid();
var Util = new Util();
var UI = new UI();
var RemoteOther = new RemoteOther();
/**
 * 远程操作工具类
 * 
 * @returns {Remote}
 */
function Remote() {
	/**
	 * 
	 * @param options
	 *            json格式数据:url-远程请求的地址;params-远程请求的参数,用json数据封装;msg-方式请求之前的提示信息；succees-函数，请求成功调用;perPost-发送请求前执行的函数
	 * @returns
	 */
	this.post = function(options) {
		/* 判断是否提示 */
		try {
			options.url=options.url+'&_input_charset=UTF-8'
			if (options.msg) {
				$.messager.confirm('友情提示', options.msg, function(ok) {
					if (ok) {
						if (options.perPost) {
							options.perPost();
						}
						$.post(options.url, options.params, succeed);
					}
				});
			} else {
				$.post(options.url, options.params, succeed);
			}
		} catch (e) {
			alert(e);
		}
		/**
		 * 远程请求数据
		 */
		function succeed(data) {
			var result;

			try {
				result = eval('(' + data + ')');// 将字符串转化为json格式
			} catch (e) {
				$.messager.alert('错误提示', '系统故障或网络出现错误，请联系管理员', 'error');
			}
			if (result && result.status == "succeed") {
				if (options && options.succees) {
					options.succees(data);
				}
				try {
					var message = result.message == '' ? '操作成功'
							: result.message;
					$.messager.show({
						'title' : '提示信息',
						'msg' : message
					});
				} catch (e) {

				}
			} else {
				if (options && options.failure) {
					options.failure(data);
				}
				try {
					var message = result.message == '' ? '555~~~,操作失败了，再来一次吧！'
							: result.message;
					$.messager.alert('提示', message, 'error');
				} catch (e) {

				}
			}
		}
	};

}




function RemoteOther() {
	/**
	 * 
	 * @param options
	 *            json格式数据:url-远程请求的地址;params-远程请求的参数,用json数据封装;msg-方式请求之前的提示信息；succees-函数，请求成功调用;perPost-发送请求前执行的函数
	 * @returns
	 */
	this.post = function(options) {
		/* 判断是否提示 */
		try {
			options.url=options.url+'&_input_charset=UTF-8'
			if (options.msg) {
				$.messager.confirm('友情提示', options.msg, function(ok) {
					if (ok) {
						if (options.perPost) {
							options.perPost();
						}
						$.post(options.url, options.params, succeed);
					}
				});
			} else {
				$.post(options.url, options.params, succeed);
			}
		} catch (e) {
			alert(e);
		}
		/**
		 * 远程请求数据
		 */
		function succeed(data) {
			var result;

			try {
				result = eval('(' + data + ')');// 将字符串转化为json格式
			} catch (e) {
				$.messager.alert('错误提示', '系统故障或网络出现错误，请联系管理员', 'error');
			}
			if (result && result.status == "succeed") {
				if (options && options.succees) {
					options.succees(data);
				}
				try {
					var message = result.message == '' ? '操作成功'
							: result.message;
					$.messager.show({
						'title' : '提示信息',
						'msg' : message
					});
				} catch (e) {

				}
			} else {
				if (options && options.failure) {
					options.failure(data);
				}
				try {
					var message = result.message == '' ? '555~~~,操作失败了，再来一次吧！'
							: result.message;
					$.messager.alert('提示', message, 'error');
				} catch (e) {

				}
			}
		}
	};

}

















/**
 * easyUI DataGrid 方法封装
 * 
 * @returns {DataGrid}
 */
function DataGrid() {

	/**
	 * 获得DataGrid的指定行的数据
	 */
	this.getData = function(grid, index) {
		var gridData = $(grid).datagrid('getData');
		if (gridData.rows) {
			return gridData.rows[index];
		} else {
			return gridData[index];
		}
	};

	/**
	 * 获取指定表格的指定列的所有值,返回结果为数组
	 */
	this.getFiledValues = function(grid, field) {
		var values = new Array;
		var data = $('#' + grid).datagrid('getData');
		var rows = data.rows;
		for ( var i = 0; i < rows.length; i++) {
			values.push(rows[i][field]);
		}

		return values;
	};

	/**
	 * 获得DataGrid的指定Id的数据
	 */
	this.getDataById = function(grid, id) {
		var index = $(grid).datagrid('getRowIndex', id);
		return this.getData(grid, index);
	};

	/**
	 * 通过记录的主键值选中表格的行记录
	 * 
	 * @param gridId
	 *            表格的id eg:'#Data_Grid'
	 * @param idArray
	 *            主键值数组 eg:[11,15]
	 */
	this.selectRecords = function(gridId, idArray) {
		for ( var i = 0; i < idArray.length; i++) {
			$(gridId).datagrid('selectRecord', idArray[i]);
		}
	};
	/**
	 * 删除表格的指定行数据
	 * 
	 * @param grid
	 *            表格的ID
	 * @param index
	 *            表格的行号
	 */
	this.deleteRow = function(grid, index) {
		var row = $('#' + grid).datagrid('getSelected');
		if (row) {
			var index = $('#' + grid).datagrid('getRowIndex', row);
			$('#' + grid).datagrid('deleteRow', index);
		}
	}

	/**
	 * 删除表格的指定行数据
	 * 
	 * @param grid
	 *            表格的ID
	 * @param index
	 *            表格的行号
	 */
	this.deleteRowByIdField = function(grid, id) {
		var index = $('#' + grid).datagrid('getRowIndex', id);
		$('#' + grid).datagrid('deleteRow', index);
	}
	
	/**
	 * 开始编辑表格的指定行数据
	 * 
	 * @param grid
	 *            表格的ID
	 * @param index
	 *            表格的行号
	 */
	this.editRowByIdField = function(grid, id) {
		var index = $('#' + grid).datagrid('getRowIndex', id);
		$('#' + grid).datagrid('beginEdit', index);
	}
	
	/**
	 * 保存编辑表格的指定行数据
	 * 
	 * @param grid
	 *            表格的ID
	 * @param index
	 *            表格的行号
	 */
	this.saveRowByIdField = function(grid, id) {
		var index = $('#' + grid).datagrid('getRowIndex', id);
		$('#' + grid).datagrid('endEdit', index);
	}
	
	/**
	 * 取消编辑表格的指定行数据
	 * 
	 * @param grid
	 *            表格的ID
	 * @param index
	 *            表格的行号
	 */
	this.cancelRowByIdField = function(grid, id) {
		var index = $('#' + grid).datagrid('getRowIndex', id);
		$('#' + grid).datagrid('cancelEdit', index);
	}

	/**
	 * 根据Id判断表格是否已存在相同的行，不存在则返回true,存则返回false
	 * 
	 * @param grid
	 *            表格的ID
	 * @param id
	 *            表格中行数据记录的id
	 * @returns {Boolean}
	 */
	this.isNotExist = function(grid, id) {
		$('#' + grid).datagrid('clearSelections');
		$('#' + grid).datagrid('selectRecord', id);
		var row = $('#' + grid).datagrid('getSelected');
		if (row) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 通过表格主键判断记录是否存在，存在则返回true,不存则返回false
	 * 
	 * @param grid
	 *            表格的ID
	 * @param idField
	 *            主键字段名
	 * @param id
	 *            主键值
	 * @returns {Boolean}
	 */
	this.isExist = function(grid, idField, id) {
		var data = $('#' + grid).datagrid('getData');
		var rows = data.rows;
		for (i in rows) {
			if (rows[i][idField] == id) {
				return true;
			}
		}
		return false;
	}

	this.mergeCellsByField=function mergeCellsByField(tableID, colList) {
		var ColArray = colList.split(",");
		var tTable = $('#' + tableID);
		var TableRowCnts = tTable.datagrid("getRows").length;
		var tmpA;
		var tmpB;
		var PerTxt = "";
		var CurTxt = "";
		var alertStr = ""; /* for (j=0;j<=ColArray.length-1 ;j++ ) */
		for (j = ColArray.length - 1; j >= 0; j--) { /* 当循环至某新的列时，变量复位。 */
			PerTxt = "";
			tmpA = 1;
			tmpB = 0; /* 从第一行（表头为第0行）开始循环，循环至行尾(溢出一位) */
			for (i = 0; i <= TableRowCnts; i++) {
				if (i == TableRowCnts) {
					CurTxt = "";
				} else {
					CurTxt = tTable.datagrid("getRows")[i][ColArray[j]];
				}
				if (PerTxt == CurTxt) {
					tmpA += 1;
				} else {
					tmpB += tmpA;
					tTable.datagrid('mergeCells', {
						index : i - tmpA,
						field : ColArray[j],
						rowspan : tmpA,
						colspan : null
					});
					tmpA = 1;
				}
				PerTxt = CurTxt;
			}
		}
	}
	
	
	this.mergeCellsByFields=function mergeCellsByFields(tableID, colList) {
		var ColArray = colList.split(",");
		var tTable = $('#' + tableID);
		var TableRowCnts = tTable.datagrid("getRows").length;
		var tmpA;
		var tmpB;
		var PerTxt = "";
		var CurTxt = "";
		var alertStr = ""; /* for (j=0;j<=ColArray.length-1 ;j++ ) */
//		for (j = ColArray.length - 1; j >= 0; j--) { /* 当循环至某新的列时，变量复位。 */
			PerTxt = "";
			tmpA = 1;
			tmpB = 0; /* 从第一行（表头为第0行）开始循环，循环至行尾(溢出一位) */
			for (i = 0; i <= TableRowCnts; i++) {
				if (i == TableRowCnts) {
					CurTxt = "";
				} else {
					CurTxt = tTable.datagrid("getRows")[i][ColArray[0]];
				}
				if (PerTxt == CurTxt) {
					tmpA += 1;
				} else {
					tmpB += tmpA;
					for (var a = ColArray.length - 1; a >= 0; a--){
						tTable.datagrid('mergeCells', {
							index : i - tmpA,
							field : ColArray[a],
							rowspan : tmpA,
							colspan : null
						});
						
					}
					
					
					
					tmpA = 1;
				}
				PerTxt = CurTxt;
			}
//		}
	}
	
	
	
	

};

/**
 * 通用工具类
 * 
 * @returns {Util}
 */
function Util() {
	this.indexOf = function(array, id) {
		for (i in array) {
			if (array[i] == id) {
				return i;
			}
		}
		return -1;
	}
};
/**
 * UI工具类
 * 
 * @returns {UI}
 */
function UI() {
	/**
	 * 打开窗口
	 * 
	 * @param key窗口的ID值
	 */
	this.open = function(key) {
		$('#' + key).dialog('open');
	};

	/**
	 * 关闭窗口
	 * 
	 * @param key窗口的ID值
	 */
	this.close = function(key) {
		$('#' + key).dialog('close');
	};

	/**
	 * 根据窗口百分百得到像素大小
	 * 
	 * @param percent
	 * @returns {Number}
	 */
	this.fixWidth = function() {
		return document.body.clientWidth * percent;
	};

	/**
	 * 禁用控件 ids 控件ID
	 */
	this.disabled = function(ids) {
		for ( var i = 0; i < ids.length; i++) {
			$('#' + ids[i]).attr({
				disabled : true
			});
		}
	};

};
/**
 * 拼接字符串的函数
 * 
 * @returns {StringBuffer}
 */
function StringBuffer() {
	this._strings_ = new Array;
	this.append = function(str) {
		if (str) {
			this._strings_.push(str);
		}
		return this;
	};
	this.toString = function(link) {
		var str = "";
		if (link) {
			str = link;
		}
		return this._strings_.join(str);
	}
}
/**
 * 转换类目名称中的分隔符的显示
 * 
 * @param value
 * @param data
 * @param index
 * @returns
 */
function formatCategoryNamePath(value, data, index) {
	var reg = new RegExp(",", "g");
	return value.replace(reg, " | ");
}

String.prototype.Trim = function()    
{    
return this.replace(/(^\s*)|(\s*$)/g, "");    
}    
String.prototype.LTrim = function()    
{    
return this.replace(/(^\s*)/g, "");    
}    
String.prototype.RTrim = function()    
{    
return this.replace(/(\s*$)/g, "");    
}  