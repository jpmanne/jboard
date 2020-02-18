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
public interface JobRepository extends JpaRepository<JobDetails, Long>, JobRepositoryCustom {

	@Query("select a from JobDetails a where a.jobCode = :jobCode")
	List<JobDetails> getJobDetailsByJobCode(@Param("jobCode") String jobCode);
	
	//select * from job_details where job_title REGEXP 'loe|thdde' or experience_qualification REGEXP 'loe|thdde';
	/*job_title, job_summary, experience_qualification, license_qualification, responsibilities_and_duties, qualifications_and_skills, company
	city or state*/
	StringBuilder searchJobsQuery = new StringBuilder("");
	
	@Query(value = "select * from job_details where job_title REGEXP ?1 or job_summary REGEXP ?2 "
	+ "or experience_qualification REGEXP ?3 or license_qualification REGEXP ?4 or company REGEXP ?5 "
	+ "or responsibilities_and_duties REGEXP ?6 or qualifications_and_skills REGEXP ?7", nativeQuery = true)
	List<JobDetails> getJobs(@Param("1") String searchTerm1, @Param("2") String searchTerm2, @Param("3") String searchTerm3, 
	@Param("4") String searchTerm4, @Param("5") String searchTerm5, @Param("6") String searchTerm6 , @Param("7") String searchTerm7);
}
