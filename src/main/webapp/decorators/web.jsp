<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
<!-- Bootstrap core CSS -->
<link
	href="<c:url value='/template/web/vendor/bootstrap/css/bootstrap.min.css'/>"
	rel="stylesheet" type="text/css">
<!-- Custom styles for this template -->
<link href="<c:url value='/template/web/css/small-business.css'/>"
	rel="stylesheet">
<link href="<c:url value='/template/web/profile.css'/>" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type='text/javascript'
	src='<c:url value="/template/admin/js/jquery-2.2.3.min.js" />'></script>
<script
	src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js' />"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="<c:url value='/template/ckeditor/ckeditor.js' />"></script>
<!-- Option 1: Include in HTML -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<script
	src='<c:url value="/template/admin/sweetalert/sweetalert2.min.js" />'></script>
<link rel="stylesheet"
	href="<c:url value='/template/admin/sweetalert/sweetalert2.min.css' />" />
</head>
<body>
	<!-- Navigation -->
	<%@ include file="/common/web/header.jsp"%>
	<br>

	<dec:body />
	<br>

	<!-- Footer -->
	<%@ include file="/common/web/footer.jsp"%>

	<!-- Bootstrap core JavaScript -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script
		src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script>
	<script
		src="<c:url value='/template/web/vendor/jquery/jquery.min.js'/>"></script>
	<script
		src="<c:url value='/template/web/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
</body>
</html>