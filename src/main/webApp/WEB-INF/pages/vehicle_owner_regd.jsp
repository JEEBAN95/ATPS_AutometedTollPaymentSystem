<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script>
	$(function() {
		$('form[id="vhclOnrReg"]').validate({
			rules : {
				first_name : 'required',
			},
			messages : {
				first_name : 'Please enter username',
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>
</head>

<body>
	<h3>Owner Details</h3>
	${errorMsgs}
	<table>
		<form:form action="vhclOnrRegister"
			modelAttribute="vOwnerDtlsModelCmd" id="vhclOnrReg">
			<tr>
				<td>&nbsp;First_name&nbsp;</td>
				<td><form:input path="first_name" /></td>
				<td><form:errors path="first_name" /></td>
			</tr>
			<tr>
				<td>&nbsp;Last_name&nbsp;</td>
				<td><form:input path="last_name" /></td>
				<td><form:errors path="last_name" /></td>
			</tr>
			<tr>
				<td>&nbsp;Gender&nbsp;</td>
				<td>Male<form:radiobutton path="gender" value="Male" />
					&nbsp;Female<form:radiobutton path="gender" value="Female" /></td>
				<td><form:errors path="gender" /></td>
			</tr>
			<tr>
				<td>&nbsp;Email&nbsp;</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" /></td>
			</tr>
			<tr>
				<td>&nbsp;Ph_no&nbsp;</td>
				<td><form:input path="phno" /></td>
				<td><form:errors path="phno" /></td>
			</tr>
			<tr>
				<td>&nbsp;Dob&nbsp;</td>
				<td><form:input type="date" path="dob" /></td>
				<td><form:errors path="dob" /></td>
			</tr>
			<tr>
				<td>&nbsp;SSN&nbsp;</td>
				<td><form:input path="ssn" /></td>
				<td><form:errors path="ssn" /></td>
			</tr>
			<tr>
				<td colspan="2"><button type="submit"
						style="background-color: #00BFFF; color: white;">Next</button>
					<button type="reset"
						style="background-color: #FF4500; color: white;">Reset</button></td>
			</tr>
		</form:form>
	</table>
</body>
</html>