<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="container-fluid">

	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h2 class="page-header">Cập Nhật Sản Phẩm</h2>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-6">

			<form:form method="post" commandName="Product">
				<div class="form-group">
					<label>Sản phẩm</label>
					<form:input path="name" class="form-control"
						placeholder="Nhập tên.." value="${itemProduct.name}" />
					<p class="help-block">
						<form:errors path="name" cssClass="text-danger" />
					</p>
				</div>
				<div class="form-group">
					<label>Danh mục</label>
					<form:select class="form-control" path="categories.id">
						<form:options items="${listCategory}" itemValue="id"
							itemLabel="name"></form:options>
					</form:select>
					<p class="help-block">
						<form:errors path="categories.id" cssClass="text-danger" />
					</p>
				</div>
				<div class="form-group">
					<label>Giá</label>
					<form:input path="price" class="form-control"
						placeholder="Nhập giá.." value="${itemProduct.price}"
						type="number" />
					<p class="help-block">
						<form:errors path="price" cssClass="text-danger" />
					</p>
				</div>
				<div class="form-group">
					<label>Ảnh</label>
					<form:input path="image" class="form-control"
						placeholder="Nhập link ảnh.." value="${itemProduct.image}" />
					<p class="help-block">
						<form:errors path="image" cssClass="text-danger" />
					</p>
				</div>
				<div class="form-group">
					<label>Mô tả</label>
					<form:input path="intro" class="form-control"
						placeholder="Nhập mô tả.." value="${itemProduct.intro}" />
					<p class="help-block">
						<form:errors path="intro" cssClass="text-danger" />
					</p>
				</div>

				<button type="submit" class="btn btn-default">Cập nhật</button>
				<button type="reset" class="btn btn-default">Làm mới</button>

			</form:form>

		</div>
	</div>
</div>