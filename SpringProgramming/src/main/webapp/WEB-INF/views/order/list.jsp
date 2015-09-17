<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Order List</title>
		<style type="text/css">
			body {
				color: white;
				text-decoration: none;
			}
			table {
				width: 100%;
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
			
			#pager{
				margin:10px;
				font-size:small;
				text-align:center;
			}
		
		</style>
	</head>
	
	<body>
		<h4>주문내역</h4>
		
		<table>
			<tr>
				<th style="width:100px">주문일시</th>
				<th>주문번호</th>
				<th style="width:90px">주문총액</th>
				<th style="width:90px">결제방법</th>
			</tr>
			
			<c:forEach var="order" items="${list}">
				<tr>
					<td>${order.date}</td>
					<td><a href="orderproduct/list?orderNo=${order.no}">${order.no}</a></td>
					<td>${order.price}</td>
					<td>${order.payment}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>