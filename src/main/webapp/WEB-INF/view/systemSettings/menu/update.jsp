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
					<form id="updateMenuFrom" class="form-horizontal"
						action="MenuServlet?method=updateMenu" method="post">
						<input type="hidden" id="menu-id" name="menu-id"
							value="${menuDto.menu_id}">

						<div class="form-group field-menu-parent_id required">
							<label class="control-label col-sm-2" for="menu-parent_id">父级</label>
							<div class="col-sm-8">
								<select id="menu-parent_id" class="form-control"
									name="menu-parent_id">
									<option value="0">顶级节点</option>
									<c:forEach items="${parentMenu}" var="menu">

										<c:choose>
											<c:when test="${menu.menu_id==menuDto.parent_menu_id}">
												<option value="${menu.menu_id}" selected="true">|--${menu.menu_name}</option>
											</c:when>
											<c:otherwise>
												<option value="${menu.menu_id}">|--${menu.menu_name}</option>
											</c:otherwise>
										</c:choose>

									</c:forEach>
								</select>
							</div>
							<div class="help-block help-block-error"></div>
						</div>

						<div class="form-group field-menu-name required">
							<label class="control-label col-sm-2" for="menu-name">名称</label>

							<div class="col-sm-8">
								<input type="text" id="menu-name" class="form-control"
									name="menu-name" maxlength="20" value="${menuDto.menu_name}">
							</div>
							<div class="help-block help-block-error"></div>
						</div>

						<div class="form-group field-menu-url required">
							<label class="control-label col-sm-2" for="menu-url">地址</label>
							<div class="col-sm-8">
								<input type="text" id="menu-url" class="form-control"
									name="menu-url" maxlength="50" value="${menuDto.menu_url}">
							</div>
							<div class="help-block help-block-error"></div>
						</div>

						<div class="form-group field-menu-icon">
							<label class="control-label col-sm-2" for="menu-icon">图标</label>
							<div class="col-sm-8">
								<input type="text" id="pictures" class="form-control"
									name="pictures" maxlength="25" value="${menuDto.pictures}">
							</div>
							<div class="help-block help-block-error"></div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label"></label>
							<div class="col-lg-10">
								<button type="button" id="addMenuBtn" class="btn btn-success"
									onclick="updMetuCheck()">修改</button>
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

	function updMetuCheck() {
		var $menu_parent_id=$("#menu-parent_id").val();
		var $menu_name=$("#menu-name").val();
		var $menu_url = $("#menu-url").val();
		var $pictures = $("#pictures").val();
		var $menu_id = $("#menu-id").val();
		if ("" == $menu_id || undefined == $menu_id) {
			alert("id不能为空");
			return;
		}
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
		
		data.menu_id = $menu_id;
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
					/* layer.alert(data.msg, {icon: 2}); */
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
