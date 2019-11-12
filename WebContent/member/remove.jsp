<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="css/removeMember.css">
<script src="js/layout.js"></script>
<script src="js/removeMember.js"></script>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<main>
		<section>
	        <p>탈퇴할 경우 재사용 및 복구가 불가능합니다.</p>
	        <p>탈퇴 후 회원 정보 및 개인형 서비스 이용 기록은 <br>모두 삭제됩니다.</p>
	        <p>탈퇴 후에도 게시판에 등록한 게시물은 남아 있습니다.</p>
	        <p>이 아이디를 사용해 다른 서비스를 이용 할 수 없습니다.</p>
	    </section>
	    <form method="post">
	        <label >
	        	<input type="checkbox" class="destroy-check" id="destory-check" name="check">
	            	<span>위 사항을 모두 확인하였으며, 이에 동의합니다.</span>
	        </label>
	        <p>탈퇴하시려면 비밀번호를 입력하세요.</p>
	        <label for="pw__destory"><input type="password" id="pw__destory" name="pwd"></label>
	        <button class="destory-button">탈퇴하기</button>
	    </form>
	</main>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>