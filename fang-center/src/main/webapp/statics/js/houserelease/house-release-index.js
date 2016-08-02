$(document).ready(function () {
    var grid = $("#house-release-grid");
    grid.initJqGrid({
        url: ctx + 'houserelease/query.json',
        addUrl : 'houserelease/operator.htm',
        editUrl : 'houserelease/operator.htm',
        deleteUrl : 'houserelease/delete.json',
        colNames : ['id', '内部编码', '采集房源_uuid', '用途', '销售类型', '状态', '楼盘名称', '省', '市', '区县', '商圈', '地址', '楼号', '单元', '房号', '楼层', '总楼层', '室', '厅', '厨', '卫', '阳台', '位置', '层数', '级别', '排量', '特色', '价格', '最低首付', '产权性质', '建筑年代', '建筑面积', '住宅类型', '装修类型', '朝向', '建筑结构', '产证满五', '唯一住房', '看房时间', '内部编号', '税费类型', '支付方式', '押', '付', '委托方式', '委托时间', '交房时间', '委托编号', '来源', '现状', '产权', '装修', '证书', '配套', '家具', '家电', '付款方式', '付拥', '钥匙', '钥匙编号', '业主', '业主电话', '联系人', '房产证', '国籍', '联系说明', '备注', '标签1', '标签2', '标签3', '创建时间', '修改时间', '房源描述'],
        colModel : [
            {name:'id', index: 'id', hidden:true},
            {name: 'code', index: 'code', width: 90},
            {name: 'collectFangUuid', index: 'collectFangUuid', width: 90},
            {name: 'useType', index: 'useType', width: 90},
            {name: 'salesType', index: 'salesType', width: 90},
            {name: 'status', index: 'status', width: 90},
            {name: 'gradingName', index: 'gradingName', width: 90},
            {name: 'province', index: 'province', width: 90},
            {name: 'city', index: 'city', width: 90},
            {name: 'district', index: 'district', width: 90},
            {name: 'cbd', index: 'cbd', width: 90},
            {name: 'address', index: 'address', width: 90},
            {name: 'buildingNo', index: 'buildingNo', width: 90},
            {name: 'unitNo', index: 'unitNo', width: 90},
            {name: 'houseNo', index: 'houseNo', width: 90},
            {name: 'floor', index: 'floor', width: 90},
            {name: 'totalFloor', index: 'totalFloor', width: 90},
            {name: 'room', index: 'room', width: 90},
            {name: 'hall', index: 'hall', width: 90},
            {name: 'kitchen', index: 'kitchen', width: 90},
            {name: 'toilet', index: 'toilet', width: 90},
            {name: 'balcony', index: 'balcony', width: 90},
            {name: 'position', index: 'position', width: 90},
            {name: 'floorNum', index: 'floorNum', width: 90},
            {name: 'level', index: 'level', width: 90},
            {name: 'capacity', index: 'capacity', width: 90},
            {name: 'feature', index: 'feature', width: 90},
            {name: 'publishPrice', index: 'publishPrice', width: 90},
            {name: 'lowestPrice', index: 'lowestPrice', width: 90},
            {name: 'propertyRightType2', index: 'propertyRightType2', width: 90},
            {name: 'buildingYear', index: 'buildingYear', width: 90},
            {name: 'buildingArea', index: 'buildingArea', width: 90},
            {name: 'housingType', index: 'housingType', width: 90},
            {name: 'decorationType2', index: 'decorationType2', width: 90},
            {name: 'orientation', index: 'orientation', width: 90},
            {name: 'buildingStructure', index: 'buildingStructure', width: 90},
            {name: 'certificateFive', index: 'certificateFive', width: 90},
            {name: 'onlyHousing', index: 'onlyHousing', width: 90},
            {name: 'lookTimeType', index: 'lookTimeType', width: 90},
            {name: 'innerCode', index: 'innerCode', width: 90},
            {name: 'taxType', index: 'taxType', width: 90},
            {name: 'payType', index: 'payType', width: 90},
            {name: 'detain', index: 'detain', width: 90},
            {name: 'pay', index: 'pay', width: 90},
            {name: 'delegationType', index: 'delegationType', width: 90},
            {name: 'delegationTime', index: 'delegationTime', width: 90},
            {name: 'readyTime', index: 'readyTime', width: 90},
            {name: 'delegationNo', index: 'delegationNo', width: 90},
            {name: 'sourceType', index: 'sourceType', width: 90},
            {name: 'actualityType', index: 'actualityType', width: 90},
            {name: 'propertyRightType', index: 'propertyRightType', width: 90},
            {name: 'decorationType', index: 'decorationType', width: 90},
            {name: 'credentialsType', index: 'credentialsType', width: 90},
            {name: 'baseService', index: 'baseService', width: 90},
            {name: 'furniture', index: 'furniture', width: 90},
            {name: 'electronics', index: 'electronics', width: 90},
            {name: 'paymentType', index: 'paymentType', width: 90},
            {name: 'commissionType', index: 'commissionType', width: 90},
            {name: 'hasKey', index: 'hasKey', width: 90},
            {name: 'keyNo', index: 'keyNo', width: 90},
            {name: 'owner', index: 'owner', width: 90},
            {name: 'ownerMobile', index: 'ownerMobile', width: 90},
            {name: 'contact', index: 'contact', width: 90},
            {name: 'propertyCredentials', index: 'propertyCredentials', width: 90},
            {name: 'nationality', index: 'nationality', width: 90},
            {name: 'contactExplain', index: 'contactExplain', width: 90},
            {name: 'remark', index: 'remark', width: 90},
            {name: 'tag1', index: 'tag1', width: 90},
            {name: 'tag2', index: 'tag2', width: 90},
            {name: 'tag3', index: 'tag3', width: 90},
            {name: 'createTime', index: 'createTime', width: 90},
            {name: 'modifyTime', index: 'modifyTime', width: 90},
            {name: 'describes', index: 'describes', width: 90}
        ]
        // ,footerrow : true, userDataOnFooter: true
    });
});