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

import com.ais.jb.dao.model.MilitaryServiceDetails;

@Repository
public interface MilitaryServiceDetailsRepository extends JpaRepository<MilitaryServiceDetails, Long> {

	@Query("select a from MilitaryServiceDetails a where a.userDetails.userDetailsId = ?1")
	Optional<MilitaryServiceDetails> findById(Long userDetailsId);
}
