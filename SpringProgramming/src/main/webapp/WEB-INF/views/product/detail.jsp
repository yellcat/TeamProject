<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Insert title here</title>
		<style>
		*{
			color:white;
		}
			h4{
				text-align: center;
				color: #
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
		<h4>[${product.name}] 상세 정보</h4>
		<div id="part1">
			<div id="part1_1">
				<span class="title">품번: </span>
				<span class="content">${product.no}</span><br/>
				<span class="title">품명: </span>
				<span class="content">${product.name}</span><br/>
				<span class="title">가격: </span>
				<span class="content">${product.price}</span><br/>
				<hr/>
			</div>
			<div id="part1_2">
				<img alt="No image" 
					src="${pageContext.request.contextPath}/resources/uploadfiles/${product.filesystemName}" />
			</div>
		</div>
		<div id="buttonGroup">
			<a href="cart?pageNo=${pageNo }">장바구니</a>
			<a href="list?pageNo=${pageNo }">목록</a>
			
		</div>
	</body>
</html>