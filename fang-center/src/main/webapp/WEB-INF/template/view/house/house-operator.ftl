<form id="house-operator" action="/house/save.json" method="post">
    <input type="hidden" id="id" name="id" value="${data.id}" />
    <div class="form-input">
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">内部编码</span>
                    <input type="text" name="code" class="form-control" placeholder="内部编码">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">采集房源_uuid</span>
                    <input type="text" name="collectFangUuid" class="form-control" placeholder="采集房源_uuid">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">用途</span>
                    <select id="useType" name="useType">
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">销售类型</span>
                    <select id="salesType" name="salesType">
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">状态</span>
                    <select id="status" name="status">
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">楼盘名称</span>
                    <input type="text" name="gradingName" class="form-control" placeholder="楼盘名称">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">省</span>
                    <input type="text" name="province" class="form-control" placeholder="省">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">市</span>
                    <input type="text" name="city" class="form-control" placeholder="市">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">区县</span>
                    <input type="text" name="district" class="form-control" placeholder="区县">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">商圈</span>
                    <input type="text" name="cbd" class="form-control" placeholder="商圈">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">地址</span>
                    <input type="text" name="address" class="form-control" placeholder="地址">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">楼号</span>
                    <input type="text" name="buildingNo" class="form-control" placeholder="楼号">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">单元</span>
                    <input type="text" name="unitNo" class="form-control" placeholder="单元">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">房号</span>
                    <input type="text" name="houseNo" class="form-control" placeholder="房号">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">楼层</span>
                    <input type="text" name="floor" class="form-control" placeholder="楼层">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">总楼层</span>
                    <input type="text" name="totalFloor" class="form-control" placeholder="总楼层">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">室</span>
                    <input type="text" name="room" class="form-control" placeholder="室">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">厅</span>
                    <input type="text" name="hall" class="form-control" placeholder="厅">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">厨</span>
                    <input type="text" name="kitchen" class="form-control" placeholder="厨">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">卫</span>
                    <input type="text" name="toilet" class="form-control" placeholder="卫">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">阳台</span>
                    <input type="text" name="balcony" class="form-control" placeholder="阳台">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">位置</span>
                    <input type="text" name="position" class="form-control" placeholder="位置">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">层数</span>
                    <select id="floorNum" name="floorNum">
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">级别</span>
                    <select id="level" name="level">
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">排量</span>
                    <input type="text" name="capacity" class="form-control" placeholder="排量">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">特色</span>
                    <input type="text" name="feature" class="form-control" placeholder="特色">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">价格</span>
                    <input type="text" name="publishPrice" class="form-control" placeholder="价格">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">最低首付</span>
                    <input type="text" name="lowestPrice" class="form-control" placeholder="最低首付">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">产权性质</span>
                    <select id="propertyRightType2" name="propertyRightType2">
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">建筑年代</span>
                    <input type="text" name="buildingYear" class="form-control" placeholder="建筑年代">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">建筑面积</span>
                    <input type="text" name="buildingArea" class="form-control" placeholder="建筑面积">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">住宅类型</span>
                    <select id="housingType" name="housingType">
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">装修类型</span>
                    <select id="decorationType2" name="decorationType2">
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">朝向</span>
                    <select id="orientation" name="orientation">
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">建筑结构</span>
                    <select id="buildingStructure" name="buildingStructure">
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">产证满五</span>
                    <select id="certificateFive" name="certificateFive">
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">唯一住房</span>
                    <select id="onlyHousing" name="onlyHousing">
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">看房时间</span>
                    <input type="text" name="lookTimeType" class="form-control" placeholder="看房时间">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">内部编号</span>
                    <input type="text" name="innerCode" class="form-control" placeholder="内部编号">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">税费类型</span>
                    <select id="taxType" name="taxType">
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">支付方式</span>
                    <select id="payType" name="payType">
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">押</span>
                    <input type="text" name="detain" class="form-control" placeholder="押">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">付</span>
                    <input type="text" name="pay" class="form-control" placeholder="付">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">委托方式</span>
                    <select id="delegationType" name="delegationType">
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">委托时间</span>
                    <input type="text" name="delegationTime" class="form-control form-date" placeholder="委托时间" readonly>
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">交房时间</span>
                    <input type="text" name="readyTime" class="form-control form-date" placeholder="交房时间" readonly>
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">委托编号</span>
                    <input type="text" name="delegationNo" class="form-control" placeholder="委托编号">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">来源</span>
                    <select id="sourceType" name="sourceType">
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">现状</span>
                    <select id="actualityType" name="actualityType">
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">产权</span>
                    <select id="propertyRightType" name="propertyRightType">
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">装修</span>
                    <select id="decorationType" name="decorationType">
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">证书</span>
                    <select id="credentialsType" name="credentialsType">
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">配套</span>
                    <input type="text" name="baseService" class="form-control" placeholder="配套">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">家具</span>
                    <input type="text" name="furniture" class="form-control" placeholder="家具">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">家电</span>
                    <input type="text" name="electronics" class="form-control" placeholder="家电">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">付款方式</span>
                    <select id="paymentType" name="paymentType">
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">付拥</span>
                    <select id="commissionType" name="commissionType">
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">钥匙</span>
                    <select id="hasKey" name="hasKey">
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">钥匙编号</span>
                    <input type="text" name="keyNo" class="form-control" placeholder="钥匙编号">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">业主</span>
                    <input type="text" name="owner" class="form-control" placeholder="业主">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">业主电话</span>
                    <input type="text" name="ownerMobile" class="form-control" placeholder="业主电话">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">联系人</span>
                    <input type="text" name="contact" class="form-control" placeholder="联系人">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">房产证</span>
                    <input type="text" name="propertyCredentials" class="form-control" placeholder="房产证">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">国籍</span>
                    <input type="text" name="nationality" class="form-control" placeholder="国籍">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">联系说明</span>
                    <input type="text" name="contactExplain" class="form-control" placeholder="联系说明">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">备注</span>
                    <input type="text" name="remark" class="form-control" placeholder="备注">
                </div>
            </div>
        </div><br>
    </div>
    <div class="form-footer">
        <button type="button" class="btn btn-default btn-close" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary btn-save">保存</button>
    </div>
</form>
<script language="text/javascript" src="/statics/js/house/house-operator.js"></script>