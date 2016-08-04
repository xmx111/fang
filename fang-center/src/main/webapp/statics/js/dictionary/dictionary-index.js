$(document).ready(function () {
    var grid = $("#dictionary-grid");
    grid.initJqGrid({
        url: ctx + 'dictionary/query.json',
        addUrl : 'dictionary/operator.htm',
        editUrl : 'dictionary/operator.htm',
        deleteUrl : 'dictionary/delete.json',
        colModel : [
            {name:'id', lable: 'id', index: 'id', hidden:true},
            {name: 'code', lable: '代码', index: 'code', width: 90},
            {name: 'value', lable: '值', index: 'value', width: 90},
            {name: 'status', lable: '状态：0-无效,1-有效', index: 'status', width: 90},
            {name: 'description', lable: '描述', index: 'description', width: 90},
            {name: 'createTime', lable: '创建时间', index: 'createTime', width: 90},
            {name: 'modifyTime', lable: '修改时间', index: 'modifyTime', width: 90}
        ]
        // ,footerrow : true, userDataOnFooter: true
    });
});