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
								nhân viên nhập hàng</label> <input class="form-control" id="idNhanVienNhapHang"
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
							<h6 class="col">Thông tin đơn hàng</h6>
						</div>
						<div class="form-group">
							<label class="col-sm-6 control-label no-padding-right" for="">Số
								lượng sản phẩm trong đơn hàng</label> <input class="form-control"
								id="soLuongSanPham" name="soLuongSanPham"
								value="${model.soLuongSanPham}">
						</div>
						<c:forEach var="item" items="${model.thongTinNhapHangDtos}">
							<%-- <div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="">Mã
									sản phẩm</label> <input class="form-control" id="idSP" name="idSP"
									value="${item.id}">
							</div> --%>
							<select class="form-control" id="idSP" name="idSP">
								<option value="">---Chọn sản phẩm---</option>
								<c:forEach var="item" items="${sp.listResult}">
									<option value="${item.id}">${item.tenSanPhamString}
										${item.soLuong}</option>
								</c:forEach>
							</select>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="">Số
									lượng</label> <input class="form-control" id="soLuong"
									name="soLuong" value="${item.soLuongNhap}">
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
		$('#btnAddOrUpdate').click(function(e) {
			e.preventDefault();
			var data = {};
			var idSanPhamList = [];
			data["idSanPhamList"] = idSanPhamList;
			var soLuongNhapList = [];
			data["soLuongNhapList"] = soLuongNhapList;
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				if(v.name == 'idSP') {
					idSanPhamList.push(v.value);
					
				}
				else if(v.name == 'soLuong') {
					soLuongNhapList.push(v.value);
				
				}
				else {
					data["" + v.name + ""] = v.value;					
				}
			});
			console.log(data);
			addNhapHang(data);
		});

		function addNhapHang(data) {
			$.ajax({
				url : '/api/nhaphang',
				type : 'POST',
				contentType : 'application/json; charset=UTF-8',
				data : JSON.stringify(data),
				success : function(result) {
					console.log(result);
					window.location.href = "/trang-chu/nhap-hang/danh-sach?message=insert_success";
				},
				error : function(error) {
					console.log(error);
					window.location.href = "/trang-chu/nhap-hang/danh-sach?message=error_system";
				}
			});
		}
	</script>
</body>
</html>