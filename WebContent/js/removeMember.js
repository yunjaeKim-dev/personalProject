$(function(){
    // 회원 탈퇴 클릭
    $(".destory-button").click(function(){
        if($("#destory-check").is(":checked") == true){
            $(".popup__destory").css("left",$(window).innerWidth() / 2 - 292 / 2 + "px").show();
            $(".layer__destory").css("bottom",$(window).height() / 2 - 142 / 2 + "px").show();
            $(".bg__destory").css({width:"100%",height:"100%"});
        }else{
            alert("탈퇴 동의를 확인해주세요.")
        }
    });
    $(".check__destory").click(function(){
        unauthed();
        location.href = "index.html"
    })
})
