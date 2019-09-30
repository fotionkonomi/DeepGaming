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
	<a href="?id=${motherboard.id }&language=en">English</a>|
	<a href="?id=${motherboard.id }&language=al">Albanian</a>

	<jsp:include page="/WEB-INF/jsp/navigation.jsp"></jsp:include>


	<section class="container">
		<form:errors path="*" cssClass="alert alert-danger" element="div" />

		<form:form class="form-horizontal" method="POST"
			modelAttribute="motherboard" enctype="multipart/form-data">
			<fieldset>
				<legend style="padding-top: 20px; font-size: 37px;">
					<spring:message code="updateMotherboard.form.legend" />
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
				
				<spring:message code="add.form.maximumRamCapacity.placeholder"
					var="maximumRamCapacityPlaceholder" />
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="cpuSpeed"><spring:message
							code="add.form.maximumRamCapacity.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="maximumRamCapacity" step="0.1" min="1"
						    placeholder="${maximumRamCapacityPlaceholder}" path="maximumRamCapacity"
							class="form-control" />
						<form:errors path="maximumRamCapacity" cssClass="text-danger" />

					</div>
				</div>
				
				<spring:message code="add.form.maximumRamSpeed.placeholder"
					var="maximumRamSpeedPlaceholder" />
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="cpuSpeed"><spring:message
							code="add.form.maximumRamSpeed.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="maximumRamSpeed" step="1" min="1"
						    placeholder="${maximumRamSpeedPlaceholder}" path="maximumRamSpeed"
							class="form-control" />
						<form:errors path="maximumRamSpeed" cssClass="text-danger" />

					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"><spring:message
							code="addCpuFamily.form.company.label" /></label>
					<div class="col-lg-10">
						<form:select path="companyOfThisMotherboard" class="form-control">
							<form:option value="">
								<spring:message code="add.form.select.company.default" />
							</form:option>
							<form:options items="${allCompanies}" />
						</form:select>
						<form:errors path="companyOfThisMotherboard"
							cssClass="text-danger" />

					</div>
				</div>



				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"><spring:message
							code="addMotherboard.form.formFactor.label" /></label>
					<div class="col-lg-10">
						<form:select path="formFactorOfThisMotherboard" class="form-control">
							<form:option value="">
								<spring:message code="addMotherboard.form.formFactor.default" />
							</form:option>
							<form:options items="${allMotherboardFormFactors}" />
						</form:select>
						<form:errors path="formFactorOfThisMotherboard" cssClass="text-danger" />

					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"><spring:message
							code="addMotherboard.form.cpuSocket.label" /></label>
					<div class="col-lg-10">
						<form:select path="cpuSocketOfThisMotherboard" class="form-control">
							<form:option value="">
								<spring:message code="addMotherboard.form.cpuSocket.default" />
							</form:option>
							<form:options items="${allCpuSockets}" />
						</form:select>
						<form:errors path="cpuSocketOfThisMotherboard" cssClass="text-danger" />

					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"><spring:message
							code="addMotherboard.form.gpuSlotOfThisMotherboard.label" /></label>
					<div class="col-lg-10">
						<form:select path="gpuSlotOfThisMotherboard" class="form-control">
							<form:option value="">
								<spring:message code="addMotherboard.form.gpuSlotOfThisMotherboard.default" />
							</form:option>
							<form:options items="${allGpuSlots}" />
						</form:select>
						<form:errors path="gpuSlotOfThisMotherboard" cssClass="text-danger" />

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
