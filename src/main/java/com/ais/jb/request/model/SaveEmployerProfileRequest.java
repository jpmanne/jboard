/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   01-Nov-2019 
*/
package com.ais.jb.request.model;

import java.io.Serializable;

public class SaveEmployerProfileRequest implements Serializable {
	private static final long serialVersionUID = -9018591349826302604L;
	private String email;
	private String name;
	private String lastName;
	private String phoneNumber;
	private String companyName;
	private String companySize;
	private String howHearAboutUs;
	private String recruiterHiringForClient;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanySize() {
		return companySize;
	}
	public void setCompanySize(String companySize) {
		this.companySize = companySize;
	}
	public String getHowHearAboutUs() {
		return howHearAboutUs;
	}
	public void setHowHearAboutUs(String howHearAboutUs) {
		this.howHearAboutUs = howHearAboutUs;
	}
	public String getRecruiterHiringForClient() {
		return recruiterHiringForClient;
	}
	public void setRecruiterHiringForClient(String recruiterHiringForClient) {
		this.recruiterHiringForClient = recruiterHiringForClient;
	}
}
