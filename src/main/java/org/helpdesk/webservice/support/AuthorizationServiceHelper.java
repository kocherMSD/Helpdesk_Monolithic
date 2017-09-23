package org.helpdesk.webservice.support;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.helpdesk.Utils.Constants;
import org.helpdesk.Utils.Util;
import org.helpdesk.db.dao.DataService;
import org.helpdesk.db.model.BaseBusinessObject;
import org.helpdesk.db.model.UsersEntity;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


public class AuthorizationServiceHelper  {

	private static Logger logger = Logger.getLogger(AuthorizationServiceHelper.class);
	private HashMap<String,String> msgCatelog;
	private Util util;
	private DataService updater;
	private String includeUsersCSV;
	private HashMap<String, String> DefaultValueMap;
	

	

	

	/**
	 * @return the includeUsersCSV
	 */
	public String getIncludeUsersCSV() {
		return includeUsersCSV;
	}

	/**
	 * @param includeUsersCSV the includeUsersCSV to set
	 */
	public void setIncludeUsersCSV(String includeUsersCSV) {
		this.includeUsersCSV = includeUsersCSV;
	}

	public DataService getUpdater() {
		return updater;
	}

	public void setUpdater(DataService updater) {
		this.updater = updater;
	}

	public HashMap<String, String> getMsgCatelog() {
		return msgCatelog;
	}

	public void setMsgCatelog(HashMap<String, String> msgCatelog) {
		this.msgCatelog = msgCatelog;
	}

	
	
	
	/**
	 * @return the util
	 */
	public Util getUtil() {
		return util;
	}

	/**
	 * @param util the util to set
	 */
	public void setUtil(Util util) {
		this.util = util;
	}

	
	
	public List<String> getListofInludeUsers()
	{
		    List<String> users=new ArrayList<String>();
		    DetachedCriteria criteria = DetachedCriteria.forClass(UsersEntity.class);
			criteria.addOrder(Order.asc("ccoid"));
			List<BaseBusinessObject> retObj = updater.findByCriteria(criteria);
			for(BaseBusinessObject bo :retObj)
			{
				users.add((((UsersEntity)bo).getCcoid()).toUpperCase());
			}
		
		return users;
	}
	
	
	public String getPrivilegeLevel(String ccoId)
	{
		 String privilegeLevel="";
		try
		{
		       
		    DetachedCriteria criteria = DetachedCriteria.forClass(UsersEntity.class);
		    criteria.add(Restrictions.eq("ccoid", ccoId));
			criteria.addOrder(Order.asc("ccoid"));
			List<BaseBusinessObject> retObj = updater.findByCriteria(criteria);
			for(BaseBusinessObject bo :retObj)
			{
				privilegeLevel=	((UsersEntity)bo).getPrivilegeLevel();
			}
		}
		catch(Exception e)
		{
			privilegeLevel=Constants.NOT_AVAILAIBLE;
		}
		
		if (privilegeLevel!=null&&privilegeLevel.equals(Constants.ONE))
			privilegeLevel=Constants.PRIVILEGE_LEVEL_1;
		else if (privilegeLevel!=null&&privilegeLevel.equals(Constants.TWO))
			privilegeLevel=Constants.PRIVILEGE_LEVEL_2;
		else  if (privilegeLevel!=null&&privilegeLevel.equals(Constants.THREE))
			privilegeLevel=Constants.PRIVILEGE_LEVEL_3;
		else
			privilegeLevel="NA";	
		
		return privilegeLevel;
		
	}
	
	
	public String getVersion()
	{
		String version="0.0.0";
		
		version=DefaultValueMap.get("faststartversion");
		
		return version;
		
	}

	public String getAccessLevel(String ccoId){
		String accessLevel = "NA";
		try
		{
		       
		    DetachedCriteria criteria = DetachedCriteria.forClass(UsersEntity.class);
		    criteria.add(Restrictions.eq("ccoid", ccoId));
			criteria.addOrder(Order.asc("ccoid"));
			List<BaseBusinessObject> retObj = updater.findByCriteria(criteria);
			for(BaseBusinessObject bo :retObj)
			{
				accessLevel=	((UsersEntity)bo).getAccesslevel();
			}
		}
		catch(Exception e)
		{
			accessLevel ="NA";
		}

		return accessLevel;
	}
	
	public String getAppointmentCapability(String ccoId){
		String appointmentCapability = "No";
		try
		{
		       
		    DetachedCriteria criteria = DetachedCriteria.forClass(UsersEntity.class);
		    criteria.add(Restrictions.eq("ccoid", ccoId));
			criteria.addOrder(Order.asc("ccoid"));
			List<BaseBusinessObject> retObj = updater.findByCriteria(criteria);
			for(BaseBusinessObject bo :retObj)
			{
				appointmentCapability=	((UsersEntity)bo).getAppointmentCapability();
			}
		}
		catch(Exception e)
		{
			appointmentCapability ="No";
		}

		return appointmentCapability;
	}
	/* public static void main(String args[]){
		 
		 AuthorizationServiceImpl serviceImpl = new AuthorizationServiceImpl();
		 System.out.println("Is external user :"+serviceImpl.isExternalUser("skalyana", null));
	 }*/

	/**
	 * @return the fastStartDefaultValueMap
	 */
	public HashMap<String, String> getDefaultValueMap() {
		return DefaultValueMap;
	}

