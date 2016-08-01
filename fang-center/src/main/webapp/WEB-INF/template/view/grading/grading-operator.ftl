<form id="grading-operator" action="/grading/save.json" method="post">
    <input type="hidden" id="id" name="id" value="${data.id}" />
    <div class="form-input">
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">楼盘代码</span>
                    <input type="text" name="code" class="form-control" placeholder="楼盘代码">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">楼盘名称</span>
                    <input type="text" name="name" class="form-control" placeholder="楼盘名称">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">楼盘别名</span>
                    <input type="text" name="anotherName" class="form-control" placeholder="楼盘别名">
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
                    <span class="input-group-addon">物业类型</span>
                    <input type="text" name="estateType" class="form-control" placeholder="物业类型">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">物业地址</span>
                    <input type="text" name="estateAddr" class="form-control" placeholder="物业地址">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">方位描述1</span>
                    <input type="text" name="positionDescribe1" class="form-control" placeholder="方位描述1">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">方位描述2</span>
                    <input type="text" name="positionDescribe2" class="form-control" placeholder="方位描述2">
                </div>
            </div>
        </div><br>
    </div>
    <div class="form-footer">
        <button type="button" class="btn btn-default btn-close" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary btn-save">保存</button>
    </div>
</form>
<script language="text/javascript" src="/statics/js/grading/grading-operator.js"></script>