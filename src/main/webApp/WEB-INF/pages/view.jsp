<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${userEmail}<br><br>
	${msg}<br><br>
	${warnning}<br><br>
	<label>&nbsp;Password&nbsp;:&nbsp;${password}</label><br><br>
	<a href="user-acc-unlock?uid=${userId}">${url}</a>
</body>
</html>