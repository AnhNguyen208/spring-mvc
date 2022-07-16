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
						<%-- <div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="">Mã
								nhân viên</label> <input class="form-control" id="idNhanVienBanHang"
								name="idNhanVienBanHang" value="${model.idNhanVienBanHang}">
						</div> --%>
						<select class="form-control" id="idNhanVienBanHang"
							name="idNhanVienBanHang">
							<option value="">---Chọn nhân viên bán hàng---</option>
							<c:forEach var="item" items="${nv.listResult}">
								<option value="${item.id}">${item.hoVaTenString}</option>
							</c:forEach>
						</select>
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
							<label class="col-sm-6 control-label no-padding-right" for="">Số
								lượng sản phẩm trong đơn hàng</label> <input class="form-control"
								id="soLuongSanPham" name="soLuongSanPham"
								value="${model.soLuongSanPham}">
						</div>
						<c:forEach var="item" items="${model.thongTinDonHangDtos}">
							<select class="form-control" id="idSP" name="idSP">
								<option value="">---Chọn sản phẩm---</option>
								<c:forEach var="item" items="${sp.listResult}">
									<option value="${item.id}">${item.tenSanPhamString}
										${item.soLuong}</option>
								</c:forEach>
							</select>
							<%-- <div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="">Mã
									sản phẩm</label> <input class="form-control" id="idSP" name="idSP"
									value="${item.id}">
							</div> --%>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="">Số
									lượng</label> <input class="form-control" id="soLuong" name="soLuong"
									value="${item.soLuongBan}">
							</div>
						</c:forEach>
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
	<script>
		var editor = '';
		$(document).ready(function() {
			editor = CKEDITOR.replace('thongTinKhachHangString');
		});
		$('#btnAddOrUpdate').click(function(e) {
			e.preventDefault();
			var data = {};
			var idSanPhamList = [];
			data["idSanPhamList"] = idSanPhamList;
			var soLuongBanList = [];
			data["soLuongBanList"] = soLuongBanList;
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				if (v.name == 'idSP') {
					idSanPhamList.push(v.value);

				} else if (v.name == 'soLuong') {
					soLuongBanList.push(v.value);

				} else {
					data["" + v.name + ""] = v.value;
				}
			});
			data["thongTinKhachHangString"] = editor.getData();
			console.log(data);
			addDonHang(data);
		});

		function addDonHang(data) {
			$.ajax({
				url : '/api/donhang',
				type : 'POST',
				contentType : 'application/json; charset=UTF-8',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					console.log(result);
					window.location.href = "/trang-chu/don-hang/danh-sach?message=insert_success";
				},
				error : function(error) {
					console.log(error);
					window.location.href = "/trang-chu/don-hang/danh-sach?message=error_system";
				}
			});
		}
	</script>
</body>
</html>