<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<link rel="stylesheet" href="css/layout.css">
<link rel="stylesheet" href="css/gameview.css">
<script src="js/layout.js"></script>
<script type="text/javascript">
   	$(function () {
		var email ='${user.email}'
		
		$(".basket").click(function () {
			event.preventDefault();
			if(!confirm("장바구니에 추가하시겠습니까?")){
				return false;
			}
			$.ajax("addBasket",{
				type:"get",
				data : {email:email,gno:$(this).val()},
				success:function(d){
					if(d.trim()){
						alert('장바구니에 추가되었습니다.')
					} else{
						alert('담기 실패')
					}
				}
			}) 
		})
		$('.game-info-slider').bxSlider({
			speed : 500,
			controls: false,
			auto : true
		});
	})
</script>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
        <main>
            <div>
                <div class="left-box">
                    <h1>${game.gname}</h1>
                    <ul class="game-info-slider">
                        <li><img src="images/${game.gno}/1.jpg" alt=""></li>
                        <li><img src="images/${game.gno}/2.jpg" alt=""></li>
                        <li><img src="images/${game.gno}/3.jpg" alt=""></li>
                        <li><img src="images/${game.gno}/4.jpg" alt=""></li>
                    </ul>
                    <h2><c:if test="${game.discount == 0}">
	                		${game.price} 원
	                		</c:if>
	                		<c:if test="${game.discount != 0}">
	                		<span style="vertical-align: super;">
	                		<span style='text-decoration:line-through; font-size:.3em; '>
	                		${game.price} 원
	                		</span>
	                		<span style="color:red; font-size:.5em;">
	                		${game.discount}%
	                		</span>
	                		</span>
	                		${game.price *(1- (game.discount/100))} 원
	                		</c:if></h2>
                    <a href="gameBuy?gno=${game.gno}">바로구매</a>
                    <button class="basket" value="${game.gno}">장바구니 담기</button>
                </div>
                <div class="right-box">
                    <h2>게임 개요</h2>
                    <p>${game.goutline}</p>
                    <table>
                        <thead>
                            <tr>
                                <th colspan="2">게임 설명</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>장르 :</td>
                                <td>
                                	<c:choose>
                                		<c:when test="${game.category == '1'}">
                                			FPS
                                		</c:when>
                                		<c:when test="${game.category == '2'}">
                                			ACTION
                                		</c:when>
                                		<c:when test="${game.category == '3'}">
                                			RPG
                                		</c:when>
                                		<c:otherwise>
                                			STRATEGY
                                		</c:otherwise>
                                	</c:choose>
                                </td>
                            </tr>
                            <tr>
                                <td>개발자 :</td>
                                <td>${game.gexplain}</td>
                            </tr>
                            <tr>
                                <td>출시 일자:</td>
                                <td>${game.regdate}</td>
                            </tr>
                        </tbody>
                    </table>
                    <h2>구매자들의 평가</h2>
                    <p>평점 : <span>${game.gusercom}</span></p>
                    <c:choose>
                    	<c:when test="${game.dlc != 0}"><h2><a href="gameView?gno=${game.dlc}">DLC 보러 가기</a></h2></c:when>
                    	<c:when test="${game.ori != 0}"><h2><a href="gameView?gno=${game.ori}">본편 보러 가기</a></h2></c:when>
                    </c:choose>
                </div>
            </div>
        </main>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>