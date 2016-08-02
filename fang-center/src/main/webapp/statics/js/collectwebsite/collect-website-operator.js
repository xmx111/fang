$(function() {
    /* 提交按钮事件 */
    $('#collect-website-operator .btn-save').click(function(){
        Global.post($('#collect-website-operator').attr('action'), $('#collect-website-operator').serialize());
    });
});