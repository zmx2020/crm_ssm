﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
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
					<i class="icon-reorder"></i> 新增商机 <a href="javascript:;"
						class="pull-right" onclick="history.go(-1);"><i
						class="icon-reply"></i> </a>
				</div>
				<div class="widget-content padded clearfix">
					<form id="w0" class="form-horizontal"
						action="view/customerManage/business/index.jsp" method="get">
						<input type="hidden" name="_csrf"
							value="Z29zNkpYOUkFGCVdcyF6MTYBQ2YHYFYCOAUCUyYIUBEQOz1.OB5Dfg==">

						<div class="form-body">
							<div class="form-group field-business-owner_name">
								<label class="control-label col-sm-2" for="business-owner_name">负责人</label>

								<div class="col-sm-8">
									<input type="text" id="employeeName"
										class="owner_name form-control weiBoxs-dialog"
										name="Business[owner_name]" dialog-size="large"
										dialog-title="选择所属人" dialog-url="/manage/select-user.html" value="阿是" readonly="readonly"
										onclick="selectEmployee()" placeholder="负责人">
										<input type="hidden" id="employeeId" />
								</div>
								<div class="help-block help-block-error"></div>
							</div>
							<div class="form-group field-business-selectcustomer required">
								<label class="control-label col-sm-2"
									for="business-selectcustomer">所属客户</label>

								<div class="col-sm-8">
									<input type="text" id="business-selectcustomer"
										class="selectCustomer form-control weiBoxs-dialog"
										name="Business[selectCustomer]" placeholder="点击选择客户"
										dialog-callback="actionCallBacks" dialog-title="选择客户"
										dialog-url="/customer/dialog-list.html"  readonly="readonly"
										onclick="selectCustomer()"/> <input type="hidden" id="customerId" />

								</div>

								<div class="help-block help-block-error"></div>
							</div>

							<div class="form-group field-business-selectcontacts required">
								<label class="control-label col-sm-2"
									for="business-selectcontacts">联系人</label>

								<div class="col-sm-8"">
									<input type="text" id="business-selectcontacts"
										class="selectContacts form-control weiBoxs-dialog"
										name="Business[selectContacts]" placeholder="点击选择联系人"
										dialog-title="选择联系人" dialog-size="large"
										dialog-url="/contacts/dialog-list.html" readonly="readonly"
										onclick="selectLinkMan()"> <input type="hidden"
										id="linkManId" />
									
								</div>

								<div class="help-block help-block-error"></div>
							</div>
							<div class="form-group field-business-name required">
								<label class="control-label col-sm-2" for="business-name">商机名</label>

								<div class="col-sm-8">
									<input type="text" id="business-name" class="form-control"
										name="Business[name]" onfocus="$(this).onlypressnum();"
										placeholder="商机名">
								</div>
								<div class="help-block help-block-error"></div>
							</div>
							<div class="form-group field-business-type required">
								<label class="control-label col-sm-2" for="business-type">商机类型</label>

								<div class="col-sm-8">
									<select id="business-type" class="form-control"
										name="Business[type]">
										<option value="">请选择...</option>
										<option value="1" selected>新业务</option>
										<option value="2">现有业务</option>
									</select>
								</div>
								<div class="help-block help-block-error"></div>
							</div>
							<div class="form-group field-business-status required">
								<label class="control-label col-sm-2" for="business-status">状态</label>

								<div class="col-sm-8">
									<select id="business-status" class="form-control"
										name="Business[status]">
										<option value="">请选择...</option>
										<option value="1">初步沟通</option>
										<option value="2">签订服务协议</option>
										<option value="3" selected>签订合同</option>
									</select>
								</div>
								<div class="help-block help-block-error"></div>
							</div>
							<div class="form-group field-business-origin required">
								<label class="control-label col-sm-2" for="business-origin">商机来源</label>

								<div class="col-sm-8">
									<select id="business-origin" class="form-control"
										name="Business[origin]">
										<option value="">请选择...</option>
										<option value="10" selected>电话营销</option>
										<option value="20">网络营销</option>
									</select>
								</div>
								<div class="help-block help-block-error"></div>
							</div>
							<div class="form-group field-business-gain_rate required">
								<label class="control-label col-sm-2" for="business-gain_rate">赢单率</label>

								<div class="col-sm-8">
									<input type="text" id="business-gain_rate" class="form-control"
										name="Business[gain_rate]" onfocus="$(this).onlypressnum();"
										placeholder="赢单率">

									<div class="help-block">按百分比%</div>
								</div>
								<div class="help-block help-block-error"></div>
							</div>
							<div class="form-group field-business-estimate_price required">
								<label class="control-label col-sm-2"
									for="business-estimate_price">预计价格</label>

								<div class="col-sm-8">
									<input type="text" id="business-estimate_price"
										class="form-control" name="Business[estimate_price]"
										onfocus="$(this).onlypressnum();" placeholder="预计价格">
								</div>
								<div class="help-block help-block-error"></div>
							</div>
						
							<div class="form-group field-business-nextstep_time required">
								<label class="control-label col-sm-2"
									for="business-nextstep_time">下次联系时间</label>

								<div class="col-sm-8">
									<input type="date" id="business-nextstep_time"
										class="form-control form_datetime"
										name="Business[nextstep_time]" >
								</div>
								<div class="help-block help-block-error"></div>
							</div>
							<div class="form-group field-business-nextstep required">
								<label class="control-label col-sm-2" for="business-nextstep">下次联系内容</label>

								<div class="col-sm-8">
									<textarea id="business-nextstep" class="form-control"
										name="Business[nextstep]" style="height:80px;"
										placeholder="下次联系内容"></textarea>
								</div>
								<div class="help-block help-block-error"></div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label"></label>

							<div class="col-lg-10">
								<button type="button" class="btn btn-primary"
									onclick="addBuness()">添加</button>
								<button type="button" class="btn btn-default"
									onClick="history.go(-1);">返回</button>
								<input type="hidden" name="reback">
							</div>
							<!-- /.col -->
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- 	负责人模态框 -->
	<div class="modal fade" id="myModalEmployee" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<input type="hidden" id="referencepositionId" name="referencepositionId">
					<h4 class="modal-title" id="myModalLabel">选择负责人</h4>
				</div>
				<div class="modal-body">
					<table id="exampleCustomer" class="table">
						<thead>
							<tr>
									<th>选择</th>
									<th>姓名</th>
									<th>部门</th>
									<th>职位</th>
								</tr>
						</thead>
							<tbody>
									<tr>
										<td>
											<input type="radio"  name ="radioEmployeeName" style=" opacity: 1;margin-top: -6px " id="1"/>
											
										</td>
										<td id="1_emp">是
										</td>
										<td>阿哥</td>
										<td>飒飒的</td>
									</tr>
							</tbody>
					</table>
				</div>
			<div class="modal-footer">
					<button type="button" id="checkPass" class="btn btn-primary"
						onclick="postCheckInfoEmployee()">确认</button>
					<button type="button" id="checkRefuse" class="btn btn-primary"
						onclick="postCheckDocInfoEmployee()">取消</button>
				</div>
			</div>
			
		</div>
	</div>
	
	
	<!-- 	联系人模态框 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<input type="hidden" id="referencepositionId" name="referencepositionId">
					<h4 class="modal-title" id="myModalLabel">选择联系人</h4>
				</div>
				<div class="modal-body">
					<table class="table" id="exampleEmployee">
