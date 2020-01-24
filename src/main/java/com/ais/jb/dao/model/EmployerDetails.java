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
@Table(name = "employer_details")
@EntityListeners(AuditingEntityListener.class)
public class EmployerDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employer_details_id", length = 20, nullable = false)
	private Long employerDetailsId;

	@Column(name = "employer_name", length = 150, nullable = false)
	private String employerName;
	
	@Column(name = "email", length = 150, nullable = false)
	private String email;
	
	@Column(name = "phone_number", length = 15, nullable = false)
	private String phoneNumber;
	
	@Column(name = "address1", length = 150, nullable = true)
	private String address1;
	
	@Column(name = "address2", length = 150, nullable = true)
	private String address2;
	
	@OneToOne
	@JoinColumn(name = "user_credentials_id")
	private UserCredentials userCredentials;

	public Long getEmployerDetailsId() {
		return employerDetailsId;
	}

	public void setEmployerDetailsId(Long employerDetailsId) {
		this.employerDetailsId = employerDetailsId;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public UserCredentials getUserCredentials() {
		return userCredentials;
	}

	public void setUserCredentials(UserCredentials userCredentials) {
		this.userCredentials = userCredentials;
	}
}