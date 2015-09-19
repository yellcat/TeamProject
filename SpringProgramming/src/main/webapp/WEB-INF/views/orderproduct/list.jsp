<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
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
			h5{
				color:Yellow;
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
			#pager a.pageNo.selected{
				color:rgb(129,134,153);
			}
			
			a:hover{
				color:rgb(99,104,123);
			}
			#name:hover{
				color:gray;
			}
			
		</style>
	</head>
	
	<body>
		<h4>[${membername}]님 주문 번호 : [${orderNo}] 번의 주문 상세 정보</h4>
		
		<table>
			<tr>
				<th style="width:80px">상품번호</th>
				<th>상품명</th>
				<th style="width:50px">수량</th>
				<th style="width:80px">가격</th>
				
			</tr>
			
			<c:forEach var="orderproduct" items="${list}">
				<tr>
					<td>${orderproduct.productno}</td>
					<td><a href="../product/detail?productNo=${orderproduct.productno}">${orderproduct.productname }</a></td>
					<td>${orderproduct.orderproductamount }</td>
					<td>${orderproduct.orderproductamount }*${orderproduct.productprice }</td>
					
				</tr>
			</c:forEach>
			
		</table>
		<h5>총 가격 : ${AllPrice }원</h5>
		<div id="pager">
	            <a href="list?pageNo=1">[처음]</a>
	            <c:if test="${groupNo>1 }">
	            <a href="list?pageNo=${startPageNo-pagesPerGroup}">[이전]</a><!-- 컨트롤러에서 만들어줘야할 변수 -->
	            </c:if>
	            
	            <c:forEach var="i" begin="${startPageNo}" end="${endPageNo}">
	               <a class='pageNo <c:if test="${pageNo==i}">selected</c:if>' href="list?pageNo=${i}">${i}</a>
	            </c:forEach>
	               
	            <c:if test="${groupNo<totalGroupNo}">
	            <a href="list?pageNo=${startPageNo+pagesPerGroup}">[다음]</a>
	            </c:if>
	            <a href="list?pageNo=${totalPageNo}">[맨끝]</a>
	         </div>
		
		
	</body>
</html>