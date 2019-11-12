$(function(){
	$("#category__commu").change(function(){
	location.href = "boardList?category=" + $("#category__commu").val();
	})
	
	$(".secret").each(function(){
        if($(this).text() =='true'){
            $(this).css({
                "background" : "url('./images/locked.png') no-repeat 50% 50%"
            })
        }
    })


})
