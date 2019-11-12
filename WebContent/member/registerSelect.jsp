<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>회원가입</title>
    <script src='https://code.jquery.com/jquery-3.4.1.min.js'></script>
    <script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet" type="text/css">
    <script src="https://apis.google.com/js/api:client.js"></script>
    <link rel="stylesheet" href="css/layout.css">
    <link rel="stylesheet" href="css/registerSelect.css">
    <script src="js/layout.js"></script>
</head>
<body>
    <div class="container">
        <c:import url="../common/header.jsp"></c:import>
        <main>
            <div>
            	<form method="post">
                	<button>일반 회원 가입</button>
                </form>
                <div>
                    <a id="kakao-login-btn2"></a>
                    <a href="http://developers.kakao.com/logout"></a>
                    <div id="gSignInWrapper">
                        <span class="label"></span>
                        <div id="customBtn2" class="customGPlusSignIn">
                            <span class="icon"></span>
                            <span class="buttonText">구글 계정으로 회원가입</span>
                        </div>
                    </div>
                    <div id="name"></div>
                    
                </div>
            </div>
        </main>
	<c:import url="../common/footer.jsp"></c:import>
    </div>
</body>
</html>
