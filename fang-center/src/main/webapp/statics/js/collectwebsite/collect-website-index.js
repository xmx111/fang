$(document).ready(function () {
    var grid = $("#collect-website-grid");
    grid.initJqGrid({
        url: ctx + 'collectwebsite/query.json',
        addUrl : 'collectwebsite/operator.htm',
        editUrl : 'collectwebsite/operator.htm',
        deleteUrl : 'collectwebsite/delete.json',
        colModel: [
            {name:'id', index: 'id', hidden:true}
            ,{name: 'url', index: 'url', width: 90}
            ,{name: 'icon', index: 'icon', width: 90}
        ]
        // ,footerrow : true, userDataOnFooter: true
    });
});