$(document).ready(function () {
    var grid = $("#house-source-grid"), numberTemplate = {formatter: 'number', align: 'right', sorttype: 'number'};
    grid.initJqGrid({
        //url: ctx + '/collect/houseSource/queryByPage.json',
        url: ctx + '/test.json',
        addUrl : 'collect/houseSource/operator.htm',
        editUrl : 'collect/houseSource/operator.htm',
        deleteUrl : 'collect/houseSource/delete.json',
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
        footerrow : true,
        userDataOnFooter: true
    });
});