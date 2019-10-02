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
	<a href="?id=${cpu.id }&language=en">English</a>|
	<a href="?id=${cpu.id }&language=al">Albanian</a>

	<jsp:include page="/WEB-INF/jsp/navigation.jsp"></jsp:include>

	<div class="section">
		<!-- container -->
		<div class="container">
			<div class="col-md-5 col-md-push-2" style="left: 0.5%">
				<div class="product-preview">
					<img width="300px" height="300px"
						src="<c:url value="/img/cpu${cpu.id}.png">
 </c:url>"
						alt="${cpu.name}"> <br /> <a style="text-align: center;"
						href="<spring:url value="/cpu/update?id=${cpu.id }" />"
						class="btn btn-primary"> <spring:message code="details.update" />
					</a> <a style="text-align: center;"
						href="<spring:url value="/cpu/chooseCpuToCompare?cpu=${cpu.id }" />"
						class="btn btn-primary"> <spring:message
							code="details.compare" />
					</a>
				</div>
			</div>
			<!-- /Product main img -->


			<!-- Product details -->
			<div class="col-md-5" style="width: 58%">
				<div class="product-details">
					<h2 style="color: #D10024;" class="product-name">${cpu.familyOfThisCpu.companyOfThisCpuFamily.name }
						${cpu.familyOfThisCpu.name } ${cpu.name }</h2>

					<div>
						<c:if test="${cpu.price != null && cpu.quantity != 0}">
							<h3 class="product-price">$${cpu.price }</h3>
							<div class="add-to-cart">

								<button class="add-to-cart-btn"  onclick="addCartItem(${cpu.id});">
									<i class="fa fa-shopping-cart"></i>
									<spring:message code="details.product.addToCart" />
								</button>
							</div>
						</c:if>
						<c:if
							test="${cpu.price == null || (cpu.price != null && cpu.quantity == 0)}">
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
							href="<spring:url value="/company/details?id=${cpu.familyOfThisCpu.companyOfThisCpuFamily.id }" />">${cpu.familyOfThisCpu.companyOfThisCpuFamily.name }</a></li>
					</ul>

					<ul class="product-links">
						<li><spring:message code="details.cpu.cpuFamily" /></li>
						<li><a
							href="<spring:url value="/cpuFamily/details?id=${cpu.familyOfThisCpu.id }" />">${cpu.familyOfThisCpu.name }</a></li>
					</ul>
					<br />
					<div>
						<spring:message code="details.moreInformation" />
						<a href="${cpu.hyperlink }"> <spring:message
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
									<p>${cpu.description }</p>
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
																		code="add.form.cpuSpeed.label" /></td>
																<td class="column2">${cpu.cpuSpeed }GHz</td>
															</tr>
															<tr>
																<td class="column1"><spring:message
																		code="add.form.turboSpeed.label" /></td>
																<td class="column2">${cpu.turboSpeed }GHz</td>

															</tr>
															<tr>
																<td class="column1"><spring:message
																		code="add.form.physicalCores.label" /></td>
																<td class="column2">${cpu.physicalCores }</td>

															</tr>
															<tr>
																<td class="column1"><spring:message
																		code="add.form.threads.label" /></td>
																<td class="column2">${cpu.threads }</td>

															</tr>
															<tr>
																<td class="column1"><spring:message
																		code="addCpu.form.architectureOfThisCpu.label" /></td>
																<td class="column2">${cpu.architectureOfThisCpu.name }</td>

															</tr>
															<tr>
																<td class="column1"><spring:message
																		code="addArchitecture.form.process.label" /></td>
																<td class="column2">${cpu.architectureOfThisCpu.cpuProcessNanometers }nm</td>

															</tr>
															<tr>
																<td class="column1"><spring:message
																		code="addCpu.form.socketOfThisCpu.label" /></td>
																<td class="column2">${cpu.socketOfThisCpu.name }</td>

															</tr>
															<tr>
																<td class="column1">Laptop/Desktop</td>
																<c:if
																	test="${cpu.socketOfThisCpu.laptopOrDesktop == true}">
																	<td class="column2">Laptop</td>

																</c:if>

																<c:if
																	test="${cpu.socketOfThisCpu.laptopOrDesktop == false}">
																	<td class="column2">Desktop</td>

																</c:if>

															</tr>
															<tr>
																<td class="column1"><spring:message
																		code="add.form.cpuBenchmark.label" /></td>
																<td class="column2">${cpu.cpuBenchmark }</td>

															</tr>
															<tr>
																<td class="column1"><spring:message
																		code="add.form.tdp.label" /></td>
																<td class="column2">${cpu.tdp }W</td>

															</tr>
															<tr>
																<td class="column1"><spring:message
																		code="add.form.bitWidth.label" /></td>
																<td class="column2">${cpu.bitWidth }bit</td>

															</tr>
															<tr>
																<td class="column1"><spring:message
																		code="add.form.l1Cache.label" /></td>
																<td class="column2">${cpu.l1Cache }KB</td>

															</tr>
															<tr>
																<td class="column1"><spring:message
																		code="add.form.l2Cache.label" /></td>
																<td class="column2">${cpu.l2Cache }KB</td>

															</tr>
															<tr>
																<td class="column1"><spring:message
																		code="add.form.l3Cache.label" /></td>
																<td class="column2">${cpu.l3Cache }KB</td>

															</tr>
															<tr>
																<td class="column1"><spring:message
																		code="add.form.releaseDate.label" /></td>
																<td class="column2">${cpu.releaseDate }</td>


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