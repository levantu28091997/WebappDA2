<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String view = request.getParameter("view");
	if (view.startsWith("admin/")) {
		pageContext.forward("layout-admin.jsp");
	}else if(view.startsWith("auth/")){
		pageContext.forward("auth/login.jsp");
	} 
	else{
		pageContext.forward("layout-user.jsp");
	}
%>