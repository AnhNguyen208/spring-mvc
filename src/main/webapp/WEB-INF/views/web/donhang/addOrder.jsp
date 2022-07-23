<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api/donhang" />
<c:url var="AddSanPhamUrl" value="/trang-chu/don-hang/them" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm đơn hàng</title>
</head>
<body>
	<div class="container pt-3">

		<div class="row justify-content-center">
			<h2 class="heading-section">Thêm đơn hàng</h2>
		</div>
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<form action="<c:url value='/trang-chu/don-hang/them'/>"
						id="formSubmit" method="get">
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="">Nhân
								viên bán hàng </label> <select class="form-control"
								id="idNhanVienBanHang" name="idNhanVienBanHang">

								<option value="">---Chọn nhân viên bán hàng---</option>
								<c:forEach var="item" items="${nv.listResult}">
									<option value="${item.id}">${item.hoVaTenString}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="">Thông
								tin khách hàng</label>
							<textarea class="form-control" id="thongTinKhachHangString"
								name="thongTinKhachHangString" rows="3">${model.thongTinKhachHangString}</textarea>
						</div>
						<div class="row">
							<h6 class="col">Thông tin đơn hàng</h6>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="">Số
								lượng sản phẩm trong đơn hàng</label> <input class="form-control"
								id="soLuongSanPham" name="soLuongSanPham"
								value="${model.soLuongSanPham}">
						</div>
						<div class="clearfix form-actions">
							<div class="col-md-offset-3 col-md-9">
								<button class="btn btn-info" type="button" id="btnContinue">
									<i></i> Xác nhận
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script>
		var editor = '';
		$(document).ready(function() {
			editor = CKEDITOR.replace('thongTinKhachHangString');
		});
		$('#btnContinue').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			data["thongTinKhachHangString"] = editor.getData();
			console.log(data);
			window.location.href = "/trang-chu/don-hang/them-san-pham-cho-don-hang?maNhanVien="
									+ data.idNhanVienBanHang
									+ "&thongTinKH="
									+ data.thongTinKhachHangString
									+ "&soLuong=" + data.soLuongSanPham + "";
						});
	</script>
</body>
</html>