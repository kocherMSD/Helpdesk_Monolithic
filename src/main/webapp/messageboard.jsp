<%@ page language="java" import="java.util.*" %> 
<%@ page language="java" import="java.io.*" %> 
<%@ page import = "java.util.ResourceBundle" %>
<%@ page import="org.spring.controller.*" %>

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
	function createMessage()
		 {
		var createMessage='<%= props.getProperty("endPoints.createMessage") %>';
		var getMessage=='<%= props.getProperty("endPoints.getMessage") %>';
		var user=document.getElementById("user").value;
		    var comment=document.getElementById("comment").value;
		    var title = getParameterByName('title');
			if(title=='')
			 {
				var title=document.getElementById("title1").value;
			 }
			if(comment==''&&title=='')
			 {
				alert("Please fill the apporopriate values")
				return;
			 }
		    var currentDate = new Date()
			var day = currentDate.getDate()
			var month = currentDate.getMonth() + 1
			var year = currentDate.getFullYear()
            var tdate= day + "/" + month + "/" + year 
  
		    var dataToSend= {"title":title,"message":comment,"userId":user,"date":currentDate};
		   	$.ajax({headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    },
           // url: 'http://localhost:9080/helpdesk/rest/MessageService/createMessage',
           url:createMessage,
            type: 'POST',
			dataType: 'json',
            data: JSON.stringify(dataToSend),
		   success:  function() {},
           error: function() {
        console.log('Cannot retrieve data.');
    }
});


	
		   
		   
 
  window.location.reload(); }

 </script>
<script>
	
  $(document).ready(function() {
           var title = getParameterByName('title');
	 if(title!='')
	  {
		$.ajax({
			//url: "http://localhost:9080/helpdesk/rest/MessageService/getMessage/"+title
			url: getMessage"+title

		}).then(function(data) {
		 var conunt=1; 
		$("#title").append(title);
		var response=data.messages;
		var response1=data.date;
		for(i=0;i<response.length;i++)
		{
            var $tr = $('<tr class="Users_Catalogue_bg">').append(
            $('<td>').text(response[i]),
            $('<td>').text(response1[i])
        ).appendTo('#added-articles');
		}
	 });
	  }
	  else
	  {
	   $("#title").append('<input type="text" id="title1" class="form-control check_input" placeholder="Caser Title" style="color: #FD0C0C; width:100%"/>');
	   $('#added-articles').hide();
	  }
	});
	</script>
	
	
	<script>
			   function getParameterByName(name) {
			name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
			var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
				results = regex.exec(location.search);
			return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
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
								<li><a href="search">Search</a></li>
                                   <input type=hidden value=<%=user%> id="user">

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
                                <option value="1"><a href="/">Log Out</a></option>                    </select>
                </div>

            </div>
            <div class="clearfix"></div>
        </div>
        <div class="clearfix"></div>
    </div>
    
        <div class="living_middle">
            <div class="container">
                <h2 class="title block-title">Message Board</h2>
                <div class="col-md-12 wow fadeInLeft" data-wow-delay="0.4s">
                    <div class="living_box">

									<div> Title :- <span id="title" class="inp_val">  </span>
									</div>
							<div>
							 <table border="1" id="added-articles" class="Users_Catalogue">
                            <thead>
                                <tr class="Users_Catalogue_tdheader_bg">
                                   
                                    <td>Comment</td>
                                    <td>Date </td>
                                </tr>
                            </thead>
                           
                            </table>
                          </div>
									<div class="name_val">&nbsp;</div>
									<div> Comments
									 <input type=text id="comment" class="form-control" placeholder="Enter your Comments here " style="min-width: 100%"><div align="right">Comments Date time</div>
									</div>
								   
									 
									<div class="name_val">&nbsp;</div>
								   <div class="name_val"> <button type="button" class="btn btn-primary" onclick="createMessage()" data-dismiss="modal" >Save Message</button> </div>
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