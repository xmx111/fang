<@macro.iframe js_config=js_config js_url=js_url >
<script language="text/javascript" src="/statics/js/agentThirdAccount/operator.js"></script>
<div title="AgentThirdAccount信息" class="tab-container">
    <form id="Data_Form" method="post" >
        <input type="hidden" id="id" name="id" value="${data.id}" />
        <table class="dialog-table">
            <tr>
                <td class="lable"></td>
                <td>
                        <input type="text" id="accountNo" name="accountNo" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable"></td>
                <td>
                        <input type="text" id="password" name="password" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable"></td>
                <td>
                        <input type="text" id="createTime" name="createTime" style="width:133px" class="Wdate easyui-validatebox" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true})" />
                </td>
            </tr>
            <tr>
                <td class="lable"></td>
                <td>
                        <input type="text" id="modifyTime" name="modifyTime" style="width:133px" class="Wdate easyui-validatebox" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true})" />
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