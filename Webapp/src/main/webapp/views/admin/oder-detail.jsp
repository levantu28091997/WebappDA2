<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="row">
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<jsp:include page="../admin-layout/message.jsp" />
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<i class="fa fa-bar-chart-o fa-fw"></i> Chi tiết order
				<div class="pull-right">
					<div class="btn-group">
						<button type="button"
							class="btn btn-default btn-xs dropdown-toggle"
							data-toggle="dropdown">
							Actions <span class="caret"></span>
						</button>
						<ul class="dropdown-menu pull-right" role="menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul>
					</div>
				</div>
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="row">
					<div class="">
						<div class="dataTables_wrapper form-inline dt-bootstrap no-footer"
							id="dataTables-example_wrapper">
							<table class="table table-bordered table-hover table-striped">
								<thead>
									<tr>
										<th>STT</th>
										<th>Tên sản phẩm</th>
										<th>Số lượng</th>
										<th>Đơn giá</th>
										<th>Thành tiền</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${oder.lstOrderDetail}" var="item"
										varStatus="i">
										<tr class="odd gradeX">
											<td>${i.count}</td>
											<td>${item.product.name}</td>
											<td>${item.quantity}</td>
											<td><fmt:formatNumber type="number" pattern="###,###"
												value="${item.product.price}" />VNĐ</td>
											<td><fmt:formatNumber type="number" pattern="###,###"
												value="${item.total}" /> VNĐ</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							Tổng hóa đơn : <fmt:formatNumber type="number" pattern="###,###"
												value="${oder.total}" /> VNĐ
						</div>
						<div class="modal-footer">
							<a href="admin/accept/${oder.id}.html" class="btn btn-danger">Xác
								nhận</a>
						</div>
						<!-- /.table-responsive -->
					</div>

					<!-- /.col-lg-4 (nested) -->
					<div class="col-lg-8">
						<div id="morris-bar-chart"></div>
					</div>
					<!-- /.col-lg-8 (nested) -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->

		<!-- /.panel -->
	</div>
	<!-- /.col-lg-8 -->
	<!-- /.col-lg-4 -->
</div>