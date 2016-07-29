$(function() {
    Global.initGlobal();
    //改变div的高度
    $(".container-main .main").height($(window).height() - 80);
    $(".container-main .main #mainContent").height($(window).height() - 90);
    // //改变div的宽度
    // $(".container-main").width($(window).width());
});