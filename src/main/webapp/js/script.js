$(function(){
	
	$(window).load(function(){
		var ww=$(window).innerWidth();
		var wh=$(".wrapper").height();
		var fh=$("footer").height();
				
		/*if(ww<=700){
			$(".login_register_info").css({"height":(wh+fh)});
		}*/
	});	
	
	/*$(window).scroll(function() {
		  if( $(this).scrollTop() >= 100 ) {
			$(".header_banner_info header").addClass("fixed");
		  } else {
			$(".header_banner_info header").removeClass("fixed");
		  }
	});*/
				
	$('.banner_slider').bxSlider({
		pager: false,
		useCSS: false,
		speed: 1000,
		pause: 5000,
		auto: true
	});
	
	$('.cart_close').click(function(){
		$(".shopping_dropdown").slideUp();
		$("body").removeClass("mobileoverflow_hidde");
	});
	
	$('.testimonials_slider').bxSlider({
		pager: false,
		auto: true
	});	
	
	$('#horizontalTab, #horizontalTab2').easyResponsiveTabs({
		type: 'default', //Types: default, vertical, accordion           
		width: 'auto', //auto or any width like 600px
		fit: true,   // 100% fit in a container
		closed: 'accordion', // Start closed if in accordion view
		activate: function(event) { // Callback function if tab is switched
			var $tab = $(this);
			var $info = $('#tabInfo');
			var $name = $('span', $info);	
			$name.text($tab.text());	
			$info.show();
		}
	});	
	
	$(".header_banner_info header .profile_campaign_list .profile_campaign_listcont .profile_list").click(function(e){
		e.stopPropagation();
		$(".header_banner_info header .profile_campaign_list .profile_campaign_listcont .profile_dropdown").slideToggle();
		$(".shopping_dropdown").hide();	
		$("body").removeClass("mobileoverflow_hidde");			
	});
	
	$(".header_banner_info header .profile_campaign_list .profile_campaign_listcont .profile_dropdown, .search_address").click(function(e){
		e.stopPropagation();
	});	
	
	$(".header_banner_info header .profile_campaign_list .shopping_list .shopping_list2").click(function(e){
		e.stopPropagation();
		$(".shopping_dropdown").slideToggle();
		$(".header_banner_info header .profile_campaign_list .profile_campaign_listcont .profile_dropdown").hide();
		$("body").toggleClass("mobileoverflow_hidde");		
	});
	
	$(".shopping_dropdown, .login_register_info").click(function(e){
		e.stopPropagation();
	});	
	
	$(".shopping_dropdown ul li .product_img img").click(function(){
			$('#storedetail_modal').modal('show');
	});
	
	$(".shopping_dropdown ul li .product_name a").click(function(){
		$('#storedetail_modal').modal('show');	
	});
	
	$(document).click(function() {
    	$(".header_banner_info header .profile_campaign_list .profile_campaign_listcont .profile_dropdown, .shopping_dropdown").hide();
		$(".search_address").hide();
		$(".innerbanner_content h6").show();
		$("body").removeClass("mobileoverflow_hidde");
	});	
	
	$(".login_register_list .login_register_tabscont form ul li input, .delivery_address ul li input, .payment_details .payment_detailslist ul li input, .card_exp ul li input, .accounts_from ul li  input").focusout(function(e) {
		if($(this).val()==""){$(this).parents("li").removeClass("active");}
    });
	
	$(".login_register_list .login_register_tabscont form ul li input, .delivery_address ul li input, .payment_details .payment_detailslist ul li input, .card_exp ul li input, .accounts_from ul li  input").focusin(function(e) {
		$(this).parents("li").addClass("active");
    });
	
	$(".login_register_list .login_register_tabscont form ul li label, .delivery_address ul li label, .payment_details .payment_detailslist ul li label, .card_exp ul li label, .accounts_from ul li  label").click(function(){ 
		$(this).parents("li").addClass("active"); 
		$(this).parents("li").find("input").focus();
	});
	
	var lilen=$(".banner_content .banner_tabsinfo ul li.resp-tab-active").index();

	if(lilen==0){
		$(".banner_content .banner_tabsinfo ul .active_bg").css({"left":0});
	}
	else if(lilen==1){
		$(".banner_content .banner_tabsinfo ul .active_bg").css({"left":150});
	}
	else if(lilen==2){
		$(".banner_content .banner_tabsinfo ul .active_bg").css({"left":300});
	}	
	
	var ww2=$(window).innerWidth();
	
	$(".banner_content .banner_tabsinfo ul li").click(function(){
		var thisind=$(this).index();
		$(".banner_content .banner_tabsinfo ul li").removeClass("resp-tab-active");
		$(this).addClass("resp-tab-active");
		$(".banner_tabslist .resp-tabs-container .banner_tabslistcont").hide();
		if(thisind==0){
			if(ww2<440){$(".banner_content .banner_tabsinfo ul .active_bg").css({"left":0});}
			else if(ww2<600){$(".banner_content .banner_tabsinfo ul .active_bg").css({"left":0});}
			else{$(".banner_content .banner_tabsinfo ul .active_bg").css({"left":0});}
			$(".banner_tabslist .resp-tabs-container .banner_tabslistcont.banner_tabslistcont_1").show();
			}
		else if(thisind==1){
			if(ww2<440){$(".banner_content .banner_tabsinfo ul .active_bg").css({"left":80});}
			else if(ww2<600){$(".banner_content .banner_tabsinfo ul .active_bg").css({"left":110});}
			else{$(".banner_content .banner_tabsinfo ul .active_bg").css({"left":150});}
			$(".banner_tabslist .resp-tabs-container .banner_tabslistcont.banner_tabslistcont_2").show();
		}
		else if(thisind==2){
			if(ww2<440){$(".banner_content .banner_tabsinfo ul .active_bg").css({"left":160});}
			else if(ww2<600){$(".banner_content .banner_tabsinfo ul .active_bg").css({"left":220});}
			else{$(".banner_content .banner_tabsinfo ul .active_bg").css({"left":300});}
			$(".banner_tabslist .resp-tabs-container .banner_tabslistcont.banner_tabslistcont_3").show();
		}	
	});
	
	$(".login_register_list .login_register_listtabhead li").click(function(){
		var thisclass=$(this).attr("class");
		var thisindex=$(this).index();	
		if(thisclass!="resp-tab-active"){
			$(".login_register_list .login_register_listtabhead li").removeClass("resp-tab-active");
			$(this).addClass("resp-tab-active");
			if(thisindex==0){
				$(".login_register_list .resp-tabs-container .register_tabinfo").hide();
				$(".login_register_list .resp-tabs-container .login_tabinfo").show();
				}
				else if(thisindex==1){
					$(".login_register_list .resp-tabs-container .login_tabinfo").hide();
				$(".login_register_list .resp-tabs-container .register_tabinfo").show();
				
				}
		}
	});
	
	$(".spicinesslevel_btninfo .spicinesslevel_btn").click(function(){
		$(".spicinesslevel_btninfo .spicinesslevel_btn").removeClass("active");
		$(this).addClass("active");
	});
	
	$(".innerbanner_content h6 .edit_btn").click(function(e){	
	e.stopPropagation();	
		$(".search_address").show();
		$(this).parent("h6").hide();
		$(".search_address input[type='text']").focus();		
	});
	
	$(".shopping_dropdown ul li, .checkout_orderlist .checkout_orderlistcont ul li").on("click", ".addnote_img", function(){
		$(this).parents("li").find(".addnote_info").show();
		$(this).parents("li").find(".addnote_info input[type='text']").focus();
		$(this).css({"visibility": "hidden","height":0});
	});
	
	$(".shopping_dropdown ul li, .checkout_orderlist .checkout_orderlistcont ul li").on("click", ".addnote_info .cancle_btn", function(){
		//$(this).parents("li").find(".addnote_img").show();
		$(this).parents("li").find(".addnote_img").css({"visibility": "visible","height":"auto"});
		$(this).parents("li").find(".addnote_info").hide();
	});
	
	$(".optional_item span.checkbox_inp").click(function(){
		$(this).toggleClass("active");
	});
	
	$(".sortby li").click(function(){	
		$(".sortby li i").removeClass("fa-caret-down");
		$(".sortby li i").addClass("fa-caret-up");
		$(this).find("i").removeClass("fa-caret-up");
		$(this).find("i").addClass("fa-caret-down");			
	});
	
	$(".storedetail_cont").mCustomScrollbar({
		axis:"yx",
		scrollButtons:{enable:true},
		theme:"3d",
		scrollbarPosition:"outside"
	});
	
	$("#storedetail_modal").click(function(e){
		e.stopPropagation();
	});

});