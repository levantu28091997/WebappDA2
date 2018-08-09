<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
								Đăng nhập </a>
							<div class="step-description">
								<jsp:include page="../admin-layout/message.jsp" />
								<div class="row" style="padding-left: 30%;">
									<div class="col-md-6 col-sm-6">
										<div class="run-customer">
											<h5>Đăng nhập để tiếp tục..!</h5>
											<form:form method="post" commandName="User" action="login">
												<div class="form-row">
													<label class="lebel-abs"> Email <strong class="red">
															* </strong>
													</label> <input type="text" class="input namefild" name="email" placeholder="Nhập email">
												</div>
												<div class="form-row">
													<label class="lebel-abs"> Password <strong
														class="red"> * </strong>
													</label> <input type="password" class="input namefild" name="password" placeholder="Nhập password">
												</div>
												<p class="forgoten">
													<a href="<%=request.getContextPath()%>/register"> Đăng
														ký nếu chưa có tài khoản? </a>
												</p>
												<button type="submit">Login</button>
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