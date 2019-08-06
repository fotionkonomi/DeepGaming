<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<jsp:include page="head.jsp" />
</head>
<body>
	<jsp:include page="body.jsp"></jsp:include>
	<a href="?language=en">English</a>|
	<a href="?language=al">Albanian</a>

	<jsp:include page="navigation.jsp"></jsp:include>

	<section>
		<div
			style="text-align: center; color: black; padding-top: 20px; font-size: 20px;">
			<spring:message code="companies.legend" />
		</div>
	</section>
	<div class="col-md-12">
		<div class="row">
			<div class="products-tabs">
				<!-- tab -->
				<div id="tab2" class="tab-pane fade in active">
					<div id="slick-nav-2" class="products-slick-nav"></div>

					<div class="products-slick" data-nav="#slick-nav-2">
						<c:forEach items="${companies}" var="company">

							<div class="product">
								<div class="product-img">
									<img width="320px" height="270px"
										src="<c:url value="/img/company${company.name}.png">
 </c:url>"
										alt="${company.name}">

								</div>
								<div class="product-body">
									<br />
									<h2 class="product-name">
										<a style="font-size: 20px;"
											href="<spring:url value="/company/details?id=${company.id}" />">${company.name}</a>
									</h2>

								</div>
								
							</div>
						</c:forEach>

					</div>


				</div>

			</div>
		</div>
	</div>



	<jsp:include page="scripts.jsp" />

	<h6 style="opacity: 0;;">aaa</h6>
</body>
<jsp:include page="footer.jsp" />

</html>