<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<jsp:include page="/common.jsp"></jsp:include>
</head>
j
<body class="navbar-top">
	<div class="modal-shiftfix">
		<jsp:include page="/menu.jsp"></jsp:include>
		<div class="container-fluid main-content">
			<div class="widget-container fluid-height clearfix mwi1200">
				<div class="heading clearfix">
					<i class="icon-reorder"></i> 修改员工信息 <a href="javascript:;"
						class="pull-right" onclick="history.go(-1);"><i
						class="icon-reply"></i> </a>
				</div>
				<div class="widget-content padded clearfix">
					<form id="updateEmployeeFrom" class="form-horizontal"
						action="EmployeeServlet?method=updateEmployee" method="post">
						<!--   <input type="hidden" name="_csrf" value="eFlReDNyY0IaLgcTCgsgOik3YSh.SgwJJzMgHV8iChoPDR8wQTQZdQ=="> -->

						<div class="form-group">
							<label class="control-label col-md-2">工号</label>
							<div class="col-md-8">
								<input type="text" class="form-control" id="employee_id"
									name="employee_id" value="${employeeDto.employee_id}"
									readonly="readonly">
							</div>
						</div>

						<div class="form-group field-manage-name required">
							<label class="control-label col-sm-2" for="manage-name">姓名</label>
							<div class="col-sm-8">
								<input type="text" id="manage-name" class="form-control"
									name="manage-name" value="${employeeDto.employee_name}">
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

										<c:choose>
											<c:when
												test="${department.department_id==employeeDto.department_id}">
												<option value="${department.department_id}" selected="true">|--${department.department_name}</option>
											</c:when>
											<c:otherwise>
												<option value="${department.department_id}">|--${department.department_name}</option>
											</c:otherwise>
										</c:choose>

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

										<c:choose>
											<c:when
												test="${position.position_id==employeeDto.position_id}">
												<option value="${position.position_id}" selected="true">|--${position.position_name}</option>
											</c:when>
											<c:otherwise>
												<option value="${position.position_id}">|--${position.position_name}</option>
											</c:otherwise>
										</c:choose>

									</c:forEach>

								</select>
							</div>
							<div class="help-block help-block-error"></div>
						</div>
						<div class="form-group field-manage-mobile required">
							<label class="control-label col-sm-2" for="manage-mobile">手机</label>

							<div class="col-sm-8">
								<input type="text" id="manage-mobile" class="form-control"
									name="manage-mobile" value="${employeeDto.phone}">
							</div>
							<div class="help-block help-block-error"></div>
						</div>
						<div class="form-group field-manage-email">
							<label class="control-label col-sm-2" for="manage-email">电子邮箱</label>
							<div class="col-sm-8">
								<input type="text" id="manage-email" class="form-control"
									name="manage-email" value="${employeeDto.email}">
							</div>
							<div class="help-block help-block-error"></div>
						</div>

						<div class="form-group field-manage-parentemployeeId">
							<label class="control-label col-sm-2" for="manage-address">上级员工工号</label>
							<div class="col-sm-8">
								<input type="text" id="parent_employee_id" class="form-control"
									name="parent_employee_id"
									value="${employeeDto.parent_employee_id}">
							</div>
							<div class="help-block help-block-error"></div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label"></label>

							<div class="col-lg-10">
								<button id="mysubmit" type="button" class="btn btn-success"
									onclick="commitCheck()">修改</button>
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
		function validatePhone(phone) {
			var Reg = /^[1][3,4,5,7,8][0-9]{9}$/;
			return Reg.test(phone);
		}
		function validateMail(mail) {
			var Reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
			return Reg.test(mail);
		}

		function commitCheck() {
			var $employee_id = $("#employee_id").val();
			var $manage_name = $("#manage-name").val();
			var $manage_department_id = $("#manage-department_id").val();
			var $manage_position_id = $("#manage-position_id").val();
			var $manage_mobile = $("#manage-mobile").val();
			var $manage_email = $("#manage-email").val();
			var $parent_employee_id = $("#parent_employee_id").val();
			if ("" == $employee_id || undefined == $employee_id) {
				alert("员工编号不能为空");
				return;
			}
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

			$("#updateEmployeeFrom").submit();
		}
	</script>
</body>

</html>
