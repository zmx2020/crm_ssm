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
			<div class="widget-container fluid-heig  ht clearfix">
				<div class="heading clearfix">
					<i class="icon-table"></i> 职位设置 <a
						class="btn btn-sm btn-primary pull-right weiBoxs-dialog"
						href="EmmPositionServlet?method=showAddPosition"
						dialog-title="添加职位"><i class="icon-plus"></i> 添加职位</a>
				</div>
				<div class="widget-content padded clearfix">
					<div class="dataTables_filter">
						<form id="positionForm" class="form-inline"
							action="EmmPositionServlet?method=getAllEmmPosition"
							method="post">
							<div class="btn-group">
								<span>职位名：</span> <input type="text" class="form-control"
									id="position_name" name="position_name" value="">
							</div>
							<div class="btn-group">
								<button type="button" id="searchButton" class="btn btn-success">
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
										<th nowrap>等级</th>
										<th nowrap>名称</th>
										<th nowrap>创建时间</th>
										<th nowrap>更新时间</th>
										<th class="action-column">操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${pageBean.list}" var="position">
										<tr data-key="${position.position_id}">
											<td>${position.position_id}</td>
											<td>${position.position_name}</td>
											<td>${position.position_level}</td>
											<td>${position.create_time}</td>
											<td>${position.update_time}</td>
											<td>
												<div class="col-lg-20">
													<button type="button" id="updatebtn" name="updatebtn"
														class="btn btn-warning btn-sm"
														onclick="updateposition(${position.position_id})">修改
													</button>
													<button type="button" id="delbtn" name="delbtn"
														class="btn btn-danger btn-sm"
														onclick="deleteposition(${position.position_id})">删除
													</button>
													<button type="button" id="linkbtn" name="linkbtn"
														class="btn btn-success btn-sm"
														onclick="showselectmodel(${position.position_id})">关联菜单</button>
												</div>
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
						<div id="checkedAllMenu" style="height: 10px; display: none"></div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- 这边是选择菜单的模态框  begin -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<input type="hidden" id="referenceposition_id"
						name="referenceposition_id">
					<h4 class="modal-title" id="myModalLabel">选择关联菜单</h4>
				</div>
				<div class="modal-body">
					<table id="example" class="table">
						<thead>
							<tr>
								<th></th>
								<th>名称</th>
								<th>地址</th>
								<th>上级菜单</th>
							</tr>
						</thead>
						<tbody>


						</tbody>
					</table>
				</div>
				<div class="modal-footer" style="text-align: center;">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-primary"
						onclick="submittochange()">确认</button>
				</div>
			</div>

		</div>
	</div>
	<!-- 这边是选择菜单的的模态框  end  -->

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
				first: '<li class="first"><a href="javascript:void(0);">首页</a></li>',
				prev: '<li class="prev"><a href="javascript:void(0);">上一页</a></li>',
				next: '<li class="next"><a href="javascript:void(0);">下一页</a></li>',
				last: '<li class="last"><a href="javascript:void(0);">末页</a></li>',
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
			window.location.href = "${pageContext.request.contextPath}/EmmPositionServlet?method=getAllEmmPosition&currentPage=" + num;
		}                                                          
	
	</script>
	<script type="text/javascript">
		$(function() {
			$("#searchButton").click(submitForm);

			function submitForm() {
				$("#positionForm").submit();
			}
		});
	</script>

	<script type="text/javascript">
	function deleteposition(position_id){
		if (confirm("删除后不可恢复，确认删除？")) {
			var data = {};
			data.position_id = position_id;
			$.ajax({
						type : 'post',
						url : '${pageContext.request.contextPath}/EmmPositionServlet?method=deletePostionCheck',
						data : data,
						dataType:"json",
						cache : false,
						sync : true,
						success : function(data) {
							if (false == data.status) {
								alert(data.msg);
							} else {
								location.href = '${pageContext.request.contextPath}/EmmPositionServlet?method=deletePosition&position_id='
										+ position_id;
							}
						},
						error : function() {
							alert("请求失败!");
						}
					});
		}
	}
	function updateposition(positionId) {
		
		location.href = 'EmmPositionServlet?method=getUpdatePostionDetailById&position_id='+positionId;
	}
	function showselectmodel(position_id) {
			$("#myModal").modal("show"); 
			var data = {};			
			data.position_id = position_id;
			
			 $.ajax({
				type : 'post',
				url : '${pageContext.request.contextPath}/EmmPositionServlet?method=getLinkPostionDetailById',
				data : data,
				cache : false,
				dataType:"json",
				sync : false,
				success : function(data) {
					$("#example tbody").html("");
					for(var  i=0;i<data.menuDtos.length;i++){
					 	$("#example tbody").append("<tr>");
						var tempMenu=data.menuDtos[i];
						/* onclick='movetochecked("+tempMenu.menu_id+")' */
						var input="<td><input type='checkbox' name='checkedemployee' value='"+tempMenu.menu_id+"'  style='opacity: 1;' /></td>";
						
					    for(var j=0;j<data.position_Menu_RelationsDtos.length;j++){
							var tempPMRDto=data.position_Menu_RelationsDtos[j];
							
							if(tempMenu.menu_id==tempPMRDto.menu_id){
								input="<td><input type='checkbox' name='checkedemployee' checked=true value='"+tempMenu.menu_id+"'  style='opacity: 1;' /></td>";
								break;
							}
						} 			   
						$("#example tbody").append(input);
						$("#example tbody").append("<td>"+tempMenu.menu_name+"</td>");
						$("#example tbody").append("<td>"+tempMenu.menu_url+"</td>");
						if(tempMenu.parent_menu_name==undefined || tempMenu.parent_menu_name==null ){
							$("#example tbody").append("<td></td>");
						}else{
							$("#example tbody").append("<td>"+tempMenu.parent_menu_name+"</td>");
						}
						$("#example tbody").append("</tr>"); 
					}
					
				},
				error : function() {
					alert("请求失败!");
				}
			});  
			
			$("#referenceposition_id").val(position_id);
	}
	</script>

	<script type="text/javascript">
	//datatable 初始化 
	$.extend($.fn.dataTable.defaults, {
				"searching" : false,
				"ordering" : false
			});
			$('#example').DataTable({
				
				"lengthMenu": [[5, 10, -1], [5, 10, "All"]],
				language : {
					"sProcessing" : "处理中...",
					"sLengthMenu" : "显示 _MENU_ 项结果",
					"sZeroRecords" : "没有匹配结果",
					"sInfo" : "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
					"sInfoEmpty" : "显示第 0 至 0 项结果，共 0 项",
					"sInfoFiltered" : "(由 _MAX_ 项结果过滤)",
					"sInfoPostFix" : "",
					"sSearch" : "搜索:",
					"sUrl" : "",
					"sEmptyTable" : "表中数据为空",
					"sLoadingRecords" : "载入中...",
					"sInfoThousands" : ",",
					"oPaginate" : {
						"sFirst" : "首页",
						"sPrevious" : "上页",
						"sNext" : "下页",
						"sLast" : "末页"
					}
				}
			});
		//end datatable 初始化 
	
		
		function submittochange(){
			 var vals = [];
			 var data = {};		
			     $('#example input:checkbox:checked').each(function (index, item) {
			         vals.push($(this).val());
			      });
			
			data.referenceposition_id = $("#referenceposition_id").val();
			data.menus = vals.join("-");
		 	$.ajax({
				type : 'post',
				url : '${pageContext.request.contextPath}/EmmPositionServlet?method=updataPositionMenuRelations',
				data : data,
				cache : false,
				dataType:"json",
				sync : false,
				success : function(data) {
					if (false == data.status) {
						alert(data.msg);
						/* layer.alert(data.msg, {
							icon : 2
						}); */
					} else {
						alert("菜单更新成功！");
						/* layer.alert() */
						$("#myModal").modal("hide"); 
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
