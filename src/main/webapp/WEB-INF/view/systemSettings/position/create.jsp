<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					<i class="icon-reorder"></i> 添加职位<a href="javascript:;"
						class="pull-right" onclick="history.go(-1);"><i
						class="icon-reply"></i> </a>
				</div>
				<div class="widget-content padded clearfix">
					<form id="addPositionFrom" class="form-horizontal"
						action="EmmPositionServlet?method=addPosition" method="post">

						<div class="form-group field-manage-name required">
							<label class="control-label col-sm-2" for="manage-name">名称</label>
							<div class="col-sm-8">
								<input type="text" id="position_name" class="form-control"
									name="position_name" placeholder="职位名称">
							</div>
							<div class="help-block help-block-error"></div>
						</div>

						<div class="form-group field-manage-department_id required">
							<label class="control-label col-sm-2" for="manage-department_id">等级</label>
							<div class="col-sm-8">
								<select id="position_Level" class="form-control"
									name="position_Level">
									<option value="">选择等级</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
								</select>
							</div>
							<div class="help-block help-block-error"></div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label"></label>
							<div class="col-lg-10">
								<button type="button" id="mysubmit" onclick="addPositionCheck()"
									class="btn btn-success">创建</button>
								<button type="button" class="btn btn-default"
									onClick="history.go(-1);">返回</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		function addPositionCheck() {
			var $position_name = $("#position_name").val();
			var $position_Level = $("#position_Level").val();
			if ("" == $position_name || undefined == $position_name) {
				alert("职位名称不能为空");
				return;
			}
			if ("" == $position_Level || undefined == $position_Level) {
				alert("请选择等级");
				return;
			}
			var data = {};

			data.position_name = $position_name;
			$
					.ajax({
						type : 'post',
						url : '${pageContext.request.contextPath}/EmmPositionServlet?method=positionNameCheck',
						data : data,
						dataType : "json",
						cache : false,
						sync : true,
						success : function(data) {
							if (false == data.status) {
								
								alert(data.msg);
								/* layer.alert(data.msg, {
									icon : 2
								}); */
							} else {
								$("form").submit();
							}
						},
						error : function() {
							alert("请求失败!");
						}
					});
		}
	</script>
</body>

</html>
