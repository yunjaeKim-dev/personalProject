$(function(){
    $("#checkbox-tray").change(function(){
        
        if($(this).is(":checked")){
            $("#changedbox").prop("checked",true)
            console.log("1");
        }else{
            $("#changedbox").prop("checked",false)
            console.log("2");
        }
    })
    $("main > button").click(function(){
        location.href = "buy.html"
    })
})