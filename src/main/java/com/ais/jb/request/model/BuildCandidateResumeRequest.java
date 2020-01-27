/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   01-Nov-2019 
*/
package com.ais.jb.request.model;

import java.io.Serializable;
import java.util.List;

import com.ais.jb.dao.model.AwardsOrAchievementsDetails;
import com.ais.jb.dao.model.CertificationsAndLicensesDetails;
import com.ais.jb.dao.model.EducationDetails;
import com.ais.jb.dao.model.MilitaryServiceDetails;
import com.ais.jb.dao.model.NonProfitStudentOrganizationsDetails;
import com.ais.jb.dao.model.OnlineProfileDetails;
import com.ais.jb.dao.model.ProjectsOrPapersPresentedDetails;
import com.ais.jb.dao.model.SkillDetails;
import com.ais.jb.dao.model.WorkExperienceDetails;

public class BuildCandidateResumeRequest implements Serializable {
	private static final long serialVersionUID = -9018591349826302604L;
	private String email;
	private String password;
	private String name;
	private String lastName;
	private String phoneNumber;
	private String headLine;
	private String objective; 
	private String city;
	private String state;
	private String pinCode;
	private String country;
	private String relocation;
	
	//Work Experience Details
	private List<WorkExperienceDetails> workExperiences;
	
	//Education Details
	private List<EducationDetails> educations;
	
	//Skills / IT Skills Details
	private List<SkillDetails> skills;
	
	//Online Profile
	private OnlineProfileDetails onlineProfileDetails;
	
	//Military Service Details
	private MilitaryServiceDetails militaryServiceDetails;
	
	//Awards / Achievements Details
	List<AwardsOrAchievementsDetails> awardsOrAchievements;
	
	//Certifications and Licenses Details
	List<CertificationsAndLicensesDetails> certificationsAndLinceses;
	
	//Non-Profit Student Organizations Details
	List<NonProfitStudentOrganizationsDetails> nonProfitStudentOrganizations;
	
	//Projects / Papers Presented Details
	List<ProjectsOrPapersPresentedDetails> projectsOrPapersPresented;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public List<WorkExperienceDetails> getWorkExperiences() {
		return workExperiences;
	}

	public void setWorkExperiences(List<WorkExperienceDetails> workExperiences) {
		this.workExperiences = workExperiences;
	}

	public List<EducationDetails> getEducations() {
		return educations;
	}

	public void setEducations(List<EducationDetails> educations) {
		this.educations = educations;
	}

	public List<SkillDetails> getSkills() {
		return skills;
	}

	public void setSkills(List<SkillDetails> skills) {
		this.skills = skills;
	}

	public OnlineProfileDetails getOnlineProfileDetails() {
		return onlineProfileDetails;
	}

	public void setOnlineProfileDetails(OnlineProfileDetails onlineProfileDetails) {
		this.onlineProfileDetails = onlineProfileDetails;
	}

	public MilitaryServiceDetails getMilitaryServiceDetails() {
		return militaryServiceDetails;
	}

	public void setMilitaryServiceDetails(MilitaryServiceDetails militaryServiceDetails) {
		this.militaryServiceDetails = militaryServiceDetails;
	}

	public List<AwardsOrAchievementsDetails> getAwardsOrAchievements() {
		return awardsOrAchievements;
	}

	public void setAwardsOrAchievements(List<AwardsOrAchievementsDetails> awardsOrAchievements) {
		this.awardsOrAchievements = awardsOrAchievements;
	}

	public List<CertificationsAndLicensesDetails> getCertificationsAndLinceses() {
		return certificationsAndLinceses;
	}

	public void setCertificationsAndLinceses(List<CertificationsAndLicensesDetails> certificationsAndLinceses) {
		this.certificationsAndLinceses = certificationsAndLinceses;
	}

	public List<NonProfitStudentOrganizationsDetails> getNonProfitStudentOrganizations() {
		return nonProfitStudentOrganizations;
	}

	public void setNonProfitStudentOrganizations(List<NonProfitStudentOrganizationsDetails> nonProfitStudentOrganizations) {
		this.nonProfitStudentOrganizations = nonProfitStudentOrganizations;
	}

	public List<ProjectsOrPapersPresentedDetails> getProjectsOrPapersPresented() {
		return projectsOrPapersPresented;
	}

	public void setProjectsOrPapersPresented(List<ProjectsOrPapersPresentedDetails> projectsOrPapersPresented) {
		this.projectsOrPapersPresented = projectsOrPapersPresented;
	}
}