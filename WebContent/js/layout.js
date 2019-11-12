//// 로그인시 수행
//function authed(){
//    $(".login-bar").hide();
//    $(".menu>li:nth-child(3)").show();
//    $(".after-login").show();
//    sessionStorage.setItem("login","on");
//}
//// 로그아웃시 수행
//function unauthed(){
//    $(".login-bar").show();
//    $(".menu>li:nth-child(3)").hide();
//    $(".after-login").hide();
//    sessionStorage.setItem("login","off");
//
//}
//
//var patternMail = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
//var patternPw = /^[a-zA-Z0-9!@#$%^&*()\-_=+\\\/\[\]{};:\`",.<>\/?]{6,32}$/
//var patternName= /^[가-힣]{2,4}$/;
//var patternNickname = /^[가-힣a-z0-9_-]{3,10}$/;
//var patternPhone = /^[0-9]{8,11}$/;

function loginpopup(){
    $(".login-popup").css("left",$(window).width() / 2 - $(".layer").width() / 2 + "px").show();
    $(".bg").css({width:"100%",height:"100%"});
    $(".layer").css("top",$(".bg").height() / 2 - $(".layer").height() / 2 + "px");
}

var patternMail = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
var patternMail=/([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
var patternPw = /^[a-zA-Z0-9!@#$%^&*()\-_=+\\\/\[\]{};:\`",.<>\/?]{6,32}$/;
var patternName= /^[가-힣]{2,4}$/;
var patternNickname = /^[가-힣a-zA-Z0-9_-]{3,10}$/;
var patternPhone = /^[0-9]{8,11}$/;

$(function(){
	// 로그인 기능
	$("#login__popup").click(function(){
		event.preventDefault();
		if($("#email-header").val() == ""){
            alert("이메일을 입력하세요.");
            $("#email-header").focus();
            return false;
        }
        if(!patternMail.test($.trim($("#email-header").val()))){
            alert("이메일 형식을 맞춰주세요.")
            $("#email-header").focus();
            return false;
        }
        if($("#pw-header").val() == ""){
            alert("비밀번호를 입력하세요.");
            $("#pw-header").focus();
            return false;
        }
        if(!patternPw.test($.trim($("#pw-header").val()))){
            alert("비밀번호 형식을 맞춰주세요.(영문과 숫자,특수문자6~32자리)")
            return false;
        }
        
		var data = $("#layer-login").serialize();
		$.ajax("loginAjax",{
			type:"post",
			data : data,
			success: function(data){
				if(data.trim()){
					location.reload();
				} else{
					alert("로그인 실패")
				}
			}
		})
	})
	
    // 로그인 팝업 띄우기
    $("#login__main").click(loginpopup);
    $(".bg").click(function(){
        $(".login-popup").hide();
    })
    // 고객지원 메뉴 드롭다운!
    $(".support").hover(function(){
        $(this)
            .children("ul").stop()
            .slideDown(300);
    },function(){
    $(this)
        .children("ul").stop()
        .slideUp(100);
    })
   // 카카오 로그인
    Kakao.init('8df4091328900592955424686a25abbe');
    // 카카오 로그인 버튼을 생성합니다.
    Kakao.Auth.createLoginButton({
        container: '#kakao-login-btn',
        success: function(authObj) {
            alert(JSON.stringify(authObj));
        },
        fail: function(err) {
            alert(JSON.stringify(err));
        }
    });
})

//구글 로그인
var googleUser = {};
var startApp = function() {
    gapi.load('auth2', function(){
    // Retrieve the singleton for the GoogleAuth library and set up the client.
    auth2 = gapi.auth2.init({
        client_id: '175838096172-qk3gaicf1fa9ivecs4k964o1c683oc6d.apps.googleusercontent.com',
        cookiepolicy: 'single_host_origin',
        // Request scopes in addition to 'profile' and 'email'
        //scope: 'additional_scope'
    });
    attachSignin(document.getElementById('customBtn'));
    });
};

function attachSignin(element) {
    console.log(element.id);
    auth2.attachClickHandler(element, {},
        function(googleUser) {
        document.getElementById('name').innerText = "Signed in: " +
            googleUser.getBasicProfile().getName();
        }, function(error) {
        alert(JSON.stringify(error, undefined, 2));
        });
}