/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   01-Nov-2019 
*/
package com.ais.jb.request.model;

import java.io.Serializable;
import java.util.List;

public class PostJobRequest implements Serializable {
	private static final long serialVersionUID = 5814919948894367355L;
	private String jobTitle;
	private String companyName;
	private String city;
	private String state;
	private String country;
	private String jobType; //Full Time, Part Time
	private String salaryRange; // Number or As per the industry standard
	private String salaryType;  // Per Year, Per Month, Per Day, Per Hour 
	private String howManyHires;
	private String howUrgentlyRequired;
	private String additionalDetails;
	private String industry;
	private String jobSummary;
	private String responsibilitiesAndDuties;
	private String qualificationsAndSkills;
	private String benefits;
	
	//Job Application Settings
	private String receiveApplications;
	private String emailAddresses;
	private String inpersonAddresses;
	private String newApplicatantsInformed;
	private String submitResume;

	//Job Application Qualifications
	private String notifyRequired;
	private String experienceQualifications;
	private String licenseQualifications;
	private String languageQualifications;
	private String educationQualification;
	private String locationQualification;
	private String shiftAvailabilityQualification;
	private String willingToTravelQualification;
	private String requiredDocumentsQualification;
	private String startDateQualification;
	private String expectedCtcQualification;
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
	public String getExperienceQualifications() {
		return experienceQualifications;
	}
	public void setExperienceQualifications(String experienceQualifications) {
		this.experienceQualifications = experienceQualifications;
	}
	public String getLicenseQualifications() {
		return licenseQualifications;
	}
	public void setLicenseQualifications(String licenseQualifications) {
		this.licenseQualifications = licenseQualifications;
	}
	public String getLanguageQualifications() {
		return languageQualifications;
	}
	public void setLanguageQualifications(String languageQualifications) {
		this.languageQualifications = languageQualifications;
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
