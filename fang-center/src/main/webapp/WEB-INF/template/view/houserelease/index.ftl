<#assign basicURL="/houserelease/">
<#assign js_config=[
"'basicURL':'${basicURL}'",
"'urlMap':{
'query':'${basicURL}doQueryForPage.json',
'add':'${basicURL}doAdd.json',
'update':'${basicURL}doModify.json',
'delete':'${basicURL}doDelete.json',
'batchUpdate':'${basicURL}doBatchStatusChange.json'
}"]>
<#assign js_url='[/statics/js/houserelease/houseReleaseIndex.js]'>
<@macro.iframe js_config=js_config js_url=js_url >
<div class="easyui-tabs" id="Data_Tabs" fit="true" border="false">
    <div title="列表" class="tab-container">
        <div class="easyui-layout" fit="true" border="false">
            <div id="Query_Box" region="north" class="condition" border="false">
                <div class="query-form">
                    <ul>
                        <li><label for="fullname">查询名称</label><input class="wid200" id="fullname"  name="fullname" type="text"></li>
                    </ul>
                    <div class="btn-w"><a id="Query_Button" class="easyui-linkbutton" iconCls="icon-search">查询</a>
                        <a id="Reset_Button" class="easyui-linkbutton" iconCls="icon-redo" href="javascript:Data_Globals.resetQuery()">重置</a></div>
                </div>
            </div>

            <div region="center" border="false">
                <div  class="easyui-layout" fit="true" border="false">
                    <div region="center"  border="false">
                        <table id="Data_Grid" fit="true" toolbar="#Data_Grid_TB">
                            <thead>
                            <tr>
                                <th field="code" sortable="true" width="60">内部编码</th>
                                <th field="collectFangUuid" sortable="true" width="60">采集房源_uuid</th>
                                <th field="useType" sortable="true" width="200">用途</th>
                                <th field="salesType" sortable="true" width="200">销售类型</th>
                                <th field="status" sortable="true" width="200">状态</th>
                                <th field="gradingName" sortable="true" width="60">楼盘名称</th>
                                <th field="province" sortable="true" width="80">省</th>
                                <th field="city" sortable="true" width="80">市</th>
                                <th field="district" sortable="true" width="60">区县</th>
                                <th field="cbd" sortable="true" width="60">商圈</th>
                                <th field="address" sortable="true" width="60">地址</th>
                                <th field="buildingNo" sortable="true" width="60">楼号</th>
                                <th field="unitNo" sortable="true" width="60">单元</th>
                                <th field="houseNo" sortable="true" width="60">房号</th>
                                <th field="floor" sortable="true" width="80">楼层</th>
                                <th field="totalFloor" sortable="true" width="80">总楼层</th>
                                <th field="room" sortable="true" width="80">室</th>
                                <th field="hall" sortable="true" width="80">厅</th>
                                <th field="kitchen" sortable="true" width="80">厨</th>
                                <th field="toilet" sortable="true" width="80">卫</th>
                                <th field="balcony" sortable="true" width="80">阳台</th>
                                <th field="position" sortable="true" width="60">位置</th>
                                <th field="floorNum" sortable="true" width="200">层数</th>
                                <th field="level" sortable="true" width="200">级别</th>
                                <th field="capacity" sortable="true" width="60">排量</th>
                                <th field="feature" sortable="true" width="60">特色</th>
                                <th field="publishPrice" sortable="true" width="80">价格</th>
                                <th field="lowestPrice" sortable="true" width="80">最低首付</th>
                                <th field="propertyRightType2" sortable="true" width="200">产权性质</th>
                                <th field="buildingYear" sortable="true" width="80">建筑年代</th>
                                <th field="buildingArea" sortable="true" width="80">建筑面积</th>
                                <th field="housingType" sortable="true" width="200">住宅类型</th>
                                <th field="decorationType2" sortable="true" width="200">装修类型</th>
                                <th field="orientation" sortable="true" width="200">朝向</th>
                                <th field="buildingStructure" sortable="true" width="200">建筑结构</th>
                                <th field="certificateFive" sortable="true" width="200">产证满五</th>
                                <th field="onlyHousing" sortable="true" width="200">唯一住房</th>
                                <th field="lookTimeType" sortable="true" width="60">看房时间</th>
                                <th field="innerCode" sortable="true" width="60">内部编号</th>
                                <th field="taxType" sortable="true" width="200">税费类型</th>
                                <th field="payType" sortable="true" width="200">支付方式</th>
                                <th field="detain" sortable="true" width="80">押</th>
                                <th field="pay" sortable="true" width="80">付</th>
                                <th field="delegationType" sortable="true" width="200">委托方式</th>
                                <th field="delegationTime" sortable="true" width="150">委托时间</th>
                                <th field="readyTime" sortable="true" width="150">交房时间</th>
                                <th field="delegationNo" sortable="true" width="60">委托编号</th>
                                <th field="sourceType" sortable="true" width="200">来源</th>
                                <th field="actualityType" sortable="true" width="200">现状</th>
                                <th field="propertyRightType" sortable="true" width="200">产权</th>
                                <th field="decorationType" sortable="true" width="200">装修</th>
                                <th field="credentialsType" sortable="true" width="200">证书</th>
                                <th field="baseService" sortable="true" width="60">配套</th>
                                <th field="furniture" sortable="true" width="60">家具</th>
                                <th field="electronics" sortable="true" width="60">家电</th>
                                <th field="paymentType" sortable="true" width="200">付款方式</th>
                                <th field="commissionType" sortable="true" width="200">付拥</th>
                                <th field="hasKey" sortable="true" width="200">钥匙</th>
                                <th field="keyNo" sortable="true" width="60">钥匙编号</th>
                                <th field="owner" sortable="true" width="60">业主</th>
                                <th field="ownerMobile" sortable="true" width="60">业主电话</th>
                                <th field="contact" sortable="true" width="60">联系人</th>
                                <th field="propertyCredentials" sortable="true" width="60">房产证</th>
                                <th field="nationality" sortable="true" width="60">国籍</th>
                                <th field="contactExplain" sortable="true" width="60">联系说明</th>
                                <th field="remark" sortable="true" width="60">备注</th>
                                <th field="tag1" sortable="true" width="60">标签1</th>
                                <th field="tag2" sortable="true" width="60">标签2</th>
                                <th field="tag3" sortable="true" width="60">标签3</th>
                                <th field="createTime" sortable="true" width="150">创建时间</th>
                                <th field="modifyTime" sortable="true" width="150">修改时间</th>
                                <th field="describes" sortable="true" width="60">房源描述</th>
                            </tr>
                            </thead>
                        </table>
                        <div id="Data_Grid_TB" class="toolbar">
                            <a id="Data_Add" title="新增" class="b-barbutton b-add">新增</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="Data_Dialog"></div>
</@macro.iframe>