$(document).ready(function () {
    var grid = $("#agent-third-account-grid");
    grid.initJqGrid({
        url: ctx + 'agentthirdaccount/query.json',
        addUrl : 'agentthirdaccount/operator.htm',
        editUrl : 'agentthirdaccount/operator.htm',
        deleteUrl : 'agentthirdaccount/delete.json',
        colModel : [
            {name:'id', lable: 'id', index: 'id', hidden:true},
            {name: 'accountNo', lable: '账号', index: 'accountNo', width: 90},
            {name: 'password', lable: '密码', index: 'password', width: 90},
            {name: 'createTime', lable: '创建时间', index: 'createTime', width: 90},
            {name: 'modifyTime', lable: '修改时间', index: 'modifyTime', width: 90}
        ]
        // ,footerrow : true, userDataOnFooter: true
    });
});