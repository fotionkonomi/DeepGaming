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
		<c:forEach items="${games }" var="game">

			<div class="col-md-4 col-xs-6">
				<div class="product">
					<div class="product-img">
						<img src="<c:url value="/img/game${game.id}.png">
 </c:url>"
							height="300px" alt="">

					</div>
					<div class="product-body">
						<p class="product-category"><spring:message code="category.game" /></p>


						<h3 class="product-name">
							<a href="<spring:url value="/game/details?id=${game.id} " />">${game.name}</a>
						</h3>
						<h4 class="product-price">$${game.price }</h4>
						<div class="product-btns">
							<button id="${game.id }"
								class="add-to-compare">
								<i class="fa fa-exchange"></i><span class="tooltipp"><spring:message
										code="details.compare" /></span>
							</button>
							

						</div>


					</div>
					<div class="add-to-cart">
						<c:if test="${game.quantity > 0 }">

							<button class="add-to-cart-btn" onclick="addCartItem(${game.id});">
								<i class="fa fa-shopping-cart"></i>
								<spring:message code="details.product.addToCart" />
							</button>
						</c:if>

						<c:if test="${game.quantity == 0 }">
							<h3 style="color: red;">Out Of Stock</h3>
						</c:if>
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
						href="<spring:url value="/game/games?page=${page } " />">${page }</a></li>
				</c:if>
				<c:if test="${page != currentPage }">
					<li><a href="<spring:url value="/game/games?page=${page } " />">${page }</a></li>
				</c:if>
			</c:forEach>

		</ul>
	</div>
	<!-- /store bottom filter -->
	<!-- /STORE -->


	<jsp:include page="/WEB-INF/jsp/scripts.jsp" />
</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
<script src="<c:url value="/js/cart.js"></c:url>"></script>



</html>