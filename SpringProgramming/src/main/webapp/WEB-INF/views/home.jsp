<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=Edge" />	
		<title> TEAM5  </title>
		<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.min.js"></script>
		<link rel="stylesheet" href="resources/css/form.css"/>
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
								}else if(result=="fail_mid"){
									alert("Non id");
								}else if(result=="fail_mpass"){
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
						$("#")
					})
				});
		</script>
	</head>
	<body>

	<!-- 배경이미지 -->
	<div class="bg"></div>	
	
	<!-- header -->
	<header>
		<h1>TEAM 5</h1>
		<ul>
			<li><a href="#"><i class="fa fa-facebook-square"></i></a><li>
			<li><a href="#"><i class="fa fa-twitter-square"></i></a><li>
			<li><a href="#"><i class="fa fa-vimeo-square"></i></a><li>
		</ul>
	</header>

	<nav>
		<ul>
			<!-- menu -->
			<li>
				<a href="#">PRODUCT</a>
				<div>
					<h2>PRODUCT</h2>
					<p><img src="img/thumb1.jpg" /></p>
					<ul>
						<li><a href="product/list" target="iframe">상품 목록</a></li>
						<li><a href="#">menu item</a></li>
						<li><a href="#">menu item</a></li>
						<li><a href="#">menu item</a></li>
					</ul>
				</div>
			</li>
			<!-- menu -->
			<li>
				<a href="#">STORE LOCATION</a>
				<div>
					<h2>STORE LOCATION</h2>
					<p><img src="img/thumb2.jpg" /></p>
					<ul>
						<li><a href="#">menu item</a></li>
						<li><a href="#">menu item</a></li>
						<li><a href="#">menu item</a></li>
						<li><a href="#">menu item</a></li>
					</ul>
				</div>
			</li>
			<!-- menu -->
			<li>
				<a href="#">ADVERTISEMENT</a>
				<div>
					<h2>ADVERTISEMENT</h2>
					<p><img src="img/thumb3.jpg" /></p>
					<ul>
						<li><a href="#">menu item</a></li>
						<li><a href="#">menu item</a></li>
						<li><a href="#">menu item</a></li>
						<li><a href="#">menu item</a></li>
					</ul>
				</div>
			</li>
			<!-- menu -->
			<li>
				<a href="#">ONLINE STORE</a>
				<div>
					<h2>ONLINE STORE</h2>
					<p><img src="img/thumb4.jpg" /></p>
					<ul>
						<li><a href="#">menu item</a></li>
						<li><a href="#">menu item</a></li>
						<li><a href="#">menu item</a></li>
						<li><a href="#">menu item</a></li>
					</ul>
				</div>
			</li>
			<!-- menu -->
			<li>
				<a href="#">CONTACT</a>
				<div>
					<h2>CONTACT</h2>
					<p><img src="img/thumb5.jpg" /></p>
					<ul>
						<li><a href="#">menu item</a></li>
						<li><a href="#">menu item</a></li>
						<li><a href="#">menu item</a></li>
						<li><a href="#">menu item</a></li>
					</ul>
				</div>
			</li>
			<!-- menu -->
			<li>
				<a href="#">ACCOUNT</a>
				<div>
					<h2>ACCOUNT</h2>
					<p><img src="img/thumb6.jpg" /></p>
					<ul>
						<li><a href="member/joinForm" target="iframe">회원가입(임시)</a></li>
						<li><a href="cart/list" target="iframe">장바구니</a></li>
						<li><a href="order/list" target="iframe">주문 내역</a></li>
						<li><a href="#">menu item</a></li>
					</ul>
				</div>
			</li>
		</ul>
	</nav>
	
	<!-- 이미지 시퀀스 프레임 -->
	<section>
		<img src="img/pic50.jpg" />	
	</section>
	
	<!-- footer -->
	<footer>
		<div id="loginForm">
			<div id="in">
				<table>
					<tr>
						<td>  ID <input id="mid" type="text" name="mid"/>  PW <input id="mpass" type="password" name="mpass"/></td>
					</tr>
				</table>
				<input id="login" type="button" value="login"/>  <input id="join" type="button" value="join"/>
			</div>
			<div id="out" style="height: 100%">
				<table>
					<tr>
						<td style="text-align: center; vertical-align: middle;">
						<span id="loginMid">xxx</span> 님. 로그인 됨<br /> 
						<input id="logout" type="button" value="logout" />
						</td>
					</tr>
				</table>
			</div>
			</div>
		</div>
	</footer>	
</body>
</html>

