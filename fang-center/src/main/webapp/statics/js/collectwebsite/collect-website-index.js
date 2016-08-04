$(document).ready(function () {
    var grid = $("#collect-website-grid");
    grid.initJqGrid({
        url: ctx + 'collectwebsite/query.json',
        addUrl : 'collectwebsite/operator.htm',
        editUrl : 'collectwebsite/operator.htm',
        deleteUrl : 'collectwebsite/delete.json',
        colModel : [
            {name:'id', lable: 'id', index: 'id', hidden:true},
            {name: 'url', lable: '网站地址', index: 'url', width: 90},
            {name: 'icon', lable: '网站图标', index: 'icon', width: 90},
            {name: 'createTime', lable: '创建时间', index: 'createTime', width: 90},
            {name: 'modifyTime', lable: '修改时间', index: 'modifyTime', width: 90}
        ]
        // ,footerrow : true, userDataOnFooter: true
    });
});