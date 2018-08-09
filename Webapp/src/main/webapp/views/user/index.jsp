<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="slide.jsp"></jsp:include>
<div class="clearfix"></div>
<div class="container_fullwidth">
	<div class="container">
		<div class="hot-products">
			<h3 class="title">
				<strong>Hot</strong> Products
			</h3>
			<div class="control">
				<a id="prev_hot" class="prev" href="#">&lt;</a><a id="next_hot"
					class="next" href="#">&gt;</a>
			</div>
			<ul id="hot">
				<li>
					<div class="row">
						<c:forEach items="${new_products}" var="item">
							<div class="col-md-3 col-sm-6">
								<div class="products">
									<div class="offer">New</div>
									<div class="thumbnail">
										<a href="detail/${item.id}.html"><img
											src="${item.image}
										alt="${item.name}"></a>
									</div>
									<div class="productname">
										<a href="detail/${item.id}.html">${item.name}</a>
									</div>
									<h4 class="price">
										<fmt:formatNumber type="number" pattern="###,###"
											value="${item.price}" />
										VNĐ
									</h4>
									<div class="button_group">
										<a href="ordernow/${item.id}"><button
												class="button add-cart" type="button">Add To Cart</button></a>
										<button class="button compare" type="button">
											<i class="fa fa-exchange"></i>
										</button>
										<button class="button wishlist" type="button">
											<i class="fa fa-heart-o"></i>
										</button>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</li>
			</ul>
		</div>
		<div class="clearfix"></div>
		<div class="featured-products">
			<h3 class="title">
				<strong>Featured </strong> Products
			</h3>
			<div class="control">
				<a id="prev_featured" class="prev" href="#">&lt;</a><a
					id="next_featured" class="next" href="#">&gt;</a>
			</div>
			<ul id="featured">
				<li>
					<div class="row">
						<c:forEach items="${popular_products}" var="item">
							<div class="col-md-3 col-sm-6">
								<div class="products">
									<div class="offer">Hot</div>
									<div class="thumbnail">
										<a href="detail/${item.id}.html"><img
											src="${item.image}
										alt="${item.name}"></a>
									</div>
									<div class="productname">
										<a href="detail/${item.id}.html">${item.name}</a>
									</div>
									<h4 class="price">
										<fmt:formatNumber type="number" pattern="###,###"
											value="${item.price}" />
										VNĐ
									</h4>
									<div class="button_group">
										<a href="ordernow/${item.id}"><button
												class="button add-cart" type="button">Add To Cart</button></a>
										<button class="button compare" type="button">
											<i class="fa fa-exchange"></i>
										</button>
										<button class="button wishlist" type="button">
											<i class="fa fa-heart-o"></i>
										</button>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</li>
			</ul>
		</div>
		<div class="clearfix"></div>
		<jsp:include page="ourband.jsp" />
	</div>
</div>