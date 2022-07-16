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
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-4">
					<h2 class="heading-section">Danh sách sản phẩm</h2>
				</div>
			</div>
			<div class="page-content">
				<div class="row" id="page-content">
					<div class="col-md-12">
						<div class="table-wrap">
							<table class="table myaccordion table-hover" id="accordion">
								<thead>
									<tr>
										<th scope="row">Mã sản phẩm</th>
										<th scope="row">Tên sản phẩm</th>
										<th scope="row">Ảnh minh họa</th>
										<th scope="row">Loại sản phẩm</th>
										<th scope="row">Giá bán</th>
										<th scope="row">Số lượng</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${sanPham.listResult}">
										<tr>
											<th scope="row">${item.id}</th>
											<td>${item.tenSanPhamString}</td>
											<td>${item.anhDaiDienString}</td>
											<td>${item.loaiSanPhamString}</td>
											<td>${item.giaBanLong}</td>
											<td>${item.soLuong}</td>
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
		
	</script>
</body>
</html>