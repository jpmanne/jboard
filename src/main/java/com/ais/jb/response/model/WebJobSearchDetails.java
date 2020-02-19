/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   01-Nov-2019 
*/
package com.ais.jb.response.model;

public class WebJobSearchDetails {
	/*
	 * location
	 * salary
	 * job summary[0]
	 * responsibilites[0]
	 * required skills[0]
	 * Skills
	 * Date (30+ days ago)
	 * responsive Employer
	 * Urgently hiring*/
	private Long jobDetailsId;
	private String jobCode;
	private String jobTitle;
	private String company;
	private String city;
	private String state;
	private String salary;
	private String jobSummary;
	private String howUrgentlyRequired;
	private String responsibilitiesAndDuties;
	private String qualificationsAndSkills;
	public Long getJobDetailsId() {
		return jobDetailsId;
	}
	public String getJobCode() {
		return jobCode;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public String getCompany() {
		return company;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getSalary() {
		return salary;
	}
	public String getJobSummary() {
		return jobSummary;
	}
	public String getHowUrgentlyRequired() {
		return howUrgentlyRequired;
	}
	public String getResponsibilitiesAndDuties() {
		return responsibilitiesAndDuties;
	}
	public String getQualificationsAndSkills() {
		return qualificationsAndSkills;
	}
	public void setJobDetailsId(Long jobDetailsId) {
		this.jobDetailsId = jobDetailsId;
	}
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public void setJobSummary(String jobSummary) {
		this.jobSummary = jobSummary;
	}
	public void setHowUrgentlyRequired(String howUrgentlyRequired) {
		this.howUrgentlyRequired = howUrgentlyRequired;
	}
	public void setResponsibilitiesAndDuties(String responsibilitiesAndDuties) {
		this.responsibilitiesAndDuties = responsibilitiesAndDuties;
	}
	public void setQualificationsAndSkills(String qualificationsAndSkills) {
		this.qualificationsAndSkills = qualificationsAndSkills;
	}
}