package org.helpdesk.webservice.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategorizerIssueTypeDetails {

	private String issueType;
	
	private List<CategorizerIssueScope> issueScopeList;

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public List<CategorizerIssueScope> getIssueScopeList() {
		return issueScopeList;
	}

	public void setIssueScopeList(List<CategorizerIssueScope> issueScopeList) {
		this.issueScopeList = issueScopeList;
	}

	@Override
	public String toString() {
		return "CategorizerIssueTypeDetails [issueType=" + issueType
				+ ", issueScopeList=" + issueScopeList + "]";
	}
	
    IssueTypeDetails groupByIssueType(CategorizerIssueTypeDetails issueType,Set<IssueTypeDetails> uniqueIssueTypes){
		for(IssueTypeDetails issueTypeDetails : uniqueIssueTypes){
			if(issueTypeDetails.getIssueType().equals(issueType.getIssueType())){
				return issueTypeDetails;
			}
		}
		IssueTypeDetails issueTypeDetails = new IssueTypeDetails();
		issueTypeDetails.setIssueType(issueType.getIssueType());
		issueTypeDetails.setIssueScopeList(new ArrayList<String>());		
		uniqueIssueTypes.add(issueTypeDetails);
		return issueTypeDetails;
	}
}
