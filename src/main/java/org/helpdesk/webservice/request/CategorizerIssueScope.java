package org.helpdesk.webservice.request;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.mapping.Map;


public class CategorizerIssueScope {

	private String name;
	private String technology;
	private String subTechnology;
	private String problemCode;
	//private String issueTypeId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getSubTechnology() {
		return subTechnology;
	}
	public void setSubTechnology(String subTechnology) {
		this.subTechnology = subTechnology;
	}
	public String getProblemCode() {
		return problemCode;
	}
	public void setProblemCode(String problemCode) {
		this.problemCode = problemCode;
	}
	
	@Override
	public String toString() {
		return "CategorizerIssueScope [name=" + name + ", technology="
				+ technology + ", subTechnology="
				+ subTechnology + ", problemCode=" + problemCode + "]";
	}
	
	Technology groupByTechnology(Set<Technology> uniqueTechnologies){
		for(Technology technology : uniqueTechnologies){
			if(technology.getName().equals(getTechnology())){
				return technology;
			}
		}
		Technology technology = new Technology();
		technology.setName(getTechnology());
		technology.setSubTechnologies(new HashSet<SubTechnology>());		
		uniqueTechnologies.add(technology);
		return technology;
	}
	
	SubTechnology groupBySubTechnology(Set<SubTechnology> uniqueSubTechnologies){
		for(SubTechnology subTechnology : uniqueSubTechnologies){
			if(subTechnology.getName().equals(getSubTechnology())){
				return subTechnology;
			}
		}
		SubTechnology subTechnology = new SubTechnology();
		subTechnology.setName(getSubTechnology());
		subTechnology.setProblemAreas(new HashSet<ProblemArea>());		
		uniqueSubTechnologies.add(subTechnology);
		return subTechnology;
	}
	
	ProblemArea groupByProblemArea(Set<ProblemArea> uniqueProblemAreas, String problemAreaForIssueType){
		for(ProblemArea problemArea : uniqueProblemAreas){
			if(problemArea.getName().equals(problemAreaForIssueType)){
				return problemArea;
			}
		}
		ProblemArea problemArea = new ProblemArea();
		problemArea.setName(problemAreaForIssueType);
		problemArea.setProblemCodes(new HashSet<ProblemCode>());
		uniqueProblemAreas.add(problemArea);
		return problemArea;
	}
	
	ProblemCode groupByProblemCode(Set<ProblemCode> uniqueProblemCodes){
		for(ProblemCode problemCode : uniqueProblemCodes){
			if(problemCode.getName().equals(getProblemCode())){
				return problemCode;
			}
		}
		ProblemCode problemCode = new ProblemCode();
		problemCode.setName(getProblemCode());
		problemCode.setIssueTypes(new HashSet<IssueTypeDetails>());		
		uniqueProblemCodes.add(problemCode);
		return problemCode;
	}
	
	void groupByIssueScope(List<String> issueScopeList) {
		if(!issueScopeList.contains(getName())){			
			issueScopeList.add(getName());
		}
	}
}
