package com.ais.jb.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ais.jb.dao.model.JobDetails;

public class JobRepositoryImpl implements JobRepositoryCustom {

	@PersistenceContext
	private EntityManager em; // here you will get plain EntityManager impl.
	
	@Override
	public List<JobDetails> findCustomNativeQueryDetails(String query) {
		TypedQuery<JobDetails> q=em.createQuery(query, JobDetails.class);
		return q.getResultList();
	}

}
