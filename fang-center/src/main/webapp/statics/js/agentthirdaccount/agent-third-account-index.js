$(document).ready(function () {
    var grid = $("#agent-third-account-grid");
    grid.initJqGrid({
        url: ctx + 'agentthirdaccount/query.json',
        addUrl : 'agentthirdaccount/operator.htm',
        editUrl : 'agentthirdaccount/operator.htm',
        deleteUrl : 'agentthirdaccount/delete.json',
        colModel: [
            {name:'id', index: 'id', hidden:true}
            ,{name: 'accountNo', index: 'accountNo', width: 90}
            ,{name: 'password', index: 'password', width: 90}
        ]
        // ,footerrow : true, userDataOnFooter: true
    });
});