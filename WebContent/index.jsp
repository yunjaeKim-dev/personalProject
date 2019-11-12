<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>HGM</title>	
<script src='https://code.jquery.com/jquery-3.4.1.min.js'></script>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet" type="text/css">
<script src="https://apis.google.com/js/api:client.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<link rel="stylesheet" href="css/layout.css">
<link rel="stylesheet" href="css/index.css">
<script src="js/layout.js"></script>
<script src="js/index.js"></script>
</head>
<body>
	<jsp:include page="common/header.jsp"/>
	<main>
		<div class="main">
	        <div class="main-top">
	            <div class="recommand-game">
	                <ul>
	                <c:forEach items="${gameList}" var="list" begin="1" end="4">
	                	<li><a href="gameView?gno=${list.gno}" style="background: url('${list.imgpath}') no-repeat; background-size: contain;"></a>
	                		<h2><a href="gameView?gno=${list.gno}">${list.gname}</a><a href="gameView?gno=${list.gno} }">
	                		<c:if test="${list.discount == 0}">
			                		<fmt:formatNumber type="number" pattern="0,000">${list.price}</fmt:formatNumber> 원
			                		</c:if>
			                		<c:if test="${list.discount != 0}">
			                		<span style="vertical-align: super;">
			                		<span style='text-decoration:line-through; font-size:.3em; '>
			                		<fmt:formatNumber type="number" pattern="0,000">${list.price}</fmt:formatNumber> 원
			                		</span>
			                		<span style="color:red; font-size:.5em;">
			                		${list.discount}%
			                		</span>
			                		</span>
			                		<fmt:formatNumber type="number" pattern="0,000">${list.price *(1- (list.discount/100))}</fmt:formatNumber>
			                		</c:if>
	                		</a></h2>
	                	</li>
	                </c:forEach>
	                </ul>
	            </div>
	        </div>
	        <div class="main-bottom">
	        	<c:forEach items="${gameList}" var="list">
			        <table class="game__main">
			        	<tr>
			        		<td><a href="gameView?gno=${list.gno}" style="background: url('${list.imgpath}') no-repeat; background-size: contain">game image</a></td>
			        	</tr>
			        	<tr>
			        		<td><h2><a href="gameView?gno=${list.gno}">${list.gname }</a></h2></td>
			        	</tr>
			        	<tr>
			        		<td>
			        		<h2>
			                	<a href="gameView?gno=${list.gno}">
			                		<c:if test="${list.discount == 0}">
			                		<fmt:formatNumber type="number" pattern="0,000">${list.price}</fmt:formatNumber> 원
			                		</c:if>
			                		<c:if test="${list.discount != 0}">
			                		<span style="vertical-align: super;">
			                		<span style='text-decoration:line-through; font-size:.3em; '>
			                		<fmt:formatNumber type="number" pattern="0,000">${list.price}</fmt:formatNumber> 원
			                		</span>
			                		<span style="color:red; font-size:.5em;">
			                		${list.discount}%
			                		</span>
			                		</span>
			                		<fmt:formatNumber type="number" pattern="0,000">${list.price *(1- (list.discount/100))}</fmt:formatNumber> 원
			                		</c:if>
			                	</a>
			                </h2>
			        		</td>
			        	</tr>
		                </table>
	        	</c:forEach>
	        </div>
	    </div>
	</main>
	<jsp:include page="common/footer.jsp"/>
</body>
</html>