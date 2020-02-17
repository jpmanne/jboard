/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   01-Nov-2019 
*/
package com.ais.jb.response.model;

import java.util.Date;

public class WebJobDetails {
	private Long jobDetailsId;
	private String jobCode;
	private String jobTitle;
	private String company;
	private String city;
	private String state;
	private String country;
	private String jobType;
	private String salaryRange;
	private String salaryType;
	private String howManyHires;
	private String howUrgentlyRequired;
	private String additionalDetails;
	private String industry;
	private String jobSummary;
	private String responsibilitiesAndDuties;
	private String qualificationsAndSkills;
	private String benefits;
	private String status;
	private Date createdAt;
	private Long employerDetailsId;

	//Job Application Settings
	private String receiveApplications;
	private String emailAddresses;
	private String inpersonAddresses;
	private String newApplicatantsInformed;
	private String submitResume;
	
	//Job Application Qualifications
	private String notifyRequired;
	private String experienceQualification;
	private String licenseQualification;
	private String languageQualification;
	private String educationQualification;
	private String locationQualification;
	private String shiftAvailabilityQualification;
	private String willingToTravelQualification;
	private String requiredDocumentsQualification;
	private String startDateQualification;
	private String expectedCtcQualification;
	public Long getJobDetailsId() {
		return jobDetailsId;
	}
	public String getJobCode() {
		return jobCode;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public String getCompany() {
		return company;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getCountry() {
		return country;
	}
	public String getJobType() {
		return jobType;
	}
	public String getSalaryRange() {
		return salaryRange;
	}
	public String getSalaryType() {
		return salaryType;
	}
	public String getHowManyHires() {
		return howManyHires;
	}
	public String getHowUrgentlyRequired() {
		return howUrgentlyRequired;
	}
	public String getAdditionalDetails() {
		return additionalDetails;
	}
	public String getIndustry() {
		return industry;
	}
	public String getJobSummary() {
		return jobSummary;
	}
	public String getResponsibilitiesAndDuties() {
		return responsibilitiesAndDuties;
	}
	public String getQualificationsAndSkills() {
		return qualificationsAndSkills;
	}
	public String getBenefits() {
		return benefits;
	}
	public String getStatus() {
		return status;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public Long getEmployerDetailsId() {
		return employerDetailsId;
	}
	public String getReceiveApplications() {
		return receiveApplications;
	}
	public String getEmailAddresses() {
		return emailAddresses;
	}
	public String getInpersonAddresses() {
		return inpersonAddresses;
	}
	public String getNewApplicatantsInformed() {
		return newApplicatantsInformed;
	}
	public String getSubmitResume() {
		return submitResume;
	}
	public String getNotifyRequired() {
		return notifyRequired;
	}
	public String getExperienceQualification() {
		return experienceQualification;
	}
	public String getLicenseQualification() {
		return licenseQualification;
	}
	public String getLanguageQualification() {
		return languageQualification;
	}
	public String getEducationQualification() {
		return educationQualification;
	}
	public String getLocationQualification() {
		return locationQualification;
	}
	public String getShiftAvailabilityQualification() {
		return shiftAvailabilityQualification;
	}
	public String getWillingToTravelQualification() {
		return willingToTravelQualification;
	}
	public String getRequiredDocumentsQualification() {
		return requiredDocumentsQualification;
	}
	public String getStartDateQualification() {
		return startDateQualification;
	}
	public String getExpectedCtcQualification() {
		return expectedCtcQualification;
	}
	public void setJobDetailsId(Long jobDetailsId) {
		this.jobDetailsId = jobDetailsId;
	}
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public void setSalaryRange(String salaryRange) {
		this.salaryRange = salaryRange;
	}
	public void setSalaryType(String salaryType) {
		this.salaryType = salaryType;
	}
	public void setHowManyHires(String howManyHires) {
		this.howManyHires = howManyHires;
	}
	public void setHowUrgentlyRequired(String howUrgentlyRequired) {
		this.howUrgentlyRequired = howUrgentlyRequired;
	}
	public void setAdditionalDetails(String additionalDetails) {
		this.additionalDetails = additionalDetails;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public void setJobSummary(String jobSummary) {
		this.jobSummary = jobSummary;
	}
	public void setResponsibilitiesAndDuties(String responsibilitiesAndDuties) {
		this.responsibilitiesAndDuties = responsibilitiesAndDuties;
	}
	public void setQualificationsAndSkills(String qualificationsAndSkills) {
		this.qualificationsAndSkills = qualificationsAndSkills;
	}
	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public void setEmployerDetailsId(Long employerDetailsId) {
		this.employerDetailsId = employerDetailsId;
	}
	public void setReceiveApplications(String receiveApplications) {
		this.receiveApplications = receiveApplications;
	}
	public void setEmailAddresses(String emailAddresses) {
		this.emailAddresses = emailAddresses;
	}
	public void setInpersonAddresses(String inpersonAddresses) {
		this.inpersonAddresses = inpersonAddresses;
	}
	public void setNewApplicatantsInformed(String newApplicatantsInformed) {
		this.newApplicatantsInformed = newApplicatantsInformed;
	}
	public void setSubmitResume(String submitResume) {
		this.submitResume = submitResume;
	}
	public void setNotifyRequired(String notifyRequired) {
		this.notifyRequired = notifyRequired;
	}
	public void setExperienceQualification(String experienceQualification) {
		this.experienceQualification = experienceQualification;
	}
	public void setLicenseQualification(String licenseQualification) {
		this.licenseQualification = licenseQualification;
	}
	public void setLanguageQualification(String languageQualification) {
		this.languageQualification = languageQualification;
	}
	public void setEducationQualification(String educationQualification) {
		this.educationQualification = educationQualification;
	}
	public void setLocationQualification(String locationQualification) {
		this.locationQualification = locationQualification;
	}
	public void setShiftAvailabilityQualification(String shiftAvailabilityQualification) {
		this.shiftAvailabilityQualification = shiftAvailabilityQualification;
	}
	public void setWillingToTravelQualification(String willingToTravelQualification) {
		this.willingToTravelQualification = willingToTravelQualification;
	}
	public void setRequiredDocumentsQualification(String requiredDocumentsQualification) {
		this.requiredDocumentsQualification = requiredDocumentsQualification;
	}
	public void setStartDateQualification(String startDateQualification) {
		this.startDateQualification = startDateQualification;
	}
	public void setExpectedCtcQualification(String expectedCtcQualification) {
		this.expectedCtcQualification = expectedCtcQualification;
	}
}