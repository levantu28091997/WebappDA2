<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="container_fullwidth">
	<div class="container shopping-cart">
		<div class="row">
			<div class="col-md-12">
				<jsp:include page="../user-layout/message.jsp" />
				<h3 class="title">Shopping Cart</h3>
				<div class="clearfix"></div>
				<table class="shop-table">
					<thead>
						<tr>
							<th>Image</th>
							<th>Dtails</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="cart" items="${sessionScope.cart.items}"
							varStatus="index">
							<tr>
								<td><img src="${cart.product.image }" alt=""></td>
								<td>
									<div class="shop-details">
										<div class="productname">
											<h3 class="pcode">Sản phẩm: ${cart.product.name }</h3>
										</div>
										<p>
											<img alt=""
												src="<%=request.getContextPath()%>/resources/home/images/star.png">
											<a class="review_num" href="#"> 02 Review(s) </a>
										</p>
										<div class="color-choser">
											<span class="text"> Product Color : </span>
											<ul>
												<li><a class="red-bg" href="#"> light red </a></li>
												<li><a class=" yellow-bg" href="#"> yellow" </a></li>
												<li><a class="black-bg " href="#"> black </a></li>
												<li><a class="pink-bg" href="#"> pink </a></li>
											</ul>
										</div>
										<p>
											Product Code : <strong class="pcode"> Dress 050 </strong>
										</p>
									</div>
								</td>
								<td>
									<h5>
										<fmt:formatNumber type="number" pattern="###,###"
											value="${cart.product.price}" />
										VNĐ
									</h5>
								</td>
								<td><select name="">
										<option selected value="1">${cart.quantity}</option>
								</select></td>
								<td><a href="deleteorder/${cart.product.id}"> <img
										src="<%=request.getContextPath()%>/resources/home/images/remove.png"
										alt="">
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="6">
								<button class="pull-left"
									onclick="location.href='<%=request.getContextPath()%>/index.html'">
									Continue Shopping</button>
								
							</td>
						</tr>
					</tfoot>
				</table>
				<div class="clearfix"></div>
				<div class="row">
					<div class="col-md-4 col-sm-6"></div>
					<div class="col-md-4 col-sm-6"></div>
					<div class="col-md-4 col-sm-6">
						<div class="shippingbox">
							<div class="grandtotal">
								<h5>GRAND TOTAL</h5>
								
								<span><fmt:formatNumber type="number" pattern="###,###"
											value="${sessionScope.cart.getTotal() }" />
										VNĐ</span>
							</div>
							<button class="pull-left"
								onclick="location.href='<%=request.getContextPath()%>/checkout'">
								Checkout</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>