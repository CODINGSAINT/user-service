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
				<h3>Edit User Details</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">

				<form role="form" action="${pageContext.request.contextPath}/user" method="post"
					enctype="application/x-www-form-urlencoded">
					<div class="form-group">
					<input type="hidden" name="userId" value="${user.userId}"> 

						<label for="firstName"> First Name </label> <input type="text"
							class="form-control" name="firstName" id="firstName" value="${user.firstName}">
					</div>
					<div class="form-group">

						<label for="lastName"> Last Name </label> <input type="text"
							class="form-control" name="lastName" id="lastName" value="${user.lastName}">
					</div>
					<div class="form-group">

						<label for="email"> Email </label> <input
							type="email" name="email" class="form-control"
							id="exampleInputEmail1" value="${user.email}">
					</div>


					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
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