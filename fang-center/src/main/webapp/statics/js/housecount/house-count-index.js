$(document).ready(function () {
    var grid = $("#house-count-grid");
    grid.initJqGrid({
        url: ctx + 'housecount/query.json',
        addUrl : 'housecount/operator.htm',
        editUrl : 'housecount/operator.htm',
        deleteUrl : 'housecount/delete.json',
        colModel: [
            {name:'id', index: 'id', hidden:true}
            ,{name: 'clickNum', index: 'clickNum', width: 90}
            ,{name: 'collectNum', index: 'collectNum', width: 90}
            ,{name: 'informNum', index: 'informNum', width: 90}
        ]
        // ,footerrow : true, userDataOnFooter: true
    });
});