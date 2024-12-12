<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@ page import="pack.connection.ConnectionManager" %>
<%@ page import="java.sql.*" %>
<%@ page import="pack.model.Package" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Package Page</title>
<link rel="stylesheet" href="IndexPackageStyle.css">
</head>
<body>

	  <%
        List<Package> packages = new ArrayList<Package>();

        try {
            Connection con = ConnectionManager.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM packages ORDER BY packageid";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Package p = new Package(
                    rs.getInt("packageId"),
                    rs.getString("packageName"),
                    rs.getDouble("packagePrice")
                );
                packages.add(p);
            }

            con.close(); 

        } catch(Exception e) {
            e.printStackTrace(); 
        }

        request.setAttribute("packages", packages); 
    %>

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
	<h1>Package List</h1>
	<table border="1" >
		<tr>
			<th>Package Id</th>
			<th>Package Name</th>
			<th>Package Price</th>
			<th colspan="3">Action</th>
		</tr>
		<%


  for (Package pkg : packages) { 
%>
    <tr>
        <td><%= pkg.getpackageId() %></td>
        <td><%= pkg.getpackageName() %></td>
        <td><%= pkg.getpackagePrice() %></td>
        <td><a class="btn btn-info" href="ViewPackageController?packageId=<%= pkg.getpackageId() %>">View</a></td>
        <td><a class="btn btn-primary" href="UpdatePackageController?id=<%= pkg.getpackageId() %>">Update</a></td>
        <td><button class=deleteBtn id="<%= pkg.getpackageId() %>" onclick="confirmation(this.id)">Delete</button></td> 
    </tr>
<% 
  } 
%> 
	</table>
	<div class="addbtn" >
	<a href="indexPackage.jsp" class="addPackageBtn">Add New Package</a>
	</div>
		
	</div>
	<script>
	function confirmation(packageId){					  		 
		  console.log(packageId);
		  var r = confirm("Are you sure you want to delete?");
		  if (r == true) {				 		  
			  location.href = 'DeletePackageController?id=' + packageId;
			  alert("Selected package successfully deleted");			
		  } else {				  
		      return false;	
		  }
	}
	</script>
</body>
</html>