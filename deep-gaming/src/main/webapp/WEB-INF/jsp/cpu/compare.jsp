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

	<a href="?cpu1=${cpu1.id }&cpu2=${cpu2.id }&language=en">English</a>|
	<a href="?cpu1=${cpu1.id }&cpu2=${cpu2.id }&language=al">Albanian</a>|

	<jsp:include page="/WEB-INF/jsp/navigation.jsp"></jsp:include>
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
										<th class="column2">${cpu1.familyOfThisCpu.companyOfThisCpuFamily.name }
											${cpu1.familyOfThisCpu.name } ${cpu1.name }</th>
										<th class="column3">${cpu2.familyOfThisCpu.companyOfThisCpuFamily.name }
											${cpu2.familyOfThisCpu.name } ${cpu2.name }</th>

									</tr>
								</thead>
								<tbody>
									<tr>
										<td class="column1"><spring:message
												code="addCpu.form.architectureOfThisCpu.label" /></td>
										<td class="column2">${cpu1.architectureOfThisCpu.name }</td>
										<td class="column3">${cpu2.architectureOfThisCpu.name }</td>

									</tr>
									<tr>
										<td class="column1"><spring:message
												code="addCpu.form.socketOfThisCpu.label" /></td>
										<td class="column2">${cpu1.socketOfThisCpu.name }</td>
										<td class="column3">${cpu2.socketOfThisCpu.name }</td>

									</tr>
									<tr>
										<td class="column1">Laptop/Desktop</td>
										<c:if test="${cpu1.socketOfThisCpu.laptopOrDesktop == true}">
											<td class="column2">Laptop</td>

										</c:if>

										<c:if test="${cpu1.socketOfThisCpu.laptopOrDesktop == false}">
											<td class="column2">Desktop</td>

										</c:if>
										<c:if test="${cpu2.socketOfThisCpu.laptopOrDesktop == true}">
											<td class="column3">Laptop</td>

										</c:if>

										<c:if test="${cpu2.socketOfThisCpu.laptopOrDesktop == false}">
											<td class="column3">Desktop</td>

										</c:if>

									</tr>
									<tr>
										<td class="column1"><spring:message
												code="add.form.cpuBenchmark.label" /></td>
										<c:if test="${cpu1.cpuBenchmark > cpu2.cpuBenchmark}">
											<td class="column2">${cpu1.cpuBenchmark }<i
												class="fa fa-check" aria-hidden="true"></i>
											</td>
											<td class="column3">${cpu2.cpuBenchmark }</td>

										</c:if>
										<c:if test="${cpu1.cpuBenchmark < cpu2.cpuBenchmark}">
											<td class="column2">${cpu1.cpuBenchmark }</td>
											<td class="column3">${cpu2.cpuBenchmark }<i
												class="fa fa-check" aria-hidden="true"></i></td>

										</c:if>
										<c:if test="${cpu1.cpuBenchmark == cpu2.cpuBenchmark}">
											<td class="column2">${cpu1.cpuBenchmark }<i
												class="fa fa-check" aria-hidden="true"></i>
											</td>
											<td class="column3">${cpu2.cpuBenchmark }<i
												class="fa fa-check" aria-hidden="true"></i></td>

										</c:if>

									</tr>
									<tr>
										<td class="column1"><spring:message
												code="add.form.cpuSpeed.label" /></td>
										<c:if test="${cpu1.cpuSpeed > cpu2.cpuSpeed}">
											<td class="column2">${cpu1.cpuSpeed }GHz<i
												class="fa fa-check" aria-hidden="true"></i>
											</td>
											<td class="column3">${cpu2.cpuSpeed }GHz</td>

										</c:if>
										<c:if test="${cpu1.cpuSpeed < cpu2.cpuSpeed}">
											<td class="column2">${cpu1.cpuSpeed }GHz</td>
											<td class="column3">${cpu2.cpuSpeed }GHz<i
												class="fa fa-check" aria-hidden="true"></i></td>

										</c:if>
										<c:if test="${cpu1.cpuSpeed == cpu2.cpuSpeed}">
											<td class="column2">${cpu1.cpuSpeed }GHz<i
												class="fa fa-check" aria-hidden="true"></i>
											</td>
											<td class="column3">${cpu2.cpuSpeed }GHz<i
												class="fa fa-check" aria-hidden="true"></i></td>

										</c:if>

									</tr>
									<tr>
										<td class="column1"><spring:message
												code="add.form.turboSpeed.label" /></td>
										<c:if test="${cpu1.turboSpeed > cpu2.turboSpeed}">
											<td class="column2">${cpu1.turboSpeed }GHz<i
												class="fa fa-check" aria-hidden="true"></i>
											</td>
											<td class="column3">${cpu2.turboSpeed }GHz</td>

										</c:if>
										<c:if test="${cpu1.turboSpeed < cpu2.turboSpeed}">
											<td class="column2">${cpu1.turboSpeed }GHz</td>
											<td class="column3">${cpu2.turboSpeed }GHz<i
												class="fa fa-check" aria-hidden="true"></i></td>

										</c:if>
										<c:if test="${cpu1.turboSpeed == cpu2.turboSpeed}">
											<td class="column2">${cpu1.turboSpeed }GHz<i
												class="fa fa-check" aria-hidden="true"></i>
											</td>
											<td class="column3">${cpu2.turboSpeed }GHz<i
												class="fa fa-check" aria-hidden="true"></i></td>

										</c:if>


									</tr>

									<tr>
										<td class="column1"><spring:message
												code="add.form.physicalCores.label" /></td>
										<c:if test="${cpu1.physicalCores > cpu2.physicalCores}">
											<td class="column2">${cpu1.physicalCores }<i
												class="fa fa-check" aria-hidden="true"></i>
											</td>
											<td class="column3">${cpu2.physicalCores }</td>

										</c:if>
										<c:if test="${cpu1.physicalCores < cpu2.physicalCores}">
											<td class="column2">${cpu1.physicalCores }</td>
											<td class="column3">${cpu2.physicalCores }<i
												class="fa fa-check" aria-hidden="true"></i></td>

										</c:if>
										<c:if test="${cpu1.physicalCores == cpu2.physicalCores}">
											<td class="column2">${cpu1.physicalCores }<i
												class="fa fa-check" aria-hidden="true"></i>
											</td>
											<td class="column3">${cpu2.physicalCores }<i
												class="fa fa-check" aria-hidden="true"></i></td>

										</c:if>


									</tr>

									<tr>
										<td class="column1"><spring:message
												code="add.form.threads.label" /></td>
										<c:if test="${cpu1.threads > cpu2.threads}">
											<td class="column2">${cpu1.threads }<i
												class="fa fa-check" aria-hidden="true"></i>
											</td>
											<td class="column3">${cpu2.threads }</td>

										</c:if>
										<c:if test="${cpu1.threads < cpu2.threads}">
											<td class="column2">${cpu1.threads }</td>
											<td class="column3">${cpu2.threads }<i
												class="fa fa-check" aria-hidden="true"></i>
											</td>

										</c:if>
										<c:if test="${cpu1.threads == cpu2.threads}">
											<td class="column2">${cpu1.threads }<i
												class="fa fa-check" aria-hidden="true"></i>
											</td>
											<td class="column3">${cpu2.threads }<i
												class="fa fa-check" aria-hidden="true"></i>
											</td>

										</c:if>
									</tr>

									<tr>
										<td class="column1"><spring:message
												code="add.form.tdp.label" /></td>
										<c:if test="${cpu1.tdp < cpu2.tdp}">
											<td class="column2">${cpu1.tdp }W<i class="fa fa-check"
												aria-hidden="true"></i>
											</td>
											<td class="column3">${cpu2.tdp }W</td>

										</c:if>
										<c:if test="${cpu1.tdp > cpu2.tdp}">
											<td class="column2">${cpu1.tdp }W</td>
											<td class="column3">${cpu2.tdp }W<i class="fa fa-check"
												aria-hidden="true"></i></td>

										</c:if>
										<c:if test="${cpu1.tdp == cpu2.tdp}">
											<td class="column2">${cpu1.tdp }W<i class="fa fa-check"
												aria-hidden="true"></i>
											</td>
											<td class="column3">${cpu2.tdp }W<i class="fa fa-check"
												aria-hidden="true"></i></td>

										</c:if>

									</tr>
									<tr>
										<td class="column1"><spring:message
												code="add.form.bitWidth.label" /></td>
										<c:if test="${cpu1.bitWidth > cpu2.bitWidth}">
											<td class="column2">${cpu1.bitWidth }<i
												class="fa fa-check" aria-hidden="true"></i>
											</td>
											<td class="column3">${cpu2.bitWidth }</td>

										</c:if>
										<c:if test="${cpu1.bitWidth < cpu2.bitWidth}">
											<td class="column2">${cpu1.bitWidth }</td>
											<td class="column3">${cpu2.bitWidth }<i
												class="fa fa-check" aria-hidden="true"></i></td>

										</c:if>
										<c:if test="${cpu1.bitWidth == cpu2.bitWidth}">
											<td class="column2">${cpu1.bitWidth }<i
												class="fa fa-check" aria-hidden="true"></i>
											</td>
											<td class="column3">${cpu2.bitWidth }<i
												class="fa fa-check" aria-hidden="true"></i></td>

										</c:if>
									</tr>
									<tr>
										<td class="column1"><spring:message
												code="addArchitecture.form.process.label" /></td>
										<c:if
											test="${cpu1.architectureOfThisCpu.cpuProcessNanometers < cpu2.architectureOfThisCpu.cpuProcessNanometers}">
											<td class="column2">${cpu1.architectureOfThisCpu.cpuProcessNanometers }nm<i
												class="fa fa-check" aria-hidden="true"></i>
											</td>
											<td class="column3">${cpu2.architectureOfThisCpu.cpuProcessNanometers}nm</td>

										</c:if>
										<c:if
											test="${cpu1.architectureOfThisCpu.cpuProcessNanometers > cpu2.architectureOfThisCpu.cpuProcessNanometers}">
											<td class="column2">${cpu1.architectureOfThisCpu.cpuProcessNanometers }nm
											</td>
											<td class="column3">${cpu2.architectureOfThisCpu.cpuProcessNanometers}nm<i
												class="fa fa-check" aria-hidden="true"></i></td>

										</c:if>
										<c:if
											test="${cpu1.architectureOfThisCpu.cpuProcessNanometers == cpu2.architectureOfThisCpu.cpuProcessNanometers}">
											<td class="column2">${cpu1.architectureOfThisCpu.cpuProcessNanometers }nm<i
												class="fa fa-check" aria-hidden="true"></i>
											</td>
											<td class="column3">${cpu2.architectureOfThisCpu.cpuProcessNanometers}nm<i
												class="fa fa-check" aria-hidden="true"></i></td>

										</c:if>
									</tr>

									<tr>
										<td class="column1"><spring:message
												code="add.form.l1Cache.label" /></td>
										<c:if test="${cpu1.l1Cache > cpu2.l1Cache}">
											<td class="column2">${cpu1.l1Cache }KB<i
												class="fa fa-check" aria-hidden="true"></i>
											</td>
											<td class="column3">${cpu2.l1Cache }KB</td>

										</c:if>
										<c:if test="${cpu1.l1Cache < cpu2.l1Cache}">
											<td class="column2">${cpu1.l1Cache }KB</td>
											<td class="column3">${cpu2.l1Cache }KB<i
												class="fa fa-check" aria-hidden="true"></i></td>

										</c:if>
										<c:if test="${cpu1.l1Cache == cpu2.l1Cache}">
											<td class="column2">${cpu1.l1Cache }KB<i
												class="fa fa-check" aria-hidden="true"></i>
											</td>
											<td class="column3">${cpu2.l1Cache }KB<i
												class="fa fa-check" aria-hidden="true"></i></td>

										</c:if>
									</tr>
									<tr>
										<td class="column1"><spring:message
												code="add.form.l2Cache.label" /></td>
										<c:if test="${cpu1.l2Cache > cpu2.l2Cache}">
											<td class="column2">${cpu1.l2Cache }KB<i
												class="fa fa-check" aria-hidden="true"></i>
											</td>
											<td class="column3">${cpu2.l2Cache }KB</td>

										</c:if>
										<c:if test="${cpu1.l2Cache < cpu2.l2Cache}">
											<td class="column2">${cpu1.l2Cache }KB</td>
											<td class="column3">${cpu2.l2Cache }KB<i
												class="fa fa-check" aria-hidden="true"></i></td>

										</c:if>
										<c:if test="${cpu1.l2Cache == cpu2.l2Cache}">
											<td class="column2">${cpu1.l2Cache }KB<i
												class="fa fa-check" aria-hidden="true"></i>
											</td>
											<td class="column3">${cpu2.l2Cache }KB<i
												class="fa fa-check" aria-hidden="true"></i></td>

										</c:if>
									</tr>
									<tr>
										<td class="column1"><spring:message
												code="add.form.l3Cache.label" /></td>
										<c:if test="${cpu1.l3Cache > cpu2.l3Cache}">
											<td class="column2">${cpu1.l3Cache }KB<i
												class="fa fa-check" aria-hidden="true"></i>
											</td>
											<td class="column3">${cpu2.l3Cache }KB</td>

										</c:if>
										<c:if test="${cpu1.l3Cache < cpu2.l3Cache}">
											<td class="column2">${cpu1.l3Cache }KB</td>
											<td class="column3">${cpu2.l3Cache }KB<i
												class="fa fa-check" aria-hidden="true"></i></td>

										</c:if>
										<c:if test="${cpu1.l3Cache == cpu2.l3Cache}">
											<td class="column2">${cpu1.l3Cache }KB<i
												class="fa fa-check" aria-hidden="true"></i>
											</td>
											<td class="column3">${cpu2.l3Cache }KB<i
												class="fa fa-check" aria-hidden="true"></i></td>

										</c:if>
									</tr>

									<tr>
										<td class="column1"><spring:message
												code="add.form.releaseDate.label" /></td>
										<td class="column2">${cpu1.releaseDate }</td>
										<td class="column3">${cpu2.releaseDate }</td>


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
									<p style="font-size: 16px;">
										<spring:message code="termsOfOverallGamingPerformance" />
										${cpu1.familyOfThisCpu.companyOfThisCpuFamily.name }
										${cpu1.familyOfThisCpu.name } ${cpu1.name }
										<c:if test="${cpu1.cpuBenchmark / cpu2.cpuBenchmark < 1.4}">
											<spring:message code="littleBitBetter" />
										</c:if>
										<c:if test="${cpu1.cpuBenchmark / cpu2.cpuBenchmark >= 1.4}">
											<spring:message code="massivelyBetter" />
										</c:if>

										${cpu2.familyOfThisCpu.companyOfThisCpuFamily.name }
										${cpu2.familyOfThisCpu.name } ${cpu2.name }
										<spring:message code="whenItComesToRunningGames" />

									</p>

									<c:if test="${cpu1.cpuBenchmark / cpu2.cpuBenchmark < 1.4}">

										<p style="font-size: 16px;">
											<spring:message code="bothCpusPerformance" />
										</p>
									</c:if>

									<p style="font-size: 16px;">
										<c:if test="${cpu1.physicalCores == cpu2.physicalCores }">
										${cpu1.familyOfThisCpu.companyOfThisCpuFamily.name }
										${cpu1.familyOfThisCpu.name } ${cpu1.name } and ${cpu2.familyOfThisCpu.companyOfThisCpuFamily.name }
										${cpu2.familyOfThisCpu.name } ${cpu2.name } both
										have ${cpu1.physicalCores} cores, which is not likely to be a
										limiting factor for gaming.
										</c:if>

										<c:if test="${cpu1.physicalCores > cpu2.physicalCores }">
