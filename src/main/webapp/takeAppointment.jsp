<%@ page language="java" import="java.util.*" %> 
<%@ page language="java" import="java.io.*" %> 
<%@ page import = "java.util.ResourceBundle" %>
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
	  $(document).ready(function () {
	

	              function isDST(t) { //t is the date object to check, returns true if daylight saving time is in effect.
						var jan = new Date(t.getFullYear(),0,1);
						var jul = new Date(t.getFullYear(),6,1);
						return Math.min(jan.getTimezoneOffset(),jul.getTimezoneOffset()) == t.getTimezoneOffset();  
					}
		if(isDST(new Date()))
			     {
				    $("select[name='timeZone']").append('<option value="-0300">Atlantic Time </option>');
					$("select[name='timeZone']").append('<option value="-0400">Eastern Time </option>');
					$("select[name='timeZone']").append('<option value="-0500">Central Time </option>');
					$("select[name='timeZone']").append('<option value="-0600">Mountain Time </option>');
					$("select[name='timeZone']").append('<option value="-0700">Pacific Time </option>');

				 }
				 else
			     {
				        $("select[name='timeZone']").append('<option value="-0400">Atlantic Time </option>');
						$("select[name='timeZone']").append('<option value="-0500">Eastern Time </option>');
						$("select[name='timeZone']").append('<option value="-0600">Central Time </option>');
						$("select[name='timeZone']").append('<option value="-0700">Mountain Time </option>');
						$("select[name='timeZone']").append('<option value="-0800">Pacific Time </option>');


				 }
				   });
	    function getAvailableDate()
		 {
	    	 <% File configDir = new File(System.getProperty("catalina.base"), "lib");
	    	 File configFile = new File(configDir, "application.properties");
	    	 InputStream stream = new FileInputStream(configFile);
	    	 Properties props = new Properties();
	    	 props.load(stream);
	    	  %>
	    	  var getAvailableDates = '<%= props.getProperty("endPoints.getAvailableDates") %>';



		   var product=document.getElementById("product");
		   var timeZone=document.getElementById("timeZone");
		   if(product!=''&&timeZone!='')
			 {
		   var dataToSend= {"product_id":"13","clientTimeZone":"-0500"};
		   	$.ajax({headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    },

            url: getAvailableDates,
            type: 'POST',
			dataType: 'json',
            data: JSON.stringify(dataToSend),
		   success:  function(results) {

        $.each(results.availableDates, function(i, item) {
           $("select[name='appointmentdate']").append('<option value="'+item+'">'+item+' </option>');		conunt++;
    });
       
      
    },
    error: function() {
        console.log('Cannot retrieve data.');
    }
    });
	
	getAvailableslot()	   
		   
 }
	
 }

   function getAvailableslot()
		 {
                  var getAvailableTimeSlots = '<%= props.getProperty("endPoints.getAvailableTimeSlots") %>';

		   var product=document.getElementById("product");
		   var timeZone=document.getElementById("timeZone");
		    var appointmentdate=document.getElementById("appointmentdate");
		   if(product!=''&&timeZone!=''&&appointmentdate!='')
			 {
		   var dataToSend= {"pid":"13","clientTimeZone":"-0500","date":"01/28/2016"};
		   	$.ajax({headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    },

          url: getAvailableTimeSlots,
            type: 'POST',
			dataType: 'json',
            data: JSON.stringify(dataToSend),
		   success:  function(results) {
           // alert(results.availableDates);
        $.each(results.timeSlots, function(i, item) {
           $("select[name='timeslot']").append('<option value="'+item+'">'+item+' </option>');		conunt++;
    });
       
      
    },
    error: function() {
        console.log('Cannot retrieve data.');
    }
});
			 }}

