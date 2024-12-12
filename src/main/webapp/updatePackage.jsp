<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Package</title>
<link rel="stylesheet" href="IndexPackageStyle.css">
</head>
<body>
<header>
        <div id="menu-bar" class="fa fa-bars"></div>
        <a href="#" class="logo"><img class="capal_logo" src="img/CAPAL LOGO.png" alt="Logo"></a>
        <nav class="navbar">
            <a href="index.html">Home</a>
            <a href="IndexAppointment.html">Appointment</a>
            <a href="IndexPet.html">Pet</a>
            <a href="IndexProfile.html">Profile</a>
        </nav>
        <div class="icons">
            <a href="cart.html"><i class="fa fa-shopping-cart"></i></a>
            <a href="#"><i class="fa fa-user"></i></a>
        </div>
    </header>
<div class="form-container">
	<h1>Update Package</h1>
	<form action="UpdatePackageController" method="post" onsubmit="return validateForm()">
		<input type="hidden" name="id" value="${pkg.packageId}">
		<div class="form-group">
			<label for="packageName">Package Name:</label>
			<input type="text" id="packageName" name="packageName" value="${pkg.packageName}" required>
		</div>
		<div class="form-group">
			<label for="packagePrice">Package Price:</label>
			<input type="number" id="packagePrice" name="packagePrice" value="${pkg.packagePrice}" required>
		</div>
		<button type="submit" class="btn btn-primary">Update</button>
	</form>
</div>


<script>
function validateForm() {
    var packageName = document.getElementById("packageName").value;
    var packagePrice = document.getElementById("packagePrice").value;

    if (packageName == "" || packagePrice == "") {
        alert("Please fill in all fields.");
        return false; 
    }

    // You can add more specific validation here if needed (e.g., for price format)

    return true; 
}
</script>
</body>
</html>