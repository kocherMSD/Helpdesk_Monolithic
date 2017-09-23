package jquery.datatables.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.helpdesk.appointment.Dao.AppointMentDao;

import jquery.datatables.model.AppointmentDetails;
import jquery.datatables.model.DataRepository;
import jquery.datatables.controller.DataTableRequestParam;

/**
 * CompanyServlet provides data to the JQuery DataTables
 */
public class CompanyDataTableAjaxDataSourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final DataTableRequestParam param = DataTablesParamUtility.getParam(request);
		
		String sEcho = param.sEcho;
		int iTotalRecords; // total number of records (unfiltered)
		int iTotalDisplayRecords;//value will be set when code filters companies by keyword
		JSONArray data = new JSONArray(); //data that will be shown in the table
		List<AppointmentDetails> appointmentDetail = new ArrayList<AppointmentDetails>();
		List<AppointmentDetails> appointmentDetails = new ArrayList<AppointmentDetails>();
		appointmentDetail= AppointMentDao.AppointmentDetailList(request);
		iTotalRecords = appointmentDetail.size();
	
		for(AppointmentDetails c : appointmentDetail){
			//Cannot search by column 0 (id)
			if(	param.bSearchable[1] &&
				c.getProductName().toLowerCase().contains(param.sSearchKeyword.toLowerCase())
				||
				param.bSearchable[2] &&
				c.getAppointmentDate().toLowerCase().contains(param.sSearchKeyword.toLowerCase())
				||
				param.bSearchable[3] &&
				c.getApointmentSlot().toLowerCase().contains(param.sSearchKeyword.toLowerCase())
				||param.bSearchable[4] &&
				(""+c.getAvailableCount()).contains(param.sSearchKeyword.toLowerCase())
				||param.bSearchable[5] &&
				(""+c.getTotalCount()).contains(param.sSearchKeyword.toLowerCase()))
			if(!appointmentDetails.contains(c))
			{
				appointmentDetails.add(c); // Add a company that matches search criterion
			}
		}
		iTotalDisplayRecords = appointmentDetails.size();//Number of companies that matches search criterion should be returned
		
		
		Collections.sort(appointmentDetails, new Comparator<AppointmentDetails>(){
			@Override
			public int compare(AppointmentDetails c1, AppointmentDetails c2) {
				int result = 0;
				for(int i=0; i<param.iSortingCols; i++){
					int sortBy = param.iSortCol[i];
					if(param.bSortable[sortBy]){
						switch(sortBy){
							case 0:
								result =	0; //sort by id is not allowed
							break;
							case 1:
								result =	c1.getProductName().compareToIgnoreCase(c2.getProductName()) * 
											(param.sSortDir[i].equals("asc") ? -1 : 1);
								break;
							case 2:
								result =	c1.getAppointmentDate().compareToIgnoreCase(c2.getAppointmentDate()) * 
											(param.sSortDir[i].equals("asc") ? -1 : 1);
								break;
							case 3:
								result =	c1.getApointmentSlot().compareToIgnoreCase(c2.getApointmentSlot()) *
											(param.sSortDir[i].equals("asc") ? -1 : 1);
								break;
							case 4:
								result =	((Integer)c1.getAvailableCount()).compareTo((Integer)c2.getAvailableCount())*
											(param.sSortDir[i].equals("asc") ? -1 : 1);
								break;
							case 5:
								result =	((Integer)c1.getTotalCount()).compareTo((Integer)c2.getTotalCount()) *
											(param.sSortDir[i].equals("asc") ? -1 : 1);
						}
					}
					if(result!=0)
						return result;
					else
						continue;
				}
				return result;
			}
		});
		
		if(appointmentDetails.size()< param.iDisplayStart + param.iDisplayLength)
			appointmentDetails = appointmentDetails.subList(param.iDisplayStart, appointmentDetails.size());
		else
			appointmentDetails = appointmentDetails.subList(param.iDisplayStart, param.iDisplayStart + param.iDisplayLength);
	
		
		try {
			JSONObject jsonResponse = new JSONObject();
			
			jsonResponse.put("sEcho", sEcho);
			jsonResponse.put("iTotalRecords", iTotalRecords);
			jsonResponse.put("iTotalDisplayRecords", iTotalDisplayRecords);
			
			for(AppointmentDetails c : appointmentDetails){
				JSONArray row = new JSONArray();
				row.put(c.getId()).put(c.getProductName()).put(c.getAppointmentDate()).put(c.getApointmentSlot()).put(c.getTotalCount()).put(c.getAvailableCount());
				data.put(row);
			}
			jsonResponse.put("aaData", data);
			
			response.setContentType("application/json");
			response.getWriter().print(jsonResponse.toString());
		} catch (JSONException e) {
			e.printStackTrace();
			response.setContentType("text/html");
			response.getWriter().print(e.getMessage());
		}
	
	}

}
