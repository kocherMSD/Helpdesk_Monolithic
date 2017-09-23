package org.helpdesk.commons.exception;


public class NoRecordsFoundException extends ApplicationException {
    public NoRecordsFoundException()
    {
        super("No records found","No records found");
    }
}
