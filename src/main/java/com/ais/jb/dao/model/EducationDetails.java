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

import com.ais.jb.response.model.WebEducationDetails;

@Entity
@Table(name = "education_details")
@EntityListeners(AuditingEntityListener.class)
public class EducationDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "education_details_id", length = 20, nullable = false)
	private Long educationDetailsId;

	@Column(name = "degree", length = 150, nullable = false)
	private String degree;
	
	@Column(name = "college_or_university", length = 255, nullable = false)
	private String collegeOrUniversity; 
	
	@Column(name = "field_of_study", length = 150, nullable = false)
	private String fieldOfStudy;
	
	@Column(name = "city", length = 100, nullable = false)
	private String city;
	
	@Column(name = "time_period_from", length = 15, nullable = false)
	private String timePeriodFrom;
	
	@Column(name = "time_period_to", length = 15, nullable = false)
	private String timePeriodTo;
	
	@OneToOne
	@JoinColumn(name = "user_details_id")
	private UserDetails userDetails;

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

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	public WebEducationDetails getWebEducationDetails() {
		WebEducationDetails details = new WebEducationDetails();
		details.setEducationDetailsId(educationDetailsId);
		details.setDegree(degree);
		details.setCollegeOrUniversity(collegeOrUniversity);
		details.setFieldOfStudy(fieldOfStudy);
		details.setCity(city);
		details.setTimePeriodFrom(timePeriodFrom);
		details.setTimePeriodTo(timePeriodTo); 
		return details;
	}
}