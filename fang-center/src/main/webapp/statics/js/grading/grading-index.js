$(document).ready(function () {
    var grid = $("#grading-grid");
    grid.initJqGrid({
        url: ctx + 'grading/query.json',
        addUrl : 'grading/operator.htm',
        editUrl : 'grading/operator.htm',
        deleteUrl : 'grading/delete.json',
        colNames : ['id', '楼盘代码', '楼盘名称', '楼盘别名', '状态', '省', '市', '区', '商圈', '物业类型', '物业地址', '方位描述1', '方位描述2', '创建时间', '修改时间'],
        colModel : [
            {name:'id', index: 'id', hidden:true},
            {name: 'code', index: 'code', width: 90},
            {name: 'name', index: 'name', width: 90},
            {name: 'anotherName', index: 'anotherName', width: 90},
            {name: 'status', index: 'status', width: 90},
            {name: 'province', index: 'province', width: 90},
            {name: 'city', index: 'city', width: 90},
            {name: 'district', index: 'district', width: 90},
            {name: 'cbd', index: 'cbd', width: 90},
            {name: 'estateType', index: 'estateType', width: 90},
            {name: 'estateAddr', index: 'estateAddr', width: 90},
            {name: 'positionDescribe1', index: 'positionDescribe1', width: 90},
            {name: 'positionDescribe2', index: 'positionDescribe2', width: 90},
            {name: 'createTime', index: 'createTime', width: 90},
            {name: 'modifyTime', index: 'modifyTime', width: 90}
        ]
        // ,footerrow : true, userDataOnFooter: true
    });
});