<!-- 							<caption>响应式表格布局</caption> -->
							<thead>
								<tr>
									<th>选择</th>
									<th>姓名</th>
									<th>职位</th>
									<th>手机号码</th>
								</tr>
							</thead>
							<tbody>
									<tr>
										<td>
											<input type="radio"  name ="radioName" style=" opacity: 1;margin-top: -6px " id="1"/>
											
										</td>
										<td id="1_lg">阿是
										</td>
										<td>广发</td>
										<td>1233</td>
									</tr>
							</tbody>
						</table>
				</div>
			<div class="modal-footer">
					<button type="button" id="checkPass" class="btn btn-primary"
						onclick="postCheckInfo()">确认</button>
					<button type="button" id="checkRefuse" class="btn btn-primary"
						onclick="postCheckDocInfo()">取消</button>
				</div>
			</div>
			
		</div>
	</div>
	
	
	<!-- 	客户模态框 -->
	<div class="modal fade" id="myModalCustomer" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<input type="hidden" id="referencepositionId" name="referencepositionId">
					<h4 class="modal-title" id="myModalLabel">选择客户</h4>
				</div>
				<div class="modal-body">
					<table id="exampleCustomer" class="table">
						<thead>
							<tr>
									<th>选择</th>
									<th>客户名称</th>
									<th>所属行业</th>
									<th>客户来源</th>
								</tr>
						</thead>
							<tbody>
									<tr>
										<td>
											<input type="radio"  name ="radioNameCustomer" style=" opacity: 1;margin-top: -6px " id="1"/>
											
										</td>
										<td id="1_gk">阿是
											
										</td>
										<td>阿哥</td>
										<td>飒飒的</td>
									</tr>
							</tbody>
					</table>
				</div>
			<div class="modal-footer">
					<button type="button" id="checkPass" class="btn btn-primary"
						onclick="postCheckInfoCustomer()">确认</button>
					<button type="button" id="checkRefuse" class="btn btn-primary"
						onclick="postCheckDocInfoCustomer()">取消</button>
				</div>
			</div>
			
		</div>
	</div>
