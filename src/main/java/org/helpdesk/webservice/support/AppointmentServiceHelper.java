package org.helpdesk.webservice.support;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.helpdesk.db.dao.DataService;
import org.helpdesk.db.model.ApointmentSlots;
import org.helpdesk.db.model.ApointmentmentTacCount;
import org.helpdesk.db.model.AppointmentTransaction;
import org.helpdesk.db.model.BaseBusinessObject;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.orm.hibernate3.HibernateCallback;



public class AppointmentServiceHelper {
	
	Set<String> zoneIds = DateTimeZone.getAvailableIDs();
	DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("Z");
	
	
	
	public  Map<String ,String> getOffSetAndTimeZone()
	{
		
		Map<String ,String> offsetmap=new HashMap<String ,String>();
		/*for(String zoneId:zoneIds) {
			offsetmap.put(dateTimeFormatter.withZone(DateTimeZone.forID(zoneId)).print(0),zoneId );
		  logger.debug("("+zoneId+"   "+dateTimeFormatter.withZone(DateTimeZone.forID(zoneId)).print(0) );
		}*/
		
		offsetmap.put("-0400", "America/New_York");
		offsetmap.put("-0500", "America/Chicago");
		offsetmap.put("-0600", "America/Denver");
		offsetmap.put("-0700", "America/Los_Angeles");
		return offsetmap;
	}
	
	
	
	
	
	 private static Logger logger = Logger.getLogger(AppointmentServiceHelper.class);

		private DataService dataService ;

	

