<@macro.iframe js_config=js_config js_url=js_url >
<script language="text/javascript" src="/statics/js/house/operator.js"></script>
<div title="House信息" class="tab-container">
    <form id="Data_Form" method="post" >
        <input type="hidden" id="id" name="id" value="${data.id}" />
        <table class="dialog-table">
            <tr>
                <td class="lable">内部编码</td>
                <td>
                        <input type="text" id="code" name="code" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">采集房源_uuid</td>
                <td>
                        <input type="text" id="collectFangUuid" name="collectFangUuid" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">用途</td>
                <td>
                        <select id="useType" name="useType">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                </td>
            </tr>
            <tr>
                <td class="lable">销售类型</td>
                <td>
                        <select id="salesType" name="salesType">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                </td>
            </tr>
            <tr>
                <td class="lable">状态</td>
                <td>
                        <select id="status" name="status">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                </td>
            </tr>
            <tr>
                <td class="lable">楼盘名称</td>
                <td>
                        <input type="text" id="gradingName" name="gradingName" class="easyui-validatebox wid200"></input>
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
                <td class="lable">区县</td>
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
                <td class="lable">地址</td>
                <td>
                        <input type="text" id="address" name="address" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">楼号</td>
                <td>
                        <input type="text" id="buildingNo" name="buildingNo" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">单元</td>
                <td>
                        <input type="text" id="unitNo" name="unitNo" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">房号</td>
                <td>
                        <input type="text" id="houseNo" name="houseNo" class="easyui-validatebox wid200"></input>
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
                <td class="lable">位置</td>
                <td>
                        <input type="text" id="position" name="position" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">层数</td>
                <td>
                        <select id="floorNum" name="floorNum">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                </td>
            </tr>
            <tr>
                <td class="lable">级别</td>
                <td>
                        <select id="level" name="level">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                </td>
            </tr>
            <tr>
                <td class="lable">排量</td>
                <td>
                        <input type="text" id="capacity" name="capacity" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">特色</td>
                <td>
                        <input type="text" id="feature" name="feature" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">价格</td>
                <td>
                        <input type="text" id="publishPrice" name="publishPrice" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">最低首付</td>
                <td>
                        <input type="text" id="lowestPrice" name="lowestPrice" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">产权性质</td>
                <td>
                        <select id="propertyRightType2" name="propertyRightType2">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                </td>
            </tr>
            <tr>
                <td class="lable">建筑年代</td>
                <td>
                        <input type="text" id="buildingYear" name="buildingYear" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">建筑面积</td>
                <td>
                        <input type="text" id="buildingArea" name="buildingArea" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">住宅类型</td>
                <td>
                        <select id="housingType" name="housingType">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                </td>
            </tr>
            <tr>
                <td class="lable">装修类型</td>
                <td>
                        <select id="decorationType2" name="decorationType2">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                </td>
            </tr>
            <tr>
                <td class="lable">朝向</td>
                <td>
                        <select id="orientation" name="orientation">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                </td>
            </tr>
            <tr>
                <td class="lable">建筑结构</td>
                <td>
                        <select id="buildingStructure" name="buildingStructure">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                </td>
            </tr>
            <tr>
                <td class="lable">产证满五</td>
                <td>
                        <select id="certificateFive" name="certificateFive">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                </td>
            </tr>
            <tr>
                <td class="lable">唯一住房</td>
                <td>
                        <select id="onlyHousing" name="onlyHousing">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                </td>
            </tr>
            <tr>
                <td class="lable">看房时间</td>
                <td>
                        <input type="text" id="lookTimeType" name="lookTimeType" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">内部编号</td>
                <td>
                        <input type="text" id="innerCode" name="innerCode" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">税费类型</td>
                <td>
                        <select id="taxType" name="taxType">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                </td>
            </tr>
            <tr>
                <td class="lable">支付方式</td>
                <td>
                        <select id="payType" name="payType">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                </td>
            </tr>
            <tr>
                <td class="lable">押</td>
                <td>
                        <input type="text" id="detain" name="detain" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">付</td>
                <td>
                        <input type="text" id="pay" name="pay" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">委托方式</td>
                <td>
                        <select id="delegationType" name="delegationType">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                </td>
            </tr>
            <tr>
                <td class="lable">委托时间</td>
                <td>
                        <input type="text" id="delegationTime" name="delegationTime" style="width:133px" class="Wdate easyui-validatebox" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true})" />
                </td>
            </tr>
            <tr>
                <td class="lable">交房时间</td>
                <td>
                        <input type="text" id="readyTime" name="readyTime" style="width:133px" class="Wdate easyui-validatebox" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true})" />
                </td>
            </tr>
            <tr>
                <td class="lable">委托编号</td>
                <td>
                        <input type="text" id="delegationNo" name="delegationNo" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">来源</td>
                <td>
                        <select id="sourceType" name="sourceType">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                </td>
            </tr>
            <tr>
                <td class="lable">现状</td>
                <td>
                        <select id="actualityType" name="actualityType">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                </td>
            </tr>
            <tr>
                <td class="lable">产权</td>
                <td>
                        <select id="propertyRightType" name="propertyRightType">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                </td>
            </tr>
            <tr>
                <td class="lable">装修</td>
                <td>
                        <select id="decorationType" name="decorationType">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                </td>
            </tr>
            <tr>
                <td class="lable">证书</td>
                <td>
                        <select id="credentialsType" name="credentialsType">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                </td>
            </tr>
            <tr>
                <td class="lable">配套</td>
                <td>
                        <input type="text" id="baseService" name="baseService" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">家具</td>
                <td>
                        <input type="text" id="furniture" name="furniture" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">家电</td>
                <td>
                        <input type="text" id="electronics" name="electronics" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">付款方式</td>
                <td>
                        <select id="paymentType" name="paymentType">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                </td>
            </tr>
            <tr>
                <td class="lable">付拥</td>
                <td>
                        <select id="commissionType" name="commissionType">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                </td>
            </tr>
            <tr>
                <td class="lable">钥匙</td>
                <td>
                        <select id="hasKey" name="hasKey">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                </td>
            </tr>
            <tr>
                <td class="lable">钥匙编号</td>
                <td>
                        <input type="text" id="keyNo" name="keyNo" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">业主</td>
                <td>
                        <input type="text" id="owner" name="owner" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">业主电话</td>
                <td>
                        <input type="text" id="ownerMobile" name="ownerMobile" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">联系人</td>
                <td>
                        <input type="text" id="contact" name="contact" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">房产证</td>
                <td>
                        <input type="text" id="propertyCredentials" name="propertyCredentials" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">国籍</td>
                <td>
                        <input type="text" id="nationality" name="nationality" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">联系说明</td>
                <td>
                        <input type="text" id="contactExplain" name="contactExplain" class="easyui-validatebox wid200"></input>
                </td>
            </tr>
            <tr>
                <td class="lable">备注</td>
                <td>
                        <input type="text" id="remark" name="remark" class="easyui-validatebox wid200"></input>
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