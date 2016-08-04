$(document).ready(function () {
    var grid = $("#house-release-grid");
    grid.initJqGrid({
        url: ctx + 'houserelease/query.json',
        addUrl : 'houserelease/operator.htm',
        editUrl : 'houserelease/operator.htm',
        deleteUrl : 'houserelease/delete.json',
        colModel : [
            {name:'id', lable: 'id', index: 'id', hidden:true},
            {name: 'code', lable: '内部编码', index: 'code', width: 90},
            {name: 'collectFangUuid', lable: '采集房源_uuid', index: 'collectFangUuid', width: 90},
            {name: 'useType', lable: '用途', index: 'useType', width: 90},
            {name: 'salesType', lable: '销售类型', index: 'salesType', width: 90},
            {name: 'status', lable: '状态', index: 'status', width: 90},
            {name: 'gradingName', lable: '楼盘名称', index: 'gradingName', width: 90},
            {name: 'province', lable: '省', index: 'province', width: 90},
            {name: 'city', lable: '市', index: 'city', width: 90},
            {name: 'district', lable: '区县', index: 'district', width: 90},
            {name: 'cbd', lable: '商圈', index: 'cbd', width: 90},
            {name: 'address', lable: '地址', index: 'address', width: 90},
            {name: 'buildingNo', lable: '楼号', index: 'buildingNo', width: 90},
            {name: 'unitNo', lable: '单元', index: 'unitNo', width: 90},
            {name: 'houseNo', lable: '房号', index: 'houseNo', width: 90},
            {name: 'floor', lable: '楼层', index: 'floor', width: 90},
            {name: 'totalFloor', lable: '总楼层', index: 'totalFloor', width: 90},
            {name: 'room', lable: '室', index: 'room', width: 90},
            {name: 'hall', lable: '厅', index: 'hall', width: 90},
            {name: 'kitchen', lable: '厨', index: 'kitchen', width: 90},
            {name: 'toilet', lable: '卫', index: 'toilet', width: 90},
            {name: 'balcony', lable: '阳台', index: 'balcony', width: 90},
            {name: 'position', lable: '位置', index: 'position', width: 90},
            {name: 'floorNum', lable: '层数', index: 'floorNum', width: 90},
            {name: 'level', lable: '级别', index: 'level', width: 90},
            {name: 'capacity', lable: '排量', index: 'capacity', width: 90},
            {name: 'feature', lable: '特色', index: 'feature', width: 90},
            {name: 'publishPrice', lable: '价格', index: 'publishPrice', width: 90},
            {name: 'lowestPrice', lable: '最低首付', index: 'lowestPrice', width: 90},
            {name: 'propertyRightType2', lable: '产权性质', index: 'propertyRightType2', width: 90},
            {name: 'buildingYear', lable: '建筑年代', index: 'buildingYear', width: 90},
            {name: 'buildingArea', lable: '建筑面积', index: 'buildingArea', width: 90},
            {name: 'housingType', lable: '住宅类型', index: 'housingType', width: 90},
            {name: 'decorationType2', lable: '装修类型', index: 'decorationType2', width: 90},
            {name: 'orientation', lable: '朝向', index: 'orientation', width: 90},
            {name: 'buildingStructure', lable: '建筑结构', index: 'buildingStructure', width: 90},
            {name: 'certificateFive', lable: '产证满五', index: 'certificateFive', width: 90},
            {name: 'onlyHousing', lable: '唯一住房', index: 'onlyHousing', width: 90},
            {name: 'lookTimeType', lable: '看房时间', index: 'lookTimeType', width: 90},
            {name: 'innerCode', lable: '内部编号', index: 'innerCode', width: 90},
            {name: 'taxType', lable: '税费类型', index: 'taxType', width: 90},
            {name: 'payType', lable: '支付方式', index: 'payType', width: 90},
            {name: 'detain', lable: '押', index: 'detain', width: 90},
            {name: 'pay', lable: '付', index: 'pay', width: 90},
            {name: 'delegationType', lable: '委托方式', index: 'delegationType', width: 90},
            {name: 'delegationTime', lable: '委托时间', index: 'delegationTime', width: 90},
            {name: 'readyTime', lable: '交房时间', index: 'readyTime', width: 90},
            {name: 'delegationNo', lable: '委托编号', index: 'delegationNo', width: 90},
            {name: 'sourceType', lable: '来源', index: 'sourceType', width: 90},
            {name: 'actualityType', lable: '现状', index: 'actualityType', width: 90},
            {name: 'propertyRightType', lable: '产权', index: 'propertyRightType', width: 90},
            {name: 'decorationType', lable: '装修', index: 'decorationType', width: 90},
            {name: 'credentialsType', lable: '证书', index: 'credentialsType', width: 90},
            {name: 'baseService', lable: '配套', index: 'baseService', width: 90},
            {name: 'furniture', lable: '家具', index: 'furniture', width: 90},
            {name: 'electronics', lable: '家电', index: 'electronics', width: 90},
            {name: 'paymentType', lable: '付款方式', index: 'paymentType', width: 90},
            {name: 'commissionType', lable: '付拥', index: 'commissionType', width: 90},
            {name: 'hasKey', lable: '钥匙', index: 'hasKey', width: 90},
            {name: 'keyNo', lable: '钥匙编号', index: 'keyNo', width: 90},
            {name: 'owner', lable: '业主', index: 'owner', width: 90},
            {name: 'ownerMobile', lable: '业主电话', index: 'ownerMobile', width: 90},
            {name: 'contact', lable: '联系人', index: 'contact', width: 90},
            {name: 'propertyCredentials', lable: '房产证', index: 'propertyCredentials', width: 90},
            {name: 'nationality', lable: '国籍', index: 'nationality', width: 90},
            {name: 'contactExplain', lable: '联系说明', index: 'contactExplain', width: 90},
            {name: 'remark', lable: '备注', index: 'remark', width: 90},
            {name: 'describes', lable: '房源描述', index: 'describes', width: 90},
            {name: 'tag1', lable: '标签1', index: 'tag1', width: 90},
            {name: 'tag2', lable: '标签2', index: 'tag2', width: 90},
            {name: 'tag3', lable: '标签3', index: 'tag3', width: 90},
            {name: 'createTime', lable: '创建时间', index: 'createTime', width: 90},
            {name: 'modifyTime', lable: '修改时间', index: 'modifyTime', width: 90}
        ]
        // ,footerrow : true, userDataOnFooter: true
    });
});