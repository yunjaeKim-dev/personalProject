<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>구매화면</title>
    <script src='https://code.jquery.com/jquery-3.4.1.min.js'></script>
    <link rel='stylesheet' href='https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css'>
    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
    <script src='https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js'></script>
    <script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet" type="text/css">
    <script src="https://apis.google.com/js/api:client.js"></script>
    <link rel="stylesheet" href="css/layout.css">
    <link rel="stylesheet" href="css/buy.css">
    <script src="js/layout.js"></script>
    <script>
    	$(function () {
    		function calcFileSize(){
    			var sum = 0;
    			$(".file-area :file").each(function(){
    				if($(this).get(0).files.length != 0){
    					sum += $(this).get(0).files[0].size;
    				}
    			});

    			$(".file-area div span").text(sum.convertByte());
    			return sum;
    		}	
    		
    		function getTotalPrice() {
				var sum = 0;
				$(".total").each(function () {
					sum = sum +  parseInt($(this).val());
				})
				$(".total-price").text(sum);
			}
    	
    	getTotalPrice();
    	
    	})
    </script>
</head>
<body>
    <div class="container">
       	<jsp:include page="../common/header.jsp"/>
        <main>
        <form method="post">
        <input type="hidden" value="${game.price * (1 - (game.discount / 100))}" class="total">
            <table>
                <thead>
                    <tr>
                        <th><input type="checkbox" id="checkbox-tray"></th>
                        <th>이미지</th>
                        <th>상품명</th>
                        <th>수량</th>
                        <th>가격</th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="basket-in">
                        <td><input type="checkbox" id="changedbox"></td>
                        <td style="background: url('${game.imgpath}') 50% 50% no-repeat; background-size:contain"><a href="gameView?gno=${game.gno}">이미지</a></td>
                        <td >${game.gname}</td>
                        <td>1</td>
                        <td>
                        <span>
                        <fmt:formatNumber type="number" pattern="0,000">
                        ${game.price * (1 - (game.discount / 100))}
                        </fmt:formatNumber></span> 원</td>
                        
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <td>합계</td>
                        <td colspan="4"><span class="total-price"><fmt:formatNumber type="number" pattern="0,000">0</fmt:formatNumber></span> 원</td>
                    </tr>
                    <tr>
                    	<td colspan="5">
			            	<button type="submit" class="buy-button" onclick="return confirm('구매합니까?')">구매 진행</button>
	            		</td>
	            	</tr>
                </tfoot>
            </table>
            </form>
        </main>
        <jsp:include page="../common/footer.jsp"/>
    </div>
</body>
</html>
