<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>


<jsp:include page="head.jsp" />
<link type="text/css" rel="stylesheet"
	href="<c:url value="/css/fileupload.css"/>" />

</head>
<body>
	<jsp:include page="body.jsp"></jsp:include>
	<a href="?language=en">English</a>|
	<a href="?language=al">Albanian</a>

	<jsp:include page="navigation.jsp"></jsp:include>


	<section class="container">
		<form:errors path="*" cssClass="alert alert-danger" element="div" />

		<form:form class="form-horizontal" method="POST"
			modelAttribute="newCompany" enctype="multipart/form-data">
			<fieldset>
				<legend style="padding-top: 20px; font-size: 37px;">Add new
					company</legend>

				<spring:message code="addCompany.form.name.placeholder"
					var="namePlaceholder" />
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="name"><spring:message
							code="addCompany.form.name.label" /></label>
					<div class="col-lg-10">
						<form:input id="name" maxlength="50"
							placeholder="${namePlaceholder}" path="name" type="text"
							class="form-control" />
						<c:if test="${param.error != null}">
							<span style="color: red;"><spring:message
									code="addCompany.form.name.error" /></span>
						</c:if>
						<form:errors path="name" cssClass="text-danger" />

					</div>
				</div>

				<spring:message code="addCompany.form.description.placeholder"
					var="descriptionPlaceholder" />

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="description"><spring:message
							code="addCompany.form.description.label" /></label>
					<div class="col-lg-10">
						<form:textarea id="description"
							placeholder="${descriptionPlaceholder}" path="description"
							type="text" class="form-control" />
						<form:errors path="description" cssClass="text-danger" />

					</div>
				</div>

				<spring:message code="addCompany.form.hyperlink.placeholder"
					var="hyperlinkPlaceholder" />


				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="hyperlink"><spring:message
							code="addCompany.form.hyperlink.label" /></label>
					<div class="col-lg-10">
						<form:input id="hyperlink" path="hyperlink"
							placeholder="${hyperlinkPlaceholder}" type="text"
							class="form-control" />
						<form:errors path="hyperlink" cssClass="text-danger" />

					</div>
				</div>



				<div class="form-group">
					<label class="control-label col-lg-2" for="companyImage"> <spring:message
							code="addCompany.form.companyImage.label" />
					</label>
					<div class="input-file-container">
						<form:input id="companyImage" path="image" type="file"
							class="input-file" />
						<label tabindex="0" for="companyImage" class="input-file-trigger">
							<spring:message code="addCompany.form.companyImage.imageUpload" />
						</label> <span class="file-return" hidden="true"><spring:message
								code="addCompany.form.image.success" /></span> <span
							class="file-return-error" hidden="true"><spring:message
								code="addCompany.form.image.error" /></span>
								<span class="file-return-size-error" hidden="true"><spring:message
								code="addCompany.form.image.error.size" /></span>
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
							code="addCompany.form.submit.label" />" />
					</div>
				</div>



			</fieldset>
		</form:form>
	</section>

	<jsp:include page="footer.jsp"></jsp:include>

	<jsp:include page="scripts.jsp" />


	<script src="<c:url value="/js/fileupload.js"></c:url>"></script>
	
</body>
</html>
