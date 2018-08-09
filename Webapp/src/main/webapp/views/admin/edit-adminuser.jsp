<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="container-fluid">

	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h2 class="page-header">Cập Nhật Tài Khoản Quản Trị</h2>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-6">

			<form:form method="post" commandName="AdminUser">
				<div class="form-group">
					<label>Tên người quản trị</label>
					<form:input path="name" class="form-control"
						placeholder="Nhập tên người quản trị .."
						value="${itemadminuser.name}" />
					<p class="help-block">
						<form:errors path="name" cssClass="text-danger" />
					</p>
				</div>
				<div class="form-group">
					<label>Email</label>
					<form:input path="email" class="form-control"
						placeholder="Nhập tên email .." value="${itemadminuser.email}" />
					<p class="help-block">
						<form:errors path="email" cssClass="text-danger" />
					</p>
				</div>
				<div class="form-group">
					<label>Password</label>
					<form:input path="password" type="password" class="form-control"
						placeholder="Nhập mật khẩu .." value="${itemadminuser.password}" />
					<p class="help-block">
						<form:errors path="password" cssClass="text-danger" />
					</p>
				</div>

				<button type="submit" class="btn btn-default">Cập nhật</button>
				<button type="reset" class="btn btn-default">Làm mới</button>

			</form:form>

		</div>
	</div>
</div>