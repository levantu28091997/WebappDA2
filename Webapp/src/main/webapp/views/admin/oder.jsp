<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div ng-app="app">
	<div id="order" ng-controller="item">
		<div class="row">
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-3 col-md-6" ng-init="getRowCount();order();">
			</div>
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-bar-chart-o fa-fw"></i> Các đơn hàng trong ngày
						hôm nay
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
					<jsp:include page="../admin-layout/message.jsp" />
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="row">
							<div class="">
								<div
									class="dataTables_wrapper form-inline dt-bootstrap no-footer"
									id="dataTables-example_wrapper">
									<table class="table table-bordered table-hover table-striped">
										<thead>
											<tr>
												<th>STT</th>
												<th>Người đặt hàng</th>
												<th>Số điện thoại</th>
												<th>Ngày đặt hàng</th>
												<th>Tổng tiền</th>
												<th>Trạng thái</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${listoder}" var="item" varStatus="i">
												<tr class="odd gradeX">
													<td>${i.count}</td>
													<td>${item.users.name}</td>
													<td>${item.users.phone}</td>
													<td>${item.date}</td>
													<td><fmt:formatNumber type="number" pattern="###,###"
												value="${item.total}" />VNĐ</td>
													<c:if test="${item.status==0}">
															<td><label class="label label-success"> Đơn
																	hàng mới</label></td>
														</c:if> <c:if test="${item.status==1}">
															<td><label class="label label-danger">Đơn hàng hoàn tất</label></td>
														</c:if>
													<c:if test="${item.status==0}">
													<td><a href="admin/oder/${item.id}.html"
														class="btn btn-danger">Xác nhận</a></td>
													</c:if>
													<c:if test="${item.status==1}">
													<td><a href="admin/odersu/${item.id}.html"
														class="btn btn-primary">Chi tiết</a></td>
													</c:if>
												</tr>
											</c:forEach>
										</tbody>
									</table>
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
	</div>
	<!-- /.row -->
</div>
<!-- /#page-wrapper -->