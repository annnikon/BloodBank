<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
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
</head>
 <body id="page-top" class="index">
      <!-- Navigation -->
    <nav id="mainNav" class="navbar navbar-default navbar-custom navbar-fixed-top">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand page-scroll" href="#page-top">My Profile</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#edit">Edit</a>
                    </li>
                  
                    <li>
                        <a class="page-scroll" href="#donors">Find donors</a>
                    </li>
                    
                      <li>
                        <a class="page-scroll" href="#rules">Rules</a>
                    </li>
                     <li>
                        <a class="page-scroll" href="#events">My events</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="logout">Log out</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
 
    <!-- Services Section -->
    <section id="edit"> 
   
  <div class="container">
            <div class="row" id="first" onload="initMap2(${user.getX()},${user.getY()})">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Your profile</h2>
                    <i class="fa fa-user" aria-hidden="true"></i>
                    Name: ${user.getName()}
                    <hr>
                    Login: ${user.getLogin()}
                    <hr>
                    Phone: ${user.getPhone()}
                    <hr>
                     Blood group: ${user.getBloodInfo()}
                     <hr>
                      Your location:
                     <input type="text" id="x" value="${user.getX()}"/>
                        <input type="text" id="y" value="${user.getY()}"/>
                        <button class="page-scroll btn btn-xl" id="showMap">Show on map</button>
                    
                          
                 
                   <button class="page-scroll btn btn-xl" id="link1">Edit</button> 
                </div>
            </div>
            
             <div id="mapProfile"> </div>             
            
            <div class="row" id="second">
   
    		<h1 class="title">Edit</h1>
   			 <form action="edit" method="post"><%@include file="editForm.jsp" %></form>
     		<hr>
                   <button class="page-scroll btn btn-xl" id="link2">Close editor</button> 
    
   
  			</div>
             
        			 
            </div>
       
    </section>

    <!-- Portfolio Grid Section -->
    <section id="recipients" class="bg-light-gray">
        
        
           <h1>Your recipients:</h1>
           <table class="table-hover" width="80%">
           <tr class="info"><th>Name</th><th>Blood </th> <th>Phone</th> <th>Contact</th></tr>
           <c:forEach var="rec" items="${donors}">
           <tr>
    <td>${rec.getName()}</td> 
   <td>${rec.getBloodInfo()}</td> 
    <td>${rec.getPhone()}</td> 
    <td><a href='contact/${rec.getLogin()}' id="${rec.getLogin()}">Write</a></td> 
   </tr>
    
</c:forEach>
</table>
           
           
       
    </section>

    <!-- About Section -->
    <section id="rules">
        <div class="container">
           
            <div class="row">
                <div class="col-lg-12">
                    <ul class="timeline">
                        <li>
                            <div class="timeline-image">
                                <img class="img-circle img-responsive" src="/bloodbank/resources/img/about/1.jpg" alt="">
                            </div>
                            <div class="timeline-panel">
                                <div class="timeline-heading">
                                    <h4>Is donation free?</h4>
                                    
                                </div>
                                <div class="timeline-body">
                                    <p class="text-muted">Absolutely. All the donors are informed about it. You will not pay for blood.</p>
                                </div>
                            </div>
                        </li>
                        <li class="timeline-inverted">
                            <div class="timeline-image">
                                <img class="img-circle img-responsive" src="/bloodbank/resources/img/about/2.jpg" alt="">
                            </div>
                            <div class="timeline-panel">
                                <div class="timeline-heading">
                                    <h4>Is donation secure?</h4>
                                    <h4 class="subheading">How can I check it?</h4>
                                </div>
                                <div class="timeline-body">
                                    <p class="text-muted">All your donors will be tested for heath before the procedure.</p>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="timeline-image">
                                <img class="img-circle img-responsive" src="/bloodbank/resources/img/about/3.jpg" alt="">
                            </div>
                            <div class="timeline-panel">
                                <div class="timeline-heading">
                                    <h4>How the donors list is formed?</h4>
                                
                                </div>
                                <div class="timeline-body">
                                    <p class="text-muted">Donors are selected required to your blood and location. </p>
                                </div>
                            </div>
                        </li>
                       
                    </ul>
                </div>
            </div>
        </div>
    </section>

    <!-- Team Section -->
    <section id="events" class="bg-light-gray">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Your schedule</h2>
                    <h3 class="section-subheading text-muted">Plan your events here.</h3>
                </div>
            </div>
            <c:if test="${not empty event}">
			    <h4 class="section-subheading text-muted">History:</h4>
			           <table class="table-hover" width="80%">
			           <tr class="info"><th>Donor</th><th>Donor's blood </th><th>Recipient</th><th>Recipient's blood </th> <th>Date</th> <th>Status</th></tr>
			          
			           <tr>
			           <td>${event.getDonor().getName()}</td> 
			   <td>${event.getDonor().getBloodInfo()}</td> 
			    <td>${event.getRecipient().getName()}</td> 
			   <td>${event.getRecipient().getBloodInfo()}</td> 
			    <td>${event.getDate().toGMTString()}</td> 
			    <td>${event.getStatus()}</td> 
			   </tr>
			    
			</table>
			
