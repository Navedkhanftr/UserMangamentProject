<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.um.model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>USER MANAGEMENT SYSTEM</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-light">
	<div class="container-fluid">
		<a class="navbar-brand">USER MANAGEMENT SYSTEM</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="<%=request.getContextPath()%>/list">USERS</a>
				</li>
			</ul>
		</div>
	</div>
	</nav>
	<c:if test="${list==null }">
		<form action="insert" method="post">
	</c:if>
	<c:if test="${list!=null }">
		<form action="update" method="post">
	</c:if>
	<h2 align="center">
		<c:if test="${list==null }">
ADD USER
</c:if>
		<c:if test="${list!=null }">
EDIT USER
</c:if>
	</h2>
	<div class="mb-3 container">
	<input type="hidden" class ="form control" id=" exampleFormControlInput5" value="${list.id}" name="id" style="width: 300px"> 
	</div>
	<div class="row">
		<div class="col-md-6 mt-3">
			<label for="exampleFormControlInput1" class="form-label">Name</label>
			<input type="text" class="form-control" id="exampleFormControlInput1"
				value="${list.name }" placeholder="ENTER YOUR NAME" name="name"
				style="width: 300px">
		</div>
	</div>
	<div class="col-md-6 mt-3">
		<label for="exampleFormControlInput2" class="form-label1">Email</label>
		<input type="email" class="form-control" id="exampleFormControlInput2"
			value="${list.email}" placeholder="ENTER YOUR EMAIL" name="email"
			style="width: 300px">
	</div>
	<div class="col-md-12 mt-3">
		<label for="exampleFormControlInput3" class="form-label">City</label>
		<input type="text" class="form-control" id="exampleFormControlInput1"
			value="${list.city}" placeholder="ENTER YOUR CITY" name="city"
			style="width: 300px">
	</div>
	<div clas="col-md-6"></div>
	<div class="col-md-3 mt-3">
		<input type="submit" value="save" class="btn btn-success form-control" />
	</div>
	</div>
	</form>
	</div>
	</div>
	</div>
	</div>
	</div>


</body>
</html>