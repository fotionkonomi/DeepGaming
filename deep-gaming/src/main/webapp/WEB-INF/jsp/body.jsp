
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<!-- HEADER -->
<header>
	<!-- TOP HEADER -->

	<!-- /TOP HEADER -->

	<!-- MAIN HEADER -->
	<div id="header">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<!-- LOGO -->
				<div class="col-md-3">
					<div class="header-logo">
						<a href="#" class="logo"> <img
							src="<c:url value="/img/logo.png" />" alt="">
						</a>
					</div>
				</div>
				<!-- /LOGO -->

				<!-- SEARCH BAR -->
				<div class="col-md-6">
					<div class="header-search">
						<form>
							 <input class="input" placeholder="Search here">
							<button class="search-btn">Search</button>
						</form>
					</div>
				</div>
				<!-- /SEARCH BAR -->

				<!-- ACCOUNT -->
				<div class="col-md-3 clearfix">
					<div class="header-ctn">
						<!-- Wishlist -->
						<div>
							<ul class="header-links pull-right">
								<li><a href="#"><i class="fa fa-user-o"></i> <security:authorize
											access="isAuthenticated()">
											<security:authentication property="principal.username" />
										</security:authorize></a></li>
							</ul>
						</div>
						
						<div>
							<ul class="header-links pull-right">
								<li><a href="/deep-gaming/logout"><i class="fa fa-user-o"></i>Logout</a></li>
							</ul>
						</div>
						
						
						<!-- /Wishlist -->

						<!-- Cart -->
						<div class="dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown"
								aria-expanded="true"> <i class="fa fa-shopping-cart"></i> <span>Your
									Cart</span>
							</a>
							<div class="cart-dropdown">
								<div class="cart-list">
									<div class="product-widget">
										<div class="product-img">
											<img src="<c:url value="/img/product01.png" />" alt="">
										</div>
										<div class="product-body">
											<h3 class="product-name">
												<a href="#">product name goes here</a>
											</h3>
											<h4 class="product-price">
												<span class="qty">1x</span>$980.00
											</h4>
										</div>
										<button class="delete">
											<i class="fa fa-close"></i>
										</button>
									</div>

									<div class="product-widget">
										<div class="product-img">
											<img src="<c:url value="/img/product02.png" /> " alt="">
										</div>
										<div class="product-body">
											<h3 class="product-name">
												<a href="#">product name goes here</a>
											</h3>
											<h4 class="product-price">
												<span class="qty">3x</span>$980.00
											</h4>
										</div>
										<button class="delete">
											<i class="fa fa-close"></i>
										</button>
									</div>
								</div>
								<div class="cart-summary">
									<small>3 Item(s) selected</small>
									<h5>SUBTOTAL: $2940.00</h5>
								</div>
								<div class="cart-btns">
									<a href="#">View Cart</a> <a href="#">Checkout <i
										class="fa fa-arrow-circle-right"></i></a>
								</div>
							</div>
						</div>
						<!-- /Cart -->

						<!-- Menu Toogle -->
						<div class="menu-toggle">
							<a href="#"> <i class="fa fa-bars"></i> <span>Menu</span>
							</a>
						</div>
						<!-- /Menu Toogle -->
					</div>
				</div>
				<!-- /ACCOUNT -->
			</div>
			<!-- row -->
		</div>
		<!-- container -->
	</div>
	<!-- /MAIN HEADER -->
</header>
<!-- /HEADER -->