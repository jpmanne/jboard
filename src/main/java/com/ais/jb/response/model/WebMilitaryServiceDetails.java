/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   01-Nov-2019 
*/
package com.ais.jb.response.model;

public class WebMilitaryServiceDetails {
	private Long militaryServiceDetailsId;
	private String serviceCountry;
	private String branch; 
	private String rank; 
	private String description; 
	private String commendations; 
	private String timePeriodFrom;
	private String timePeriodTo;
	
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
}