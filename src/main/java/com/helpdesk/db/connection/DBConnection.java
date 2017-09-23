package com.helpdesk.db.connection;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

public class DBConnection {

	private DBConnection()
	{
		
		
	}
	 Connection conn = null;
	static DBConnection connec=new DBConnection();
	public static Connection createDBConnection(HttpServletRequest request)
	{
	
		try{
			
		if(connec.conn==null){
			synchronized(DBConnection.class )
			{
			
			
				Properties prop = new Properties();
				prop.load(request.getSession().getServletContext().getResourceAsStream("/WEB-INF/lib/Appointment.properties"));
				
	
			      Properties properties = new Properties();
				  properties.put("user",prop
							.getProperty("db.userName"));
				  properties.put("password",prop
							.getProperty("db.password"));
				  properties.put("characterEncoding", "ISO-8859-1");
				  properties.put("useUnicode", "true");
				  String url = prop
							.getProperty("db.url");
				  
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
			  connec. conn = DriverManager.getConnection(url, properties);
		 }
			 }
		  return connec.conn;
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return connec.conn;
	}
	
	
	

}
