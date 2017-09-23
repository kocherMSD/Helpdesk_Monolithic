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
  <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/login.js"></script>
    <script src="js/jquery.easydropdown.js"></script>
    <script src="js/wow.min.js"></script>
    <link href="css/animate.css" rel='stylesheet' type='text/css' />
    <style type='text/css'>
    .searchbox {
    width:100%;
    border:1px solid #d3d3d3;
}
.searchbox div {
    width:100%;
}
.searchbox .innerSearch {
    background-color:#d3d3d3;
    padding: 2px;
    cursor: pointer;
    font-weight: bold;
}
.searchbox .contentN {
    display: none;
    padding : 5px;
}
    </style>
 <script>
        new WOW().init();
    </script>

<script type="text/javascript">
    $(document).ready(function() {
      $("#search").click(function(){
        var q = $("#searchText").val();
        $.getJSON("http://en.wikipedia.org/w/api.php?callback=?",
        {
          srsearch: q,
          action: "query",
          list: "search",
          format: "json"
        },
        function(data) {
          $('#wiki').empty();
          $('#wiki').append('Results for <b>' + q + '</b> from WikiPedia <ul>');
          $.each(data.query.search, function(i,item){
            $('#wiki').append('<li><a href=http://en.wikipedia.org/wiki/' + encodeURIComponent(item.title) + '>' + item.title + '</a>' + item.snippet + '</li>');
          });
            $('#wiki').append('</ul>');
        });
      });
   });

</script>
<script>
    $(".innerSearch").click(function () {

    $innerSearch = $(this);
    //getting the next element
    $content = $innerSearch.next();
    //open up the content needed - toggle the slide- if visible, slide up, if not slidedown.
    $content.slideToggle(500, function () {
        //execute this after slideToggle is done
        //change text of header based on visibility of content div
        $innerSearch.text(function () {
            //change text based on condition
            return $content.is(":visible") ? "Collapse" : "Expand";
        });
    });

});
	function search()
		 {

		    var searchText=document.getElementById("searchText").value;
			if(searchText=='')
			 {
				alert('Empty text. Please provide value in text');
			 }
			
  
 var dataToSend= {"query":searchText};
 <% File configDir = new File(System.getProperty("catalina.base"), "lib");
File configFile = new File(configDir, "application.properties");
InputStream stream = new FileInputStream(configFile);
Properties props = new Properties();
props.load(stream);
 %>
 var serachEndPoint = '<%= props.getProperty("endPoints.serachEndPoint") %>';
 var solrSearchEndPoint= '<%= props.getProperty("endPoints.solrSearchEndPoint") %>';
 $.ajax({headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
            url: serachEndPoint,
            type: 'POST',
             dataType: 'json',
            data: JSON.stringify(dataToSend)    ,
      success: function(data, textStatus, jqXHR) { 
    alert(data)
 $("#results").empty();
  productString='';
 if(typeof data.catalogue != "undefined"){
 productString='<div class="header">  '+data.catalogue.ProductFamilyList.length +' Results for <b>' + searchText + '</b> from Products </div> <div class="searchbox"> <div class="content">      <ul>';
  $.each(data.catalogue.ProductFamilyList, function(i,item){
  productString =productString+ '<li>'+item.productId+'&nbsp;&nbsp;&nbsp;'+item.technologySolution+'&nbsp;&nbsp;&nbsp;'+item.productFamily+'</li>'
});
}
if(typeof data.messages != "undefined"){
 productString =productString +'</ul></div> <div class="header">' +  data.messages.messages.length +'Results for <b>' + searchText + '</b> from Messages </div><div class="searchbox"> <div class="content">      <ul>'
  $.each(data.messages.messages, function(i,item){
  productString =productString +'<div>'+item.title+'&nbsp;&nbsp;&nbsp;'+item.date+'</div>'
});
}
if(typeof data.Tickets != "undefined"){
 productString =productString + '</ul></div><div class="header">' + data.Tickets.ViewAllTicketResponses.length +'Results for <b>' + searchText + '</b> from Tickets and Resolutions </div><div class="searchbox"> <div class="header"><div class="content">      <ul>'
  $.each(data.Tickets.ViewAllTicketResponses, function(i,item){
  productString =productString +'<div>'+item.userId+'&nbsp;&nbsp;&nbsp;'+item.summary+'&nbsp;&nbsp;&nbsp;'+item.descriptiveSummary+'</div>'
}); 
}
 $("#results").append('</ul></div>' +productString);
 }
      }).fail(function (jqXHR, textStatus, error) {
    // Handle error here
    alert(jqXHR.responseText);
  //  $('#editor-container').modal('show');
});
		   
 
//  window.location.reload();
 }
    
    function solrsearch()
		 {
        var solrSearchEndPoint= '<%= props.getProperty("endPoints.solrSearchEndPoint") %>';
		    var searchText=document.getElementById("searchText").value;
			if(searchText=='')
			 {
				alert('Empty text. Please provide value in text');
			 }
			
  
         var dataToSend= {"query":searchText};
 $.ajax({headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
            url: solrSearchEndPoint,
            type: 'POST',
             dataType: 'json',
            data: JSON.stringify(dataToSend)    ,
      success: function(data, textStatus, jqXHR) { 
  
 $("#solrresults").empty();
          
        var docs = data.results;
        $.each(docs, function(i, item) {
            $('#solrresults').prepend($('<div>' + objToString(item) + '</div>'));
        });

        var total = 'Found ' + docs.length + ' results';
        $('#solrresults').prepend('<div>' + total + '</div>');

    }
      }).fail(function (jqXHR, textStatus, error) {
    // Handle error here
    alert(jqXHR.responseText);
  //  $('#editor-container').modal('show');
});
		   
 
 }
function objToString (obj) {
    var str = '';
    for (var p in obj) {
        if (obj.hasOwnProperty(p)) {
            str += p + '::' + obj[p] + '\n';
        }
    }
    return str;
}

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
                        if(session.getAttribute("ACCESS_LEVEL").equals("4"))
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
      <div class="living_middle">
            <div class="container">
                <div class="col-md-12 wow fadeInLeft" data-wow-delay="0.4s">
				<div id="error" style="color: #FD0C0C; width:100%"></div>
                    <div class="living_box">
									<input type="text" id="searchText" class="form-control check_input" placeholder="search text" style="color: #FD0C0C; width:50%"/>
					   <div class="name_val">&nbsp;</div>
								   <div class="name_val">
              <button type="button"  class="btn btn-primary" data-dismiss="modal" onclick="search()" >Basic Search</button> </div>
                        <div class="name_val">
                            <br/>
              <button type="button" id="search">Wikki Search</button> </div>
                    </div>
                     <div class="name_val">
                            <br/>
              <button type="button"  id="search" onclick="solrsearch()">Advance Search</button> </div>
                   
					  </div>  </div>  </div>  			
      
     <div id="results"></div> 
     <div id="wiki"></div> 
     <div id="solrresults"></div> 
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