$(document).ready(function () {
    var grid = $("#house-grid");
    grid.initJqGrid({
        url: ctx + 'house/query.json',
        addUrl : 'house/operator.htm',
        editUrl : 'house/operator.htm',
        deleteUrl : 'house/delete.json',
        colModel: [
            {name:'id', index: 'id', hidden:true}
            ,{name: 'code', index: 'code', width: 90}
            ,{name: 'collectFangUuid', index: 'collectFangUuid', width: 90}
            ,{name: 'useType', index: 'useType', width: 90}
            ,{name: 'salesType', index: 'salesType', width: 90}
            ,{name: 'status', index: 'status', width: 90}
            ,{name: 'gradingName', index: 'gradingName', width: 90}
            ,{name: 'province', index: 'province', width: 90}
            ,{name: 'city', index: 'city', width: 90}
            ,{name: 'district', index: 'district', width: 90}
            ,{name: 'cbd', index: 'cbd', width: 90}
            ,{name: 'address', index: 'address', width: 90}
            ,{name: 'buildingNo', index: 'buildingNo', width: 90}
            ,{name: 'unitNo', index: 'unitNo', width: 90}
            ,{name: 'houseNo', index: 'houseNo', width: 90}
            ,{name: 'floor', index: 'floor', width: 90}
            ,{name: 'totalFloor', index: 'totalFloor', width: 90}
            ,{name: 'room', index: 'room', width: 90}
            ,{name: 'hall', index: 'hall', width: 90}
            ,{name: 'kitchen', index: 'kitchen', width: 90}
            ,{name: 'toilet', index: 'toilet', width: 90}
            ,{name: 'balcony', index: 'balcony', width: 90}
            ,{name: 'position', index: 'position', width: 90}
            ,{name: 'floorNum', index: 'floorNum', width: 90}
            ,{name: 'level', index: 'level', width: 90}
            ,{name: 'capacity', index: 'capacity', width: 90}
            ,{name: 'feature', index: 'feature', width: 90}
            ,{name: 'publishPrice', index: 'publishPrice', width: 90}
            ,{name: 'lowestPrice', index: 'lowestPrice', width: 90}
            ,{name: 'propertyRightType2', index: 'propertyRightType2', width: 90}
            ,{name: 'buildingYear', index: 'buildingYear', width: 90}
            ,{name: 'buildingArea', index: 'buildingArea', width: 90}
            ,{name: 'housingType', index: 'housingType', width: 90}
            ,{name: 'decorationType2', index: 'decorationType2', width: 90}
            ,{name: 'orientation', index: 'orientation', width: 90}
            ,{name: 'buildingStructure', index: 'buildingStructure', width: 90}
            ,{name: 'certificateFive', index: 'certificateFive', width: 90}
            ,{name: 'onlyHousing', index: 'onlyHousing', width: 90}
            ,{name: 'lookTimeType', index: 'lookTimeType', width: 90}
            ,{name: 'innerCode', index: 'innerCode', width: 90}
            ,{name: 'taxType', index: 'taxType', width: 90}
            ,{name: 'payType', index: 'payType', width: 90}
            ,{name: 'detain', index: 'detain', width: 90}
            ,{name: 'pay', index: 'pay', width: 90}
            ,{name: 'delegationType', index: 'delegationType', width: 90}
            ,{name: 'delegationTime', index: 'delegationTime', width: 90}
            ,{name: 'readyTime', index: 'readyTime', width: 90}
            ,{name: 'delegationNo', index: 'delegationNo', width: 90}
            ,{name: 'sourceType', index: 'sourceType', width: 90}
            ,{name: 'actualityType', index: 'actualityType', width: 90}
            ,{name: 'propertyRightType', index: 'propertyRightType', width: 90}
            ,{name: 'decorationType', index: 'decorationType', width: 90}
            ,{name: 'credentialsType', index: 'credentialsType', width: 90}
            ,{name: 'baseService', index: 'baseService', width: 90}
            ,{name: 'furniture', index: 'furniture', width: 90}
            ,{name: 'electronics', index: 'electronics', width: 90}
            ,{name: 'paymentType', index: 'paymentType', width: 90}
            ,{name: 'commissionType', index: 'commissionType', width: 90}
            ,{name: 'hasKey', index: 'hasKey', width: 90}
            ,{name: 'keyNo', index: 'keyNo', width: 90}
            ,{name: 'owner', index: 'owner', width: 90}
            ,{name: 'ownerMobile', index: 'ownerMobile', width: 90}
            ,{name: 'contact', index: 'contact', width: 90}
            ,{name: 'propertyCredentials', index: 'propertyCredentials', width: 90}
            ,{name: 'nationality', index: 'nationality', width: 90}
            ,{name: 'contactExplain', index: 'contactExplain', width: 90}
            ,{name: 'remark', index: 'remark', width: 90}
        ]
        // ,footerrow : true, userDataOnFooter: true
    });
});