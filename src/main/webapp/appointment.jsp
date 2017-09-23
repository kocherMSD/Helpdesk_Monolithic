<!DOCTYPE html>
<html>
    <head>
        <title>Apointments</title>
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
				 window.open ('login','_self',false)
			 }
</script>

        <link href="media/dataTables/demo_page.css" rel="stylesheet" type="text/css" />
        <link href="media/dataTables/demo_table.css" rel="stylesheet" type="text/css" />
        <link href="media/dataTables/demo_table_jui.css" rel="stylesheet" type="text/css" />
        <link href="media/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" media="all" />
      
	
        <link href="media/themes/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css" media="all" />
		<link rel="styleshee" type="text/css" href="media/dataTables/jquery.timepicker.css" />
  <link rel="stylesheet" type="text/css" href="media/dataTables/bootstrap-datepicker.css" />
  <link rel="stylesheet" type="text/css" href="media/dataTables/jquery.autocomplete.css" />

  <script type="text/javascript" src="scripts/jquery.min.js"></script>
   <script type="text/javascript" src="scripts/jquery-ui.js"></script>

     <script src="scripts/jquery.dataTables.1.8.2.js" type="text/javascript"></script>
        <script src="scripts/jquery.dataTables.editable.js" type="text/javascript"></script>
        <script src="scripts/jquery.jeditable.js" type="text/javascript"></script>
        <script src="scripts/jquery.validate.js" type="text/javascript"></script>
        <script type="text/javascript">

		jQuery.extend( jQuery.fn.dataTableExt.oSort, {
	"num-html-pre": function ( a ) {
		var x = String(a).replace( /<[\s\S]*?>/g, "" );
		return parseFloat( x );
	},

	"num-html-asc": function ( a, b ) {
		return ((a < b) ? -1 : ((a > b) ? 1 : 0));
	},

	"num-html-desc": function ( a, b ) {
		return ((a < b) ? 1 : ((a > b) ? -1 : 0));
	}
} );
</script>
		   <script type="text/javascript" src="scripts/jquery-ui.js"></script>
		   <script type="text/javascript" src="scripts/jquery.autocomplete.js"></script>

        <script type="text/javascript">
        $(document).ready(function () {


            $("#companies").dataTable({
                "bServerSide": true,
                "sAjaxSource": "/helpdesk/CompanyAjaxDataSource",
                "bProcessing": true,
                "sPaginationType": "full_numbers",
                "bJQueryUI": true,
                "aoColumnDefs": [
                              { "sType": "html", "aTargets": [ 0 ] },
                      { "sType": "html", "aTargets": [ 0 ] },
                       { "sType": "date", "aTargets": [ 0 ] },
				{ "sType": "numeric", "aTargets":0 },
				{ "sType": "numeric", "aTargets":3 },
					  { type: 'num-html', aTargets: 0 }
                     ],
					  "aoColumns": [
                              {  "sName": "ID",
                                 "bSearchable": false,
                                 "bSortable": false,
                                 "bVisible": false
                                     },
                      { "sName": "product_name" },
                      { "sName": "date" },
					  {  "sName": "time_slots",
                                 "bSortable": false,
                     }
                   ,
                      { "sName": "TotalCount", "sType": "num-html", "aTargets": [5]},
					  { "sName": "available_count",type: 'num-html'}
                     ]
         }).makeEditable({
        	    "aoColumns": [
				               null,
        	                  null,
        	                  null,//null for read-only columns
        	                  null,
        	                  null,
        	                  null//null for read-only columns
        	                     ]
        	              });


				 $("#companies_filter input").autocompleteArray(
					[
					"Black berry Z10",
					"Blackberry bold",
					"cheema",
					"iPhone 3G",
					"iPhone 3GS",
					"iPhone 4",
					"iPhone 4s",
					"iPhone 5",
					"iPhone 5 C",
					"iPhone 5s",
					"iPhone 6",
					"iPhone 6 plus",
					"iPhone 6 s",
					"Nokia 700",
					"Nokia 808",
					"Nokia 8210",
					"Nokia E7",
					"Nokia Lumia 1020",
					"Nokia Lumia 610",
					"Nokia Lumia 810",
					"Nokia Lumia 925",
					"Nokia Lumia 928",
					"Phone 1st Generation",
					"Samsung Galaxy Note Edge",
					"Samsung Galaxy Note II ",
					"Samsung Galaxy S",
					"Samsung Galaxy S 3",
					"Samsung Galaxy S 4",
					"Samsung Galaxy S 5",
					"Samsung Galaxy S 6",
					"Samsung Nexus S",
					"Samsung Stratosphere II ",
					"Sony Xperia",
					"Sony Xperia",
					"Sony Xperia Arc S ",
					"Sony Xperia L",
					"Sony Xperia Play",
					"Sony Xperia SP",
					"Sony Xperia X10"
					],
					{
					delay:10,
					minChars:1,
					matchSubset:1,
					onItemSelect:selectItem,
                    onFindValue:findValue,
					autoFill:true,
					maxItemsToShow:10
					}
					);
                   function selectItem(li) {
					$('#companies_filter input').trigger("blur");
					$('#companies_filter input').trigger("keydown");
					$('#companies_filter input').trigger("keyup");
					$('#companies_filter input').trigger("keypress");
				
					
						if( li == null ) return alert("No match!");
						
                     };
				   function findValue(li) {
						if( li == null ) return alert("No match!");
					
                   };


				   function isDST(t) { //t is the date object to check, returns true if daylight saving time is in effect.
						var jan = new Date(t.getFullYear(),0,1);
						var jul = new Date(t.getFullYear(),6,1);
						return Math.min(jan.getTimezoneOffset(),jul.getTimezoneOffset()) == t.getTimezoneOffset();  
					}
					if(isDST(new Date()))
			     {
				    $("select[name='timeZone']").append('<option value="AST">Atlantic Time </option>');
					$("select[name='timeZone']").append('<option value="America/New_York">Eastern Time </option>');
					$("select[name='timeZone']").append('<option value="America/Chicago">Central Time </option>');
					$("select[name='timeZone']").append('<option value="America/Denver">Mountain Time </option>');
					$("select[name='timeZone']").append('<option value="America/Los_Angeles">Pacific Time </option>');

				 }
				 else
			     {
				        $("select[name='timeZone']").append('<option value="AST">Atlantic Time </option>');
						$("select[name='timeZone']").append('<option value="America/New_York">Eastern Time </option>');
						$("select[name='timeZone']").append('<option value="America/Chicago">Central Time </option>');
						$("select[name='timeZone']").append('<option value="America/Denver">Mountain Time </option>');
						$("select[name='timeZone']").append('<option value="America/Los_Angeles">Pacific Time </option>');


				 }


                 });


				  

        </script>
    </head>
    <body id="dt_example">
	<div class="header">
		   <div class="col-sm-10 header-left">
					 <div class="logo">
						<a href="index.html"><img src="images/logo.png" alt=""/></a>
					 </div>
					 <div class="menu">
						  <a class="toggleMenu" href="#"><img src="images/nav.png" alt="" /></a>
						    <ul class="nav" id="nav">
                              <li class="active"><a href="productcatalogueAdmin">Product Catalogue Admin</a></li>
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
                                <option value="0">My Profile</option>
                                <option value="1">Log Out</option>
                            </select>
                        </div>

                    </div>
		                 <div class="clearfix"></div>
	                 </div>
	                <div class="clearfix"></div>
   </div>

        <div id="container">
            <div id="demo_jui">
            
    		
		        <table id="companies" class="display">
		            <thead>
		                <tr>
		                	<th>ID</th>
		                    <th>Product Name</th>
		                    <th>Date</th>
		                    <th>Time Slots</th>
		                    <th>Total Slots</th>
							<th>Free Slots</th>
		                </tr>
		                
		            </thead>
		            <tbody>
		          
		            </tbody>
		            <tfoot>
		            
		            <tr>
		                	<th colspan="3">&nbsp;</th>
		                    <th colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;<button id="btnAddNewRow" value="Ok" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" role="button">Add Appointment</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; <button id="btnDeleteRow" value="cancel" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" role="button">Delete Appointment</button> </th>
		                </tr>
		                <tfood>
		        </table>
		    </div>
            
            
            <form id="formAddNewRow" action="#" title="Add new Appointment">
			    <input type="hidden" id="id" name="id" value="-1" rel="0" />
			    <table ><tr><td>
			    Product Name</td><td>
				<select name="name"  id="name" class="required" rel="1">
				<option value="Black berry Z10">            Black berry Z10          </option>
				<option value="Blackberry bold">	       Blackberry bold          </option>
				<option value="cheema">			       cheema                   </option>
				<option value="iPhone 3G">		       iPhone 3G                </option>
				<option value="iPhone 3GS">		       iPhone 3GS               </option>
				<option value="iPhone 4">		       iPhone 4                 </option>
				<option value="iPhone 4s">		       iPhone 4s                </option>
				<option value="iPhone 5">		       iPhone 5                 </option>
				<option value="iPhone 5 C">		       iPhone 5 C               </option>
				<option value="iPhone 5s">		       iPhone 5s                </option>
				<option value="iPhone 6">		       iPhone 6                 </option>
				<option value="iPhone 6 plus">		       iPhone 6 plus            </option>
				<option value="iPhone 6 s">		       iPhone 6 s               </option>
				<option value="Nokia 700">		       Nokia 700                </option>
				<option value="Nokia 808">		       Nokia 808                </option>
				<option value="Nokia 8210">		       Nokia 8210               </option>
				<option value="Nokia E7">		       Nokia E7                 </option>
				<option value="Nokia Lumia 1020">	       Nokia Lumia 1020         </option>
				<option value="Nokia Lumia 610">	       Nokia Lumia 610          </option>
				<option value="Nokia Lumia 810">	       Nokia Lumia 810          </option>
				<option value="Nokia Lumia 925">	       Nokia Lumia 925          </option>
				<option value="Nokia Lumia 928">	       Nokia Lumia 928          </option>
				<option value="Phone 1st Generation">	       Phone 1st Generation     </option>
				<option value="Samsung Galaxy Note Edge">      Samsung Galaxy Note Edge </option>
				<option value="Samsung Galaxy Note II ">       Samsung Galaxy Note II   </option>
				<option value="Samsung Galaxy S">	       Samsung Galaxy S         </option>
				<option value="Samsung Galaxy S 3">	       Samsung Galaxy S 3       </option>
				<option value="Samsung Galaxy S 4">	       Samsung Galaxy S 4       </option>
				<option value="Samsung Galaxy S 5">	       Samsung Galaxy S 5       </option>
				<option value="Samsung Galaxy S 6">	       Samsung Galaxy S 6       </option>
				<option value="Samsung Nexus S">	       Samsung Nexus S          </option>
				<option value="Samsung Stratosphere II ">      Samsung Stratosphere II  </option>
				<option value="Sony Xperia">		       Sony Xperia              </option>
				<option value="Sony Xperia">		       Sony Xperia              </option>
				<option value="Sony Xperia Arc S ">	       Sony Xperia Arc S        </option>
				<option value="Sony Xperia L">		       Sony Xperia L            </option>
				<option value="Sony Xperia Play">	       Sony Xperia Play         </option>
				<option value="Sony Xperia SP">		       Sony Xperia SP           </option>
				<option value="Sony Xperia X10">	       Sony Xperia X10          </option>

				</select>
				</td></tr>
			   
	    <tr><td colspan=2>
			  
		<div id="alternateUiWidgetsExample">
		 <table>
			   <tr><td>
     Apointment Date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp</td><td> <input type="text" class="date start required " rel="2" name="date" id="datepicker"  /> 
  </td></tr>
	
  <tr><td>
    From Time &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp</td><td> <input type="text" class="time start required" rel="3" name="toTime"  />   </td></tr>
  <tr><td>  To Time &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp </td><td> <input type="text" class="time end required" rel="4" name="fromTime"/>
	 </td></tr></table>
