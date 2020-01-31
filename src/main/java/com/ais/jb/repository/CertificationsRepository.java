/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   01-Nov-2019 
*/
package com.ais.jb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ais.jb.dao.model.CertificationsAndLicensesDetails;

@Repository
public interface CertificationsRepository extends JpaRepository<CertificationsAndLicensesDetails, Long> {

}
