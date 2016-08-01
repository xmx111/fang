<form id="grading-info-operator" action="/gradinginfo/save.json" method="post">
    <input type="hidden" id="id" name="id" value="${data.id}" />
    <div class="form-input">
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">交通状况</span>
                    <input type="text" name="trafficDescribe" class="form-control" placeholder="交通状况">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">大学</span>
                    <input type="text" name="university" class="form-control" placeholder="大学">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">中小学</span>
                    <input type="text" name="school" class="form-control" placeholder="中小学">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">幼儿园</span>
                    <input type="text" name="kindergarten" class="form-control" placeholder="幼儿园">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">商场</span>
                    <input type="text" name="mall" class="form-control" placeholder="商场">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">邮局</span>
                    <input type="text" name="postOffice" class="form-control" placeholder="邮局">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">银行</span>
                    <input type="text" name="bank" class="form-control" placeholder="银行">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">医院</span>
                    <input type="text" name="hospital" class="form-control" placeholder="医院">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">其它</span>
                    <input type="text" name="other" class="form-control" placeholder="其它">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">联系电话</span>
                    <input type="text" name="tel" class="form-control" placeholder="联系电话">
                </div>
            </div>
        </div><br>
    </div>
    <div class="form-footer">
        <button type="button" class="btn btn-default btn-close" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary btn-save">保存</button>
    </div>
</form>
<script language="text/javascript" src="/statics/js/gradinginfo/grading-info-operator.js"></script>