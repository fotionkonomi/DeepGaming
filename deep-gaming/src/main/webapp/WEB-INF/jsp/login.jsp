<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<link rel="stylesheet" href="<c:url value="css/utilLogin.css" />" />
<link rel="stylesheet" href="<c:url value="css/mainLogin.css" />" />

<!--===============================================================================================-->
</head>
<body>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50">
				<form class="login100-form validate-form" action="login"
					method="post">
					<span class="login100-form-title p-b-33"> Account Login </span>
					<c:if test="${param.error}">
						<h1>${error}</h1>
					</c:if>
					<div class="wrap-input100 validate-input"
						data-validate="Valid email is required: ex@abc.xyz">
						<input class="input100" type="text" name="username"
							placeholder="Username"> <span class="focus-input100-1"></span>
						<span class="focus-input100-2"></span>
					</div>

					<div class="wrap-input100 rs1 validate-input"
						data-validate="Password is required">
						<input class="input100" type="password" name="pass"
							placeholder="Password"> <span class="focus-input100-1"></span>
						<span class="focus-input100-2"></span>
					</div>

					<div class="container-login100-form-btn m-t-20">
						<input type="submit" value="Sign in" class="login100-form-btn">
					</div>

					<br>
					<div class="text-center">
						<span class="txt1"> Create an account? </span> <a href="signup"
							class="txt2 hov1"> Sign up </a>
					</div>
				</form>
			</div>
		</div>
	</div>




	<!--===============================================================================================-->
	<!--===============================================================================================-->

	<!--===============================================================================================-->
	<!--===============================================================================================-->
	<!--===============================================================================================-->

</body>
</html>