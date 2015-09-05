<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Insert title here</title>
		<style>
			@import url(http://fonts.googleapis.com/css?family=Orbitron);
			
			*	{
			font:11px/2.8 orbitron; 
			color:#888;
			}
			form {
				margin: 60px 450px;
				padding: 10px 10px;
				display: inline-block;
			}
			
			legend {
				text-align: center;
			}
			#joinForm {
				color: white;
			}
			
			#buttonGroup {
				color: #black;
				text-align: center;
			}
		</style>
	</head>
	<body>
		<form method="post" action="join">
			<fieldset id="joinForm">
				<legend>Sign up</legend>
				<table>
					<tr>
						<td>ID</td>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="text" name="pw"></td>
					</tr>
					<tr>
						<td>Name</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>Mobile('-'제외)</td>
						<td><input type="tel" name="tel"></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><input type="text" name="address"></td>
					</tr>
				</table>
					<div id="buttonGroup">
						<input type="submit" value="Join">
						<input type="reset" value="Reset">
					</div>	
			</fieldset>
		</form>
	</body>
</html>