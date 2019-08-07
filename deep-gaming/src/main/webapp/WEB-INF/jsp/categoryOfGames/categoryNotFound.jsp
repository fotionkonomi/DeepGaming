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


	<jsp:include page="/WEB-INF/jsp/navigation.jsp"></jsp:include>

	<h1 style="text-align: center; color: #D10024;">
		<spring:message code="error.genericError" />
	</h1>

	<h3 style="text-align: center; color: black;">
		<spring:message code="error.genericError.sorry" />
	</h3>
	<br />

	<br />
	<br />
	<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>

	<jsp:include page="/WEB-INF/jsp/scripts.jsp" />


	<script src="<c:url value="/js/fileupload.js"></c:url>"></script>

</body>
</html>
