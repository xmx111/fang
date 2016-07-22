<#assign basicURL="/housesource/">
<#assign js_config=[
"'basicURL':'${basicURL}'",
"'urlMap':{
'query':'${basicURL}doQueryForPage.json',
'add':'${basicURL}doAdd.json',
'update':'${basicURL}doModify.json',
'delete':'${basicURL}doDelete.json',
'batchUpdate':'${basicURL}doBatchStatusChange.json'
}"]>
<#assign js_url='[/statics/js/housesource/houseSourceIndex.js]'>
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
                                <th field="uuid" sortable="true" width="60">uuid</th>
                                <th field="source" sortable="true" width="60">来源</th>
                                <th field="url" sortable="true" width="60">来源url</th>
                                <th field="sourceId" sortable="true" width="60">外部id</th>
                                <th field="title" sortable="true" width="60">标题</th>
                                <th field="gradingName" sortable="true" width="60">楼盘名称</th>
                                <th field="useType" sortable="true" width="60">用途</th>
                                <th field="salesType" sortable="true" width="60">销售类型</th>
                                <th field="status" sortable="true" width="60">状态</th>
                                <th field="province" sortable="true" width="80">省</th>
                                <th field="city" sortable="true" width="80">市</th>
                                <th field="district" sortable="true" width="60">区</th>
                                <th field="cbd" sortable="true" width="60">商圈</th>
                                <th field="room" sortable="true" width="80">室</th>
                                <th field="hall" sortable="true" width="80">厅</th>
                                <th field="kitchen" sortable="true" width="80">厨</th>
                                <th field="toilet" sortable="true" width="80">卫</th>
                                <th field="balcony" sortable="true" width="80">阳台</th>
                                <th field="floor" sortable="true" width="80">楼层</th>
                                <th field="totalFloor" sortable="true" width="80">总楼层</th>
                                <th field="propertyRightType" sortable="true" width="60">产权性质</th>
                                <th field="buildingYear" sortable="true" width="60">建筑年代</th>
                                <th field="housingType" sortable="true" width="60">住宅类型</th>
                                <th field="decorationType" sortable="true" width="60">装修类型</th>
                                <th field="buildingStructure" sortable="true" width="60">建筑结构</th>
                                <th field="orientation" sortable="true" width="60">朝向</th>
                                <th field="describes" sortable="true" width="60">房源描述</th>
                                <th field="createTime" sortable="true" width="150">创建时间</th>
                                <th field="modifyTime" sortable="true" width="150">修改时间</th>
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