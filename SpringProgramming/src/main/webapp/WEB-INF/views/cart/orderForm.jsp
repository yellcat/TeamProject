<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<style>
		*{
			color:white;
		}
		option{
			color:black;
		}
	</style>
	<script type="text/javascript">
				function sendData(){
					
					var order=document.order;
					var select = document.getElementById("Payment");
					
					var Payment = select.options[select.selectedIndex].value;
					var AllPrice=document.order.AllPrice;
					
					if(Payment.value==""){
						alert("결제 방식을 선택해주세요");
						return;
					}
					order.submit();
				}
			</script>
	<body>
		<br/><br/><br/><br/><br/>
		<form id="order" name="order" method="post" action="order">
		<div id="orderForm">
		<table>
			<tr>
				<th>품명</th>
				<th style="width:100px">가격</th>
				<th style="width:100px">개수</th>
			</tr>
			
			<c:forEach var="cart" items="${list}">
				<tr>
					<td><a href="../product/detail?productNo=${cart.productNo}">${cart.name}</a></td>
					<td>${cart.price}</td>
					<td>${cart.amount}</td>
				</tr>
			</c:forEach>
			<tr>
				<td>총가격: ${AllPrice}<input type="hidden" name="AllPrice" value="${AllPrice}"/></td>
				<td>결제방식</td>
				<td>
					<select id="Payment"name="Payment">
						<option value="카드">카드</option>
						<option value="계좌이체">계좌이체</option>
						<option value="상품권">상품권</option>
						<option value="모바일 간편결제">모바일 간편결제</option>
					</select>
				</td>
			</tr>
		</table>
		</div>
		</form>
		
		<a href="javascript:sendData()">결제</a>
		<a href="list">결제취소</a>
		
	</body>
</html>