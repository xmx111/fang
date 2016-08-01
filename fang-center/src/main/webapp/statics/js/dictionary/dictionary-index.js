$(document).ready(function () {
    var grid = $("#dictionary-grid");
    grid.initJqGrid({
        url: ctx + 'dictionary/query.json',
        addUrl : 'dictionary/operator.htm',
        editUrl : 'dictionary/operator.htm',
        deleteUrl : 'dictionary/delete.json',
        colModel: [
            {name:'id', index: 'id', hidden:true}
            ,{name: 'code', index: 'code', width: 90}
            ,{name: 'value', index: 'value', width: 90}
            ,{name: 'status', index: 'status', width: 90}
            ,{name: 'description', index: 'description', width: 90}
        ]
        // ,footerrow : true, userDataOnFooter: true
    });
});