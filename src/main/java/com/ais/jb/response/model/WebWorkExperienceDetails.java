/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   01-Nov-2019 
*/
package com.ais.jb.response.model;

public class WebWorkExperienceDetails {
	private Long workExperienceDetailsId;
	private String jobTitle;
	private String company; 
	private String city;
	private String description; 
	private String timePeriodFrom;
	private String timePeriodTo;

	public Long getWorkExperienceDetailsId() {
		return workExperienceDetailsId;
	}

	public void setWorkExperienceDetailsId(Long workExperienceDetailsId) {
		this.workExperienceDetailsId = workExperienceDetailsId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTimePeriodFrom() {
		return timePeriodFrom;
	}

	public void setTimePeriodFrom(String timePeriodFrom) {
		this.timePeriodFrom = timePeriodFrom;
	}

	public String getTimePeriodTo() {
		return timePeriodTo;
	}

	public void setTimePeriodTo(String timePeriodTo) {
		this.timePeriodTo = timePeriodTo;
	}
}