</c:if>
<c:if test="${empty event}">
<h2>You haven't recent events yet.</h2>
</c:if> 

<hr>
  <h1>The nearest dates of possible blood receptions for you:</h1>
           <table class="table-hover" width="80%">
           <tr class="info"><th>Date</th> </tr>
           <c:forEach var="rec" items="${dates}">
           <tr>
    <td>${rec.toGMTString()}</td> 
  
    
   </tr>
    
</c:forEach>
</table>
 <h4 class="section-subheading text-muted">Your calendar:</h4>
           
              <%@include file="calendar.jsp" %>
              
         </div>
         
      
    </section>

  


    <footer>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <span class="copyright">NURE | Anna Nikonova | Kharkiv, 2017</span>
                </div>
               
                
            </div>
        </div>
    </footer>



  

    <!-- Bootstrap Core JavaScript -->
    <script src="/bloodbank/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js" integrity="sha384-mE6eXfrb8jxl0rzJDBRanYqgBxtJ6Unn4/1F7q4xRRyIw7Vdg9jP4ycT7x1iVsgb" crossorigin="anonymous"></script>

    <!-- Contact Form JavaScript -->
    <script src="/bloodbank/resources/js/jqBootstrapValidation.js"></script>
    <script src="/bloodbank/resources/js/contact_me.js"></script>

    <!-- Theme JavaScript -->
    <script src="/bloodbank/resources/js/agency.min.js"></script>
    
        <script>
        $(function () {
        			
            $("#second").hide();
                        
            $("#link1, #link2").bind("click", function () {

              $("#first, #second").hide();        
                
              if ($(this).attr("id") == "link1")
              {
                $("#second").show();
                             
              }
              else 
              { 
                $("#first").show();
              
              }
            });

        });
        </script>    
	<script>     
    
    var map2;
    var marker;  
   
    var newMarker;
    
    document.getElementById("showMap").onclick = function(){
        var x = parseFloat(document.getElementById("x").value);
       
        var y = parseFloat(document.getElementById("y").value);
        
        initMap2(x,y);
        
    }
    
    document.getElementById("edit").onclick = function(){
        var x = parseFloat(document.getElementById("x").value);
           
        var y = parseFloat(document.getElementById("y").value);
       
        initMap3(x,y);
        
    }

    
    function initMap2(x,y) {
    	
        var chicago = new google.maps.LatLng(x,y);
        map2 = new google.maps.Map(document.getElementById('mapProfile'), {
          center: chicago,
          zoom: 9
        });
     
        
        marker = new google.maps.Marker({
         	    map: map2,
         	    title: 'You are here',
         	    position: chicago
         	  });
    }
    
    
    function initMap3(x,y) {
    	var chicago = new google.maps.LatLng(x,y);
        newMarker = new google.maps.Marker({
         	    map: map2,
         	    draggable: true,
         	    animation: google.maps.Animation.DROP,
         	    position: chicago
         	  });
         	  
    
    
    google.maps.event.addListener(newMarker, "click", function (event) {
          
        document.getElementById('xCoord').value=event.latLng.lat();      
        document.getElementById('yCoord').value=event.latLng.lng();
      
      });
    marker.addListener('click', toggleBounce);
    }
    
    function toggleBounce() {
        if (marker.getAnimation() !== null) {
          marker.setAnimation(null);
        } else {
         
          
          marker.setAnimation(google.maps.Animation.BOUNCE);
        }
      }
     
     
    
 
 
</script>
   

    
      
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCqdjZ5cYzvvUOBzx9lqPjiksR0ZTC_DBM&callback=initMap2">
    </script>
   

 
</body>
</html>