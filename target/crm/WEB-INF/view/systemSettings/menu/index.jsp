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
			<div class="widget-container fluid-height clearfix">
				<div class="heading clearfix">
					<i class="icon-table"></i> 菜单管理 <a
						class="btn btn-sm btn-primary pull-right"
						href="MenuServlet?method=getAllParentMenu"><i
						class="icon-plus"></i> 创建菜单</a>
				</div>
				<div class="widget-content padded clearfix">
					<div class="dataTables_filter">
						<form class="form-inline" action="MenuServlet?method=getAllMenu"
							method="post">
							<div class="btn-group">
								<span>菜单名：</span> <input type="text" class="form-control"
									id="name" name="name" value="" placeholder="名称">
							</div>
							<div class="btn-group">
								<button type="submit" class="btn btn-success">
									<i class="glyphicon glyphicon-search"></i> 搜索
								</button>
							</div>
						</form>
					</div>
					<div id="w0" class="grid-view">
						<div class="table-responsive">
							<table class="table table-hover">
								<thead>
									<tr>
										<th nowrap>ID</th>
										<th nowrap>名称</th>
										<th nowrap>地址</th>
										<th nowrap>图标</th>
										<th nowrap>创建时间</th>
										<th nowrap>更新时间</th>
										<th nowrap>上级菜单</th>
										<th class="action-column">操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${pageBean.list}" var="menu">
										<tr data-key="${menu.menu_id}">
											<td>${menu.menu_id}</td>
											<td>${menu.menu_name}</td>
											<td>${menu.menu_url}</td>
											<td><span class="${menu.pictures}"></span></td>	
											<td>${menu.create_time}</td>
											<td>${menu.update_time}</td>
											<td>${menu.parent_menu_name}</td>
											<%-- <td>${menu.status}</td> --%>
											<td>
												<button type="button" id="updatebtn" name="updatebtn"
													class="btn btn-warning btn-sm"
													onclick="updateMenu(${menu.menu_id})">修改</button>
												<button type="button" id="delbtn" name="delbtn"
													class="btn btn-danger btn-sm"
													onclick="deleteMenu(${menu.menu_id})">删除</button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<center>
								<ul class="pagination">
								</ul>
							</center>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(function() {
		
		var if_fistime = true;
		$(".pagination").jqPaginator({
				//总页数（pageBean）
				totalPages: ${pageBean.totalPage},
				//可见的页数（前段页面可写死）
				visiblePages: 5,
				//当前页（pageBean）
				currentPage: ${pageBean.currentPage},
				first: '<li class="first"><a href="javascript:void(0);">第一页</a></li>',
				prev: '<li class="prev"><a href="javascript:void(0);">上一页</a></li>',
				next: '<li class="next"><a href="javascript:void(0);">下一页</a></li>',
				last: '<li class="last"><a href="javascript:void(0);">最后一页</a></li>',
				page: '<li class="page"><a href="javascript:void(0);">{{page}}</a></li>',
				onPageChange: function(num) {
					if(if_fistime) {
						if_fistime = false;
					} else {
						changePage(num);
					} 
				}
			});
		});
	
		
		function changePage(num) {
			window.location.href = "${pageContext.request.contextPath}/MenuServlet?method=getAllMenu&currentPage=" + num;
		}
		

		function deleteMenu(menu_id) {
			if (confirm("删除后不可恢复，确认删除？")) {
				var data = {};
				data.menu_id = menu_id;
				$
						.ajax({
							type : 'post',
							url : '${pageContext.request.contextPath}/MenuServlet?method=checkDeleteMenuId',
							data : data,
							dataType:"json",
							cache : false,
							sync : true,
							success : function(data) {

								if (false == data.status) {
									alert(data.msg);
								} else {
									location.href = '${pageContext.request.contextPath}/MenuServlet?method=deleteMenuById&menu_id='
											+ menu_id;
								}
							},
							error : function() {
								alert("请求失败!");
							}
						});
			}
		}

		function updateMenu(menuId) {
	
			location.href = 'MenuServlet?method=getUpdateMenudetailById&menuId='+menuId;
		}
	</script>
</body>

</html>
