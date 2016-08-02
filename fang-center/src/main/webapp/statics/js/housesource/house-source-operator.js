$(function() {
    /* 提交按钮事件 */
    $('#house-source-operator .btn-save').click(function(){
        Global.post($('#house-source-operator').attr('action'), $('#house-source-operator').serialize());
    });
});