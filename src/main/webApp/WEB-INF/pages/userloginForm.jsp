<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table style="height: 100%; width: 100%; text-align: center;"
		border="1">
		<tr>
			<td style="width: 60%;">image</td>

			<td style="text-align: center;">
				<table
					style="height: 100%; width: 100%; text-align: left; padding-top: 50px">
					<tr>
						<td colspan="2" style="text-align: left;"><label
							style="color: cyan; font-weight: bolder;">${loginMsg}</label></td>
					</tr>
					<tr>
						<td style="text-align: center;" colspan="2"><h3>SIGN IN</h3>
							<br></td>
					</tr>
					<form:form action="signin" modelAttribute="userRegdCmd">
						<tr>
							<td style="text-align: right;">&nbsp;User Name&nbsp;</td>
							<td><form:input path="email" placeholder="email adderss" /></td>
						</tr>
						<tr>
							<td style="text-align: right;"><br>&nbsp;Password
								&nbsp;</td>
							<td><br>
							<form:input path="password" placeholder="password"
									type="password" /></td>
						</tr>
						<tr>
							<td colspan="2" style="text-align: center;"><br>
								<button type="submit"
									style="background-color: #00BFFF; color: white;">Sign
									In</button></td>
						</tr>
						<tr>
							<td><br> <a href="forgotpassword">forgot password ?</a></td>
							<td style="text-align: right;"><br> <a href="signUp">account
									not created ?</a></td>
						</tr>
					</form:form>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>