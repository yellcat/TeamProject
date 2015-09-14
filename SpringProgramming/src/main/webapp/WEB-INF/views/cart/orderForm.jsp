<%@ page contentType="text/html; charset=UTF-8"%>
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
					var AllPrice=document.order.AllPrice;
					var payment=document.order.payment;
					
					if(payment.value==""){
						alret("결제 방식을 선택해주세요");
						return;
					}
					order.submit();
				}
			</script>
	<body>
		<br/><br/><br/><br/><br/>
		<form action="order">
		<div id="orderForm">
				<span class="title">총 가격</span>
				<span>${AllPrice}</span><br/>
				
				<span class="title">결제방식</span>
				<span>
					<select>
						<option value="카드">카드</option>
						<option value="계좌이체">계좌이체</option>
						<option value="상품권">상품권</option>
						<option value="모바일 간편결제">모바일 간편결제</option>
					</select>
				</span>
			</div><br/>
		</form>
		
		<a href="javascript:sendData()">결제</a>
		<a href="list">결제취소</a>
		
	</body>
</html>