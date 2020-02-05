/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   01-Nov-2019 
*/
package com.ais.jb.response.model;

public class WebOnlineProfileDetails {
	private Long onlineProfileDetailsId;
	private String linkAddress;

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
}