<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<jsp:include page="/WEB-INF/jsp/head.jsp" />
<link type="text/css" rel="stylesheet"
	href="<c:url value="/css/table.css"/>" />

</head>
<body>
	<jsp:include page="/WEB-INF/jsp/body.jsp"></jsp:include>
	<a href="?page=${currentPage }&language=en">English</a>|
	<a href="?page=${currentPage }&language=al">Albanian</a>

	<jsp:include page="/WEB-INF/jsp/navigation.jsp"></jsp:include>

	<!-- store products -->
	<div class="row">
		<!-- product -->
		<c:forEach items="${cpus }" var="cpu">

			<div class="col-md-4 col-xs-6">
				<div class="product">
					<div class="product-img">
						<img src="<c:url value="/img/cpu${cpu.id}.png">
 </c:url>"
							height="300px" alt="">

					</div>
					<div class="product-body">
						<p class="product-category">Cpu</p>
						

						<h3 class="product-name">
							<a href="<spring:url value="/cpu/details?id=${cpu.id} " />">${cpu.familyOfThisCpu.companyOfThisCpuFamily.name }
								${cpu.familyOfThisCpu.name } ${cpu.name }</a>
						</h3>
						<h4 class="product-price">$${cpu.price }</h4>
						<div class="product-btns">
							<button id="${cpu.id }" onclick="pageRedirect(${cpu.id});" class="add-to-compare">
								<i class="fa fa-exchange"></i><span class="tooltipp">add
									to compare</span>
							</button>
							
						</div>


					</div>
					<div class="add-to-cart">
						<button class="add-to-cart-btn">
							<i class="fa fa-shopping-cart"></i>
							<spring:message code="details.product.addToCart" />
						</button>
					</div>
				</div>
			</div>
		</c:forEach>

	</div>
	<div class="store-filter clearfix">
		<ul class="store-pagination">
			<c:forEach items="${pageNumbers}" var="page">
				<c:if test="${page == currentPage }">
					<li class="active"><a
						href="<spring:url value="/cpu/cpus?page=${page } " />">${page }</a></li>
				</c:if>
				<c:if test="${page != currentPage }">
					<li><a href="<spring:url value="/cpu/cpus?page=${page } " />">${page }</a></li>
				</c:if>
			</c:forEach>

		</ul>
	</div>
	<!-- /store bottom filter -->
	<!-- /STORE -->


	<jsp:include page="/WEB-INF/jsp/scripts.jsp" />
</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />

<script>
function pageRedirect(id) {
    window.location.href = "/deep-gaming/cpu/chooseCpuToCompare?cpu="+ id;
  }
</script>

</html>