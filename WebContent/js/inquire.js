$(function(){
     // 비밀글 알람창
    function popup(){
        $(".popup__inquire").css("left",$(window).width() / 2 - 300 / 2 + "px").fadeIn(100);
        $(".bg__inquire").css({width:"100%",height:"100%"});
        $(".bg__inquire").click(function(){
            $(".popup__inquire").fadeOut(100)
        })
    }

//    // 페이지 이동
//    // 질문글 클릭시
//    $("table tr td:nth-child(4)").click(function(){
//       if($(this).parent().children().eq(2).text() == 1){
//           popup()
//       }else{
//           location.href = "post-inquire.html"
//       }
//    })
//    //문의하기 누름!
//    $(".write-inquire").click(function(){
//        location.href = 'write-inquire.html'
//    })

//
//    // 번호 호버
//    $("main > div > *:nth-child(2) > *").hover(function(){
//        $(this).css("background","#0002")
//    },function(){
//        $(this).css("background","#f4f4f4")
//    }).click(function(){
//        location.href = "community.html"
//    })

    // 비밀 아이콘 부여
    $("table tr").not($("table tr:nth-child(1)")).each(function(){
        if($(this).children().eq(2).text() == 1){
            $(this).children().eq(2).css({
                "background" : "url('./images/locked.png') no-repeat 50% 50%",
                "background-size" : "contain"
            })
        }
    })
    
   
    
})
