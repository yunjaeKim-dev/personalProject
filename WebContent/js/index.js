$(function(){
    //bxslider__main
    $(".recommand-game > ul").bxSlider({
        prevText : "",
        nextText : "",
        infiniteLoop : true,
        pause : 2000,
        speed : 2000
    }).startAuto();
    $(".bx-wrapper > *:nth-child(2) > *:first-child > *").hover(function(){
        $(this).css("background","rgb(0,0,0,0.3)");
    },function(){
        $(this).css("background","none");
    })
    // 할인 게임
    $(".discount-game > *:nth-child(1)").click(function(){
        location.href = "game-info.html"
    })
   $(".game__main > a").click(function(){
       location.href = 'game-info.html'
   })
   



})
