$(function() {
    /* 提交按钮事件 */
    $('#agent-third-account-operator .btn-save').click(function(){
        Global.post($('#agent-third-account-operator').attr('action'), $('#agent-third-account-operator').serialize());
    });
});