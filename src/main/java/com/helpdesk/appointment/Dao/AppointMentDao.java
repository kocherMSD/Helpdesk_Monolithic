package com.helpdesk.appointment.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.helpdesk.db.connection.DBConnection;

import jquery.datatables.model.AppointmentDetails;


public class AppointMentDao {
	static Connection connection=null;
	
	/**
	 * @return the connection
	 */
	public static Connection getConnection(HttpServletRequest request) {
		return DBConnection.createDBConnection(request);
	}
	  private static List<AppointmentDetails> CompanyData = new ArrayList<AppointmentDetails>();


	/**
	 * @return the companyData
	 */
	public static List<AppointmentDetails> getCompanyData() {
		return CompanyData;
	}
	/**
	 * @param companyData the companyData to set
	 */
	public static void setCompanyData(List<AppointmentDetails> companyData) {
		CompanyData = companyData;
	}
	public static boolean saveAppointmentSlot(HttpServletRequest request,AppointmentDetails details)
	{
	boolean flag=false;
	String sql="INSERT INTO APPOINTMENT_SLOTS (slots,pid) VALUES (?,?) ";
	try
	{
		Connection conn=getConnection( request) ;
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, details.getApointmentSlot());
		pstmt.setString(2, getPid(request,details.getProductName()));
		pstmt.executeUpdate();
		pstmt.close();
	}
	catch(SQLException e)
	{
			e.printStackTrace();
	}
	return flag;	
	}
	/*
	public static List<AppointmentDetails> getAppointmentDetails(HttpServletRequest request)
	{
		
		String sql="SELECT * FROM APPOINTMENT_TAC_COUNTS";
		try
		{
			AppointmentDetails details=null;
			PreparedStatement pstmt=getConnection(request).prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				do
				{
					details=new AppointmentDetails(rs.getString(columnIndex), AppointmentDate, ApointmentSlot, TotalCount, AvailableCount)	
					
				}
				while(rs.next());
				
				
			}

			
			
		}
		catch(Exception e)
		{
			
			
		}
		
		
	}
	*/
	public static String getSlotId(HttpServletRequest request,String slots,String pid)
	{
	String slots_id="0";
	String sql="select id from APPOINTMENT_SLOTS where slots=? and pid=?";
	try
	{
		PreparedStatement pstmt=getConnection(request).prepareStatement(sql);
		pstmt.setString(1, slots);
		pstmt.setString(2, pid);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			slots_id=	""+rs.getInt("id");
			
		}	
		rs.close();	
		pstmt.close();

		}
	catch(SQLException e)
	{
		
		e.printStackTrace();
		
	}
	return slots_id;	
	}
	
	public static String getSlotName(HttpServletRequest request,String id)
	{
	String slots_id="0";
	String sql="select slots from APPOINTMENT_SLOTS where id=? ";
	try
	{
		PreparedStatement pstmt=getConnection(request).prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(id));
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			slots_id=	""+rs.getString("slots");
			
		}	
		rs.close();	
		pstmt.close();

		}
	catch(SQLException e)
	{
		
		e.printStackTrace();
		
	}
	return slots_id;	
	}

	public static List<AppointmentDetails> AppointmentDetailList(HttpServletRequest request)
	{
		
		String sql="select * from  APPOINTMENT_TAC_COUNTS";
         try
         {
        	 
        	CompanyData=new ArrayList<AppointmentDetails>();
        	Connection conn=getConnection(request);
     		PreparedStatement pstmt=conn.prepareStatement(sql);
    		ResultSet rs=pstmt.executeQuery();
     		if(rs.next())
    		{
     		  do
     		  {
     			 CompanyData.add(new AppointmentDetails(getProductName(request, rs.getString("productId")), rs.getString("slotDate"), getSlotName(request, rs.getString("slotId")) ,Integer.parseInt(rs.getString("totalslot")),Integer.parseInt(rs.getString("availableSlotsCount"))));
    			
     		    }
     		    while(rs.next());
     			
    		}
     		rs.close();
     		pstmt.close();
     		AppointmentDetails.setNextID(1);
        	 
        	 
         }
         catch(Exception e)
         {
        	 
        	System.out.println("This is error message"+e.getMessage());
         }

		return CompanyData;
	}
	
	public static boolean deleteAppointmentDetail(HttpServletRequest request,AppointmentDetails details)
	{
	boolean flag=false;
	String sqlExisting="select totalSlot, availableSlotsCount from  APPOINTMENT_TAC_COUNTS  where productId=?  and slotId=? and slotDate=? ";
	String deleteSql="delete from  APPOINTMENT_TAC_COUNTS where productId=?  and slotId=? and slotDate=?";

	
	try
	{
		Connection conn=getConnection(request);
		PreparedStatement pstmt1=conn.prepareStatement(sqlExisting);
		pstmt1.setString(1, getPid( request,details.getProductName()));
		pstmt1.setString(2, ""+getSlotId(request,details.getApointmentSlot(), getPid( request,details.getProductName())));
		pstmt1.setString(3, ""+details.getAppointmentDate());
		ResultSet rs=pstmt1.executeQuery();
		if(rs.next())
		{
		
		PreparedStatement pstmt=conn.prepareStatement(deleteSql);
		pstmt.setString(1, getPid( request,details.getProductName()));
		pstmt.setString(2, ""+getSlotId(request,details.getApointmentSlot(), getPid( request,details.getProductName())));
		pstmt.setString(3, ""+details.getAppointmentDate());
		pstmt.executeUpdate();
		pstmt.close();
		}
		rs.close();
		pstmt1.close();
	}
	catch(SQLException e)
	{
		
		e.printStackTrace();
		
	}
	CompanyData.remove(details);
	return flag;	
	}


	public static boolean saveAppointmentDetail(HttpServletRequest request,AppointmentDetails details)
	{
	boolean flag=false;
	String sql="INSERT INTO APPOINTMENT_TAC_COUNTS (productId,totalSlot,slotId,availableSlotsCount,slotDate) VALUES (?,?,?,?,?) ";
	String sqlExisting="select totalSlot, availableSlotsCount from  APPOINTMENT_TAC_COUNTS  where productId=?  and slotId=? and slotDate=? ";
	String sqlUpdate="update APPOINTMENT_TAC_COUNTS set totalSlot=?,availableSlotsCount=?  where productId=?  and slotId=? and slotDate=?";

	
	try
	{
		Connection conn=getConnection(request);

		PreparedStatement pstmt1=conn.prepareStatement(sqlExisting);
		pstmt1.setString(1, getPid( request,details.getProductName()));
		pstmt1.setString(2, ""+getSlotId(request,details.getApointmentSlot(), getPid( request,details.getProductName())));
		pstmt1.setString(3, ""+details.getAppointmentDate());
		ResultSet rs=pstmt1.executeQuery();
		if(!rs.next())
		{
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, getPid( request,details.getProductName()));
		pstmt.setString(2, ""+details.getTotalCount());
		pstmt.setString(3, ""+getSlotId(request,details.getApointmentSlot(), getPid( request,details.getProductName())));
		pstmt.setString(4, ""+details.getAvailableCount());
		pstmt.setString(5, ""+details.getAppointmentDate());
		pstmt.executeUpdate();
		pstmt.close();
		CompanyData.add(details);
		}
		else
		{
			CompanyData.remove(details);
			int TotalCount=Integer.parseInt(rs.getString("totalSlot"))+details.getTotalCount();
			int availableCount= Integer.parseInt(rs.getString("availableSlotsCount"))+details.getAvailableCount();
		
			PreparedStatement pstmt2=conn.prepareStatement(sqlUpdate);
			
			pstmt2.setString(1, ""+TotalCount);
			pstmt2.setString(2, ""+availableCount);
			pstmt2.setString(3, getPid( request,details.getProductName()));
			pstmt2.setString(4, ""+getSlotId(request,details.getApointmentSlot(), getPid( request,details.getProductName())));
			pstmt2.setString(5, ""+details.getAppointmentDate());
			pstmt2.executeUpdate();
			
			pstmt2.close();
			
			
		}
		rs.close();
		pstmt1.close();
	}
	catch(SQLException e)
	{
		
		e.printStackTrace();
		
	}
	return flag;	
	}
	
	public static boolean isAvailableAppointmentDetail(HttpServletRequest request,AppointmentDetails details)
	{
	boolean flag=false;
	String sql="select productId from  APPOINTMENT_TAC_COUNTS  where productId=?  and,slotId=? and slotDate=? ";
	
	try
	{
		Connection conn=getConnection(request);
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, getPid( request,details.getProductName()));
		pstmt.setString(2, ""+getSlotId(request,details.getApointmentSlot(), getPid( request,details.getProductName())));
		pstmt.setString(3, ""+details.getAppointmentDate());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{flag=true;}
		rs.close();
		pstmt.close();

	}
	catch(SQLException e)
	{
		
		e.printStackTrace();
		
	}
	return flag;	
	}

	
	public static String getPid(HttpServletRequest request,String productName)
	{
	String product="";
	String sql="select id from products where productdesc=?";
	try
	{
		Connection conn=getConnection(request);
		PreparedStatement pstmt=getConnection(request).prepareStatement(sql);
		pstmt.setString(1, productName);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			product=	""+rs.getInt("id");
			
			
		}
		rs.close();	
		pstmt.close();
	}
	catch(SQLException e)
	{
		
		e.printStackTrace();
		
	}
	return product;	
	}

	
	public static String getProductName(HttpServletRequest request,String pid)
	{
	String product="";
	String sql="select productfamily from products where id=?";
	try
	{
		Connection conn=getConnection(request);
		PreparedStatement pstmt=getConnection(request).prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(pid));
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			product=	""+rs.getString("productfamily");
			
			
		}
		rs.close();	
		pstmt.close();

	}
	catch(SQLException e)
	{
		
		e.printStackTrace();
		
	}
	return product;	
	}

}
