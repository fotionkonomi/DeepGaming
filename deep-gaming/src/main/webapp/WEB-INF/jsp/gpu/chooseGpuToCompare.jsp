<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<jsp:include page="/WEB-INF/jsp/head.jsp" />
<link type="text/css" rel="stylesheet"
	href="<c:url value="/css/table.css"/>" />

</head>
<body>
	<jsp:include page="/WEB-INF/jsp/body.jsp"></jsp:include>
	<a href="?page=${currentPage }&language=en">English</a>|
	<a href="?page=${currentPage }&language=al">Albanian</a>

	<jsp:include page="/WEB-INF/jsp/navigation.jsp"></jsp:include>

	<section class="container">

		<span id="defaultValue" hidden="true"><spring:message
				code="addGpu.form.gpuFamily.option" /></span> <span id="defaultGpuValue"
			hidden="true"><spring:message
				code="compare.form.gpu.defOption" /></span> <span id="gpuId" hidden="true">${gpu.id }</span>


		<form id="form" action="">
			<fieldset>
				<center>
					<spring:message code="select.gpuToBeCompared" />
					${gpu.familyOfThisGpu.companyOfThisGpuFamily.name }
					${gpu.familyOfThisGpu.name } ${gpu.name }
				</center>

				<br />
				<div class="form-group">
					<br /> <label class="control-label col-lg-2 col-lg-2"><spring:message
							code="add.form.chooseCompany.product.label" /></label>
					<div class="col-lg-10">
						<select id="selectCompany" class="form-control">
							<option value="NoComp404">
								<spring:message code="add.form.chooseCompany.default" />
							</option>
							<c:forEach items="${companies }" var="company">

								<option value="${company.name}">${company.name }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<br /> <br />

				<div id="divGpuFamily" class="form-group" hidden="true">
					<label class="control-label col-lg-2 col-lg-2"><spring:message
							code="addGpu.form.gpuFamily.label" /></label>
					<div class="col-lg-10">
						<select id="selectFamily" class="form-control">

						</select>
					</div>
				</div>

				<br /> <br />

				<div id="divGpu" class="form-group" hidden="true">
					<label class="control-label col-lg-2 col-lg-2"><spring:message
							code="add.form.compare.findGpu" /></label>
					<div class="col-lg-10">
						<select id="selectGpu" class="form-control">

						</select>
					</div>
				</div>



				<div class="form-group">
					<br /> <br />
					<div class="col-lg-offset-2 col-lg-10 float-right">
						<a id="a" id="btnAdd" class="btn btn-primary disabled"> <spring:message
								code="add.form.next" />
						</a>
					</div>
				</div>
			</fieldset>
		</form>


	</section>




	<jsp:include page="/WEB-INF/jsp/scripts.jsp" />
	<script>
		$('#selectCompany')
				.change(
						function() {
							$('#selectGpu').empty();
							$('#selectFamily').empty();
							enableOrDisableNextButton();
							var companyName = $(this).val();
							$('#divGpu').attr("hidden", "true");
							if (companyName == "NoComp404") {
								$('#divGpuFamily').attr("hidden", "true");
								return;
							}
							$
									.ajax({
										method : 'GET',
										url : "gpu-rest/" + companyName,
										success : function(data) {
											$('#divGpuFamily').removeAttr(
													"hidden");
											var selectGpuFamily = $('#selectFamily'), option = "";
											selectGpuFamily.empty();
											option = "<option value='-999'>"
													+ $('#defaultValue').text()
													+ "</option>";
											for (var i = 0; i < data.length; i++) {
												option = option
														+ "<option value='" + data[i].id +"'>"
														+ data[i].name
														+ "</option>";
											}
											selectGpuFamily.append(option);
										},
										error : function() {
										}
									});
						});
		$('#selectFamily')
				.change(
						function() {
							$('#selectGpu').empty();
							enableOrDisableNextButton();
							var gpuFamily = $(this).val();
							if (gpuFamily == "-999") {
								$('#divGpu').attr("hidden", "true");
								return;
							}
							$
									.ajax({
										method : 'GET',
										url : "gpu-rest/gpuFamily/" + gpuFamily,
										success : function(data) {
											$('#divGpu').removeAttr("hidden");
											var selectGpu = $('#selectGpu'), option = "";
											selectGpu.empty();
											option = "<option value=''>"
													+ $('#defaultGpuValue')
															.text()
													+ "</option>";
											for (var i = 0; i < data.length; i++) {
												if (data[i].id == $('#gpuId')
														.text()) {
													continue;
												}
												option = option
														+ "<option value='" + data[i].id +"'>"
														+ data[i].familyOfThisGpu.companyOfThisGpuFamily.name
														+ " "
														+ data[i].familyOfThisGpu.name
														+ " " + data[i].name
														+ "</option>";
											}
											selectGpu.append(option);
										},
										error : function() {
										}
									});
						});
		$('#selectGpu').change(function() {
			enableOrDisableNextButton();
		});
		function enableOrDisableNextButton() {
			if ($('#selectGpu').val() == null || $('#selectGpu').val() == "") {
				$('#a').attr("class", "btn btn-primary disabled");
				$('#a').removeAttr("href");
			} else {
				$('#a').attr("class", "btn btn-primary");
				$('#a').attr(
						"href",
						"compare?gpu1=" + $('#gpuId').text() + "&gpu2="
								+ $('#selectGpu').val());
			}
		}
	</script>
</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />





</html>