package com.ais.jb.repository;

import java.util.List;

import com.ais.jb.dao.model.JobDetails;

public interface JobRepositoryCustom {

	List<JobDetails> findCustomNativeQueryDetails(String query);
}
