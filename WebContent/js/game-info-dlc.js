$(function(){
    $(".left-box > button:nth-of-type(1)").click(function(){
        $(".popup-buy__game-info-dlc").css("left",$(window).width() /2 - 150 / 2 + "px").fadeIn(100)
        $(".bg-buy__game-info-dlc").css({width:"100%",height:"100%"})
        $(".layer-buy__game-info-dlc").css("top",$(".bg-buy__game-info-dlc").height() /2.5 + "px")
    })
    $(".bg-buy__game-info-dlc, .buy-button__game-info-dlc").click(function(){
        location.href = "buy.html"
    })

    $(".left-box > button:nth-of-type(2)").click(function(){
        $(".popup-tray__game-info-dlc").css("left",$(window).width() /2 - 150 / 2 + "px").fadeIn(100)
        $(".bg-tray__game-info-dlc").css({width:"100%",height:"100%"})
        $(".layer-tray__game-info-dlc").css("top",$(".bg-tray__game-info-dlc").height() /2.5 + "px")
    })
    $(".bg-tray__game-info-dlc, .tray-button__game-info-dlc").click(function(){
        $(".popup-tray__game-info-dlc").fadeOut(100)
    })

    $(".right-box  a").click(function(){
        location.href = "game-info.html"
    })

})