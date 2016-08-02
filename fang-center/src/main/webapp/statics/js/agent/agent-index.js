$(document).ready(function () {
    var grid = $("#agent-grid");
    grid.initJqGrid({
        url: ctx + 'agent/query.json',
        addUrl : 'agent/operator.htm',
        editUrl : 'agent/operator.htm',
        deleteUrl : 'agent/delete.json',
        colNames : ['id', '姓名', '手机', '密码', '创建时间', '修改时间'],
        colModel : [
            {name:'id', index: 'id', hidden:true},
            {name: 'name', index: 'name', width: 90},
            {name: 'mobile', index: 'mobile', width: 90},
            {name: 'password', index: 'password', width: 90},
            {name: 'createTime', index: 'createTime', width: 90},
            {name: 'modifyTime', index: 'modifyTime', width: 90}
        ]
        // ,footerrow : true, userDataOnFooter: true
    });
});