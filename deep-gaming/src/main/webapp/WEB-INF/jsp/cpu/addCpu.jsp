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
	<a href="?company=${company}&language=en">English</a>|
	<a href="?company=${company }&language=al">Albanian</a>

	<jsp:include page="/WEB-INF/jsp/navigation.jsp"></jsp:include>


	<section class="container">
		<form:errors path="*" cssClass="alert alert-danger" element="div" />

		<form:form class="form-horizontal" method="POST"
			modelAttribute="newCpu" enctype="multipart/form-data">
			<fieldset>
				<legend style="padding-top: 20px; font-size: 37px;">
					<spring:message code="addCpu.form.legend" />
				</legend>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"><spring:message
							code="addCpu.form.cpuFamily.label" /></label>
					<div class="col-lg-10">
						<form:select path="familyOfThisCpu" class="form-control">
							<option value="0">
								<spring:message code="addCpu.form.cpuFamily.option" />
							</option>
							<form:options items="${cpuFamilies}" />
						</form:select>
						<form:errors path="familyOfThisCpu" cssClass="text-danger" />

					</div>
				</div>

				<spring:message code="add.form.name.placeholder"
					var="namePlaceholder" />
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="name"><spring:message
							code="add.form.name.label" /></label>
					<div class="col-lg-10">
						<form:input id="name" maxlength="50"
							placeholder="${namePlaceholder}" path="name" type="text"
							class="form-control" />
						<c:if test="${param.error != null}">
							<span style="color: red;"><spring:message
									code="addCpu.form.name.error" /></span>
						</c:if>
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

				<spring:message code="add.form.cpuSpeed.placeholder"
					var="cpuSpeedPlaceholder" />


				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="cpuSpeed"><spring:message
							code="add.form.cpuSpeed.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="cpuSpeed"
							placeholder="${cpuSpeedPlaceholder}" path="cpuSpeed"
							class="form-control" />
						<form:errors path="cpuSpeed" cssClass="text-danger" />

					</div>
				</div>



				<spring:message code="add.form.turboSpeed.placeholder"
					var="turboSpeedPlaceholder" />

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="cpuSpeed"><spring:message
							code="add.form.turboSpeed.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="turboSpeed"
							placeholder="${turboSpeedPlaceholder}" path="turboSpeed"
							class="form-control" />
						<form:errors path="turboSpeed" cssClass="text-danger" />

					</div>
				</div>


				<spring:message code="add.form.physicalCores.placeholder"
					var="physicalCoresPlaceholder" />


				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="physicalCores"><spring:message
							code="add.form.physicalCores.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="physicalCores"
							placeholder="${physicalCoresPlaceholder}" path="physicalCores"
							class="form-control" />
						<form:errors path="physicalCores" cssClass="text-danger" />

					</div>
				</div>

				<spring:message code="add.form.threads.placeholder"
					var="threadsPlaceholder" />


				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="threads"><spring:message
							code="add.form.threads.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="threads"
							placeholder="${threadsPlaceholder}" path="threads"
							class="form-control" />
						<form:errors path="threads" cssClass="text-danger" />

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


				<spring:message code="add.form.bitWidth.placeholder"
					var="bitWidthPlaceholder" />


				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="bitWidth"><spring:message
							code="add.form.bitWidth.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="bitWidth"
							placeholder="${bitWidthPlaceholder}" path="bitWidth"
							class="form-control" />
						<form:errors path="bitWidth" cssClass="text-danger" />

					</div>
				</div>


				<spring:message code="add.form.l1Cache.placeholder"
					var="l1CachePlaceholder" />


				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="l1Cache"><spring:message
							code="add.form.l1Cache.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="l1Cache"
							placeholder="${l1CachePlaceholder}" path="l1Cache"
							class="form-control" />
						<form:errors path="l1Cache" cssClass="text-danger" />

					</div>
				</div>

				<spring:message code="add.form.l2Cache.placeholder"
					var="l2CachePlaceholder" />


				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="l2Cache"><spring:message
							code="add.form.l2Cache.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="l2Cache"
							placeholder="${l2CachePlaceholder}" path="l2Cache"
							class="form-control" />
						<form:errors path="l2Cache" cssClass="text-danger" />

					</div>
				</div>

				<spring:message code="add.form.l3Cache.placeholder"
					var="l3CachePlaceholder" />


				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="l3Cache"><spring:message
							code="add.form.l3Cache.label" /></label>
					<div class="col-lg-10">
						<form:input type="number" id="l3Cache"
							placeholder="${l3CachePlaceholder}" path="l3Cache"
							class="form-control" />
						<form:errors path="l3Cache" cssClass="text-danger" />

					</div>
				</div>


				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"><spring:message
							code="addCpu.form.socketOfThisCpu.label" /></label>
					<div class="col-lg-10">
						<form:select path="socketOfThisCpu" class="form-control">
							<form:option value="">
								<spring:message code="addCpu.form.socketOfThisCpu.option" />
							</form:option>
							<form:options items="${cpuSockets}" />
						</form:select>
						<form:errors path="socketOfThisCpu" cssClass="text-danger" />

					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"><spring:message
							code="addCpu.form.architectureOfThisCpu.label" /></label>
					<div class="col-lg-10">
						<form:select path="architectureOfThisCpu" class="form-control">
							<form:option value="">
								<spring:message code="addCpu.form.architectureOfThisCpu.option" />
							</form:option>
							<form:options items="${cpuArchitectures}" />
						</form:select>
						<form:errors path="architectureOfThisCpu" cssClass="text-danger" />

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
