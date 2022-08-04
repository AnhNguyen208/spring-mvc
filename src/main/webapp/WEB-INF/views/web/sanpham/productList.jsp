<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sản phẩm</title>
</head>
<body>
	<div class="container pt-3">
		<form action="<c:url value='/trang-chu/san-pham/danh-sach'/>"
			id="formSubmit" method="get">
			<c:if test="${not empty message}">
				<div class="alert alert-${alert}" role="alert">${message}</div>
			</c:if>
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-4">
					<h2 class="heading-section">Danh sách sản phẩm</h2>
				</div>
			</div>
			<div class="page-content">
				<div class="row" id="page-content">
					<div class="col-md-12">
						<input type="text" id="myInput" onkeyup="myFunction()"
							placeholder="Tìm kiếm theo tên sản phẩm" title="Type in a name">
						<div class="table-wrap">
							<h2></h2>
							<table class="table myaccordion table-hover" id="accordion">
								<thead>
									<tr>
										<th scope="row">Mã sản phẩm</th>
										<th scope="row">Tên sản phẩm</th>
										<th scope="row">Ảnh minh họa</th>
										<th scope="row">Loại sản phẩm</th>
										<th scope="row">Thương hiệu thời trang</th>

										<th scope="row" colspan=3>Thao tác</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${sanPham.listResult}">
										<tr>
											<th scope="row">${item.id}</th>
											<td>${item.tenSanPhamString}</td>
											<td>${item.anhDaiDienString}</td>
											<td>${item.loaiSanPhamString}</td>
											<td>${item.hangString}</td>
											<td><a
												class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
												data-toggle="tooltip"
												href="/trang-chu/san-pham/chinh-sua?id=${item.id}"><i
													class="bi bi-pencil-square">Chỉnh sửa</i></a></td>
											<td><button id="btnDelete" type="button"
													onclick="warningBeforeDelete(${item.id})"
													class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
													data-toggle="tooltip" title='Xóa bài viết'>
													<span> <i class="bi bi-trash">Xóa</i>
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
												<h4>Chi tiết sản phẩm</h4>
												<table class="table myaccordion table-hover" id="accordion1">
													<thead>
														<tr>
															<th>#</th>
															<th scope="row">Màu sắc</th>
															<th scope="row">Kích cỡ</th>
															<th scope="row">Giá bán</th>
															<th scope="row">Giá nhập</th>
															<th scope="row">Số lượng</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<th scope="row"></th>
															<td>${item.mauSacString}</td>
															<td>${item.kichCoString}</td>
															<td>${item.giaBanLong}</td>
															<td>${item.giaNhapLong}</td>
															<td>${item.soLuong}</td>
														</tr>
													</tbody>
												</table>
											</td>
										</tr>
									</c:forEach>
								</tbody>
								<tfoot>
									<tr>
										<td colspan=6></td>
									</tr>
								</tfoot>
							</table>
						</div>
					</div>
				</div>
			</div>
		</form>

	</div>
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
					url : '/api/sanpham',
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
		function myFunction() {
			  var input, filter, table, tr, td, i, txtValue;
			  input = document.getElementById("myInput");
			  filter = input.value.toUpperCase();
			  table = document.getElementById("accordion");
			  tr = table.getElementsByTagName("tr");
			  for (i = 0; i < tr.length; i++) {
			    td = tr[i].getElementsByTagName("td")[0];
			    if (td) {
			      txtValue = td.textContent || td.innerText;
			      if (txtValue.toUpperCase().indexOf(filter) > -1) {
			        tr[i].style.display = "";
			      } else {
			        tr[i].style.display = "none";
			      }
			    }       
			  }
			}
	</script>
</body>
</html>