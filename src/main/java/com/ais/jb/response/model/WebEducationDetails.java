/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   01-Nov-2019 
*/
package com.ais.jb.response.model;

public class WebEducationDetails {
	private Long educationDetailsId;
	private String degree;
	private String collegeOrUniversity; 
	private String fieldOfStudy;
	private String city;
	private String timePeriodFrom;
	private String timePeriodTo;

	public Long getEducationDetailsId() {
		return educationDetailsId;
	}

	public void setEducationDetailsId(Long educationDetailsId) {
		this.educationDetailsId = educationDetailsId;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getCollegeOrUniversity() {
		return collegeOrUniversity;
	}

	public void setCollegeOrUniversity(String collegeOrUniversity) {
		this.collegeOrUniversity = collegeOrUniversity;
	}

	public String getFieldOfStudy() {
		return fieldOfStudy;
	}

	public void setFieldOfStudy(String fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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