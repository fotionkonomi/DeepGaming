<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<jsp:include page="/WEB-INF/jsp/head.jsp" />
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/body.jsp"></jsp:include>
	<a href="?language=en">English</a>|
	<a href="?language=al">Albanian</a>

	<jsp:include page="/WEB-INF/jsp/navigation.jsp"></jsp:include>

	<section>
		<div
			style="text-align: center; color: black; padding-top: 20px; font-size: 20px;">
			<spring:message code="chipsets.legend" />
		</div>
	</section>
	<div class="col-md-12">
		<div class="row">
			<div class="products-tabs">
				<!-- tab -->
				<div id="tab2" class="tab-pane fade in active">
					<div id="slick-nav-2" class="products-slick-nav"></div>

					<div class="products-slick" data-nav="#slick-nav-2">
						<c:forEach items="${chipsets}" var="chipset">

							<div class="product">
								<div class="product-img">
									<img width="420px" height="240px"
										src="<c:url value="/img/chipset${chipset.id}.png">
 </c:url>"
										alt="${chipset.name}">

								</div>
								<div class="product-body">
									<br />
									<h2 class="product-name">
										<a style="font-size: 20px;"
											href="<spring:url value="/chipset/details?id=${chipset.id}" />">${chipset.name}</a>
									</h2>

								</div>
								
							</div>
						</c:forEach>

					</div>


				</div>

			</div>
		</div>
	</div>



	<jsp:include page="/WEB-INF/jsp/scripts.jsp" />

	<h6 style="opacity: 0;;">aaa</h6>
</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />

</html>