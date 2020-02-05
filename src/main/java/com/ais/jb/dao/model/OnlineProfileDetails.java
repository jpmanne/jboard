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

import com.ais.jb.response.model.WebOnlineProfileDetails;

@Entity
@Table(name = "online_profile_details")
@EntityListeners(AuditingEntityListener.class)
public class OnlineProfileDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "online_profile_details_id", length = 20, nullable = false)
	private Long onlineProfileDetailsId;

	@Column(name = "link_address", length = 255, nullable = false)
	private String linkAddress;
	
	@OneToOne
	@JoinColumn(name = "user_details_id")
	private UserDetails userDetails;

	public Long getOnlineProfileDetailsId() {
		return onlineProfileDetailsId;
	}

	public void setOnlineProfileDetailsId(Long onlineProfileDetailsId) {
		this.onlineProfileDetailsId = onlineProfileDetailsId;
	}

	public String getLinkAddress() {
		return linkAddress;
	}

	public void setLinkAddress(String linkAddress) {
		this.linkAddress = linkAddress;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	public WebOnlineProfileDetails getWebOnlineProfileDetails() {
		WebOnlineProfileDetails details = new WebOnlineProfileDetails();
		details.setOnlineProfileDetailsId(onlineProfileDetailsId);
		details.setLinkAddress(linkAddress);
		return details;
	}
}