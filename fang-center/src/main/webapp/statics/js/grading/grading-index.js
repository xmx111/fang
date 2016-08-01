$(document).ready(function () {
    var grid = $("#grading-grid");
    grid.initJqGrid({
        url: ctx + 'grading/query.json',
        addUrl : 'grading/operator.htm',
        editUrl : 'grading/operator.htm',
        deleteUrl : 'grading/delete.json',
        colModel: [
            {name:'id', index: 'id', hidden:true}
            ,{name: 'code', index: 'code', width: 90}
            ,{name: 'name', index: 'name', width: 90}
            ,{name: 'anotherName', index: 'anotherName', width: 90}
            ,{name: 'status', index: 'status', width: 90}
            ,{name: 'province', index: 'province', width: 90}
            ,{name: 'city', index: 'city', width: 90}
            ,{name: 'district', index: 'district', width: 90}
            ,{name: 'cbd', index: 'cbd', width: 90}
            ,{name: 'estateType', index: 'estateType', width: 90}
            ,{name: 'estateAddr', index: 'estateAddr', width: 90}
            ,{name: 'positionDescribe1', index: 'positionDescribe1', width: 90}
            ,{name: 'positionDescribe2', index: 'positionDescribe2', width: 90}
        ]
        // ,footerrow : true, userDataOnFooter: true
    });
});