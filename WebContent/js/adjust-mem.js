$(function(){
    // 수정하기 버튼
    $(".adjust-mem").click(function(){
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
        location.href = "index.html";
    })
})