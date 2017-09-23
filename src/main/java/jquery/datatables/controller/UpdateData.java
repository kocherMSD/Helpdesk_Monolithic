package jquery.datatables.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helpdesk.appointment.Dao.AppointMentDao;

import jquery.datatables.model.AppointmentDetails;
import jquery.datatables.model.DataRepository;

/**
 * Handler for the update cell action
 */
public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * This servlet handles post request from the JEditable and updates company property that is edited
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 int id = Integer.parseInt(request.getParameter("id"));
		    //int columnId = Integer.parseInt(request.getParameter("columnId"));
		int columnPosition = Integer.parseInt(request.getParameter("columnPosition"));
		//int rowId = Integer.parseInt(request.getParameter("rowId"));
		 String value = request.getParameter("value");
		//String columnName = request.getParameter("columnName");
		
		
		for(AppointmentDetails appointmentDetails: DataRepository.GetCompanies())
		{
			if(appointmentDetails.getId()==id)
			{
				AppointMentDao.AppointmentDetailList(request).remove(appointmentDetails);
				switch (columnPosition)
	            {
	                case 0:
	                    appointmentDetails.setProductName(value);
	                    break;
	                case 1:
	                    appointmentDetails.setAppointmentDate(value);
	                    break;
	                case 2:
	                    appointmentDetails.setApointmentSlot(value);
	                    break;
	                case 3:
	                    appointmentDetails.setTotalCount(Integer.parseInt(value));
	                    break;
	                case 4:
	                    appointmentDetails.setAvailableCount(Integer.parseInt(value));
	                    break;
	                default:
	                    break;
	            }
				AppointMentDao.saveAppointmentDetail(request,appointmentDetails);
				AppointMentDao.AppointmentDetailList(request).add(appointmentDetails);
				PrintWriter out = response.getWriter();
			    out.print(value);
			    return ;

			}
		}
		response.getWriter().print("Error - company cannot be found");
	}


}
