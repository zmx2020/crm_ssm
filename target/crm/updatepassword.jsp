<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<jsp:include page="/common.jsp"></jsp:include>
    <title>初始密码需要修改后才能登陆</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css"/>


</head>
<body>
<div class="form_login">
    <div class="form_logo"><h2>修改密码</h2><h4>初始密码修改后才能登陆</h4></div>
    <form method="post" role="form" id="form_login" action="LoginServlet?method=updatePassword">
    
    	<div class="form-group">
            <i class="fa fa-user"></i>
            <input type="text" class="form-control" name="employeeId" id="employeeId"  placeholder="输入工号">
        </div>
   		<div class="form-group">
            <i class="fa fa-key"></i>
            <input type="password" class="form-control" name="oldpassword" id="oldpassword"  placeholder="输入旧密码">
        </div>
        <div class="form-group">
            <i class="fa fa-key"></i>
            <input type="password" class="form-control" name="newpassword" id="newpassword"  placeholder="输入新密码">
        </div>
        <div class="form-group">
            <i class="fa fa-key"></i>
            <input type="password" class="form-control" name="password" id="password" placeholder="确认新密码">
        </div>
      
        <div class="form-group">
            <button type="button" id="loginsubmit" class="btn btn-primary btn-block btn-login"  onclick="updatepassword()">修改</button>
        </div>
    </form>
    <div class="form_footer">
			<h4>@2017 江苏万和系统工程有限公司</h4>
	</div>
</div>
</body>
<script type="text/javascript">
	function updatepassword(){
		var employeeId = $("#employeeId").val();
		var oldpassword = $("#oldpassword").val();
		var newpassword = $("#newpassword").val();
		var password = $("#password").val();
		if ("" == employeeId || undefined == employeeId) {
			alert("工号不能为空");
			return;
		}
		if ("" == oldpassword || undefined == oldpassword) {
			alert("旧密码不能为空");
			return;
		}
		if ("" == newpassword || undefined == newpassword) {
			alert("新密码不能为空");
			return;
		}
		if ("" == password || undefined == password) {
			alert("确认密码不能为空");
			return;
		}
		if ("123456" == newpassword) {
			alert("新密码不能为123456");
			return;
		}
		if (oldpassword == newpassword) {
			alert("新旧密码不能相同");
			return;
		}
		if (newpassword!=password) {
			alert("新密码2次输入不一致");
			return;
		}
		var data = {};
		data.employeeId = employeeId;
		data.newpassword = newpassword;
		data.oldpassword = oldpassword;
		data.password = oldpassword;
		$.ajax({
			type : 'post',
			url : 'LoginServlet?method=loginCheck',
			data : data,
			cache : false,
			sync : true,
			success : function(msg) {
				var json = JSON.parse(msg);
				if (0 == json.status) {
					alert(json.msg);
				} else {
					//alert("1");
					$("#form_login").submit();
				}
			},
			error : function() {
				alert("请求失败!");
			}
		});
	}

</script>
</html>
