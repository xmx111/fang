<form id="house-source-operator" action="/housesource/save.json" method="post">
    <input type="hidden" id="id" name="id" value="${data.id}" />
    <div class="form-input">
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">来源</span>
                    <input type="text" name="source" class="form-control" placeholder="来源">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">来源url</span>
                    <input type="text" name="url" class="form-control" placeholder="来源url">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">外部id</span>
                    <input type="text" name="sourceId" class="form-control" placeholder="外部id">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">标题</span>
                    <input type="text" name="title" class="form-control" placeholder="标题">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">楼盘名称</span>
                    <input type="text" name="gradingName" class="form-control" placeholder="楼盘名称">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">用途</span>
                    <input type="text" name="useType" class="form-control" placeholder="用途">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">销售类型</span>
                    <input type="text" name="salesType" class="form-control" placeholder="销售类型">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">状态</span>
                    <input type="text" name="status" class="form-control" placeholder="状态">
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
                    <span class="input-group-addon">区</span>
                    <input type="text" name="district" class="form-control" placeholder="区">
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
                    <span class="input-group-addon">楼层</span>
                    <input type="text" name="floor" class="form-control" placeholder="楼层">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">总楼层</span>
                    <input type="text" name="totalFloor" class="form-control" placeholder="总楼层">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">产权性质</span>
                    <input type="text" name="propertyRightType" class="form-control" placeholder="产权性质">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">建筑年代</span>
                    <input type="text" name="buildingYear" class="form-control" placeholder="建筑年代">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">住宅类型</span>
                    <input type="text" name="housingType" class="form-control" placeholder="住宅类型">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">装修类型</span>
                    <input type="text" name="decorationType" class="form-control" placeholder="装修类型">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">建筑结构</span>
                    <input type="text" name="buildingStructure" class="form-control" placeholder="建筑结构">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">朝向</span>
                    <input type="text" name="orientation" class="form-control" placeholder="朝向">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">房源描述</span>
                    <input type="text" name="describes" class="form-control" placeholder="房源描述">
                </div>
            </div>
        </div><br>
    </div>
    <div class="form-footer">
        <button type="button" class="btn btn-default btn-close" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary btn-save">保存</button>
    </div>
</form>
<script language="text/javascript" src="/statics/js/housesource/house-source-operator.js"></script>