<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách đơn hàng</title>
</head>
<body>
	<section class="ftco-section">
		<div class="container pt-3">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-4">
					<h2 class="heading-section">Danh sách đơn hàng</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="table-wrap">
						<table class="table myaccordion table-hover" id="accordion">
							<thead>
								<tr>
									<th>#</th>
									<th class="center">Nhân viên nhận hàng</th>
									<th class="center">Ngày nhận hàng</th>
									<th>&nbsp;</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${NhapHang.listResult}">
									<tr>
										<th scope="row">${item.id}</th>
										<td>${item.tenNhanVienString}</td>
										<td>${item.createdDateTimestamp}</td>
										<td data-toggle="collapse" data-target="#collapse${item.id}"
											aria-expanded="false" aria-controls="collapse${item.id}"
											class=""><i class="fa" aria-hidden="true"></i> <i
											class="bi bi-box-arrow-in-down"></i></td>
									</tr>
									<tr>
										<td colspan="6" id="collapse${item.id}" class="acc collapse"
											data-parent="#accordion" style="">
											<h4>Chi tiết nhập hàng</h4>
											<table class="table myaccordion table-hover" id="accordion">
												<thead>
													<tr>
														<th>#</th>
														<th class="center">Tên sản phẩm</th>
														<th class="center">Giá tiền</th>
														<th class="center">Số lượng</th>
														<th class="center">Tổng</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="item1" items="${item.thongTinNhapHangDtos}">
														<tr>
															<th scope="row"></th>
															<td>${item1.tenSanPhamString}</td>
															<td>${item1.giaNhapLong1}</td>
															<td>${item1.soLuongNhap}</td>
															<td>${item1.soLuongNhap*item1.giaNhapLong1}</td>
														</tr>
													</c:forEach>
												</tbody>
												<tfoot>
													<tr>
														<td colspan=3></td>
														<td class="table-info">Tổng tiền:</td>
														<td class="table-info">${item.tongTienDonHang}</td>
													</tr>
												</tfoot>
											</table>
										</td>
									</tr>
								</c:forEach>
							</tbody>
							<tfoot>
								<tr>
									<td colspan=5></td>
								</tr>
							</tfoot>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>

</html>