	public  List<String> getUnavailableDates(final String pid,String offset)
	 {
   	 Map<String ,String> offsetmap=getOffSetAndTimeZone();

	    final String query="select availableSlotsCount,slotDate,APPOINTMENT_SLOTS.slots from APPOINTMENT_TAC_COUNTS,APPOINTMENT_SLOTS where slotId=APPOINTMENT_SLOTS.id and APPOINTMENT_TAC_COUNTS.availableSlotsCount!=0 and APPOINTMENT_TAC_COUNTS.productId=? group by APPOINTMENT_TAC_COUNTS.slotDate,APPOINTMENT_SLOTS.slots";

		 logger.debug("Getting the List of unavailable Date Starts");
	     List<String> returnlist=new ArrayList<String>();	
	     try
	     {
	    	 int hours=0;
	    	 
	    	 if(offset.substring(0,1).equalsIgnoreCase("+"))
	    	     hours=Integer.parseInt(offset.substring(1,3));
	    	 else
		    	 hours=Integer.parseInt(offset.substring(0,3));
 
	    	 int minutes=Integer.parseInt(offset.substring(3));
	    	 final DateTimeFormatter df = DateTimeFormat
	 		        .forPattern("MM/dd/yyyy hh:mm aa 'GMT'Z");
	    	 final DateTimeFormatter df1 = DateTimeFormat
		 		        .forPattern("MM/dd/yyyy");
			 List ResultList = (List)dataService.getHibernateTemplate().execute(
					 new HibernateCallback() {
					 public Object doInHibernate(Session session) throws HibernateException {
					 SQLQuery sq =session.createSQLQuery(query);
					 sq.setString(0, pid);
					 return sq.list();
					 }});
			Calendar calendar = Calendar.getInstance(); 
			int min=(int) 3.5*60;
					calendar.add(Calendar.MINUTE, min);
		    	    Date todays =  calendar.getTime();
			 for(int i=0;i<ResultList.size();i++){
				 try
				 {
				 Object[] row = (Object[]) ResultList.get(i);
				
					int index=((String)row[2]).indexOf("-");
					int index1=((String)row[2]).indexOf("G");

					String date=(String)row[1]+" "+((String)row[2]).substring(0,index)+" "+((String)row[2]).substring(index1);
					
					String dateStrc=(String)row[1]+" "+((String)row[2]).substring(0,index);
					DateTime dateTime = df.withOffsetParsed()
					        .parseDateTime(date);
					dateTime=dateTime.toDateTime(DateTimeZone.forOffsetHoursMinutes(hours, minutes));
					System.out.println(dateTime.toString(df1));
					
					
		    	    
		    	    SimpleDateFormat format=new SimpleDateFormat("MM/dd/yyyy HH:mm");
		    	    SimpleDateFormat format1=new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
		    	    
					DateTimeZone timeZone = DateTimeZone.forID(offsetmap.get(offsetmap.get(date.substring(date.length()-5))));
				    DateTime now = new DateTime(timeZone);
				    now=  now.plusMinutes(min);
		    	    if((now.compareTo(dateTime)<=0))
		    	    {
					if(!returnlist.contains(dateTime.toString(df1)))
				       returnlist.add(dateTime.toString(df1));
		    	    }
				 }			
				 catch(Exception e)
			     {
			    	logger.debug("Exception while getting the list of the available dates" +e.getMessage()); 
			     }

	    	 
	     }
	     }
	     catch(Exception e)
	     {
	    	logger.debug("Exception while getting the list of the available dates" +e.getMessage()); 
	     }
	     List<String> returnlistFinal=new ArrayList<String>();	

	     try
	     {
	    	 SimpleDateFormat format=new SimpleDateFormat("MM/dd/yyyy");
             int daysLimit=30;
	    	for(String date :returnlist)
	    	{
	    	 	Calendar calendar = Calendar.getInstance();
	    	    Date todays =  calendar.getTime();
	    	    
	    	    calendar.add(Calendar.DAY_OF_MONTH, daysLimit);
	    	    
	    	    Date date8weekafter =  calendar.getTime();

	    			if((format.parse(format.format(todays)).compareTo(format.parse(date))<=0)&&format.parse(format.format(date8weekafter)).compareTo(format.parse(date))>=0
	    				&&(format.parse(date).getDay()!=0)){
	    				returnlistFinal.add(date);
	    			}

	    		
	    		
	    	}
	    	 
	     }
	     catch(Exception e)
	     {}
	     
	     
	     logger.debug("Getting the List of unavailable Date Ends");
	
	    return returnlistFinal;
		 
	 }
	 
	 
	 public  List<String> getTimeSlots(final String pid,final String date,String offset)
	 {

		    final String query="select availableSlotsCount,slotDate,APPOINTMENT_SLOTS.slots from APPOINTMENT_TAC_COUNTS,APPOINTMENT_SLOTS where slotId=APPOINTMENT_SLOTS.id and APPOINTMENT_TAC_COUNTS.availableSlotsCount!=0 and APPOINTMENT_TAC_COUNTS.productId=? group by APPOINTMENT_TAC_COUNTS.slotDate,APPOINTMENT_SLOTS.slots";

			 logger.debug("Getting the List of unavailable Date Starts");
		     List<String> returnlist=new ArrayList<String>();	
		     try
		     {
		    	 Map<String ,String> offsetmap=getOffSetAndTimeZone();
		    	 
		    	 int hours=0;
		    	 
		    	 if(offset.substring(0,1).equalsIgnoreCase("+"))
		    	     hours=Integer.parseInt(offset.substring(1,3));
		    	 else
			    	 hours=Integer.parseInt(offset.substring(0,3));
	 
		    	 int minutes=Integer.parseInt(offset.substring(3));
		    	 final DateTimeFormatter df = DateTimeFormat
		 		        .forPattern("MM/dd/yyyy hh:mm aa 'GMT'Z");
		    	 
		    	 final DateTimeFormatter df4 = DateTimeFormat
			 		        .forPattern("hh:mm aa ZZZ");
		    	 final DateTimeFormatter df2 = DateTimeFormat
			 		        .forPattern("hh:mm aa 'GMT'Z");
		    	 final DateTimeFormatter df3 = DateTimeFormat
			 		        .forPattern("hh:mm aa");
		    	 final DateTimeFormatter df1 = DateTimeFormat
			 		        .forPattern("MM/dd/yyyy");
				 List ResultList = (List)dataService.getHibernateTemplate().execute(
						 new HibernateCallback() {
						 public Object doInHibernate(Session session) throws HibernateException {
						 SQLQuery sq =session.createSQLQuery(query);
						 sq.setString(0, pid);
						 return sq.list();
						 }});
				    
			    	SimpleDateFormat format=new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
					int min=(int) (3.5*60);

				 for(int i=0;i<ResultList.size();i++){
					    
					 
					    Calendar calendar = Calendar.getInstance();
						calendar.add(Calendar.MINUTE, min); 
						Date todays =  calendar.getTime();
						
					    Object[] row = (Object[]) ResultList.get(i);
					 
						int index1=((String)row[2]).indexOf("-");
						int index2=((String)row[2]).indexOf("G");
						String dateStr=(String)row[1]+" "+((String)row[2]).substring(0,index1)+" "+((String)row[2]).substring(index2);

						String dateStrc=(String)row[1]+" "+((String)row[2]).substring(0,index1);
						
						int index=((String)row[2]).indexOf("-")+1;
						int indexThird=((String)row[2]).indexOf("G");

						DateTime dateTime = df.withOffsetParsed()
						        .parseDateTime(dateStr);
						dateTime=dateTime.toDateTime(DateTimeZone.forOffsetHoursMinutes(hours, minutes));
						System.out.println(dateTime.toString(df1));
						
						DateTimeZone timeZone = DateTimeZone.forID(offsetmap.get(offsetmap.get(dateStr.substring(dateStr.length()-5))));
					    DateTime now = new DateTime(timeZone);
					    now=  now.plusMinutes(min);
			    	    if((now.compareTo(dateTime)<=0))
			    	    {
						if(dateTime.toString(df1).equals(date))
						{
							String dateStrTo=(String)row[1]+" "+((String)row[2]).substring(0,index-1)+" "+((String)row[2]).substring(indexThird);
							DateTime dateTime1 = df.withOffsetParsed()
							        .parseDateTime(dateStrTo);
							String tacTo=dateTime1.toString(df3);
							dateTime1=dateTime1.toDateTime(DateTimeZone.forOffsetHoursMinutes(hours, minutes));

							String dateStrfrom=(String)row[1]+" "+((String)row[2]).substring(index);
							DateTime dateTime2 = df.withOffsetParsed()
							        .parseDateTime(dateStrfrom);
							offsetmap.get(dateStr.substring(dateStr.length()-5));
							String tacFrom=dateTime2.toString(df3)+ " " + offsetmap.get(dateStr.substring(dateStr.length()-5));

							dateTime2=dateTime2.toDateTime(DateTimeZone.forOffsetHoursMinutes(hours, minutes));
                      
							returnlist.add("LocalTime:"+dateTime1.toString(df3)+"-"+dateTime2.toString(df2)+" TacTime:"+tacTo+"-"+tacFrom+" TacDate:"+(String)row[1]);

							
						}
			    	    }
					   
					 }			

		    	 
		     }
		     catch(Exception e)
		     {
		    	logger.debug("Exception while getting the list of the available dates" +e.getMessage()); 
		     }
		     
		     
		     logger.debug("Getting the List of unavailable Date Ends");
		
		    return returnlist;
			 
		 
	 }
	 
	 
	 
