<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api/donhang" />
<c:url var="AddSanPhamUrl" value="/trang-chu/don-hang/them" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa sản phẩm</title>
</head>
<body>
	<div class="container pt-3">

		<div class="row justify-content-center">
			<h2 class="heading-section">Chỉnh sửa sản phẩm</h2>
		</div>
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<form action="" id="formSubmit" method="get">
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="">Mã
								sản phẩm</label> <input class="form-control" id="id" name="id"
								value="${sanPham.id}">
						</div>
						<div class="form-group">
							<label class="col-sm-6 control-label no-padding-right" for="">Tên
								sản phẩm</label> <input class="form-control" id="tenSanPhamString"
								name="tenSanPhamString" value="${sanPham.tenSanPhamString}">
						</div>
						<div class="form-group">
							<label class="col-sm-6 control-label no-padding-right" for="">Tên
								hãng</label> <input class="form-control" id="hangString"
								name="hangString" value="${sanPham.hangString}">
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="">Ảnh
								minh họa</label>
							<textarea class="form-control" id="anhDaiDienString"
								name="anhDaiDienString" rows="3">${sanPham.anhDaiDienString}</textarea>
						</div>
						<div class="form-group">
							<label class="col-sm-6 control-label no-padding-right" for="">Loại
								sản phẩm</label> <input class="form-control" id="loaiSanPhamString"
								name="loaiSanPhamString" value="${sanPham.loaiSanPhamString}">
						</div>
						<div class="form-group">
							<label class="col-sm-6 control-label no-padding-right" for="">Màu
								sắc sản phẩm</label> <input class="form-control" id="mauSacString"
								name="mauSacString" value="${sanPham.mauSacString}">
						</div>
						<div class="form-group">
							<label class="col-sm-6 control-label no-padding-right" for="">Kích
								cỡ sản phẩm</label> <input class="form-control" id="kichCoString"
								name="kichCoString" value="${sanPham.kichCoString}">
						</div>
						<div class="form-group">
							<label class="col-sm-6 control-label no-padding-right" for="">Giá
								bán</label> <input class="form-control" id="giaBanLong"
								name="giaBanLong" value="${sanPham.giaBanLong}">
						</div>
						<div class="form-group">
							<label class="col-sm-6 control-label no-padding-right" for="">Giá
								nhập</label> <input class="form-control" id="giaNhapLong"
								name="giaNhapLong" value="${sanPham.giaNhapLong}">
						</div>

						<div class="clearfix form-actions">
							<div class="col-md-offset-3 col-md-9">
								<button class="btn btn-info" type="button" id="btnUpdate">
									<i class="ace-icon fa fa-check bigger-110"></i> Xác nhận
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
	<script>
		var editor = '';
		$(document).ready(function() {
			editor = CKEDITOR.replace('anhDaiDienString');
		});
		$('#btnUpdate').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			data["anhDaiDienString"] = editor.getData();
			console.log(data);
			updateSanPham(data);
		});

		function updateSanPham(data) {
			$
					.ajax({
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