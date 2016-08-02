$(document).ready(function () {
    var grid = $("#dictionary-grid");
    grid.initJqGrid({
        url: ctx + 'dictionary/query.json',
        addUrl : 'dictionary/operator.htm',
        editUrl : 'dictionary/operator.htm',
        deleteUrl : 'dictionary/delete.json',
        colNames : ['id', '代码', '值', '状态：0-无效,1-有效', '描述', '创建时间', '修改时间'],
        colModel : [
            {name:'id', index: 'id', hidden:true},
            {name: 'code', index: 'code', width: 90},
            {name: 'value', index: 'value', width: 90},
            {name: 'status', index: 'status', width: 90},
            {name: 'description', index: 'description', width: 90},
            {name: 'createTime', index: 'createTime', width: 90},
            {name: 'modifyTime', index: 'modifyTime', width: 90}
        ]
        // ,footerrow : true, userDataOnFooter: true
    });
});