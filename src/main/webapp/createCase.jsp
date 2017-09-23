<%@ page language="java" import="java.util.*" %> 
<%@ page language="java" import="java.io.*" %> 
<%@ page import = "java.util.ResourceBundle" %>
<%@ page import="java.util.Map" %>  
<%@ page import="org.spring.controller.*" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
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
   <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
  <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js" ></script>
<script type="text/javascript">

$(document).ready(function() {
	
	$("a.radio-picture").click(function(){
		var $id = $(this).attr('id');
		$("a.radio-picture").removeClass('filter:progid:DXImageTransform.Microsoft.Alpha(opacity=100);');
		$("a#" + $id).addClass('filter:progid:DXImageTransform.Microsoft.Alpha(opacity=100)').addClass('-moz-opacity=1').addClass('opacity=1;');
	});
});


function set_radio($inputid) {
$("input#" + $inputid).click();
}
</script>

<style type="text/css">
p {margin:20px 0;}

label {font-weight:bold;}

a.radio-picture {
    border: 2px solid transparent;
    display: inline-block;
    height: 50px;
    margin-right: 10px;
    text-decoration: none;
    width: 60px;
	filter:progid:DXImageTransform.Microsoft.Alpha(opacity=50);
-moz-opacity: 0.5;
opacity: 0.5;

}
a.radio-picture:hover {
	border:2px dashed red;
}
a.green-border {
	border:2px solid green;
}
a#category_fruit {
    background: url("images/Down.png") no-repeat scroll 0 0 white;
}
a#category_vegetables {
    background: url("images/exclamation.png") no-repeat scroll 0 0 white;
}
a#category_meat {
    background: url("images/myprofile_tab_img1.png") no-repeat scroll 0 0 white;
}
a#category_bread {
    background: url("images/question.png") no-repeat scroll 0 0 white;
}

