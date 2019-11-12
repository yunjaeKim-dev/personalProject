$(function(){
    // 범주 클릭시 테두리 바뀜!
    $(".qna-table > thead > tr > *").not($(".qna-table > thead > tr > *:nth-child(5)")).click(function(){
        $(this).css({
            "border-top" : "4px solid #118318",
            "border-bottom" : "none"
        })
        $(".qna-table > thead > tr > *").not(this).css({
            "border-right" : "1px solid #222",
            "border-top" : "1px solid #222",
            "border-bottom" : "1px solid #222"
        })
        $(".qna-table > thead > tr > *:nth-child(5)").css({
            border : "none"
        })
    })
    // 범주 클릭시 질문 변경!
    $(".qna-table > thead > tr > *").not($(".qna-table > thead > tr > *:nth-child(5)")).click(function(){
        var str = $(this).text();
        if(str == "전체"){
            $(".qna-table > tbody > tr:nth-child(even)").hide()
            $(".qna-table > tbody > tr:nth-child(odd)").show();
        }else{
            $(".qna-table > tbody > tr:nth-child(odd)").each(function(){
                if($(this).children().children("span:nth-child(1)").text().slice(2,4) == str){
                    $(".qna-table > tbody > tr:nth-child(even)").hide()
                    $(this).show()
                }else{
                    $(this).hide().next().hide()
                }
            })
        }
    })
    // 질문 클릭시 답변 나옴!
    $(".qna-table > tbody > tr:nth-child(odd)").click(function(){
        $(".qna-table > tbody > tr:nth-child(odd)").children().each(function(){
            $(".answer").hide();
        })
        $(this).next().fadeIn(100);
    })
})