$(function(){
    // 페이지 이동
    // 해당 글로 가기
    $("table tr > td:nth-child(2)").click(function(){
        location.href = "ann-post.html"
    })
    // 글 검색
    $(".search-bar__commu > form > button").click(function(){
        location.href = "announcement.html"
    })
    $("main > div > *:nth-child(1) > *").hover(function(){
        $(this).css("background","#0002")
    },function(){
        $(this).css("background","#f4f4f4")
    }).click(function(){
        location.href = "announcement.html"
    })
})
