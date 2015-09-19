<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html >
<html>
	<head>
		<title> TEAM5  </title>
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
									$("#account").show();
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
						$.ajax({
							url:"member/logout",
							method:"POST",
							data:{"mid":""},
							success:function(data){
								console.log(data);
								var result = data.trim();
								if(result == "success"){
									$("#in").show();
									$("#out").hide();
									$("#account").hide();
									$("loginMid").html("xxx");
								}
							}
						});
					});
				});
		</script>
	<body>

		<!-- 배경이미지 -->
		<div class="bg"></div>	
		
		<!-- header -->
		<header>
			<h1>TEAM 5</h1>
		</header>
	

		<nav>
			<ul>
				<!-- menu -->
				<li>
					<a href="#">PRODUCT</a>
					<div>
						<h2>PRODUCT</h2>
						<ul>
							<li><a href="product/list" target="iframe">Product list</a></li>
							<li><a href="#">Coming soon...</a></li>
							<li><a href="#">Coming soon...</a></li>
						</ul>
					</div>
				</li>

				
				<!-- menu -->
				<li id="account" >
					<a href="#">ACCOUNT</a>
					<div>
						<h2>ACCOUNT</h2>
						<ul>
							<li><a href="cart/list" target="iframe">Cart</a></li>
							<li><a href="order/list" target="iframe">Order Record</a></li>
							<li><a href="#">Coming soon...</a></li>
						</ul>
					</div>
				</li>
			</ul>
		</nav>
		
		<!-- 이미지 시퀀스 프레임 -->
		<section>
			<div id="content">
				<iframe name="iframe" height="100%" width="100%"></iframe>
			</div>
		</section>
		
		
		<!-- footer -->
		<footer>
			
			<div id="loginForm">
				<div id="in">
					<table>
						<tr>
							<td>
								<a id="SignUp" href="member/joinForm" target="iframe">Sign up</a>
							</td>
						</tr>
						<tr>
							<td>  ID <input id="mid" type="text" name="mid"/>  PW <input id="mpass" type="password" name="mpass"/></td>
							<td><input id="login" type="button" value="login"/></td>  
						</tr>
					</table>
					
				</div>
				<div id="out" style="height: 100%">
					<table>
						<tr>
							<td style="text-align: center; vertical-align: middle;">
							<span id="loginMid">xxx</span>님 환영합니다 
							<input id="logout" type="button" value="logout" />
							</td>
						</tr>
					</table>
				</div>
			</div>
		</footer>	
	</body>
</html>

