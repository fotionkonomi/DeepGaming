
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
						
								<div class="cart-btns">
									<a href="<spring:url value="/cart/details" />">View Cart</a> 
										
								</div>
							</div>
						</div>
						<!-- /Cart -->

					
					</div>
				</div>
				<!-- /ACCOUNT -->
			</div>
			<!-- row -->
		</div>
		<!-- container -->
	<!-- /MAIN HEADER -->
</header>
<!-- /HEADER -->