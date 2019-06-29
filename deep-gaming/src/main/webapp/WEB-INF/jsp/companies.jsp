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
	<c:forEach items="${companies}" var="company">

		<section class="container">
			<div class="row">
				<div class="col-sm-6 col-md-3" style="padding- bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<div class="col-sm-6 col-md-3">
								<div class="thumbnail" style="width: 300px; height: auto">
									<img class="img-thumbnail" style="width: 300px; height: 200px;"
										src="<c:url value="/img/company${company.name}.png">
 </c:url>"
										alt="image" />

									<div class="caption">
										<h3>${company.name}</h3>
										<p>${company.description}</p>
										<p>${company.hyperlink}</p>
										<%-- 										<p>Available ${product.unitsInStock} units in stock</p> --%>
										<!-- 										<p> -->
										<!-- 											<a -->
										<%-- 												href=" <spring:url value="/market/product?id=${product.productId}" /> " --%>
										<!-- 												class="btn btn-primary"> <span -->
										<!-- 												class="glyphicon-info-sign glyphicon" /></span> Details -->
										<!-- 											</a> -->
										<!-- 										</p> -->
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>

	</c:forEach>


	<jsp:include page="scripts.jsp" />


</body>
</html>