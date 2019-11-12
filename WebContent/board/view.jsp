<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>게시글</title>
    <script src='https://code.jquery.com/jquery-3.4.1.min.js'></script>
    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
    <script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet" type="text/css">
    <script src="https://apis.google.com/js/api:client.js"></script>
    <link rel="stylesheet" href="css/layout.css">
    <link rel="stylesheet" href="css/view.css">
    <script src="js/layout.js"></script>
    <script src="js/view.js"></script>
    <script>
    $(function(){
    	$(".reply > div > a").click(function(){
    		
    	})
    })
    
    </script>
</head>
<body>
    <div class="container">
        <jsp:include page="../common/header.jsp"/>
        <main>
            <div>
                <button>< 이전글</button>
                <button>다음글 ></button>
                <c:if test="${board.writer == user.email || user.admin }">
                	<a href="boardRemove?boardno=${board.boardno}" onclick="return confirm('삭제할꺼야?????')">삭제</a>
                </c:if>
                <c:if test="${board.writer == user.email || user.admin }">
                	<a href="boardModify?boardno=${board.boardno }">수정</a>
                	
                </c:if>
                <a href="boardList?category=${param.category}">목록</a>
            </div>
            <div>
                <div>
                	<c:if test="${param.category == 1}"><h6>공지</h6></c:if>
                	<c:if test="${param.category == 2}"><h6>QnA</h6></c:if>
                	<c:if test="${param.category == 3}"><h6>문의 게시판</h6></c:if>
                	<c:if test="${param.category == 4}"><h6>자유 게시판</h6></c:if>
                	<c:if test="${param.category == 5}"><h6>질문 게시판</h6></c:if>
					<h2>조회수 : ${board.hitcount }</h2>
                    <c:choose>
                    	<c:when test="${empty board.moddate}">
                    		<h6>${board.regdate}</h6>
                    	</c:when>
                    	<c:otherwise>
                    		<h6>${board.moddate}</h6>
                    	</c:otherwise>
                    </c:choose>
                    
                    <h1>${board.title}</h1>
                    <h3>${board.writername}</h3>
                </div>
                <div>
                    <div><p>${board.content}</p>
                    </div>
                    <c:if test="${param.category == 4 || param.category ==5}">
	                    <h6 class="bad-up">비추천 : ${board.recm}</h6>
	                    <h6 class="good-up">추천 : ${board.notrecm}</h6>
                    </c:if>
                </div>
                <div class="reply">
	                <c:forEach items="${reply}" var="r">
	                	<c:choose>
	                		<c:when test="${r.removal}">
	                			<div class='delete-reply'><p>삭제된 댓글입니다.</p></div>
	                		</c:when> 
	                		<c:otherwise>
			                	<div>
			                		<h4>${r.writername}</h4>
			                		<h4>${r.regdate}</h4>
			                		<c:if test="${not empty user.email}">
			                			<h4 class="report-reply"><a href="#">신고</a></h4>
			                		</c:if>
			                		<c:if test="${user.email == r.writer}">
			                			<a href="replyRemove?replyno=${r.replyno}&boardno=${board.boardno}" class="remove-reply" onclick="return confirm('삭제하시겟습니까???')">삭제</a>
			                		</c:if>
			                		<%-- <c:if test="${not empty user.email}">
			                			<h4 class="re-reply-write"><a>답글</a></h4>
			                		</c:if> --%>
			                		<p>${r.content}</p>
			                	</div>
	                		</c:otherwise>
	                	</c:choose>
	                </c:forEach>
                </div>
                <c:if test="${not empty user.email}">
	                <div class="write-reply" >
	                    <form action="replyWrite">
	                    	<input type="hidden" name="writer" value="${user.email}">
	                    	<input type="hidden" name="boardno" value="${board.boardno}">
	                        <textarea name="content" id="write-reply" cols="50" rows="3" placeholder="명예훼손, 개인정보 유출, 분쟁 유발, 허위사실 유포 등의 글은 이용약관에 의해 제재는 물론 법률에 의해 처벌받을 수 있습니다. 건전한 커뮤니티를 위해 자제를 당부 드립니다."></textarea>
	                        <button>댓글 작성</button>
	                    </form>
	                </div>
                </c:if>
            </div>
        </main>
	<jsp:include page="../common/footer.jsp"/>        
    </div>
</body>
</html>
