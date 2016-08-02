$(document).ready(function () {
    var grid = $("#china-area-grid");
    grid.initJqGrid({
        url: ctx + 'chinaarea/query.json',
        addUrl : 'chinaarea/operator.htm',
        editUrl : 'chinaarea/operator.htm',
        deleteUrl : 'chinaarea/delete.json',
        colNames : ['id', '区域类型
-1:区域1:国家
2:省/自治区/直辖市
3:地区(省下面的地级市)
4:县/市(县级市)/区
6:海外', '', '', '', '', '创建时间', '修改时间'],
        colModel : [
            {name:'id', index: 'id', hidden:true},
            {name: 'areaType', index: 'areaType', width: 90},
            {name: 'areaCode', index: 'areaCode', width: 90},
            {name: 'areaName', index: 'areaName', width: 90},
            {name: 'areaAbbname', index: 'areaAbbname', width: 90},
            {name: 'remark', index: 'remark', width: 90},
            {name: 'gmtCreate', index: 'gmtCreate', width: 90},
            {name: 'gmtModified', index: 'gmtModified', width: 90}
        ]
        // ,footerrow : true, userDataOnFooter: true
    });
});