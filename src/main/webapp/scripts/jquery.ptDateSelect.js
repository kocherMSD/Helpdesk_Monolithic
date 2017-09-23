/***********************************************************************
 * FILE: jquery.ptDateSelect.js
 *
 * 		jQuery plugin for displaying a popup that allows a user
 * 		to select a date and set that date back to a form's input
 * 		field.
 *
 *
 * AUTHOR:
 *
 * 		*Paul T.*
 *
 * 		- <http://sourceforge.net/projects/ptdateselect>
 * 		- <http://www.purtuga.com>
 *
 *
 * DEPENDECIES:
 *
 * 		-	jQuery.js
 * 			<http://docs.jquery.com/Downloading_jQuery>
 *
 * 		- 	dimensions.js
 * 			<http://docs.jquery.com/Plugins>
 *
 *
 * LICENSE:
 *
 * 		Copyright (c) 2007 Paul T. (purtuga.com)
 *		Dual licensed under the:
 *
 * 		-	MIT
 * 			<http://www.opensource.org/licenses/mit-license.php>
 *
 * 		-	GPL
 * 			<http://www.opensource.org/licenses/gpl-license.php>
 *
 *
 * INSTALLATION:
 *
 * 		This file <jquery.ptDateSelect.js> is the only one required.
 * 		To install, simply copy it to the same directory as jquery.js
 * 		and include it in the html pages requiring it's functionality.
 *
 *
 * 		REMINDER
 *
 * 			This plugin requires the dimension.js plugin.
 *
 *
 * EXAMPLES:
 *
 * 		- Default look
 *
 * 		(start code)
 *
 * 		$(".dateFields").ptDateSelect();
 *
 * 		(end code)
 *
 * 		- Globaly change labels of weekdays and includes custom classes
 *
 * |		jQuery.ptDateSelect.labels.days = [
 * |								'Sunday',
 * |								'Monday',
 * |								'Tuesday',
 * |								'Wednesday',
 * |								'Thursday',
 * |								'Friday',
 * |								'Saturday' ];
 * |		jQuery.ptDateSelect.css.days = 'dtNorm';
 * |		jQuery.ptDateSelectcss.next = 'dtNext';
 * |
 * |		$('.dateFields').ptDateSelect();
 *
 *
 * LAST UPDATED:
 *
 * 		- $Date: 2007/04/02 16:52:40 $
 * 		- $Author: paulinho4u $
 * 		- $Revision: 1.2 $
 *
 *
 **********************************************************************/

/***********************************************************************
 * METHOD: $(ele).ptDateSelect()
 * 		Inserts a link next to each matched element (ele) that when
 * 		clicked will display a popup calendar that allows the user to
 * 		select a date. The selected date will then be written to the
 * 		form's input element.
 *
 *
 * PARAMS:
 *
 * 		opt -	[object] An object with any of the options as defined by
 * 				<JQuery.ptDateSelectInit()>.
 *
 *
 * RETURNS:
 *
 * 		- [object] jQuery
 *
 *
 * EXAMPLE:
 *
 * |		$('.dateInputs').ptDateSelect();
 * |
 * |		//Example with custom setup
 * |		var myOpt = {
 * |				labels: {
 * |						x: '[X]',
 * |						n: '[>>]',
 * |						p: '[<<]',
 * |						days: [
 * |								'Sunday',
 * |								'Monday',
 * |								'Tuesday',
 * |								'Wednesday',
 * |								'Thursday',
 * |								'Friday',
 * |								'Saturday' ]
 * |				},
 * |				css: {
 * |						selected: 'daySel',
 * |						days: 'dayNorm'
 * |				}
 * |		};
 * |		$('.dateInputs').ptDateSelect(myOpt);
 *
 *
 */
jQuery.fn.ptDateSelect = function(opt) {
	console.debug('entering' + this)
	this.each(
		function(){
			if(this.nodeName.toLowerCase() != 'input') return;
			jQuery.ptDateSelect._setSelector(this, opt);
			return this;
	}	);
};/* End of jQuery.fn.timeSelect */

