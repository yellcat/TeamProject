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
		<h4>장바구니</h4>
		
		<table>
			<tr>
				<th style="width:80px">카트번호</th>
				<th>상품명</th>
				<th style="width:80px">상품가격</th>
				<th style="width:80px">상품개수</th>
			</tr>
			
			<c:forEach var="product" items="${list}">
				<tr>
					<td>${cart.no}</td>
					<td><a href="/product/detail?productNo=${cart.productNo}">${cart.name}</a></td>
					<td>${cart.price}</td>
					<td>${cart.amount}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4">총가격: ${cart.amount*cart.price}</td>
			</tr>
		</table>
		<%-- <div id="pager">
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
	         </div> --%>
		
	</body>
</html>








