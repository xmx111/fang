<@macro.iframe js_config=js_config js_url=js_url >
<script language="text/javascript" src="/statics/js/user/operator.js"></script>
<div title="com.ufo.fang.center.model.User信息" class="tab-container">
    <form id="Data_Form" method="post" >
        <input type="hidden" id="id" name="id" value="${data.id}" />
        <table class="dialog-table">
            <tr>
                <td class="lable">用户名</td>
                <td>
                    <input type="text" id="username" name="username" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">姓名</td>
                <td>
                    <input type="text" id="fullname" name="fullname" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">性别</td>
                <td>
                    <input type="text" id="sex" name="sex" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">用户密码</td>
                <td>
                    <input type="text" id="password" name="password" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">邮箱地址</td>
                <td>
                    <input type="text" id="email" name="email" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">手机号码</td>
                <td>
                    <input type="text" id="mobilephone" name="mobilephone" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">用户状态</td>
                <td>
                    <@dicSelect keyValueType="status" id="status"  name="status" class="wid100" />
                </td>
            </tr>
            <tr>
                <td class="lable">创建人名称</td>
                <td>
                    <input type="text" id="creatorName" name="creatorName" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">修改人名称</td>
                <td>
                    <input type="text" id="modifierName" name="modifierName" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
        </table>
        <div class="dialog-bottom-toolbar">
            <a id="Submit_Button"  class="easyui-linkbutton" iconCls="icon-save">保存</a>
            <a id="cancel_button" onclick="UI.close('Data_Dialog')"  class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
        </div>
    </form>
</div>
<!--表单字段--结束 -->
</@macro.iframe>