<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="container_fullwidth">
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<div class="products-details">
					<div class="preview_image">
						<div class="preview-small">
							<img id="zoom_03" src="${detail.image}"
								style="padding: 20px 0px 18px 90px" alt="">
						</div>

					</div>
					<div class="products-description">
						<h5 class="name">${detail.name}</h5>
						<hr class="border">
						<div class="price">
							Price : <span class="new_price"><fmt:formatNumber
									type="number" pattern="###,###" value="${detail.price}" /><sup>
									VNĐ </sup> </span>
						</div>
						<hr class="border">
						<div class="wided">
							<div class="qty">
								Qty &nbsp;&nbsp;: <select>
									<option>1</option>
								</select>
							</div>
							<div class="button_group">
								<a href="ordernow/${detail.id}"><button
												class="button compare" type="button">Add To Cart</button></a>
								<button class="button compare">
									<i class="fa fa-exchange"> </i>
								</button>
								<button class="button favorite">
									<i class="fa fa-heart-o"> </i>
								</button>
								<button class="button favorite">
									<i class="fa fa-envelope-o"> </i>
								</button>
							</div>
						</div>
						<div class="clearfix"></div>
						<hr class="border">
						<img src="images/share.png" alt="" class="pull-right">
					</div>
				</div>
				<div class="clearfix"></div>
				<div class="tab-box">
					<div id="tabnav">
						<ul>
							<li><a href="#Descraption"> DESCRIPTION </a></li>
							<li><a href="#Reviews"> REVIEW </a></li>
							<li><a href="#tags"> PRODUCT TAGS </a></li>
						</ul>
					</div>
					<div class="tab-content-wrap">
						<div class="tab-content" id="Descraption">
							<p>${detail.intro}</p>
						</div>
					</div>
				</div>

				<div class="clearfix"></div>
			</div>
			<div class="col-md-3">
				<div class="special-deal leftbar">
					<h4 class="title">
						Sản phẩm <strong> bán chạy </strong>
					</h4>
					<div class="special-item">
						<div class="product-image">
							<a href="#"> <img
								src="<%=request.getContextPath()%>/resources/home/images/products/thum/products-01.png"
								alt="">
							</a>
						</div>
						<div class="product-info">
							<p>Licoln Corner Unit</p>
							<h5 class="price">$300.00</h5>
						</div>
					</div>
					<div class="special-item">
						<div class="product-image">
							<a href="#"> <img
								src="<%=request.getContextPath()%>/resources/home/images/products/thum/products-02.png"
								alt="">
							</a>
						</div>
						<div class="product-info">
							<p>Licoln Corner Unit</p>
							<h5 class="price">$300.00</h5>
						</div>
					</div>
					<div class="special-item">
						<div class="product-image">
							<a href="#"> <img
								src="<%=request.getContextPath()%>/resources/home/images/products/thum/products-03.png"
								alt="">
							</a>
						</div>
						<div class="product-info">
							<p>Licoln Corner Unit</p>
							<h5 class="price">$300.00</h5>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>