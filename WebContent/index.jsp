<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
.custom_div {
	margin-left: 33%;
}
</style>
</head>
<body>
	<div class="w3-sidebar w3-bar-block w3-light-grey w3-xlarge"
		style="width: 70px">
		<a href="index.jsp" class="w3-bar-item w3-button"><i
			class="fa fa-home"></i></a> <a href="#" class="w3-bar-item w3-button"><i
			class="fa fa-envelope"></i></a> <a href="#" class="w3-bar-item w3-button"><i
			class="fa fa-globe"></i></a> <a href="#" class="w3-bar-item w3-button"><i
			class="fa fa-trash"></i></a>
	</div>
	<div style="margin-left: 70px">

		<div class="w3-display-container">
			<div class="w3-card-2">
				<div class="w3-container w3-center w3-teal">
					<h2>DASHBOARD</h2>
				</div>
			</div>
		</div>
		<hr>
		<div class="w3-display-container">
			<div class="w3-row w3-container">
				<div class="w3-col s4">
					<div class="w3-card">
						<header class="w3-container w3-teal">
							<h4>Admin Login</h4>
						</header>
						<form class="w3-container" action="AdminLoginVerify" method="post">
							<p>
								<input type="text" name="username" placeholder="username"
									class="w3-input" required >
							</p>
							<p>
								<input type="password" name="password" placeholder="password"
									class="w3-input" required>
							</p>
							<p>
								<input type="submit" value="LOGIN"
									class="w3-button w3-teal w3-hover-black"/>
							</p>
						</form>
					</div>
				</div>

				<div class="w3-col s4 custom_div">
					<div class="w3-card">
						<header class="w3-container w3-teal">
							<h4 class="w3-left">Librarian Login</h4>
							<a href="signup.jsp"> <input type="submit" value="SIGN UP"
								class="w3-button w3-right w3-hover-black">
							</a>
						</header>
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