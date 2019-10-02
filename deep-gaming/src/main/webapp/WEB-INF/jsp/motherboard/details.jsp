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
	<a href="?id=${motherboard.id }&language=en">English</a>|
	<a href="?id=${motherboard.id }&language=al">Albanian</a>

	<jsp:include page="/WEB-INF/jsp/navigation.jsp"></jsp:include>

	<div class="section">
		<!-- container -->
		<div class="container">
			<div class="col-md-5 col-md-push-2" style="left: 0.5%">
				<div class="product-preview">
					<img width="300px" height="300px"
						src="<c:url value="/img/motherboard${motherboard.id}.png">
 </c:url>"
						alt="${motherboard.name}"> <br /> <a
						style="text-align: center;"
						href="<spring:url value="/motherboard/update?id=${motherboard.id }" />"
						class="btn btn-primary"> <spring:message code="details.update" />
					</a>
				</div>
			</div>
			<!-- /Product main img -->


			<!-- Product details -->
			<div class="col-md-5" style="width: 58%">
				<div class="product-details">
					<h2 style="color: #D10024;" class="product-name">${motherboard.companyOfThisMotherboard.name }
						${motherboard.name }</h2>

					<div>
						<c:if
							test="${motherboard.price != null && motherboard.quantity != 0}">
							<h3 class="product-price">$${motherboard.price }</h3>
							<div class="add-to-cart">

								<button class="add-to-cart-btn" onclick="addCartItem(${motherboard.id});">
									<i class="fa fa-shopping-cart"></i>
									<spring:message code="details.product.addToCart" />
								</button>
							</div>
						</c:if>
						<c:if
							test="${motherboard.price == null || (motherboard.price != null && motherboard.quantity == 0)}">
							<h3 class="product-price">
								<spring:message code="details.product.notInStock" />
							</h3>
						</c:if>

					</div>



					<div></div>
					<div></div>
					<ul class="product-links">
						<li><spring:message code="details.cpu.company" /></li>
						<li><a
							href="<spring:url value="/company/details?id=${motherboard.companyOfThisMotherboard.id }" />">${motherboard.companyOfThisMotherboard.name }</a></li>
					</ul>

					<ul class="product-links">

						<li><spring:message code="details.motherboard.formFactor" /></li>
						<li><a
							href="<spring:url value="/motherboardFormFactor/details?id=${motherboard.formFactorOfThisMotherboard.id }" /> ">${motherboard.formFactorOfThisMotherboard.name }
						</a></li>

					</ul>

					<br />
					<div>
						<spring:message code="details.moreInformation" />
						<a href="${motherboard.hyperlink }"> <spring:message
								code="details.clickHere" />
						</a>
					</div>

				</div>
			</div>

			<!-- Product tab -->
			<div class="col-md-12">
				<div id="product-tab">
					<!-- product tab nav -->
					<ul class="tab-nav">
						<li class="active"><a data-toggle="tab" href="#tab1"><spring:message
									code="add.form.description.label" /></a></li>
						<li><a data-toggle="tab" href="#tab2"><spring:message
									code="details" /></a></li>
					</ul>
					<!-- /product tab nav -->

					<!-- product tab content -->
					<div class="tab-content">
						<!-- tab1  -->
						<div id="tab1" class="tab-pane fade in active">
							<div class="row">
								<div class="col-md-12">
									<p>${motherboard.description }</p>
								</div>
							</div>
						</div>
						<!-- /tab1  -->

						<!-- tab2  -->
						<div id="tab2" class="tab-pane fade in">
							<div class="row">
								<div class="col-md-12">
									<div class="limiter">
										<div class="container-table100">
											<div class="wrap-table100">
												<div class="table100">
													<table>
														<tbody>
															<tr>
																<td class="column1"><spring:message
																		code="addMotherboard.form.cpuSocket.label" /></td>
																<td class="column2">${motherboard.cpuSocketOfThisMotherboard.name }</td>
															</tr>
															<tr>
																<td class="column1"><spring:message
																		code="addMotherboard.form.gpuSlotOfThisMotherboard.label" /></td>
																<td class="column2">${motherboard.gpuSlotOfThisMotherboard.name }</td>
															</tr>
															<tr>
																<td class="column1"><spring:message
																		code="add.form.maximumRamCapacity.label" /></td>
																<td class="column2">${motherboard.maximumRamCapacity }GB</td>
															</tr>

															<tr>
																<td class="column1"><spring:message
																		code="add.form.maximumRamSpeed.label" /></td>
																<td class="column2">${motherboard.maximumRamSpeed }MHz</td>

															</tr>




															<tr>
																<td class="column1">Laptop/Desktop</td>
																<c:if
																	test="${motherboard.cpuSocketOfThisMotherboard.laptopOrDesktop == true}">
																	<td class="column2">Laptop</td>

																</c:if>

																<c:if
																	test="${motherboard.cpuSocketOfThisMotherboard.laptopOrDesktop == false}">
																	<td class="column2">Desktop</td>

																</c:if>

															</tr>



															<tr>
																<td class="column1"><spring:message
																		code="add.form.releaseDate.label" /></td>
																<td class="column2">${motherboard.releaseDate }</td>


															</tr>


														</tbody>
													</table>
												</div>
											</div>
										</div>
										<!-- /tab2  -->
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/jsp/scripts.jsp" />
</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
		<script src="<c:url value="/js/cart.js"></c:url>"></script>



</html>