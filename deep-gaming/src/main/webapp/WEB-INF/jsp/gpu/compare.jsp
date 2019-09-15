<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>


<jsp:include page="/WEB-INF/jsp/head.jsp" />
<link type="text/css" rel="stylesheet"
	href="<c:url value="/css/fileupload.css"/>" />
<link type="text/css" rel="stylesheet"
	href="<c:url value="/css/table.css"/>" />
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/body.jsp"></jsp:include>

	<a href="?gpu1=${gpu1.id }&gpu2=${gpu2.id }&language=en">English</a>|
	<a href="?gpu1=${gpu1.id }&gpu2=${gpu2.id }&language=al">Albanian</a>|

	<jsp:include page="/WEB-INF/jsp/navigation.jsp"></jsp:include>
	<center>
		<div class="container">
			<div class="row">
				<div class="col-xs-6">
					<img width="300px" height="300px"
						src="<c:url value="/img/gpu${gpu1.id}.png">
 </c:url>">
				</div>

				<div class="col-xs-6">
					<img width="300px" height="300px"
						src="<c:url value="/img/gpu${gpu2.id}.png">
 </c:url>">
				</div>

			</div>
		</div>
	</center>
	<div class="row">
		<div class="col-md-12">

			<div class="limiter">

				<div class="container-table100">
					<div class="wrap-table100">
						<div class="table100">
							<table>
								<thead>
									<tr class="table100-head">
										<th class="column1"><spring:message
												code="cpu.compare.attributes" /></th>
										<th class="column2">${gpu1.familyOfThisGpu.companyOfThisGpuFamily.name }
											${gpu1.familyOfThisGpu.name } ${gpu1.name }</th>
										<th class="column3">${gpu2.familyOfThisGpu.companyOfThisGpuFamily.name }
											${gpu2.familyOfThisGpu.name } ${gpu2.name }</th>

									</tr>
								</thead>
								<tbody>
									<tr>
										<td class="column1"><spring:message
												code="addGpu.form.architectureOfThisGpu.label" /></td>
										<td class="column2">${gpu1.architectureOfThisGpu.name }</td>
										<td class="column3">${gpu2.architectureOfThisGpu.name }</td>

									</tr>
									<tr>
										<td class="column1"><spring:message
												code="addGpu.form.gpuSlot.label" /></td>
										<td class="column2">${gpu1.gpuSlotOfThisGpu.name }</td>

										<td class="column3">${gpu2.gpuSlotOfThisGpu.name }</td>

									</tr>
									<tr>
										<td class="column1">Laptop/Desktop</td>
										<c:if test="${gpu1.gpuSlotOfThisGpu.laptopOrDesktop == true}">
											<td class="column2">Laptop</td>

										</c:if>

										<c:if test="${gpu1.gpuSlotOfThisGpu.laptopOrDesktop == false}">
											<td class="column2">Desktop</td>

										</c:if>
										<c:if test="${gpu2.gpuSlotOfThisGpu.laptopOrDesktop == true}">
											<td class="column3">Laptop</td>

										</c:if>

										<c:if test="${gpu2.gpuSlotOfThisGpu.laptopOrDesktop == false}">
											<td class="column3">Desktop</td>

										</c:if>

									</tr>
									<tr>
										<td class="column1"><spring:message
												code="add.form.gpuBenchmark.label" /></td>
										<c:if test="${gpu1.gpuBenchmark > gpu2.gpuBenchmark}">
											<td class="column2">${gpu1.gpuBenchmark }<i
												class="fa fa-check" aria-hidden="true"></i>
											</td>
											<td class="column3">${gpu2.gpuBenchmark }</td>

										</c:if>
										<c:if test="${gpu1.gpuBenchmark < gpu2.gpuBenchmark}">
											<td class="column2">${gpu1.gpuBenchmark }</td>
											<td class="column3">${gpu2.gpuBenchmark }<i
												class="fa fa-check" aria-hidden="true"></i></td>

										</c:if>
										<c:if test="${gpu1.gpuBenchmark == gpu2.gpuBenchmark}">
											<td class="column2">${gpu1.gpuBenchmark }<i
												class="fa fa-check" aria-hidden="true"></i>
											</td>
											<td class="column3">${gpu2.gpuBenchmark }<i
												class="fa fa-check" aria-hidden="true"></i></td>

										</c:if>

									</tr>
									<tr>
										<td class="column1"><spring:message
												code="addArchitecture.form.process.label" /></td>
										<c:if
											test="${gpu1.architectureOfThisGpu.gpuProcessNanometers > gpu2.architectureOfThisGpu.gpuProcessNanometers }">
											<td class="column2">${gpu1.architectureOfThisGpu.gpuProcessNanometers }nm</td>
											<td class="column3">${gpu2.architectureOfThisGpu.gpuProcessNanometers }nm
												<i class="fa fa-check" aria-hidden="true"></i>
											</td>
										</c:if>
										<c:if
											test="${gpu1.architectureOfThisGpu.gpuProcessNanometers < gpu2.architectureOfThisGpu.gpuProcessNanometers }">
											<td class="column2">${gpu1.architectureOfThisGpu.gpuProcessNanometers }nm
												<i class="fa fa-check" aria-hidden="true"></i>
											</td>
											<td class="column3">${gpu2.architectureOfThisGpu.gpuProcessNanometers }nm
											</td>
										</c:if>
										<c:if
											test="${gpu1.architectureOfThisGpu.gpuProcessNanometers == gpu2.architectureOfThisGpu.gpuProcessNanometers }">
											<td class="column2">${gpu1.architectureOfThisGpu.gpuProcessNanometers }nm
												<i class="fa fa-check" aria-hidden="true"></i>
											</td>
											<td class="column3">${gpu2.architectureOfThisGpu.gpuProcessNanometers }nm
												<i class="fa fa-check" aria-hidden="true"></i>
											</td>
										</c:if>

									</tr>
									<tr>
										<c:if test="${gpu1.coreSpeed > gpu2.coreSpeed }">
											<td class="column1"><spring:message
													code="add.form.coreSpeed.label" /></td>
											<td class="column2">${gpu1.coreSpeed }MHz<i
												class="fa fa-check" aria-hidden="true"></i>
											</td>
											<td class="column3">${gpu2.coreSpeed }MHz</td>
										</c:if>

										<c:if test="${gpu1.coreSpeed < gpu2.coreSpeed }">
											<td class="column1"><spring:message
													code="add.form.coreSpeed.label" /></td>
											<td class="column2">${gpu1.coreSpeed }MHz</td>
											<td class="column3">${gpu2.coreSpeed }MHz<i
												class="fa fa-check" aria-hidden="true"></i></td>
										</c:if>


										<c:if test="${gpu1.coreSpeed == gpu2.coreSpeed }">
											<td class="column1"><spring:message
													code="add.form.coreSpeed.label" /><i class="fa fa-check"
												aria-hidden="true"></i></td>
											<td class="column2">${gpu1.coreSpeed }MHz<i
												class="fa fa-check" aria-hidden="true"></i>
											</td>
											<td class="column3">${gpu2.coreSpeed }MHz</td>
										</c:if>

									</tr>
									<tr>
										<td class="column1"><spring:message
												code="add.form.boostClock.label" /></td>
										<c:if test="${gpu1.boostClock > gpu2.boostClock }">
											<td class="column2">${gpu1.boostClock }MHz<i
												class="fa fa-check" aria-hidden="true"></i></td>
											<td class="column3">${gpu2.boostClock }MHz</td>
										</c:if>
										<c:if test="${gpu1.boostClock < gpu2.boostClock }">
											<td class="column2">${gpu1.boostClock }MHz</td>
											<td class="column3">${gpu2.boostClock }MHz<i
												class="fa fa-check" aria-hidden="true"></i></td>
										</c:if>
										<c:if test="${gpu1.boostClock == gpu2.boostClock }">
											<td class="column2">${gpu1.boostClock }MHz<i
												class="fa fa-check" aria-hidden="true"></i></td>
											<td class="column3">${gpu2.boostClock }MHz<i
												class="fa fa-check" aria-hidden="true"></i></td>
										</c:if>

									</tr>
									<tr>
										<td class="column1"><spring:message
												code="add.form.shaderProcessingUnits.label" /></td>
										<c:if
											test="${gpu1.shaderProcessingUnits > gpu2.shaderProcessingUnits }">
											<td class="column2">${gpu1.shaderProcessingUnits }<i
												class="fa fa-check" aria-hidden="true"></i></td>
											<td class="column3">${gpu2.shaderProcessingUnits }</td>
										</c:if>

										<c:if
											test="${gpu1.shaderProcessingUnits < gpu2.shaderProcessingUnits }">
											<td class="column2">${gpu1.shaderProcessingUnits }</td>
											<td class="column3">${gpu2.shaderProcessingUnits }<i
												class="fa fa-check" aria-hidden="true"></i></td>
										</c:if>

										<c:if
											test="${gpu1.shaderProcessingUnits == gpu2.shaderProcessingUnits }">
											<td class="column2">${gpu1.shaderProcessingUnits }<i
												class="fa fa-check" aria-hidden="true"></i></td>
											<td class="column3">${gpu2.shaderProcessingUnits }<i
												class="fa fa-check" aria-hidden="true"></i></td>
										</c:if>

									</tr>
									<tr>
										<td class="column1"><spring:message
												code="add.form.rayTracingCores.label" /></td>
										<c:if test="${gpu1.rayTracingCores > gpu2.rayTracingCores }">
											<td class="column2">${gpu1.rayTracingCores }<i
												class="fa fa-check" aria-hidden="true"></i></td>
											<td class="column3">${gpu2.rayTracingCores }</td>
										</c:if>

										<c:if test="${gpu1.rayTracingCores < gpu2.rayTracingCores }">
											<td class="column2">${gpu1.rayTracingCores }</td>
											<td class="column3">${gpu2.rayTracingCores }<i
												class="fa fa-check" aria-hidden="true"></i></td>
										</c:if>

										<c:if test="${gpu1.rayTracingCores == gpu2.rayTracingCores }">
											<td class="column2">${gpu1.rayTracingCores }<i
												class="fa fa-check" aria-hidden="true"></i></td>
											<td class="column3">${gpu2.rayTracingCores }<i
												class="fa fa-check" aria-hidden="true"></i></td>
										</c:if>
									</tr>


									<tr>
										<td class="column1"><spring:message
												code="add.form.tensorCores.label" /></td>
										<c:if test="${gpu1.tensorCores > gpu2.tensorCores }">
											<td class="column2">${gpu1.tensorCores }<i
												class="fa fa-check" aria-hidden="true"></i></td>
											<td class="column3">${gpu2.tensorCores }</td>
										</c:if>

										<c:if test="${gpu1.tensorCores < gpu2.tensorCores }">
											<td class="column2">${gpu1.tensorCores }</td>
											<td class="column3">${gpu2.tensorCores }<i
												class="fa fa-check" aria-hidden="true"></i></td>
										</c:if>

										<c:if test="${gpu1.tensorCores == gpu2.tensorCores }">
											<td class="column2">${gpu1.tensorCores }<i
												class="fa fa-check" aria-hidden="true"></i></td>
											<td class="column3">${gpu2.tensorCores }<i
												class="fa fa-check" aria-hidden="true"></i></td>
										</c:if>
									</tr>



									<tr>
										<td class="column1"><spring:message
												code="add.form.tmu.label" /></td>
										<c:if test="${gpu1.tmu > gpu2.tmu }">
											<td class="column2">${gpu1.tmu }<i class="fa fa-check"
												aria-hidden="true"></i></td>
											<td class="column3">${gpu2.tmu }</td>
										</c:if>

										<c:if test="${gpu1.tmu < gpu2.tmu }">
											<td class="column2">${gpu1.tmu }</td>
											<td class="column3">${gpu2.tmu }<i class="fa fa-check"
												aria-hidden="true"></i></td>
										</c:if>

										<c:if test="${gpu1.tmu == gpu2.tmu }">
											<td class="column2">${gpu1.tmu }<i class="fa fa-check"
												aria-hidden="true"></i></td>
											<td class="column3">${gpu2.tmu }<i class="fa fa-check"
												aria-hidden="true"></i></td>
										</c:if>

									</tr>
									<tr>
										<td class="column1"><spring:message
												code="add.form.textureRate.label" /></td>
										<c:if test="${gpu1.textureRate > gpu2.textureRate }">
											<td class="column2">${gpu1.textureRate }GTexel/s<i
												class="fa fa-check" aria-hidden="true"></i></td>
											<td class="column3">${gpu2.textureRate }GTexel/s</td>
										</c:if>

										<c:if test="${gpu1.textureRate < gpu2.textureRate }">
											<td class="column2">${gpu1.textureRate }GTexel/s</td>
											<td class="column3">${gpu2.textureRate }GTexel/s<i
												class="fa fa-check" aria-hidden="true"></i></td>
										</c:if>

										<c:if test="${gpu1.textureRate == gpu2.textureRate }">
											<td class="column2">${gpu1.textureRate }GTexel/s<i
												class="fa fa-check" aria-hidden="true"></i></td>
											<td class="column3">${gpu2.textureRate }GTexel/s<i
												class="fa fa-check" aria-hidden="true"></i></td>
										</c:if>

									</tr>

									<tr>
										<td class="column1"><spring:message
												code="add.form.pixelRate.label" /></td>
										<c:if test="${gpu1.pixelRate > gpu2.pixelRate }">
											<td class="column2">${gpu1.pixelRate }GPixel/s<i
												class="fa fa-check" aria-hidden="true"></i></td>
											<td class="column3">${gpu2.pixelRate }GPixel/s</td>

										</c:if>

										<c:if test="${gpu1.pixelRate < gpu2.pixelRate }">
											<td class="column2">${gpu1.pixelRate }GPixel/s</td>
											<td class="column3">${gpu2.pixelRate }GPixel/s<i
												class="fa fa-check" aria-hidden="true"></i></td>

										</c:if>

										<c:if test="${gpu1.pixelRate == gpu2.pixelRate }">
											<td class="column2">${gpu1.pixelRate }GPixel/s<i
												class="fa fa-check" aria-hidden="true"></i></td>
											<td class="column3">${gpu2.pixelRate }GPixel/s<i
												class="fa fa-check" aria-hidden="true"></i></td>

										</c:if>

									</tr>

									<tr>
										<td class="column1"><spring:message
												code="add.form.driverSupport.label" /></td>
										<c:if test="${gpu1.driverSupport > gpu2.driverSupport }">
											<td class="column2">${gpu1.driverSupport }<i
												class="fa fa-check" aria-hidden="true"></i></td>
											<td class="column3">${gpu2.driverSupport }</td>
										</c:if>
										<c:if test="${gpu1.driverSupport < gpu2.driverSupport }">
											<td class="column2">${gpu1.driverSupport }</td>
											<td class="column3">${gpu2.driverSupport }<i
												class="fa fa-check" aria-hidden="true"></i></td>
										</c:if>
										<c:if test="${gpu1.driverSupport == gpu2.driverSupport }">
											<td class="column2">${gpu1.driverSupport }<i
												class="fa fa-check" aria-hidden="true"></i></td>
											<td class="column3">${gpu2.driverSupport }<i
												class="fa fa-check" aria-hidden="true"></i></td>
										</c:if>
									</tr>



									<tr>
										<td class="column1"><spring:message
												code="addGpu.form.gpuMemoryTechnology.label" /></td>
										<td class="column2">${gpu1.memoryTechnologyOfThisGpu.name }</td>
										<td class="column3">${gpu2.memoryTechnologyOfThisGpu.name }</td>

									</tr>

									<tr>
										<td class="column1"><spring:message
												code="add.form.memorySpeed.label" /></td>
										<c:if test="${gpu1.memorySpeed > gpu2.memorySpeed }">
											<td class="column2">${gpu1.memorySpeed }MHz<i
												class="fa fa-check" aria-hidden="true"></i></td>
											<td class="column3">${gpu2.memorySpeed }MHz</td>
										</c:if>

										<c:if test="${gpu1.memorySpeed < gpu2.memorySpeed }">
											<td class="column2">${gpu1.memorySpeed }MHz</td>
											<td class="column3">${gpu2.memorySpeed }MHz<i
												class="fa fa-check" aria-hidden="true"></i></td>
										</c:if>

										<c:if test="${gpu1.memorySpeed == gpu2.memorySpeed }">
											<td class="column2">${gpu1.memorySpeed }MHz<i
												class="fa fa-check" aria-hidden="true"></i></td>
											<td class="column3">${gpu2.memorySpeed }MHz<i
												class="fa fa-check" aria-hidden="true"></i></td>
										</c:if>

									</tr>

									<tr>
										<td class="column1"><spring:message
												code="add.form.memoryBus.label" /></td>
										<c:if test="${gpu1.memoryBus > gpu2.memoryBus }">
											<td class="column2">${gpu1.memoryBus }bit<i
												class="fa fa-check" aria-hidden="true"></i></td>
											<td class="column3">${gpu2.memoryBus }bit</td>
										</c:if>

										<c:if test="${gpu1.memoryBus < gpu2.memoryBus }">
											<td class="column2">${gpu1.memoryBus }bit</td>
											<td class="column3">${gpu2.memoryBus }bit<i
												class="fa fa-check" aria-hidden="true"></i></td>
										</c:if>


										<c:if test="${gpu1.memoryBus == gpu2.memoryBus }">
											<td class="column2">${gpu1.memoryBus }bit<i
												class="fa fa-check" aria-hidden="true"></i></td>
											<td class="column3">${gpu2.memoryBus }bit<i
												class="fa fa-check" aria-hidden="true"></i></td>
										</c:if>


									</tr>

									<tr>
										<td class="column1"><spring:message
												code="add.form.memoryBandwidth.label" /></td>
										<c:if test="${gpu1.memoryBandwidth > gpu2.memoryBandwidth }">
											<td class="column2">${gpu1.memoryBandwidth }MB/s<i
												class="fa fa-check" aria-hidden="true"></i></td>
											<td class="column3">${gpu2.memoryBandwidth }MB/s</td>
										</c:if>

										<c:if test="${gpu1.memoryBandwidth < gpu2.memoryBandwidth }">
											<td class="column2">${gpu1.memoryBandwidth }MB/s</td>
											<td class="column3">${gpu2.memoryBandwidth }MB/s<i
												class="fa fa-check" aria-hidden="true"></i></td>
										</c:if>

										<c:if test="${gpu1.memoryBandwidth == gpu2.memoryBandwidth }">
											<td class="column2">${gpu1.memoryBandwidth }MB/s<i
												class="fa fa-check" aria-hidden="true"></i></td>
											<td class="column3">${gpu2.memoryBandwidth }MB/s<i
												class="fa fa-check" aria-hidden="true"></i></td>
										</c:if>



									</tr>

									<tr>
										<td class="column1"><spring:message
												code="add.form.cache.label" /></td>
										<c:if test="${gpu1.cache > gpu2.cache }">
											<td class="column2">${gpu1.cache }KB<i
												class="fa fa-check" aria-hidden="true"></i></td>
											<td class="column3">${gpu2.cache }KB</td>
										</c:if>

										<c:if test="${gpu1.cache < gpu2.cache }">
											<td class="column2">${gpu1.cache }KB</td>
											<td class="column3">${gpu2.cache }KB<i
												class="fa fa-check" aria-hidden="true"></i></td>
										</c:if>

										<c:if test="${gpu1.cache == gpu2.cache }">
											<td class="column2">${gpu1.cache }KB<i
												class="fa fa-check" aria-hidden="true"></i></td>
											<td class="column3">${gpu2.cache }KB<i
												class="fa fa-check" aria-hidden="true"></i></td>
										</c:if>

									</tr>

									<tr>
										<td class="column1"><spring:message
												code="add.form.tdp.label" /></td>
										<c:if test="${gpu1.tdp < gpu2.tdp }">
											<td class="column2">${gpu1.tdp }W<i class="fa fa-check"
												aria-hidden="true"></i></td>
											<td class="column3">${gpu2.tdp }W</td>
										</c:if>

										<c:if test="${gpu1.tdp > gpu2.tdp }">
											<td class="column2">${gpu1.tdp }W</td>
											<td class="column3">${gpu2.tdp }W<i class="fa fa-check"
												aria-hidden="true"></i></td>
										</c:if>

										<c:if test="${gpu1.tdp == gpu2.tdp }">
											<td class="column2">${gpu1.tdp }W<i class="fa fa-check"
												aria-hidden="true"></i></td>
											<td class="column3">${gpu2.tdp }W<i class="fa fa-check"
												aria-hidden="true"></i></td>
										</c:if>
									</tr>

									<tr>
										<td class="column1"><spring:message
												code="add.form.shader.label" /></td>
										<c:if test="${gpu1.shader > gpu2.shader }">
											<td class="column2">${gpu1.shader }<i
												class="fa fa-check" aria-hidden="true"></i></td>
											<td class="column3">${gpu2.shader }</td>

										</c:if>

										<c:if test="${gpu1.shader < gpu2.shader }">
											<td class="column2">${gpu1.shader }</td>
											<td class="column3">${gpu2.shader }<i
												class="fa fa-check" aria-hidden="true"></i></td>

										</c:if>

										<c:if test="${gpu1.shader == gpu2.shader }">
											<td class="column2">${gpu1.shader }<i
												class="fa fa-check" aria-hidden="true"></i></td>
											<td class="column3">${gpu2.shader }<i
												class="fa fa-check" aria-hidden="true"></i></td>

										</c:if>
									</tr>

									<tr>
										<td class="column1"><spring:message
												code="add.form.openGL.label" /></td>
										<c:if test="${gpu1.openGL > gpu2.openGL }">
											<td class="column2">${gpu1.openGL }<i
												class="fa fa-check" aria-hidden="true"></i></td>
											<td class="column3">${gpu2.openGL }</td>
										</c:if>

										<c:if test="${gpu1.openGL < gpu2.openGL }">
											<td class="column2">${gpu1.openGL }</td>
											<td class="column3">${gpu2.openGL }<i
												class="fa fa-check" aria-hidden="true"></i></td>
										</c:if>

										<c:if test="${gpu1.openGL == gpu2.openGL }">
											<td class="column2">${gpu1.openGL }<i
												class="fa fa-check" aria-hidden="true"></i></td>
											<td class="column3">${gpu2.openGL }<i
												class="fa fa-check" aria-hidden="true"></i></td>
										</c:if>

									</tr>

									<tr>
										<td class="column1"><spring:message
												code="addGpu.form.directX.label" /></td>
										<td class="column2">${gpu1.maximumDirectXSupportedByThisGpu.name }</td>
										<td class="column3">${gpu2.maximumDirectXSupportedByThisGpu.name }</td>

									</tr>

									<tr>
										<td class="column1"><spring:message
												code="addGpu.form.cpu.label" /></td>
										<td class="column2">${gpu1.cpuRecommendedForThisGpu.familyOfThisCpu.companyOfThisCpuFamily.name }
											${gpu1.cpuRecommendedForThisGpu.familyOfThisCpu.name}
											${gpu1.cpuRecommendedForThisGpu.name }</td>
										<td class="column3">${gpu2.cpuRecommendedForThisGpu.familyOfThisCpu.companyOfThisCpuFamily.name }
											${gpu2.cpuRecommendedForThisGpu.familyOfThisCpu.name}
											${gpu2.cpuRecommendedForThisGpu.name }</td>

									</tr>



									<tr>
										<td class="column1"><spring:message
												code="add.form.releaseDate.label" /></td>
										<td class="column2">${gpu1.releaseDate }</td>
										<td class="column3">${gpu2.releaseDate }</td>


									</tr>

								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<div id="product-tab">
					<ul class="tab-nav">
						<li class="active"><a data-toggle="tab" href="#tab1"><spring:message
									code="add.form.description.label" /></a></li>
					</ul>
					<div class="tab-content">
						<!-- tab1  -->
						<div id="tab1" class="tab-pane fade in active">
							<div class="row">
								<div class="col-md-12">
									<div style="font-size: 16px;">
										<spring:message code="termsOfOverallGamingPerformance" />
										${gpu1.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu1.familyOfThisGpu.name } ${gpu1.name }
										<c:if test="${gpu1.gpuBenchmark / gpu2.gpuBenchmark < 1.3}">
											<spring:message code="littleBitBetter" />
										</c:if>
										<c:if test="${gpu1.gpuBenchmark / gpu2.gpuBenchmark >= 1.3}">
											<spring:message code="massivelyBetter" />
										</c:if>

										${gpu2.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu2.familyOfThisGpu.name } ${gpu2.name }
										<spring:message code="whenItComesToRunningGamesGPU" />

									</div>
									<br>
									<c:if test="${gpu1.gpuBenchmark / gpu2.gpuBenchmark < 1.3}">

										<div style="font-size: 16px;">
											<spring:message code="bothGpusPerformance" />
										</div>
										<br>
									</c:if>

									<div style="font-size: 16px;">
										<c:if test="${gpu1.coreSpeed > gpu2.coreSpeed }">
												${gpu1.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu1.familyOfThisGpu.name } ${gpu1.name } <spring:message
												code="hasACoreSpeed" /> ${gpu1.coreSpeed - gpu2.coreSpeed}MHz <spring:message
												code="largerThan" /> ${gpu2.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu2.familyOfThisGpu.name } ${gpu2.name }. <spring:message
												code="helpGraphicalPerformance" /> ${gpu1.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu1.familyOfThisGpu.name } ${gpu1.name } <spring:message
												code="comparedTo" /> ${gpu2.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu2.familyOfThisGpu.name } ${gpu2.name }
										</c:if>

										<c:if test="${gpu1.coreSpeed < gpu2.coreSpeed }">
												${gpu2.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu2.familyOfThisGpu.name } ${gpu2.name } <spring:message
												code="hasACoreSpeed" /> ${gpu2.coreSpeed - gpu1.coreSpeed }MHz <spring:message
												code="largerThan" /> ${gpu1.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu1.familyOfThisGpu.name } ${gpu1.name }. <spring:message
												code="helpGraphicalPerformance" /> ${gpu2.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu2.familyOfThisGpu.name } ${gpu2.name } <spring:message
												code="comparedTo" /> ${gpu1.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu1.familyOfThisGpu.name } ${gpu1.name }
										</c:if>

										<c:if test="${gpu1.coreSpeed == gpu2.coreSpeed }">
											<spring:message code="sameCoreSpeed" />
										</c:if>

									</div>

									<div style="font-size: 16px;">
										<spring:message code="whatIsTmu" />
										<c:if test="${gpu1.tmu > gpu2.tmu }">
												${gpu1.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu1.familyOfThisGpu.name } ${gpu1.name } <spring:message
												code="has" /> ${gpu1.tmu - gpu2.tmu} <spring:message
												code="moreTmuThan" /> ${gpu2.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu2.familyOfThisGpu.name } ${gpu2.name }. <spring:message
												code="helpGraphicalPerformance" /> ${gpu1.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu1.familyOfThisGpu.name } ${gpu1.name } <spring:message
												code="comparedTo" /> ${gpu2.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu2.familyOfThisGpu.name } ${gpu2.name }
										</c:if>

										<c:if test="${gpu1.tmu < gpu2.tmu }">
												${gpu2.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu2.familyOfThisGpu.name } ${gpu2.name } <spring:message
												code="has" /> ${gpu2.tmu - gpu1.tmu } <spring:message
												code="moreTmuThan" /> ${gpu1.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu1.familyOfThisGpu.name } ${gpu1.name }. <spring:message
												code="helpGraphicalPerformance" /> ${gpu2.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu2.familyOfThisGpu.name } ${gpu2.name } <spring:message
												code="comparedTo" /> ${gpu1.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu1.familyOfThisGpu.name } ${gpu1.name }
										</c:if>

										<c:if test="${gpu1.tmu == gpu2.tmu }">
											<spring:message code="sameNumberOfTmus" />
										</c:if>

									</div>

									<br />
									<div style="font-size: 16px;">

										<c:if test="${gpu1.memorySize > gpu2.memorySize }">
												${gpu1.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu1.familyOfThisGpu.name } ${gpu1.name } <spring:message
												code="has" /> ${gpu1.memorySize - gpu2.memorySize} MB <spring:message
												code="moreMemoryThan" /> ${gpu2.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu2.familyOfThisGpu.name } ${gpu2.name }. 
										</c:if>

										<c:if test="${gpu1.memorySize < gpu2.memorySize }">
												${gpu2.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu2.familyOfThisGpu.name } ${gpu2.name } <spring:message
												code="has" /> ${gpu2.memorySize - gpu1.memorySize } MB <spring:message
												code="moreMemoryThan" /> ${gpu1.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu1.familyOfThisGpu.name } ${gpu1.name }. 
										</c:if>

										<c:if test="${gpu1.memorySize == gpu2.memorySize }">
											<spring:message code="sameMemorySize" />
										</c:if>
										<c:if test="${gpu1.memoryBandwidth > gpu2.memoryBandwidth }">
										${gpu1.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu1.familyOfThisGpu.name } ${gpu1.name } <spring:message
												code="hasAMemorySpeed" /> ${gpu1.memoryBandwidth - gpu2.memoryBandwidth} MHz <spring:message
												code="largerThan" /> ${gpu2.familyOfThisGpu.companyOfThisGpuFamily.name } 
										${gpu2.familyOfThisGpu.name } ${gpu2.name }.  <spring:message
												code="helpGraphicalPerformance" /> ${gpu1.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu1.familyOfThisGpu.name } ${gpu1.name } <spring:message
												code="comparedTo" /> ${gpu2.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu2.familyOfThisGpu.name } ${gpu2.name }
										</c:if>

										<c:if test="${gpu1.memoryBandwidth < gpu2.memoryBandwidth }">
												${gpu2.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu2.familyOfThisGpu.name } ${gpu2.name } <spring:message
												code="hasAMemorySpeed" /> ${gpu2.memoryBandwidth - gpu1.memoryBandwidth } MHz <spring:message
												code="largerThan" /> ${gpu1.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu1.familyOfThisGpu.name } ${gpu1.name }. <spring:message
												code="helpGraphicalPerformance" /> ${gpu2.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu2.familyOfThisGpu.name } ${gpu2.name } <spring:message
												code="comparedTo" /> ${gpu1.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu1.familyOfThisGpu.name } ${gpu1.name }
										</c:if>

										<c:if test="${gpu1.memoryBandwidth == gpu2.memoryBandwidth }">
											<spring:message code="sameMemoryBandwidth" />
										</c:if>


									</div>
									<br>

									<div style="font-size: 16px;">
										<spring:message code="shaderProcessingUnitsExplanation" />
										<c:if
											test="${gpu1.shaderProcessingUnits > gpu2.shaderProcessingUnits }">
												${gpu1.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu1.familyOfThisGpu.name } ${gpu1.name } <spring:message
												code="has" /> ${gpu1.shaderProcessingUnits - gpu2.shaderProcessingUnits} <spring:message
												code="moreShadersThan" /> ${gpu2.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu2.familyOfThisGpu.name } ${gpu2.name }. <spring:message
												code="helpGraphicalPerformance" /> ${gpu1.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu1.familyOfThisGpu.name } ${gpu1.name } <spring:message
												code="comparedTo" /> ${gpu2.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu2.familyOfThisGpu.name } ${gpu2.name }
										</c:if>

										<c:if
											test="${gpu1.shaderProcessingUnits < gpu2.shaderProcessingUnits }">
												${gpu2.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu2.familyOfThisGpu.name } ${gpu2.name } <spring:message
												code="has" /> ${gpu2.shaderProcessingUnits - gpu1.shaderProcessingUnits } <spring:message
												code="moreShadersThan" /> ${gpu1.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu1.familyOfThisGpu.name } ${gpu1.name }. <spring:message
												code="helpGraphicalPerformance" /> ${gpu2.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu2.familyOfThisGpu.name } ${gpu2.name } <spring:message
												code="comparedTo" /> ${gpu1.familyOfThisGpu.companyOfThisGpuFamily.name }
										${gpu1.familyOfThisGpu.name } ${gpu1.name }
										</c:if>

										<c:if
											test="${gpu1.shaderProcessingUnits == gpu2.shaderProcessingUnits }">
											<spring:message code="sameNumberOfShaders" />
										</c:if>

									</div>

								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



	<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>

	<jsp:include page="/WEB-INF/jsp/scripts.jsp" />


	<script src="<c:url value="/js/fileupload.js"></c:url>"></script>

</body>
</html>
