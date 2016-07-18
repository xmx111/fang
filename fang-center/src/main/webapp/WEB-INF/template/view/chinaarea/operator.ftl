<@macro.iframe js_config=js_config js_url=js_url >
<script language="text/javascript" src="/statics/js/chinaArea/operator.js"></script>
<div title="ChinaArea信息" class="tab-container">
    <form id="Data_Form" method="post" >
        <input type="hidden" id="id" name="id" value="${data.id}" />
        <table class="dialog-table">
            <tr>
                <td class="lable">区域类型
-1:区域1:国家
2:省/自治区/直辖市
3:地区(省下面的地级市)
4:县/市(县级市)/区
6:海外</td>
                <td>
                        <input type="text" id="areaType" name="areaType" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable"></td>
                <td>
                        <input type="text" id="areaCode" name="areaCode" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable"></td>
                <td>
                        <input type="text" id="areaName" name="areaName" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable"></td>
                <td>
                        <input type="text" id="areaAbbname" name="areaAbbname" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable"></td>
                <td>
                        <input type="text" id="remark" name="remark" class="easyui-validatebox wid200"></input>
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