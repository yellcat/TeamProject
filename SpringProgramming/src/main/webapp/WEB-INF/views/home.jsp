<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Home</title>
		<link rel="stylesheet" href="resources/css/form.css"/>
	</head>
	
	<body>
	<div id="pagewrapper">
		<div id="page">
			<div id="header">
				<h1>Spring Programming</h1>
			</div>
			
			<div id="content1">
				<div id="login">
					<a class=loginbutton href="member/joinForm" target="loginframe">회원가입</a>
					<a class=loginbutton href="member/loginForm" target="loginframe">로그인</a>
					<iframe name="loginframe" height="100%" width="100%"></iframe>
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
