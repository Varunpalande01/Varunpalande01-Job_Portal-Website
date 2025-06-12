<%@page import="com.DB.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored ="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Job_Portal</title>
<%@include file="all_component/all_css.jsp" %>
<style type="text/css">
.back-img{
   background-image:url("img/j.jpg");
   width: 100%;
   height: 90vh;
   background-size: 100%;
background-repeat: no-repeat;
background-position: center;
}
h1.portal-title {
   font-family: 'Poppins', sans-serif;
   color: white;  /* Dark amber yellow */
   font-weight: 650;
   text-shadow: 1px 1px 2px rgba(0,0,0,0.3); /* improves readability on image */
}
</style>
</head>
<body>
<%@include file="all_component/navbar.jsp" %>



	<div class="container-fluid back-img">
		<div class="text-center">
			<h1 class="portal-title p-4">
				<i class="fa fa-book" aria-hidden="true"></i>
				    Online Job Portal
			</h1>
		</div>
	</div>
<%@include file="all_component/footer.jsp" %>
</body>
</html>