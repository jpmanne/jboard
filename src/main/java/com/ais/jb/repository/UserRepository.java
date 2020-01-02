/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   01-Nov-2019 
*/
package com.ais.jb.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ais.jb.dao.model.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {
	
	@Query("SELECT a FROM UserDetails a WHERE a.userName = :userName AND a.password = :password")
	List<UserDetails> getUserByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);
	
	List<UserDetails> getUsersByDateOfBirth(Date dateOfBirth);
	
	@Query("SELECT a FROM UserDetails a WHERE a.status = :status")
	List<UserDetails> getAllUsers(String status);
	
	@Query("SELECT a FROM UserDetails a WHERE a.userDetailsId = :userDetailsId")
	List<UserDetails> getUsers(Long userDetailsId);
	
	//https://javadeveloperzone.com/spring/spring-jpa-query-in-clause-example/
	@Query("SELECT a FROM UserDetails a WHERE a.userDetailsId IN (:userDetailsIds)")
	List<UserDetails> findByUserDetailsIds(@Param("userDetailsIds")List<Long> userDetailsIds);

}
