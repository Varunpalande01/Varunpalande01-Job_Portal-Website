<%@page import="com.entity.jobs"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile Page</title>
<%@include file="all_component/all_css.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty Userobj}">
		<c:redirect url="login.jsp" />
	</c:if>

	<%@include file="all_component/navbar.jsp"%>
	<div class="continer-fluid">
		<div class="row p-5">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<div class="text-center">
							<i class="fa fa-user-plus fa-2x"></i>
							<h5>Edit Profile</h5>
						</div>
						<form action="update_profile" method="post">
							<input type="hidden" name="id" value="${Userobj.id }">
							<div class="form-group">

								<label>Enter Full name</label><input type="text"
									required="required" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									name="name" value="${Userobj.name }">
							</div>
							<div class="form-group">

								<label>Enter Email</label><input type="email"
									required="required" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									name="email" value="${Userobj.email }">
							</div>
							
							<div class="form-group">
								<label for="exampleInputpassword1">Enter Password</label><input
									type="password" required="required" class="form-control"
									id="exampleInputpassword1" name="ps" value="${Userobj.password }">
							</div>
							<div class="form-group">
								<label for="exampleInputpassword1">Enter Qualification</label><input
									type="text" required="required" class="form-control"
									id="exampleInputpassword1" name="qua"
									value="${Userobj.qualification }">
							</div>
							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>