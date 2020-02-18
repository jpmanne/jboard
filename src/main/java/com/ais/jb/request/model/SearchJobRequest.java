/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   01-Nov-2019 
*/
package com.ais.jb.request.model;

import java.io.Serializable;

public class SearchJobRequest implements Serializable {
	private static final long serialVersionUID = 5814919948894337655L;
	private String searchTermWhat;
	private String searchTermWhere;
	private String companyName;
	private String jobType; //Full Time, Part Time
	private String location;

	public String getSearchTermWhat() {
		return searchTermWhat;
	}
	public String getSearchTermWhere() {
		return searchTermWhere;
	}
	public String getCompanyName() {
		return companyName;
	}
	public String getJobType() {
		return jobType;
	}
	public String getLocation() {
		return location;
	}
	public void setSearchTermWhat(String searchTermWhat) {
		this.searchTermWhat = searchTermWhat;
	}
	public void setSearchTermWhere(String searchTermWhere) {
		this.searchTermWhere = searchTermWhere;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
