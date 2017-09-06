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

    <title>Blood Bank</title>

 <!-- Bootstrap Core CSS -->

    <link href="/bloodbank/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/bloodbank/resources/css/agency.css" rel="stylesheet">
   
<link href="/bloodbank/resources/css/agency.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/bloodbank/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

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
                <a class="navbar-brand page-scroll" href="#page-top">Blood Bank</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#services">Services</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#portfolio">Login or register</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#about">About</a>
                    </li>
                    
                    <li>
                        <a class="page-scroll" href="#contact">Contact</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
    
    
     <c:if test="${not empty error}">
     	    <header>
			        <div class="container">
			            <div class="intro-text">
			                <div class="intro-lead-in">
			               Info: ${error}
			               </div>
							
			               
			                <a href="/bloodbank" class="page-scroll btn btn-xl">Back</a>
			            </div>
			        </div>
			    </header>
		
			           
			    
				</c:if>
 
		<c:if test="${empty error}">
			<!-- Header -->
			    <header>
			        <div class="container">
			            <div class="intro-text">
			                <div class="intro-lead-in">
			                Welcome to
			               </div>
							<br/><br/>
			                <div class="intro-heading">blood bank</div>
			                <a href="#services" class="page-scroll btn btn-xl">Join now</a>
			            </div>
			        </div>
			    </header>
		</c:if>

    

    <!-- Services Section -->
    <section id="services">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Services</h2>
                    <h3 class="section-subheading text-muted">Blood Bank contains:</h3>
                </div>
            </div>
            <div class="row text-center">
                <div class="col-md-4">
                    <span class="fa-stack fa-4x">
                        <i class="fa fa-circle fa-stack-2x text-primary"></i>
                        <i class="fa fa-shopping-cart fa-stack-1x fa-inverse"></i>
                    </span>
                    <h4 class="service-heading">Android App</h4>
                    <p class="text-muted">Mobile client for everyone</p>
                </div>
                <div class="col-md-4">
                    <span class="fa-stack fa-4x">
                        <i class="fa fa-circle fa-stack-2x text-primary"></i>
                        <i class="fa fa-laptop fa-stack-1x fa-inverse"></i>
                    </span>
                    <h4 class="service-heading">Web Client</h4>
                    <p class="text-muted">Easy-to-use site for donors and recipients</p>
                </div>
                <div class="col-md-4">
                    <span class="fa-stack fa-4x">
                        <i class="fa fa-circle fa-stack-2x text-primary"></i>
                        <i class="fa fa-lock fa-stack-1x fa-inverse"></i>
                    </span>
                    <h4 class="service-heading">IOT</h4>
                    <p class="text-muted">Smart location tracker with SOS-button</p>
                </div>
				 <a href="#portfolio" class="page-scroll btn btn-xl">Sign in</a>
            </div>
        </div>
    </section>

    <!-- Portfolio Grid Section -->
    <section id="portfolio" class="bg-light-gray">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Sign in to the system</h2>
                    <h3 class="section-subheading text-muted">Tell us who you are.</h3>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 col-sm-6 portfolio-item">
                    <a href="#donor" class="portfolio-link" data-toggle="modal">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content">
                                <i class="fa fa-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="/bloodbank/resources/img/portfolio/roundicons.png" class="img-responsive" alt="">
                    </a>
                    <div class="portfolio-caption">
                        <h4>Donor</h4>
                        <p class="text-muted">I want to donate my blood for free.</p>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6 portfolio-item">
                    <a href="#recipient" class="portfolio-link" data-toggle="modal">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content">
                                <i class="fa fa-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="/bloodbank/resources/img/portfolio/startup-framework.png" class="img-responsive" alt="">
                    </a>
                    <div class="portfolio-caption">
                        <h4>Recipient</h4>
                        <p class="text-muted">I need some blood.</p>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6 portfolio-item">
                    <a href="#portfolioModal3" class="portfolio-link" data-toggle="modal">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content">
                                <i class="fa fa-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="/bloodbank/resources/img/portfolio/treehouse.png" class="img-responsive" alt="">
                    </a>
                    <div class="portfolio-caption">
                        <h4>Administrator</h4>
                        <p class="text-muted">I have a special access permition.</p>
                    </div>
                </div>
               
              
                
            </div>
        </div>
    </section>

    <!-- About Section -->
    <section id="about">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Background</h2>
                   <p>After the start of military operations on the territory of Ukraine increased by half the number of cases where victims urgently need to make blood transfusions. According to the WHO, every person in Ukraine requires 12-15 ml of blood, but in fact only available 8-8.5 ml. Mass actions in blood donation centers can not provide the need for regular blood donation, as blood shelf life is limited: to 5 days for red blood cells, up to 42 hours for platelets up to 24 hours for leukocytes.