${cpu1.familyOfThisCpu.companyOfThisCpuFamily.name }
										${cpu1.familyOfThisCpu.name } ${cpu1.name } 											<spring:message
												code="has" />
										 ${cpu1.physicalCores - cpu2.physicalCores } <spring:message
												code="moreCoresThanThe" /> ${cpu2.familyOfThisCpu.companyOfThisCpuFamily.name }
										${cpu2.familyOfThisCpu.name } ${cpu2.name }. <spring:message
												code="With" />  ${cpu1.physicalCores } <spring:message
												code="cores" /> , ${cpu1.familyOfThisCpu.companyOfThisCpuFamily.name }
										${cpu1.familyOfThisCpu.name } ${cpu1.name } <spring:message
												code="lessLikelyToBottleneck" />
										</c:if>

										<c:if test="${cpu1.physicalCores < cpu2.physicalCores }">
 ${cpu2.familyOfThisCpu.companyOfThisCpuFamily.name }
										${cpu2.familyOfThisCpu.name } ${cpu2.name } <spring:message
												code="has" /> ${cpu2.physicalCores - cpu1.physicalCores }<spring:message
												code="moreCoresThanThe" /> ${cpu1.familyOfThisCpu.companyOfThisCpuFamily.name }
										${cpu1.familyOfThisCpu.name } ${cpu1.name }. <spring:message
												code="with" /> ${cpu2.physicalCores } <spring:message
												code="cores" />, ${cpu2.familyOfThisCpu.companyOfThisCpuFamily.name }
										${cpu2.familyOfThisCpu.name } ${cpu2.name } <spring:message
												code="lessLikelyToBottleneck" />
										</c:if>

									</p>

									<p style="font-size: 16px;">
										<c:if
											test="${cpu1.threads > cpu1.physicalCores && cpu2.threads > cpu2.physicalCores }">
											<spring:message code="both" /> ${cpu1.familyOfThisCpu.companyOfThisCpuFamily.name }
										${cpu1.familyOfThisCpu.name } ${cpu1.name } <spring:message
												code="and" /> ${cpu2.familyOfThisCpu.companyOfThisCpuFamily.name }
										${cpu2.familyOfThisCpu.name } ${cpu2.name } <spring:message
												code="useHyperthreading" />.
										</c:if>

										<c:if
											test="${cpu1.threads > cpu1.physicalCores && cpu2.threads == cpu2.physicalCores }">
											<spring:message code="Only" />  ${cpu1.familyOfThisCpu.companyOfThisCpuFamily.name }
										${cpu1.familyOfThisCpu.name } ${cpu1.name } <spring:message
												code="useHyperthreading" />
										</c:if>

										<c:if
											test="${cpu1.threads == cpu1.physicalCores && cpu2.threads > cpu2.physicalCores }">
											<spring:message code="Only" />  ${cpu2.familyOfThisCpu.companyOfThisCpuFamily.name }
										${cpu2.familyOfThisCpu.name } ${cpu2.name } <spring:message
												code="useHyperthreading" />
										</c:if>
										<c:if
											test="${cpu1.threads == cpu1.physicalCores && cpu2.threads == cpu2.physicalCores }">
											<spring:message code="noHyperthreading" />
										</c:if>
									</p>

									<p style="font-size: 16px;">
										<spring:message code="multithreadingExplenation" />
									</p>

									<p style="font-size: 16px;">
										<spring:message code="clockRateExplenation" />
									</p>

									<p style="font-size: 16px;">
										<c:if
											test="${cpu1.architectureOfThisCpu.id == cpu2.architectureOfThisCpu.id }">
											<c:if test="${cpu1.cpuSpeed != cpu2.cpuSpeed }">
											  ${cpu1.familyOfThisCpu.companyOfThisCpuFamily.name }
										${cpu1.familyOfThisCpu.name } ${cpu1.name } 										<spring:message
													code="and" />
  ${cpu2.familyOfThisCpu.companyOfThisCpuFamily.name }
										${cpu2.familyOfThisCpu.name } ${cpu2.name } 						<spring:message
													code="areSameArch" /> (
										${cpu2.architectureOfThisCpu.name } ), <spring:message
													code="directlyComparable" />
												<c:if test="${cpu1.cpuSpeed > cpu2.cpuSpeed}"> ${cpu1.cpuSpeed - cpu2.cpuSpeed } </c:if>
												<c:if test="${cpu2.cpuSpeed > cpu1.cpuSpeed}"> ${cpu2.cpuSpeed - cpu1.cpuSpeed } </c:if>
												<spring:message code="fasterBaseClockRate" />, <c:if
													test="${cpu1.cpuSpeed > cpu2.cpuSpeed}">   ${cpu1.familyOfThisCpu.companyOfThisCpuFamily.name }
										${cpu1.familyOfThisCpu.name } ${cpu1.name } </c:if>
												<c:if test="${cpu2.cpuSpeed > cpu1.cpuSpeed}"> ${cpu2.familyOfThisCpu.companyOfThisCpuFamily.name }
										${cpu2.familyOfThisCpu.name } ${cpu2.name } </c:if>
												<spring:message code="managesProvideBetterPerformance" />
												<c:if test="${cpu1.cpuSpeed > cpu2.cpuSpeed}">${cpu2.familyOfThisCpu.companyOfThisCpuFamily.name }
										${cpu2.familyOfThisCpu.name } ${cpu2.name }. </c:if>
												<c:if test="${cpu2.cpuSpeed > cpu1.cpuSpeed}">${cpu1.familyOfThisCpu.companyOfThisCpuFamily.name }
										${cpu1.familyOfThisCpu.name } ${cpu1.name }. </c:if>
											</c:if>

											<c:if test="${cpu1.cpuSpeed == cpu2.cpuSpeed }">
												<spring:message code="both" />${cpu1.familyOfThisCpu.companyOfThisCpuFamily.name }
										${cpu1.familyOfThisCpu.name } ${cpu1.name } <spring:message
													code="and" /> ${cpu2.familyOfThisCpu.companyOfThisCpuFamily.name }
										${cpu2.familyOfThisCpu.name } ${cpu2.name } <spring:message
													code="sameCpuSpeed" />
											</c:if>


										</c:if>

										<c:if
											test="${cpu1.architectureOfThisCpu.id != cpu2.architectureOfThisCpu.id }">
