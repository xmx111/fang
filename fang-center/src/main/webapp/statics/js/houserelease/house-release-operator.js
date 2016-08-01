$(function() {
    /* 提交按钮事件 */
    $('#house-release-operator btn-save').click(function(){
        Global.post($('#house-release-operator').attr('action'), $('#house-release-operator').serialize());
    });
});