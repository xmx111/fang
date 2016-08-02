$(document).ready(function () {
    var grid = $("#house-source-grid");
    grid.initJqGrid({
        url: ctx + 'collect/housesource/query.json',
        addUrl : 'collect/housesource/operator.htm',
        editUrl : 'collect/housesource/operator.htm',
        deleteUrl : 'collect/housesource/delete.json',
        colModel : [
            {name:'id', index: 'id', hidden:true},
            {name: '时间', index: 'time', width: 90},
            {name: '区县', index: 'district', width: 90},
            {name: '商圈', index: 'cbd', width: 90},
            {name: '楼盘名称', index: 'gradingName', width: 90},
            {name: '标题', index: 'title', width: 90},
            {name: '价格', index: 'publishPrice', width: 90},
            {name: '图片', index: 'photoCount', width: 90},
            {name: '联系人', index: 'contact', width: 90},
            {name: '联系电话', index: 'contactMobile', width: 90},
            {name: '举报', index: 'inform_num', width: 90},
            {name: '点击', index: 'click_num', width: 90},
            {name: '采集', index: 'collect_num', width: 90}
        ],
        btnOptions : [{
            caption: "采集",
            onClickButton: function () {
                $.zui.modalTrigger.show({
                    title: '采集',
                    size: 'lg',
                    remote: ctx + ''
                });
            },
            position: "first"
        },{
            caption: "发布",
            onClickButton: function () {
                $.zui.modalTrigger.show({
                    title: '发布',
                    size: 'lg',
                    remote: ctx + ''
                });
            },
            position: "first"
        },{
            caption: "收藏",
            onClickButton: function () {
                $.zui.modalTrigger.show({
                    title: '收藏',
                    size: 'lg',
                    remote: ctx + ''
                });
            },
            position: "first"
        },{
            caption: "举报",
            onClickButton: function () {
                $.zui.modalTrigger.show({
                    title: '举报',
                    size: 'lg',
                    remote: ctx + ''
                });
            },
            position: "first"
        }]
        // ,footerrow : true, userDataOnFooter: true
    });
});