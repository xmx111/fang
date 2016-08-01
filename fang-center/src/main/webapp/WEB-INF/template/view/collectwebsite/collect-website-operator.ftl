<form id="collect-website-operator" action="/collectwebsite/save.json" method="post">
    <input type="hidden" id="id" name="id" value="${data.id}" />
    <div class="form-input">
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">网站地址</span>
                    <input type="text" name="url" class="form-control" placeholder="网站地址">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">网站图标</span>
                    <input type="text" name="icon" class="form-control" placeholder="网站图标">
                </div>
            </div>
        </div><br>
    </div>
    <div class="form-footer">
        <button type="button" class="btn btn-default btn-close" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary btn-save">保存</button>
    </div>
</form>
<script language="text/javascript" src="/statics/js/collectwebsite/collect-website-operator.js"></script>