/***********************************************************************
 * FUNCTION: JQuery.ptDateSelectInit()
 * 		Object initialization for DateSelect plugin.  Function sets up
 * 		the jQuery.ptDateSelect object with the following:
 * 
 * 
 * 		bgcolor			-	[string] Color for the <div> container 
 * 							(id=ptDateSelectCntr) that holds the popup
 * 							calendar. Default is white (#ffffff)
 * 
 * 		labels.x		-	[string] Label for the close link of the popup
 * 						  	calendar element. Default is '[Close]'.
 * 							The value defined in this label will be wrapped
 * 							with the <a> html link, thus it can be set to an
 * 							<img> as well.
 *
 * 		labels.p		-	[string] Label for the Previous link. Default is
 * 							[Prev.].
 * 							The value defined in this label will be wrapped
 * 							with the <a> html link, thus it can be set to an
 * 							<img> as well.
 *
 * 		labels.n		-	[string] Label for the Next link. Default is [next].
 * 							The value defined in this label will be wrapped
 * 							with the <a> html link, thus it can be set to an
 * 							<img> as well.
 *
 * 		labels.months[]	- 	[array] An array of 12 elements (0 though 11) with the
 * 							labels for each of the months. Defaults are 0=January,
 * 							1=February, 2=March, 3=April, 4=May, 5=June, 6=July,
 * 							7=August, 8=September, 9=October, 10=November,
 * 							11=December
 *
 * 		labels.days[]	-	[array] An array of 7 elements (0 though 6) with the
 * 							labels for the weekdays. Defaults are 0=Su, 1=Mo, 2=Te
 * 							3=We, 4=Tu, 5=Fr, 6=Sa.
 *
 * 		labels.calPopup	-	[string]Label for the link that is inserted into the html
 * 							document, next to input field.
 * 							The value defined in this label will be wrapped
 * 							with the <a> html link, thus it can be set to an
 * 							<img> as well.
 *
 * 		css.cntr		-	[string] Class name to be associated with the overall
 * 							popup <div> container.
 *
 * 		css.month		-	[string] Class name to be associated with the html <table>
 * 							element that holds the entire calendar (including name,
 * 							days and prev./next links.
 *
 * 		css.days		-	[string] Class name to be associated with the individual
 * 							days (<td> html tag) of the month.
 *
 * 		css.selected	-	[string] Class name to be asociated with the <td> element
 * 							that holds the selected day.
 *
 * 		css.week		-	[string] Class name to be associated with the table row
 * 							(<tr>) for each week of the month.
 *
 * 		css.monthName	-	[string] Class name to be associated with the table header
 * 							element (<th>) that holds the name of the month.
 *
 * 		css.next		-	[string] Class name to be associated with the table column
 * 							(<td>) that holds the next link.
 *
 * 		css.prev		-	[string] Class name to be associated with the table column
 * 							(<td>) that holds the previous link.
 *
 * 		css.close		-	[string] Class name to be asociated with the <div> element
 * 							That holds the close link.
 *
 *
 * 		The following are also set, but should not be manipulated.
 * 		These are used internally by ptDateSelect.
 *
 * 		_counter		-	[int] Interger that is used when generating the division
 * 							ids around each <input> element.
 *
 * 		_dtCntr			-	[jQuery] jQuery element that points to the ptDateSelect
 * 							container.
 *
 * 		_currEle		-	[object] The <input> element for wich the popup calender
 * 							is currently opened for.
 *
 * 		_eleOpt			-	[object] Object that stores the options for each of the
 * 							dateSelect applied to the page.
 *
 * PARAMS:
 *
 * 		- none
 *
 *
 * RETURNS:
 *
 * 		- nothing
 *
 *
 * EXAMPLE:
 *
 * 		Plugin options can be accessed via jQuery.ptDateSelect
 *
 * |		jQuery.ptDateSelect.css.next = "nextClass";
 * |		jQuery.ptDateSelect.labels.n = '<img src="/foward.png">';
 *
 *
 */
