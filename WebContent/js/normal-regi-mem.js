$(function(){
    $(".regi-mem-button").click(function(){
        if($("#email").val() == ""){
            alert("이메일을 입력하세요.")
            $("#email").focus();
            return false;
        }
        if(!patternMail.test($.trim($("#email").val()))){
            alert("이메일 형식을 지켜주세요.");
            $("#email").focus();
            return false;
        }

        if($("#pw").val() == ""){
            alert("비밀번호을 입력하세요.")
            $("#pw").focus();
            return false;
        }
        if(!patternPw.test($.trim($("#pw").val()))){
            alert("비밀번호 형식을 지켜주세요.");
            $("#pw").focus();
            return false;
        }
        if($("#pwCK").val() == ""){
            alert("비밀번호확인란을 입력하세요.")
            $("#pwCK").focus();
            return false;
        }
        if($("#pwCK").val() != $("#pw").val()){
            alert("비밀번호가 일치하지 않습니다.");
            $("#pwCK").focus();
            return false;
        }
        if($("#name1").val() == ""){
            alert("이름을 입력하세요.")
            $("#name1").focus();
            return false;
        }
        if(!patternName.test($.trim($("#name1").val()))){
            alert("이름 형식을 지켜주세요.");
            $("#name1").focus();
            return false;
        }
        if($("#nickname").val() == ""){
            alert("닉네임을 입력하세요.")
            $("#nickname").focus();
            return false;
        }
        if(!patternNickname.test($.trim($("#nickname").val()))){
            alert("닉네임 형식을 지켜주세요.(영어와 한글,숫자로 이루어진 3~10글자)");
            $("#nickname").focus();
            return false;
        }
        if($("#birth").val() == ""){
            alert("생년월일을 입력하세요.")
            $("#birth").focus();
            return false;
        }
        if($("#phone").val() == ""){
            alert("핸드폰번호를 입력하세요.")
            $("#phone").focus();
            return false;
        }
        if(!patternPhone.test($.trim($("#phone").val()))){
            alert("핸드폰번호 형식을 지켜주세요.하이픈-을 제외한 11자리 번호를 입력해주세요.");
            $("#phone").focus();
            return false;
        }
        
        $(".popup-regi-check").css("height",$(window).width() /2 - $(".layer-regi-check").width() / 2 + "px").fadeIn(100)
        $(".bg-regi-check").css({"width":"100%","height":"100%"})
        $(".layer-regi-check").css("top",$(".bg-regi-check").height() / 2 - $(".layer-regi-check").height() /2 + "px");
    })
    
    $(".layer-regi-check > button, .bg-regi-check").click(function(){
        location.href = "index.html"
    })
})