<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login - Deep Gaming</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<!--===============================================================================================-->
<!--===============================================================================================-->
<!--===============================================================================================-->
<!--===============================================================================================-->
<!--===============================================================================================-->
<!--===============================================================================================-->
<!--===============================================================================================-->
<!--===============================================================================================-->
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="css/utilLogin.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="css/mainLogin.css" />" />

<!--===============================================================================================-->
</head>
<body>

	<form:form class="form-horizontal" method="POST"
		modelAttribute="newUser">
		<div class="limiter">
			<div class="container-login100">
				<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50">
					<form class="login100-form validate-form">
						<span class="login100-form-title p-b-33"> Account Login </span>

						<div class="wrap-input100 validate-input"
							data-validate="Valid email is required: ex@abc.xyz">
							<form:input class="input100" path="firstName" type="text"
								name="firstName" placeholder="First Name" />
							<span class="focus-input100-1"></span> <span
								class="focus-input100-2"></span>
						</div>

						<div class="wrap-input100 validate-input"
							data-validate="Valid email is required: ex@abc.xyz">
							<form:input class="input100" path="lastName" type="text"
								name="lastName" placeholder="Last Name" />
							<span class="focus-input100-1"></span> <span
								class="focus-input100-2"></span>
						</div>
						
							<div class="wrap-input100 validate-input"
							data-validate="Valid email is required: ex@abc.xyz">
							<form:input class="input100" path="username" type="text"
								name="username" placeholder="Username" />
							<span class="focus-input100-1"></span> <span
								class="focus-input100-2"></span>
						</div>

						<div class="wrap-input100 validate-input"
							data-validate="Valid email is required: ex@abc.xyz">
							<form:input class="input100" path="email" type="email"
								name="email" placeholder="Email" />
							<span class="focus-input100-1"></span> <span
								class="focus-input100-2"></span>
						</div>


						<div class="wrap-input100 validate-input"
							data-validate="Valid email is required: ex@abc.xyz">
							<form:input type="date" id="dateOfBirth" 
								placeholder="Date Of Birth" path="date"
								class="form-control input100" />
							<span class="focus-input100-1"></span> <span
								class="focus-input100-2"></span>
						</div>

						<div class="wrap-input100 rs1 validate-input"
							data-validate="Password is required">
							<form:input class="input100" path="password" type="password" name="pass"
								placeholder="Password" /> <span class="focus-input100-1"></span>
							<span class="focus-input100-2"></span>
						</div>

						<div class="container-login100-form-btn m-t-20">
							<input type="submit" value="Sign Up" class="login100-form-btn">
						</div>

						<br>
						<div class="text-center">
							<span class="txt1"> Create an account? </span>


						</div>
					</form>
				</div>
			</div>
		</div>
	</form:form>


	<!--===============================================================================================-->
	<!--===============================================================================================-->

	<!--===============================================================================================-->
	<!--===============================================================================================-->
	<!--===============================================================================================-->

</body>
</html>