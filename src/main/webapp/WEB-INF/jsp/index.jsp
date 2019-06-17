<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>User Service</title>


<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet">

</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-12 text-center">
				<h3>User Details</h3>
				<c:if test="${not empty msg }">
				
				<div class="alert alert-success" role="alert">
					${msg}
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				</c:if>
				<c:if test="${not empty error }">
				
				<div class="alert alert-danger" role="alert">
					A simple danger alert-check it out!
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				</c:if>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">

				<form role="form" action="${pageContext.request.contextPath}/user"
					method="post" enctype="application/x-www-form-urlencoded">
					<div class="form-group">

						<label for="firstName"> First Name </label> <input type="text"
							class="form-control" name="firstName" id="firstName">
					</div>
					<div class="form-group">

						<label for="lastName"> Last Name </label> <input type="text"
							class="form-control" name="lastName" id="lastName">
					</div>
					<div class="form-group">

						<label for="exampleInputEmail1"> Email </label> <input
							type="email" name="email" class="form-control"
							id="exampleInputEmail1">
					</div>


					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
			<div class="col-md-8">
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Action</th>
						</tr>
					</thead>

					<tbody>

						<c:forEach var="u" varStatus="count" items="${users}">
							<tr>
								<td>${count.index+1}</td>
								<td><c:out value="${u.firstName}" /></td>
								<td><c:out value="${u.lastName}" /></td>
								<td><c:out value="${u.email}" /></td>
								<td><a href="editUser/${u.userId}">

										<button type="button" class="btn btn-success btn-sm">
											Edit</button>
								</a> <a href="deleteUser/${u.userId}">
										<button type="button" class="btn btn-danger btn-sm">
											Delete</button>
								</a></td>

							</tr>
						</c:forEach>


					</tbody>
				</table>

			</div>
		</div>
	</div>

	<script
		src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>