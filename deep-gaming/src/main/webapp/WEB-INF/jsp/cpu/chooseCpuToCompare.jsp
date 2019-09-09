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
				code="addCpu.form.cpuFamily.option" /></span> <span id="defaultCpuValue"
			hidden="true"><spring:message
				code="compare.form.cpu.defOption" /></span> <span id="cpuId" hidden="true">${cpu.id }</span>


		<form id="form" action="">
			<fieldset>
				<center>
					<spring:message code="select.cpuToBeCompared" />
					${cpu.familyOfThisCpu.companyOfThisCpuFamily.name }
					${cpu.familyOfThisCpu.name } ${cpu.name }
				</center>

				<br />
				<div class="form-group">
					<br /> <label class="control-label col-lg-2 col-lg-2"><spring:message
							code="add.form.chooseCompany.cpu.label" /></label>
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

				<div id="divCpuFamily" class="form-group" hidden="true">
					<label class="control-label col-lg-2 col-lg-2"><spring:message
							code="addCpu.form.cpuFamily.label" /></label>
					<div class="col-lg-10">
						<select id="selectFamily" class="form-control">

						</select>
					</div>
				</div>

				<br /> <br />

				<div id="divCpu" class="form-group" hidden="true">
					<label class="control-label col-lg-2 col-lg-2"><spring:message
							code="add.form.compare.findCpu" /></label>
					<div class="col-lg-10">
						<select id="selectCpu" class="form-control">

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
							$('#selectCpu').empty();
							$('#selectFamily').empty();

							enableOrDisableNextButton();
							var companyName = $(this).val();
							$('#divCpu').attr("hidden", "true");

							if (companyName == "NoComp404") {
								$('#divCpuFamily').attr("hidden", "true");

								return;
							}

							$
									.ajax({
										method : 'GET',
										url : "cpu-rest/" + companyName,
										success : function(data) {

											$('#divCpuFamily').removeAttr(
													"hidden");
											var selectCpuFamily = $('#selectFamily'), option = "";
											selectCpuFamily.empty();
											option = "<option value='-999'>"
													+ $('#defaultValue').text()
													+ "</option>";
											for (var i = 0; i < data.length; i++) {
												option = option
														+ "<option value='" + data[i].id +"'>"
														+ data[i].name
														+ "</option>";
											}
											selectCpuFamily.append(option);
										},
										error : function() {
										}
									});
						});

		$('#selectFamily')
				.change(
						function() {
							$('#selectCpu').empty();
							enableOrDisableNextButton();
							var cpuFamily = $(this).val();
							if (cpuFamily == "-999") {
								$('#divCpu').attr("hidden", "true");
								return;
							}
							$
									.ajax({
										method : 'GET',
										url : "cpu-rest/cpuFamily/" + cpuFamily,
										success : function(data) {

											$('#divCpu').removeAttr("hidden");
											var selectCpu = $('#selectCpu'), option = "";
											selectCpu.empty();
											option = "<option value=''>"
													+ $('#defaultCpuValue')
															.text()
													+ "</option>";
											for (var i = 0; i < data.length; i++) {
												if (data[i].id == $('#cpuId')
														.text()) {
													continue;
												}
												option = option
														+ "<option value='" + data[i].id +"'>"
														+ data[i].familyOfThisCpu.companyOfThisCpuFamily.name
														+ " "
														+ data[i].familyOfThisCpu.name
														+ " " + data[i].name
														+ "</option>";
											}
											selectCpu.append(option);
										},
										error : function() {
										}
									});
						});

		$('#selectCpu').change(function() {
			enableOrDisableNextButton();
		});

		function enableOrDisableNextButton() {

			if ($('#selectCpu').val() == null || $('#selectCpu').val() == "") {
				$('#a').attr("class", "btn btn-primary disabled");
				$('#a').removeAttr("href");
			} else {
				$('#a').attr("class", "btn btn-primary");
				$('#a').attr(
						"href",
						"compare?cpu1=" + $('#cpuId').text() + "&cpu2="
								+ $('#selectCpu').val());

			}
		}
	</script>
</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />





</html>