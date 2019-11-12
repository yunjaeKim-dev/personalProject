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
    		function getTotalPrice() {
				var sum = 0;
				$(".total").each(function () {
					sum = sum +  parseInt($(this).val());
				})
				$(".total-price").text(sum);
			}
    	
    	getTotalPrice();
    	
    	var email = '${user.email}'
    	
   		$(".delete").click(function () {
			event.preventDefault();
			if(!confirm("제거하시겠습니까?")){
				return false;
			}
			$.ajax("removeBasket",{
				type : "get",
				data : {basketno : $(this).val(),email:email},
				success:function(d){
					if(d.trim()){
						alert("장바구니 목록에서 제거되었습니다.")
						location.reload();
					}else{
						alert("장바구니 목록에서 제거하지 못했습니다.")
					}
				}
			})
		})

		$(".delete-all").click(function () {
			event.preventDefault();
			if(!confirm("전부 제거하시겠습니까?")){
				return false;
			}
			$.ajax("removeBasket",{
				type : "get",
				data : {email:email},
				success:function(d){
					if(d.trim()){
						alert("장바구니이 모두 제거되었습니다.")
						location.reload();
					}else{
						alert("장바구니 목록에서 제거하지 못했습니다.")
					}
				}
			})
		})
    	

		$(".delete-select").click(function () {
			event.preventDefault();
			var checked = []
			$(".checked:checked").each(function (){
				checked.push(parseInt($(this).val()));
			});
			if(checked.length < 1){
				alert('선택된 항목이 없습니다.')
				return false;
			}
			if(!confirm("선택하신 항목을 제거하시겠습니까?")){
				return false;
			}
			$.ajax("removeBasket",{
				type : "post",
				traditional : true,
				data : {email:email, basketnos:checked},
				success:function(d){
					if(d.trim()){
						alert("선택한 항목이 제거되었습니다.")
						location.reload();
					}else{
						alert("장바구니 목록에서 제거하지 못했습니다.")
					}
				}
			})
		})
		
		$(".buy-button").click(function () {
			event.preventDefault();
			var checked1 = []
			$(".checked:checked").each(function (){
				checked1.push(parseInt($(this).val()));
			});
			if(checked1.length < 1){
				alert('구매할 항목을 선택해주세요.')
				return false;
			};
			var checked = []
			$(".checked:checked").each(function (){
				checked.push(parseInt($(this).next().val()));
			});
			if(!confirm('구매하시겟습니까?')){
				return false;
			}
			$.ajax("buyBasket",{
				type : "post",
				traditional : true,
				data : {email:email, gnos:checked,basketnos:checked1},
				success:function(d){
					if(d.trim()){
						alert("구매 완료.")
						location.reload();
					}else{
						alert("구매 실패.")
					}
				}
			})
			
		})
		
		
		$("#check-all").change(function(){
	        if($(this).is(":checked")){
	            $(".checked").attr("checked",true)
	        }else{
	            $(".checked").attr("checked",false)
	        }
    	})
   	})
    </script>
</head>
<body>
    <div class="container">
       	<jsp:include page="../common/header.jsp"/>
        <main>
            <form method="post" id="basket-list">
            <c:if test="${not empty basket}">
            <table>
                <thead>
                    <tr>
                        <th><input type="checkbox" id="check-all"></th>
                        <th>이미지</th>
                        <th>상품명</th>
                        <th>삭제</th>
                        <th>가격</th>
                    </tr>

                </thead>
                <tbody>
				   
                <c:forEach items="${basket}" var="game">
                    <tr class="basket-in">
                        <td><input type="checkbox" class="checked" value="${game.basketno}"><input type="hidden" value="${game.gno}"></td>
                        <td style="background: url('${game.imgpath}') 50% 50% no-repeat; background-size:contain"><a href="gameView?gno=${game.gno}" class="game-img">이미지</a></td>
                        <td >${game.gname}</td>
                        <td><button class="delete" value="${game.basketno}">삭제</button></td>
                        <td>
                        <span>
                        <fmt:formatNumber type="number" pattern="0,000">
                        ${game.price * (1 - (game.discount / 100))}
                        </fmt:formatNumber></span> 원<input type="hidden" value="${game.price * (1 - (game.discount / 100))}" class="total"></td>
                    </tr>
                    </c:forEach>
                 
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="5">
                            <button class="delete-all">전체 삭제</button>
                            <button class="delete-select">선택 삭제</button>
                        </td>
                    </tr>
                    <tr>
                        <td>합계</td>
                        <td colspan="4"><span class="total-price"><fmt:formatNumber type="number" pattern="0,000">0</fmt:formatNumber></span> 원</td>
                    </tr>
                    <tr>
                    	<td colspan="5">
			            	<button type="submit" class="buy-button" >구매 진행</button>
	            		</td>
	            	</tr>
                </tfoot>
            </table>
			</c:if>
            <c:if test="${empty basket}">
         		<h3>장바구니가 비어있습니다.</h3>
       		</c:if>
       </form>   
        </main>
        <jsp:include page="../common/footer.jsp"/>
    </div>
</body>
</html>
