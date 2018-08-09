<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.servletContext.contextPath}/">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/resources/home/images/favicon.png">
<title>SB Admin Version 2.0</title>
<jsp:include page="admin-layout1/stylesheet.jsp" />
<!--stylesheet-->

</head>

<body>

	<div id="wrapper">

		<jsp:include page="admin-layout1/navigation.jsp" />

		<div id="page-wrapper">
			<jsp:include page="${param.view}" />
		</div>
		<!-- /#page-wrapper -->

	</div>
	<jsp:include page="admin-layout1/script-bottom.jsp" />

</body>

</html>