jQuery.ptDateSelectInit = function () {
	// don't break IE
	if (window.console == undefined) { window.console = {log:function(){}, debug:function(){}}; };

	jQuery.ptDateSelect = {
		_counter: 1,
		_dtCntr: null,
		_currEle: null,
		_eleOpt: {},
		bgcolor: '#ffffff',
		labels: {
				x:	'[Close]',
				n:	'[Next]',
				p:	'[Prev.]',
				calPopup: '[D]',
				months:	[
						'January',
						'February',
						'March',
						'April',
						'May',
						'June',
						'July',
						'August',
						'September',
						'October',
						'November',
						'December'
				],
				days: [
						'Su',
						'Mo',
						'Tu',
						'We',
						'Th',
						'Fr',
						'Sa'
				]
		},
		css: {
				cntr: '',
				month: '',
				days: '',
				week: '',
				monthName: '',
				next: '',
				prev: '',
				close: ''
		}
	};

	//if the html is not yet created in the document, then do it now
	if (!jQuery('#ptDateSelectCntr').length) {
		jQuery(document).ready(
			function() {
				var htmlCntr =
						'<div id="ptDateSelectCntr" style="padding: 5px; z-index: 10;'
					+	'position: absolute; display: none; border: 1px solid #000000; '
					+	'left: 10px; top: 10px; width: 250px; '
					+	'height: 280px; overflow: hidden;" class="'
					+	jQuery.ptDateSelect.css.cntr
					+	'"><div id="ptDateSelectClose" style="text-align: right;" class="'
					+	jQuery.ptDateSelect.css.close
					+	'"><a href="'
					+	'javascript:void(0);" onclick="jQuery.ptDateSelect.hide();">'
					+	jQuery.ptDateSelect.labels.x
					+	'</a></div><div id="ptDateSelectMonth" style="margin-top: 5px; align: center;"></div>'
					+	'<!--[if lte IE 6.5]><iframe style="display:block; position:absolute;top: 0;left:0;z-index:-1; filter:Alpha(Opacity=\'0\');width:3000px;height:3000px"></iframe><![endif]-->'
					+	'</div>';
				jQuery("body").append(htmlCntr);
				jQuery.ptDateSelect._dtCntr = jQuery('div#ptDateSelectCntr');
		}	);
	} else {
		jQuery.ptDateSelect._dtCntr = jQuery('div#ptDateSelectCntr');
	}

}();/* end ptDateSElectInit() */

/**
 * FUNCTION: jQuery.ptDateSelect.show()
 * 		Method makes the date popup visible on the screen. The popup
 * 		is first positioned next to the input element.
 *
 *
 * PARAMS:
 *
 * 		uId -	[string] The ID of the <div> element that was wrapped
 * 				around the input form elemnt. this was inserted when
 * 				$(...).ptDateSelect() was initially called.
 *
 * RETURNS:
 *
 * 		ele - [object]
 *
 */
jQuery.ptDateSelect.show = function (uId) {
	var ele		= jQuery('#' + uId + '>input');
	var tCntr	= jQuery.ptDateSelect._dtCntr;
	var offset	= jQuery(ele).offset();
	var opt		= (jQuery.ptDateSelect._eleOpt[uId] || jQuery.ptDateSelect);
	
	offset.left	+= jQuery(ele).width();

	//if IE, then offset some... bad ie (as usual)  :(
	if (jQuery.browser.msie) {
		offset.top	-= 12;
		offset.left	-= 12;
	}

	// Save the current element for wich the popup will be displayed.
	jQuery.ptDateSelect._currEle = ele;

	//set the month to display
	jQuery.ptDateSelect.defineCal('',uId);

	tCntr.background(opt.bgcolor);
	
	// update the close link text for this instance of dateSelect
	jQuery('#ptDateSelectClose>a',tCntr).empty()
					.append( jQuery.ptDateSelect.getLabel('x', uId) );

	// display the popup and store the current element
	tCntr.css({left: offset.left + 'px', top: offset.top + 'px'}).slideDown('slow');

	return ele;

};/* end jQuery.ptDateSelect.show() */

