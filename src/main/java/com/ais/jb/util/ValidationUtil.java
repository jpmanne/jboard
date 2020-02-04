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
import com.ais.jb.request.model.SaveCandidateProfileRequest;

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
	
}