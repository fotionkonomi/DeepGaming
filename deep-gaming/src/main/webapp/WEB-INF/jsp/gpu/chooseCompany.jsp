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
					<br /> <label class="control-label col-lg-2 col-lg-2" for="name"><spring:message
							code="add.form.chooseCompany.product.label" /></label>
					<div class="col-lg-10">
						<select id="select" class="form-control">
							<option value=""><spring:message
									code="add.form.chooseCompany.default" /></option>
							<c:forEach items="${companies }" var="company">

								<option>${company.name }</option>
							</c:forEach>
						</select>
					</div>
				</div>


				<div class="form-group">
					<br />
					<br />
					<div class="col-lg-offset-2 col-lg-10 float-right">
						<a id="a" id="btnAdd" class="btn btn-primary disabled">
							<spring:message code="add.form.next" />
						</a>
					</div>
				</div>
			</fieldset>
		</form>


	</section>

	<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>

	<jsp:include page="/WEB-INF/jsp/scripts.jsp" />

	<script>
		$('document').ready(function() {
			if($('#select').val()) {
				var action = $('#select').val();
				$('#a').attr('href', "chooseSocketArchitectureFamily?company=" + action);
				$('#a').attr('class', "btn btn-primary");
			}
		});
	
		$('#select').change(function() {
			if ( $(this).val() != "") {
				var action = $(this).val();
				$('#a').attr('href', "chooseSelects?company=" + action);
				$('#a').attr('class', "btn btn-primary");
			} else {
				$('#a').removeAttr('href');
				$('#a').attr('class', "btn btn-primary disabled");

			}
		});
	</script>
</body>
</html>
