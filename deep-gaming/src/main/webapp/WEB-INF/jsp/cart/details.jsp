<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<jsp:include page="/WEB-INF/jsp/head.jsp" />
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/body.jsp"></jsp:include>
	<a href="?id=${chipset.id }&language=en">English</a>|
	<a href="?id=${chipset.id }&language=al">Albanian</a>

	<jsp:include page="/WEB-INF/jsp/navigation.jsp"></jsp:include>

	<div>
			<a class="btn btn-danger pull-left" ng-click="clearCart()"> <span
				class="glyphicon glyphicon-remove-sign"></span> Clear Cart
			</a> 
<%-- 			<a href="<spring:url value="/checkout?cartId=${cartId}"/>" --%>
<!-- 				class="btn btn-success pull-right"> <span -->
<!-- 				class="glyphicon-shopping-cart glyphicon"></span> Check out -->
<!-- 			</a> -->
		</div>
		<table class="table table-hover">
			<tr>
				<th>Product</th>
				<th>Unit price</th>
				<th>Qauntity</th>
				<th>Price</th>
				<th>Action</th>
			</tr>
<%-- 			<c:forEach var=""> --%>
<!-- 			<tr ng-repeat="item in cart.cartItems"> -->
<!-- 				<td>{{item.product.productId}}-{{item.product.name}}</td> -->
<!-- 				<td>{{item.product.unitPrice}}</td> -->
<!-- 				<td>{{item.quantity}}</td> -->
<!-- 				<td>{{item.totalPrice}}</td> -->
<!-- 				<td><a href="#" class="label label-danger" -->
<!-- 					ng-click="removeFromCart(item.product.productId)"> <span -->
<!-- 						class="glyphicon glyphicon-remove" /></span> Remove -->
<!-- 				</a></td> -->
<!-- 			</tr> -->
<%-- 			</c:forEach> --%>
			<tr>
				<th></th>
				<th></th>
				<th>Grand Total</th>
				<th>{{cart.grandTotal}}</th>
				<th></th>
			</tr>
		</table>

		<a href="<spring:url value="/market/products" />"
			class="btn btn-default"> <span
			class="glyphicon-hand-left glyphicon"></span> Continue shopping
		</a>
	</div>

	<jsp:include page="/WEB-INF/jsp/scripts.jsp" />

</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />

</html>