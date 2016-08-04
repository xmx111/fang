$(document).ready(function () {
    var grid = $("#grading-grid");
    grid.initJqGrid({
        url: ctx + 'grading/query.json',
        addUrl : 'grading/operator.htm',
        editUrl : 'grading/operator.htm',
        deleteUrl : 'grading/delete.json',
        colModel : [
            {name:'id', lable: 'id', index: 'id', hidden:true},
            {name: 'code', lable: '楼盘代码', index: 'code', width: 90},
            {name: 'name', lable: '楼盘名称', index: 'name', width: 90},
            {name: 'anotherName', lable: '楼盘别名', index: 'anotherName', width: 90},
            {name: 'status', lable: '状态', index: 'status', width: 90},
            {name: 'province', lable: '省', index: 'province', width: 90},
            {name: 'city', lable: '市', index: 'city', width: 90},
            {name: 'district', lable: '区', index: 'district', width: 90},
            {name: 'cbd', lable: '商圈', index: 'cbd', width: 90},
            {name: 'estateType', lable: '物业类型', index: 'estateType', width: 90},
            {name: 'estateAddr', lable: '物业地址', index: 'estateAddr', width: 90},
            {name: 'positionDescribe1', lable: '方位描述1', index: 'positionDescribe1', width: 90},
            {name: 'positionDescribe2', lable: '方位描述2', index: 'positionDescribe2', width: 90},
            {name: 'createTime', lable: '创建时间', index: 'createTime', width: 90},
            {name: 'modifyTime', lable: '修改时间', index: 'modifyTime', width: 90}
        ]
        // ,footerrow : true, userDataOnFooter: true
    });
});