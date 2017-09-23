/**
 * 
 */
package org.helpdesk.webservice.implementation;




import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import org.helpdesk.Utils.Constants;
import org.helpdesk.webservice.request.AppointmentAvailableDateRequest;
import org.helpdesk.webservice.request.AppointmentAvailableTimeSlotRequest;
import org.helpdesk.webservice.request.AppointmentRequest;
import org.helpdesk.webservice.response.AppointmentAvailableDateResponse;
import org.helpdesk.webservice.response.AppointmentAvailableTimeSlotResponse;
import org.helpdesk.webservice.response.AppointmentResponse;
import org.helpdesk.webservice.support.AppointmentServiceHelper;
import org.springframework.stereotype.Component;


/**
 * @author Anuj Singh
 *  Endpoint implementation to retrieve available appointment
 *         dates and time slots for an user
 */

@Component
@Path("/AppointmentService")
public class AppointmentServiceImpl  {

	
	AppointmentServiceHelper helper =null;
	
	@POST
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/json"})
	@Path("/getAvailableTimeSlots/")
	public AppointmentAvailableTimeSlotResponse getAvailableTimeSlots(@Context HttpHeaders headers,
			AppointmentAvailableTimeSlotRequest Request) {
		// TODO Auto-generated method stub
		AppointmentAvailableTimeSlotResponse response = new AppointmentAvailableTimeSlotResponse();
		response.setTimeSlots(helper.getTimeSlots(Request.getPid(),Request.getDate(),Request.getClientTimeZone()));
	//	response.setTimeSlots(buildDummyTimeSlots());
		response.setResponseStatus(Constants.SUCCESS);
		return response;
	}

	@POST
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/json"})
	@Path("/getAvailableDates/")
	public AppointmentAvailableDateResponse getUnAvailableDates(@Context HttpHeaders headers,AppointmentAvailableDateRequest request) {
		// TODO Auto-generated method stub
		AppointmentAvailableDateResponse response = new AppointmentAvailableDateResponse();
		try {
			response.setAvailableDates(helper.getUnavailableDates(request.getProduct_id(),request.getClientTimeZone()));
		} catch (Exception e) {
			String errorMessage = "Got Exception while trying to parse Date"
					+ e;
			response.setResponseStatus(Constants.FAIL);
			return response;
		}
		response.setResponseStatus(Constants.SUCCESS);
		return response;
	}


	@POST
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/json"})
	@Path("/saveAppointment/")
	public AppointmentResponse saveAppointment(@Context HttpHeaders headers,AppointmentRequest request) {
		// TODO Auto-generated method stub
		AppointmentResponse response = new AppointmentResponse();
		boolean success=false;
		try {
			success=helper.SaveAppointment(request.getPid(), request.getDate(), request.getCcoid(), request.getSlot(),request.getTimeZone(),request.getSrNo());
		} catch (Exception e) {
			String errorMessage = "Got Exception while trying to parse Date"
					+ e;
			response.setResponseStatus(Constants.FAIL);
			return response;
		}
		if(success)
		response.setResponseStatus(Constants.SUCCESS);
		else
			response.setResponseStatus(Constants.FAIL);
		
		return response;
	}

	/**
	 * @return the helper
	 */
	public AppointmentServiceHelper getHelper() {
		return helper;
	}

	/**
	 * @param helper the helper to set
	 */
	public void setHelper(AppointmentServiceHelper helper) {
		this.helper = helper;
	}


}
