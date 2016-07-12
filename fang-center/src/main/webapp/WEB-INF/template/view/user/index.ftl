<#assign basicURL="/user/">
<#assign js_config=[
"'basicURL':'${basicURL}'",
"'urlMap':{
'query':'${basicURL}queryForPage.json',
'add':'${basicURL}add.do',
'update':'${basicURL}modify.do',
'delete':'${basicURL}delete.do',
'batchUpdate':'${basicURL}batchStatusChange.json'
}"]>
<#assign js_url=['/statics/js/user/userIndex.js']>
<@iframe.html js_config=js_config js_url=js_url >
<div class="easyui-tabs" id="Data_Tabs" fit="true" border="false">
    <div title="列表" class="tab-container">
        <div id="Query_Box" class="condition" border="false">
            <form class="query-form">
                <ul>
                    <li><label for="fullname">查询名称</label><input class="wid200" id="fullname"  name="fullname" type="text"></li>
                </ul>
                <div class="btn-w"><a id="Query_Button" class="easyui-linkbutton" iconCls="icon-search">查询</a>
                    <a id="Reset_Button" class="easyui-linkbutton" iconCls="icon-redo" href="javascript:Data_Globals.resetQuery()">重置</a></div>
            </form>
        </div>
        <table id="Data_Grid" fit="true" toolbar="#Data_Grid_TB">
            <thead>
            <tr>
                <th field="username" sortable="true" width="60">用户名</th>
                <th field="fullname" sortable="true" width="60">姓名</th>
                <th field="sex" sortable="true" width="80">性别</th>
                <th field="password" sortable="true" width="60">用户密码</th>
                <th field="email" sortable="true" width="60">邮箱地址</th>
                <th field="mobilephone" sortable="true" width="60">手机号码</th>
                <th field="status" sortable="true" width="80">用户状态</th>
                <th field="gmtCreate" sortable="true" width="150">创建时间</th>
                <th field="gmtModified" sortable="true" width="150">修改时间</th>
                <th field="creatorName" sortable="true" width="60">创建人名称</th>
                <th field="modifierName" sortable="true" width="60">修改人名称</th>
            </tr>
            </thead>
        </table>
        <div id="Data_Grid_TB" class="toolbar">
            <a id="Data_Add" title="新增" class="b-barbutton b-add">新增</a>
        </div>
    </div>
</div>
<div id="Data_Dialog"></div>
</@iframe.html>