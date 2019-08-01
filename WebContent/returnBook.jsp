<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<title>Return Book</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container" style="margin-top: 150px">
		<div class="row  justify-content-center">
			<div class="col-sm-4">
				<div class="card">
					<header class="card-header">
						<h4>Return Book</h4>
					</header>
					<div class="card-body">
						<form action="ReturnBook" method="post">
							<div class="form-group">
								<input type="text" class="form-control" name="cellno"
									placeholder="Cell Number" required>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" name="studentid"
									placeholder="Student Id" required>
							</div>
							<div class="form-group">
								<input type="submit" value="RETURN BOOK"
									class="btn btn-info btn-block">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>