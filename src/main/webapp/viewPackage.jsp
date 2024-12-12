<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Package View</title>
</head>
<body>
	<a href="indexPackage.jsp">Home</a> |
	<a href="indexPackage.jsp">Add Shawl</a> |
	<a href="listPackage.jsp">Shawl List</a><br><br>
	<h1>Package Info</h1>
	packageId: <c:out value="${packageId}"/> <br>
	packageName: <c:out value="${packageName}"/> <br>
	packagePrice: <c:out value="${packagePrice}"/> <br>
</body>
</html>