<@macro.iframe js_config=js_config js_url=js_url >
<script language="text/javascript" src="/statics/js/dictionary/operator.js"></script>
<div title="Dictionary信息" class="tab-container">
    <form id="Data_Form" method="post" >
        <input type="hidden" id="id" name="id" value="${data.id}" />
        <table class="dialog-table">
            <tr>
                <td class="lable">代码</td>
                <td>
                        <input type="text" id="code" name="code" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">值</td>
                <td>
                        <input type="text" id="value" name="value" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">状态：0-无效,1-有效</td>
                <td>
                        <input type="text" id="status" name="status" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">描述</td>
                <td>
                        <input type="text" id="description" name="description" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">创建时间</td>
                <td>
                        <input type="text" id="gmtCreate" name="gmtCreate" style="width:133px" class="Wdate easyui-validatebox" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true})" />
                </td>
            </tr>
            <tr>
                <td class="lable">修改时间</td>
                <td>
                        <input type="text" id="gmtModified" name="gmtModified" style="width:133px" class="Wdate easyui-validatebox" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true})" />
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