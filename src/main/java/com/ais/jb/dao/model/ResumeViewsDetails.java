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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "resume_views_details")
@EntityListeners(AuditingEntityListener.class)
public class ResumeViewsDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resume_views_details_id", length = 20, nullable = false)
	private Long resumeViewsDetailsId;

	@Column(name = "resume_code", length = 32, nullable = false)
	private String resumeCode;
	
	@Column(name = "employer_details_id", length = 20, nullable = false)
	private Long employerDetailsId;
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	public Long getResumeViewsDetailsId() {
		return resumeViewsDetailsId;
	}

	public void setResumeViewsDetailsId(Long resumeViewsDetailsId) {
		this.resumeViewsDetailsId = resumeViewsDetailsId;
	}

	public String getResumeCode() {
		return resumeCode;
	}

	public void setResumeCode(String resumeCode) {
		this.resumeCode = resumeCode;
	}

	public Long getEmployerDetailsId() {
		return employerDetailsId;
	}

	public void setEmployerDetailsId(Long employerDetailsId) {
		this.employerDetailsId = employerDetailsId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}