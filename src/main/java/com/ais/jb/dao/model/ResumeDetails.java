/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   01-Nov-2019 
*/
package com.ais.jb.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "resume_details")
@EntityListeners(AuditingEntityListener.class)
public class ResumeDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resume_details_id", length = 20, nullable = false)
	private Long resumeDetailsId;

	@Column(name = "resume_code", length = 32, nullable = false)
	private String resumeCode;
	
	@Column(name = "head_line", length = 150, nullable = true)
	private String headLine;
	
	@Column(name = "objective", nullable = true, length = 65535, columnDefinition = "text")
	private String objective; 
	
	@Column(name = "city", length = 100, nullable = false)
	private String city;
	
	@Column(name = "state", length = 100, nullable = false)
	private String state;
	
	@Column(name = "pin_code", length = 15, nullable = true)
	private String pinCode;
	
	@Column(name = "country", length = 100, nullable = true)
	private String country;
	
	@Column(name = "relocation", length = 1, nullable = true)
	private String relocation;
	
	@Column(name = "status", length = 1, nullable = false)
	private String status;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	
	@OneToOne
	@JoinColumn(name = "user_details_id")
	private UserDetails userDetails;

	public Long getResumeDetailsId() {
		return resumeDetailsId;
	}

	public void setResumeDetailsId(Long resumeDetailsId) {
		this.resumeDetailsId = resumeDetailsId;
	}

	public String getResumeCode() {
		return resumeCode;
	}

	public void setResumeCode(String resumeCode) {
		this.resumeCode = resumeCode;
	}

	public String getHeadLine() {
		return headLine;
	}

	public void setHeadLine(String headLine) {
		this.headLine = headLine;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRelocation() {
		return relocation;
	}

	public void setRelocation(String relocation) {
		this.relocation = relocation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
}