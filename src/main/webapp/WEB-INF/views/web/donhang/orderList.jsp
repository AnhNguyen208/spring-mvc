<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order List</title>
</head>
<body>
	<section class="ftco-section">
		<div class="container pt-3">
			<c:if test="${not empty message}">
				<div class="alert alert-${alert}" role="alert">${message}</div>
			</c:if>
			<div class="row justify-content-center">

				<div class="col-md-6 text-center mb-4">
					<h2 class="heading-section">Order List</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="table-wrap">
						<table class="table myaccordion table-hover" id="accordion">
							<thead>
								<tr>
									<th>#</th>
									<th class="center">Customer information</th>
									<th class="center">Sales staff</th>
									<th class="center">Date time</th>
									<th scope="row" colspan=3>Manipulation</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${DonHang.listResult}">
									<tr>
										<th scope="row">${item.id}</th>
										<td>${item.thongTinKhachHangString}</td>
										<td>${item.tenNhanVienString}</td>
										<td>${item.createdDateTimestamp}</td>
										<td><a
											class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
											data-toggle="tooltip"
											href="/trang-chu/don-hang/chinh-sua?id=${item.id}"><i
												class="bi bi-pencil-square">Edit</i></a></td>
										<td><button id="btnDelete" type="button"
												onclick="warningBeforeDelete(${item.id})"
												class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
												data-toggle="tooltip" title='Xóa đơn hàng'>
												<span> <i class="bi bi-trash">Delete</i>
												</span>
											</button></td>
										<td data-toggle="collapse" data-target="#collapse${item.id}"
											aria-expanded="false" aria-controls="collapse${item.id}"
											class=""><i class="fa" aria-hidden="true"></i> <i
											class="bi bi-cart4"></i></td>
									</tr>
									<tr>
										<td colspan="6" id="collapse${item.id}" class="acc collapse"
											data-parent="#accordion" style="">
											<h4>Order details</h4>
											<table class="table myaccordion table-hover" id="accordion">
												<thead>
													<tr>
														<th>#</th>
														<th class="center">Product</th>
														<th class="center">Unit price</th>
														<th class="center">Quantity</th>
														<th class="center">Amount</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="item1" items="${item.thongTinDonHangDtos}">
														<tr>
															<th scope="row"></th>
															<td>${item1.tenSanPhamString}</td>
															<td>${item1.giaBanLong1}</td>
															<td>${item1.soLuongBan}</td>
															<td>${item1.soLuongBan*item1.giaBanLong1}</td>
														</tr>
													</c:forEach>
												</tbody>
												<tfoot>
													<tr>
														<td colspan=3></td>
														<td class="table-info">Discount:</td>
														<td class="table-info">${item.chietKhauLong}</td>
													</tr>
													<tr>
														<td colspan=3></td>
														<td class="table-info">Total amount:</td>
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
	<script>
		function warningBeforeDelete(id) {
			swal({
				title : "Xác nhận xóa",
				text : "Bạn có chắc chắn muốn xóa hay không",
				type : "warning",
				showCancelButton : true,
				confirmButtonClass : "btn-success",
				cancelButtonClass : "btn-danger",
				confirmButtonText : "Xác nhận",
				cancelButtonText : "Hủy bỏ",
			}).then(
					function(isConfirm) {
						if (isConfirm) {
							deleteSanPham(id);
						}
					});
		}
		function deleteSanPham(data) {
			$.ajax({
					url : '/api/donhang',
					type : 'DELETE',
					contentType : 'application/json',
					data : JSON.stringify(data),
					success : function(result) {
						console.log(result);
					},
					error : function(error) {
						console.log(error);
					}
					});
			}
	</script>
</body>

</html>