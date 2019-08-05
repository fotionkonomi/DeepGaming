<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<jsp:include page="head.jsp" />
</head>
<body>
	<jsp:include page="body.jsp"></jsp:include>

	<section>
		<div class="jumbotron">
			<div class="container">
				<h2>Companies</h2>
			</div>
		</div>
	</section>
	<div class="col-md-12">
		<div class="row">
			<div class="products-tabs">
				<!-- tab -->
				<div id="tab2" class="tab-pane fade in active">
					<div class="products-slick" data-nav="#slick-nav-2">
						<c:forEach items="${companies}" var="company">

							<div class="product">
								<div class="product-img">
									<img width="200px" height="200px"
										src="<c:url value="/img/company${company.name}.png">
 </c:url>"
										alt="">
									<div class="product-label">
										<span class="sale">-30%</span> <span class="new">NEW</span>
									</div>
								</div>
								<div class="product-body">
									<p class="product-category">Category</p>
									<h3 class="product-name">
										<a href="#">${company.name}</a>
									</h3>
									<h4 class="product-price">
										$980.00
										<del class="product-old-price">$990.00</del>
									</h4>
									<div class="product-rating"></div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>



	<jsp:include page="scripts.jsp" />


</body>
</html>