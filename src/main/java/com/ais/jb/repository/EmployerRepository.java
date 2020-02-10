/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   01-Nov-2019 
*/
package com.ais.jb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ais.jb.dao.model.EmployerDetails;

@Repository
public interface EmployerRepository extends JpaRepository<EmployerDetails, Long> {
	
	@Query("select a from EmployerDetails a where a.userDetails.userDetailsId = ?1")
	Optional<EmployerDetails> findById(Long userDetailsId);
}
