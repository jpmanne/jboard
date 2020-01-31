/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   23-Jan-2020 
*/
package com.ais.jb.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ais.jb.common.Constants;
import com.ais.jb.common.URLConstants;
import com.ais.jb.dao.model.AwardsOrAchievementsDetails;
import com.ais.jb.dao.model.CertificationsAndLicensesDetails;
import com.ais.jb.dao.model.EducationDetails;
import com.ais.jb.dao.model.MilitaryServiceDetails;
import com.ais.jb.dao.model.NonProfitStudentOrganizationsDetails;
import com.ais.jb.dao.model.OnlineProfileDetails;
import com.ais.jb.dao.model.ProjectsOrPapersPresentedDetails;
import com.ais.jb.dao.model.RoleDetails;
import com.ais.jb.dao.model.SkillDetails;
import com.ais.jb.dao.model.UserDetails;
import com.ais.jb.dao.model.WorkExperienceDetails;
import com.ais.jb.exception.JBoradException;
import com.ais.jb.model.AuthorizationDetails;
import com.ais.jb.model.Response;
import com.ais.jb.repository.AwardsOrAchiementsDetailsRepository;
import com.ais.jb.repository.CertificationsRepository;
import com.ais.jb.repository.EducationDetailsRepository;
import com.ais.jb.repository.MilitaryServiceDetailsRepository;
import com.ais.jb.repository.OnlineProfileDetailsRepository;
import com.ais.jb.repository.ProjectsRepository;
import com.ais.jb.repository.ResumeRepository;
import com.ais.jb.repository.SkillDetailsRepository;
import com.ais.jb.repository.StudentOrganizationsRepository;
import com.ais.jb.repository.UserRepository;
import com.ais.jb.repository.WorkExperienceDetailsRepository;
import com.ais.jb.request.model.BuildCandidateResumeRequest;
import com.ais.jb.request.model.SaveCandidateProfileRequest;
import com.ais.jb.util.AppUtil;
import com.ais.jb.util.PasswordEncy;
import com.ais.jb.util.UniversalUniqueCodeGenerator;

