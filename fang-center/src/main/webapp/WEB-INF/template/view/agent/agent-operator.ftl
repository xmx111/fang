<form id="agent-operator" action="/agent/save.json" method="post">
    <input type="hidden" id="id" name="id" value="${data.id}" />
    <div class="form-input">
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">姓名</span>
                    <input type="text" name="name" class="form-control" placeholder="姓名">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">手机</span>
                    <input type="text" name="mobile" class="form-control" placeholder="手机">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">密码</span>
                    <input type="text" name="password" class="form-control" placeholder="密码">
                </div>
            </div>
        </div><br>
    </div>
    <div class="form-footer">
        <button type="button" class="btn btn-default btn-close" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary btn-save">保存</button>
    </div>
</form>
<script language="text/javascript" src="/statics/js/agent/agent-operator.js"></script>