/**
 * FUNCTION: jQuery.ptDateSelect.getLabel()
 * 		Returns a label requested by caller.
 *
 * PARAMS:
 *
 * 		lbl	-	[string] Required. Label token
 * 		uId	-	[string] Optional. Unique id of current dateSelect instance.
 *
 * RETURNS:
 *
 * 		- [string] Label requested.
 *
 */
jQuery.ptDateSelect.getLabel = function (lbl, uId) {
	if (!lbl) {return;};
	var self = jQuery.ptDateSelect;
	if (	self._eleOpt[uId]
		&&	self._eleOpt[uId].labels
		&&	self._eleOpt[uId].labels[lbl]
	) {
		if (
				(lbl == 'days' && !self._eleOpt[uId].labels[lbl].length)
			||	(lbl == 'months' && !self._eleOpt[uId].labels[lbl].length)
		) {
			return self.labels[lbl];
		} else {
			return self._eleOpt[uId].labels[lbl];
		}
	} else {
		return self.labels[lbl];
	};
}/* end jQuery.ptDateSelect.getLabel */

/**
 * FUNCTION: jQuery.ptDateSelect.hide()
 * 		Hides the calendar popup and nulls out the
 * 		current elemnt stored in the ptDateSelect variable.
 *
 * PARAMS:
 *
 * 		- none
 *
 * RETURNS:
 *
 * 		- nothing
 *
 */
jQuery.ptDateSelect.hide = function () {
	jQuery.ptDateSelect._dtCntr.slideUp("fast");
	jQuery.ptDateSelect._currEle = null;
};/* end jQuery.ptDateSelect.hide() */


/**
 * FUNCTION: jQuery.ptDateSelect.setDate
 * 		Sets the date that the user clicked on to the input element
 * 		corresponding to the open popup
 *
 * PARAMS:
 * 		dtStr - Date string to be set
 *
 * RETURNS:
 *
 * 		- nothing
 *
 *
 */
jQuery.ptDateSelect.setDate = function (dtStr) {
	jQuery(jQuery.ptDateSelect._currEle).val(dtStr);
	jQuery.ptDateSelect.hide();
};/* end jQuery.ptDateSelect.setDate() */

/**
 * FUNCTION: jQuery.ptDateSelect._getFmtDate()
 * 		Given a js date object, this method returns a date string formated
 * 		as specified by the user format.
 *
 * PARAMS:
 * 		dtObj	- [object] Date() object.
 *
 *
 * RETURNS:
 *
 * 		date - [string] date string
 *
 */
jQuery.ptDateSelect._getFmtDate = function (dtObj) {
	if (!dtObj) {return;};
	var day		= dtObj.getDate();
	var mon		= (dtObj.getMonth() + 1);
	var year	= dtObj.getFullYear();
	var del		= '/';
	return mon + del + day + del + year;
}/* jQuery.ptDateSelect._getFmtDate */

/**
 * FUNCTION: jQuery.ptDateSelect.defineCal(dt)
 * 		Defines an html table with the monthly calendar in it and
 * 		writes that to the popup calendar container.
 *
 * PARAMS:
 *
 * 		dt	-	[string] The date to display. This value will
 * 				define what month will be highlighted and which
 * 				day. If null, it will attempt to get the date currently
 * 				set in the associated input field. If one is not defined
 * 				then the current month is displayed but no date is
 * 				hightlighted.
 *
 * 		uId	-	[string] The unique id of the input element's container.
 *
 * RETURNS:
 *
 * 		- nothing
 *
 *
 */
