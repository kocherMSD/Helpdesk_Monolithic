<%@ page language="java" import="java.util.*" %> 
<%@ page language="java" import="java.io.*" %> 
<%@ page import = "java.util.ResourceBundle" %>
<!DOCTYPE HTML>
<html>
<head>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
      
	<% File configDir = new File(System.getProperty("catalina.base"), "lib");
		File configFile = new File(configDir, "application.properties");
		InputStream stream = new FileInputStream(configFile);
		Properties props = new Properties();
		props.load(stream);
		 %>
  <script type="text/javascript">

  
        function saveproducts()
         {
                var addCatalogue= '<%= props.getProperty("endPoints.addCatalogue") %>';
                
                 var product=$( "#product" ).val();
                 var productFamily=$( "#productFamily" ).val();
                 var date='2017/09/09';
                 var status=$( "#status" ).val();
                 var solutiontechnology='N';
                 var version='1';
                 var solution_products_flag=status;
               
               
     var dataToSend= {
    "pid":""+product,
    "productdesc":""+ product,    
    "productfamily":""+productFamily,    
    "solutiontechnology":""+solutiontechnology    ,
    "created_date":""+date,        
    "updated_date":""+date,    
    "version":""+1,
    "solution_products_flag":""+solution_products_flag
    }
    	$.ajax({headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    },
           
            url: addCatalogue,
            type: 'POST',
			dataType: 'json',
            data: JSON.stringify(dataToSend)    ,
      success: function(data) {  $("#caseNumber").html("Product Added"); }
        }).fail(function (jqXHR, textStatus, error) {
    // Handle error here
    alert(jqXHR.responseText);
  //  $('#editor-container').modal('show');
});
}
      
       
       
