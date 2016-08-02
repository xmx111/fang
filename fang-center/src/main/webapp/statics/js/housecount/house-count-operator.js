$(function() {
    /* 提交按钮事件 */
    $('#house-count-operator .btn-save').click(function(){
        Global.post($('#house-count-operator').attr('action'), $('#house-count-operator').serialize());
    });
});