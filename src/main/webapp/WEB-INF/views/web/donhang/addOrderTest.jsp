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
			<h2 class="heading-section">Add order</h2>
		</div>
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<form action="<c:url value='/trang-chu/don-hang/them'/>"
						id="formSubmit" method="get">
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="">Staff
							</label> <select class="form-control" id="idNhanVienBanHang"
								name="idNhanVienBanHang">

								<option value="">---Select sales staff---</option>
								<c:forEach var="item" items="${nv.listResult}">
									<option value="${item.id}">${item.hoVaTenString}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="">Customer
								information</label>
							<textarea class="form-control" id="thongTinKhachHangString"
								name="thongTinKhachHangString" rows="3">${model.thongTinKhachHangString}</textarea>
						</div>
						<div class="row">
							<h6 class="col">Order information</h6>
						</div>
						<div class="col-md-offset-3 col-md-9">
							<button class="btn btn-info" type="button" id="btnAddProduct">
								<i></i> Add product
							</button>
							<button class="btn btn-info" type="button" id="btnDeleteProduct">
								<i></i> Delete product
							</button>
						</div>
						<br>
						<table class="table myaccordion table-hover" id="accordion">
							<thead>
								<tr>
									<th class="center">Product</th>
									<th class="center">Quantity</th>
									<th scope="row" colspan=3>Manipulation</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${model.thongTinDonHangDtos}">
									<tr>
										<td><select class="form-control" id="idSP" name="idSP">
												<option value="">---Select product---</option>
												<c:forEach var="item" items="${sp.listResult}">
													<option value="${item.id}">${item.tenSanPhamString}
														${item.soLuong}</option>
												</c:forEach>
										</select></td>
										<td><input class="form-control" id="soLuong"
											name="soLuong" value="${item.soLuongBan}"></td>
										<td><button id="btnDelete" type="button"
												onclick="warningBeforeDelete(${item.id})"
												class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
												data-toggle="tooltip" title='Xóa sản phẩm'>
												<span> <i class="bi bi-trash">Delete</i>
												</span>
											</button></td>
									</tr>
								</c:forEach>
							</tbody>
							<tfoot>
								<tr>
									<td colspan=5></td>
								</tr>
							</tfoot>
						</table>
						<div class="form-group">
							<label class="col-sm-6 control-label no-padding-right" for="">Discount</label>
							<input class="form-control" id="chietKhauLong"
								name="chietKhauLong" value="${model.chietKhauLong}">
						</div>
						<div class="clearfix form-actions">
							<div class="col-md-offset-3 col-md-9">
								<button class="btn btn-info" type="button" id="btnAddOrUpdate">
									<i class="ace-icon fa fa-check bigger-110"></i> Add order
								</button>
								&nbsp; &nbsp; &nbsp;
								<button class="btn" type="reset">
									<i class="ace-icon fa fa-undo bigger-110"></i> Cancel
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
		$('#btnAddProduct').click(
				function(e) {
					e.preventDefault();
					var soLuong = ${model.soLuongSanPham}+1;
					window.location.href = "/trang-chu/don-hang/them?soLuong="
							+ soLuong + "";
				});
		$('#btnDeleteProduct').click(
				function(e) {
					e.preventDefault();
					var soLuong = ${model.soLuongSanPham}-1;
					window.location.href = "/trang-chu/don-hang/them?soLuong="
							+ soLuong + "";
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
			data["soLuongSanPham"] = ${model.soLuongSanPham};
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