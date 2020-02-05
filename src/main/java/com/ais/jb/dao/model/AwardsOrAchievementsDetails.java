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

import com.ais.jb.response.model.WebAwardsOrAchievementsDetails;

@Entity
@Table(name = "awards_achievements_details")
@EntityListeners(AuditingEntityListener.class)
public class AwardsOrAchievementsDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "awards_achievements_details_id", length = 20, nullable = false)
	private Long awardsOrAchievementsDetailsId;

	@Column(name = "title", length = 100, nullable = false)
	private String title;
	
	@Column(name = "date_awarded", length = 50, nullable = false)
	private String dateAwarded;
	
	@Column(name = "description", nullable = true, length = 65535, columnDefinition = "text")
	private String description; 
	
	@OneToOne
	@JoinColumn(name = "user_details_id")
	private UserDetails userDetails;

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

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	public WebAwardsOrAchievementsDetails getWebAwardsOrAchievementsDetails() {
		WebAwardsOrAchievementsDetails details = new WebAwardsOrAchievementsDetails();
		details.setAwardsOrAchievementsDetailsId(awardsOrAchievementsDetailsId);
		details.setTitle(title);
		details.setDateAwarded(dateAwarded);
		details.setDescription(description);
		return details;
	}
}