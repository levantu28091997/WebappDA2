<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Website bán hàng</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/resources/home/images/favicon.png">
<jsp:include page="user-layout/stysheet.jsp"></jsp:include>
<base href="${pageContext.servletContext.contextPath}/">
</head>
<body id="home">
<script lang="javascript">var _vc_data = {id : 4705493, secret : 'b7c737be37ecf2e7a6c0b7f864e6f1cd'};(function() {var ga = document.createElement('script');ga.type = 'text/javascript';ga.async=true; ga.defer=true;ga.src = '//live.vnpgroup.net/client/tracking.js?id=4705493';var s = document.getElementsByTagName('script');s[0].parentNode.insertBefore(ga, s[0]);})();</script>         	         	
	<div class="wrapper">
		<jsp:include page="user-layout/menu.jsp"></jsp:include>
		<div class="clearfix"></div>
		<jsp:include page="${param.view}"></jsp:include>
		<div class="clearfix"></div>
		<jsp:include page="user-layout/footer.jsp"></jsp:include>
	</div>
	<jsp:include page="user-layout/js-bottom.jsp"></jsp:include>
</body>
</html>