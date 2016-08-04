$(document).ready(function () {
    var grid = $("#china-area-grid");
    grid.initJqGrid({
        url: ctx + 'chinaarea/query.json',
        addUrl : 'chinaarea/operator.htm',
        editUrl : 'chinaarea/operator.htm',
        deleteUrl : 'chinaarea/delete.json',
        colModel : [
            {name:'id', lable: 'id', index: 'id', hidden:true},
            {name: 'areaType', lable: '区域类型', index: 'areaType', width: 90},
            {name: 'areaCode', lable: '', index: 'areaCode', width: 90},
            {name: 'areaName', lable: '', index: 'areaName', width: 90},
            {name: 'areaAbbname', lable: '', index: 'areaAbbname', width: 90},
            {name: 'remark', lable: '', index: 'remark', width: 90},
            {name: 'gmtCreate', lable: '创建时间', index: 'gmtCreate', width: 90},
            {name: 'gmtModified', lable: '修改时间', index: 'gmtModified', width: 90}
        ]
        // ,footerrow : true, userDataOnFooter: true
    });
});