jQuery.ptDateSelect.defineCal = function (dt, uId) {

	var dtObj;
	var opt = (jQuery.ptDateSelect._eleOpt[uId] || jQuery.ptDateSelect);

	// if a date was passed in, then create a date object from it.
	if (dt) {
 		dtObj = new Date(dt);

	// ELSE IF the date is false, but a date is currently defined in the input
	// field, then create a Date object from it.
	} else if (!dt && jQuery(jQuery.ptDateSelect._currEle).val()) {
		dtObj = new Date(jQuery(jQuery.ptDateSelect._currEle).val());
		
		// If date object is not valid (date in input was bad), then
		// just get today's date.
		if (!dtObj.getDate()) {
			dtObj = new Date();
		}
		
	// ELSE, just define a date based on today
	} else {
		dtObj = new Date();
	}

	var dSel	= (dt ? dtObj.getDate() : 0);
	var dLast	= (new Date(dtObj.getFullYear(), dtObj.getMonth()+1, 0)).getDate();
	var c		= 0; //column count (0 - 6 for 7 days)
	var d		= 0; // day count.
	var done	= false;
	var calHtml	=
			'<table id="ptDateSelectMonthTbl" align="center" border="1"'
		+	(		opt.css.month
				?	' class="' + opt.css.month + '" '
				:	''
			)
		+	'cellpadding="0" cellspacing="0" width="">'
		+	'<tr><th colspan="7" align="center" id="ptDateSelectMonthName"'
		+	(		opt.css.monthName
				?	' class="' + opt.css.monthName + '" '
				:	''
			)
		+	'>'
		+	jQuery.ptDateSelect.getLabel('months')[dtObj.getMonth()]
		+	' ' + dtObj.getFullYear()
		+	'</th><tr>';

	// Add the day headings to the html
	for (var i=0; i<jQuery.ptDateSelect.getLabel('days', uId).length; i++) {
		calHtml += '<th>' + jQuery.ptDateSelect.getLabel('days', uId)[i] + '</th>'
	};
	calHtml += '</tr>';

	//Ajust the date to the first day of the month
	dtObj.setDate(1);

	// Loop until calendar is done.
	while (!done && d < 60) {
		d++;
		//if we reached #7, then reset it and end row.
		if (c > 6) {c = 0; calHtml += '</tr>'; };

		//if we're at column 0, then start the row
		if (c == 0) {
			calHtml += '<tr'
				+	(		opt.css.week
						?	' class="' + opt.css.week + '" '
						:	''
					)
				+	'>';
		};

		//start the column for this day and add the class(es) to it.
		//Selected class is only added if the day is the same as the one requested.
		// TODO: need to suppress the class tag if no class is defined.
		calHtml += '<td align="center" class="'
				+	(		dtObj.getDay() == c	&&	dtObj.getDay() == dSel
						?	( ' ' + opt.css.selected )
						:	''	)
				+	'">';

		// if the current day of week is the same as the column
		// being processed, then insert the date into the column
		if (dtObj.getDay() == c) {
			calHtml +=
					'<a href="javascript:void(0);" onclick="jQuery.ptDateSelect.setDate(\''
				+	jQuery.ptDateSelect._getFmtDate(dtObj)
				+	'\');">'
				+	dtObj.getDate()
				+	'</a></td>';

			// Increment the date. If the current date + 1 is larger
			// than the last day of month, then we're working on the
			// the last day now. Null out the object (breaks loop)
			if ((dtObj.getDate() + 1) > dLast) {
				done = true;

				//increment column here to see if all were created
				c++;

				// if c is less then 7, then finish up the row
				while (c < 7) {
					calHtml += '<td'
							+	(	opt.css.days
									?	' class="' + opt.css.days + '" '
									:	''
								)
							+	'>&nbsp</td>';
					c++;
				}

				// End the row, since we're not comming back to the loop
				calHtml += '</tr>';

			//ELSE, just increment the day
			} else {
				dtObj.setDate(dtObj.getDate() + 1);
			}

		// else, day in dt obj not same as current column day of week.
		// just leave it blank.
		} else {
			calHtml += '&nbsp;</td>';
		}

		//increament the column
		c++;

	}//end while loop

	// insert the prev/next links at the bottom.
	calHtml +=
			'<tr><td colspan="7"><table border="0" width="100%"><tr><td align="left"'
		+	' id="ptDateSelectPrev" class="'
		+	opt.css.prev
		+	'"><a href="javascript:void(0);" onclick="jQuery.ptDateSelect.defineCal(\''
		+	(dtObj.getMonth() == 0
				?	(new Date(dtObj.getFullYear()-1, 11, 1)).toDateString()
				:	(new Date(dtObj.getFullYear(), dtObj.getMonth()-1, 1)).toDateString() )
		+	'\', \'' + uId + '\')">'
		+	jQuery.ptDateSelect.getLabel('p', uId)
		+	'</td><td align="right" id="ptDateSelectNext" class="'
		+	opt.css.next
		+	'"><a href="javascript:void(0);" onclick="'
		+	'jQuery.ptDateSelect.defineCal(\''
		+	(new Date(dtObj.getFullYear(), dtObj.getMonth()+1, 1)).toDateString()
		+	'\', \'' + uId + '\')">'
		+	jQuery.ptDateSelect.getLabel('n', uId)
		+	'</a></td</tr></table></td></tr></table>';

	//insert the month into the container
	jQuery('div#ptDateSelectMonth', jQuery.ptDateSelect._dtCntr).empty();
	jQuery('div#ptDateSelectMonth', jQuery.ptDateSelect._dtCntr).append(calHtml);

};/* end jQuery.ptDateSelect.defineCal() */

