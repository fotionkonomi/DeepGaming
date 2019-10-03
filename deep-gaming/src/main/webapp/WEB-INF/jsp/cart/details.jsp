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

	<div>
		<c:if test="${not empty cart.cartItemDTOs }">
			<button id="clearAll" class="btn btn-danger pull-left"
				onclick="deleteAllCartItems();">
				<span class="glyphicon glyphicon-remove-sign"></span> <spring:message code="details.cart.clearCart" />
			</button>
		</c:if>
	</div>
	<table class="table table-hover">
		<tr>
			<th><spring:message code="details.cart.product" /></th>
			<th><spring:message code="details.cart.unitPrice" /></th>
			<th><spring:message code="details.cart.quantity" /></th>
			<th><spring:message code="details.cart.price" /></th>
			<th><spring:message code="details.cart.action" /></th>
		</tr>
		
		<c:forEach items="${cart.cartItemDTOs }" var="cartItem">
			<tr class="itemRows" id="row${cartItem.id }">
				<td>${cartItem.product.name }</td>
				<td>$${cartItem.product.price }</td>
				<td>${cartItem.quantity }</td>
				<td>$${cartItem.quantity * cartItem.product.price}</td>
				<td>
					<button class="btn btn-danger delete-btn" id=${cartItem.id }
						onclick="deleteCartItem(${cartItem.id});"><spring:message code="details.cart.deleteItem" /></button>
				</td>
			</tr>
		</c:forEach>
		<c:if test="${not empty cart.cartItemDTOs }">

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>

					<button id="reserve" type="button" class="btn btn-info" onclick="reserve();">
						<span class="glyphicon glyphicon-shopping-cart"></span> <spring:message code="details.cart.reserve" />
					</button>
				</td>
			</tr>
		</c:if>
	</table>


	<a href="<spring:url value="/" />" class="btn btn-default"> <span
		class="glyphicon-hand-left glyphicon"></span> <spring:message code="details.cart.continueShopping" />
	</a>

	<jsp:include page="/WEB-INF/jsp/scripts.jsp" />

</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
<script src="<c:url value="/js/cart.js"></c:url>"></script>

</html>
