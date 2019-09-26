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
	<a
		href="?gpuFamily=${gpuFamily}&gpuArchitecture=${gpuArchitecture }&company=${company }&language=en">English</a>|
	<a
		href="?gpuFamily=${gpuFamily}&gpuArchitecture=${gpuArchitecture }&company=${company }&language=al">Albanian</a>

	<jsp:include page="/WEB-INF/jsp/navigation.jsp"></jsp:include>


	<section class="container">
		<form:errors path="*" cssClass="alert alert-danger" element="div" />

		<form:form class="form-horizontal" method="POST"
			modelAttribute="newGpu" enctype="multipart/form-data">
			<fieldset>
				<legend style="padding-top: 20px; font-size: 37px;">
					<spring:message code="addGpu.form.legend" />
				</legend>

				<spring:message code="add.form.name.placeholder"
					var="namePlaceholder" />
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="name"><spring:message
							code="add.form.name.label" /></label>
					<div class="col-lg-10">
						<form:input id="name" maxlength="50"
							placeholder="${namePlaceholder}" path="name" type="text"
							class="form-control" />

						<form:errors path="name" cssClass="text-danger" />

					</div>
				</div>

				<spring:message code="add.form.description.placeholder"
					var="descriptionPlaceholder" />

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="description"><spring:message
							code="add.form.description.label" /></label>
					<div class="col-lg-10">
						<form:textarea id="description"
							placeholder="${descriptionPlaceholder}" path="description"
							type="text" class="form-control" />
						<form:errors path="description" cssClass="text-danger" />

					</div>
				</div>

				<spring:message code="add.form.releaseDate.placeholder"
					var="releaseDatePlaceholder" />


				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="releaseDate"><spring:message
							code="add.form.releaseDate.label" /></label>
					<div class="col-lg-10">
						<form:input type="date" id="releaseDate"
							placeholder="${releaseDatePlaceholder}" path="date"
							class="form-control" />
						<form:errors path="date" cssClass="text-danger" />

					</div>
				</div>

				<spring:message code="add.form.tmu.placeholder" var="tmuPlaceholder" />


				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="tmu"><spring:message
							code="add.form.tmu.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="tmu" placeholder="${tmuPlaceholder}"
							path="tmu" class="form-control" />
						<form:errors path="tmu" cssClass="text-danger" />

					</div>
				</div>
				
			



				<spring:message code="add.form.textureRate.placeholder"
					var="textureRatePlaceholder" />

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="textureRate"><spring:message
							code="add.form.textureRate.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="textureRate" placeholder="${textureRatePlaceholder}"
							path="textureRate" class="form-control" />
						<form:errors path="textureRate" cssClass="text-danger" />

					</div>
				</div>


				<spring:message code="add.form.rop.placeholder" var="ropPlaceholder" />


				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="rop"><spring:message
							code="add.form.rop.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="rop" placeholder="${ropPlaceholder}"
							path="rop" class="form-control" />
						<form:errors path="rop" cssClass="text-danger" />

					</div>
				</div>

				<spring:message code="add.form.pixelRate.placeholder"
					var="pixelRatePlaceholder" />


				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="pixelRate"><spring:message
							code="add.form.pixelRate.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="pixelRate"
							placeholder="${pixelRatePlaceholder}" path="pixelRate"
							class="form-control" />
						<form:errors path="pixelRate" cssClass="text-danger" />

					</div>
				</div>

				<spring:message code="add.form.tdp.placeholder" var="tdpPlaceholder" />


				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="tdp"><spring:message
							code="add.form.tdp.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="tdp" placeholder="${tdpPlaceholder}"
							path="tdp" class="form-control" />
						<form:errors path="tdp" cssClass="text-danger" />

					</div>
				</div>


				<spring:message code="add.form.shaderProcessingUnits.placeholder"
					var="shaderProcessingUnitsPlaceholder" />


				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"
						for="shaderProcessingUnits"><spring:message
							code="add.form.shaderProcessingUnits.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="shaderProcessingUnits"
							placeholder="${shaderProcessingUnitsPlaceholder}"
							path="shaderProcessingUnits" class="form-control" />
						<form:errors path="shaderProcessingUnits" cssClass="text-danger" />

					</div>
				</div>


				<spring:message code="add.form.rayTracingCores.placeholder"
					var="rayTracingCoresPlaceholder" />


				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"
						for="rayTracingCores"><spring:message
							code="add.form.rayTracingCores.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="rayTracingCores"
							placeholder="${rayTracingCoresPlaceholder}"
							path="rayTracingCores" class="form-control" />
						<form:errors path="rayTracingCores" cssClass="text-danger" />

					</div>
				</div>

				<spring:message code="add.form.tensorCores.placeholder"
					var="tensorCoresPlaceholder" />


				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="tensorCores"><spring:message
							code="add.form.tensorCores.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="tensorCores"
							placeholder="${tensorCoresPlaceholder}" path="tensorCores"
							class="form-control" />
						<form:errors path="tensorCores" cssClass="text-danger" />

					</div>
				</div>

				<spring:message code="add.form.driverSupport.placeholder"
					var="driverSupportPlaceholder" />


				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="driverSupport"><spring:message
							code="add.form.driverSupport.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="driverSupport"
							placeholder="${driverSupportPlaceholder}" step="0.1" min="1"
							max="5" path="driverSupport" class="form-control" />
						<form:errors path="driverSupport" cssClass="text-danger" />

					</div>
				</div>
				
				<spring:message code="add.form.shader.placeholder"
					var="shaderPlaceholder" />
					
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="shader"><spring:message
							code="add.form.shader.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="shader"
							placeholder="${shaderPlaceholder}" step="0.1" min="1"
							max="5" path="shader" class="form-control" />
						<form:errors path="shader" cssClass="text-danger" />

					</div>
				</div>
				
				<spring:message code="add.form.openGL.placeholder"
					var="openGLPlaceholder" />
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="openGL"><spring:message
							code="add.form.openGL.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="openGL"
							placeholder="${openGLPlaceholder}" step="0.1" min="1"
							max="5" path="openGL" class="form-control" />
						<form:errors path="openGL" cssClass="text-danger" />

					</div>
				</div>

				<spring:message code="add.form.gpuBenchmark.placeholder"
					var="gpuBenchmarkPlaceholder" />

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="gpuBenchmark"><spring:message
							code="add.form.gpuBenchmark.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="gpuBenchmark"
							placeholder="${gpuBenchmarkPlaceholder}" path="gpuBenchmark"
							class="form-control" />
						<form:errors path="gpuBenchmark" cssClass="text-danger" />

					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"><spring:message
							code="addGpu.form.gpuMemoryTechnology.label" /></label>
					<div class="col-lg-10">
						<form:select path="memoryTechnologyOfThisGpu" class="form-control">
							<form:option value=""><spring:message code="addGpu.form.gpuMemoryTechnology.default" /></form:option>
							<form:options items="${gpuMemoryTechnologies}" />
						</form:select>
						<form:errors path="memoryTechnologyOfThisGpu" cssClass="text-danger" />

					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"><spring:message
							code="addGpu.form.directX.label" /></label>
					<div class="col-lg-10">
						<form:select path="maximumDirectXSupportedByThisGpu" class="form-control">
							<form:option value=""><spring:message code="addGpu.form.directX.default" /></form:option>
							<form:options items="${directXs}" />
						</form:select>
						<form:errors path="maximumDirectXSupportedByThisGpu" cssClass="text-danger" />

					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"><spring:message
							code="addGpu.form.gpuSlot.label" /></label>
					<div class="col-lg-10">
						<form:select path="gpuSlotOfThisGpu" class="form-control">
							<form:option value=""><spring:message code="addGpu.form.gpuSlot.default" /></form:option>
							<form:options items="${gpuSlots}" />
						</form:select>
						<form:errors path="gpuSlotOfThisGpu" cssClass="text-danger" />

					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"><spring:message
							code="addGpu.form.cpu.label" /></label>
					<div class="col-lg-10">
						<form:select path="cpuRecommendedForThisGpu" class="form-control">
							<form:option value=""><spring:message code="addGpu.form.cpu.default" /></form:option>
							<form:options items="${cpus}" />
						</form:select>
						<form:errors path="cpuRecommendedForThisGpu" cssClass="text-danger" />

					</div>
				</div>

				<spring:message code="add.form.memorySize.placeholder"
					var="memorySizePlaceholder" />

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="memorySize"><spring:message
							code="add.form.memorySize.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="memorySize"
							placeholder="${memorySizePlaceholder}" path="memorySize"
							class="form-control" />
						<form:errors path="memorySize" cssClass="text-danger" />

					</div>
				</div>

				<spring:message code="add.form.memorySpeed.placeholder"
					var="memorySpeedPlaceholder" />

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="memorySpeed"><spring:message
							code="add.form.memorySpeed.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="memorySpeed"
							placeholder="${memorySpeedPlaceholder}" path="memorySpeed"
							class="form-control" />
						<form:errors path="memorySpeed" cssClass="text-danger" />

					</div>
				</div>

				<spring:message code="add.form.memoryBus.placeholder"
					var="memoryBusPlaceholder" />

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="memoryBus"><spring:message
							code="add.form.memoryBus.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="memoryBus"
							placeholder="${memoryBusPlaceholder}" path="memoryBus"
							class="form-control" />
						<form:errors path="memoryBus" cssClass="text-danger" />

					</div>
				</div>


				<spring:message code="add.form.memoryBandwidth.placeholder"
					var="memoryBandwidthPlaceholder" />

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="memoryBandwidth"><spring:message
							code="add.form.memoryBandwidth.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="memoryBandwidth"
							placeholder="${memoryBandwidthPlaceholder}" path="memoryBandwidth"
							class="form-control" />
						<form:errors path="memoryBandwidth" cssClass="text-danger" />

					</div>
				</div>


				<spring:message code="add.form.cache.placeholder"
					var="cachePlaceholder" />

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="cache"><spring:message
							code="add.form.cache.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="cache"
							placeholder="${cachePlaceholder}" path="cache"
							class="form-control" />
						<form:errors path="cache" cssClass="text-danger" />

					</div>
				</div>


				<spring:message code="add.form.coreSpeed.placeholder"
					var="coreSpeedPlaceholder" />

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="coreSpeed"><spring:message
							code="add.form.coreSpeed.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="coreSpeed"
							placeholder="${coreSpeedPlaceholder}" path="coreSpeed"
							class="form-control" />
						<form:errors path="coreSpeed" cssClass="text-danger" />

					</div>
				</div>

				<spring:message code="add.form.boostClock.placeholder"
					var="boostClockPlaceholder" />

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="boostClock"><spring:message
							code="add.form.boostClock.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="boostClock"
							placeholder="${boostClockPlaceholder}" path="boostClock"
							class="form-control" />
						<form:errors path="boostClock" cssClass="text-danger" />

					</div>
				</div>





				<spring:message code="add.form.hyperlink.placeholder"
					var="hyperlinkPlaceholder" />


				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="hyperlink"><spring:message
							code="add.form.hyperlink.label" /></label>
					<div class="col-lg-10">
						<form:input id="hyperlink" path="hyperlink"
							placeholder="${hyperlinkPlaceholder}" type="text"
							class="form-control" />
						<form:errors path="hyperlink" cssClass="text-danger" />

					</div>
				</div>

				<spring:message code="add.form.price.placeholder"
					var="pricePlaceholder" />


				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="price"><spring:message
							code="add.form.price.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="price" path="price"
							placeholder="${pricePlaceholder}" class="form-control" />
						<form:errors path="price" cssClass="text-danger" />

					</div>
				</div>

				<spring:message code="add.form.quantity.placeholder"
					var="quantityPlaceholder" />


				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="quantity"><spring:message
							code="add.form.quantity.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="quantity" path="quantity"
							placeholder="${quantityPlaceholder}" class="form-control" />
						<form:errors path="quantity" cssClass="text-danger" />

					</div>
				</div>

				




				<div class="form-group">
					<label class="control-label col-lg-2" for="image"> <spring:message
							code="addCpu.form.image.label" />
					</label>
					<div class="input-file-container">
						<form:input id="image" path="image" type="file" class="input-file" />
						<label tabindex="0" for="image" class="input-file-trigger">
							<spring:message code="add.form.image.imageUpload" />
						</label> <span class="file-return" hidden="true"><spring:message
								code="add.form.image.success" /></span> <span
							class="file-return-error" hidden="true"><spring:message
								code="add.form.image.error" /></span> <span
							class="file-return-size-error" hidden="true"><spring:message
								code="add.form.image.error.size" /></span>
						<form:errors path="image" cssClass="text-danger" />
						<c:if test="${not empty errors}">
							<span style="color: red;"> ${errors } </span>
						</c:if>
					</div>

				</div>


				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn
 btn-primary"
							value="<spring:message
							code="add.form.submit.label" />" />
					</div>
				</div>



			</fieldset>
		</form:form>
	</section>

	<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>

	<jsp:include page="/WEB-INF/jsp/scripts.jsp" />

	<script src="<c:url value="/js/fileupload.js"></c:url>"></script>

</body>
</html>
