<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%--
	<div class="row">
		<div class="col-lg-12">
				<div>
					<p>
						<a class="btn btn-primary" role="button"
							href="admin/${path}/delete/${id}-yes.html">Yes</a> <a class="btn btn-danger"
							role="button" href="admin/${path}">No</a>
					</p>
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div> --%>


<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header"></h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Bạn có chắc chắn muốn xóa không..?</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<p>
					<a class="btn btn-primary" role="button"
						href="admin/${path}/delete/${id}-yes.html">Yes</a> <a
						class="btn btn-danger" role="button" href="admin/${path}">No</a>
				</p>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>