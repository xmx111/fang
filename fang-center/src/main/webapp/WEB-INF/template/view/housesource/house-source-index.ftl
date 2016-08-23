<div class="row">
    <div class="col-md-12 grid-main">
        <div class="row search-form-default">
            <div class="col-md-12">
                <div class="row">
                    <form id="house-source-form" action="#">
                        <div class="col-md-9">
                            <dl>
                                <dd><span>区县：</span><select class="form-control" name="distinct" id="distinct"></select></dd>
                                <dd><span>商圈：</span><select class="form-control min150" name="cbd" id="cbd"></select></dd>
                                <dd><span>关键字：</span><input type="text" name="keys" class="form-control-search w100" placeholder="关键字"></dd>
                                <dd><span>房源类型：</span><@dicSelect keyValueType="houseStyle" id="houseStyle" name="houseStyle" class="form-control-select-search w100"/></dd>
                                <dd><span>来源：</span><@dicSelect keyValueType="houseSource" id="houseSource" name="houseSource" class="form-control-select-search w100"/></dd>
                                <dd><span>户型：</span><@dicSelect keyValueType="houseType" id="houseType" name="houseType" class="form-control-select-search w100"/></dd>
                                <dd><span>面积：</span><input type="text" name="areaBegin" class="form-control-search w50">-<input type="text" name="areaEnd" class="form-control-search w50">㎡</dd>
                                <dd><span>价格：</span><input type="text" name="priceBegin" class="form-control-search w50">-<input type="text" name="priceEnd" class="form-control-search w50">万</dd>
                            </dl>
                        </div>
                        <div class="col-md-3">
                            <div class="btn-group">
                                <button type="button" class="btn btn-success btn-query"><span class="icon-search"></span> 查询</button>
                                <button type="button" class="btn btn-success btn-repeat"><span class="icon-repeat"></span> 重置</button>
                                <button type="button" class="btn btn-success btn-export"><span class="icon-file-excel"></span> 导出</button>
                            </div>
                        </div>
                        <#--<div class="col-md-9">-->
                            <#--<div class="input-group">-->
                                <#--<select class="form-control" name="distinct" id="distinct"></select>-->
                                <#--<span class="input-group-addon fix-border fix-padding"></span>-->
                                <#--<input type="text" name="name" class="form-control" placeholder="名称">-->
                                <#--<span class="input-group-addon fix-border fix-padding"></span>-->
                                <#--<input type="text" name="name" class="form-control" placeholder="名称">-->
                            <#--</div>-->
                        <#--</div>-->
                        <#--<div class="col-md-3">-->
                            <#--<div class="btn-group">-->
                                <#--<button type="button" class="btn btn-success btn-query"><span class="icon-search"></span> 查询</button>-->
                                <#--<button type="button" class="btn btn-success btn-repeat"><span class="icon-repeat"></span> 重置</button>-->
                                <#--<button type="button" class="btn btn-success btn-export"><span class="icon-file-excel"></span> 导出</button>-->
                            <#--</div>-->
                        <#--</div>-->
                    </form>
                </div>
            </div>
        </div>
        <div class="row grid-default">
            <div class="col-md-12">
                <table id="house-source-grid"></table>
            </div>
        </div>
    </div>
</div>
<script src="/statics/js/housesource/house-source-index.js" type="text/javascript"></script>