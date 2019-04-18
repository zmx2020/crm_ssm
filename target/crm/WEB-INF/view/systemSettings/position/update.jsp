<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
					<i class="icon-reorder"></i> 修改职位 <a href="javascript:;"
						class="pull-right" onclick="history.go(-1);"><i
						class="icon-reply"></i> </a>
				</div>
				<div class="widget-content padded clearfix">
					<form id="updatePositionFrom" class="form-horizontal"
						action="EmmPositionServlet?method=updatePosition" method="post">


						<input type="hidden" id="position_id" name="position_id"
							value='${position.position_id}'>
						<div class="form-group field-manage-name required">
							<label class="control-label col-sm-2" for="manage-name">名称</label>
							<div class="col-sm-8">
								<input type="text" id="position_name" class="form-control"
									name="position_name" value='${position.position_name}'>
							</div>
							<div class="help-block help-block-error"></div>
						</div>

						<div class="form-group field-manage-department_id required">
							<label class="control-label col-sm-2" for="manage-department_id">等级</label>
							<div class="col-sm-8">
								<select id="position_Level" class="form-control"
									name="position_Level">
									<option value="0">选择等级</option>
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
								<button type="button" id="mysubmit" onclick="positionCheck()"
									class="btn btn-success">修改</button>
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
		$(function() {

			//初始化下拉菜单选中项
			$("#position_Level").val("${position.position_level}");

			$("#positionLevel").val('${emmPosition.positionLevel}');

		});

		function positionCheck() {

			var $position_id = $("#position_id").val();
			var $position_name = $("#position_name").val();
			var $position_Level = $("#position_Level").val();
			if ("" == $position_name || undefined == $position_name) {
				alert("职位名称不能为空");
				return;
			}
			if (0 == $position_Level) {
				alert("必须选择职位等级！");
				return;
			}
			var data = {};
			data.position_id = $position_id;
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
								layer.alert(data.msg, {
									icon : 2
								});
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
