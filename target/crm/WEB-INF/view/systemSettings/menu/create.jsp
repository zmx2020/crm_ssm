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
					<i class="icon-reorder"></i> 创建菜单 <a href="javascript:;"
						class="pull-right" onclick="history.go(-1);"><i
						class="icon-reply"></i></a>
				</div>
				<div class="widget-content padded clearfix">
					<form id="addMenuFrom" class="form-horizontal"
						action="MenuServlet?method=addMenu" method="post">
						<!--  <input type="hidden" name="_csrf" value="Z3ItdHlYLnQFBXsfQCFtDDYcHSQ0YEE/OBhcERUIRywQJmM8Cx5UQw=="> -->

						<div class="form-group field-menu-parent_id required">
							<label class="control-label col-sm-2" for="menu-parent_id">父级</label>
							<div class="col-sm-8">
								<select id="menu-parent_id" class="form-control"
									name="menu-parent_id">
									<option value="0">顶级节点</option>
									<c:forEach items="${parentMenu}" var="menu" >
										<option value="${menu.menu_id}">|--${menu.menu_name}</option>
									</c:forEach>
								</select>
							</div>
							<div class="help-block help-block-error"></div>
						</div>

						<div class="form-group field-menu-name required">
							<label class="control-label col-sm-2" for="menu-name">名称</label>
							<div class="col-sm-8">
								<input type="text" id="menu-name" class="form-control"
									name="menu-name" maxlength="20" placeholder="名称">
							</div>
							<div class="help-block help-block-error"></div>
						</div>

						<div class="form-group field-menu-url required">
							<label class="control-label col-sm-2" for="menu-url">地址</label>
							<div class="col-sm-8">
								<input type="text" id="menu-url" class="form-control"
									name="menu-url" maxlength="50" placeholder="地址">
							</div>
							<div class="help-block help-block-error"></div>
						</div>

						<div class="form-group field-menu-icon">
							<label class="control-label col-sm-2" for="menu-icon">图标</label>
							<div class="col-sm-8">
								<input type="text" id="pictures" class="form-control"
									name="pictures" maxlength="25" placeholder="图标">
							</div>
							<div class="help-block help-block-error"></div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label"></label>
							<div class="col-lg-10">
								<button type="button" id="addMenuBtn" class="btn btn-success"
									onclick="addMetuCheck()">创建</button>
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
</body>

<script type="text/javascript">
	
	function addMetuCheck() {
		var $menu_parent_id=$("#menu-parent_id").val();
		var $menu_name=$("#menu-name").val();
		var $menu_url = $("#menu-url").val();
		var $pictures = $("#pictures").val();
		if ("" == $menu_name || undefined == $menu_name) {
			alert("名称不能为空");
			return;
		}
		if ("" == $menu_url || undefined == $menu_url) {
			alert("地址不能为空");
			return;
		}
		if ("" == $pictures || undefined == $pictures) {
			alert("图标不能为空");
			return;
		}
		var data = {};
		
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
					alert(data.msg);
					//layer.alert(data.msg, {icon: 2});
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
</html>
