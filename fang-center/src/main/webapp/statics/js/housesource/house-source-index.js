$(document).ready(function () {
    var grid = $("#house-source-grid"), numberTemplate = {formatter: 'number', align: 'right', sorttype: 'number'};
    grid.initJqGrid({
        datatype: 'json',
        //url: ctx + '/collect/houseSource/queryByPage.json',
        url: ctx + '/test.json',
        footerrow : true,
        userDataOnFooter: true,
        colModel: [
            {name:'id', index: 'id', hidden:true},
            {name: 'customer', index: 'customer', width: 90},
            {name: 'orderdate', index: 'orderdate', width: 100, align: 'center', sorttype: 'date',
                formatter: 'date', formatoptions: {newformat: 'd-M-Y'}, datefmt: 'd-M-Y'},
            {name: 'price', index: 'price', width: 55, template: numberTemplate},
            {name: 'vat', index: 'vat', width: 42, template: numberTemplate},
            {name: 'total', index: 'total', width: 50, template: numberTemplate},
            {name: 'completed', index: 'completed', width: 30, align: 'center', formatter: 'checkbox',
                edittype: 'checkbox', editoptions: {value: 'Yes:No', defaultValue: 'Yes'}},
            {name: 'shipment', index: 'shipment', width: 80, align: 'center', formatter: 'select',
                edittype: 'select', editoptions: {value: 'FE:FedEx;TN:TNT;IN:Intime;us:USPS', defaultValue: 'Intime'}}
        ],
        pager : '#house-source-grid-button'
    });
    grid.navGrid('#house-source-grid-button', {edit:false,add:false,del:false,search:false})
        .navButtonAdd('#house-source-grid-button',{
            caption:"",
            buttonicon:"ui-icon-trash",
            onClickButton: function(){
                if (!grid.jqGrid('getGridParam','selrow'))
                    $.zui.messager.show('请选择一行！', {type:'warning', placement: 'center', time:'1500'});
                console.log(grid.jqGrid('getRowData', grid.jqGrid('getGridParam','selrow')));
                $.zui.modalTrigger.show({
                    remote:ctx + 'collect/houseSource/operator.htm?id=' + grid.jqGrid('getRowData', grid.jqGrid('getGridParam','selrow')).id
                });
            },
            position:"first"
        })
        .navButtonAdd('#house-source-grid-button',{
            caption:"",
            buttonicon:"ui-icon-pencil",
            onClickButton: function(){
                if (!grid.jqGrid('getGridParam','selrow'))
                    $.zui.messager.show('请选择一行！', {type:'warning', placement: 'center', time:'1500'});
                console.log(grid.jqGrid('getRowData', grid.jqGrid('getGridParam','selrow')));
                $.zui.modalTrigger.show({
                    remote:ctx + 'collect/houseSource/operator.htm?id=' + grid.jqGrid('getRowData', grid.jqGrid('getGridParam','selrow')).id
                });
            },
            position:"first"
        })
        .navButtonAdd('#house-source-grid-button',{
            caption:"",
            buttonicon:"ui-icon-plus",
            onClickButton: function(){
                $.zui.modalTrigger.show({
                    remote:ctx + 'collect/houseSource/operator.htm'
                });
            },
            position:"first"
        });
});