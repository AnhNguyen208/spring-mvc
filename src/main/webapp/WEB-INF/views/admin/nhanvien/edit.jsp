<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api/nhanvien" />
<c:url var="NhanVienUrl" value="/quan-tri/nhan-vien/danh-sach" />
<c:url var="EditNhanVienUrl" value="/quan-tri/nhan-vien/chinh-sua" />
<html>
<head>
<title>Chỉnh sửa thông tin nhân viên</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>

				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
					</li>

					<li><a href="#">Forms</a></li>
					<li class="active">Form Elements</li>
				</ul>
			</div>

			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<c:if test="${not empty message}">
							<div class="alert alert-${alert}" role="alert">
  								${message}
							</div>
						</c:if>
						<!-- PAGE CONTENT BEGINS -->
						<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="maChucVuString">Chuc vu</label>
								<div class="col-sm-9">
									<%-- <select class="form-control" id="maChucVuString"
										name="maChucVuString">
										<option value="">---Chon chuc vu---</option>
										<c:forEach var="item" items="${chucvu}">
											<option value="${item.maChucVuString }">${item.tenChucVuString}</option>
										</c:forEach>
									</select> --%>
									<form:select path="maChucVuString" id="maChucVuString">
										<form:option value="" label="--- Chon chuc vu ---"/>
										<form:options items="${chucvu}"/>
									</form:select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="hoVaTenString"> Họ và tên </label>
								<div class="col-sm-9">
									<%-- <input type="text" class="col-xs-10 col-sm-5"
										id="hoVaTenString" name="hoVaTenString" value="${model.hoVaTenString}"/> --%>
									<form:input path="hoVaTenString" cssClass="col-xs-10 col-sm-5"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="anhDaiDienString">Ảnh đại diên </label>
								<div class="col-sm-9">
									<form:textarea path="anhDaiDienString" rows="5" cols="10" cssClass="form-control" id="anhDaiDienString"/>
									<!-- <input type="file" class="col-xs-10 col-sm-5"
										id="anhDaiDienString" name="anhDaiDienString" accept="image/png, image/jpeg"/> -->
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="diaChiString">Địa chỉ</label>
								<div class="col-sm-9">
									<%-- <textarea class="form-control" rows="5" cols="10"
									id="diaChiString" name="diaChiString">${model.diaChiString}</textarea> --%>
									<form:textarea path="diaChiString" rows="5" cols="10" cssClass="form-control" id="diaChiString"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="emailString"> Email </label>
								<div class="col-sm-9">
									<%-- <input type="text" class="col-xs-10 col-sm-5"
										id="emailString" name="emailString" value="${model.emailString}"/> --%>
									<form:input path="emailString" cssClass="col-xs-10 col-sm-5"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="sdtString">SDT</label>
								<div class="col-sm-9">
									<%-- <input type="text" class="col-xs-10 col-sm-5"
										id="sdtString" name="sdtString" value="${model.sdtString}"/> --%>
									<form:input path="sdtString" cssClass="col-xs-10 col-sm-5"/>
								</div>
							</div>
							<form:hidden path="id" id="idNhanVien"/>
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
								<c:if test="${not empty model.id}">
									<button class="btn btn-info" type="button" id="btnAddOrUpdate">
										<i class="ace-icon fa fa-check bigger-110"></i> Cập nhật nhân viên
									</button>
								</c:if>
								<c:if test="${empty model.id}">
									<button class="btn btn-info" type="button" id="btnAddOrUpdate">
										<i class="ace-icon fa fa-check bigger-110"></i> Thêm nhân viên
									</button>
								</c:if>
									&nbsp; &nbsp; &nbsp;
									<button class="btn" type="reset">
										<i class="ace-icon fa fa-undo bigger-110"></i> Huy
									</button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script>
	var editor = '';
	$(document).ready(function(){
		editor = CKEDITOR.replace( 'anhDaiDienString' );
	});
	
	$('#btnAddOrUpdate').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        var id = $('#idNhanVien').val();
        $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
        data["anhDaiDienString"] = editor.getData();
        if(id == '') {
        	delete data.id;
        	addNhanVien(data);
        } else {
        	updateNhanVien(data);
        }
        console.log(formData);
    });
	
	function addNhanVien(data) {
		 $.ajax({
	            url: '${APIurl}',
	            type: 'POST',
	            contentType: 'application/json; charset=UTF-8',
	            data: JSON.stringify(data),
	            dataType: 'json',
	            success: function (result) {
	            	window.location.href = "${EditNhanVienUrl}?id="+result.id+"&message=insert_success";
	            },
	            error: function (error) {
	            	window.location.href = "${NhanVienUrl}?page=1&limit=2&message=error_system";
	            }
	        });
	}
	
	function updateNhanVien(data) {
		 $.ajax({
	            url: '${APIurl}',
	            type: 'PUT',
	            contentType: 'application/json; charset=UTF-8',
	            data: JSON.stringify(data),
	            dataType: 'json',
	            success: function (result) {
	            	window.location.href = "${EditNhanVienUrl}?id="+result.id+"&message=update_success";
	            },
	            error: function (error) {
	            	window.location.href = "${NhanVienUrl}?page=1&limit=2&message=error_system";
	            }
	        });
	}
	</script>
</body>
</html>