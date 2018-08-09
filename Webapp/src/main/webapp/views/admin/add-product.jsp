<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container-fluid">

	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h2 class="page-header">Thêm Sản Phẩm</h2>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-6">

			<form:form method="post" commandName="Product">

				<div class="form-group">
					<label>Tên sản phẩm</label>
					<form:input class="form-control" path="name" placeholder="Nhập tên" />
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
					<form:input class="form-control" path="price" type="number"
						placeholder="Nhập giá" />
					<p class="help-block">
						<form:errors path="price" cssClass="text-danger" />
					</p>
				</div>


				<div class="form-group">
					<label>Ảnh</label>
					<form:input class="form-control" path="image"
						placeholder="Nhập link ảnh" />
					<p class="help-block">
						<form:errors path="image" cssClass="text-danger" />
					</p>
				</div>

				<div class="form-group">
					<label>Mô tả</label>
					<form:textarea class="form-control" path="intro" rows="3"></form:textarea>
					<p class="help-block">
						<form:errors path="intro" cssClass="text-danger" />
					</p>
				</div>


				<button type="submit" class="btn btn-default">Thêm mới</button>
				<button type="reset" class="btn btn-default">Làm mới</button>

			</form:form>

		</div>
	</div>
</div>