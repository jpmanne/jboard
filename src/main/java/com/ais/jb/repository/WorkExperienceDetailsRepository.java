/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   01-Nov-2019 
*/
package com.ais.jb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.ais.jb.dao.model.WorkExperienceDetails;

@Repository
public interface WorkExperienceDetailsRepository extends JpaRepository<WorkExperienceDetails, Long> {

	@Query("SELECT w FROM WorkExperienceDetails w WHERE w.userDetails.userDetailsId = :userDetailsId") 
	List<WorkExperienceDetails> getWorkExperiences(Long userDetailsId);
}
