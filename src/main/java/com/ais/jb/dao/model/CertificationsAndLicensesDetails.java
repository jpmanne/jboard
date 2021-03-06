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

import com.ais.jb.response.model.WebCertificationsAndLicensesDetails;

@Entity
@Table(name = "certifications_and_licenses_details")
@EntityListeners(AuditingEntityListener.class)
public class CertificationsAndLicensesDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "certifications_and_licenses_details_id", length = 20, nullable = false)
	private Long certificationsAndLicensesDetailsId;

	@Column(name = "title", length = 150, nullable = false)
	private String title;
	
	@Column(name = "description", nullable = true, length = 65535, columnDefinition = "text")
	private String description; 
	
	@Column(name = "time_period_from", length = 15, nullable = false)
	private String timePeriodFrom;
	
	@Column(name = "time_period_to", length = 15, nullable = false)
	private String timePeriodTo;
	
	@OneToOne
	@JoinColumn(name = "user_details_id")
	private UserDetails userDetails;

	public Long getCertificationsAndLicensesDetailsId() {
		return certificationsAndLicensesDetailsId;
	}

	public void setCertificationsAndLicensesDetailsId(Long certificationsAndLicensesDetailsId) {
		this.certificationsAndLicensesDetailsId = certificationsAndLicensesDetailsId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTimePeriodFrom() {
		return timePeriodFrom;
	}

	public void setTimePeriodFrom(String timePeriodFrom) {
		this.timePeriodFrom = timePeriodFrom;
	}

	public String getTimePeriodTo() {
		return timePeriodTo;
	}

	public void setTimePeriodTo(String timePeriodTo) {
		this.timePeriodTo = timePeriodTo;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	public WebCertificationsAndLicensesDetails getWebCertificationsAndLicensesDetails() {
		WebCertificationsAndLicensesDetails details = new WebCertificationsAndLicensesDetails();
		details.setCertificationsAndLicensesDetailsId(certificationsAndLicensesDetailsId);
		details.setTitle(title);
		details.setDescription(description);
		details.setTimePeriodFrom(timePeriodFrom);
		details.setTimePeriodTo(timePeriodTo);
		return details;
	}
}