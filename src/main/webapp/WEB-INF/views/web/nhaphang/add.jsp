<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api/donhang" />
<c:url var="AddSanPhamUrl" value="/trang-chu/don-hang/them" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm đơn nhập hàng</title>
</head>
<body>
	<div class="container pt-3">

		<div class="row justify-content-center">
			<h2 class="heading-section">Thêm đơn nhập hàng</h2>
		</div>
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<form action="<c:url value='/trang-chu/don-hang/them'/>"
						id="formSubmit" method="get">
						<%-- <div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="">Mã
								nhân viên</label> <input class="form-control" id="idNhanVienNhapHang"
								name="idNhanVienNhapHang" value="${model.idNhanVienNhapHang}">
						</div> --%>
						<select class="form-control" id="idNhanVienNhapHang"
							name="idNhanVienNhapHang">
							<option value="">---Chọn nhân viên nhập hàng---</option>
							<c:forEach var="item" items="${nv.listResult}">
								<option value="${item.id}">${item.hoVaTenString}</option>
							</c:forEach>
						</select>
						<div class="row">
							<h6 class="col">Thông tin đơn nhập hàng</h6>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="">Số lượng sản phẩm trong đơn hàng</label> <input class="form-control" id="soLuongSanPham"
								name="soLuongSanPham" value="${model.soLuongSanPham}">
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
		$('#btnContinue').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			console.log(formData);
			window.location.href = "/trang-chu/nhap-hang/them-san-pham-cho-don-nhap-hang?maNhanVien="+data.idNhanVienNhapHang+"&thongTinNCC="+data.thongTinNhaCungCapString+"&soLuong="+data.soLuongSanPham+"";
		});
	</script>
</body>
</html>