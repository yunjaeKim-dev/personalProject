<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>게임 목록</title>
    <script src='https://code.jquery.com/jquery-3.4.1.min.js'></script>
    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
    <script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet" type="text/css">
    <script src="https://apis.google.com/js/api:client.js"></script>
    <link rel="stylesheet" href="css/layout.css">
    <link rel="stylesheet" href="css/game-list.css">
    <script src="js/layout.js"></script>
    <script type="text/javascript">
    	$(function () {
			$("#game-sort").change(function () {
				location.href = "gameList?gamecategory=" + $("#game-sort").val();
			})
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
			
		})
    </script>
</head>
<body>
    <div class="container">
    	<jsp:include page="../common/header.jsp"/>
        <main>
        
            <c:if test="${param.nickname != user.nickname || empty user.email}">
            <div class="game-sort">
	            <form action="gameList" >
	                <select name="gamecategory" id="game-sort">
	                    <option value="0">전체</option>
	                    <option value="1" ${param.gamecategory == '1' ? "selected" : "" }>ACTION</option>
	                    <option value="2" ${param.gamecategory == '2' ? "selected" : "" }>FPS</option>
	                    <option value="3" ${param.gamecategory == '3' ? "selected" : "" }>RPG</option>
	                    <option value="4" ${param.gamecategory == '4' ? "selected" : "" }>STRATEGY</option>
	                </select>
	            </form>
            </div>
			</c:if>
            <div class="game__list">
            	                	<c:if test="${empty games}"><h2>구매하신 게임이 없습니다.</h2></c:if>
            	<c:forEach items="${games}" var="gl">
            	<c:if test='${gl.category == param.gamecategory || param.gamecategory == 0 || (empty param.gamecategory)}'>
	            	<table class="game-list">
	            		<tr><td style="background: url('${gl.imgpath}') 50% 50% no-repeat; background-size:contain">
	            			<a href="gameView?gno=${gl.gno}" >게임 이미지</a>
	            			</td></tr>
	            		<tr><td ><a href="gameView?gno=${gl.gno}">${gl.gname}</a></td></tr>
	            		<c:if test="${empty param.nickname}">
	            		<tr><td ><a href="gameView?gno=${gl.gno}">
           					<c:if test="${gl.discount == 0}">
	                		<fmt:formatNumber type="number" pattern="0,000">${gl.price}</fmt:formatNumber> 원
	                		</c:if>
	                		<c:if test="${gl.discount != 0}">
	                		<span style="vertical-align: super;">
	                		<span style='text-decoration:line-through; font-size:.3em; '>
	                		<fmt:formatNumber type="number" pattern="0,000">${gl.price}</fmt:formatNumber> 원
	                		</span>
	                		<span style="color:red; font-size:.5em;">
	                		${gl.discount}%
	                		</span>
	                		</span>
	                		<fmt:formatNumber type="number" pattern="0,000">${gl.price *(1- (gl.discount/100))}</fmt:formatNumber> 원
	                		</c:if></a></td>
	                	</tr>

	                	</c:if>
	            		<tr>
	            			<c:if test="${(not empty user.email ) &&  (param.nickname != user.nickname)}">
	            			<td>
	            				<a href="gameBuy?gno=${gl.gno}"><button class="buy-now" >바로 구매</button></a>
	            				<a href="gameBuy?gno=${gl.gno}"><button class="basket" value="${gl.gno}">장바구니 담기</button></a>
	            			</td>
	            			</c:if>
	            		</tr>
	            	</table>
	            </c:if>
            	</c:forEach>
            	<%-- <c:choose>
            	<c:when test="${empty games && not empty param.keyword}">
            		<h2>${param.keyword}의 검색 결과가 없습니다.</h2>
            	</c:when>
            	<c:when test="${(param.gamecategory != '1' && param.gamecategory != '2' && param.gamecategory != '3' && param.gamecategory != '4' && param.gamecategory != '0' )&& (param.nickname != user.nickname)}">
            		<h2>존재하지 않는 카테고리입니다.</h2>
            	</c:when>
            	</c:choose>
            	 --%>
           	</div>
        </main>
	<jsp:include page="../common/footer.jsp"/>
    </div>
</body>
</html>
