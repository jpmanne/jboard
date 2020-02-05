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

import com.ais.jb.response.model.WebProjectsOrPapersPresentedDetails;

@Entity
@Table(name = "projects_or_papers_presented_details")
@EntityListeners(AuditingEntityListener.class)
public class ProjectsOrPapersPresentedDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "projects_or_papers_presented_details_id", length = 20, nullable = false)
	private Long projectsOrPapersPresentedDetailsId;

	@Column(name = "title", length = 150, nullable = false)
	private String title;
	
	@Column(name = "url", length = 150, nullable = false)
	private String url;
	
	@Column(name = "description", nullable = true, length = 65535, columnDefinition = "text")
	private String description; 
	
	@Column(name = "additional_information", nullable = true, length = 65535, columnDefinition = "text")
	private String additionalInformation; 
	
	@Column(name = "date_published", length = 15, nullable = false)
	private String datePublished;
	
	@OneToOne
	@JoinColumn(name = "user_details_id")
	private UserDetails userDetails;

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

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	public WebProjectsOrPapersPresentedDetails getWebProjectsOrPapersPresentedDetails() {
		WebProjectsOrPapersPresentedDetails details = new WebProjectsOrPapersPresentedDetails();
		details.setProjectsOrPapersPresentedDetailsId(projectsOrPapersPresentedDetailsId);
		details.setTitle(title);
		details.setUrl(url);
		details.setDescription(description);
		details.setAdditionalInformation(additionalInformation);
		details.setDatePublished(datePublished);
		return details;
	}
}