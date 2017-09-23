
package org.helpdesk.webservice.request;

import java.util.*;

public class Message implements java.io.Serializable
{
	private String messageId;
	private String messageUrl;
	private String messageBodyUrl;
	private String messageReadUrl;
	private boolean unread = true;
	private Calendar messageSent;
	private String message;
	private String title;
	private Map<String, String> extra = new HashMap<String, String>();
	
	
	public String getMessageId()
	{
		return messageId;
	}
	
	public void setMessageId(String messageId)
	{
		this.messageId = messageId;
	}
	
	public String getMessageUrl()
	{
		return messageUrl;
	}
	
	public void setMessageUrl(String messageUrl)
	{
		this.messageUrl = messageUrl;
	}
	
	public String getMessageBodyUrl()
	{
		return messageBodyUrl;
	}
	
	public void setMessageBodyUrl(String messageBodyUrl)
	{
		this.messageBodyUrl = messageBodyUrl;
	}
	
	public String getMessageReadUrl()
	{
		return messageReadUrl;
	}
	
	public void setMessageReadUrl(String messageReadUrl)
	{
		this.messageReadUrl = messageReadUrl;
	}
	
	public boolean isUnread()
	{
		return unread;
	}
	
	public void setUnread(boolean unread)
	{
		this.unread = unread;
	}
	
	public Calendar getMessageSent()
	{
		return messageSent;
	}
	
	public void setMessageSent(Calendar messageSent)
	{
		this.messageSent = messageSent;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public Map<String, String> getExtra()
	{
		return extra;
	}
	
	public void setExtra(Map<String, String> extra)
	{
		this.extra = extra;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String toString()
	{
		return "messageId=" + getMessageId();
	}
	
}
