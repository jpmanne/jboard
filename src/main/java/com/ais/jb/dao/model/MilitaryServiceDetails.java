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
@Table(name = "military_service_details")
@EntityListeners(AuditingEntityListener.class)
public class MilitaryServiceDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "military_service_details_id", length = 20, nullable = false)
	private Long militaryServiceDetailsId;

	@Column(name = "service_country", length = 150, nullable = false)
	private String serviceCountry;
	
	@Column(name = "branch", length = 100, nullable = false)
	private String branch; 
	
	@Column(name = "rank", length = 100, nullable = false)
	private String rank; 
	
	@Column(name = "description", nullable = true, length = 65535, columnDefinition = "text")
	private String description; 
	
	@Column(name = "commendations", nullable = true, length = 65535, columnDefinition = "text")
	private String commendations; 
	
	@Column(name = "time_period_from", length = 15, nullable = false)
	private String timePeriodFrom;
	
	@Column(name = "time_period_to", length = 15, nullable = false)
	private String timePeriodTo;
	
	@OneToOne
	@JoinColumn(name = "user_details_id")
	private UserDetails userDetails;

	public Long getMilitaryServiceDetailsId() {
		return militaryServiceDetailsId;
	}

	public void setMilitaryServiceDetailsId(Long militaryServiceDetailsId) {
		this.militaryServiceDetailsId = militaryServiceDetailsId;
	}

	public String getServiceCountry() {
		return serviceCountry;
	}

	public void setServiceCountry(String serviceCountry) {
		this.serviceCountry = serviceCountry;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCommendations() {
		return commendations;
	}

	public void setCommendations(String commendations) {
		this.commendations = commendations;
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
}