<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Order Detail</title>
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
			
		
			#part1_2 img{
				width: 500px;
				height: 500px;
				display:block;
				margin:auto;
			}
			#part2{
				margin:20px;
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
	</head>
	
	<body>		
		<h4>주문 상세 내역</h4>
		<div id="part1">
			<div id="part1_1">
				<span class="title">주문번호: </span>
				<span class="content">${order.no}</span><br/>
				<span class="title">상품이름: </span>
				<span class="content">${product.name}</span><br/>
				<span class="title">주문수량: </span>
				<span class="content">${cart.amount}</span><br/>
				<span class="title">결제수단: </span>
				<span class="content">${order.payment}</span><br/>
				<hr/>
			</div>			
		</div>
		<div id="buttonGroup">			
			<a href="list">주문내역</a>
			
		</div>
	</body>
</html>