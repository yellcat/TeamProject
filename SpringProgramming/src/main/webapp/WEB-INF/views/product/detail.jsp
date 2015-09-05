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
			#amounttocart{
				float:right;
			}
			
		</style>
		<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript">
				function sendData(){
					//값의 유효성 검사
					//var modifyForm=document.querySelector("#modifyForm");
					var tocart=document.tocart;
					
					
					var amount=document.tocart.amount;
				
					
					var productno=document.tocart.productno;
					
					if(amount.value==""||productno.value==""){
						return;
					}
					//서버로 전송
					tocart.submit();
				}
				
				$(function() {
					
					$("#submit").click(function(){
						var amount=$("#amount").val();
						$.ajax({
							url:"howmuch.jsp",
							method:"POST",
							data:{
								"amount":amount
							},
							success:function(data){
								$("#resultamount").html(data);
							}
						});
					});
				});
			</script>
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
		<div id="amounttocart">
				한번에 10개까지 주문가능:
				<input type="number" name="amount" min="1" max="10" style="color:black; text-align:center;">
				<input type="button" id="submit" value="선택" style="color:black; text-align:center;">
				<div id="resultamount" style="width: 200px; height: 150px; border: 1px solid none"></div>
		</div><br/>
		<div id="buttonGroup">
<<<<<<< HEAD
			<form id="tocart" name="tocart" method="post" action="../cart/add">
				
				<input type="hidden" name="productno" value="${product.no}" />
			</form><hr/>
			<a href="javascript:sendData()">장바구니</a>
=======
			<a href="/cart/add?productNo=${product.no}">장바구니</a>
>>>>>>> branch 'master' of https://github.com/yellcat/TeamProject.git
			<a href="list?pageNo=${pageNo}">목록</a>
			
		</div>
	</body>
</html>