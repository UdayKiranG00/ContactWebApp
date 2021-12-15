<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contacts View</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"/>

<script>
function confirmDelete(){
	return confirm("Are You Sure Want To Delete");
}
</script>
</head>
<body>
<div class="container-sm">
<h3 align="center"> All Contacts</h3>
	<h6 align="right"> <a href='contact' class="btn btn-success">+ Add New Contact</a></h6>
	<table class="table">
		<thead>
			<tr align="center">
				<td scope="col">Name</td>
				<td scope="col">Email</td>
				<td scope="col">Number</td>
				<td scope="col">Action</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contacts }" var="contact">
				<tr align="center">
					<td>${contact.contactName }</td>
					<td>${contact.contactEmail }</td>
					<td>${contact.contactNumber }</td>
					<td><a href="edit?cid=${contact.contactId}" class="btn btn-warning">Edit</a>&nbsp&nbsp&nbsp&nbsp<a class="btn btn-danger"href="delete?cid=${contact.contactId}" onclick="return confirmDelete()">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>