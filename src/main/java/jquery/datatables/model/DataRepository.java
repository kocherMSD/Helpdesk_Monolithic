package jquery.datatables.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class DataRepository {
	
	/// <summary>
    /// Singleton collection of companies
    /// </summary>
    private static List<AppointmentDetails> CompanyData = null;

    /// <summary>
    /// Method that returns all companies used in this example
    /// </summary>
    /// <returns>List of companies</returns>
    public static List<AppointmentDetails> GetCompanies()
    {
    	String date = "";


		Date date1 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		date=(sdf.format(date1));


        if (CompanyData == null)
        {
            CompanyData = new LinkedList<AppointmentDetails>();
            CompanyData.add(new AppointmentDetails("Catalyst 3750 series", date, "8.30 PM-9.30 PM" ,1,2));
            CompanyData.add(new AppointmentDetails("Catalyst 4500 series", date, "8.30 PM-9.30 PM" ,1,2));
            CompanyData.add(new AppointmentDetails("Catalyst 4800 series", date, "8.30 PM-9.30 PM",1 ,2));
            CompanyData.add(new AppointmentDetails("Catalyst 6000 series", date, "8.30 PM-9.30 PM",1,2 ));
        
           
           
        }
        return CompanyData;
    }

}
