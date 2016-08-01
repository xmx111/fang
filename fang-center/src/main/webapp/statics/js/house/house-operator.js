$(function() {
    /* 提交按钮事件 */
    $('#house-operator btn-save').click(function(){
        Global.post($('#house-operator').attr('action'), $('#house-operator').serialize());
    });
});