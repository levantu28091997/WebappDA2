<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin - Bootstrap Admin Template</title>

<!-- Bootstrap Core CSS -->
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<%=request.getContextPath()%>/resources/css/sb-admin.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<%=request.getContextPath()%>/resources/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">SB Admin</a>
		</div>
	</nav>

	<div id="page-wrapper">

		<div class="container-fluid">
			<div class="row" style="margin-left: 400px; margin-top: 100px;">
				<!-- /.col-sm-4 -->
				<div class="col-sm-6">
					<div class="panel panel-green">
						<div class="panel-heading">
							<h3 class="panel-title">ĐĂNG NHẬP</h3>
						</div>
						<div class="panel-body">
							<c:if test="${!empty message}">
								<div class="alert alert-danger alert-dismissable">
									<button type="button" class="close" data-dismiss="alert"
										aria-hidden="true">×</button>${message}</div>
							</c:if>
							<form:form method="post" commandName="AdminUser">
								<div class="form-group">
									<label>Email</label>
									<form:input path="email" class="form-control"
										placeholder="Nhập email.." />
									<p class="help-block"></p>
								</div>
								<div class="form-group">
									<label>Password</label>
									<form:input path="password" class="form-control"
										placeholder="Nhập password.." type="password" />
									<p class="help-block"></p>
								</div>
								<button type="submit" class="btn btn-default">Đăng nhập</button>
								&emsp;
								<button type="reset" class="btn btn-default">Làm mới</button>

							</form:form>
						</div>
					</div>
				</div>
				<!-- /.col-sm-4 -->
			</div>
		</div>
		<!-- /.container-fluid -->

	</div>
	<!-- /.container-fluid -->


	<!-- jQuery -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>

</body>

</html>