	 public  String getAvailableTimeSlotCount(final String slot_id,final String pid,final String date)
	 {
		final String query="select availableSlotsCount ,slotDate from APPOINTMENT_TAC_COUNTS,APPOINTMENT_SLOTS where slotId=APPOINTMENT_SLOTS.id and APPOINTMENT_TAC_COUNTS.availableSlotsCount!=0 and APPOINTMENT_TAC_COUNTS.productId=? and APPOINTMENT_TAC_COUNTS.slotId=? and slotDate=? group by APPOINTMENT_TAC_COUNTS.slotDate,APPOINTMENT_SLOTS.slots";
       
		String availableCount="0";
		 logger.debug("Getting the List of available slots for a  Date : "+date +"  Starts");
		 List<String> returnList=new ArrayList<String>();
		 try
	     {
			 List ResultList = (List)dataService.getHibernateTemplate().execute(
					 new HibernateCallback() {
					 public Object doInHibernate(Session session) throws HibernateException {
					 SQLQuery sq =session.createSQLQuery(query);
					 sq.setString(0, pid);
					 sq.setString(1, slot_id);
					 sq.setString(2, date);
					 return sq.list();
					 }});
			 for(int i=0;i<ResultList.size();i++){
				 Object[] row = (Object[]) ResultList.get(i);
				 availableCount=(String)row[0];
			 }
	 
	    	 
	     }
	     catch(Exception e)
	     {
	    	logger.debug("Exception while getting the list of the available slots for the date" +e.getMessage()); 
	     }
		 logger.debug("Getting the List of available slots for a  Date : "+date +"  Ends");
		 return availableCount;
		 
	 }
	 
