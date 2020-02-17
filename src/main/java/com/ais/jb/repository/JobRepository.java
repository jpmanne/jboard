/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   01-Nov-2019 
*/
package com.ais.jb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ais.jb.dao.model.JobDetails;

@Repository
public interface JobRepository extends JpaRepository<JobDetails, Long> {

	@Query("select a from JobDetails a where a.jobCode = :jobCode")
	List<JobDetails> getJobDetailsByJobCode(@Param("jobCode") String jobCode);
	
}
