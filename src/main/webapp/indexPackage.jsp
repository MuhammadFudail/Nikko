<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Package Page</title>
<link rel="stylesheet" href="IndexPackageStyle.css">
</head>
<body>
	<header>
        <div id="menu-bar" class="fa fa-bars"></div>
        <a href="#" class="logo"><img class="capal_logo" src="img/CAPAL LOGO.png" alt="Logo"></a>
        <nav class="navbar">
            <a href="#home">Home</a>
            <a href="IndexAppointment.html">Appointment</a>
            <a href="IndexPet.html">Pet</a>
            <a href="IndexProfile.html">Profile</a>
        </nav>
        <div class="icons">
            <a href="cart.html"><i class="fa fa-shopping-cart"></i></a>
            <a href="#"><i class="fa fa-user"></i></a>
        </div>
    </header>
    
     <div class="container">
        <h1>Add New Package</h1>
        <form action="AddPackageController" method="post">
            
            <label for="packageName">Enter Package Name:</label>
            <input type="text" id="packageName" name="packageName" placeholder="Enter Package Name" required>
            <label for="price">Package Price (RM):</label>
            <input type="number" id="packagePrice" name="packagePrice" placeholder="Enter Package Price">
			<button type="submit" class="btn">Submit</button>
        </form>
    </div>
     <footer class="footer">
        <div class="main_container footer_container">
            <div class="footer_item">
                <a href="#" class="footer_logo"><img class="capal_logo_white" src="img/CAPAL LOGO WHITE.png" alt="Logo"></a>
                <div class="footer_p">Where Comfort Meets Confidence.</div>
            </div>
            <div class="footer_item">
                <h3 class="footer_item_title">Reach Us</h3>
                <ul class="footer_list">
                    <a href="#"><li class="li footer_list_item">Jasin, Melaka</li></a>
                    <a href="mailto:abc@example.com"><li class="li footer_list_item">nikkospace@gmail.com</li></a>
                    <a href="tel:+601923445265"><li class="li footer_list_item">+6019-2344 5265</li></a>
                    <a href="tel:+601762500959"><li class="li footer_list_item">+6017 6250 0959</li></a>
                </ul>
            </div>
            <div class="footer_item">
                <h3 class="footer_item_title">Support</h3>
                <ul class="footer_list">
                    <a href="product.html"><li class="li footer_list_item">Our Store</li></a>
                    <a href="login.html"><li class="li footer_list_item">Login / Register</li></a>
                    <a href="cart.html"><li class="li footer_list_item">Appointment</li></a>
                    <a href="product.html"><li class="li footer_list_item">Pet</li></a>
                </ul>
            </div>
            <div class="footer_item">
                <h3 class="footer_item_title">Help</h3>
                <ul class="footer_list">
                    <a href="#"><li class="li footer_list_item">Privacy Policy</li></a>
                    <a href="#"><li class="li footer_list_item">Terms of Use</li></a>
                    <a href="#"><li class="li footer_list_item">FAQs</li></a>
                    <a href="#"><li class="li footer_list_item">Contact</li></a>
                </ul>
            </div>
        </div>
        <div class="footer_bottom">
            <div class="footer_bottom_container">
                <p class="footer_copy">Copyright Nikko Space 2024. All rights reserved.</p>
            </div>
        </div>
    </footer>
</body>  
</html>