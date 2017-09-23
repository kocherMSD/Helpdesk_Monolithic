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
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/login.js"></script>
    <script src="js/jquery.easydropdown.js"></script>
    <script src="js/wow.min.js"></script>
    <link href="css/animate.css" rel='stylesheet' type='text/css' />
    <script>
        new WOW().init();
    </script>
	<script>
	<% File configDir = new File(System.getProperty("catalina.base"), "lib");
	 File configFile = new File(configDir, "application.properties");
	 InputStream stream = new FileInputStream(configFile);
	 Properties props = new Properties();
	 props.load(stream);
	%>
	
  $(document).ready(function() {
	  var viewTicket=='<%= props.getProperty("endPoints.viewTicket") %>';
	  var user=$( "#user" ).val();
                var ticketId = getParameterByName('id');
				$.ajax({
			//url: "http://localhost:9080/helpdesk/rest/HelpDeskViewTicket/viewTicket/"+user+"/"+ticketId
			url: viewTicket+user+"/"+ticketId

		}).then(function(data) {
		 var conunt=1; 
		$("#ticketNo").append(ticketId);
		$("#accounttNo").append(ticketId);
		$("#status").append(data.statusName);
		$("#userName").append(data.userId);
		$("#emailAddress").append(data.emailAddress);
		$("#severity").append(data.severityId);
		$("#descriptiveSummary").append(data.descriptiveSummary);
		

	 });
	});
	</script>
	<script>
            function jsfunction(){
             var select = document.getElementById("profile"); 
			 var selectedString = select.options[select.selectedIndex].value;
              if(selectedString==0)
                 window.open ('UserProfile.html','_self',false)
				 else
				 window.open ('index.html','_self',false)
			 }

   function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}
</script>
</head>
<body>



   

    <!-- Modal  ends hear-->


    <div class="header">
        <div class="col-sm-10 header-left">
            <div class="logo">
                <a href="index.html"><img src="images/logo.png" alt="" /></a>
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
                                <li class="active"><a href="productcatalogue">Product Catalogue</a></li><input type=hidden value=<%=user%> id="user">
                                <li><a href="createCaseOr">Create an Incident</a></li>
                                <li><a href="notesAll">Message Board</a></li>
                                <li><a href="viewAllCase">View Incident</a></li>
								 <%
									if(user.equals("arsinghcs@gmail.com"))
									{
                                
									%>
								  <li><a href="appointment">Appointment</a></li>
							   <%
								}
							  %>
								<li><a href="takeAppointment">Take Appointment</a></li>
                           		<li><a href="search">Search</a></li>

								<div class="clearfix"></div>
							</ul>
                <script type="text/javascript" src="js/responsive-nav.js"></script>
            </div>
            
            <!----search-scripts---->
            <script src="js/classie.js"></script>
            <script src="js/uisearch.js"></script>
            <script>
                new UISearch(document.getElementById('sb-search'));
            </script>
            <!----//search-scripts---->
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
    <div class="banner">
      <div class="container_wrap">

          <div class="living_middle" width="100%">
              <div class="container" class="Users_Catalogue">
                  <h2 class="title block-title">View</h2>
                  <div class="col-md-12 wow fadeInLeft" data-wow-delay="0.4s">
                      <div class="living_box">
                          <div class="account_list">
                              <div>
                                  <h5>Account Information </h5> 
                              </div>
                              <div class="row clearfix">
                                  <div class="col-md-4">
                                      <div class="account_listcont">
                                          <ul>
                                              <li>
                                                  <div class="name_val">Ticket No :   </div>
                                                  <div id="ticketNo" class="inp_val">  </div>
                                              </li>
                                              <li>
                                                  <div class="name_val">Account No : </div>
                                                  <div id="accountNo" class="inp_val"></div>
                                              </li>
                                              </ul>
</div>
                                  </div>
                                  <div class="col-md-4">
                                      <div class="account_listcont">
                                          <ul>
                                              <li>
                                                  <div class="name_val">Status : </div>
                                                  <div id="status" class="inp_val"></div>
                                              </li>
                                              <li>
                                                  <div class="name_val">User Name  : </div>
                                                  <div id="userName" class="inp_val"></div>
                                              </li>
                                          </ul>
                                      </div>
                                  </div>
                                  <div class="col-md-4">
                                      <div class="account_listcont">
                                          <ul>
                                              <li>
                                                  <div class="name_val">Email Address :  </div>
                                                  <div id="emailAddress" class="inp_val"></div>
                                              </li>
                                              <li>
                                                  <div class="name_val">Severity   : </div>
                                                  <div id="severity" class="inp_val"></div>
                                              </li>
                                          </ul>
                                      </div>
                                  </div>
                              </div>
                              <div class="row clearfix"  style="margin-top:5%">
                                  <div class="col-lg-12">
                                      
                                      <div class="living_desc" style="margin-bottom:4%;">
                                          <a href="#" class="btn4" style="text-decoration:none" >Notes</a>
                                      </div>
                                      <table border="1" class="Users_Catalogue">
                                          <tbody>
                                              <tr >
                                                  <td>
                                                      <textarea class="form-control" placeholder="Enter your case note here " style="min-width: 100%"></textarea>
                                                  </td>
                                                  
                                              </tr>
                                           
                                              
                                          </tbody>
                                      </table>

                                      <a href="#" class="btn3" style="margin-top:1%">Submit</a>


                                  </div>
                              </div>
                          </div>
                          <hr>
                      </div>
                  </div>
              </div>
          </div>
          <div class="living_middle">
              <div class="container">
                  <div class="col-md-12 wow fadeInLeft" data-wow-delay="0.4s">
                      <div class="living_box">
                          <div class="account_list">
                              <div class="row clearfix">
                                  <div class="col-lg-12">

                                      <div class="living_desc" style="margin-bottom:4%;">
                                          <a href="#" class="btn5" style="text-decoration:none">Problem Description</a>
                                      </div>
                                      <table border="1" class="Users_Catalogue">
                                          <tbody>
                                              <tr>
                                                  <td>
                                                        <div id="descriptiveSummary" class="inp_val"></div>
                                                  </td>

                                              </tr>
                                          </tbody>
                                      </table>
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