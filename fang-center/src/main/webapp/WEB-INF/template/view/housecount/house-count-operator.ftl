<form id="house-count-operator" action="/housecount/save.json" method="post">
    <input type="hidden" id="id" name="id" value="${data.id}" />
    <div class="form-input">
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">点击数</span>
                    <input type="text" name="clickNum" class="form-control" placeholder="点击数">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">采集数</span>
                    <input type="text" name="collectNum" class="form-control" placeholder="采集数">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">举报数</span>
                    <input type="text" name="informNum" class="form-control" placeholder="举报数">
                </div>
            </div>
        </div><br>
    </div>
    <div class="form-footer">
        <button type="button" class="btn btn-default btn-close" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary btn-save">保存</button>
    </div>
</form>
<script language="text/javascript" src="/statics/js/housecount/house-count-operator.js"></script>