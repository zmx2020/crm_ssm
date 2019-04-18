<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="/common.jsp"></jsp:include>
<title>用户登陆</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/login.css" />
<style>
</style>
</head>
<body>
	<div class="form_login">
		<div class="form_logo">
			<h1>CRM</h1>
		</div>
		<form method="post" id="formlogin"
			action="${pageContext.request.contextPath }/LoginServlet/loginToCms">
			<div class="form-group">
				<i class="fa fa-user"></i> <input type="text" class="form-control"
					name="employeeId" id="employeeId" placeholder="输入工号">
			</div>
			<div class="form-group">
				<i class="fa fa-key"></i> <input type="password"
					class="form-control" name="password" id="password"
					placeholder="输入密码">
			</div>
			<!--  <div class="form-group" style="height:25px; line-height:25px; text-align:left;">
            <input type="checkbox" name="checkbox" id="checkbox">
            <span class="checkfont">记住我的帐号</span>
        </div> -->
			<div class="form-group">
				<button type="button" id="loginsubmit"
					class="btn btn-primary btn-block btn-login" onclick="mylogin()">登录</button>
			</div>
		</form>
		<div class="form_footer">
			<h4>@2017 江苏万和系统工程有限公司</h4>
		</div>
	</div>
</body>
<script type="text/javascript">
	function mylogin() {
		var employeeId = $("#employeeId").val();
		var password = $("#password").val();
		if ("" == employeeId || undefined == employeeId) {
			alert("工号不能为空");
			return;
		}
		if ("" == password || undefined == password) {
			alert("密码不能为空");
			return;
		}

		var data = {};
		data.employeeId = employeeId;
		data.password = password;
		$.ajax({
			type : 'post',
			url : '${pageContext.request.contextPath }/LoginServlet/loginCheck',
			data : data,
			cache : false,
			sync : true,
			success : function(msg) {
				var json = JSON.parse(msg);
				if (0 == json.status) {
					alert(json.msg);
				} else {
					//alert("1");
					$("#formlogin").submit();
				}
			},
			error : function() {
				alert("请求失败!");
			}
		});
	}
</script>
</html>
