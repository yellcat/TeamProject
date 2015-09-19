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
			
			.tel{
				width: 45px;
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
		<script type="text/javascript">
			function func1() {
				console.log("fun1()");
				document.join.submit();
			}
		</script>
		<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript">
			$(function (){
				$("#idCheck").click(function(){
					var mid = $("#id").val();
					console.log(mid);
					$.ajax({
						url:"idCheck",
						method:"POST",
						data:{"mid":mid},
						success:function(data){
							console.log(data);
							var result = data.trim();
							if(result == "able"){
								alert("사용 가능한 ID입니다");
							}else if(result=="unable"){
								alert("사용 불가능한 ID입니다");
								$("#join")[0].reset();
							}
						}
					});
				});

				$("#btnSubmit").click(function(){
					console.log("submit");
					var id = $("#id").val();
					var pw = $("#pw").val();
					var pwCheck = $("#pwCheck").val();
					var name = $("#name").val();
					var mobile = $("tel1").val()+$("#tel2").val()+$("#tel3").val();
					var address = $("#adress").val();
		
					if (id == ""){
						alert("id를 입력해주세요");
						return;
					}
					if (pw == "") {
						alert("비밀번호를 입력해주세요");
						return;
					}
					if (name == "") {
						alert("이름을 입력해주세요");
						return;
					}
					if (pw != pwCheck) {
						alert("비밀번호가 일치하지 않습니다");
						return;
					}
					
					$("#join").submit();
					
				});
			});
		</script>
	</head>
	<body>
		<form id="join" name="join" method="post" action="join">
			<fieldset id="joinForm">
				<legend>Sign up</legend>
				<table>
					<tr>
						<td>ID</td>
						<td><input type="text" id="id" name="id"></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="button" id="idCheck" value="ID중복확인">
						</td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" id="pw" name="pw"></td>
					</tr>
					<tr>
						<td>PasswordCheck</td>
						<td><input type="password" id="pwCheck" name="pwCheck"></td>
					</tr>
					<tr>
						<td>Name</td>
						<td><input type="text" id="name" name="name"></td>
					</tr>
					<tr>
						<td>Mobile</td>
						<td>
							<select id="tel1" name="tel1">
								<option value="010">010</option>
								<option value="011">011</option>
							</select>
							-
							<input class="tel" id="tel2" type="text" name="tel2"/>
							-
							<input class="tel" id="tel3" type="text" name="tel3"/>
						</td>
					</tr>
					<tr>
						<td>Address</td>
						<td><input type="text" name="address"></td>
					</tr>
				</table>
					<div id="buttonGroup">
						<input id="btnSubmit" type="button" value="Join" onclick="func1()">
						<input type="reset" value="Reset">
					</div>	
			</fieldset>
		</form>
	</body>
</html>