/**
 * FUNCTION: jQuery.ptDateSelect._setSelector()
 * 		Method that creates the link next to the input fields, which when
 * 		clicked, displays the popup with  the calendar. This method is
 * 		called from the ptDateSelect iterator.
 *
 *
 * PARAMS:
 *
 * 		ele	-	[object] The input element that is being worked on.
 *
 * 		opt -	[object] An object with any of the options as defined by
 * 				<JQuery.ptDateSelectInit()>.
 *
 *
 * RETURNS:
 *
 * 		- nothing
 *
 */
jQuery.ptDateSelect._setSelector = function (ele, opt) {
	//Define a unique id and increment global counter var
	var uId = 'ptDateSelect_'  + jQuery.ptDateSelect._counter;
	jQuery.ptDateSelect._counter += 1;

	jQuery.ptDateSelect._setSelectorOpt(uId, opt);

	//Wrap the input field in a <div> element with
	// a unique id for later referencing.
	jQuery(ele).wrap('<div style="display: inline;" id="' + uId + '"></div>' );

	//insert the link to popup the calendar
	jQuery(
			'<a href="javascript:void(0);" onclick="jQuery.ptDateSelect.show(\''
		+	uId
		+	'\');">'
		+	jQuery.ptDateSelect.getLabel('calPopup',uId)
		+	'</a>').appendTo(jQuery('div#' + uId));


};/* end jQuery.ptDateSelect._setSelector() */

/**
 * FUNCTION: jQuery.ptDateSelect._setSelectorOpt()
 * 		Method to set the options for the current element being
 * 		setup.
 *
 *
 * PARAMS:
 *
 * 		uId -	[string] The unique id of the <div> for the dateSelect popup.
 * 		opt -	[object] An object with the options
 *
 *
 * RETURNS:
 *
 * 		- none
 *
 */
jQuery.ptDateSelect._setSelectorOpt = function (uId, opt) {
	if (!uId || !opt) {return;};
	jQuery.ptDateSelect._eleOpt[uId] = opt;
	if (!jQuery.ptDateSelect._eleOpt[uId].labels) {
		jQuery.ptDateSelect._eleOpt[uId].labels = {};
	}
	if (!jQuery.ptDateSelect._eleOpt[uId].labels.days) {
		jQuery.ptDateSelect._eleOpt[uId].labels.days = [];
	}
	if (!jQuery.ptDateSelect._eleOpt[uId].labels.months) {
		jQuery.ptDateSelect._eleOpt[uId].labels.months = [];
	}
	if (!jQuery.ptDateSelect._eleOpt[uId].css) {
		jQuery.ptDateSelect._eleOpt[uId].css = {};
	}
}/* end jQuery.ptDateSelect._setSelectorOpt() */

