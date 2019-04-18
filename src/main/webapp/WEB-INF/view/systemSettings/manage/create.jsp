<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<jsp:include page="/common.jsp"></jsp:include>
</head>

<body class="navbar-top">
	<div class="modal-shiftfix">
		<jsp:include page="/menu.jsp"></jsp:include>
		<div class="container-fluid main-content">
			<div class="widget-container fluid-height clearfix mwi1200">
				<div class="heading clearfix">
					<i class="icon-reorder"></i> 添加员工 <a href="javascript:;"
						class="pull-right" onclick="history.go(-1);"><i
						class="icon-reply"></i> </a>
				</div>
				<div class="widget-content padded clearfix">
					<form id="addEmployeeForm" class="form-horizontal"
						action="EmployeeServlet?method=addEmployee" method="post">

						<div class="form-group">
							<label class="control-label col-md-2">工号</label>
							<div class="col-md-8">
								<input type="text" class="form-control" name="employeeId"
									id="employeeId" value="工号自动生成无需手动填写" readonly="readonly"
									disabled="disabled">
							</div>
						</div>

						<div class="form-group field-manage-name required">
							<label class="control-label col-sm-2" for="manage-name">姓名</label>
							<div class="col-sm-8">
								<input type="text" id="manage-name" class="form-control"
									name="manage-name" placeholder="姓名">
							</div>
							<div class="help-block help-block-error"></div>
						</div>

						<div class="form-group field-manage-password required">
							<label class="control-label col-sm-2" for="manage-password">密码</label>
							<div class="col-sm-8">
								<input type="input" id="manage-password" class="form-control"
									name="manage-password" placeholder="123456(初始化密码，修改后才能登陆)"
									readonly="readonly">
							</div>
							<div class="help-block help-block-error"></div>
						</div>

						<div class="form-group field-manage-department_id required">
							<label class="control-label col-sm-2" for="manage-department_id">部门</label>
							<div class="col-sm-8">
								<select id="manage-department_id" class="form-control"
									name="manage-department_id">
									<option value="0">选择部门</option>
									<c:forEach items="${departments}" var="department">
										<option value="${department.department_id}">|--${department.department_name}</option>
									</c:forEach>
								</select>
							</div>
							<div class="help-block help-block-error"></div>
						</div>

						<div class="form-group field-manage-position_id required">
							<label class="control-label col-sm-2" for="manage-position_id">职位</label>
							<div class="col-sm-8">
								<select id="manage-position_id" class="form-control"
									name="manage-position_id">
									<option value="0">选择职位</option>
									<c:forEach items="${positions}" var="position">
										<option value="${position.position_id}">|--${position.position_name}</option>
									</c:forEach>
								</select>
							</div>
							<div class="help-block help-block-error"></div>
						</div>

						<div class="form-group field-manage-mobile required">
							<label class="control-label col-sm-2" for="manage-mobile">手机</label>
							<div class="col-sm-8">
								<input type="text" id="manage-mobile" class="form-control"
									name="manage-mobile" placeholder="手机">
							</div>
							<div class="help-block help-block-error"></div>
						</div>

						<div class="form-group field-manage-email">
							<label class="control-label col-sm-2" for="manage-email">电子邮箱</label>
							<div class="col-sm-8">
								<input type="text" id="manage-email" class="form-control"
									name="manage-email" placeholder="电子邮箱">
							</div>
							<div class="help-block help-block-error"></div>
						</div>

						<div class="form-group field-manage-parentemployeeId">
							<label class="control-label col-sm-2" for="manage-address">上级员工工号</label>
							<div class="col-sm-8">
								<input type="text" id="parent_employee_id" class="form-control"
									name="parent_employee_id" placeholder="上级员工工号">
							</div>
							<div class="help-block help-block-error"></div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label"></label>
							<div class="col-lg-10">
								<button id="mysubmit" type="button" class="btn btn-success"
									onclick="commitCheck()">添加</button>
								<button type="button" class="btn btn-default"
									onClick="history.go(-1);">返回</button>
								<input type="hidden" name="reback">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		//验证查询的日期格式是否正确
		function validateQueryDate(startDate, endDate) {
			var flag = false; //设置标记
			var dateReg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/; //设置日期格式正则表达式
			var dataS = new Date(startDate).getTime();
			var dataE = new Date(endDate).getTime();
			if (startDate == "" || endDate == "") { //如果查询起始日期没有选择  给予提示
				queryCondition = "";
				layer.msg("请选择查询起始日期");
			} else if (dateReg.test(startDate) == false
					|| dateReg.test(endDate) == false) {//验证日期格式是否正确
				layer.msg("输入的日期格式不正确");
			} else if (dataE < dataS) { //结束日期必须小于开始日期
				layer.msg("结束日期必须大于开始日期");
			} else {
				flag = true;
			}
			return flag;
		}

		function validatePhone(phone) {			
			var Reg = /^[1][3,4,5,7,8][0-9]{9}$/; 
			return Reg.test(phone);
		}
		function validateMail(mail) {			
			var Reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
			return Reg.test(mail);
		}
		
		function commitCheck() {

			var $manage_name = $("#manage-name").val();
			var $manage_department_id = $("#manage-department_id").val();
			var $manage_position_id = $("#manage-position_id").val();
			var $manage_mobile = $("#manage-mobile").val();
			var $manage_email = $("#manage-email").val();
			var $parent_employee_id = $("#parent_employee_id").val();
			if ("" == $manage_name || undefined == $manage_name) {
				alert("员工姓名不能为空");
				return;
			}
			if ("" == $manage_mobile || undefined == $manage_mobile) {
				alert("电话不能为空");
				return;
			}
			
			if (!validatePhone($manage_mobile)) {
				alert("手机号码格式不正确");
				return;
			}
			if ("" == $manage_email || undefined == $manage_email) {
				alert("邮箱不能为空");
				return;
			}
			if (!validateMail($manage_email)) {
				alert("邮箱格式不正确");
				return;
			}
			if ("" == $parent_employee_id || undefined == $parent_employee_id) {
				alert("上级员工号不能为空");
				return;
			}
			
			$("#addEmployeeForm").submit();
			/* var data = {};
			
			data.menu_name = $menu_name;
			data.menu_url = $menu_url;
			
			$.ajax({
				type : 'post',
				url : '${pageContext.request.contextPath}/MenuServlet?method=CheckMenuNameAndURL',
				data : data,
				dataType:"json",
				cache : false,
				sync : true,
				success : function(data) {
					if (false == data.status) {
						layer.alert(data.msg, {icon: 2});
					} else {
						$("form").submit();
					}
				},
				error : function() {
					alert("请求失败!");
				}
			}); */
		}
	</script>
</body>

</html>
