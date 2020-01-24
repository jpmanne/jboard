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
@Table(name = "user_credentials")
@EntityListeners(AuditingEntityListener.class)
public class UserCredentials {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_credentials_id", length = 20, nullable = false)
	private Long userCredentialsId;

	@Column(name = "user_name", length = 32, nullable = false)
	private String userName;
	
	@Column(name = "password", length = 150, nullable = false)
	private String password;
	
	@OneToOne
	@JoinColumn(name = "role_id")
	private RoleDetails roleDetails;
	
	@Column(name = "status", length = 1, nullable = false)
	private String status;

	public Long getUserCredentialsId() {
		return userCredentialsId;
	}

	public void setUserCredentialsId(Long userCredentialsId) {
		this.userCredentialsId = userCredentialsId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleDetails getRoleDetails() {
		return roleDetails;
	}

	public void setRoleDetails(RoleDetails roleDetails) {
		this.roleDetails = roleDetails;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}