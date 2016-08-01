<form id="china-area-operator" action="/chinaarea/save.json" method="post">
    <input type="hidden" id="id" name="id" value="${data.id}" />
    <div class="form-input">
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">区域类型
-1:区域1:国家
2:省/自治区/直辖市
3:地区(省下面的地级市)
4:县/市(县级市)/区
6:海外</span>
                    <input type="text" name="areaType" class="form-control" placeholder="区域类型
-1:区域1:国家
2:省/自治区/直辖市
3:地区(省下面的地级市)
4:县/市(县级市)/区
6:海外">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon"></span>
                    <input type="text" name="areaCode" class="form-control" placeholder="">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon"></span>
                    <input type="text" name="areaName" class="form-control" placeholder="">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon"></span>
                    <input type="text" name="areaAbbname" class="form-control" placeholder="">
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon"></span>
                    <input type="text" name="remark" class="form-control" placeholder="">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">创建时间</span>
                    <input type="text" name="gmtCreate" class="form-control form-date" placeholder="创建时间" readonly>
                </div>
            </div>
        </div><br>
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">修改时间</span>
                    <input type="text" name="gmtModified" class="form-control form-date" placeholder="修改时间" readonly>
                </div>
            </div>
        </div><br>
    </div>
    <div class="form-footer">
        <button type="button" class="btn btn-default btn-close" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary btn-save">保存</button>
    </div>
</form>
<script language="text/javascript" src="/statics/js/chinaarea/china-area-operator.js"></script>