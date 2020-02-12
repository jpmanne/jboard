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
@Table(name = "job_application_qualifications")
@EntityListeners(AuditingEntityListener.class)
public class JobApplicationQualifications {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_application_qualifications_id", length = 20, nullable = false)
	private Long jobApplicationQualificationsId;

	@Column(name = "notify_required", length = 1, nullable = false)
	private String notifyRequired;
	
	@Column(name = "experience_qualification", nullable = true, length = 65535, columnDefinition = "text")
	private String experienceQualification;
	
	@Column(name = "license_qualification", nullable = true, length = 65535, columnDefinition = "text")
	private String licenseQualification;
	
	@Column(name = "language_qualification", nullable = true, length = 65535, columnDefinition = "text")
	private String languageQualification;
	
	@Column(name = "education_qualification", length = 100, nullable = true)
	private String educationQualification;
	
	@Column(name = "location_qualification", length = 100, nullable = true)
	private String locationQualification;
	
	@Column(name = "shift_availability_qualification", length = 100, nullable = true)
	private String shiftAvailabilityQualification;
	
	@Column(name = "willing_to_travel_qualification", length = 100, nullable = true)
	private String willingToTravelQualification;
	
	@Column(name = "required_documents_qualification", length = 100, nullable = true)
	private String requiredDocumentsQualification;
	
	@Column(name = "start_date_qualification", length = 100, nullable = true)
	private String startDateQualification;

	@Column(name = "expected_ctc_qualification", length = 100, nullable = true)
	private String expectedCtcQualification;
	
	@OneToOne
	@JoinColumn(name = "job_details_id")
	private JobDetails jobDetails;

	public Long getJobApplicationQualificationsId() {
		return jobApplicationQualificationsId;
	}

	public void setJobApplicationQualificationsId(Long jobApplicationQualificationsId) {
		this.jobApplicationQualificationsId = jobApplicationQualificationsId;
	}

	public String getNotifyRequired() {
		return notifyRequired;
	}

	public void setNotifyRequired(String notifyRequired) {
		this.notifyRequired = notifyRequired;
	}

	public String getExperienceQualification() {
		return experienceQualification;
	}

	public void setExperienceQualification(String experienceQualification) {
		this.experienceQualification = experienceQualification;
	}

	public String getLicenseQualification() {
		return licenseQualification;
	}

	public void setLicenseQualification(String licenseQualification) {
		this.licenseQualification = licenseQualification;
	}

	public String getLanguageQualification() {
		return languageQualification;
	}

	public void setLanguageQualification(String languageQualification) {
		this.languageQualification = languageQualification;
	}

	public String getEducationQualification() {
		return educationQualification;
	}

	public void setEducationQualification(String educationQualification) {
		this.educationQualification = educationQualification;
	}

	public String getLocationQualification() {
		return locationQualification;
	}

	public void setLocationQualification(String locationQualification) {
		this.locationQualification = locationQualification;
	}

	public String getShiftAvailabilityQualification() {
		return shiftAvailabilityQualification;
	}

	public void setShiftAvailabilityQualification(String shiftAvailabilityQualification) {
		this.shiftAvailabilityQualification = shiftAvailabilityQualification;
	}

	public String getWillingToTravelQualification() {
		return willingToTravelQualification;
	}

	public void setWillingToTravelQualification(String willingToTravelQualification) {
		this.willingToTravelQualification = willingToTravelQualification;
	}

	public String getRequiredDocumentsQualification() {
		return requiredDocumentsQualification;
	}

	public void setRequiredDocumentsQualification(String requiredDocumentsQualification) {
		this.requiredDocumentsQualification = requiredDocumentsQualification;
	}

	public String getStartDateQualification() {
		return startDateQualification;
	}

	public void setStartDateQualification(String startDateQualification) {
		this.startDateQualification = startDateQualification;
	}

	public String getExpectedCtcQualification() {
		return expectedCtcQualification;
	}

	public void setExpectedCtcQualification(String expectedCtcQualification) {
		this.expectedCtcQualification = expectedCtcQualification;
	}

	public JobDetails getJobDetails() {
		return jobDetails;
	}

	public void setJobDetails(JobDetails jobDetails) {
		this.jobDetails = jobDetails;
	}
}