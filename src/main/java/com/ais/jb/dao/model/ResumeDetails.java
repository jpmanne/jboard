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
	
	@Column(name = "status", length = 1, nullable = false)
	private String status;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	
	@OneToOne
	@JoinColumn(name = "candidate_details_id")
	private CandidateDetails candidateDetails;

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

	public CandidateDetails getCandidateDetails() {
		return candidateDetails;
	}

	public void setCandidateDetails(CandidateDetails candidateDetails) {
		this.candidateDetails = candidateDetails;
	}
}