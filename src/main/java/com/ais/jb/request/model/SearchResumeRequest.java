/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   01-Nov-2019 
*/
package com.ais.jb.request.model;

import java.io.Serializable;

public class SearchResumeRequest implements Serializable {
	private static final long serialVersionUID = 5814919948894373655L;
	private String searchTermWhat;
	private String searchTermWhere;
	private String searchFields;
	public String getSearchTermWhat() {
		return searchTermWhat;
	}
	public String getSearchTermWhere() {
		return searchTermWhere;
	}
	public String getSearchFields() {
		return searchFields;
	}
	public void setSearchTermWhat(String searchTermWhat) {
		this.searchTermWhat = searchTermWhat;
	}
	public void setSearchTermWhere(String searchTermWhere) {
		this.searchTermWhere = searchTermWhere;
	}
	public void setSearchFields(String searchFields) {
		this.searchFields = searchFields;
	}
}
