$(document).ready(function () {
    var grid = $("#agent-third-account-grid");
    grid.initJqGrid({
        url: ctx + 'agentthirdaccount/query.json',
        addUrl : 'agentthirdaccount/operator.htm',
        editUrl : 'agentthirdaccount/operator.htm',
        deleteUrl : 'agentthirdaccount/delete.json',
        colNames : ['id', '账号', '密码', '创建时间', '修改时间'],
        colModel : [
            {name:'id', index: 'id', hidden:true},
            {name: 'accountNo', index: 'accountNo', width: 90},
            {name: 'password', index: 'password', width: 90},
            {name: 'createTime', index: 'createTime', width: 90},
            {name: 'modifyTime', index: 'modifyTime', width: 90}
        ]
        // ,footerrow : true, userDataOnFooter: true
    });
});