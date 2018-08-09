<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Tables</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
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
								<th>Sản Phẩm</th>
								<th>Ảnh</th>
								<th>Danh Mục</th>
								<th>Giá</th>
								<th>Mô Tả</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listproduct}" var="item" varStatus="i">
								<tr>
									<td>${i.count}</td>
									<td>${item.name}</td>
									<td><img src="${item.image}" alt="${item.name}" width="30"
										height="30" /></td>
									<td>${item.categories.name}</td>
									<td><fmt:formatNumber type="number" pattern="###,###"
											value="${item.price}" /> VNĐ</td>
									<td>${item.intro}</td>
									<td><a href="admin/product/edit/${item.id}.html"><i
											class="fa fa-pencil fa-fw"></i></a>&emsp;<a
										href="admin/product/delete/${item.id}.html"><i
											class="fa fa-trash-o fa-fw"></i></a></td>
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