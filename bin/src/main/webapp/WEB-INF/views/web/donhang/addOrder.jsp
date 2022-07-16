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
							<label class="col-sm-3 control-label no-padding-right" for="">Mã
								nhân viên</label> <input class="form-control" id="idNhanVienBanHang"
								name="idNhanVienBanHang" value="${model.id}">
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
							<label class="col-sm-3 control-label no-padding-right" for="">Mã
								sản phẩm</label> <input class="form-control" id="idSanPhamLong"
								name="idSanPhamLong" value="${model.idSanPhamLong}">
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="">Số
								lượng</label> <input class="form-control" id="soLuongBan"
								name="soLuongBan" value="${model1.soLuongBan}">
						</div>
						<div class="clearfix form-actions">
							<div class="col-md-offset-3 col-md-9">
								<button class="btn btn-info" type="button" id="btnAddOrUpdate">
									<i></i> Thêm đơn hàng
								</button>
								&nbsp; &nbsp; &nbsp;
								<button class="btn" type="reset">
									<i></i> Hủy
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script>
		$('#btnAddOrUpdate').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			console.log(formData);
			addDonHang(data);
		});

		function addDonHang(data) {
			$.ajax({
				url : '${APIurl}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
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