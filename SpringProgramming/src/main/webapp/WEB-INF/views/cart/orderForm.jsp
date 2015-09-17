<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<style>
		body {
				color: white;
				text-align:center;
				text-decoration: none;
			}
			table {
				margin: auto;
				width: 500px;
				border-collapse: collapse;
				font-size: small;
			}
			table, th, td {
				border: 1px solid white;
				text-align: center;
			}
			th {
				background-color: rgb(89,94,113);
			}
			a{
				color: white;
				text-decoration: none;
			}
			#Payment{
				color:black;
			}
			#Payment>option{
				color:black;
			}
			 #buttonGroup {
            margin: 10px;
            text-align: center;
         }
         
         #buttonGroup a {
            display:inline-block;
            width: 70px;
            line-height: 30px;
            text-decoration: none;
            font-size: small;
            color: white;
            border: 1px solid darkgray;
            background-color: rgb(89,94,113);
            font-weight: bold;
         }
         
         #buttonGroup a:hover {
            color: black;
            background-color: lightgray;
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
		<h4>결제창</h4>
		<form id="order" name="order" method="post" action="order">
		<div id="orderForm">
		<table>
			<tr>
				<th style="width:300px">품명</th>
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
		<div id="buttonGroup">
			<a href="javascript:sendData()">결제</a>
			<a href="list">결제취소</a>
		</div>
	</body>
</html>