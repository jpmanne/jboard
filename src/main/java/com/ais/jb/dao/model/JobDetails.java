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
@Table(name = "job_details")
@EntityListeners(AuditingEntityListener.class)
public class JobDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_details_id", length = 20, nullable = false)
	private Long jobDetailsId;

	@Column(name = "job_code", length = 32, nullable = false)
	private String jobCode;
	
	@Column(name = "status", length = 1, nullable = false)
	private String status;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	
	@OneToOne
	@JoinColumn(name = "employer_details_id")
	private EmployerDetails employerDetails;

	public Long getJobDetailsId() {
		return jobDetailsId;
	}

	public void setJobDetailsId(Long jobDetailsId) {
		this.jobDetailsId = jobDetailsId;
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

	public EmployerDetails getEmployerDetails() {
		return employerDetails;
	}

	public void setEmployerDetails(EmployerDetails employerDetails) {
		this.employerDetails = employerDetails;
	}
}