</body>
<script type="text/javascript">
	function selectEmployee() {
		$("#myModalEmployee").modal("show");
	}
	
	function postCheckInfoEmployee(){
		var list=document.getElementsByName("radioEmployeeName");
		for ( var i = 0; i < list.length; i++) {
			if (list[i].checked==true) {
				var id=list[i].id;
				var textName=document.getElementById(id+"_emp").innerText;
				$("#employeeName").val("");
				$("#employeeId").val("");
				$("#employeeName").val(textName);
				$("#employeeId").val(id);
			}
		}
		$("#myModalEmployee").modal("hide");
	}
	
	function postCheckDocInfoEmployee(){
		$("#myModalEmployee").modal("hide");
	}
	
	
	
	
	
	
	
	
	
	function selectLinkMan() {
		$("#myModal").modal("show");
	}
	
	function postCheckInfo(){
		var list=document.getElementsByName("radioName");
		for ( var i = 0; i < list.length; i++) {
			if (list[i].checked==true) {
				var id=list[i].id;
				var textName=document.getElementById(id+"_lg").innerText;
				$("#business-selectcontacts").val("");
				$("#linkManId").val("");
				$("#business-selectcontacts").val(textName);
				$("#linkManId").val(id);
			}
		}
		$("#myModal").modal("hide");
	}
	
	function postCheckDocInfo(){
		$("#myModal").modal("hide");
	}
	
	function selectCustomer(){
		$("#myModalCustomer").modal("show");
	}
	function postCheckInfoCustomer(){
		var list=document.getElementsByName("radioNameCustomer");
		for ( var i = 0; i < list.length; i++) {
			if (list[i].checked==true) {
				var id=list[i].id;
				var textName=document.getElementById(id+"_gk").innerText;
				$("#business-selectcustomer").val("");
				$("#customerId").val("");
				$("#business-selectcustomer").val(textName);
				$("#customerId").val(id);
			}
		}
		$("#myModalCustomer").modal("hide");
	}
	
	function postCheckDocInfoCustomer(){
		$("#myModalCustomer").modal("hide");
	}


	function addBuness() {
		
	
 	}
</script>

<script type="text/javascript">

		$.extend($.fn.dataTable.defaults, {
			"searching" : false,
			"ordering" : false
		});
		$('#example').DataTable({
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
	</script>
	
	<script type="text/javascript">

		$.extend($.fn.dataTable.defaults, {
			"searching" : false,
			"ordering" : false
		});
		$('#exampleCustomer').DataTable({
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
	</script>
	<script type="text/javascript">

		$.extend($.fn.dataTable.defaults, {
			"searching" : false,
			"ordering" : false
		});
		$('#exampleEmployee').DataTable({
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
	</script>
</html>
