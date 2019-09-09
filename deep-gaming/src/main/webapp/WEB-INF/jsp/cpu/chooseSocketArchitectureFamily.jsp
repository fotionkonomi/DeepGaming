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
	<a href="?company=${company}&language=al">Albanian</a>
	<span id="company" style="opacity: 0;">${company }</span>

	<jsp:include page="/WEB-INF/jsp/navigation.jsp"></jsp:include>


	<section class="container">

		<form id="form" action="">
			<fieldset>
				<center>

					<c:if test="${errorOrNot == null}">
						<legend style="padding-top: 20px; font-size: 30px; color: red;">
							<spring:message code="error.reChoose" />
						</legend>
					</c:if>
				</center>

				<br />

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"><spring:message
							code="addCpu.form.cpuFamily.label" /></label>
					<div class="col-lg-10">
						<select id="selectFamily" class="form-control">
							<option value="">
								<spring:message code="addCpu.form.cpuFamily.option" />
							</option>
							<c:forEach items="${cpuFamilies }" var="cpuFamily">

								<option value="${cpuFamily.id }">${cpuFamily.name }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<br /> <br /> <br />


				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"><spring:message
							code="addCpu.form.architectureOfThisCpu.label" /></label>
					<div class="col-lg-10">
						<select id="selectArchitecture" class="form-control">
							<option value="">
								<spring:message code="addCpu.form.architectureOfThisCpu.option" />
							</option>
							<c:forEach items="${cpuArchitectures }" var="cpuArchitecture">

								<option value="${cpuArchitecture.id }">${cpuArchitecture.name }</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<br /> <br />

				<div class="form-group">
					<br /> <label class="control-label col-lg-2 col-lg-2"><spring:message
							code="addCpu.form.socketOfThisCpu.label" /></label>
					<div class="col-lg-10">
						<select id="selectSocket" class="form-control">
							<option value="">
								<spring:message code="addCpu.form.socketOfThisCpu.option" />
							</option>
							<c:forEach items="${cpuSockets }" var="cpuSocket">

								<option value="${cpuSocket.id }">${cpuSocket.name }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<br /> <br />


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

	<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>

	<jsp:include page="/WEB-INF/jsp/scripts.jsp" />

	<script>
		$('document').ready(function() {
			enableOrDisableButton();
		});

		$('#selectFamily').change(function() {
			enableOrDisableButton();
		});

		$('#selectArchitecture').change(function() {
			enableOrDisableButton();
		});

		$('#selectSocket').change(function() {
			enableOrDisableButton();
		});

		function areAllFieldsFilled() {
			if ($("#selectFamily").val() != ""
					&& $("#selectArchitecture").val() != ""
					&& $("#selectSocket").val() != "") {
				return true;
			} else {
				return false;
			}
		}

		function enableOrDisableButton() {
			if (areAllFieldsFilled()) {
				var cpuFamily = $('#selectFamily').val();
				var cpuArchitecture = $('#selectArchitecture').val();
				var cpuSocket = $('#selectSocket').val();
				var company = $('#company').text();
				$('#a').attr(
						"href",
						"add?cpuFamily=" + cpuFamily + "&cpuArchitecture="
								+ cpuArchitecture + "&cpuSocket=" + cpuSocket
								+ "&company=" + company);
				$('#a').attr("class", "btn btn-primary");
			} else {
				$('#a').removeAttr('href');
				$('#a').attr('class', "btn btn-primary disabled");
			}
		}
	</script>
</body>
</html>
