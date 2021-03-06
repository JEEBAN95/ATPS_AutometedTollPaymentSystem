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
			<td colspan="2"><label style="color: red; font-weight: bolder;">${msg}</label><br>
			<a href="login"><button type="button" style="background-color: blue; color: white">Login</button></a>
			</td>
		</tr>
		<tr>
			<td>
				<h3>User Details</h3>
			</td>
		</tr>
		<form:form action="register" modelAttribute="userRegdCmd">
			<tr>
				<td>&nbsp;First Name&nbsp;</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>&nbsp;Last Name&nbsp;</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>&nbsp;Email&nbsp;</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>&nbsp;Phone no&nbsp;</td>
				<td><form:input path="phoneNum" /></td>
			</tr>
			<tr>
				<td>&nbsp;Dob&nbsp;</td>
				<td><form:input type="date" path="dob" /></td>
			</tr>
			<tr>
				<td>&nbsp;Gender&nbsp;</td>
				<td>Male<form:radiobutton path="gender" value="Male" />
					&nbsp;Female<form:radiobutton path="gender" value="Female" /></td>
				<td><form:errors path="gender" /></td>
			</tr>
			<tr>
				<td colspan="2"><button type="submit"
						style="background-color: #00BFFF; color: white;">Sign up</button>
					<button type="reset"
						style="background-color: #FF4500; color: white;">Reset</button></td>
			</tr>
			<table>
				<tr>
					<td colspan="2"><label
						style="color: blue; font-weight: bolder;">${success}</label></td>
				</tr>
				<tr>
					<td colspan="2"><label
						style="color: green; font-weight: bolder;">${emailNotification}</label>
					</td>
				</tr>
			</table>
		</form:form>
	</table>
</body>
</html>