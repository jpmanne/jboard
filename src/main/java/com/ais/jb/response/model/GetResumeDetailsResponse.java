/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   01-Nov-2019 
*/
package com.ais.jb.response.model;

import java.io.Serializable;
import java.util.List;

public class GetResumeDetailsResponse implements Serializable {
	private static final long serialVersionUID = -5367385197878504823L;
	private String message;
	private String authCode;
	private String email;
	private String name;
	private String lastName;
	private String headLine;
	private String objective;
	private String city;
	private String state;
	private String pinCode;
	private String country;
	private String phoneNumber;
	private String relocate;
	private String resumeCode;
	private List<WebWorkExperienceDetails> workExperiences;
	private List<WebEducationDetails> educations;
	private List<WebSkillDetails> skills;
	private List<WebAwardsOrAchievementsDetails> awardsOrAchievements;
	private List<WebCertificationsAndLicensesDetails> certificationsAndLincenses;
	private List<WebNonProfitStudentOrganizationsDetails> nonProfitStudentOrganizations;
	private List<WebProjectsOrPapersPresentedDetails> projectsOrPapersPresented;
	private WebOnlineProfileDetails onlineProfileDetails;
	private WebMilitaryServiceDetails militaryServiceDetails;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getRelocate() {
		return relocate;
	}
	public void setRelocate(String relocate) {
		this.relocate = relocate;
	}
	public String getResumeCode() {
		return resumeCode;
	}
	public void setResumeCode(String resumeCode) {
		this.resumeCode = resumeCode;
	}
	public List<WebWorkExperienceDetails> getWorkExperiences() {
		return workExperiences;
	}
	public void setWorkExperiences(List<WebWorkExperienceDetails> workExperiences) {
		this.workExperiences = workExperiences;
	}
	public List<WebEducationDetails> getEducations() {
		return educations;
	}
	public void setEducations(List<WebEducationDetails> educations) {
		this.educations = educations;
	}
	public List<WebSkillDetails> getSkills() {
		return skills;
	}
	public void setSkills(List<WebSkillDetails> skills) {
		this.skills = skills;
	}
	public List<WebAwardsOrAchievementsDetails> getAwardsOrAchievements() {
		return awardsOrAchievements;
	}
	public void setAwardsOrAchievements(List<WebAwardsOrAchievementsDetails> awardsOrAchievements) {
		this.awardsOrAchievements = awardsOrAchievements;
	}
	public List<WebCertificationsAndLicensesDetails> getCertificationsAndLincenses() {
		return certificationsAndLincenses;
	}
	public void setCertificationsAndLincenses(List<WebCertificationsAndLicensesDetails> certificationsAndLincenses) {
		this.certificationsAndLincenses = certificationsAndLincenses;
	}
	public List<WebNonProfitStudentOrganizationsDetails> getNonProfitStudentOrganizations() {
		return nonProfitStudentOrganizations;
	}
	public void setNonProfitStudentOrganizations(
			List<WebNonProfitStudentOrganizationsDetails> nonProfitStudentOrganizations) {
		this.nonProfitStudentOrganizations = nonProfitStudentOrganizations;
	}
	public List<WebProjectsOrPapersPresentedDetails> getProjectsOrPapersPresented() {
		return projectsOrPapersPresented;
	}
	public void setProjectsOrPapersPresented(List<WebProjectsOrPapersPresentedDetails> projectsOrPapersPresented) {
		this.projectsOrPapersPresented = projectsOrPapersPresented;
	}
	public WebOnlineProfileDetails getOnlineProfileDetails() {
		return onlineProfileDetails;
	}
	public void setOnlineProfileDetails(WebOnlineProfileDetails onlineProfileDetails) {
		this.onlineProfileDetails = onlineProfileDetails;
	}
	public WebMilitaryServiceDetails getMilitaryServiceDetails() {
		return militaryServiceDetails;
	}
	public void setMilitaryServiceDetails(WebMilitaryServiceDetails militaryServiceDetails) {
		this.militaryServiceDetails = militaryServiceDetails;
	}
}
