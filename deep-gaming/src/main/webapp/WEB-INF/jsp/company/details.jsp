<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<jsp:include page="/WEB-INF/jsp/head.jsp" />
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/body.jsp"></jsp:include>
	<a href="?id=${company.id }&language=en">English</a>|
	<a href="?id=${company.id }&language=al">Albanian</a>

	<jsp:include page="/WEB-INF/jsp/navigation.jsp"></jsp:include>

	<div class="section">
		<!-- container -->
		<div class="container">
			<div class="col-md-5 col-md-push-2" style="left: 0.5%">
				<div class="product-preview">
					<img width="300px" height="300px"
						src="<c:url value="/img/company${company.id}.png">
 </c:url>"
						alt="${company.name}"> <br /> <br />
					<p>
						<spring:message code="details.moreInformation" />
						<a href="${company.hyperlink }"> <spring:message
								code="details.clickHere" />
						</a>
					</p>
					<a style="text-align: center;"
						href="<spring:url value="/company/update?id=${company.id }" />"
						class="btn btn-primary"> <spring:message
							code="details.update" />
					</a>
				</div>
			</div>
			<!-- /Product main img -->


			<!-- Product details -->
			<div class="col-md-5" style="width: 58%">
				<div class="product-details">
					<h2 style="color: #D10024;" class="product-name">${company.name }</h2>

					<div></div>
					<div></div>
					<p>${company.description }</p>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/jsp/scripts.jsp" />

</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />

</html>