</div>


  </td></tr>
  <tr><td>
	Time Zone &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp</td><td><select name="timeZone1" id='timeZone1' hidden="true" class="required"><option></option></select>
	 <select name="timeZone" id='timeZone' class="required">
	 <option></option>


	 </select>
  </td></tr>
  <tr><td>
	 No of Slots &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp</td><td><input type="text" name="count"  class="required" id="count" rel="5"/>
  </td></tr>
</table>
 
<!-- include input widgets; this is independent of Datepair.js -->
<link href="media/dataTables/pikaday.css" rel="stylesheet" type="text/css" />
<link href="media/dataTables/jquery.ptTimeSelect.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/bootstrap-datepicker.js"></script>
<script src="https://jonthornton.github.io/jquery-timepicker/jquery.timepicker.js"></script>
<script type="text/javascript" src="scripts/moments.js"></script>
<script type="text/javascript" src="scripts/pikaday.js"></script>
<script type="text/javascript" src="scripts/jquery.ptTimeSelect.js"></script>
 <script type="text/javascript" src="scripts/timezones.full.js"></script>



<script type="text/javascript" src="scripts/jquery.datepair.js"></script>
<script type="text/javascript" src="scripts/datepair.js"></script>


<script>
  $('#timeZone1').timezones();
    // initialize input widgets
    // ptTimeSelect doesn't trigger change event by default
    $('#alternateUiWidgetsExample .time').ptTimeSelect({
        'onClose': function($self) {
            $self.trigger('change');
        }
    });

    $('#alternateUiWidgetsExample .date').pikaday({
        field: document.getElementById('datepicker'),
        trigger: document.getElementById('datepicker-button'),
        minDate: new Date(),
        maxDate: new Date(new Date().getTime()+(56*24*60*60*1000)),
        yearRange: [2010,2020],
		format:'MM/DD/YYYY'
    });

    var TIMEFORMAT = 'hh:mm A';
    var alternateUiWidgetsExampleEl = document.getElementById('alternateUiWidgetsExample');
    var alternateWidgetsDatepair = new Datepair(alternateUiWidgetsExampleEl, {
        parseTime: function(input){
            // use moment.js to parse time
            var m = moment(input.value, TIMEFORMAT);
            return m.toDate();
        },
        updateTime: function(input, dateObj){
            var m = moment(dateObj);
            input.value = m.format(TIMEFORMAT);
        },
        parseDate: function(input){
          var picker = $(input).data('pikaday');
            return picker.getDate();
        },
        updateDate: function(input, dateObj){
            var picker = $(input).data('pikaday');
		     return picker.setDate(dateObj,true);
        }
    });
</script> 
            
			</form>

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

    </body>
</html>


