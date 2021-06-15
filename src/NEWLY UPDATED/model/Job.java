package com.vishnu.model;

public class Job{
	
	private  int JobId;
	private String JobTitle;
	private String JobDescription;
	private String CompanyName;
	private String Location;
	private String KeySkill;
	private String Salary;
	private String Experience;
	private String Active;
	
	public Job() {
		
	}
	
	
public Job(String JobTitle, String JobDescription, String CompanyName, String Location, String KeySkill,
		String Salary, String Experience) {
	super();
	this.JobTitle = JobTitle;
	this.JobDescription = JobDescription;
	this.CompanyName = CompanyName;
	this.Location = Location;
	this.KeySkill = KeySkill;
	this.Salary = Salary;
	this.Experience = Experience;
}


public int getJobId() {
	return JobId;
}


public void setJobId(int jobId) {
	JobId = jobId;
}


public String getJobTitle() {
	return JobTitle;
}


public void setJobTitle(String jobTitle) {
	JobTitle = jobTitle;
}


public String getJobDescription() {
	return JobDescription;
}


public void setJobDescription(String jobDescription) {
	JobDescription = jobDescription;
}


public String getCompanyName() {
	return CompanyName;
}


public void setCompanyName(String companyName) {
	CompanyName = companyName;
}


public String getLocation() {
	return Location;
}


public void setLocation(String location) {
	Location = location;
}


public String getKeySkill() {
	return KeySkill;
}


public void setKeySkill(String keySkill) {
	KeySkill = keySkill;
}


public String getSalary() {
	return Salary;
}


public void setSalary(String salary) {
	Salary = salary;
}


public String getActive() {
	return Active;
}


public String getExperience() {
	return Experience;
}


public void setExperience(String experience) {
	Experience = experience;
}


public void setActive(String active) {
	Active = active;
}



}