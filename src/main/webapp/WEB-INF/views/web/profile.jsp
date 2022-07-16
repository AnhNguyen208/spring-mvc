<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/profile.css" rel="stylesheet" />
<link rel="shortcut icon" type="image/x-icon"
	href="https://www.bootdey.com/img/favicon.ico">
<link rel="canonical"
	href="https://www.bootdey.com/snippets/preview/account-setting-or-edit-profile"
	itemprop="url">
<link rel="alternate" type="application/rss+xml"
	title="Latest snippets resources templates and utilities for bootstrap from bootdey.com:"
	href="http://bootdey.com/rss">
<script
	src="/cache-js/cache-1635427806-97135bbb13d92c11d6b2a92f6a36685a.js"
	type="text/javascript"></script>
</head>

<body>
	<div class="container pt-3">
		<h4 class="font-weight-bold py-3 mb-4"> Cài đặt tài khoản</h4>
		<div class="main-content">
			<div id="snippetContent">
				<div class="row gutters">
					<div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
						<div class="card h-100">
							<div class="card-body">
								<div class="account-settings">
									<div class="user-profile">
										<div class="user-avatar">
											<img src="https://bootdey.com/img/Content/avatar/avatar7.png"
												alt="Maxwell Admin">
										</div>
										<h5 class="user-name">${model.hoVaTenString}</h5>
										<h6 class="user-email">${model.emailString}</h6>
									</div>
									<div class="about">
										<h5>Chức vụ</h5>
										<p>${model1.tenChucVuString}</p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
						<div class="card h-100">
							<div class="card-body">
								<div class="row gutters">
									<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
										<h6 class="mb-2 text-primary">Thông tin cá nhân</h6>
									</div>
									<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
										<div class="form-group">
											<label for="fullName">Họ và tên</label> <input type="text"
												class="form-control" id="fullName"
												value="${model.hoVaTenString}" placeholder="Enter full name">
										</div>
									</div>
									<div class="ccol-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
										<div class="form-group">
											<label for="eMail">Email</label> <input type="email"
												class="form-control" id="eMail" value="${model.emailString}"
												placeholder="Enter email ID">
										</div>
									</div>
									<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
										<div class="form-group">
											<label for="phone">Số điện thoại</label> <input type="text"
												class="form-control" id="phone" value="${model.sdtString}"
												placeholder="Enter phone number">
										</div>
									</div>
									<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
										<div class="form-group">
											<label for="phone">Địa chỉ</label> <input type="text"
												class="form-control" id="phone"
												value="${model.diaChiString}"
												placeholder="Enter phone number">
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
					
				</div>
			</div>
		</div>
		<h4 class="font-weight-bold py-3 mb-4"></h4>
	</div>
</body>

</html>