$(function(){
    $(".find-pw-button, .find-id-button").click(function(){
        $(".popup-check").css("left",$(window).width() / 2 - 500 / 2 + "px").fadeIn(100);
        $(".bg-check").css({width:"100%",height:"100%"})
    })
    $(".layer-check > button, .bg-check").click(function(){
        $(".popup-check").fadeOut(100)
    })
})