@RestController
@RequestMapping(URLConstants.Resume.API_BASE)
public class ResumeController extends BaseController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ResumeController.class);
	@Autowired
	UserRepository userRepository;
	@Autowired
	ResumeRepository resumeRepository;
	@Autowired
	WorkExperienceDetailsRepository workExperienceDetailsRepository;
	@Autowired
	EducationDetailsRepository educationDetailsRepository;
	@Autowired
	SkillDetailsRepository skillDetailsRepository;
	@Autowired
	AwardsOrAchiementsDetailsRepository awardsOrAchiementsDetailsRepository;
	@Autowired
	CertificationsRepository certificationsRepository;
	@Autowired
	StudentOrganizationsRepository studentOrganizationsRepository;
	@Autowired
	ProjectsRepository projectsRepository;
	@Autowired
	OnlineProfileDetailsRepository onlineProfileDetailsRepository;
	@Autowired
	MilitaryServiceDetailsRepository militaryServiceDetailsRepository;
	
	//=========================================================================
	
	@PostMapping(URLConstants.Resume.SAVE_CANDIDATE_PROFILE)
	public ResponseEntity<Response> saveCandidateProfile(
		@Valid @RequestBody SaveCandidateProfileRequest saveCandidateProfileRequest) throws JBoradException {
		String logTag = "saveCandidateProfile() :";
		LOGGER.info(AppUtil.getStartMethodMessage(logTag));
		Response response = null;
		List<UserDetails> existingUsers = null;
		UserDetails userDetails = null;
		
		try {
			if(saveCandidateProfileRequest != null) {
				existingUsers = userRepository.getUserByEmail(saveCandidateProfileRequest.getEmail());
				
				if(existingUsers != null && existingUsers.size() > 0) {
					response = new Response("Email already exists.", null);
				} else {
					userDetails = new UserDetails();
					userDetails.setEmail(saveCandidateProfileRequest.getEmail());
					userDetails.setPassword(PasswordEncy.getInstance().encrypt(UniversalUniqueCodeGenerator.getInstance().getAutoGeneratedPassword()));
					userDetails.setFirstName(saveCandidateProfileRequest.getName());
					userDetails.setLastName(saveCandidateProfileRequest.getLastName());
					userDetails.setPhoneNumber(saveCandidateProfileRequest.getPhoneNumber());
					userDetails.setStatus(Constants.ACTIVE);
					userDetails.setCreatedAt(new Date());
					RoleDetails roleDetails = new RoleDetails();
					roleDetails.setRoleId(Constants.CANDIDATE_ROLE);
					userDetails.setRoleDetails(roleDetails);
					userDetails = userRepository.save(userDetails);
					
					if(userDetails.getUserDetailsId() != null) {
						response = new Response("Candidate Profile saved successfully", null);
					}
				}
			} else {
				response = new Response("Invalid Input", null);
			}
		} catch (Exception e) {
			String exceptionMessage = logTag + "Exception while saving the candidate profile.";
			handleException(LOGGER, logTag, exceptionMessage, e, null);
		}
		LOGGER.info(AppUtil.getEndMethodMessage(logTag));
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
		
	//=========================================================================
	
	@PostMapping(URLConstants.Resume.BUILD_CANDIDATE_RESUME)
	public ResponseEntity<Response> buildCandidateResume(
		@Valid @RequestBody BuildCandidateResumeRequest buildCandidateResumeRequest,
		@RequestParam("authCode") String authCode) throws JBoradException {
		String logTag = "buildCandidateResume() :";
		LOGGER.info(AppUtil.getStartMethodMessage(logTag));
		AuthorizationDetails authorizationDetails = null;
		Response response = null;
		List<WorkExperienceDetails> workExperiences;
		List<EducationDetails> educations;
		List<SkillDetails> skills;
		List<AwardsOrAchievementsDetails> awardsOrAchievements;
		List<CertificationsAndLicensesDetails> certificationsAndLinceses;
		List<NonProfitStudentOrganizationsDetails> nonProfitStudentOrganizations;
		List<ProjectsOrPapersPresentedDetails> projectsOrPapersPresented;
		OnlineProfileDetails onlineProfileDetails;
		MilitaryServiceDetails militaryServiceDetails;
		UserDetails userDetails = null;
		int saveCount = 0;
		
		try {
			authorizationDetails = validateAuthorization(authCode);
			
			if(authorizationDetails.isValidAuthCode()) {
				if(authorizationDetails.isValidAccess()) {
					userDetails = new UserDetails();
					userDetails.setUserDetailsId(authorizationDetails.getUserDetailsId());
					
					workExperiences = buildCandidateResumeRequest.getWorkExperiences();
					educations = buildCandidateResumeRequest.getEducations();
					skills = buildCandidateResumeRequest.getSkills();
					awardsOrAchievements = buildCandidateResumeRequest.getAwardsOrAchievements();
					certificationsAndLinceses = buildCandidateResumeRequest.getCertificationsAndLinceses();
					nonProfitStudentOrganizations = buildCandidateResumeRequest.getNonProfitStudentOrganizations();
					projectsOrPapersPresented = buildCandidateResumeRequest.getProjectsOrPapersPresented();
					
					onlineProfileDetails = buildCandidateResumeRequest.getOnlineProfileDetails();
					militaryServiceDetails = buildCandidateResumeRequest.getMilitaryServiceDetails();
					
					if(workExperiences != null && !workExperiences.isEmpty()) {
						for(WorkExperienceDetails details : workExperiences) {
							details.setUserDetails(userDetails);
						}
						workExperienceDetailsRepository.saveAll(workExperiences);
						saveCount++;
					}
					
					if(educations != null && !educations.isEmpty()) {
						for(EducationDetails details : educations) {
							details.setUserDetails(userDetails);
						}
						educationDetailsRepository.saveAll(educations);
					}
					
					if(skills != null && !skills.isEmpty()) {
						for(SkillDetails details : skills) {
							details.setUserDetails(userDetails);
						}
						skillDetailsRepository.saveAll(skills);
						saveCount++;
					}
					
					if(awardsOrAchievements != null && !awardsOrAchievements.isEmpty()) {
						for(AwardsOrAchievementsDetails details : awardsOrAchievements) {
							details.setUserDetails(userDetails);
						}
						awardsOrAchiementsDetailsRepository.saveAll(awardsOrAchievements);
						saveCount++;
					}
					
					if(certificationsAndLinceses != null && !certificationsAndLinceses.isEmpty()) {
						for(CertificationsAndLicensesDetails details : certificationsAndLinceses) {
							details.setUserDetails(userDetails);
						}
						certificationsRepository.saveAll(certificationsAndLinceses);
						saveCount++;
					}
					
					if(nonProfitStudentOrganizations != null && !nonProfitStudentOrganizations.isEmpty()) {
						for(NonProfitStudentOrganizationsDetails details : nonProfitStudentOrganizations) {
							details.setUserDetails(userDetails);
						}
						studentOrganizationsRepository.saveAll(nonProfitStudentOrganizations);
						saveCount++;
					}
					
					if(projectsOrPapersPresented != null && !projectsOrPapersPresented.isEmpty()) {
						for(ProjectsOrPapersPresentedDetails details : projectsOrPapersPresented) {
							details.setUserDetails(userDetails);
						}
						projectsRepository.saveAll(projectsOrPapersPresented);
						saveCount++;
					}
					
					if(onlineProfileDetails != null) {
						onlineProfileDetails.setUserDetails(userDetails);
						onlineProfileDetailsRepository.save(onlineProfileDetails);
						saveCount++;
					} 
					
					if(militaryServiceDetails != null) {
						militaryServiceDetails.setUserDetails(userDetails);
						militaryServiceDetailsRepository.save(militaryServiceDetails);
						saveCount++;
					}
					
					if(saveCount > 0) {
						response = new Response("Candidate Resume build successfully", null);
					} else {
						response = new Response("Candidate Resume build unsuccessful", null);
					}
				} else {
					LOGGER.info(logTag + "Unauthorized Access : "+authCode);
					return new ResponseEntity<Response>(getUnAuthorizedAccessRespose(), HttpStatus.UNAUTHORIZED);
				}
			} else {
				response = getInvalidAuthCodeRespose(authCode);
				LOGGER.info(logTag + "Invalid AuthCode : "+authCode);
			}
		} catch (Exception e) {
			String exceptionMessage = logTag + "Exception while building the candidate resume.";
			handleException(LOGGER, logTag, exceptionMessage, e, null);
		}
		LOGGER.info(AppUtil.getEndMethodMessage(logTag));
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	//=========================================================================
}
