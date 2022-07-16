<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<section class="login-block">
	<div class="container">
		<div class="row">
			<div class="col-md-4 login-sec">
				<c:if test="${param.incorrectAccount != null}">
					<div class="alert alert-danger">Username or password
						incorrect</div>
				</c:if>
				<c:if test="${param.accessDenied != null}">
					<div class="alert alert-danger">you Not authorize</div>
				</c:if>
				<h2 class="text-center">Login Now</h2>
				<form class="login-form" action="j_spring_security_check"
					id="formLogin" method="post">
					<div class="form-group">
						<label for="exampleInputEmail1" class="text-uppercase">Tên
							đăng nhập</label> <input type="text" class="form-control" id="userName"
							name="j_username" placeholder="">
					</div>

					<div class="form-group">
						<label for="exampleInputPassword1" class="text-uppercase">Mật
							khẩu</label> <input type="password" class="form-control" id="password"
							name="j_password" placeholder="">
					</div>
					<button type="submit" class="btn btn-primary">Đăng nhập</button>
				</form>
			</div>

			<div class="col-md-8 banner-sec">
				<div id="carouselExampleIndicators" class="carousel slide"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to="0"
							class=""></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="1"
							class=""></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="2"
							class="active"></li>
					</ol>
					<div class="carousel-inner" role="listbox">
						<div class="carousel-item">
							<img class="d-block img-fluid"
								src="https://static.pexels.com/photos/33972/pexels-photo.jpg"
								alt="First slide">
							<div class="carousel-caption d-none d-md-block">
								<div class="banner-text">
									<h2>This is Heaven</h2>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,
										sed do eiusmod tempor incididunt ut labore et dolore magna
										aliqua. Ut enim ad minim veniam, quis nostrud exercitation</p>
								</div>
							</div>
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid"
								src="https://images.pexels.com/photos/7097/people-coffee-tea-meeting.jpg"
								alt="First slide">
							<div class="carousel-caption d-none d-md-block">
								<div class="banner-text">
									<h2>This is Heaven</h2>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,
										sed do eiusmod tempor incididunt ut labore et dolore magna
										aliqua. Ut enim ad minim veniam, quis nostrud exercitation</p>
								</div>
							</div>
						</div>
						<div class="carousel-item active">
							<img class="d-block img-fluid"
								src="https://images.pexels.com/photos/872957/pexels-photo-872957.jpeg"
								alt="First slide">
							<div class="carousel-caption d-none d-md-block">
								<div class="banner-text">
									<h2>This is Heaven</h2>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,
										sed do eiusmod tempor incididunt ut labore et dolore magna
										aliqua. Ut enim ad minim veniam, quis nostrud exercitation</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>

</body>
</html>