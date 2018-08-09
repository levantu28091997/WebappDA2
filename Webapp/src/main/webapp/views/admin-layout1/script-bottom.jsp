<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<base href="${pageContext.request.contextPath}/">
<script>
	$(document).ready(function() {
		$('#dataTables-example').dataTable();
	});
</script>
<!-- Core Scripts - Include with every page -->
<script
	src="<%=request.getContextPath()%>/resources/admin/js/jquery-1.10.2.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/admin/js/bootstrap.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/admin/js/plugins/metisMenu/jquery.metisMenu.js"></script>

<!-- Page-Level Plugin Scripts - Dashboard -->
<script
	src="<%=request.getContextPath()%>/resources/admin/js/plugins/morris/raphael-2.1.0.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/admin/js/plugins/morris/morris.js"></script>

<!-- SB Admin Scripts - Include with every page -->
<script
	src="<%=request.getContextPath()%>/resources/admin/js/sb-admin.js"></script>

<!-- Page-Level Demo Scripts - Dashboard - Use for reference -->
<script
	src="<%=request.getContextPath()%>/resources/admin/js/demo/dashboard-demo.js"></script>

<!-- Page-Level Plugin Scripts - Tables -->
<script
	src="<%=request.getContextPath()%>/resources/admin/js/plugins/dataTables/jquery.dataTables.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/admin/js/plugins/dataTables/dataTables.bootstrap.js"></script>
<!-- Page-Level Demo Scripts - Tables - Use for reference -->

