$(function() {
    /* 提交按钮事件 */
    $('#grading-info-operator btn-save').click(function(){
        Global.post($('#grading-info-operator').attr('action'), $('#grading-info-operator').serialize());
    });
});