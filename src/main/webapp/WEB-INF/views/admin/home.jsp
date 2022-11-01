<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a></li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="widget-box table-filter">
					<div class="table-btn-controls">
						<div class="pull-right tableTools-container"></div>
					</div>
				</div>
				<div class="row">

					<div class="col-xs-12">

						<h4>Overview</h4>
						<div class="space-6"></div>

						<div class="col-sm-9 infobox-container">
							<div class="infobox infobox-green">
								<div class="infobox-icon">
									<i class="ace-icon fa fa-comments"></i>
								</div>

								<div class="infobox-data">
									<span class="infobox-data-number">${model.totalItem}</span>
									<div class="infobox-content">Total employees</div>
								</div>
							</div>

							<div class="infobox infobox-blue">
								<div class="infobox-icon">
									<i class="ace-icon fa fa-twitter"></i>
								</div>

								<div class="infobox-data">
									<span class="infobox-data-number">${model1.totalItem}</span>
									<div class="infobox-content">Total number of products</div>
								</div>
							</div>

							<div class="infobox infobox-pink">
								<div class="infobox-icon">
									<i class="ace-icon fa fa-shopping-cart"></i>
								</div>

								<div class="infobox-data">
									<span class="infobox-data-number">${model2.totalItem}</span>
									<div class="infobox-content">Total Orders</div>
								</div>
							</div>
							<div class="infobox infobox-red">
								<div class="infobox-icon">
									<i class="ace-icon fa fa-flask"></i>
								</div>

								<div class="infobox-data">
									<span class="infobox-data-number">${model3}Đ</span>
									<div class="infobox-content">Total revenue</div>
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
							<h4>Product statistics</h4>
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>Product code</th>
										<th>Product's name</th>
										<th>Sell ​​number</th>
										<th>Quantity sold</th>
										<th>Inventory quantity</th>
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
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<!-- /.main-content -->
</body>
</html>