	/**
	 * @param fastStartDefaultValueMap the fastStartDefaultValueMap to set
	 */
	public void setFastStartDefaultValueMap(
			HashMap<String, String> DefaultValueMap) {
		this.DefaultValueMap = DefaultValueMap;
	}
	
	

	public String gettac_working_hours(String ccoId) {
		String tac_working_hours = "NA";
		try
		{
		       
			tac_working_hours=getusertimezone(ccoId)+"-"+getweekendrestriction(ccoId)+"-"+getworkingHours(ccoId);
		}
		catch(Exception e)
		{
			tac_working_hours ="NA";
		}

		return tac_working_hours;
	}
	

	
	public String getusertimezone(String ccoId) {
		// TODO Auto-generated method stub
		String case_creation_restriction_enabled = "NA";
		try
		{
		       
		    DetachedCriteria criteria = DetachedCriteria.forClass(UsersEntity.class);
		    criteria.add(Restrictions.eq("ccoid", ccoId));
			criteria.addOrder(Order.asc("ccoid"));
			List<BaseBusinessObject> retObj = updater.findByCriteria(criteria);
			for(BaseBusinessObject bo :retObj)
			{
				case_creation_restriction_enabled=	((UsersEntity)bo).getTimezone();
			}
			if(!(null!=case_creation_restriction_enabled))
				case_creation_restriction_enabled="NA";
			
		}
		catch(Exception e)
		{
			case_creation_restriction_enabled ="NA";
		}

		return case_creation_restriction_enabled;
	}

	
	public String getweekendrestriction(String ccoId) {
		// TODO Auto-generated method stub
		String case_creation_restriction_enabled = "false";
		try
		{
		       
		    DetachedCriteria criteria = DetachedCriteria.forClass(UsersEntity.class);
		    criteria.add(Restrictions.eq("ccoid", ccoId));
			criteria.addOrder(Order.asc("ccoid"));
			List<BaseBusinessObject> retObj = updater.findByCriteria(criteria);
			for(BaseBusinessObject bo :retObj)
			{
				case_creation_restriction_enabled=	((UsersEntity)bo).getWeekend_restriction();
			}
			if((null!=case_creation_restriction_enabled)&&case_creation_restriction_enabled.equalsIgnoreCase("Y"))
				case_creation_restriction_enabled="true";
			else
				case_creation_restriction_enabled="false";
	
		}
		catch(Exception e)
		{
			case_creation_restriction_enabled ="false";
		}

		return case_creation_restriction_enabled;
	}
	
	public String getworkingHours(String ccoId) {
		// TODO Auto-generated method stub
		String case_creation_restriction_enabled = "NA";
		try
		{
		       
		    DetachedCriteria criteria = DetachedCriteria.forClass(UsersEntity.class);
		    criteria.add(Restrictions.eq("ccoid", ccoId));
			criteria.addOrder(Order.asc("ccoid"));
			List<BaseBusinessObject> retObj = updater.findByCriteria(criteria);
			for(BaseBusinessObject bo :retObj)
			{
				case_creation_restriction_enabled=	((UsersEntity)bo).getUserworkingstarttime();
			}
			if(!(null!=case_creation_restriction_enabled))
				case_creation_restriction_enabled="NA";
		}
		catch(Exception e)
		{
			case_creation_restriction_enabled ="NA";
		}

		return case_creation_restriction_enabled;
	}




	public String getcase_creation_restriction_enabled(String ccoId) {
		// TODO Auto-generated method stub
		String case_creation_restriction_enabled = "No";
		try
		{
		       
		    DetachedCriteria criteria = DetachedCriteria.forClass(UsersEntity.class);
		    criteria.add(Restrictions.eq("ccoid", ccoId));
			criteria.addOrder(Order.asc("ccoid"));
			List<BaseBusinessObject> retObj = updater.findByCriteria(criteria);
			for(BaseBusinessObject bo :retObj)
			{
				case_creation_restriction_enabled=	((UsersEntity)bo).getCase_creation_restriction_enabled();
			}
			if(null!=case_creation_restriction_enabled&&!case_creation_restriction_enabled.equalsIgnoreCase("N"))
				case_creation_restriction_enabled="Yes";
			else
				case_creation_restriction_enabled="No";
		}
		catch(Exception e)
		{
			case_creation_restriction_enabled ="No";
		}

		return case_creation_restriction_enabled;
	}

	public String getsmart_suggest_enabled(String ccoId) {
		// TODO Auto-generated method stub
		String smart_suggest_enabled = "No";
		try
		{
		       
		    DetachedCriteria criteria = DetachedCriteria.forClass(UsersEntity.class);
		    criteria.add(Restrictions.eq("ccoid", ccoId));
			criteria.addOrder(Order.asc("ccoid"));
			List<BaseBusinessObject> retObj = updater.findByCriteria(criteria);
			for(BaseBusinessObject bo :retObj)
			{
				smart_suggest_enabled=	((UsersEntity)bo).getSmart_suggest_enabled();
			}
			if(null!=smart_suggest_enabled&&!smart_suggest_enabled.equalsIgnoreCase("N"))
				smart_suggest_enabled="Yes";
			else
				smart_suggest_enabled="No";
		}
		catch(Exception e)
		{
			smart_suggest_enabled ="No";
		}

		return smart_suggest_enabled;
	}
	
	

}

