<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${!empty message}">
	<div class="alert alert-${b} alert-dismissable">
		<button type="button" class="close" data-dismiss="alert"
			aria-hidden="true">×</button>${message}</div>
</c:if>