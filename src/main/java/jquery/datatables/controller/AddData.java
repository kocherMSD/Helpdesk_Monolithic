package jquery.datatables.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helpdesk.appointment.Dao.AppointMentDao;

import jquery.datatables.model.AppointmentDetails;
import jquery.datatables.model.DataRepository;

/**
 * Handling adding new data
 */
public class AddData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String date = request.getParameter("date");
		NumberFormat nf=new DecimalFormat("0000");
		
	    String timeZone="GMT"+	nf.format(TimeZone.getTimeZone( request.getParameter("timeZone")).getOffset(new Date().getTime())/36000);
		
		String slot = request.getParameter("toTime")+"-"+request.getParameter("fromTime") +" "+timeZone;
		int count = Integer.parseInt(request.getParameter("count"));
		
		AppointmentDetails details = new AppointmentDetails(name, date, slot, count,count);
		String slot_id=AppointMentDao.getSlotId(request,slot, AppointMentDao.getPid( request,name));
		if(slot_id.equalsIgnoreCase("0"))
		{
			AppointMentDao.saveAppointmentSlot(request,details);
			slot_id=AppointMentDao.getSlotId(request,slot,AppointMentDao.getPid( request,name));
		}
		AppointMentDao.saveAppointmentDetail(request,details);
		response.getWriter().print(details.getId());
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