	 public  boolean SaveAppointment(String pid,String date,String ccoid,String slot ,String timeZone,String SrNumber)
	 {
         boolean flag=false;
		 logger.debug("saving the appointment : "+date +"  Starts");
		 try
	     {
			 String offSet="";
			 Set<String>  keyList=getOffSetAndTimeZone().keySet();
			 Iterator<String> it=keyList.iterator();
			 String key="";
			 while(it.hasNext())
			 {
				 key=it.next();
				String value=getOffSetAndTimeZone().get(key);
				if(value.equalsIgnoreCase(timeZone))
				{
					offSet=key;
					break;
				}
			 }
			 
			 String rangeTimeZone=slot+" GMT"+offSet;
			 
			 String slotId=""+getSlotId(rangeTimeZone,pid);
			 
			 String slotCount=getAvailableTimeSlotCount(slotId,pid,date);
			 
			 if(slotCount.equals("0"))
			 {
				 flag=false; 
			 }
		     else
			 {
		    	 
			 AppointmentTransaction at=new AppointmentTransaction();
			
			 SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
			 java.util.Date dateSql = sdf1.parse(date);
			 java.sql.Date sqlStartDate = new java.sql.Date(dateSql.getTime());  
			 at.setAppointmentDate(sqlStartDate);
			 at.setCreatedDate(""+new java.util.Date());
			 at.setUpdatedDate(""+new java.util.Date());
			 at.setSlotId(""+slotId);
			 at.setCcoId(ccoid);
			 at.setProductId(pid);
			 at.setSrNo(SrNumber);
			 dataService.saveOrUpdate(at);
			 
			 DetachedCriteria criteria = DetachedCriteria.forClass(ApointmentmentTacCount.class);
			 criteria.add(Restrictions.eq("productId", pid));
			 criteria.add(Restrictions.eq("slotDate", date));
			 criteria.add(Restrictions.eq("slotId", slotId));
			
				
				List<BaseBusinessObject> retObj = dataService.findByCriteria(criteria);
				ApointmentmentTacCount actvCount=null;
				
				    for(BaseBusinessObject bo:retObj)
					{
					actvCount=(ApointmentmentTacCount)bo;
					}
				    actvCount.setAvailableSlotsCount(""+(Integer.parseInt(actvCount.getAvailableSlotsCount())-1));
				    dataService.saveOrUpdate(actvCount);
			
			 flag=true; 
			 }
	    	 
	     }
	     catch(Exception e)
	     {
	    	 flag=false; 
	    	logger.debug("Exception while saving the appointment" +e.getMessage()); 
	     }
		 logger.debug("Saving the appointment date : "+date +"  Ends");
		 return flag;
		 
	 }
	 
	 public int getSlotId(String slot,String pid)
	 {
		 int slot_id=0;
		 try
		 {
			 DetachedCriteria criteria = DetachedCriteria.forClass(ApointmentSlots.class);
			 criteria.add(Restrictions.eq("pid", pid));
			 criteria.add(Restrictions.eq("slots", slot));
			 List<BaseBusinessObject> retObj = dataService.findByCriteria(criteria);
			 for(BaseBusinessObject bo:retObj)
				{
				 slot_id=((ApointmentSlots)bo).getId();
				}
		 }
		 catch(Exception e )
		 {
			 logger.debug("Exception getting the Slot ID" +e.getMessage());  	 
		 }
		 
		 return slot_id;
	 }
	 
	 public int getTotalCount(String slot,String pid,String date)
	 {
		 int totalCount=0;
		 try
		 {
			 ApointmentmentTacCount actvCount=null;
			 DetachedCriteria criteria = DetachedCriteria.forClass(ApointmentmentTacCount.class);
			 criteria.add(Restrictions.eq("productId", pid));
			 criteria.add(Restrictions.eq("slotdate", date));
			 criteria.add(Restrictions.eq("slotId", getSlotId(slot,pid)));
			 List<BaseBusinessObject> retObj = dataService.findByCriteria(criteria);

			  for(BaseBusinessObject bo:retObj)
				{
				actvCount=(ApointmentmentTacCount)bo;
				totalCount=Integer.parseInt(actvCount.getTotalSlot());
				}
		 }
		 catch(Exception e)
		 {
			 logger.debug("Exception getting the Total count" +e.getMessage());  
			 
		 }
		 
		 return totalCount;
	 }


	/**
	 * @return the dataService
	 */
	public DataService getDataService() {
		return dataService;
	}


	/**
	 * @param dataService the dataService to set
	 */
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}


	
	
	

}
