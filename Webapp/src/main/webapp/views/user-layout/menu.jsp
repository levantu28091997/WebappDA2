<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="header">
	<div class="container">
		<div class="row">
			<div class="col-md-2 col-sm-2">
				<div class="logo">
					<a href="index.html"><img
						src="<%=request.getContextPath()%>/resources/home/images/logo.png"
						alt="FlatShop"></a>
				</div>
			</div>
			<div class="col-md-10 col-sm-10">
				<div class="header_top">
					<div class="row">
						<div class="col-md-3">
							<ul class="option_nav">
								<li class="dorpdown"><a href="#">Eng</a>
									<ul class="subnav">
										<li><a href="#">Eng</a></li>
										<li><a href="#">Vns</a></li>
										<li><a href="#">Fer</a></li>
										<li><a href="#">Gem</a></li>
									</ul></li>
								<li class="dorpdown"><a href="#">USD</a>
									<ul class="subnav">
										<li><a href="#">USD</a></li>
										<li><a href="#">UKD</a></li>
										<li><a href="#">FER</a></li>
									</ul></li>
							</ul>
						</div>
						<div class="col-md-6">
							<ul class="topmenu">
								<li><a href="#">About Us</a></li>
								<li><a href="#">News</a></li>
								<li><a href="#">Service</a></li>
								<li><a href="#">Recruiment</a></li>
								<li><a href="#">Media</a></li>
								<li><a href="#">Support</a></li>
							</ul>
						</div>
						<div class="col-md-3">
							<ul class="usermenu">

								<c:if test="${sessionScope.USER!=null }">
									<li><a class="log">Xin chào
											${sessionScope.USER.getName()}</a><a
										href="<%=request.getContextPath()%>/userlogout">Logout</a></li>
								</c:if>
								<c:if test="${sessionScope.USER==null}">
									<li><a href="<%=request.getContextPath()%>/login"
										class="log">Login</a></li>

								</c:if>
								<li><a href="<%=request.getContextPath()%>/register"
									class="reg">Register</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
				<div class="header_bottom">
					<ul class="option">
						<li id="search" class="search">
							<form>
								<input class="search-submit" type="submit" value=""><input
									class="search-input" placeholder="Enter your search term..."
									type="text" value="" name="search">
							</form>
						</li>
						<li class="option-cart"><a
							href="<%=request.getContextPath()%>/cart" class="cart-icon">cart
								<span class="cart_no"></span>
						</a></li>
					</ul>
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span><span
								class="icon-bar"></span><span class="icon-bar"></span><span
								class="icon-bar"></span>
						</button>
					</div>
					<div class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li class="active dropdown"><a href="#"
								class="dropdown-toggle" data-toggle="dropdown">Home</a>
								<div class="dropdown-menu">
									<ul class="mega-menu-links">
										<li><a href="index.html">home</a></li>
										<li><a href="home2.html">home2</a></li>
										<li><a href="home3.html">home3</a></li>
										<li><a href="productlitst.html">Productlitst</a></li>
										<li><a href="productgird.html">Productgird</a></li>
										<li><a href="details.html">Details</a></li>
										<li><a href="cart.html">Cart</a></li>
										<li><a href="checkout.html">CheckOut</a></li>
										<li><a href="checkout2.html">CheckOut2</a></li>
										<li><a href="contact.html">contact</a></li>
									</ul>
								</div></li>
							<li><a href="productgird.html">men</a></li>
							<li><a href="productlitst.html">women</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Fashion</a>
								<div class="dropdown-menu mega-menu">
									<div class="row">
										<div class="col-md-6 col-sm-6">
											<ul class="mega-menu-links">
												<li><a href="productgird.html">New Collection</a></li>
												<li><a href="productgird.html">Shirts & tops</a></li>
												<li><a href="productgird.html">Laptop & Brie</a></li>
												<li><a href="productgird.html">Dresses</a></li>
												<li><a href="productgird.html">Blazers & Jackets</a></li>
												<li><a href="productgird.html">Shoulder Bags</a></li>
											</ul>
										</div>
										<div class="col-md-6 col-sm-6">
											<ul class="mega-menu-links">
												<li><a href="productgird.html">New Collection</a></li>
												<li><a href="productgird.html">Shirts & tops</a></li>
												<li><a href="productgird.html">Laptop & Brie</a></li>
												<li><a href="productgird.html">Dresses</a></li>
												<li><a href="productgird.html">Blazers & Jackets</a></li>
												<li><a href="productgird.html">Shoulder Bags</a></li>
											</ul>
										</div>
									</div>
								</div></li>
							<li><a href="productgird.html">gift</a></li>
							<li><a href="productgird.html">kids</a></li>
							<li><a href="productgird.html">blog</a></li>
							<li><a href="productgird.html">jewelry</a></li>
							<li><a href="contact.html">contact us</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>