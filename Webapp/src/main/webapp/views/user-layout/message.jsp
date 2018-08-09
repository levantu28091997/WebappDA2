<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${!empty message}">
	<div class="alert alert-success">
		<button type="button" class="close" data-dismiss="alert"
			aria-hidden="true">×</button>
		<h4>${message}</h4>
	</div>
</c:if>