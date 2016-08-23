$(document).ready(function () {
    var grid = $("#house-source-grid");
    grid.initJqGrid({
        url: ctx + 'collect/housesource/query.json',
        // addUrl : 'collect/housesource/operator.htm',
        // editUrl : 'collect/housesource/operator.htm',
        // deleteUrl : 'collect/housesource/delete.json',
        shrinkToFit:false,
        autoScroll:true,
        colModel : [
            {name:'id', lable:'id', index: 'id', hidden:true},
            {name: 'time', lable:'时间', index: 'time', width: 90},
            {name: 'district', lable:'区县', index: 'district', width: 90},
            {name: 'cbd', lable:'商圈', index: 'cbd', width: 90},
            {name: 'gradingName', lable:'楼盘名称', index: 'gradingName', width: 90},
            {name: 'title', lable:'标题', index: 'title', width: 90},
            {name: 'publishPrice', lable:'价格', index: 'publishPrice', width: 90},
            {name: 'photoCount', lable:'图片', index: 'photoCount', width: 90},
            {name: 'contact', lable:'联系人', index: 'contact', width: 90},
            {name: 'contactMobile', lable:'联系电话', index: 'contactMobile', width: 90},
            {name: 'inform_num', lable:'举报', index: 'inform_num', width: 90},
            {name: 'click_num', lable:'点击', index: 'click_num', width: 90},
            {name: 'collect_num', lable:'采集', index: 'collect_num', width: 90}
        ],
        btnOptions : [{
            caption: "采集",
            buttonicon: "ui-icon-flag",
            onClickButton: function () {
                $.zui.modalTrigger.show({
                    title: '采集',
                    size: 'lg',
                    remote: ctx + ''
                });
            },
            position: "last"
        },{
            caption: "发布",
            buttonicon: "ui-icon-script",
            onClickButton: function () {
                $.zui.modalTrigger.show({
                    title: '发布',
                    size: 'lg',
                    remote: ctx + ''
                });
            },
            position: "last"
        },{
            caption: "收藏",
            buttonicon: "ui-icon-star",
            onClickButton: function () {
                $.zui.modalTrigger.show({
                    title: '收藏',
                    size: 'lg',
                    remote: ctx + ''
                });
            },
            position: "last"
        },{
            caption: "举报",
            buttonicon: "ui-icon-alert",
            onClickButton: function () {
                $.zui.modalTrigger.show({
                    title: '举报',
                    size: 'lg',
                    remote: ctx + ''
                });
            },
            position: "last"
        }]
        // ,footerrow : true, userDataOnFooter: true
    });
    Area.render('#distinct', '#cbd');
});