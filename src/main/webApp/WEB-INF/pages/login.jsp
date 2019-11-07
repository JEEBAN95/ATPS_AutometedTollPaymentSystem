<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
	<h3>Owner Details</h3>
	${errorMsgs}
	<table>
		<form:form>
			<tr>
				<td>&nbsp;User Name&nbsp;</td>
				<td><form:input path="uname" /></td>
				<td><form:errors path="uname" /></td>
			</tr>
			<tr>
				<td>&nbsp;Password	&nbsp;</td>
				<td><form:input path="pwd" /></td>
				<td><form:errors path="pwd" /></td>
			</tr>
		</form:form>
	</table>
</body>
</html>