.hidden {
    left: -10000px;
    position: absolute;
    top: -1000px;
}
input[type="submit"] {cursor:pointer;}
</style>

 <% File configDir = new File(System.getProperty("catalina.base"), "lib");
	 File configFile = new File(configDir, "application.properties");
	 InputStream stream = new FileInputStream(configFile);
	 Properties props = new Properties();
	 props.load(stream);
	 LoginForm loginform=(LoginForm)session.getAttribute("LOGGEDIN_USER") ;
     String user=loginform.getUsername();
	  %>
	
    <script>
	$(document).ready(function() {
		  var getCatalogue = '<%= props.getProperty("endPoints.getCatalogue") %>';
		  var getIssueTypesAndScopes = '<%= props.getProperty("endPoints.getIssueTypesAndScopes") %>';
          var createTicket= '<%= props.getProperty("endPoints.createTicket") %>';
	
		$.ajax({
			
			url: getCatalogue+'/<%=user%>'
		}).then(function(data) {
			var response=data.ProductFamilyList;
		 
        var availableTags=[];;
        var	conunt=0; 
		  $.each(response, function(i, item) {
            availableTags[conunt]=(item.productId);
		conunt++;
    });
	    $( "#products" ).autocomplete({
			select: function(event,ui) {
				  var dataItem = ui.item.label;
                  loadIssueType(dataItem);
				  loadContact();
    },
         source: availableTags
    });
	  });
	});

	function loadIssueType(dataItem)
	{
	  $.ajax({
		
			url:getIssueTypesAndScopes+dataItem
		}).then(function(data) {
			var response=data.IssueTypeDetails;
		 
        var availableTags=[];
		
        var	conunt=0; 
		  $.each(response, function(i, item) {
            availableTags[conunt]=(item.issueType);
		conunt++;
    });
	 $( "#issueType" ).autocomplete({
         source: availableTags
    });
	  });
	}

	function loadContact()
	{
 
        var availableTags=["By Phone", "By Email"];
		
      
	 $( "#contactType" ).autocomplete({
         source: availableTags
    });
	 
	}

	function saveCase()
	{
		
                 var createTicket= '<%= props.getProperty("endPoints.createTicket") %>';
	
	var enviormentstatus=$( "#enviormentstatus" ).val();
	var products=$( "#products" ).val();
	var user=$( "#user" ).val();
	var issueType=$( "#issueType" ).val();
	var contactType=$( "#contactType" ).val();
	var title=$( "#caseTitle" ).val();

    if(enviormentstatus==''||products==''||issueType==''||contactType==''||title=='')
		{
		$( "#error" ).empty();
		$( "#error" ).append("Please fill all fields");
		return;
		}
	var userId =""+user
	var summary=title;
	var statusName="open";
	var typeName="Issue";
	var severityId=enviormentstatus;
	var outage="No";
	var requestContext="Service";
	var verifyCpFlag="N";
	var product=products;
	var productFamily=products;
	var  issueType=issueType;
	var  issueScope="unknown";
	
	var customer_name="";
	var isPartner="";
	var privilege_level="2";
	var access_level="3";
	var descriptiveSummary="";
	var accesslevel="3";
	var user=document.getElementById("user").value;
	var emailAddress="";
	  
	        var dataToSend= { "Contact": {
            "ccoid": ""+user,
            "contactPointType": "This is test ticket",
            "contactPointValue": "This is test ticket"
        },
        "userId": user,
        "summary": title,
        "statusName": statusName,
        "typeName": typeName,
        "severityId": severityId,
        "outage": outage,
        "requestContext": requestContext,
        "verifyCpFlag": verifyCpFlag,
        "product": product,
        "productFamily": products,
        "issueType": issueType,
        "issueScope": issueScope,
        "customer_name": customer_name,
        "isPartner": isPartner,
        "privilege_level": privilege_level,
        "access_level": "Y",
        "descriptiveSummary": title,
        "accesslevel": accesslevel,
        "emailAddress": user
            }
	$.ajax({headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    },
           
            url: createTicket,
            type: 'POST',
			dataType: 'json',
            data: JSON.stringify(dataToSend)    ,
      success: function(data) {  $("#caseNumber").html("Success :- Case No. "+data.ticketNumber); }
        }).fail(function (jqXHR, textStatus, error) {
    // Handle error here
    alert(jqXHR.responseText);
  //  $('#editor-container').modal('show');
});
	
	
	}
 
  </script>
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
				                  
				                   if(session.getAttribute("ACCESS_LEVEL").equals("4"))										{
                                
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
                                <option value="0"><a href="/UserProfile.html">My Profile</a></option>
                                <option value="1"><a href="/index.html">Log Out</a></option>
                    </select>
                </div>

            </div>
            <div class="clearfix"></div>
        </div>
        <div class="clearfix"></div>
    </div>
    
        <div class="living_middle">
            <div class="container">
                <h2 class="title block-title">Create Case</h2>
                <div class="col-md-12 wow fadeInLeft" data-wow-delay="0.4s">
				<div id="error" style="color: #FD0C0C; width:100%"></div>
                    <div class="living_box">
									
									<div id="caseNumber"></div>
							<div>	Title	<input type="text" id="caseTitle" class="form-control check_input" placeholder="Caser Title" style="color: #FD0C0C; width:100%"/></div>
									<div class="name_val">&nbsp;</div>
									<fieldset>
									<legend>Environment Status</legend>
									  <table width="100%" >
										<tr>
											<td align="center">
												<input type="radio" value="fruit" name="category" id="category_1" class="hidden" />
												<a id="category_fruit" href="javascript:set_radio('category_1');" class="radio-picture">&nbsp;</a>											</td>
											<td align="center">
												<input type="radio" value="vegetables" name="category" id="category_2" class="hidden" />
												<a id="category_vegetables" href="javascript:set_radio('category_2');" class="radio-picture">&nbsp;</a>											</td>
											</tr>
											<tr><td align="center">Down</td><td align="center">Severly Degraded</td></tr>
											<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
											<tr>
											<td align="center">
												<input type="radio" value="meat" name="category" id="category_3" class="hidden" />
												<a id="category_meat" href="javascript:set_radio('category_3');" class="radio-picture">&nbsp;</a>											</td>
											<td align="center">
												<input type="radio" value="bread" name="category" id="category_4" class="hidden" />
												<a id="category_bread" href="javascript:set_radio('category_4');" class="radio-picture">&nbsp;</a>
											</td>
											</tr>
											<tr><td align="center">Impaired</td><td align="center">Ask Question</td></tr>
											</table>
											</fieldset>
       

       

       

      
      

								  </div>
                                <div class="name_val">&nbsp;</div>
								   
									 
									  <table width="100%">
									    <tr><td>Solution, Product & issue </td></tr>
										<tr>
											<td><input  id="products" class="form-control check_input" placeholder="Search product by name" style="color: #FD0C0C; width:100%"/></td>
										</tr>
										<tr><td>&nbsp;</td></tr>
										<tr>
											<td><input id="issueType" class="form-control check_input" placeholder="Issue Type" style="color: #FD0C0C; width:100%"/></td>
										</tr>
										<tr><td>&nbsp;</td></tr>
										<tr>
											<td><input  id="contactType" class="form-control check_input" placeholder="Search by Email" style="color: #FD0C0C; width:100%"/></td>
										</tr>
									  </table>
								  <div class="name_val">&nbsp;</div>
								   <div class="name_val"> <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="saveCase()" >Save Case</button> </div>
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