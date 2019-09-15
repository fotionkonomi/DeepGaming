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
		<c:forEach items="${gpus }" var="gpu">

			<div class="col-md-4 col-xs-6">
				<div class="product">
					<div class="product-img">
						<img src="<c:url value="/img/gpu${gpu.id}.png">
 </c:url>"
							height="300px" alt="">

					</div>
					<div class="product-body">
						<p class="product-category">Gpu</p>
						

						<h3 class="product-name">
							<a href="<spring:url value="/gpu/details?id=${gpu.id} " />">${gpu.familyOfThisGpu.companyOfThisGpuFamily.name }
								${gpu.familyOfThisGpu.name } ${gpu.name }</a>
						</h3>
						<h4 class="product-price">$${gpu.price }</h4>
						<div class="product-btns">
							<button id="${gpu.id }" onclick="pageRedirect(${gpu.id});" class="add-to-compare">
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
						href="<spring:url value="/gpu/gpus?page=${page } " />">${page }</a></li>
				</c:if>
				<c:if test="${page != currentPage }">
					<li><a href="<spring:url value="/gpu/gpus?page=${page } " />">${page }</a></li>
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
    window.location.href = "/deep-gaming/gpu/chooseGpuToCompare?gpu="+ id;
  }
</script>

</html>