$(document).ready(function () {
    var grid = $("#agent-grid");
    grid.initJqGrid({
        url: ctx + 'agent/query.json',
        addUrl : 'agent/operator.htm',
        editUrl : 'agent/operator.htm',
        deleteUrl : 'agent/delete.json',
        colModel : [
            {name:'id', lable: 'id', index: 'id', hidden:true},
            {name: 'name', lable: '姓名', index: 'name', width: 90},
            {name: 'mobile', lable: '手机', index: 'mobile', width: 90},
            {name: 'password', lable: '密码', index: 'password', width: 90},
            {name: 'createTime', lable: '创建时间', index: 'createTime', width: 90},
            {name: 'modifyTime', lable: '修改时间', index: 'modifyTime', width: 90}
        ]
        // ,footerrow : true, userDataOnFooter: true
    });
});