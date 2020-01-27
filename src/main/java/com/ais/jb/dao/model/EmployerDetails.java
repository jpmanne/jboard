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
@Table(name = "employer_details")
@EntityListeners(AuditingEntityListener.class)
public class EmployerDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employer_details_id", length = 20, nullable = false)
	private Long employerDetailsId;

	@Column(name = "company_name", length = 150, nullable = false)
	private String companyName;
	
	@Column(name = "company_size", length = 25, nullable = false)
	private String companySize;
	
	@Column(name = "recruiter_hiring_for_client", length = 15, nullable = false)
	private String recruiterHiringForClient;
	
	@Column(name = "how_hear_about_us", length = 100, nullable = false)
	private String howHearAboutUs;
	
	@OneToOne
	@JoinColumn(name = "user_details_id")
	private UserDetails userDetails;

	public Long getEmployerDetailsId() {
		return employerDetailsId;
	}

	public void setEmployerDetailsId(Long employerDetailsId) {
		this.employerDetailsId = employerDetailsId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanySize() {
		return companySize;
	}

	public void setCompanySize(String companySize) {
		this.companySize = companySize;
	}

	public String getRecruiterHiringForClient() {
		return recruiterHiringForClient;
	}

	public void setRecruiterHiringForClient(String recruiterHiringForClient) {
		this.recruiterHiringForClient = recruiterHiringForClient;
	}

	public String getHowHearAboutUs() {
		return howHearAboutUs;
	}

	public void setHowHearAboutUs(String howHearAboutUs) {
		this.howHearAboutUs = howHearAboutUs;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
}