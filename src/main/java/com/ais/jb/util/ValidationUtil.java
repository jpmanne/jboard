/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   01-Nov-2019 
*/
package com.ais.jb.util;

import com.ais.jb.common.Constants;
import com.ais.jb.dao.model.AwardsOrAchievementsDetails;
import com.ais.jb.dao.model.CertificationsAndLicensesDetails;
import com.ais.jb.dao.model.EducationDetails;
import com.ais.jb.dao.model.MilitaryServiceDetails;
import com.ais.jb.dao.model.NonProfitStudentOrganizationsDetails;
import com.ais.jb.dao.model.OnlineProfileDetails;
import com.ais.jb.dao.model.ProjectsOrPapersPresentedDetails;
import com.ais.jb.dao.model.SkillDetails;
import com.ais.jb.dao.model.WorkExperienceDetails;
import com.ais.jb.request.model.PostJobRequest;
import com.ais.jb.request.model.SaveCandidateProfileRequest;
import com.ais.jb.request.model.SaveEmployerProfileRequest;
import com.ais.jb.request.model.SearchJobRequest;

public class ValidationUtil {
	
	private static ValidationUtil instance = null;

	// ========================================================================

	private ValidationUtil() { }

	// ========================================================================

	public static synchronized ValidationUtil getInstance() {
		if (instance == null) {
			instance = new ValidationUtil();
		}
		return instance;
	}

	// ========================================================================
	
	public String validateField(String fieldName, String fieldValue, boolean notNull, int maxLength) {
		
		if(notNull) {
			if(fieldValue != null && fieldValue.trim().length() > 0) {
				if(fieldValue.length() > maxLength) {
					return fieldName + " data exceeds max length ("+maxLength+")";
				}
			} else {
				return fieldName + " cannot be null";
			}
		} else {
			if(fieldValue != null && fieldValue.trim().length() > 0) {
				if(fieldValue.trim().length() > maxLength) {
					return fieldName + " data exceeds max length ("+maxLength+")";
				}
			}
		}
		return Constants.SUCCESS;
	}
	
	// ========================================================================
	
	public String validateCandidateProfileDetails(SaveCandidateProfileRequest details) {
		if(details != null) {
			String validateFieldResult1 = validateField("email", details.getEmail(), true, 150);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult1)) {
				return validateFieldResult1;
			}
			
			/*String validateFieldResult2 = validateField("password", details.getPassword(), true, 150);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult2)) {
				return validateFieldResult2;
			}*/
			
