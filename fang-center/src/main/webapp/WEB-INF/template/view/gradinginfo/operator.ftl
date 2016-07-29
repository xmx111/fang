<@macro.iframe js_config=js_config js_url=js_url >
<script language="text/javascript" src="/statics/js/gradinginfo/operator.js"></script>
<div title="GradingInfo信息" class="tab-container">
    <form id="Data_Form" method="post" >
        <input type="hidden" id="id" name="id" value="${data.id}" />
        <table class="dialog-table">
            <tr>
                <td class="lable">交通状况</td>
                <td>
                        <input type="text" id="trafficDescribe" name="trafficDescribe" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">大学</td>
                <td>
                        <input type="text" id="university" name="university" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">中小学</td>
                <td>
                        <input type="text" id="school" name="school" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">幼儿园</td>
                <td>
                        <input type="text" id="kindergarten" name="kindergarten" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">商场</td>
                <td>
                        <input type="text" id="mall" name="mall" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">邮局</td>
                <td>
                        <input type="text" id="postOffice" name="postOffice" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">银行</td>
                <td>
                        <input type="text" id="bank" name="bank" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">医院</td>
                <td>
                        <input type="text" id="hospital" name="hospital" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">其它</td>
                <td>
                        <input type="text" id="other" name="other" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">联系电话</td>
                <td>
                        <input type="text" id="tel" name="tel" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">创建时间</td>
                <td>
                        <input type="text" id="createTime" name="createTime" style="width:133px" class="Wdate easyui-validatebox" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true})" />
                </td>
            </tr>
            <tr>
                <td class="lable">修改时间</td>
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