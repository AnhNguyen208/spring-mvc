<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api/donhang" />
<c:url var="AddSanPhamUrl" value="/trang-chu/don-hang/them" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa đơn hàng</title>
</head>
<body>
	<div class="container pt-3">

		<div class="row justify-content-center">
			<h2 class="heading-section">Chỉnh sửa đơn hàng</h2>
		</div>
		<div class="page-content">
			<div class="page-content">
				<div class="row">
					<div class="col-md-12">
						<form action="<c:url value='/trang-chu/don-hang/them'/>"
							id="formSubmit" method="get">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="">Nhân
									viên bán hàng </label> <input class="form-control"
									id="tenNhanVienString" name="tenNhanVienString"
									value="${donHang.tenNhanVienString}">
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="">Thông
									tin khách hàng</label>
								<textarea class="form-control" id="thongTinKhachHangString"
									name="thongTinKhachHangString" rows="3">${donHang.thongTinKhachHangString}</textarea>
							</div>
							<div class="row">
								<h6 class="col">Thông tin đơn hàng</h6>
							</div>
							<div class="col-md-offset-3 col-md-9">
								<button class="btn btn-info" type="button" id="btnAddProduct">
									<i></i> Thêm sản phẩm
								</button>
								<button class="btn btn-info" type="button" id="btnDeleteProduct">
									<i></i> Xóa sản phẩm
								</button>
							</div>
							<c:forEach var="item" items="${donHang.thongTinDonHangDtos}">
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="">Sản
										phẩm</label> <select class="form-control" id="idSP" name="idSP">
										<option value="${item.id}">${item.tenSanPhamString} ${item.soLuong}</option>
										<c:forEach var="item1" items="${sanPham.listResult}">
											<option value="${item1.id}">${item1.tenSanPhamString}
												${item1.soLuong}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="">Số
										lượng</label> <input class="form-control" id="soLuong" name="soLuong"
										value="${item.soLuongBan}">
								</div>
							</c:forEach>
							<div class="form-group">
								<label class="col-sm-6 control-label no-padding-right" for="">Chiết
									khấu</label> <input class="form-control" id="chietKhauLong"
									name="chietKhauLong" value="${donHang.chietKhauLong}">
							</div>
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<button class="btn btn-info" type="button" id="btnAddOrUpdate">
										<i class="ace-icon fa fa-check bigger-110"></i> Thêm đơn hàng
									</button>
									&nbsp; &nbsp; &nbsp;
									<button class="btn" type="reset">
										<i class="ace-icon fa fa-undo bigger-110"></i> Hủy
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		var editor = '';
		$(document).ready(function() {
			editor = CKEDITOR.replace('thongTinKhachHangString');
		});
		$('#btnAddProduct').click(
				function(e) {
					e.preventDefault();
					var soLuong = ${donHang.soLuongSanPham}+1;
					window.location.href = "/trang-chu/don-hang/them?soLuong="
							+ soLuong + "";
				});
		$('#btnDeleteProduct').click(
				function(e) {
					e.preventDefault();
					var soLuong = ${donHang.soLuongSanPham}-1;
					window.location.href = "/trang-chu/don-hang/them?soLuong="
							+ soLuong + "";
				});
		$('#btnUpdate').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			data["thongTinKhachHangString"] = editor.getData();
			console.log(data);
			updateSanPham(data);
		});

		function updateSanPham(data) {
			$.ajax({
						url : '/api/sanpham',
						type : 'PUT',
						contentType : 'application/json; charset=UTF-8',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							console.log(result);
							window.location.href = "/trang-chu/san-pham/danh-sach?message=update_success";
						},
						error : function(error) {
							console.log(error);
							window.location.href = "/trang-chu/san-pham/danh-sach?message=error_system";
						}
					});
		}
	</script>
</body>
</html>