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
	<a href="?language=en">English</a>|
	<a href="?language=al">Albanian</a>

	<jsp:include page="/WEB-INF/jsp/navigation.jsp"></jsp:include>


	<section class="container">
		<form:errors path="*" cssClass="alert alert-danger" element="div" />

		<form:form class="form-horizontal" method="POST"
			modelAttribute="newGame" enctype="multipart/form-data">
			<fieldset>
				<legend style="padding-top: 20px; font-size: 37px;">
					<spring:message code="addGame.form.legend" />
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
					<label class="control-label col-lg-2 col-lg-2"><spring:message
							code="addGame.form.cpuLow.label" /></label>
					<div class="col-lg-10">
						<form:select path="cpuLow" class="form-control">
							<form:option value="">
								<spring:message code="addGpu.form.cpu.default" />
							</form:option>
							<form:options items="${allCpus}" />
						</form:select>
						<form:errors path="cpuLow" cssClass="text-danger" />

					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"><spring:message
							code="addGame.form.cpuMedium.label" /></label>
					<div class="col-lg-10">
						<form:select path="cpuMedium" class="form-control">
							<form:option value="">
								<spring:message code="addGpu.form.cpu.default" />
							</form:option>
							<form:options items="${allCpus}" />
						</form:select>
						<form:errors path="cpuMedium" cssClass="text-danger" />

					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"><spring:message
							code="addGame.form.cpuHigh.label" /></label>
					<div class="col-lg-10">
						<form:select path="cpuHigh" class="form-control">
							<form:option value="">
								<spring:message code="addGpu.form.cpu.default" />
							</form:option>
							<form:options items="${allCpus}" />
						</form:select>
						<form:errors path="cpuHigh" cssClass="text-danger" />

					</div>
				</div>



				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"><spring:message
							code="addGame.form.gpuLow.label" /></label>
					<div class="col-lg-10">
						<form:select path="gpuLow" class="form-control">
							<form:option value="">
								<spring:message code="addGame.form.gpu.default" />
							</form:option>
							<form:options items="${allGpus}" />
						</form:select>
						<form:errors path="gpuLow" cssClass="text-danger" />

					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"><spring:message
							code="addGame.form.gpuMedium.label" /></label>
					<div class="col-lg-10">
						<form:select path="gpuMedium" class="form-control">
							<form:option value="">
								<spring:message code="addGame.form.gpu.default" />
							</form:option>
							<form:options items="${allgpus}" />
						</form:select>
						<form:errors path="gpuMedium" cssClass="text-danger" />

					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"><spring:message
							code="addGame.form.gpuHigh.label" /></label>
					<div class="col-lg-10">
						<form:select path="gpuHigh" class="form-control">
							<form:option value="">
								<spring:message code="addGame.form.gpu.default" />
							</form:option>
							<form:options items="${allGpus}" />
						</form:select>
						<form:errors path="gpuHigh" cssClass="text-danger" />

					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"><spring:message
							code="addGame.form.directXMinimum.label" /></label>
					<div class="col-lg-10">
						<form:select path="directXMinimum" class="form-control">
							<form:option value="">
								<spring:message code="addGame.form.directXMinimum.default" />
							</form:option>
							<form:options items="${allDirectXs}" />
						</form:select>
						<form:errors path="directXMinimum" cssClass="text-danger" />

					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"><spring:message
							code="addGame.form.esrbRating.label" /></label>
					<div class="col-lg-10">
						<form:select path="esrbRating" class="form-control">
							<form:option value="">
								<spring:message code="addGame.form.esrbRating.default" />
							</form:option>
							<form:options items="${allEsrbRatings}" />
						</form:select>
						<form:errors path="esrbRating" cssClass="text-danger" />

					</div>
				</div>

				<spring:message code="add.form.ramLow.placeholder"
					var="ramLowPlaceholder" />

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="ramLow"><spring:message
							code="add.form.ramLow.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="ramLow" path="ramLow"
							placeholder="${ramLowPlaceholder}" class="form-control" />
						<form:errors path="ramLow" cssClass="text-danger" />

					</div>
				</div>


				<spring:message code="add.form.ramMedium.placeholder"
					var="ramMediumPlaceholder" />


				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="ramMedium"><spring:message
							code="add.form.ramMedium.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="ramMedium" path="ramMedium"
							placeholder="${ramMediumPlaceholder}" class="form-control" />
						<form:errors path="ramMedium" cssClass="text-danger" />

					</div>
				</div>


				<spring:message code="add.form.ramHigh.placeholder"
					var="ramHighPlaceholder" />


				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="ramHigh"><spring:message
							code="add.form.ramHigh.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="ramHigh" path="ramHigh"
							placeholder="${ramHighPlaceholder}" class="form-control" />
						<form:errors path="ramHigh" cssClass="text-danger" />

					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="ramHigh"><spring:message
							code="add.form.ramHigh.label" /></label>
					<div class="col-lg-10">

						<label>${category.name }</label>
						<form:checkboxes items="${allCategories }" path="categoryOfGames"
							value="${category }" />
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
