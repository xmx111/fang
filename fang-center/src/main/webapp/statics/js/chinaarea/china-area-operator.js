$(function() {
    /* 提交按钮事件 */
    $('#china-area-operator btn-save').click(function(){
        Global.post($('#china-area-operator').attr('action'), $('#china-area-operator').serialize());
    });
});