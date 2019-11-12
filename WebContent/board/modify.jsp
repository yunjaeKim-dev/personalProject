<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>게시글 작성</title>
    <script src='https://code.jquery.com/jquery-3.4.1.min.js'></script>
    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
    <script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet" type="text/css">
    <script src="https://apis.google.com/js/api:client.js"></script>
    <link rel="stylesheet" href="css/layout.css">
    <link rel="stylesheet" href="css/write-post.css">
    <script src="js/layout.js"></script>
    <script src="js/write-post.js"></script>
</head>
<body>
    <div class="container">
        <jsp:include page="../common/header.jsp"/>
        <main>
            <form class="adjust-post" method="post">
            	<input type="hidden" name="boardno" value="${board.boardno}" >
            	<input type="hidden" name="category" value="${param.category}" >
                <select name="category" id="subject">
                	<c:choose>	
						<c:when test="${param.category ==1 || param.category== 2 || param.category== 3 }">                
		                    <c:if test="${user.admin}">
			                    <option value="1" ${param.category == 1 ? 'selected': ''}>공지게시판</option>
			                    <option value="2" ${param.category == 2 ? 'selected': ''}>QnA게시판</option>
		                	</c:if>
		                    <option value="3" ${param.category == 3 ? "selected" : "" } >문의게시판</option>
						</c:when>
                    	<c:otherwise>
		                    <option value="4" ${param.category == 4 ? "selected" : "" } >자유게시판</option>
		                    <option value="5" ${param.category == 5 ? "selected" : "" } >질문게시판</option>
		                </c:otherwise>
                    </c:choose>
                </select>
                <div>
                    <input type="text" placeholder="글 제목" name="title" value="${board.title}">
                    <textarea name="content" id="adjust-post-text" cols="30" rows="10" placeholder="게시글 작성">${board.content}</textarea>
                </div>
                <c:if test="${param.category == 3}">
                	<label>비밀글<input type="checkbox" name="secret"></label>
                </c:if>
                <button >수정</button>
            </form>
        </main>
		<jsp:include page="../common/footer.jsp"/>
    </div>
</body>
</html>
