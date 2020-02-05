/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   01-Nov-2019 
*/
package com.ais.jb.response.model;

public class WebAwardsOrAchievementsDetails {
	private Long awardsOrAchievementsDetailsId;
	private String title;
	private String dateAwarded;
	private String description; 

	public Long getAwardsOrAchievementsDetailsId() {
		return awardsOrAchievementsDetailsId;
	}

	public void setAwardsOrAchievementsDetailsId(Long awardsOrAchievementsDetailsId) {
		this.awardsOrAchievementsDetailsId = awardsOrAchievementsDetailsId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDateAwarded() {
		return dateAwarded;
	}

	public void setDateAwarded(String dateAwarded) {
		this.dateAwarded = dateAwarded;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}