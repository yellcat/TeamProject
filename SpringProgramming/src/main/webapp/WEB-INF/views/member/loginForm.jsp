<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style>
			#out{
				display: none;
				text-align:center;
				line-height:100px;
			}
		</style>
		<script src="/resources/js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#login").click(function(){
					var mid = $("#mid").val();
					var mpass = $("#mpass").val();
					$.ajax({
						url:"ajax05.jsp",
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
			});
		</script>
		
	</head>
	<body>
		<hr/>
		<div id="log" 
			style="width:200px; height:100px; border:1px solid black">
			<div id="in">
				<input id="mid" type="text" name="mid"/><br/>
				<input id="mpass" type="password" name="mpass"/><br/>
				<input id="login" type="button" value="login"/>
				<input id="join" type="button" value="join"/>
			</div>
			<div id="out" style="height:100%">
				<table><tr><td style="text-align:center; vertical-align:middle;">
				<span id="loginMid">xxx</span>님. 로그인 됨<br/>
				<input id="logout" type="button" value="logout"/>
				</td></tr></table>
			</div>
		</div>
		<hr/>
		주요내용...
	</body>
</html>