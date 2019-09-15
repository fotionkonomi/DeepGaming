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
	<a href="?id=${gpu.id }&language=en">English</a>|
	<a href="?id=${gpu.id }&language=al">Albanian</a>

	<jsp:include page="/WEB-INF/jsp/navigation.jsp"></jsp:include>

	<div class="section">
		<!-- container -->
		<div class="container">
			<div class="col-md-5 col-md-push-2" style="left: 0.5%">
				<div class="product-preview">
					<img width="300px" height="300px"
						src="<c:url value="/img/gpu${gpu.id}.png">
 </c:url>"
						alt="${gpu.name}"> <br /> <a style="text-align: center;"
						href="<spring:url value="/gpu/update?id=${gpu.id }" />"
						class="btn btn-primary"> <spring:message code="details.update" />
					</a> <a style="text-align: center;"
						href="<spring:url value="/gpu/chooseGpuToCompare?gpu=${gpu.id }" />"
						class="btn btn-primary"> <spring:message
							code="details.compare" />
					</a>
				</div>
			</div>
			<!-- /Product main img -->


			<!-- Product details -->
			<div class="col-md-5" style="width: 58%">
				<div class="product-details">
					<h2 style="color: #D10024;" class="product-name">${gpu.familyOfThisGpu.companyOfThisGpuFamily.name }
						${gpu.familyOfThisGpu.name } ${gpu.name }</h2>

					<div>
						<c:if test="${gpu.price != null && gpu.quantity != 0}">
							<h3 class="product-price">$${gpu.price }</h3>
							<div class="add-to-cart">

								<button class="add-to-cart-btn">
									<i class="fa fa-shopping-cart"></i>
									<spring:message code="details.product.addToCart" />
								</button>
							</div>
						</c:if>
						<c:if
							test="${gpu.price == null || (gpu.price != null && gpu.quantity == 0)}">
							<h3 class="product-price">
								<spring:message code="details.product.notInStock" />
							</h3>
						</c:if>

					</div>



					<div></div>
					<div></div>
					<ul class="product-links">
						<li><spring:message code="details.gpu.company" /></li>
						<li><a
							href="<spring:url value="/company/details?id=${gpu.familyOfThisGpu.companyOfThisGpuFamily.id }" />">${gpu.familyOfThisGpu.companyOfThisGpuFamily.name }</a></li>
					</ul>

					<ul class="product-links">
						<li><spring:message code="details.gpu.gpuFamily" /></li>
						<li><a
							href="<spring:url value="/gpuFamily/details?id=${gpu.familyOfThisGpu.id }" />">${gpu.familyOfThisGpu.name }</a></li>
					</ul>
					<br />
					<div>
						<spring:message code="details.moreInformation" />
						<a href="${gpu.hyperlink }"> <spring:message
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
									<p>${gpu.description }</p>
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
																		code="add.form.gpuBenchmark.label" /></td>
																<td class="column2">${gpu.gpuBenchmark }</td>

															</tr>

															<tr>
																<td class="column1"><spring:message
																		code="addGpu.form.architectureOfThisGpu.label" /></td>
																<td class="column2">${gpu.architectureOfThisGpu.name }</td>

															</tr>
															<tr>
																<td class="column1"><spring:message
																		code="addArchitecture.form.process.label" /></td>
																<td class="column2">${gpu.architectureOfThisGpu.gpuProcessNanometers }nm</td>

															</tr>
															<tr>
																<td class="column1"><spring:message
																		code="add.form.coreSpeed.label" /></td>
																<td class="column2">${gpu.coreSpeed }MHz</td>
															</tr>
															<tr>
																<td class="column1"><spring:message
																		code="add.form.boostClock.label" /></td>
																<td class="column2">${gpu.boostClock }MHz</td>

															</tr>
															<tr>
																<td class="column1"><spring:message
																		code="add.form.shaderProcessingUnits.label" /></td>
																<td class="column2">${gpu.shaderProcessingUnits }</td>

															</tr>
															<tr>
																<td class="column1"><spring:message
																		code="add.form.rayTracingCores.label" /></td>
																<td class="column2">${gpu.rayTracingCores }</td>

															</tr>


															<tr>
																<td class="column1"><spring:message
																		code="add.form.tensorCores.label" /></td>
																<td class="column2">${gpu.tensorCores }</td>

															</tr>



															<tr>
																<td class="column1"><spring:message
																		code="add.form.tmu.label" /></td>
																<td class="column2">${gpu.tmu }</td>

															</tr>
															<tr>
																<td class="column1"><spring:message
																		code="add.form.textureRate.label" /></td>
																<td class="column2">${gpu.textureRate }GTexel/s</td>

															</tr>

															<tr>
																<td class="column1"><spring:message
																		code="add.form.pixelRate.label" /></td>
																<td class="column2">${gpu.pixelRate }GPixel/s</td>

															</tr>

															<tr>
																<td class="column1"><spring:message
																		code="add.form.driverSupport.label" /></td>
																<td class="column2">${gpu.driverSupport }</td>

															</tr>

															<tr>
																<td class="column1"><spring:message
																		code="add.form.driverSupport.label" /></td>
																<td class="column2">${gpu.driverSupport }</td>

															</tr>



															<tr>
																<td class="column1"><spring:message
																		code="addGpu.form.gpuMemoryTechnology.label" /></td>
																<td class="column2">${gpu.memoryTechnologyOfThisGpu.name }</td>

															</tr>

															<tr>
																<td class="column1"><spring:message
																		code="add.form.memorySpeed.label" /></td>
																<td class="column2">${gpu.memorySpeed }MHz</td>

															</tr>

															<tr>
																<td class="column1"><spring:message
																		code="add.form.memoryBus.label" /></td>
																<td class="column2">${gpu.memoryBus }bit</td>

															</tr>

															<tr>
																<td class="column1"><spring:message
																		code="add.form.memoryBandwidth.label" /></td>
																<td class="column2">${gpu.memoryBandwidth }MB/s</td>

															</tr>

															<tr>
																<td class="column1"><spring:message
																		code="add.form.cache.label" /></td>
																<td class="column2">${gpu.cache }KB</td>

															</tr>

															<tr>
																<td class="column1"><spring:message
																		code="add.form.tdp.label" /></td>
																<td class="column2">${gpu.tdp }W</td>

															</tr>

															<tr>
																<td class="column1"><spring:message
																		code="add.form.shader.label" /></td>
																<td class="column2">${gpu.shader }</td>

															</tr>

															<tr>
																<td class="column1"><spring:message
																		code="add.form.openGL.label" /></td>
																<td class="column2">${gpu.openGL }</td>

															</tr>

															<tr>
																<td class="column1"><spring:message
																		code="addGpu.form.gpuSlot.label" /></td>
																<td class="column2">${gpu.gpuSlotOfThisGpu.name }</td>

															</tr>

															<tr>
																<td class="column1"><spring:message
																		code="addGpu.form.directX.label" /></td>
																<td class="column2">${gpu.maximumDirectXSupportedByThisGpu.name }</td>

															</tr>

															<tr>
																<td class="column1"><spring:message
																		code="addGpu.form.cpu.label" /></td>
																<td class="column2">${gpu.cpuRecommendedForThisGpu.familyOfThisCpu.companyOfThisCpuFamily.name } ${gpu.cpuRecommendedForThisGpu.familyOfThisCpu.name} ${gpu.cpuRecommendedForThisGpu.name }</td>

															</tr>


															<tr>
																<td class="column1">Laptop/Desktop</td>
																<c:if
																	test="${gpu.gpuSlotOfThisGpu.laptopOrDesktop == true}">
																	<td class="column2">Laptop</td>

																</c:if>

																<c:if
																	test="${gpu.gpuSlotOfThisGpu.laptopOrDesktop == false}">
																	<td class="column2">Desktop</td>

																</c:if>

															</tr>
														
															<tr>
																<td class="column1"><spring:message
																		code="add.form.releaseDate.label" /></td>
																<td class="column2">${gpu.releaseDate }</td>


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



</html>