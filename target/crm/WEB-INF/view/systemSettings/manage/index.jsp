<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="net.wanho.consts.ConstVal"%>
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
			<div class="widget-container fluid-height clearfix">
				<div class="heading clearfix">
					<i class="icon-table"></i> 员工管理 <a
						class="btn btn-sm btn-primary pull-right"
						href="EmployeeServlet?method=getDeapartAndPostionInfo"><i
						class="icon-plus"></i> 添加员工</a>
				</div>
				<div class="widget-content padded clearfix">
					<div class="dataTables_filter">
						<form class="form-inline"
							action="EmployeeServlet?method=getAllEmployee" method="post">
							<div class="btn-group">
								<span>工号：</span> <input type="text" class="form-control"
									id="emmployee_id" name="emmployee_id" value="">
							</div>
							<div class="btn-group">
								<span>姓名：</span> <input type="text" class="form-control"
									id="emmployee_name" name="emmployee_name" value="">
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
										<th nowrap>工号</th>
										<th nowrap>姓名</th>
										<th nowrap>部门</th>
										<th nowrap>职位</th>
										<th nowrap>手机</th>
										<th nowrap>电子邮箱</th>
										<th nowrap>状态</th>
										<th nowrap>创建时间</th>
										<th nowrap>更新时间</th>
										<th class="action-column">操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${pageBean.list}" var="employee">
										<tr data-key="${employee.employee_id}">
											<td>${employee.employee_id}</td>
											<td>${employee.employee_name}</td>
											<td>${employee.department_name}</td>
											<td>${employee.position_Name}</td>
											<td>${employee.phone}</td>
											<td>${employee.email}</td>
											<td><c:choose>
													<c:when test="${employee.status==0}">
														<%=ConstVal.EMPLOYEE_STATUS_0%>
													</c:when>
													<c:otherwise>
														<%=ConstVal.EMPLOYEE_STATUS_1%>
													</c:otherwise>
												</c:choose></td>
											<td>${employee.create_time}</td>
											<td>${employee.update_time}</td>
											<td><c:choose>
													<c:when test="${employee.status==0}">
														<button type="button" id="forbidbtn" name="forbidbtn"
															class="btn btn-danger btn-sm"
															onclick="updateEmployeeStatus('${employee.employee_id}','1')">禁用账户</button>
														<button type="button" id="updatebtn" name="updatebtn"
															class="btn btn-info btn-sm"
															onclick="updateEmployeeDetail('${employee.employee_id}')">修改用户信息</button>
													</c:when>
													<c:otherwise>
														<button type="button" id="forbidbtn" name="forbidbtn"
															class="btn btn-success btn-sm"
															onclick="updateEmployeeStatus('${employee.employee_id}','0')">恢复正常</button>
													</c:otherwise>
												</c:choose></td>
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
			window.location.href = "${pageContext.request.contextPath}/EmployeeServlet?method=getAllEmployee&currentPage=" + num;
		}
	
		function updateEmployeeStatus(employee_id, status) {
		
		
			layer.confirm('是否确认更新用户状态？', {
				 btn: ['确认','取消'] //按钮
				}, function(){
					var data = {};
					data.employee_id = employee_id;
					data.status = status;
					
					$.ajax({
						type : 'post',
						url : '${pageContext.request.contextPath}/EmployeeServlet?method=updateEmployeeStatus',
						data : data,
						cache : false,
						sync : true,
						dataType:"json",
						success : function(result) {
							if (0 == result.status) {
								location.href = '${pageContext.request.contextPath}/EmployeeServlet?method=getAllEmployee';
							} else {
								layer.alert(result.msg, {icon: 2});
							}
						},
						error : function() {
							layer.alert("请求失败", {icon: 2});
						}
					
					});
				}, function(){
				  
				});
			
		}
		
		function updateEmployeeDetail(employee_id) {
			
			location.href = '${pageContext.request.contextPath}/EmployeeServlet?method=findEmployeeById&employee_id='
					+ employee_id;
		}
	</script>
</body>

</html>
