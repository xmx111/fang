$(function() {
    /* 提交按钮事件 */
    $('#grading-operator .btn-save').click(function(){
        Global.post($('#grading-operator').attr('action'), $('#grading-operator').serialize());
    });
});