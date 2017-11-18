<%@ page language="java" import="java.util.*" %> 
<%@ page language="java" import="java.io.*" %> 
<%@ page import = "java.util.ResourceBundle" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<script src="js/jquery.easydropdown.js"></script>
<script src="js/scripts.js"></script>
<!--Animation-->
  
<script src="js/wow.min.js"></script>
	<% File configDir = new File(System.getProperty("catalina.base"), "lib");
       	 File configFile = new File(configDir, "application.properties");
       	 InputStream stream = new FileInputStream(configFile);
       	 Properties props = new Properties();
       	 props.load(stream);
       	%>
<script>
        function login()
                 {
        
  		  var authenticate = '<%= props.getProperty("endPoints.authenticate") %>';
  		  

                    var userName=document.getElementById("username").value;
                    var password = getParameterByName('password');
                        
                        if(userName==''&&password=='')
                         {
                                alert("Please fill the apporopriate values in userId and password")
                                return;
                         }
                  

                    var dataToSend= {"userName":userName,"password":password};
                        $.ajax({headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
          //  url: 'http://localhost:9080/helpdesk/rest/Authentication/authenticate',
          url: authenticate,
            type: 'POST',
                        dataType: 'json',
            data: JSON.stringify(dataToSend),
                   success:  function(data) {
               alert(data); 	   
                   },
                   }
           error: function() {
        console.log('Cannot retrieve data.');
    }
});
</script>
<link href="css/animate.css" rel='stylesheet' type='text/css' />
<script>
	new WOW().init();
</script>
    <!--<script src="js/jquery.min.js"></script>-->
    <script src="js/jquery.backstretch.min.js"></script>

</head>
<body onload="showModal()">
    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog modal-sm" style="margin-top:14%">
            <div class="modal-content">
                <div class="modal_popup_header">
                    <!--<button type="button" class="close" data-dismiss="modal">&times;</button>-->
                    <h4 class="modal-title" style="text-align: center;">Welcome</h4>
                </div>
                <div class="modal-body">
                   
                    <div >
                      
      <form:form action="login" method="post"  modelAttribute="loginAttribute">
		<table border="0" cellpadding="1" cellspacing="0">
		<tr>
			<th>Username &nbsp;</th>
			<td><form:input type="text"  class="login-inp" path="username" /></td>
		</tr>
		<tr>
			<th>Password &nbsp; </th>
			<td><form:input type="password" value="************"  onfocus="this.value=''" class="login-inp" path="password"/></td>
		</tr>
		<tr>
			<th></th>
			<td valign="top"><input type="checkbox" class="checkbox-size" id="login-check" /><label for="login-check">Remember me</label></td>
		</tr>
		<tr>
			<th></th>
			<td><input type="submit" class="submit-login"  value="login" /></td>
		</tr>
		</table>
		</form:form>
</div>
                        </div>
                       
						
                    </div>
                    


                </div>
               
            </div>
        </div>
    </div>
    <!--model will be end hear-->

            <div class="col-sm-2 header_right " onload="showModal()>
                <!--<div id="loginContainer">

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
        </div>
              
                <div class="clearfix"></div>
            </div>
            <div class="clearfix"></div>
        </div>
    <!--banner will be starts form hear-->
        <div class="banner" onclick="showModal()">
            <div class="container_wrap">
                <div class="contact_btn">
                    <!--<label class="main_page_btn btn-2 btn-2g"><input name="submit" type="submit" id="submit" value="login" data-toggle="modal" data-target="#myModal"></label>-->
                    
                </div>
            </div>
            <div>

            </div>
        </div>


        <div class="footer" onclick="showModal()">
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

    <script type="text/javascript">
        $(document).ready(function () {

            $('#myModal').modal('show');
        });
		function showModal()
		{
		 $('#myModal').modal('show');

		}
    </script>

        <script>

		
            $(".banner").backstretch([
              "images/banner.jpg",
              "images/banner2.jpg",
              "images/banner3.jpg",
              "images/banner4.jpg",
              "images/banner5.jpg",
              "images/banner6.jpg",

            ], {
                fade: 500,
                duration: 2000
            });
        </script>



</body>
</html>		