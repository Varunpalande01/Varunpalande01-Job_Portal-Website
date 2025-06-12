<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored ="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Panel</title>
<%@include file="all_component/all_css.jsp"%>
<style type="text/css">
.back-img {
   background: url("img/ad.jpg");
   width: 100%;
   height: 90vh;
   background-size: cover;
   background-repeat: no-repeat;
   background-position: center;
   image-rendering: auto;
}
</style>

</head>
<body >
<c:if test="${Userobj.role ne 'admin'}">
    <c:redirect url ="login.jsp" />
</c:if>

	<%@include file="all_component/navbar.jsp"%>
	<div class="continer-fluid back-img">
		<div class="text-center">
			<h1 class="text-white p-4">Welcome Admin</h1>
		</div>
	</div>
</body>
</html>