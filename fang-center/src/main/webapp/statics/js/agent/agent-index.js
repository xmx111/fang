$(document).ready(function () {
    var grid = $("#agent-grid");
    grid.initJqGrid({
        url: ctx + 'agent/query.json',
        addUrl : 'agent/operator.htm',
        editUrl : 'agent/operator.htm',
        deleteUrl : 'agent/delete.json',
        colModel: [
            {name:'id', index: 'id', hidden:true}
            ,{name: 'name', index: 'name', width: 90}
            ,{name: 'mobile', index: 'mobile', width: 90}
            ,{name: 'password', index: 'password', width: 90}
        ]
        // ,footerrow : true, userDataOnFooter: true
    });
});