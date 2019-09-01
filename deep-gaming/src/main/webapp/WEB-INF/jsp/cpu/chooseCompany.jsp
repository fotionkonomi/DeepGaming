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

		<form id="form" action="">
			<fieldset>


				<div class="form-group">
				<br/>
					<label class="control-label col-lg-2 col-lg-2" for="name"><spring:message
							code="add.form.chooseCompany.cpu.label" /></label>
					<div class="col-lg-10">
						<select id="select" class="form-control">
						<option><spring:message
							code="add.form.chooseCompany.default" /></option>
							<c:forEach items="${companies }" var="company">
								
								<option>${company.name }</option>
							</c:forEach>
						</select>
					</div>
				</div>


				<div class="form-group">
				<br/><br/>
					<div class="col-lg-offset-2 col-lg-10 float-right">
						<a id="a" href="" id="btnAdd" class="btn btn-primary"> <spring:message
							code="add.form.next" /> </a>
					</div>
				</div>
			</fieldset>
		</form>


	</section>

	<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>

	<jsp:include page="/WEB-INF/jsp/scripts.jsp" />

	<script>
		$('#select').change(function() {
			var action = $(this).val();
			$('#a').attr('href', "add?company=" + action);
		});
	</script>
</body>
</html>