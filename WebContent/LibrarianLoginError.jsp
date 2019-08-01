<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
	<div class="w3-display-container">
		<div class="w3-card-2">
			<div class="w3-container w3-center w3-teal">
				<h2>Login Error</h2>
			</div>
		</div>
	</div>

	<div class="container" style="margin-top: 100px">
		<div class="row justify-content-center">
			<div class="col-sm-4">
				<div class="card">
					<header class="card-header">
						<h4>Librarian Login</h4>
					</header>
					<div class="card-body">
						<form class="w3-container" action="librarianLoginProcess.jsp"
							method="post">
							<p>
								<input type="text" name="username" placeholder="username"
									class="w3-input" required>
							</p>
							<p>
								<input type="password" name="password" placeholder="password"
									class="w3-input" required>
							</p>
							<p>
								<input type="submit" value="LOGIN"
									class="w3-button w3-hover-black w3-teal">
							</p>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>