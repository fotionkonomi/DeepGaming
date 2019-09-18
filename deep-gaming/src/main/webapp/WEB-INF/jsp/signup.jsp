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
<link type="text/css" rel="stylesheet"
	href="<c:url value="/css/bootstrap.min.css"/>" />

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
							<center>
								<form:errors path="username"
									style="font-family:monospace; color:red;" />
							</center>
							<span class="focus-input100-1"></span> <span
								class="focus-input100-2"></span>
						</div>

						<div class="wrap-input100 validate-input"
							data-validate="Valid email is required: ex@abc.xyz">
							<form:input class="input100" path="email" type="email"
								name="email" placeholder="Email" />
							<center>
								<form:errors path="email"
									style="font-family:monospace; color:red;" />
							</center>
							<span class="focus-input100-1"></span> <span
								class="focus-input100-2"></span>
						</div>


						<div class="wrap-input100 validate-input"
							data-validate="Valid email is required: ex@abc.xyz">

							<form:input type="text" id="dateOfBirth"
								placeholder="Date Of Birth" path="date"
								class="form-control input100 textbox-n"
								onfocus="(this.type='date') " />
							<span class="focus-input100-1"></span> <span
								class="focus-input100-2"></span>
						</div>

						<div class="wrap-input100 rs1 validate-input"
							data-validate="Password is required">
							<form:input class="input100" path="password" type="password"
								name="pass" placeholder="Password" />
							<span class="focus-input100-1"></span> <span
								class="focus-input100-2"></span>
						</div>
						<br />
						<hr>
						<center>
							<h3 style="font-family: monospace;">Your Computer</h3>
							<p>*You can leave these fields empty</p>
						</center>
						<div class="form-group">

							<div class="col-lg-12">
								<form:select path="cpuOfHisComputer" class="form-control">
									<form:option value="">
										<spring:message code="signup.form.cpu.default" />
									</form:option>
									<form:options items="${cpus}" />
								</form:select>
								<form:errors path="cpuOfHisComputer" cssClass="text-danger" />

							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-12">
								<form:select path="gpuOfHisComputer" class="form-control">
									<form:option value="">
										<spring:message code="signup.form.gpu.default" />
									</form:option>
									<form:options items="${gpus}" />
								</form:select>
								<form:errors path="gpuOfHisComputer" cssClass="text-danger" />

							</div>

						</div>

						<div class="wrap-input100 validate-input">
							<form:input class="input100" path="ramSizeOfHisComputer"
								type="number" step="0.1" min="0" name="lastName"
								placeholder="Ram size of your computer in GB" />
							<span class="focus-input100-1"></span> <span
								class="focus-input100-2"></span>
						</div>


						<div class="container-login100-form-btn m-t-20">
							<input type="submit" value="Sign Up" class="login100-form-btn">
						</div>
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