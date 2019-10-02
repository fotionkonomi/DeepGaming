<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>


<jsp:include page="/WEB-INF/jsp/head.jsp" />
<link type="text/css" rel="stylesheet"
	href="<c:url value="/css/fileupload.css"/>" />

</head>
<body>
	<jsp:include page="/WEB-INF/jsp/body.jsp"></jsp:include>

	<jsp:include page="/WEB-INF/jsp/navigation.jsp"></jsp:include>



	<c:forEach items="${reservations }" var="cart">
		<center>
			<h2 class="table${cart.id }">Reserved by : ${cart.user.username }</h2>
		</center>
		<table class="table table-hover table${cart.id }">
			<tr>
				<th>Product</th>
				<th>Unit price</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Action</th>
			</tr>

			<c:forEach items="${cart.cartItemDTOs }" var="cartItem">
				<tr class="itemRows" id="row${cartItem.id }">
					<td>${cartItem.product.name }</td>
					<td>$${cartItem.product.price }</td>
					<td>${cartItem.quantity }</td>
					<td>$${cartItem.quantity * cartItem.product.price}</td>
					<td>
						<button class="btn btn-danger delete-btn" id=${cartItem.id }
							onclick="deleteCartItem(${cartItem.id});">Delete item</button>
					</td>
				</tr>


			</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td>
					<button id="reserve" type="button" class="btn btn-danger"
						onclick="cancelReservation(${cart.id});">Cancel
						Reservation</button>
				</td>
				<td>

					<button id="reserve" type="button" class="btn btn-info"
						onclick="confirmPurchase(${cart.id});">
						<span class="glyphicon glyphicon-shopping-cart"></span> Confirm
						Purchase
					</button>
				</td>
			</tr>
		</table>
		<hr>
	</c:forEach>

	<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>

	<jsp:include page="/WEB-INF/jsp/scripts.jsp" />

	<script src="<c:url value="/js/cart.js"></c:url>"></script>


</body>
</html>
