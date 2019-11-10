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
			<td colspan="2">
				<label style="color: red; font-weight: bolder;">${msg}</label>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<h3><br><label style=" font-weight: bolder;">Unlock Account</label></h3>
			</td>
		</tr>
		<tr>
			<td>&nbsp;Email&nbsp;</td>
			<td><label>:&nbsp;${email}</label></td>
		</tr>
		<form:form action="unlockUser?userEmail=${email}"
			modelAttribute="userRegdCmd">
			<tr>
				<td>&nbsp;Temp. Password&nbsp;</td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td>&nbsp;New Password&nbsp;</td>
				<td><form:input path="newPassword" /></td>
			</tr>
			<tr>
				<td>&nbsp;Confirm Password&nbsp;</td>
				<td><form:input path="confirmPassword" /></td>
			</tr>
			<tr>
				<td colspan="2"><button type="submit"
						style="background-color: #00BFFF; color: white;">Unlock
						account</button>
					<button type="reset"
						style="background-color: #FF4500; color: white;">Reset</button></td>
			</tr>
		</form:form>
	</table>
</body>
</html>