function saveUsers()
	{     
          var account_id=$("#account_id" ).val();
          var user_id=$("#user_id" ).val();
          var password=$("#password").val();
          var firstName=$("#firstName").val();
          var last_name=$("#last_name").val();
          var city=$("#city").val();
          var country=$("#country").val(); 
          var email=$("#email" ).val();
           var companyname='None;'
           var accesslevel=1;
           var crparty_id='1';
           var phonenumber='2082304076';
           var gu_id='1'
           var created_date=null;
           var updated_date=null;
           var AppointmentCapability='N';
        
        
        var  contractexpdate='2017/09/09';
        var  contractstatus='active';
        var  contracttype='new';
        var servicelinedesc='';
        var  servicelinestatus='Active';
        var servicelinestartdate='2017/09/09';
        var servicelineenddate='2017/09/09';
        var billtositeuse_id  ='12';         
        var billtoparty_id='12';
        var created_date='null';
        var updated_date='null';
        var entitlementKey='1';
        var version='1';

  var dataToSend={
    "user":{
        "ccoid":""+user_id,		  
		"firstname":""+firstName,	
        "firstname":""+password,
        "city":""+city,
        "country":""+country,
		 "middlename":""+last_name,		  
		 "lastname":""+last_name,		  		  
		 "companyname":""+companyname,		  
		"accesslevel":""+accesslevel,		  
		 "emailaddress":""+email,		  
		 "crparty_id":""+crparty_id,	  
		"phonenumber":""+phonenumber,		  
		"gu_id":""+gu_id,		  
		"created_date":""+created_date,
        "updated_date":""+updated_date,	
        "appointmentCapability":""+AppointmentCapability
    },
    "contract":{
    "ccoid":""+user_id, 
	"contractnumber":""+account_id,    
	"contractexpdate":""+contractexpdate,  
	"contractstatus":""+contractstatus,    
	 "contracttype":""+contracttype,    
	"servicelinedesc":""+servicelinedesc,    
	"servicelinestatus":""+servicelinestatus,    
	"servicelinestartdate":""+servicelinestartdate,
	"servicelineenddate":""+servicelineenddate,    
	"billtositeuse_id":""+billtositeuse_id,    
	"billtoparty_id":""+billtoparty_id,    
	"created_date":""+created_date,   
	"updated_date":""+updated_date,  
	"version":""+version,   
    "entitlementKey":""+entitlementKey,
    }
  }
 
   var addUser= '<%= props.getProperty("endPoints.addUser") %>';
 
	$.ajax({headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    },
           
            url: addUser,
            type: 'POST',
			dataType: 'json',
            data: JSON.stringify(dataToSend)    ,
      success: function(data) {  $("#result").html("User Added"); }
        }).fail(function (jqXHR, textStatus, error) {
    // Handle error here
    alert(jqXHR.responseText);
  //  $('#editor-container').modal('show');
});
    }
      
      function addSoldProducts()
      {
   
          
        
           var account_id=$("#account_id_1" ).val();
          var user_id=$("#user_id_1" ).val();
          var product=$("#product_1").val();
          var serialNo=$("#serialNo").val();
          var date=$("#date_1").val();
          var productFamily=$("#productFamily_1").val();
          
        var addDevice= '<%= props.getProperty("endPoints.addDevice") %>';
           alert(addDevice);
    var dataToSend= {
    "accountId":""+ account_id,    
    "productFamily":""+productFamily,    
    "product":""+product    ,
    "serialNumber":""+serialNo,        
    "date":""+date
    }
 
	$.ajax({headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    },
           
            url: addDevice,
            type: 'POST',
			dataType: 'json',
            data: JSON.stringify(dataToSend)    ,
      success: function(data) {  $("#result").html("User Added"); }
        }).fail(function (jqXHR, textStatus, error) {
    // Handle error here
    alert(jqXHR.responseText);
  //  $('#editor-container').modal('show');
});   
          
}
      
	$(document).ready(function() {
        
       
		 var getAllCatalogue = '<%= props.getProperty("endPoints.getAllCatalogue") %>';
     //	alert(getCatalogue);	
		$.ajax({
			url: getAllCatalogue
		}).then(function(data) {
			var response=data.ProductFamilyList;
		  var	conunt=1; 
		  $.each(response, function(i, item) {
            var $tr = $('<tr class="Users_Catalogue_bg">').append(
			$('<td>').text(conunt),
            $('<td>').text(item.productId),
            $('<td>').text(item.productFamily),
            $('<td>').text(item.technologySolution)
        ).appendTo('#productcatalogue');
		conunt++;
    });
	 });
        
        
        var getProductFamily = '<%= props.getProperty("endPoints.getProductFamily") %>';
     //	alert(getCatalogue);	
		$.ajax({
			url: getProductFamily
		}).then(function(data) {
			var response=data.productFamily;
		  var	conunt=1; 
             $('<option>').text('Select Product Family')
        .appendTo('#productFamily_1');
           $.each(response, function(i, item) {
            var $tr = $(
			$('<option >').text(item)
        ).appendTo('#productFamily_1');
		conunt++;
    });	 });
	});
      
      function getProducts()
      {
         var productFamily=$("#productFamily_1").val();
         var getProducts = '<%= props.getProperty("endPoints.getProducts") %>';
     //	alert(getCatalogue);	
		$.ajax({
			url: getProducts+"/"+productFamily
		}).then(function(data) {
			var response=data.products;
		  var	conunt=1;
      
       $('#product_1 option').each(function() {
        $(this).remove();
      });       
             $('<option>').text('Select Product')
        .appendTo('#product_1');
            $.each(response, function(i, item) {
            var $tr = $(
			$('<option>').text(item)
        ).appendTo('#product_1');
		conunt++;
    });	 });
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
    <!-- Modal -->
    <div class="modal fade" id="productModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Add Supported Products</h4>
                </div>
                <div class="modal-body">
                   
                    <div class="editaccountinformation_list">
                        <ul>
                            
                             <li>
                                <label>Product Family :</label>
                                <input type="text" class="form-control check_input" id="productFamily" placeholder="productFamily" />
                            </li>
                            <li>
                                <label>Product :</label>
                                <input type="text" class="form-control check_input" id="product" placeholder="Product" />
                            </li>
                           
                          
                            <li>
                                <label>Status :</label>
                                <input type="text" class="form-control check_input" id="status" placeholder="status" />
                            </li>
                        </ul>
                    </div>
                    </div>
                <div class="modal-footer">
                    <button type="button"  onclick="saveproducts()" class="btn btn-info btn-block" data-dismiss="modal">Save</button>
                </div>
            </div>

        </div>
    </div>

    <!-- Modal  ends hear-->
    
      <!-- Modal -->
    <div class="modal fade" id="userModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Add New User</h4>
                </div>
                <div class="modal-body">
                   
                    <div class="editaccountinformation_list">
                        <ul>
                             <li>
                                <label>Account Id:</label>
                                <input type="text" class="form-control check_input" id="account_id" placeholder="account_id" />
                            </li>
                            <li>
                                <label>User Id :</label>
                                <input type="text" class="form-control check_input" id="user_id" placeholder="user_id" />
                            </li>
                           
                          
                            <li>
                                <label>Password :</label>
                                <input type="password" class="form-control check_input" id="password" placeholder="password" />
                            </li>
                            
                             <li>
                                <label>First Name :</label>
                                <input type="text" class="form-control check_input" id="firstName" placeholder="firstName" />
                            </li>
                            
                            <li>
                                <label>Last Name :</label>
                                <input type="text" class="form-control check_input" id="last_name" placeholder="last_name" />
                            </li>
                            <li>
                                <label>City :</label>
                                <input type="text" class="form-control check_input" id="city" placeholder="city" />
                            </li>
                            <li>
                                <label>Country :</label>
                                <input type="text" class="form-control check_input" id="country" placeholder="country" />
                            </li>
                            
                            <li>
                                <label>Email :</label>
                                <input type="text" class="form-control check_input" id="email" placeholder="email" />
                            </li>
                        </ul>
                    </div>
                    </div>
                <div class="modal-footer">
                    <button type="button" onclick="saveUsers()" class="btn btn-info btn-block" data-dismiss="modal">Save</button>
                </div>
            </div>

        </div>
    </div>

    <!-- Modal  ends hear-->
    
      <!-- Modal -->
    <div class="modal fade" id="supportModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Add Sold Product</h4>
                </div>
                <div class="modal-body">
                   
                    <div class="editaccountinformation_list">
                        <ul>
                             <li>
                                <label>User Id :</label>
                                <input type="text" class="form-control check_input" id="user_id_1" placeholder="user_id" />
                            </li>
                        
                            <li>
                                <label>Account Id :</label>
                                <input type="text" class="form-control check_input" id="account_id_1" placeholder="account_id" />
                            </li>
                           
                            <li>
                                <label>Product Family :</label>
                                <select class="form-control check_input" onchange="getProducts()" id="productFamily_1"></select>
                            </li>
                           
                            <li>
                                <label>Product :</label>
                                 <select class="form-control check_input" id="product_1" ></select>

                            </li>
                            <li>
                                <label>Serial No :</label>
                                <input type="text" class="form-control check_input" id="serialNo" placeholder="serialNo" />
                            </li>
                            <li>
                                <label>Date :</label>
                                <input type="text" class="form-control check_input" id="date_1" placeholder="date" />
                            </li>
                        </ul>
                    </div>
                    </div>
                <div class="modal-footer">
                    <button type="button" onclick="addSoldProducts()" class="btn btn-info btn-block" data-dismiss="modal">Save</button>
                </div>
            </div>

        </div>
    </div>

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
								
                              <li class="active"><a href="productcatalogueAdmin">Administrator</a></li>
							  <%
								}
							  %>
                                <li class="active"><a href="productcatalogueAdmin">Administration</a></li>
                                 <li><a href="viewAllCase">View All Incident</a></li>

								 <%
									if(session.getAttribute("ACCESS_LEVEL").equals("4"))
									{
                                
									%>
								       <li><a href="appointment">Appointment</a></li>
							   <%
								}
							  %>

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
    
        <div class="living_middle">
            <div class="container">
                
                <div class="col-md-12 wow fadeInLeft" data-wow-delay="0.4s">
                    <h2 class="title block-title">Administration</h2>
                    <div class="living_box">
                        <div class="living_box">
                        <div class="living_desc" style="margin-bottom:0%;">
                            
                            <a href="#" class="btn btn-info btn-block" data-toggle="modal" data-target="#productModal">Add Supported Products</a>
                           </div> <div class="living_desc" style="margin-bottom:0%;">
                            <a href="#" class="btn btn-info btn-block" data-toggle="modal" data-target="#userModal">Add New User</a> 
                               </div>
                        <div class="living_desc" style="margin-bottom:0%;">
                            <a href="#" class="btn btn-info btn-block" data-toggle="modal" data-target="#supportModal">Add Sold Product</a>
                        </div></div>
                         <div class="living_box">
                        <h2 class="title block-title">Supported products</h2>
                        </div>
                        <table border="1" class="Users_Catalogue" id="productcatalogue">
                            <thead>
                                
                                <tr class="Users_Catalogue_tdheader_bg">
                                   
                                    <td>Sr.No</td>
                                    <td>Product</td>
                                    <td>Product Family</td>
                                    <td>Status </td>
                                </tr>
                            </thead>
                            <tbody>
                                <tr class="Users_Catalogue_bg">
                                    
                                  
                                </tr>
              
                            </tbody>
                        </table>
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
