<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Thống kê</title>
</head>
<body>
	<div class="main-content">
		<form action="" id="formSubmit" method="get">
			<div class="page-content">
				<div class="row">
					<div class="space-6"></div>

					<div class="col-sm-9 infobox-container">
						<div class="infobox infobox-green">
							<div class="infobox-icon">
								<i class="ace-icon fa fa-comments"></i>
							</div>

							<div class="infobox-data">
								<span class="infobox-data-number">${model.totalItem}</span>
								<div class="infobox-content">Tổng số nhân viên</div>
							</div>
						</div>

						<div class="infobox infobox-blue">
							<div class="infobox-icon">
								<i class="ace-icon fa fa-twitter"></i>
							</div>

							<div class="infobox-data">
								<span class="infobox-data-number">${model1.totalItem}</span>
								<div class="infobox-content">Tổng số sản phẩm</div>
							</div>
						</div>

						<div class="infobox infobox-pink">
							<div class="infobox-icon">
								<i class="ace-icon fa fa-shopping-cart"></i>
							</div>

							<div class="infobox-data">
								<span class="infobox-data-number">${model2.totalItem}</span>
								<div class="infobox-content">Tổng số đơn đặt hàng</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12">
						<div class="table-responsive">
							<h4>Thống kê sản phẩm</h4>
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>Mã sản phẩm</th>
										<th>Tên sản phẩm</th>
										<th>Số lượng bán</th>
										<th>Số lượng nhập</th>
										<th>Số lượng tồn kho</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${model1.listResult}">
										<tr>
											<td>${item.id}</td>
											<td>${item.tenSanPhamString}</td>
											<td>${item.soLuongBan}</td>
											<td>${item.soLuongNhap}</td>
											<td>${item.soLuong}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<div class="space-6"></div>
							<div class="infobox infobox-blue infobox-small infobox-dark">
								<div class="infobox-data">
									<div class="infobox-content">Doanh thu</div>
									<div class="infobox-content">$32,000</div>
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="row">
					<div class="col-xs-12">
						<div class="col-xs-12">
							<div class="widget-box table-filter">
								<div class="table-btn-controls">
									<div class="pull-right tableTools-container"></div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="table-responsive">
										<h4>Thống kê theo đơn hàng</h4>
										<table class="table table-bordered">
											<thead>
												<tr>
													<th>Mã đơn hàng</th>
													<th>Tổng tiền đơn hàng</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${model2.listResult}">
													<tr>
														<td>${item.id}</td>
														<td>${item.tongTienDonHang}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<div class="space-6"></div>
										<div class="infobox infobox-blue infobox-small infobox-dark">
											<div class="infobox-data">
												<div class="infobox-content">Doanh thu</div>
												<div class="infobox-content">$32,000</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="widget-box table-filter">
								<div class="table-btn-controls">
									<div class="pull-right tableTools-container"></div>
								</div>
							</div>

							<div class="row">
								<div class="col-xs-12">
									<div class="table-responsive">
										<h4>Thống kê doanh thu theo nhân viên</h4>
										<table class="table table-bordered">
											<thead>
												<tr>
													<th>Mã nhân viên</th>
													<th>Tên nhân viên</th>
													<th>Doanh thu</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${model.listResult}">
													<tr>
														<td>${item.id}</td>
														<td>${item.hoVaTenString}</td>
														<td>${item.doanhThuLong}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<div class="space-6"></div>
										<div class="infobox infobox-blue infobox-small infobox-dark">
											<div class="infobox-data">
												<div class="infobox-content">Doanh thu</div>
												<div class="infobox-content">$32,000</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>


</body>
</html>