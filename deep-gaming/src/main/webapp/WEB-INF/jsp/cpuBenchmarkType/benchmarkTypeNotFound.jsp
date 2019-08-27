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
	<a href="?id=${id }&language=en">English</a>|
	<a href="?id=${id }&language=al">Albanian</a>

	<jsp:include page="/WEB-INF/jsp/navigation.jsp"></jsp:include>

	<h1 style="text-align: center; color: #D10024;">
		Error 404:
		<spring:message code="cpuBenchmarkType.cpuBenchmarkTypeNotFound" />
	</h1>
	<br />
	<center>
		<a style="text-align: center;"
			href="<spring:url value="/cpuBenchmarkType/benchmarkTypes" />"
			class="btn btn-primary"> <spring:message
				code="error.notFound.goBack" />
		</a>
	</center>
	<br />
	<br />
	<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>

	<jsp:include page="/WEB-INF/jsp/scripts.jsp" />


	<script src="<c:url value="/js/fileupload.js"></c:url>"></script>

</body>
</html>
