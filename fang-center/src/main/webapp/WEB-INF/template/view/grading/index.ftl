<#assign basicURL="/grading/">
<#assign js_config=[
"'basicURL':'${basicURL}'",
"'urlMap':{
'query':'${basicURL}doQueryForPage.json',
'add':'${basicURL}doAdd.json',
'update':'${basicURL}doModify.json',
'delete':'${basicURL}doDelete.json',
'batchUpdate':'${basicURL}doBatchStatusChange.json'
}"]>
<#assign js_url='[/statics/js/grading/gradingIndex.js]'>
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
                                <th field="code" sortable="true" width="60"></th>
                                <th field="name" sortable="true" width="60"></th>
                                <th field="anotherName" sortable="true" width="60"></th>
                                <th field="status" sortable="true" width="80"></th>
                                <th field="province" sortable="true" width="80"></th>
                                <th field="city" sortable="true" width="80"></th>
                                <th field="district" sortable="true" width="80"></th>
                                <th field="cbd" sortable="true" width="80"></th>
                                <th field="estateType" sortable="true" width="80"></th>
                                <th field="estateAddr" sortable="true" width="60"></th>
                                <th field="positionDescribe1" sortable="true" width="60"></th>
                                <th field="positionDescribe2" sortable="true" width="60"></th>
                                <th field="createTime" sortable="true" width="150"></th>
                                <th field="modifyTime" sortable="true" width="150"></th>
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