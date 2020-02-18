/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   01-Nov-2019 
*/
package com.ais.jb.response.model;

public class WebJobSearchDetails {
	private Long jobDetailsId;
	private String jobCode;
	private String jobTitle;
	private String company;
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
}