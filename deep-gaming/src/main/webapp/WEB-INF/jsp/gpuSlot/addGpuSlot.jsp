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

		<form:form class="form-horizontal"
			method="POST" modelAttribute="newGpuSlot"
			enctype="multipart/form-data">
			<fieldset>
				<legend style="padding-top: 20px; font-size: 37px;">
					<spring:message code="addGpuSlot.form.legend" />
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
						<c:if test="${param.error != null}">
							<span style="color: red;"><spring:message
									code="addGpuSlot.form.name.error" /></span>
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

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"
						for="laptopOrDesktop"><spring:message
							code="addGpuSlot.form.laptop/desktop.label" /></label>
					<div class="col-lg-10">
						<form:radiobutton id="laptopOrDesktop" path="laptopOrDesktop"
							value="true" />
						&nbsp;Laptop
						<form:radiobutton id="laptopOrDesktop" path="laptopOrDesktop"
							value="false" />
						Desktop
						<form:errors path="laptopOrDesktop" cssClass="text-danger" />

					</div>
				</div>



				<div class="form-group">
					<label class="control-label col-lg-2" for="image"> <spring:message
							code="addGpuSlot.form.image.label" />
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
