$(document).ready(function () {
    var grid = $("#collect-website-grid");
    grid.initJqGrid({
        url: ctx + 'collectwebsite/query.json',
        addUrl : 'collectwebsite/operator.htm',
        editUrl : 'collectwebsite/operator.htm',
        deleteUrl : 'collectwebsite/delete.json',
        colNames : ['id', '网站地址', '网站图标', '创建时间', '修改时间'],
        colModel : [
            {name:'id', index: 'id', hidden:true},
            {name: 'url', index: 'url', width: 90},
            {name: 'icon', index: 'icon', width: 90},
            {name: 'createTime', index: 'createTime', width: 90},
            {name: 'modifyTime', index: 'modifyTime', width: 90}
        ]
        // ,footerrow : true, userDataOnFooter: true
    });
});