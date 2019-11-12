<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header>
	<div class="header-up">
		<div class="header-icon-logo">
			<a href="index" class="header-icon">icon</a> <a
				href="index" class="header-logo">HGM</a>
		</div>
		<c:choose>
			<c:when test="${empty user.email}">
				<div class="login-bar">
					<a href="#" id="login__main">로그인</a> <span>|</span> <a href="registerSelect">회원가입</a>
				</div>
			</c:when>
			<c:otherwise>
				<div class="after-login">
					<c:choose>
						<c:when test="${empty user.file}">
							<a href="register" class="user-info" style="background: url('images/man.png') no-repeat ;background-size: cover" ></a>
						</c:when>
						<c:otherwise>
							<a href="register" class="user-info"  style="background: url('upload/${file.filepath}/${file.originname}') no-repeat ;background-size: cover"></a>
						</c:otherwise>
					</c:choose>
					<h2>
						<a href="register" class="user-id user-info">${user.nickname}</a>
					</h2>
					<a href="register" class="user-info">회원 정보</a>
					<a href="gameListBasket" >장바구니</a>
					<a href="logout" class="logout">로그 아웃</a>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="login-popup">
		<div class="bg"></div>
		<div class="layer">
			<form id="layer-login">
				<label for="email-heaer">이메일<input type="email" id="email-header" name="email"></label> 
				<label for="pw-header">비밀번호<input type="password" id="pw-header" name="pwd"></label>
				<button type="submit" id="login__popup">로그인</button>
			</form>
			<div class="api-login">
				<a id="kakao-login-btn"></a> <a	href="http://developers.kakao.com/logout"></a>
				<div id="gSignInWrapper">
					<span class="label"></span>
					<div id="customBtn" class="customGPlusSignIn">
						<span class="icon"></span> <span class="buttonText">구글 계정으로 로그인</span>
					</div>
				</div>
				<div id="name"></div>
			<!-- 	<script>
					startApp();
				</script> -->
			</div>
			<h2>
				<a href="registerSelect">회원 가입</a>
			</h2>
			<h2>
				<a href="#" onclick="return alert('미구현입니다.')">아이디/비밀번호 찾기</a>
			</h2>
		</div>
	</div>
	<div class="header-down">
		<div class="menu-bar">
			<ul class="menu">
				<li class="blank"><span>blank</span>
				<li><a href="gameList?gamecategory=0">게임</a></li>
				<c:if test="${not empty user.email}">
					<li><a href="gameList?nickname=${user.nickname}">내 게임</a></li>
				</c:if>
				<li><a href="boardList?category=4">커뮤니티</a></li>
				<li class="support" id="support"><a>고객 지원</a>
					<ul>
						<li><a href="boardList?category=1">공지</a></li>
						<li><a href="boardList?category=2">QnA</a></li>
						<li><a href="boardList?category=3">문의</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<div class="search-bar">
			<form method="get" action="gameList">
				<button type="submit"></button>
				<input type="text" name="keyword">
			</form>
		</div>
	</div>
</header>