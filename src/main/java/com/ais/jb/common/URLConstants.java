/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   01-Nov-2019 
*/
package com.ais.jb.common;

public class URLConstants {

	public class User {
		public static final String API_BASE = "/api/user";
		public static final String GET_ALL_USERS = "/all";
		public static final String GET_USER = "/{userDetailsId}";
		public static final String ADD_USER = "/add";
		public static final String UPDATE_USER = "/update/{userDetailsId}";
		public static final String DELETE_USER = "/{userDetailsId}";
		public static final String IS_EMAIL_EXISTS = "/email/exists";
	}
	
	//=========================================================================
	
	public class Login {
		public static final String API_BASE = "/api/user";
		public static final String LOGIN_USER = "/login";
		public static final String LOGOUT_USER = "/logout";
	}
	
	//=========================================================================
	
	public class Registration {
		public static final String API_BASE = "/api/registration";
	}
	
	//=========================================================================
	
	public class Job {
		public static final String API_BASE = "/api/job";
		public static final String SAVE_EMPLOYER_PROFILE = "/save/profile/employer";
		public static final String POST_JOB = "/post";
		public static final String GET_JOB_DETAILS_BY_ID = "/get/details/{jobDetailsId}";
		public static final String GET_JOB_DETAILS_BY_JOBCODE = "/get/details/{jobCode}";
		public static final String GET_EMPLOYEE_BENEFITS = "/get/employee/benefits";
		public static final String GET_JOB_INDUSTRIES = "/get/industries";
		public static final String SEARCH_JOB = "/search";
		public static final String ADVANCED_SEARCH_JOB = "/search/advanced";

	}
	
	//=========================================================================
	
	public class Resume {
		public static final String API_BASE = "/api/resume";
		public static final String SAVE_CANDIDATE_PROFILE = "/save/profile/candidate";
		public static final String BUILD_CANDIDATE_RESUME = "/build/candidate";
		public static final String GET_RESUME_DETAILS = "/get/details";
		public static final String DOWNLOAD_RESUME = "/download";
		public static final String SEARCH_RESUME = "/search";
	}
	
	//=========================================================================
	
	public class Message {
		public static final String API_BASE = "/api/message";

	}
	
	//=========================================================================
	
	public class Preferences {
		public static final String API_BASE = "/api/preferences";	
	
	}
	
	//=========================================================================
}
