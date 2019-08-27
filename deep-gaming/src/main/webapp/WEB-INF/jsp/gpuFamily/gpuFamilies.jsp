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
			<spring:message code="gpuFamilies.legend" />
		</div>
	</section>
	<div class="col-md-12">
		<div class="row">
			<div class="products-tabs">
				<!-- tab -->
				<div id="tab2" class="tab-pane fade in active">
					<div id="slick-nav-2" class="products-slick-nav"></div>

					<div class="products-slick" data-nav="#slick-nav-2">
						<c:forEach items="${gpuFamilies}" var="gpuFamily">

							<div class="product">
								<div class="product-img">
									<img width="420px" height="240px"
										src="<c:url value="/img/gpufamily${gpuFamily.id}.png">
 </c:url>"
										alt="${gpuFamily.name}">

								</div>
								<div class="product-body">
									<br />
									<h2 class="product-name">
										<a style="font-size: 20px;"
											href="<spring:url value="/gpuFamily/details?id=${gpuFamily.id}" />">${gpuFamily.companyOfThisGpuFamily.name}
											${gpuFamily.name}</a>
									</h2>

								</div>

							</div>
						</c:forEach>

					</div>


				</div>

			</div>
		</div>
	</div>


	<h6 style="opacity: 0;">aaa</h6>

	<hr />
	<c:if test="${not empty companies}">

		<section>
			<div
				style="text-align: center; color: black; padding-top: 20px; font-size: 20px;">
				<spring:message code="gpuFamilies.company.legend" />
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
										<img width="420px" height="240px"
											src="<c:url value="/img/company${company.id}.png">
 </c:url>"
											alt="${company.name}">

									</div>
									<div class="product-body">
										<br />
										<h2 class="product-name">
											<a style="font-size: 20px;"
												href="<spring:url value="/gpuFamily/gpuFamilies/${company.name} " />">
												${company.name}</a>
										</h2>

									</div>

								</div>
							</c:forEach>

						</div>


					</div>

				</div>
			</div>
		</div>
		<h6 style="opacity: 0;">aaa</h6>
	</c:if>
	<jsp:include page="/WEB-INF/jsp/scripts.jsp" />

</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />

</html>