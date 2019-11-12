<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>커뮤니티</title>
    <script src='https://code.jquery.com/jquery-3.4.1.min.js'></script>
    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
    <script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet" type="text/css">
    <script src="https://apis.google.com/js/api:client.js"></script>
    <link rel="stylesheet" href="css/layout.css">
    <link rel="stylesheet" href="css/list.css">
    <script src="js/layout.js"></script>
    <script src="js/list.js"></script> 
</head>
<body>
    <div class="container">
        <jsp:include page="../common/header.jsp"/>
        <main>
            <table id="board">
	            <tr>
		            <c:choose>
	            		<c:when test="${param.category == 1 }"><td colspan="4"></c:when>
	            		
	            		<c:otherwise><td colspan="6"></c:otherwise>
	            	</c:choose>
	            	
		            <form>
		                <select name="category" id="category__commu">
							<c:choose>	
								<c:when test="${param.category ==1 || param.category== 2 || param.category== 3 }">                
				                    <option value="1" ${param.category == 1 ? "selected" : "" } >공지게시판</option>
				                    <option value="2" ${param.category == 2 ? "selected" : "" } >QnA게시판</option>
				                    <option value="3" ${param.category == 3 ? "selected" : "" } >문의게시판</option>
								</c:when>
		                    	<c:otherwise>
				                    <option value="4" ${param.category == 4 ? "selected" : "" } >자유게시판</option>
				                    <option value="5" ${param.category == 5 ? "selected" : "" } >질문게시판</option>
				                </c:otherwise>
		                    </c:choose>
		                </select>
		            </form>
		            
		            </td>
	            </tr>
            	<tr>
		            <th>글번호</th>
		            <c:if test="${param.category ==3 }">
		            	<th class="secret"></th>
		            </c:if>
		            <th class="title noclick">제목</th>
		            <c:if test="${param.category != 1}">
			            <th>작성자</th>
	                </c:if>
		            <th>등록일</th>
		            <th>조회</th>
		            <c:if test="${param.category != 1 && param.category != 3}">
			            <th>추천수</th>
	                </c:if>
		        </tr>
	            	<c:forEach items="${list}" var="b">
		                <tr class="board">
		                    <td>${b.boardno}<input type="hidden" value="${b.writer}"></td>
		                    <c:if test="${param.category == 3 }" ><td class="secret">${b.secret}</td></c:if>
		                    <td class="title">
		                    <a href="boardView?boardno=${b.boardno}&category=${param.category}">
		                    	${b.title}
		                    	<input type="hidden" name="category" value="${param.category}"></a></td>
		                    <c:if test="${param.category != 1}">
		                    	<td>${b.writername}</td>
		                    </c:if>
		                    <td>${b.regdate}</td>
		                    <td>${b.hitcount}</td>
		                    <c:if test="${param.category!=1 && param.category != 3}">
		                    	<td>${b.recm}</td>
		                    </c:if>
		                </tr>
	            	</c:forEach>
            
		            <c:set var="cate">
		            	<c:if test="${not empty param.category}">
		            		&category=${param.category}
		            	</c:if>
		            </c:set>
		            <c:set var="key">
		            	<c:if test="${not empty param.keyword}">
		            		&keyword=${param.keyword}
		            	</c:if>
		            </c:set>
            	<tr>
	            	<c:choose>
	            		<c:when test="${param.category == 1 }"><td colspan="4"></c:when>
	            		
	            		<c:otherwise><td colspan="6"></c:otherwise>
	            	</c:choose>
	            	<c:if test="${not empty user.email && param.category != 1 && param.category != 2}">
	                	<a href="boardWrite?category=${param.category}" class="writepost">글쓰기</a>
	                </c:if>
	            	<c:if test="${user.admin && (param.category ==1 || param.category == 2)}">
	                	<a href="boardWrite?category=${param.category}" class="writepost">글쓰기</a>
	                </c:if>
	              	<c:if test="${pagination.prev}">
	              		<a href="boardList?page=${pagination.startPage - 1}${cate}${key}">&lt;</a>
	              	</c:if>  
	              	<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="i">
	              		<a href="boardList?page=${i}${cate}${key}">${i}</a>
					</c:forEach>
	              	
	              	<c:if test="${pagination.next}">
	              		<a href="boardList?page=${pagination.endPage + 1 }${cate}${key}">&gt;</a>
	              	</c:if>
					</td>
            	</tr>
            </table>
            <form class="search-bar" >
	             <input type="hidden" name="category" value="${param.category}">
                <input type="text" name="keyword">
                <button type="submit"></button>
            </form>
        </main>
	<jsp:include page="../common/footer.jsp"/>        
</div>
</body>
</html>
              