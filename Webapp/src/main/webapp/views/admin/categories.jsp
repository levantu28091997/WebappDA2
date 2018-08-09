<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="container-fluid">

	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h3 class="page-header">
				Danh Mục Sản Phẩm - <a href="admin/categories/add">Thêm Danh Mục</a>
			</h3>
			<ol class="breadcrumb">
				<li><i class="fa fa-dashboard"></i> <a
					href="<%=request.getContextPath()%>/admin">Dashboard</a></li>
				<li class="active"><i class="fa fa-table"></i> Danh mục sản
					phẩm</li>
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
									<th>Tên Danh Mục</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listcategories}" var="item" varStatus="i">
									<tr class="odd gradeX">
										<td>${i.count}</td>
										<td>${item.name}</td>
										<td><a href="admin/categories/edit/${item.id}.html"><i
												class="fa fa-pencil fa-fw"></i></a>&emsp;<a
											href="admin/categories/delete/${item.id}.html"><i
												class="fa fa-trash-o fa-fw icon-red"></i></a></td>
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
