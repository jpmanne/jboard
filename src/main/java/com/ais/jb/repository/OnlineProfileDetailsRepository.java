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

import com.ais.jb.dao.model.OnlineProfileDetails;

@Repository
public interface OnlineProfileDetailsRepository extends JpaRepository<OnlineProfileDetails, Long> {

	@Query("select a from OnlineProfileDetails a where a.userDetails.userDetailsId = ?1")
	Optional<OnlineProfileDetails> findById(Long userDetailsId);
}
