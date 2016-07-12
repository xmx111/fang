(function() {
	/* 自定义验证信息 */
	$.extend($.fn.validatebox.defaults.rules, {
		/* 最小长度 */
		minLength : {
			validator : function(value, param) {
				value = value.replace(/(^\s*)|(\s*$)/g,"");
				return value.length >= param[0];
			},
			message : '文本长度不能少于 {0}个字符。 '
		},
		/* 最大长度 */
		maxLength : {
			validator : function(value, param) {
				var message = '文本长度不能大于'+param[0]+'个字符';
				if(value==message){
					return false;
				}
				value = value.replace(/(^\s*)|(\s*$)/g,"");
				return value.length <= param[0];
			},
			message : '文本长度不能大于 {0}个字符。 '
		},
		/**
		 * 数字最大值验证，编辑表格时，表格中数字值与其它字段值比较的验证,表格必须为单行选择
		 * param[0] 表格id
		 * param[1] 被比较的字段
		 * param[2] 错误提示信息，被比较的字段名称
		 */
		maxValue : {
			validator : function(value, param) {
				var row = $('#'+param[0]).datagrid('getSelected');
				var num1 = parseFloat(value);
				var num2 = parseFloat(row[param[1]]);
				return num1 <= num2;
			},
			message : '数值非法超出【 {2}】限制 '
		},				
		/**
		 * 综合验证字符串，包括长度限制、格式等。 add by tangmin.ht 2012-07-02
		 * param[0] 字符串最小长度
		 * param[1] 字符串最大长度  
		 * param[2] 字符串允许格式,正则表达式，默认限制 “数字英文或者中文字符” 。注意，传入的正则表达式中的特殊字符要加\,如：\\d{3}
		 * param[3] 格式验证失败提示信息 ,默认 “只能输入中文，数字或英文字符”
		 * param[4] 要回显的提示信息
		 */
		strValidate:{
			validator : function(value, param) {
				value = value.replace(/(^\s*)|(\s*$)/g,"");
				//验证长度
				if(value.length>10 || value.length<2){
					param[4] = '文本长度必须介于'+param[0]+'到'+param[1]+'之间。';
					return false;
				}
				//验证格式
				var reg = /^([\u4e00-\u9fa5]|[A-Za-z]|[0-9]){0,}$/; 
				if(param[2]!=''){
					reg = new RegExp('^'+param[2]+'$') 
				}
				if(param[3]==''){
					param[3] = '只能输入中文，数字或英文字符';
				}
				if(!value.match(reg)){
					param[4] = param[3];
					return false;	
				} 			
				return true;
			},
			message : '{4}'
		}
	});
	

})();

