<%@ page import="com.quanlydoanhthu.util.SecurityUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="#">Start Bootstrap</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link"
					href="<c:url value='/trang-chu'/>">Trang chủ <span
						class="sr-only">(current)</span>
				</a></li>
				<security:authorize access="isAnonymous()">
					<li class="nav-item"><a class="nav-link"
						href="<c:url value='/dang-nhap'/>">Đăng nhập</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Đăng kí</a></li>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<div class="dropdown">
						<button class="btn btn-secondary dropdown-toggle" type="button"
							id="dropdownMenuButton" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">
							Wellcome,<%=SecurityUtils.getPrincipal().getFullNameString()%></button>
						<c:if
							test="${SecurityUtils.getPrincipal().getPhanQuyenString() == 'USER1'}">
							<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
								<li class="dropdown-header">Tài khoản</li>
								<li><a class="dropdown-item" href="/trang-chu/thong-tin">Thông
										tin tài khoản</a></li>
								<li><a class="dropdown-item" href="<c:url value='/thoat'/>">Thoát</a></li>
								<li class="dropdown-header">Đơn hàng</li>
								<li><a class="dropdown-item"
									href="/trang-chu/don-hang/danh-sach">Danh sách đơn hàng</a></li>
								<li><a class="dropdown-item"
									href="/trang-chu/don-hang/them">Thêm đơn hàng</a></li>
								<li class="dropdown-header">Nhập hàng</li>
								<li><a class="dropdown-item" href="#">Danh sách hóa đơn
										nhập hàng</a></li>
								<li><a class="dropdown-item" href="#">Thêm hóa đơn nhập
										hàng</a></li>
								<li><a class="dropdown-item"
									href="/trang-chu/san-pham/danh-sach">Sản phẩm</a></li>
							</ul>
						</c:if>
						<c:if
							test="${SecurityUtils.getPrincipal().getPhanQuyenString() == 'USER2'}">
							<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
								<li class="dropdown-header">Dropdown header</li>
								<li><a class="dropdown-item" href="#">Xuất, nhập kho </a></li>
								<li><a class="dropdown-item" href="/trang-chu/thong-tin">Thông
										tin tài khoản</a></li>
								<li><a class="dropdown-item"
									href="/trang-chu/don-hang/danh-sach">Đơn hàng</a></li>
								<li><a class="dropdown-item" href="<c:url value='/thoat'/>">Thoát</a></li>
							</ul>
						</c:if>
					</div>
				</security:authorize>

			</ul>
		</div>
	</div>
</nav>