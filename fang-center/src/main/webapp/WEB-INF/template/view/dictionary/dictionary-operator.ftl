<form id="dictionary-operator" action="/dictionary/save.json" method="post">
    <input type="hidden" id="id" name="id" value="${data.id}" />
    <div class="form-input">
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">代码</span>
                    <input type="text" name="code" class="form-control" placeholder="代码">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">值</span>
                    <input type="text" name="value" class="form-control" placeholder="值">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">状态：0-无效,1-有效</span>
                    <input type="text" name="status" class="form-control" placeholder="状态：0-无效,1-有效">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">描述</span>
                    <input type="text" name="description" class="form-control" placeholder="描述">
                </div>
            </div>
        </div><br>
    </div>
    <div class="form-footer">
        <button type="button" class="btn btn-default btn-close" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary btn-save">保存</button>
    </div>
</form>
<script language="text/javascript" src="/statics/js/dictionary/dictionary-operator.js"></script>