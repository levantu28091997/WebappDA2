<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="container-fluid">

	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h3 class="page-header">Thông Tin Quản Trị</h3>
			<ol class="breadcrumb">
				<li><i class="fa fa-dashboard"></i> <a
					href="<%=request.getContextPath()%>/admin">Dashboard</a></li>
				<li class="active"><i class="fa fa-table"></i> Thông tin quản
					trị</li>
			</ol>
			<jsp:include page="../admin-layout/message.jsp" />
		</div>
	</div>
	<!-- /.row -->

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">DataTables Advanced Tables</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>#</th>
									<th>Tên người quản trị</th>
									<th>Email</th>
									<th>Password</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listadminuser}" var="item" varStatus="i">
									<tr>
										<td>${i.count}</td>
										<td>${item.name}</td>
										<td>${item.email}</td>
										<td>*****</td>
										<td><a href="admin/adminuser/edit/${item.id}.html"><i
												class="fa fa-pencil fa-fw"></i></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<!-- /.table-responsive -->
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<script>
	$(document).ready(function() {
		$('#dataTables-example').dataTable();
	});

	
</script>
</div>