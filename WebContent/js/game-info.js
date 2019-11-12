$(function(){
    $(".left-box > button:nth-of-type(1)").click(function(){
        $(".popup-buy__game-info").css("left",$(window).width() /2 - 150 / 2 + "px").fadeIn(100)
        $(".bg-buy__game-info").css({width:"100%",height:"100%"})
        $(".layer-buy__game-info").css("top",$(".bg-buy__game-info").height() /2.5 + "px")
    })
    $(".bg-buy__game-info, .buy-button__game-info").click(function(){
        location.href = "buy.html"
    })

    $(".left-box > button:nth-of-type(2)").click(function(){
        $(".popup-tray__game-info").css("left",$(window).width() /2 - 150 / 2 + "px").fadeIn(100)
        $(".bg-tray__game-info").css({width:"100%",height:"100%"})
        $(".layer-tray__game-info").css("top",$(".bg-tray__game-info").height() /2.5 + "px")
    })
    $(".bg-tray__game-info, .tray-button__game-info").click(function(){
        $(".popup-tray__game-info").fadeOut(100)
    })

    $(".right-box  a").click(function(){
        location.href = "game-info-dlc.html"
    })

})