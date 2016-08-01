$(document).ready(function () {
    var grid = $("#grading-info-grid");
    grid.initJqGrid({
        url: ctx + 'gradinginfo/query.json',
        addUrl : 'gradinginfo/operator.htm',
        editUrl : 'gradinginfo/operator.htm',
        deleteUrl : 'gradinginfo/delete.json',
        colModel: [
            {name:'id', index: 'id', hidden:true}
            ,{name: 'trafficDescribe', index: 'trafficDescribe', width: 90}
            ,{name: 'university', index: 'university', width: 90}
            ,{name: 'school', index: 'school', width: 90}
            ,{name: 'kindergarten', index: 'kindergarten', width: 90}
            ,{name: 'mall', index: 'mall', width: 90}
            ,{name: 'postOffice', index: 'postOffice', width: 90}
            ,{name: 'bank', index: 'bank', width: 90}
            ,{name: 'hospital', index: 'hospital', width: 90}
            ,{name: 'other', index: 'other', width: 90}
            ,{name: 'tel', index: 'tel', width: 90}
        ]
        // ,footerrow : true, userDataOnFooter: true
    });
});