Donor blood should appear locally and can not be transported to other cities.
Independent search of donors with ads or acquaintances is often a difficult task, their time can cost a patient lives.
That is why there is a need to create a single database of donors who could donate blood and its components and recipients who need help. The system requires that at critical moments when the recipient (sick child, injured soldier ATO, etc.) immediately need blood, but this is not available, automatically pick up all possible donors near and willing to help.
                   </p>
                   <h2 class="section-heading">Business Opportunity</h2>
                <p>   Blood Bank - automated system for recruiting blood donors, whose main objective - to establish the quick contact "donor - recipient". The project also aims to coordinate donors and promoting free blood donation in Ukraine.
The information system should operate on a nonprofit basis and cover the whole territory of Ukraine. Data on the health of participants must be confidential. As envisaged use of health care institutions and individuals.
Currently known alternative operating mode bulletin boards where there is no possibility automated selection of donors and recipients. Also, these systems do not provide for monitoring of the health of donors and their promotion.
    </p>               
            </div>
        </div>
        </div>
    </section>

    

    

    <!-- Contact Section -->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Contact Us</h2>
                    <h3 class="section-subheading text-muted">Have any questions?</h3>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <form name="sentMessage" id="contactForm" novalidate>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Your Name *" id="name" required data-validation-required-message="Please enter your name.">
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="form-group">
                                    <input type="email" class="form-control" placeholder="Your Email *" id="email" required data-validation-required-message="Please enter your email address.">
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="form-group">
                                    <input type="tel" class="form-control" placeholder="Your Phone *" id="phone" required data-validation-required-message="Please enter your phone number.">
                                    <p class="help-block text-danger"></p>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <textarea class="form-control" placeholder="Your Message *" id="message" required data-validation-required-message="Please enter a message."></textarea>
                                    <p class="help-block text-danger"></p>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                            <div class="col-lg-12 text-center">
                                <div id="success"></div>
                                <button type="submit" class="btn btn-xl">Send Message</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
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

    <!-- Portfolio Modals -->
    <!-- Use the modals below to showcase details about your portfolio projects! -->

    <!-- Portfolio Modal 1 -->
    <div class="portfolio-modal modal fade" id="donor" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="close-modal" data-dismiss="modal">
                    <div class="lr">
                        <div class="rl">
                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8 col-lg-offset-2">
                            <div class="modal-body">
                                <!-- Project Details Go Here -->
                              
                        <div class="row">
                            <div class="col-md-6">
							<form action ="donor/login" method="post">
							<%@include file="loginForm.jsp" %>
						 </form>
						 
                            </div>
                            <div class="col-md-6">
							<!-- REGISTER FORM -->
							<form action="donor/register" method="post">
							<%@include file="registerForm.jsp" %>
							<%@include file="mapRegister.jsp" %>
							</form>
                            </div>
                           
                        </div>
                    
                                <button type="button" class="btn btn-primary" data-dismiss="modal"><i class="fa fa-times"></i> Close Project</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Portfolio Modal 2 -->
    <div class="portfolio-modal modal fade" id="recipient" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="close-modal" data-dismiss="modal">
                    <div class="lr">
                        <div class="rl">
                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="row">
                        <div class="col-md-6">
							<form action ="recipient/login" method="post">
							<%@include file="loginForm.jsp" %>
						 </form>
						 
                            </div>
                            <div class="col-md-6">
							<!-- REGISTER FORM -->
							<form action="recipient/register" method="post">
							<%@include file="registerForm.jsp" %>
							</form>
                            </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Portfolio Modal 3 -->
    <div class="portfolio-modal modal fade" id="portfolioModal3" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="close-modal" data-dismiss="modal">
                    <div class="lr">
                        <div class="rl">
                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="row">
                        <div class="col-md-6">
							
							<%@include file="adminForm.jsp" %>
						
                            </div>
                            
                    </div>
                </div>
            </div>
        </div>
    </div>

   

    <!-- jQuery -->
    <script src="/bloodbank/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/bloodbank/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js" integrity="sha384-mE6eXfrb8jxl0rzJDBRanYqgBxtJ6Unn4/1F7q4xRRyIw7Vdg9jP4ycT7x1iVsgb" crossorigin="anonymous"></script>

    <!-- Contact Form JavaScript -->
    <script src="/bloodbank/resources/js/jqBootstrapValidation.js"></script>
    <script src="/bloodbank/resources/js/contact_me.js"></script>

    <!-- Theme JavaScript -->
    <script src="/bloodbank/resources/js/agency.min.js"></script>
	
   

 
</body>
</html>