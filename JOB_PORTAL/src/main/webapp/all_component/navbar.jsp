
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-custom">
	<a class="navbar-brand" href="#">Navbar</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="home.jsp">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<c:if test="${Userobj.role eq 'admin' }">
				<li class="nav-item"><a class="nav-link" href="add_job.jsp"><i
						class="fa-solid fa-circle-plus"></i> Post Job</a></li>
				<li class="nav-item"><a class="nav-link" href="viewjob.jsp"><i
						class="fa-regular fa-eye"></i> View Job</a></li>
			</c:if>




		</ul>
		<form class="form-inline my-2 my-lg-0">

			<c:if test="${ Userobj.role eq 'admin' }">
				<a href='#' class="btn btn-light mr-1"><i
					class="fa-solid fa-user"></i> Admin </a>
				<a href='logout' class="btn btn-light"> <i
					class="fa-solid fa-right-to-bracket"></i> Logout
				</a>
			</c:if>
			<c:if test="${ Userobj.role eq 'user' }">
				<a href='#' class="btn btn-light mr-1" data-toggle="modal"
					data-target="#exampleModal"><i class="fa-solid fa-user"></i>
					${Userobj.name } </a>
				<a href='logout' class="btn btn-light"> <i
					class="fa-solid fa-right-to-bracket"></i> Logout
				</a>
			</c:if>




			<c:if test="${ empty Userobj }">
				<a href='login.jsp' class="btn btn-light mr-1"><i
					class="fa-solid fa-right-to-bracket"></i> Login</a>
				<a href='signup.jsp' class="btn btn-light"><i
					class="fa-solid fa-user"></i> Signup </a>
			</c:if>

		</form>
	</div>




	<!-- Button trigger modal -->


	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Profile</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="card">
						<div class="card-body">
							<div class="text-center text-primary">
								<i class=" fa fa-user-circle fa-3x"></i>
							</div>
							<table class="table">
								<tbody>
									<tr>
										<th scope="row">Now :-</th>
										<th>${Userobj.name }</th>
									</tr>
									<tr>
										<th scope="row">Qualification :-</th>
										<th>${Userobj.qualification }</th>
									</tr>
									<tr>
										<th scope="row">Email ;-</th>
										<th>${Userobj.email }</th>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
							<a href="edit_profile.jsp" class="btn btn-primary">Edit</a>
						</div>

					</div>
				</div>
			</div>
</nav>