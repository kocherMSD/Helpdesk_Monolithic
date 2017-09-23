<%@ page language="java" import="java.util.*" %> 
<%@ page language="java" import="java.io.*" %> 
<%@ page import = "java.util.ResourceBundle" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Help Desk</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfont-->
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<script src="js/jquery.easydropdown.js"></script>
    <script src="js/scripts.js"></script>
<!--Animation-->
<script src="js/wow.min.js"></script>
<link href="css/animate.css" rel='stylesheet' type='text/css' />
<script>
	new WOW().init();
</script>

	<script>
            function jsfunction(){
             var select = document.getElementById("profile"); 
			 var selectedString = select.options[select.selectedIndex].value;
              if(selectedString==0)
                 window.open ('profile','_self',false)
				 else
				 window.open ('logout','_self',false)
			 }
</script>

</head>
<body>
<div class="header">
		   <div class="col-sm-10 header-left">
					 <div class="logo">
						<a href="index.html"><img src="images/logo.png" alt=""/></a>
					 </div>
					 <div class="menu">
						  <a class="toggleMenu" href="#"><img src="images/nav.png" alt="" /></a>
						    <ul class="nav" id="nav">
						    
						     <%
                         String user = (String)request.getAttribute("user");
                        if(session.getAttribute("ACCESS_LEVEL").equals("4"))
                                                                                {

                                                                        %>
						  
							<li class="active"><a href="productcatalogueAdmin">Product Catalogue Admin</a></li>
							  <%
                                                                }
                                                          %>
                                <li class="active"><a href="productcatalogue">Product Catalogue</a></li>
                                <li><a href="createCaseOr">Create an Incident</a></li>
                                <li><a href="notesAll">Message Board</a></li>
                                <li><a href="viewAllCase">View Incident</a></li>				
								<li><a href="appointment">Appointment</a></li>
								<li><a href="takeAppointment">Take Appointment</a></li>
								<li><a href="search">Search</a></li>
								

								<div class="clearfix"></div>
							</ul>
							<script type="text/javascript" src="js/responsive-nav.js"></script>
				    </div>	
				     <!-- start search-->
				      <!--<div class="search-box">
							<div id="sb-search" class="sb-search">
								<form>
									<input class="sb-search-input" placeholder="Enter your search term..." type="search" name="search" id="search">
									<input class="sb-search-submit" type="submit" value="">
									<span class="sb-icon-search"> </span>
								</form>
							</div>
						</div>-->
						<!----search-scripts---->
						<script src="js/classie.js"></script>
						<script src="js/uisearch.js"></script>
						<script>
							new UISearch( document.getElementById( 'sb-search' ) );
						</script>
						<!----//search-scripts---->						
	    		    <div class="clearfix"></div>
	    	    </div>
	            <div class="col-sm-2 header_right">
	    		      <!--<div id="loginContainer"><a href="#" id="loginButton"><img src="images/login.png"><span>User Name</span></a>
						    <div id="loginBox">                
						        <form id="loginForm">
						                <fieldset id="body">
						                	<fieldset>
						                          <label for="email">Email Address</label>
						                          <input type="text" name="email" id="email">
						                    </fieldset>
						                    <fieldset>
						                            <label for="password">Password</label>
						                            <input type="password" name="password" id="password">
						                     </fieldset>
						                    <input type="submit" id="login" value="Sign in">
						                	<label for="checkbox"><input type="checkbox" id="checkbox"> <i>Remember me</i></label>
						            	</fieldset>
						                 <span><a href="#">Forgot your password?</a></span>
							      </form>
				              </div>
			             </div>-->

                    <div class="dropdown-buttons">
                        <div class="modal_popup_dropdown-button">
                            <select class="dropdown" id="profile" tabindex="9" onchange="jsfunction()" data-settings='{"wrapperClass":"flat"}'>
                              <option value="0"><a href="/profile">My Profile</a></option>
                                <option value="1"><a href="/">Log Out</a></option>
                            </select>
                        </div>

                    </div>
		                 <div class="clearfix"></div>
	                 </div>
	                <div class="clearfix"></div>
   </div>
   <div class="banner">
   	  
       <div>

       </div>
   </div>


    <div class="footer">
        <div class="container">
            
            <div class="footer">
                <div class="container">
                    <div class="footer_grids">
                        <ul class="list1">
                            <li><a href="#">ABOUT Us</a></li>
                            <li><a href="#"> CONTACT US</a></li>

                        </ul>
                        <div class="footer-grid last_grid">
                            <ul class="footer_social wow fadeInLeft" data-wow-delay="0.4s">
                                <li><a href=""> <i class="fb"> </i> </a></li>
                                <li><a href=""><i class="tw"> </i> </a></li>
                                <li><a href=""><i class="google"> </i> </a></li>
                                <li><a href=""><i class="u_tube"> </i> </a></li>
                            </ul>

                        </div>
                        <div class="copy wow fadeInRight" data-wow-delay="0.4s">
                            <p> &copy; 2015. HELP DESK. ALL RIGHTS ARE RESERVED. <a href="http://helpdesk.com/">helpdesk.com</a></p>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                </div>
            </div>
        </div>
    </div>





    <script src="js/jquery.min.js"></script>
    <script src="js/jquery.backstretch.min.js"></script>

    <script>
        $(".banner").backstretch([
          "images/banner.jpg",
          "images/banner2.jpg",
          "images/banner3.jpg",
		  "images/banner4.jpg",
          "images/banner5.jpg",
		  "images/banner6.jpg",
          "images/banner7.jpg",
		  
        ], {
            fade: 1500,
            duration: 3000
        });
    </script>



</body>
</html>		