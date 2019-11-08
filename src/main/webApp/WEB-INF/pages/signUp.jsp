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
			<td>
				<h3>User Details</h3>
			</td>
		</tr>
		<form:form action="register" modelAttribute="userRegdCmd">
			<tr>
				<td>&nbsp;First_name&nbsp;</td>
				<td><form:input path="firstName" /></td>
				<td><form:errors path="firstName" /></td>
			</tr>
			<tr>
				<td>&nbsp;Last_name&nbsp;</td>
				<td><form:input path="lastName" /></td>
				<td><form:errors path="lastName" /></td>
			</tr>
			<tr>
				<td>&nbsp;Email&nbsp;</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" /></td>
			</tr>
			<tr>
				<td>&nbsp;Ph_no&nbsp;</td>
				<td><form:input path="phoneNum" /></td>
				<td><form:errors path="phoneNum" /></td>
			</tr>
			<tr>
				<td>&nbsp;Dob&nbsp;</td>
				<td><form:input type="date" path="dob" /></td>
				<td><form:errors path="dob" /></td>
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
		</form:form>
	</table>
</body>
</html>