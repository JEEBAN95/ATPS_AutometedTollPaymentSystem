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
<h3 style="color: red">${msg}</h3>
	<table>
		<tr>
			<td colspan="2"><h3>Enter Your Email</h3></td>
		</tr>
		<form:form action="resetPassword" modelAttribute="frgtPwd">
			<tr>
				<td>&nbsp;Email&nbsp;:</td>
				<td><form:input path="email" />
			<tr>
				<td colspan="2" ><br><button style="color: white; background-color:cyan;" type="submit">Submit</button></td>
			</tr>
		</form:form>
	</table>
	<label style="color: blue; font-weight: bold;">${success}</label>
</body>
</html>