/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   01-Nov-2019 
*/
package com.ais.jb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ais.jb.dao.model.ResumeDetails;

@Repository
public interface ResumeRepository extends JpaRepository<ResumeDetails, Long> {
	/*SELECT * FROM resume_details rd 
	LEFT OUTER JOIN work_experience_details wed ON rd.user_details_id = wed.user_details_id
	LEFT OUTER JOIN skill_details sd ON rd.user_details_id = sd.user_details_id
	LEFT OUTER JOIN education_details ed ON rd.user_details_id = ed.user_details_id
	WHERE rd.head_line REGEXP 'sof'
	and (rd.city REGEXP 'abc' or rd.state REGEXP 'abc' or rd.pin_code REGEXP '500')
	*/
	
	@Query("select a from ResumeDetails a where a.userDetails.userDetailsId = ?1")
	Optional<ResumeDetails> findById(Long userDetailsId);
	
	@Query(value = "select * from resume_details where head_line REGEXP ?1", nativeQuery = true)
	List<ResumeDetails> getResumesByHeadLine(@Param("1") String searchTerm);
	
	@Query(value = "select * from resume_details where city REGEXP ?1 or state REGEXP ?2 or pin_code REGEXP ?3", nativeQuery = true)
	List<ResumeDetails> getResumesByLocation(@Param("1") String city, @Param("2") String state, @Param("3") String pinCode);
	
	@Query(value = "select * from resume_details where head_line REGEXP ?1 and (city REGEXP ?2 or state REGEXP ?3 or pin_code REGEXP ?4)", nativeQuery = true)
	List<ResumeDetails> getResumesByHeadLineAndLocation(@Param("1") String headLine, @Param("2") String city, @Param("3") String state, @Param("4") String pinCode);
}
