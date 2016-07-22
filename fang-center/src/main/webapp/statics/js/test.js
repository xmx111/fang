$(document).ready(function () {
    'use strict';
    var theGrid = $("#theGrid"), numberTemplate = {formatter: 'number', align: 'right', sorttype: 'number'};
    theGrid.initJqGrid({
        datatype: 'json',
        url: '/test.json',
        footerrow : true,
        userDataOnFooter: true,
        colModel: [
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
        pager : '#theButton'
    });
    theGrid.navGrid('#theButton', {edit:true,add:true,del:true,search:true})
});