function createAppointment()
		 {
                     var  saveAppointment=  '<%= props.getProperty("endPoints.saveAppointment") %>';
		   var product=document.getElementById("product");
		   var timeZone=document.getElementById("timeZone");
		    var appointmentdate=document.getElementById("appointmentdate");
		    var timeslot=document.getElementById("timeslot");

		   if(product!=''&&timeZone!=''&&appointmentdate!=''&&timeslot!='')
			 {
		   var dataToSend= {"pid":"13","ccoid":"12","date":"01/20/2016","slot":"02:00 AM-02:25 AM","srNo":"1","TimeZone":"America/Chicago"};
		   	$.ajax({headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    },
           // url: 'http://localhost:9080/helpdesk/rest/AppointmentService/saveAppointment/',
            url: saveAppointment,
            type: 'POST',
			dataType: 'json',
            data: JSON.stringify(dataToSend),
		   success:  function() {},
           error: function() {
        console.log('Cannot retrieve data.');
    }
});


	
		   
		   
 }
	
 }
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
<body onload"isDST(t)">
   
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
         
          <div class="resp-tabs-container">

            <div>
              <div class="account_info">
                <div class="account_list">
                  <ul>
                    <li>
                      <div class="name_val">Product :</div>
                      <div class="inp_val"> 
                <select name="name"  id="product" class="required" rel="1">
				<option value="13">            Black berry Z10          </option>
				<option value="12">	           Blackberry bold          </option>
				<option value="2">		       iPhone 3G                </option>
				<option value="3">		       iPhone 3GS               </option>
				<option value="4">		       iPhone 4                 </option>
				<option value="5">		       iPhone 4s                </option>
				<option value="6">		       iPhone 5                 </option>
				<option value="7">		       iPhone 5 C               </option>
				<option value="8">		       iPhone 5s                </option>
				<option value="9">		       iPhone 6                 </option>
				<option value="10">		       iPhone 6 plus            </option>
				<option value="11">		       iPhone 6 s               </option>
				<option value="14">		       Nokia 700                </option>
				<option value="15">		       Nokia 808                </option>
				<option value="16">		       Nokia 8210               </option>
				<option value="17">		       Nokia E7                 </option>
				<option value="18">	       Nokia Lumia 1020         </option>
				<option value="22">	       Nokia Lumia 610          </option>
				<option value="19">	       Nokia Lumia 810          </option>
				<option value="20">	       Nokia Lumia 925          </option>
				<option value="21">	       Nokia Lumia 928          </option>
				<option value="1">	       Phone 1st Generation     </option>
				<option value="30">      Samsung Galaxy Note Edge </option>
				<option value="31">       Samsung Galaxy Note II   </option>
				<option value="32">	       Samsung Galaxy S         </option>
				<option value="33">	       Samsung Galaxy S 3       </option>
				<option value="34">	       Samsung Galaxy S 4       </option>
				<option value="35">	       Samsung Galaxy S 5       </option>
				<option value="36">	       Samsung Galaxy S 6       </option>
				<option value="37">	       Samsung Nexus S          </option>
				<option value="38">      Samsung Stratosphere II  </option>
				<option value="28">		       Sony Xperia              </option>
				<option value="29">		       Sony Xperia              </option>
				<option value="23">	       Sony Xperia Arc S        </option>
				<option value="24">		       Sony Xperia L            </option>
				<option value="25">	       Sony Xperia Play         </option>
				<option value="26">		       Sony Xperia SP           </option>
				<option value="27">	       Sony Xperia X10          </option>
				</select>					  
					  </div>
                    </li>
                    <li>
                      <div class="name_val">TimeZone : </div>
                      <div class="inp_val"> 
						<select name="timeZone1" id='timeZone1' hidden="true" class="required"><option></option></select>
						<select name="timeZone" id='timeZone' class="required" onchange="getAvailableDate()">
						<option></option>


						</select>					  
					  </div>
                    </li>
                    <li>
                      <div class="name_val">Apointment Date: </div>
                      <div class="inp_val"> 
					  
                          <select name="appointmentdate" id='appointmentdate' class="required">
						<option></option>
						</select>					  
					  </div>
                    </li>
                    <li>
                      <div class="name_val">Apointment Timeslot : </div>
                      <div class="inp_val"> 
                     <select name="timeslot" id='timeslot' class="required">
						<option></option>
						</select>					  
					  </div>&nbsp;
                    </li>
                    <li> 
                       <div class="name_val"> <button type="button" onclick="createAppointment()" class="btn btn-info btn-block" data-dismiss="modal">Save</button></div>
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