<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style>
		*{
			color:white;
		}
			h4{
				text-align: center;
				
			}
			span{
				display: inline-block;
				margin:10px;
			}
			span.title{
				border:1px solid darkgray;
				background:rgb(89,94,113);
				width:70px;
				
				text-align: center;
			}
			#part1{
				
				margin:20px;
				/* width:550px;  */
			}
			
		
		</style>
	</head>
	
	<body>		
		<h4>주문 번호 : [${order.no}] 번 상세 정보</h4>
		<div id="part1">
			<div id="part1_1">
				<span class="title">상품번호: </span>
				<span class="content">${product.no}</span><br/>
				<span class="title">상품명: </span>
				<span class="content">${product.name}</span><br/>
				<span class="title">수량: </span>
				<span class="content">${cart.amount}</span><br/>
				<span class="title">가격: </span>
				<span class="content">${product.price}</span><br/>
				
				<c:forEach var="orderproduct" items="${list}">
				<tr>
					<td>${product.no}</td>
					<td><a href="product/detail?productNo=${product.no}">${product.name}</a></td>
					<td>${cart.amount}</td>
					<td>${product.price}</td>
				</tr>
			</c:forEach>
				<hr/>
			</div>

		</div>
		
	</body>
</html>