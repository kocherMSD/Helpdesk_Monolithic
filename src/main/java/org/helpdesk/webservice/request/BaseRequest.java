package org.helpdesk.webservice.request;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class BaseRequest
{
    private String loggedInUser;

    public String getLoggedInUser()
    {
        return loggedInUser;
    }

    public void setLoggedInUser(String loggedInUser)
    {
        this.loggedInUser = loggedInUser;
    }
    
    @Override
    public String toString()
    {
        
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
        
    }
}
