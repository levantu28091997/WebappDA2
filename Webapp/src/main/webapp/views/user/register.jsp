<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="clearfix"></div>
<div class="clearfix"></div>
<div class="container_fullwidth">
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<div class="special-deal leftbar" style="margin-top: 0;">
					<h4 class="title">
						Sản phẩm <strong> bán chạy </strong>
					</h4>
					<div class="special-item">
						<div class="product-image">
							<a href="details.html"> <img
								src="<%=request.getContextPath()%>/resources/home/images/products/thum/products-01.png"
								alt="">
							</a>
						</div>
						<div class="product-info">
							<p>
								<a href="details.html"> Licoln Corner Unit </a>
							</p>
							<h5 class="price">$300.00</h5>
						</div>
					</div>
					<div class="special-item">
						<div class="product-image">
							<a href="details.html"> <img
								src="<%=request.getContextPath()%>/resources/home/images/products/thum/products-02.png"
								alt="">
							</a>
						</div>
						<div class="product-info">
							<p>
								<a href="details.html"> Licoln Corner Unit </a>
							</p>
							<h5 class="price">$300.00</h5>
						</div>
					</div>
					<div class="special-item">
						<div class="product-image">
							<a href="details.html"> <img
								src="<%=request.getContextPath()%>/resources/home/images/products/thum/products-03.png"
								alt="">
							</a>
						</div>
						<div class="product-info">
							<p>
								<a href="details.html"> Licoln Corner Unit </a>
							</p>
							<h5 class="price">$300.00</h5>
						</div>
					</div>
				</div>

			</div>
			<div class="col-md-9">
				<div class="checkout-page">
					<ol class="checkout-steps">
						<li class="steps active"><a href=".../login"
							class="step-title" style="color: red; font-weight: bolder;">
								Đăng ký </a>
							<div class="step-description">
								<jsp:include page="../admin-layout/message.jsp" />
								<div class="row">
									<div class="col-md-6 col-sm-6">
										<div class="run-customer">

											<form:form method="post" commandName="User">
												<div class="form-group">
													<label>Tên Khách Hàng</label>
													<form:input path="name" class="form-control"
														placeholder="Nhập tên khách hàng.." />
													<p class="help-block">
														<form:errors path="name" cssClass="text-danger" />
													</p>
												</div>
												<div class="form-group">
													<label>Email</label>
													<form:input path="email" class="form-control"
														placeholder="Nhập email.." />
													<p class="help-block">
														<form:errors path="email" cssClass="text-danger" />
													</p>
												</div>
												<div class="form-group">
													<label>Password</label>
													<form:input path="password" class="form-control"
														placeholder="Nhập password.." />
													<p class="help-block">
														<form:errors path="password" cssClass="text-danger" />
													</p>
												</div>
												<div class="form-group">
													<label>Phone</label>
													<form:input path="phone" class="form-control"
														placeholder="Nhập phone.." />
													<p class="help-block">
														<form:errors path="phone" cssClass="text-danger" />
													</p>
												</div>
												<div class="form-group">
													<label>Địa chỉ</label>
													<form:input path="address" class="form-control"
														placeholder="Nhập tên địa chỉ.." />
													<p class="help-block">
														<form:errors path="address" cssClass="text-danger" />
													</p>
												</div>

												<button type="submit" class="btn btn-default">Thêm
													mới</button>
												<button type="reset" class="btn btn-default">Làm
													mới</button>

											</form:form>
										</div>
									</div>
								</div>
							</div></li>
					</ol>
				</div>
			</div>
		</div>
	</div>
</div>