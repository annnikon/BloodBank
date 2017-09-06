<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Web client for blood bank">
    <meta name="author" content="Anna Nikonova">

    <title>Donor</title>

 <!-- Bootstrap Core CSS -->
   <link href="/bloodbank/resources/css/calendar.css" rel="stylesheet">
    <link href="/bloodbank/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/bloodbank/resources/css/agency.css" rel="stylesheet">
<link href="/bloodbank/resources/css/agency.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/bloodbank/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

          <!-- jQuery -->
    <script src="/bloodbank/resources/vendor/jquery/jquery.min.js"></script>
    <style>
    #mapProfile {
    width:100%;
	height:450px;
    }
    table {
    padding: 50px;}
    </style>

<title>Administrator panel</title>
</head>
<body id="page-top" class="index">
<div class="container">${error}</div>
<div class="container">
Admin: ${admin.getLogin()} <hr>
Location: x: ${admin.getX()} y: ${admin.getY()}
<hr>

   <h1 class="section-heading">All recipients:</h1>
           <table class="table-hover" width="80%">
           <tr class="info"><th>Name</th><th>Blood </th> <th>Phone</th> <th>Contact</th> <th>Manage</th></tr>
           <c:forEach var="rec" items="${recipients}">
           <tr>
    <td>${rec.getName()}</td> 
   <td>${rec.getBloodInfo()}</td> 
    <td>${rec.getPhone()}</td> 
   <td><a href='contact/${rec.getLogin()}' id="${rec.getLogin()}">Write</a></td> 
     <td><a href='delete/${rec.getLogin()}' id="${rec.getLogin()}">Delete</a></td> 
   </tr>
    
</c:forEach>
</table>

<h1 class="section-heading">All donors:</h1>
           <table class="table-hover" width="80%">
           <tr class="info"><th>Name</th><th>Blood </th> <th>Phone</th> <th>Contact</th> <th>Manage</th></tr>
           <c:forEach var="rec" items="${donors}">
           <tr>
    <td>${rec.getName()}</td> 
   <td>${rec.getBloodInfo()}</td> 
    <td>${rec.getPhone()}</td> 
    <td><a href='contact/${rec.getLogin()}' id="${rec.getLogin()}">Write</a></td> 
     <td><a href='delete/${rec.getLogin()}' id="${rec.getLogin()}">Delete</a></td> 
   </tr>
    
</c:forEach>
</table>

</div>

</body>
</html>