$(document).ready(function () {
    var grid = $("#house-count-grid");
    grid.initJqGrid({
        url: ctx + 'housecount/query.json',
        addUrl : 'housecount/operator.htm',
        editUrl : 'housecount/operator.htm',
        deleteUrl : 'housecount/delete.json',
        colModel : [
            {name:'id', lable: 'id', index: 'id', hidden:true},
            {name: 'clickNum', lable: '点击数', index: 'clickNum', width: 90},
            {name: 'collectNum', lable: '采集数', index: 'collectNum', width: 90},
            {name: 'informNum', lable: '举报数', index: 'informNum', width: 90}
        ]
        // ,footerrow : true, userDataOnFooter: true
    });
});