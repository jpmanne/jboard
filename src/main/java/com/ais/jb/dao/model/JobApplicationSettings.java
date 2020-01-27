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

@Entity
@Table(name = "job_application_settings")
@EntityListeners(AuditingEntityListener.class)
public class JobApplicationSettings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_application_settings_id", length = 20, nullable = false)
	private Long jobApplicationSettingsId;

	@Column(name = "receive_applications", length = 1, nullable = false)
	private String receiveApplications;
	
	@Column(name = "email_addresses", nullable = true, length = 65535, columnDefinition = "text")
	private String emailAddresses;
	
	@Column(name = "inperson_address", nullable = true, length = 65535, columnDefinition = "text")
	private String inpersonAddresses;
	
	@Column(name = "new_applicatants_informed", length = 1, nullable = false)
	private String newApplicatantsInformed;
	
	@Column(name = "submit_resume", length = 1, nullable = false)
	private String submitResume;

	@OneToOne
	@JoinColumn(name = "job_details_id")
	private JobDetails jobDetails;

	public Long getJobApplicationSettingsId() {
		return jobApplicationSettingsId;
	}

	public void setJobApplicationSettingsId(Long jobApplicationSettingsId) {
		this.jobApplicationSettingsId = jobApplicationSettingsId;
	}

	public String getReceiveApplications() {
		return receiveApplications;
	}

	public void setReceiveApplications(String receiveApplications) {
		this.receiveApplications = receiveApplications;
	}

	public String getEmailAddresses() {
		return emailAddresses;
	}

	public void setEmailAddresses(String emailAddresses) {
		this.emailAddresses = emailAddresses;
	}

	public String getInpersonAddresses() {
		return inpersonAddresses;
	}

	public void setInpersonAddresses(String inpersonAddresses) {
		this.inpersonAddresses = inpersonAddresses;
	}

	public String getNewApplicatantsInformed() {
		return newApplicatantsInformed;
	}

	public void setNewApplicatantsInformed(String newApplicatantsInformed) {
		this.newApplicatantsInformed = newApplicatantsInformed;
	}

	public String getSubmitResume() {
		return submitResume;
	}

	public void setSubmitResume(String submitResume) {
		this.submitResume = submitResume;
	}

	public JobDetails getJobDetails() {
		return jobDetails;
	}

	public void setJobDetails(JobDetails jobDetails) {
		this.jobDetails = jobDetails;
	}
}