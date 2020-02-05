/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   01-Nov-2019 
*/
package com.ais.jb.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.ais.jb.response.model.WebWorkExperienceDetails;

@Entity
@Table(name = "work_experience_details")
@EntityListeners(AuditingEntityListener.class)
public class WorkExperienceDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "work_experience_details_id", length = 20, nullable = false)
	private Long workExperienceDetailsId;

	@Column(name = "job_title", length = 150, nullable = false)
	private String jobTitle;
	
	@Column(name = "company", length = 255, nullable = false)
	private String company; 
	
	@Column(name = "city", length = 100, nullable = false)
	private String city;
	
	@Column(name = "description", nullable = true, length = 65535, columnDefinition = "text")
	private String description; 
	
	@Column(name = "time_period_from", length = 15, nullable = false)
	private String timePeriodFrom;
	
	@Column(name = "time_period_to", length = 15, nullable = false)
	private String timePeriodTo;
	
	@OneToOne
	@JoinColumn(name = "user_details_id")
	private UserDetails userDetails;

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

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	public WebWorkExperienceDetails getWebWorkExperienceDetails() {
		WebWorkExperienceDetails details = new WebWorkExperienceDetails();
		details.setWorkExperienceDetailsId(workExperienceDetailsId);
		details.setJobTitle(jobTitle);
		details.setCompany(company);
		details.setCity(city);
		details.setDescription(description);
		details.setTimePeriodFrom(timePeriodFrom);
		details.setTimePeriodTo(timePeriodTo);
		return details;
	}
}