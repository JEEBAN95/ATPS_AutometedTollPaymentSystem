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
	<table>
		<tr>
			<td colspan="2" style="text-align: left;"><label
				style="color: cyan; font-weight: bolder;">${msg}</label></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: left;"><label
				style="color: red; font-weight: bolder;">${email}</label></td>
		</tr>
		<tr>
			<td style="text-align: center;" colspan="2"><h3>SIGN IN</h3></td>
		</tr>
		<form:form action="signin" modelAttribute="userRegdCmd">
			<tr>
				<td style="text-align: right;">&nbsp;User Name&nbsp;</td>
				<td><form:input path="email" placeholder="email adderss" /></td>
				<td><form:errors path="email" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">&nbsp;Password &nbsp;</td>
				<td><form:input path="password" placeholder="password"
						type="password" /></td>
				<td><form:errors path="password" /></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;"><button
						type="submit" style="background-color: #00BFFF; color: white;">Sign
						In</button></td>
			</tr>
			<tr>
				<td style="height: 100px"><a href="#">forgot password ?</a></td>
				<td style="text-align: right;"><a href="signUp">account not
						created ?</a></td>
			</tr>
		</form:form>
	</table>
</body>
</html>