The ${cpu1.familyOfThisCpu.companyOfThisCpuFamily.name }
										${cpu1.familyOfThisCpu.name } ${cpu1.name }. <spring:message
												code="and" /> ${cpu2.familyOfThisCpu.companyOfThisCpuFamily.name }
										${cpu2.familyOfThisCpu.name } ${cpu2.name }. <spring:message
												code="noSameArchitecture" />





										</c:if>


									</p>
									<p style="font-size: 16px;">
										<spring:message code="cacheExplanation" />

										<c:if test="${cpu1.l2Cache != cpu2.l2Cache }">
											<c:if test="${cpu1.l2Cache > cpu2.l2Cache }">
											 ${cpu1.familyOfThisCpu.companyOfThisCpuFamily.name }
										${cpu1.familyOfThisCpu.name } ${cpu1.name } <spring:message
													code="has" /> ${cpu1.l2Cache - cpu2.l2Cache } KB <spring:message
													code="biggerL2Cache" /> ${cpu2.familyOfThisCpu.companyOfThisCpuFamily.name }
										${cpu2.familyOfThisCpu.name } ${cpu2.name }, 										<spring:message
													code="whichMeans" />
.
										</c:if>

											<c:if test="${cpu1.l2Cache < cpu2.l2Cache }">
											The ${cpu2.familyOfThisCpu.companyOfThisCpuFamily.name }
										${cpu2.familyOfThisCpu.name } ${cpu2.name } <spring:message
													code="has" /> ${cpu2.l2Cache - cpu1.l2Cache } KB bigger L2 cache than the ${cpu1.familyOfThisCpu.companyOfThisCpuFamily.name }
										${cpu1.familyOfThisCpu.name } ${cpu1.name },<spring:message
													code="whichMeans" />
											</c:if>
										</c:if>
									</p>
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
