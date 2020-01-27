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
@Table(name = "skill_details")
@EntityListeners(AuditingEntityListener.class)
public class SkillDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "skill_details_id", length = 20, nullable = false)
	private Long skillDetailsId;

	@Column(name = "skill", length = 100, nullable = false)
	private String skill;
	
	@Column(name = "experience", length = 50, nullable = false)
	private String experience;
	
	@OneToOne
	@JoinColumn(name = "user_details_id")
	private UserDetails userDetails;

	public Long getSkillDetailsId() {
		return skillDetailsId;
	}

	public void setSkillDetailsId(Long skillDetailsId) {
		this.skillDetailsId = skillDetailsId;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
}