			String validateFieldResult3 = validateField("name", details.getName(), true, 150);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult3)) {
				return validateFieldResult3;
			}
			
			String validateFieldResult4 = validateField("lastName", details.getLastName(), true, 150);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult4)) {
				return validateFieldResult4;
			}
			
			String validateFieldResult5 = validateField("city", details.getCity(), true, 100);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult5)) {
				return validateFieldResult5;
			}
			
			String validateFieldResult6 = validateField("state", details.getState(), true, 100);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult6)) {
				return validateFieldResult6;
			}
		} else {
			return "CandidateProfile cannot be null";
		}
		return Constants.SUCCESS;
	}
	
	// ========================================================================
	
	public String validateWorkExperienceDetails(WorkExperienceDetails details) {
		if(details != null) {
			String validateFieldResult1 = validateField("jobTitle", details.getJobTitle(), true, 150);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult1)) {
				return validateFieldResult1;
			}
			
			String validateFieldResult2 = validateField("company", details.getCompany(), true, 255);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult2)) {
				return validateFieldResult2;
			}
			
			String validateFieldResult3 = validateField("city", details.getCity(), true, 100);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult3)) {
				return validateFieldResult3;
			}
			
			String validateFieldResult4 = validateField("timePeriodFrom", details.getTimePeriodFrom(), true, 15);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult4)) {
				return validateFieldResult4;
			}
			
			String validateFieldResult5 = validateField("timePeriodTo", details.getTimePeriodTo(), true, 15);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult5)) {
				return validateFieldResult5;
			}
		} else {
			return "WorkExperienceDetails cannot be null";
		}
		return Constants.SUCCESS;
	}
	
	// ========================================================================
	
	public String validateEducationDetails(EducationDetails details) {
		if(details != null) {
			String validateFieldResult1 = validateField("collegeOrUniversity", details.getCollegeOrUniversity(), true, 255);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult1)) {
				return validateFieldResult1;
			}
			
			String validateFieldResult2 = validateField("degree", details.getDegree(), true, 150);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult2)) {
				return validateFieldResult2;
			}
			
			String validateFieldResult3 = validateField("city", details.getCity(), true, 100);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult3)) {
				return validateFieldResult3;
			}
			
			String validateFieldResult4 = validateField("timePeriodFrom", details.getTimePeriodFrom(), true, 15);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult4)) {
				return validateFieldResult4;
			}
			
			String validateFieldResult5 = validateField("timePeriodTo", details.getTimePeriodTo(), true, 15);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult5)) {
				return validateFieldResult5;
			}
			
			String validateFieldResult6 = validateField("fieldOfStudy", details.getFieldOfStudy(), true, 150);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult6)) {
				return validateFieldResult6;
			}
		} else {
			return "EducationDetails cannot be null";
		}
		return Constants.SUCCESS;
	}
	
	// ========================================================================
	
	public String validateSkillDetails(SkillDetails details) {
		if(details != null) {
			String validateFieldResult1 = validateField("experience", details.getExperience(), true, 50);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult1)) {
				return validateFieldResult1;
			}
			
			String validateFieldResult2 = validateField("skill", details.getSkill(), true, 100);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult2)) {
				return validateFieldResult2;
			}
			
		} else {
			return "SkillDetails cannot be null";
		}
		return Constants.SUCCESS;
	}
	
	// ========================================================================
	
	public String validateAwardsOrAchievementsDetails(AwardsOrAchievementsDetails details) {
		if(details != null) {
			String validateFieldResult1 = validateField("title", details.getTitle(), true, 100);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult1)) {
				return validateFieldResult1;
			}
			
			String validateFieldResult2 = validateField("dateAwarded", details.getDateAwarded(), true, 50);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult2)) {
				return validateFieldResult2;
			}
			
		} else {
			return "AwardsOrAchievementsDetails cannot be null";
		}
		return Constants.SUCCESS;
	}
	
	// ========================================================================
	
	public String validateCertificationsAndLicensesDetails(CertificationsAndLicensesDetails details) {
		if(details != null) {
			String validateFieldResult1 = validateField("title", details.getTitle(), true, 150);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult1)) {
				return validateFieldResult1;
			}
			
			String validateFieldResult2 = validateField("timePeriodFrom", details.getTimePeriodFrom(), true, 15);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult2)) {
				return validateFieldResult2;
			}
			
			String validateFieldResult3 = validateField("timePeriodTo", details.getTimePeriodTo(), true, 15);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult3)) {
				return validateFieldResult3;
			}
		} else {
			return "CertificationsAndLicensesDetails cannot be null";
		}
		return Constants.SUCCESS;
	}
	
	// ========================================================================
	
	public String validateNonProfitStudentOrganizationsDetails(NonProfitStudentOrganizationsDetails details) {
		if(details != null) {
			String validateFieldResult1 = validateField("title", details.getTitle(), true, 150);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult1)) {
				return validateFieldResult1;
			}
			
			String validateFieldResult2 = validateField("timePeriodFrom", details.getTimePeriodFrom(), true, 15);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult2)) {
				return validateFieldResult2;
			}
			
			String validateFieldResult3 = validateField("timePeriodTo", details.getTimePeriodTo(), true, 15);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult3)) {
				return validateFieldResult3;
			}
		} else {
			return "NonProfitStudentOrganizationsDetails cannot be null";
		}
		return Constants.SUCCESS;
	}
	
	// ========================================================================
	
	public String validateProjectsOrPapersPresentedDetails(ProjectsOrPapersPresentedDetails details) {
		if(details != null) {
			String validateFieldResult1 = validateField("title", details.getTitle(), true, 150);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult1)) {
				return validateFieldResult1;
			}
			
			String validateFieldResult2 = validateField("url", details.getUrl(), true, 150);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult2)) {
				return validateFieldResult2;
			}
			
			String validateFieldResult3 = validateField("datePublished", details.getDatePublished(), true, 15);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult3)) {
				return validateFieldResult3;
			}
		} else {
			return "ProjectsOrPapersPresentedDetails cannot be null";
		}
		return Constants.SUCCESS;
	}
	
	// ========================================================================
	
	public String validateOnlineProfileDetails(OnlineProfileDetails details) {
		if(details != null) {
			String validateFieldResult1 = validateField("LinkAddress", details.getLinkAddress(), true, 150);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult1)) {
				return validateFieldResult1;
			}
			
		} else {
			return "OnlineProfileDetails cannot be null";
		}
		return Constants.SUCCESS;
	}
	
	// ========================================================================
	
	public String validateMilitaryServiceDetails(MilitaryServiceDetails details) {
		if(details != null) {
			String validateFieldResult1 = validateField("rank", details.getRank(), true, 100);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult1)) {
				return validateFieldResult1;
			}
			
			String validateFieldResult2 = validateField("branch", details.getBranch(), true, 100);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult2)) {
				return validateFieldResult2;
			}
			
			String validateFieldResult3 = validateField("serviceCountry", details.getServiceCountry(), true, 150);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult3)) {
				return validateFieldResult3;
			}
			
			String validateFieldResult4 = validateField("timePeriodFrom", details.getTimePeriodFrom(), true, 15);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult4)) {
				return validateFieldResult4;
			}
			
			String validateFieldResult5 = validateField("timePeriodTo", details.getTimePeriodTo(), true, 15);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult5)) {
				return validateFieldResult5;
			}
		} else {
			return "MilitaryServiceDetails cannot be null";
		}
		return Constants.SUCCESS;
	}
	
	// ========================================================================
	
	public String validateEmployerProfileDetails(SaveEmployerProfileRequest details) {
		if(details != null) {
			String validateFieldResult1 = validateField("email", details.getEmail(), true, 150);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult1)) {
				return validateFieldResult1;
			}
			
			/*String validateFieldResult2 = validateField("password", details.getPassword(), true, 150);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult2)) {
				return validateFieldResult2;
			}*/
			
			String validateFieldResult3 = validateField("name", details.getName(), true, 150);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult3)) {
				return validateFieldResult3;
			}
			
			/*String validateFieldResult4 = validateField("lastName", details.getLastName(), true, 150);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult4)) {
				return validateFieldResult4;
			}*/
			
			String validateFieldResult5 = validateField("companyName", details.getCompanyName(), true, 150);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult5)) {
				return validateFieldResult5;
			}
			
			String validateFieldResult6 = validateField("companySize", details.getCompanySize(), true, 25);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult6)) {
				return validateFieldResult6;
			}
			
			String validateFieldResult7 = validateField("howHearAboutUs", details.getHowHearAboutUs(), true, 100);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult7)) {
				return validateFieldResult7;
			}
			String validateFieldResult8 = validateField("recruiterHiringForClient", details.getRecruiterHiringForClient(), true, 15);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult8)) {
				return validateFieldResult8;
			}
		} else {
			return "EmployerProfile cannot be null";
		}
		return Constants.SUCCESS;
	}
	
	// ========================================================================
	
	public String validatePostJobDetails(PostJobRequest details) {
		if(details != null) {
			
			String validateFieldResult1 = validateField("jobTitle", details.getJobTitle(), true, 255);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult1)) {
				return validateFieldResult1;
			}
			
			String validateFieldResult2 = validateField("companyName", details.getCompanyName(), true, 255);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult2)) {
				return validateFieldResult2;
			}
			
			String validateFieldResult3 = validateField("city", details.getCity(), true, 100);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult3)) {
				return validateFieldResult3;
			}
			
			String validateFieldResult4 = validateField("state", details.getState(), true, 100);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult4)) {
				return validateFieldResult4;
			}
			
			String validateFieldResult5 = validateField("country", details.getCountry(), true, 100);
			if(!Constants.SUCCESS.equalsIgnoreCase(validateFieldResult5)) {
				return validateFieldResult5;
			}
			
			String validateFieldResult6 = validateField("jobType", details.getJobType(), true, 20);
			if(Constants.SUCCESS.equalsIgnoreCase(validateFieldResult6)) {
				boolean validJobType = false;
				
				for(int i = 0; i < Constants.JOB_TYPES.length; i++) {
					if(details.getJobType().equalsIgnoreCase(Constants.JOB_TYPES[i])) {
						validJobType = true;
						break;
					}
				}
				if(!validJobType) {
					return "Invalid Job Type";
				}
			} else {
				return validateFieldResult6;
			}
			
			String validateFieldResult7 = validateField("newApplicatantsInformed", details.getNewApplicatantsInformed(), true, 15);
			if(Constants.SUCCESS.equalsIgnoreCase(validateFieldResult7)) {
				if("Daily".equalsIgnoreCase(details.getNewApplicatantsInformed()) || "Individually".equalsIgnoreCase(details.getNewApplicatantsInformed())) {
					
				} else {
					return "newApplicatantsInformed supports either Daily or Individually";
				}
				
			} else {
				return validateFieldResult7;
			}
			
			String validateFieldResult8 = validateField("notifyRequired", details.getNotifyRequired(), true, 10);
			if(Constants.SUCCESS.equalsIgnoreCase(validateFieldResult8)) {
				if("Yes".equalsIgnoreCase(details.getNotifyRequired()) || "No".equalsIgnoreCase(details.getNotifyRequired())) {
					
				} else {
					return "notifyRequired supports either Yes or No";
				}
				
			} else {
				return validateFieldResult8;
			}
			
			String validateFieldResult9 = validateField("receiveApplications", details.getReceiveApplications(), true, 10);
			if(Constants.SUCCESS.equalsIgnoreCase(validateFieldResult9)) {
				if("Email".equalsIgnoreCase(details.getReceiveApplications()) || "In-Person".equalsIgnoreCase(details.getReceiveApplications())) {
					
				} else {
					return "receiveApplications supports either Email or In-Person";
				}
				
			} else {
				return validateFieldResult9;
			}
			
			String validateFieldResult10 = validateField("submitResume", details.getSubmitResume(), true, 10);
			if(Constants.SUCCESS.equalsIgnoreCase(validateFieldResult10)) {
				if("Yes".equalsIgnoreCase(details.getSubmitResume()) || "No".equalsIgnoreCase(details.getSubmitResume()) || "Optional".equalsIgnoreCase(details.getSubmitResume())) {
					
				} else {
					return "submitResume supports either Yes or No or Optional";
				}
				
			} else {
				return validateFieldResult10;
			}
		} else {
			return "PostJobRequest cannot be null";
		}
		return Constants.SUCCESS;
	}
	
	// ========================================================================
	
	public String validateSearchJobDetails(SearchJobRequest details) {
		int searchTermCount = 0;
		
		if(details.getSearchTermWhat() != null && details.getSearchTermWhat().trim().length() > 0) {
			searchTermCount++;
		} else {
			if(details.getSearchTermWhere() != null && details.getSearchTermWhere().trim().length() > 0) {
				searchTermCount++;
			}
		}
		
		if(searchTermCount == 0) {
			return "Please provide atleast one search term";
		}
		return Constants.SUCCESS;
	}
	
	// ========================================================================
	
}