/****************************************************************************
 * 				ADDITIONAL DOCUMENTATION
 * **************************************************************************
 * GROUP: HTML Wrapped Around Input Fields
 * 		The follwoing code is wrapped around each of the matched input fields
 * 
 * (start code)
 * 		<div id="ptDateSelct-#" style="display: inline;"><input/></div>
 * (end code)
 * 
 * 
 * GROUP: HTML Popup Created
 * 		Below is the html writen to the DOM by this plugin. This code is
 * 		written only once and used for all date selections.
 *
 * (start code)
 *
 * <div class=""
 * 		style="border: 1px solid rgb(0, 0, 0); padding: 5px; overflow: visible;
 * 			z-index: 10; position: absolute; display: block; left: 159px;
 * 			top: 142px; background-color: rgb(204, 204, 204); width: 200px; height: 280px;"
 * 		id="ptDateSelectCntr">
 * 	<div class=""
 * 			style="text-align: right;" id="ptDateSelectClose">
 * 		<a onclick="jQuery.ptDateSelect.hide();" href="javascript:void(0);">[Close]</a>
 * 	</div>
 * 	<div style="margin-top: 5px;" id="ptDateSelectMonth">
 * 	<table cellspacing="0" cellpadding="2" border="1" align="center"
 * 		id="ptDateSelectMonthTbl">
 * 		<tbody>
 * 			<tr>
 * 				<th align="center" class="" id="ptDateSelectMonthName" colspan="7">October 2006</th>
 * 			</tr>
 * 			<tr>
 * 				<th>Su</th>
 * 				<th>Mo</th>
 * 				<th>Tu</th>
 * 				<th>We</th>
 * 				<th>Th</th>
 * 				<th>Fr</th>
 * 				<th>Sa</th>
 * 			</tr>
 * 			<tr class="">
 * 				<td align="center" class="">
 * 					<a href="javascript:void(0);">1</a>
 * 				</td>
 * 				<td align="center" class="">
 * 					<a href="javascript:void(0);">2</a>
 * 				</td>
 * 				<td align="center" class="">
 * 					<a href="javascript:void(0);">3</a>
 * 				</td>
 * 				<td align="center" class="">
 * 					<a href="javascript:void(0);">4</a>
 * 				</td>
 * 				<td align="center" class="">
 * 					<a href="javascript:void(0);">5</a>
 * 				</td>
 * 				<td align="center" class="">
 * 					<a href="javascript:void(0);">6</a>
 * 				</td>
 * 				<td align="center" class="">
 * 					<a href="javascript:void(0);">7</a>
 * 				</td>
 * 			</tr>
 * 			<tr class="">
 * 				<td align="center" class="">
 * 					<a href="javascript:void(0);">8</a>
 * 				</td>
 * 				<td align="center" class="">
 * 					<a href="javascript:void(0);">9</a>
 * 				</td>
 * 				<td align="center" class="">
 * 					<a href="javascript:void(0);">10</a>
 * 				</td>
 * 				<td align="center" class="">
 * 					<a href="javascript:void(0);">11</a>
 * 				</td>
 * 				<td align="center" class="">
 * 					<a href="javascript:void(0);">12</a>
 * 				</td>
 * 				<td align="center" class="">
 * 					<a href="javascript:void(0);">13</a>
 * 				</td>
 * 				<td align="center" class="">
 * 					<a href="javascript:void(0);">14</a>
 * 				</td>
 * 			</tr>
 * 			...
 * 			<tr>
 * 				<td colspan="7">
 * 				<table width="100%" border="0">
 * 					<tbody>
 * 						<tr>
 * 							<td align="left" class="" id="ptDateSelectPrev">
 * 								<a href="javascript:void(0);">[Prev.]</a>
 * 							</td>
 * 							<td align="right" class="" id="ptDateSelectNext">
 * 								<a href="javascript:void(0);">[Next]</a>
 * 							</td>
 * 						</tr>
 * 					</tbody>
 * 				</table>
 * 				</td>
 * 			</tr>
 * 		</tbody>
 * 	</table>
 * 	</div>
 * 	<!--[if lte IE 6.5]><iframe style="display:block; position:absolute;top: 0;left:0;z-index:-1; filter:Alpha(Opacity='0');width:3000px;height:3000px"></iframe><![endif]-->
 * </div>
 *
 * (end code)
 *
 */

