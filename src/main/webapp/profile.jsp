<%@ page language="java" import="java.util.*" %> 
<%@ page language="java" import="java.io.*" %> 
<%@ page import = "java.util.ResourceBundle" %>
<%@ page import="org.spring.controller.*" %>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Help Desk</title>
  <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
   <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <!-- Custom Theme files -->
    <link href="css/style.css" rel='stylesheet' type='text/css' />
    <!-- Custom Theme files -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/login.js"></script>
    <script src="js/jquery.easydropdown.js"></script>
    <script src="js/wow.min.js"></script>
    <link href="css/animate.css" rel='stylesheet' type='text/css' />
    <link href="css/easy-responsive-tabs.css" type="text/css" rel="stylesheet">
    <link href="css/jquery.mCustomScrollbar.css" type="text/css" rel="stylesheet">
    <link href="css/jquery.bxslider.css" type="text/css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet" />
    <link href="css/responsive1.css" type="text/css" rel="stylesheet">
    <script src="js/bootstrap.js"></script>
    <script src="js/jquery.mCustomScrollbar.js"></script>
    <script src="js/jquery.bxslider.js"></script>
    <script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
    <script src="js/script.js"></script>
    <script>
        new WOW().init();
    </script>
 <script>
 </script>
	<script>
            function jsfunction(){
             var select = document.getElementById("profile"); 
			 var selectedString = select.options[select.selectedIndex].value;
              if(selectedString==0)
                 window.open ('profile','_self',false)
				 else
				 window.open ('login','_self',false)
			 }
</script>
  </head>
<body>
   
    <div class="header">
        <div class="col-sm-10 header-left">
            <div class="logo">
                <a href="index.html"><img src="images/logo.png" alt="" /></a>
            </div>
            <div class="menu">
                <a class="toggleMenu" href="#"><img src="images/nav.png" alt="" /></a>
                <ul class="nav" id="nav">
				                   <%
				                   LoginForm loginform=(LoginForm)session.getAttribute("LOGGEDIN_USER") ;
				                   String user=loginform.getUsername();
				                   if(session.getAttribute("ACCESS_LEVEL").equals("4"))
										{
                                
									%>
								
                              <li class="active"><a href="productcatalogueAdmin">Product Catalogue Admin</a></li>
							  <%
								}
							  %>
                                <li class="active"><a href="productcatalogue">Product Catalogue</a></li><input type=hidden value=<%=user%> id="user">
                                <li><a href="createCaseOr">Create an Incident</a></li>
                                <li><a href="notesAll">Message Board</a></li>
                                <li><a href="viewAllCase">View Incident</a></li>
								  
						     <%
                        if(session.getAttribute("ACCESS_LEVEL").equals("4"))
                                                                                {

                                                                        %>
								  <li><a href="appointment">Appointment</a></li>
							   <%
								}
							  %>
								<li><a href="takeAppointment">Take Appointment</a></li>
								<li><a href="search">search</a></li>

								<div class="clearfix"></div>
							</ul>
                <script type="text/javascript" src="js/responsive-nav.js"></script>
            </div>
      
            <div class="clearfix"></div>
        </div>
        <div class="col-sm-2 header_right">
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
    
        <div class="living_middle">
             <div class="container">
    <div class="myprofile_info">
        <div id="horizontalTab" class="resp-htabs">
          <ul class="resp-tabs-list">
            <li><img src="images/myprofile_tab_img1.png"> Account</li>
            <li><img src="images/myprofile_tab_img3.png"> Device</li>
          </ul>
          <div class="resp-tabs-container">

            <div>
              <div class="account_info">
                <div class="account_list">
                  <ul>
                    <li>
                      <div class="name_val">First Name :</div>
                      <div class="inp_val"> <input type="text" class="form-control check_input" disabled value=<%=user%> placeholder="First Name" style="color: #FD0C0C;"/></div>
                    </li>
                    <li>
                      <div class="name_val">Last Name : </div>
                      <div class="inp_val"> <input type="text" class="form-control check_input" disabled value="" placeholder="Last Name" style="color: #FD0C0C;"/></div>
                    </li>
                    <li>
                      <div class="name_val">City : </div>
                      <div class="inp_val"> <input type="text" class="form-control check_input" disabled value="Asutin" placeholder="City" style="color: #FD0C0C;"/></div>
                    </li>
                    <li>
                      <div class="name_val">Country : </div>
                      <div class="inp_val"> <input type="text" class="form-control check_input" disabled value="US" placeholder="Country" style="color: #FD0C0C;"/></div>&nbsp;
                    </li>
                    <li> 
                    </li>
                  </ul>
                </div>
               
              </div>
            </div>
            <div>
              <div class="account_info">
                <div class="account_list">
                  <ul>
                    <li>
                      <div class="name_val">Account Start Date :</div>
                      <div class="inp_val"> <input type="text" id="datepicker" class="form-control check_input" placeholder="Start Date" style="color: #FD0C0C;"/></div>
                    </li>
                    <li>
                      <div class="name_val">Account End Date : </div>
                      <div class="inp_val"> 
						<input type="text" id="datepicker" class="form-control check_input" disabled placeholder="Start Date" style="color: #FD0C0C;"/>
					</div>
                    </li>
                    <li>
                      <div class="name_val">Account No : </div>
                      <div class="inp_val"> <input type="text" class="form-control check_input" disabled placeholder="Account No:" style="color: #FD0C0C;"/></div>
                    </li>
                    <li>
                      <div class="name_val">Account Type : </div>
                      <div class="inp_val"> <input type="text" class="form-control check_input"  disabled placeholder="Account Type" style="color: #FD0C0C;"/></div>&nbsp;
                    </li>
                    <li> 
                    </li>
                  </ul>
                </div>
                
              </div>
            </div>
          </div>
        </div>
      </div>
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
    <script>
    
        (function () {
            "use strict";

            $('.Users_Catalogue tr').hover(function () {
                $(this).find('img').css("visibility", "visible");
            }, function () {
                $(this).find('img').css("visibility", "hidden");
            });
        })();
     

    </script>
  
</body>
</html>		