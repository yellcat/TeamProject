<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Home</title>
		<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.min.js"></script>
		<link rel="stylesheet" href="resources/css/form.css"/>
	</head>
		<script type="text/javascript">
			$(function(){
				$("#login").click(function(){
					var mid = $("#mid").val();
					var mpass = $("#mpass").val();
					$.ajax({
						url:"member/login",
						method:"POST",
						data:{"mid":mid, "mpass":mpass},
						success:function(data){
							console.log(data);
							var result = data.trim();
							if(result == "success"){
								$("#in").hide();
								$("#out").show();
								$("#loginMid").html(mid);
							}else if(result=="wrong_mid"){
								alert("Non id");
							}else if(result=="wrong_mpass"){
								alert("Non password");
							}
						}
					});
				});
				$("#logout").click(function(){
					$("#in").show();
					$("#out").hide();
					$("loginMid").html("xxx");
				});
				$("#join").click(function(){
					
				})
			});
		</script>
	<body>
	<div id="pagewrapper">
		<div id="page">
			<div id="header">
				<h1>Spring Programming</h1>
			</div>
			
			<div id="content1">
				<div id="loginForm">
					<div id="log"
						style="width: 200px; height: 100px; border: 1px solid black">
						<div id="in">
							<input id="mid" type="text" name="mid" /><br />
							<input id="mpass" type="password" name="mpass" /><br />
							<input id="login" type="button" value="login" /> 
							<input id="join" type="button" value="join" />
						</div>
						<div id="out" style="height: 100%">
							<table>
								<tr>
									<td style="text-align: center; vertical-align: middle;"><span
										id="loginMid">xxx</span>님. 로그인 됨<br /> <input id="logout"
										type="button" value="logout" />
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
				<div id="frontImage">
					<img src="resources/image/header.jpg"/>
				</div>
			</div>
			
			<div id="content2">
				<div id="menu">
					<ul>
						<h4>주문 시스템</h4>
						<br/>
						<li><a href="member/joinForm" target="iframe">회원가입(임시)</a></li>
						<br/>
						<li><a href="product/list" target="iframe">상품 목록</a></li>
						<br/>
						<li><a href="cart/list" target="iframe">장바구니</a></li>
						<br/>
						<li><a href="order/list" target="iframe">주문 내역</a></li>
					</ul>
				</div>
				<div id="content">
					<iframe name="iframe" height="100%" width="100%"></iframe>
				</div>
			</div>
			
			<div id="footer">
				<h5>Created by Egg_Kim</h5>
			</div>
		</div>
		</div>
	</body>
	
</html>
