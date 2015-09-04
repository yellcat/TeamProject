<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form method="post" action="join">
			<div id=joinForm">
				<span>ID</span>
				<span><input type="text" name="id"></span><br/>
				<span>Password</span>
				<span><input type="text" name="pw"></span><br/>
				<span>Name</span>
				<span><input type="text" name="name"></span><br/>
				<span>Mobile</span>
				<span><input type="tel" name="tel"></span>
				<span>Address</span>
				<span><input type="text" name="address"></span><br/>	
			</div>
			<div id=buttonGroup>
				<input type="submit" value="글 올리기">
					<input type="reset" value="다시 작성">
			</div>
		</form>
	</body>
</html>