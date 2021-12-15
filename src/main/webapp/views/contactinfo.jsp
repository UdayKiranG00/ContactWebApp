<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact App</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"/>
</head>
<body>
<div class="container-fluid" align='center'>
	<h3>Save Your Contact</h3>
	<font color='green'>${success }</font>
	<font color='red'>${error }</font>
	<form:form action="saveContact?contactId=${contact.contactId}" modelAttribute="contact" method="POST">
		<table>
			<tr>
				<td>Contact Name:</td>
				<td align='center'><form:input path="contactName"></form:input></td>
			</tr>
			<tr>
				<td>Contact Email:</td>
				<td align='center'><form:input path="contactEmail"></form:input></td>
			</tr>
			<tr>
				<td>Contact Number:</td>
				<td align='center'><form:input  path="contactNumber"></form:input></td>
			</tr>
			<tr>
				<td align="right"><input type="submit" class="btn btn-primary" value="save"></td>
				<td align="center"><input type="reset" class="btn btn-warning" value="cancel"></td>
			</tr>
		</table>
	</form:form>
	<a href="viewContacts" >View All Contacts</a>
	</div>
</body>
</html>