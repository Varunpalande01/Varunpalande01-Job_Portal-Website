<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile</title>
<%@include file="all_component/all_css.jsp"%>
</head>

<body style="background-color: #f0f1f2;">

<c:if test="${empty Userobj}">
    <c:redirect url="login.jsp"/>
</c:if>

<%@include file="all_component/navbar.jsp"%>

<div class="container-fluid">
    <div class="row p-5">
        <div class="col-md-4 offset-md-4">

            <div class="card">
                <div class="card-body">

                    <div class="text-center mb-3">
                        <i class="fa fa-user fa-2x"></i>
                        <h5>Edit Profile</h5>
                    </div>

                    <form action="update_profile" method="post">

                        <!-- IMPORTANT -->
                        <input type="hidden" name="id" value="${Userobj.id}">

                        <div class="form-group">
                            <label>Full Name</label>
                            <input type="text" name="name"
                                   class="form-control"
                                   value="${Userobj.name}" required>
                        </div>

                        <div class="form-group">
                            <label>Email</label>
                            <input type="email" name="email"
                                   class="form-control"
                                   value="${Userobj.email}" required>
                        </div>

                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" name="password"
                                   class="form-control"
                                   value="${Userobj.password}" required>
                        </div>

                        <div class="form-group">
                            <label>Qualification</label>
                            <input type="text" name="qualification"
                                   class="form-control"
                                   value="${Userobj.qualification}" required>
                        </div>

                        <button type="submit"
                                class="btn btn-primary btn-block">
                            Update Profile
                        </button>

                    </form>

                </div>
            </div>

        </div>
    </div>
</div>

</body>
</html>
