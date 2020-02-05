/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   01-Nov-2019 
*/
package com.ais.jb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ais.jb.dao.model.NonProfitStudentOrganizationsDetails;

@Repository
public interface StudentOrganizationsRepository extends JpaRepository<NonProfitStudentOrganizationsDetails, Long> {
	
	@Query("SELECT a FROM NonProfitStudentOrganizationsDetails a WHERE a.userDetails.userDetailsId = :userDetailsId") 
	List<NonProfitStudentOrganizationsDetails> getNonProfitStudentOrganizations(Long userDetailsId);

}
