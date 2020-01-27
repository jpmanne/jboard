/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   23-Jan-2020 
*/
package com.ais.jb.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ais.jb.common.URLConstants;
import com.ais.jb.exception.JBoradException;
import com.ais.jb.model.Response;
import com.ais.jb.request.model.BuildCandidateResumeRequest;
import com.ais.jb.util.AppUtil;

@RestController
@RequestMapping(URLConstants.Resume.API_BASE)
public class ResumeController extends BaseController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ResumeController.class);
	
	//=========================================================================
	
		@PostMapping(URLConstants.Resume.BUILD_CANDIDATE_RESUME)
		public ResponseEntity<Response> buildCandidateResume(@Valid @RequestBody BuildCandidateResumeRequest buildCandidateResumeRequest) throws JBoradException {
			String logTag = "buildCandidateResume() :";
			LOGGER.info(AppUtil.getStartMethodMessage(logTag));
			Response response = null;
			
			try {
				
				
				
				
			} catch (Exception e) {
				String exceptionMessage = logTag + "Exception while building the candidate resume.";
				handleException(LOGGER, logTag, exceptionMessage, e, null);
			}
			LOGGER.info(AppUtil.getEndMethodMessage(logTag));
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
	
	//=========================================================================
}
