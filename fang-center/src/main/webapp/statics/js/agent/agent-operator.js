$(function() {
    /* 提交按钮事件 */
    $('#agent-operator btn-save').click(function(){
        Global.post($('#agent-operator').attr('action'), $('#agent-operator').serialize());
    });
});