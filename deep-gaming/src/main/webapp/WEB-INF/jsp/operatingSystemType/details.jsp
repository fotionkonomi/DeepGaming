<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<jsp:include page="/WEB-INF/jsp/head.jsp" />
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/body.jsp"></jsp:include>
	<a href="?id=${operatingSystemType.id }&language=en">English</a>|
	<a href="?id=${operatingSystemType.id }&language=al">Albanian</a>

	<jsp:include page="/WEB-INF/jsp/navigation.jsp"></jsp:include>

	<div class="section">
		<!-- container -->
		<div class="container">
			<div class="col-md-5 col-md-push-2" style="left: 0.5%">
				<div class="product-preview">
					<img width="300px" height="300px"
						src="<c:url value="/img/operatingsystemtype${operatingSystemType.id}.png">
 </c:url>"
						alt="${operatingSystemType.name}"> <br /> <br />
						<p>
						<spring:message code="details.company" />
						<a
							href="/deep-gaming/company/details?id=${operatingSystemType.companyOfThisOS.id }">${operatingSystemType.companyOfThisOS.name}
						</a>
					</p>
					<a style="text-align: center;"
						href="<spring:url value="/operatingSystemType/update?id=${operatingSystemType.id }" />"
						class="btn btn-primary"> <spring:message
							code="details.update" />
					</a>
				</div>
			</div>
			<!-- /Product main img -->


			<!-- Product details -->
			<div class="col-md-5" style="width: 58%">
				<div class="product-details">
					<h2 style="color: #D10024;" class="product-name">${operatingSystemType.companyOfThisOS.name} ${operatingSystemType.name }</h2>

					<div></div>
					<div></div>
					<p>${operatingSystemType.description }</p>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/jsp/scripts.jsp" />

</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />

</html>