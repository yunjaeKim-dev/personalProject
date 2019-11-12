<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<title>HGM</title>
<script src='https://code.jquery.com/jquery-3.4.1.min.js'></script>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet" type="text/css">
<script src="https://apis.google.com/js/api:client.js"></script>
<link rel="stylesheet" href="css/layout.css">
<link rel="stylesheet" href="css/member-info.css">
<script src="js/layout.js"></script>
<script>
	$(function () {
		$(".info-button button:nth-of-type(1)").click(function(){
	        console.log($("#pwd").val())
	        console.log($("#pwdCk").val())
			if($("#email").val() == ""){
	            alert("이메일을 입력하세요.");
	            $("#email").focus();
	            return false;
	        }
	        if(!patternMail.test($.trim($("#email").val()))){
	            alert("이메일 형식을 맞춰주세요.")
	            $("#email").focus();
	            return false;
	        }
	        if($("#pwd").val() == ""){
	            alert("비밀번호를 입력하세요.(영문과 숫자,특수문자6~32자리)");
	            $("#pwd").focus();
	            return false;
	        }
	        if(!patternPw.test($.trim($("#pwd").val()))){
	            alert("비밀번호 형식을 맞춰주세요.(영문과 숫자,특수문자6~32자리)")
	            return false;
	        }
	        if($("#pwd").val() != ($("#pwdCk").val())){
				alert("비밀번호가 일치하지 않습니다.")
				return false;
			}	        
	        if($("#reginame").val() == ""){
	            alert("이름을 입력하세요.")
	            $("#reginame").focus();
	            return false;
	        }
	        if(!patternName.test($.trim($("#reginame").val()))){
	            alert("이름 형식을 지켜주세요.");
	            $("#reginame").focus();
	            return false;
	        }
	        if($("#nickname").val() == ""){
	            alert("닉네임을 입력하세요.(영어와 한글,숫자로 이루어진 3~10글자)")
	            $("#nickname").focus();
	            return false;
	        }
	        if(!patternNickname.test($.trim($("#nickname").val()))){
	            alert("닉네임 형식을 지켜주세요.(영어와 한글,숫자로 이루어진 3~10글자)");
	            $("#nickname").focus();
	            return false;
	        }
	        if($("#birthdate").val() == ""){
	            alert("생년월일을 입력하세요.")
	            $("#birthdate").focus();
	            return false;
	        }
	        if($("#phone").val() == ""){
	            alert("핸드폰번호를 입력하세요.(하이픈-을 제외한 11자리)")
	            $("#phone").focus();
	            return false;
	        }
	        if(!patternPhone.test($.trim($("#phone").val()))){
	            alert("핸드폰번호 형식을 지켜주세요.(하이픈-을 제외한 11자리 번호)");
	            $("#phone").focus();
	            return false;
	        }
		})
	})

</script>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<main>
		<form method="post" enctype="multipart/form-data">
		<table>
	        <tr class="mail">
	            <td>이메일</td>
	            <td><input type="text" id="email" name="email" value="${user.email}" ${not empty user.email ? "readonly" : ""}></td>
	        </tr>
	        <tr class="pw">
	            <td>비밀번호</td>
	            <td><input type="password" id="pwd"name="pwd"></td>
	        </tr>
	        <tr class="pwCk">
	            <td>비밀번호 확인</td>
	            <td><input type="password" id="pwdCk" name="pwdCk"></td>
	        </tr>
	        <tr class="name">
	            <td>이름</td>
	            <td><input type="text" name="name" id="reginame" value="${user.name}" ${not empty user.name ? "readonly" : ""}></td>
	        </tr>
	        <tr class="nickname">
	            <td>닉네임</td>
	            <td><input type="text" name="nickname" id="nickname" value="${user.nickname}"></td>
	        </tr>
	        <tr class="birthdate">
	            <td>생년월일</td>
	            <td><input type="date" name="birthdate" id="birthdate" value="${user.birthdate}" ${not empty user.birthdate ? "readonly" : ""}></td>
	        </tr>
	        <tr class="phone">
	            <td>전화번호</td>
	            <td><input type="tel" name="phone" id="phone" value="${user.phone}"></td>
	        </tr>
	        <tr>
	        	<td>회원 프로필 사진</td>
	        	<td><input type="file" name="file" value="${user.file}"> </td>
	        </tr>
	        <tr class="info-button">
	            <td colspan="2">
	            	<c:choose>
	            		<c:when test="${empty user.email}">
	            			<button type="submit" formaction="register" onclick="return confirm('회원 가입 하시겠습니까?')">회원 가입</button>
	            		</c:when>
	            		<c:otherwise>
			            	<button type="submit" formaction="modify" formmethod="post" class="adjust-mem" onclick="return confirm('수정하시겠습니까?')">회원정보수정</button>
							<button type="submit" formaction="removeMember" formmethod="get" class="destory-mem">회원 탈퇴</button>
		            	</c:otherwise>
		            </c:choose>
	            </td>
	        </tr>
	    </table>
	    </form>
	</main>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>