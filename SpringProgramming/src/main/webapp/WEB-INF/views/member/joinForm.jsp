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
				<span><input type="tel" name="tel"></span><br/>
				<span>Address</span>
				<span><input type="text" name="address"></span><br/>	
			</div>
			<div id=buttonGroup>
				<input type="submit" value="Join">
				<input type="reset" value="Reset">
			</div>
		</form>
	</body>
</html>