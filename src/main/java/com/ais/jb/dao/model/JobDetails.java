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
	
	@Column(name = "job_title", length = 255, nullable = false)
	private String jobTitle;
	
	@Column(name = "company", length = 255, nullable = false)
	private String company;
	
	@Column(name = "city", length = 100, nullable = false)
	private String city;
	
	@Column(name = "state", length = 100, nullable = false)
	private String state;
	
	@Column(name = "country", length = 100, nullable = false)
	private String country;
	
	@Column(name = "job_type", length = 20, nullable = false)
	private String jobType;
	
	@Column(name = "salary_range", length = 100, nullable = true)
	private String salaryRange;
	
	@Column(name = "salary_type", length = 10, nullable = true)
	private String salaryType;
	
	@Column(name = "how_many_hires", length = 50, nullable = true)
	private String howManyHires;
	
	@Column(name = "how_urgently_required", length = 50, nullable = true)
	private String howUrgentlyRequired;
	
	@Column(name = "additional_details", length = 20, nullable = true)
	private String additionalDetails;
	
	@Column(name = "industry", length = 20, nullable = true)
	private String industry;
	
	@Column(name = "job_summary", nullable = true, length = 65535, columnDefinition = "text")
	private String jobSummary;
	
	@Column(name = "responsibilities_and_duties", nullable = true, length = 65535, columnDefinition = "text")
	private String responsibilitiesAndDuties;
	
	@Column(name = "qualifications_and_skills", nullable = true, length = 65535, columnDefinition = "text")
	private String qualificationsAndSkills;
	
	@Column(name = "benefits", nullable = true, length = 65535, columnDefinition = "text")
	private String benefits;
	
	@Column(name = "status", length = 1, nullable = false)
	private String status;

	@OneToOne
	@JoinColumn(name = "employer_details_id")
	private EmployerDetails employerDetails;
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	//Job Application Settings
	@Column(name = "receive_applications", length = 10, nullable = false)
	private String receiveApplications;
	
	@Column(name = "email_addresses", nullable = true, length = 65535, columnDefinition = "text")
	private String emailAddresses;
	
	@Column(name = "inperson_address", nullable = true, length = 65535, columnDefinition = "text")
	private String inpersonAddresses;
	
	@Column(name = "new_applicatants_informed", length = 15, nullable = false)
	private String newApplicatantsInformed;
	
	@Column(name = "submit_resume", length = 10, nullable = false)
	private String submitResume;
	
	//Job Application Qualifications
	@Column(name = "notify_required", length = 10, nullable = false)
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

	public Long getJobDetailsId() {
		return jobDetailsId;
	}

	public void setJobDetailsId(Long jobDetailsId) {
		this.jobDetailsId = jobDetailsId;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getSalaryRange() {
		return salaryRange;
	}

	public void setSalaryRange(String salaryRange) {
		this.salaryRange = salaryRange;
	}

	public String getSalaryType() {
		return salaryType;
	}

	public void setSalaryType(String salaryType) {
		this.salaryType = salaryType;
	}

	public String getHowManyHires() {
		return howManyHires;
	}

	public void setHowManyHires(String howManyHires) {
		this.howManyHires = howManyHires;
	}

	public String getHowUrgentlyRequired() {
		return howUrgentlyRequired;
	}

	public void setHowUrgentlyRequired(String howUrgentlyRequired) {
		this.howUrgentlyRequired = howUrgentlyRequired;
	}

	public String getAdditionalDetails() {
		return additionalDetails;
	}

	public void setAdditionalDetails(String additionalDetails) {
		this.additionalDetails = additionalDetails;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getJobSummary() {
		return jobSummary;
	}

	public void setJobSummary(String jobSummary) {
		this.jobSummary = jobSummary;
	}

	public String getResponsibilitiesAndDuties() {
		return responsibilitiesAndDuties;
	}

	public void setResponsibilitiesAndDuties(String responsibilitiesAndDuties) {
		this.responsibilitiesAndDuties = responsibilitiesAndDuties;
	}

	public String getQualificationsAndSkills() {
		return qualificationsAndSkills;
	}

	public void setQualificationsAndSkills(String qualificationsAndSkills) {
		this.qualificationsAndSkills = qualificationsAndSkills;
	}

	public String getBenefits() {
		return benefits;
	}

	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public EmployerDetails getEmployerDetails() {
		return employerDetails;
	}

	public void setEmployerDetails(EmployerDetails employerDetails) {
		this.employerDetails = employerDetails;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
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
}