<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
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
                        <i class="fa fa-bar-chart-o fa-fw"></i> Các đơn hàng trong ngày hôm nay
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
                                            <th>Người đặt hàng</th>
                                            <th>Số điện thoại</th>
                                            <th>Ngày đặt hàng</th>
                                            <th>Sản phẩm đặt</th>
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
									<td>${item.lstOrderDetail.get(0).createdAt}</td>
									<td>${item.lstOrderDetail.get(0).product.name}</td>
									<td>${item.total}</td>
									<td>${item.status}</td>
									<td>
                                    <button ng-click="changeStatus(${item.id})" type="button" class="btn btn-danger" data-dismiss="modal">Xác nhận</button>

									</td>
								</tr>
							</c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- /.table-responsive -->
                            </div>

                            <div class="modal fade" id="myModal" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">Chi tiết order</h4>
                                        </div>
                                        <div class="modal-body">
                                            <table width="100%"
                                                   class="table table-hover table-striped">
                                                <thead>
                                                <tr>
                                                    <th>STT</th>
                                                    <th>Tên sản phẩm</th>
                                                    <th>Số lượng</th>
                                                    <th>Đơn giá</th>
                                                    <th>Thành tiền</th>
                                                </tr>
                                                </thead>
                                                <tbody ng-repeat="orderDetail in orderDetails.data">
                                                <tr class="odd gradeX">
                                                    <td>{{$index}}</td>
                                                    <td>{{orderDetail.product.name}}</td>
                                                    <td>{{orderDetail.quantity}}</td>
                                                    <td>{{orderDetail.product.price | currency : "" : 0}} VND</td>
                                                    <td>{{orderDetail.product.price * orderDetail.quantity | currency :
                                                        "" : 0}} VND
                                                    </td>
                                                </tr>
                                                </tbody>
                                            </table>
                                            Tổng hóa đơn : {{total | currency : "" : 0}} VND
                                        </div>
                                        <div class="modal-footer">
                                            Chuyển trạng thái đơn hàng
                                            <select ng-model="status">
                                                <option value="2" ng-repeat="item in units" ng-value="item.id">{{item.label}}</option>
                                            </select>
                                            <button ng-click="changeStatus(id,1)" type="button" class="btn btn-default" data-dismiss="modal">Xác nhận
                                            </button>
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Đóng
                                            </button>
                                        </div>
                                    </div>

                                </div>
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
<script src="<%=request.getContextPath()%>/resources/js-user/angular.js"></script>
<script type="text/javascript">
    var app = angular.module('app', []);

    app.controller("item", function ($scope, $http, $location) {

        $scope.units = [
            {'id': 1, 'label': 'Đơn hàng đã ship'},
        ]


        $scope.status = 0;


    

        $scope.order = function () {

            var url = "/admin/getorder";

            $http.post(url, "").then(function (response) {
                    if (response.data.message == "success") {
                        $scope.orders = response.data;
                    }
                }, function (response) {
                    $scope.getResultMessage = "Fail!";
                }
            )
        }

        $scope.orderDetail = function (id) {

            var url = "/getorderbyid/" + id;

            $http.post(url, "").then(function (response) {
                    if (response.data.message == "success") {
                        $scope.orderDetails = response.data;
                        $scope.id = id;
                    }
                }, function (response) {
                    $scope.getResultMessage = "Fail!";
                }
            )
        }

        $scope.total = 0


        $scope.setTotal = function(amount){
            $scope.total = amount;
        }


        $scope.changeStatus = function (id) {

            var url = "admin/setstatus/"+id;
			
            if(confirm("Bạn có thực sự muốn thay đổi")){
            	$http.get(url, "").then(function (response) {
                }, function(response) {
                    alert("Sửa trạng thái thành công");
                    window.location.reload();
                }
            )
            }
        }


        $scope.getLstProduct = function () {

            var url = "/getlstProduct";

            $http.get(url, "").then(function (response) {
                    if (response.data.message == "success") {
                        $scope.lstProduct = response.data;
                        $scope.order();
                    }
                }, function (response) {

                    $scope.getResultMessage = "Fail!";
                }
            )

        }



    });

</script>

<!-- /#page-wrapper -->