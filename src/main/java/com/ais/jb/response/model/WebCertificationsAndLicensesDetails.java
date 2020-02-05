/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   01-Nov-2019 
*/
package com.ais.jb.response.model;

public class WebCertificationsAndLicensesDetails {
	private Long certificationsAndLicensesDetailsId;
	private String title;
	private String description; 
	private String timePeriodFrom;
	private String timePeriodTo;

	public Long getCertificationsAndLicensesDetailsId() {
		return certificationsAndLicensesDetailsId;
	}

	public void setCertificationsAndLicensesDetailsId(Long certificationsAndLicensesDetailsId) {
		this.certificationsAndLicensesDetailsId = certificationsAndLicensesDetailsId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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