/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   01-Nov-2019 
*/
package com.ais.jb.response.model;

public class WebProjectsOrPapersPresentedDetails {
	private Long projectsOrPapersPresentedDetailsId;
	private String title;
	private String url;
	private String description; 
	private String additionalInformation; 
	private String datePublished;

	public Long getProjectsOrPapersPresentedDetailsId() {
		return projectsOrPapersPresentedDetailsId;
	}

	public void setProjectsOrPapersPresentedDetailsId(Long projectsOrPapersPresentedDetailsId) {
		this.projectsOrPapersPresentedDetailsId = projectsOrPapersPresentedDetailsId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	public String getDatePublished() {
		return datePublished;
	}

	public void setDatePublished(String datePublished) {
		this.datePublished = datePublished;
	}
}