<@macro.iframe js_config=js_config js_url=js_url >
<script language="text/javascript" src="/statics/js/housesource/operator.js"></script>
<div title="HouseSource信息" class="tab-container">
    <form id="Data_Form" method="post" >
        <input type="hidden" id="id" name="id" value="${data.id}" />
        <table class="dialog-table">
            <tr>
                <td class="lable">uuid</td>
                <td>
                        <input type="text" id="uuid" name="uuid" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">来源</td>
                <td>
                        <input type="text" id="source" name="source" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">来源url</td>
                <td>
                        <input type="text" id="url" name="url" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">外部id</td>
                <td>
                        <input type="text" id="sourceId" name="sourceId" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">标题</td>
                <td>
                        <input type="text" id="title" name="title" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">楼盘名称</td>
                <td>
                        <input type="text" id="gradingName" name="gradingName" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">用途</td>
                <td>
                        <input type="text" id="useType" name="useType" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">销售类型</td>
                <td>
                        <input type="text" id="salesType" name="salesType" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">状态</td>
                <td>
                        <input type="text" id="status" name="status" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">省</td>
                <td>
                        <input type="text" id="province" name="province" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">市</td>
                <td>
                        <input type="text" id="city" name="city" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">区</td>
                <td>
                        <input type="text" id="district" name="district" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">商圈</td>
                <td>
                        <input type="text" id="cbd" name="cbd" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">室</td>
                <td>
                        <input type="text" id="room" name="room" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">厅</td>
                <td>
                        <input type="text" id="hall" name="hall" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">厨</td>
                <td>
                        <input type="text" id="kitchen" name="kitchen" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">卫</td>
                <td>
                        <input type="text" id="toilet" name="toilet" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">阳台</td>
                <td>
                        <input type="text" id="balcony" name="balcony" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">楼层</td>
                <td>
                        <input type="text" id="floor" name="floor" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">总楼层</td>
                <td>
                        <input type="text" id="totalFloor" name="totalFloor" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">产权性质</td>
                <td>
                        <input type="text" id="propertyRightType" name="propertyRightType" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">建筑年代</td>
                <td>
                        <input type="text" id="buildingYear" name="buildingYear" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">住宅类型</td>
                <td>
                        <input type="text" id="housingType" name="housingType" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">装修类型</td>
                <td>
                        <input type="text" id="decorationType" name="decorationType" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">建筑结构</td>
                <td>
                        <input type="text" id="buildingStructure" name="buildingStructure" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">朝向</td>
                <td>
                        <input type="text" id="orientation" name="orientation" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">房源描述</td>
                <td>
                        <input type="text" id="describes" name="describes" class="easyui-validatebox wid200"></input>
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