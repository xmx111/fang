$(function() {
    /* 提交按钮事件 */
    $('#dictionary-operator btn-save').click(function(){
        Global.post($('#dictionary-operator').attr('action'), $('#dictionary-operator').serialize());
    });
});