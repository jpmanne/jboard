/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   23-Jan-2020 
*/
package com.ais.jb.controller;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ais.jb.common.Constants;
import com.ais.jb.common.URLConstants;
import com.ais.jb.dao.model.AuthCodeDetails;
import com.ais.jb.dao.model.AwardsOrAchievementsDetails;
import com.ais.jb.dao.model.CertificationsAndLicensesDetails;
import com.ais.jb.dao.model.EducationDetails;
import com.ais.jb.dao.model.MilitaryServiceDetails;
import com.ais.jb.dao.model.NonProfitStudentOrganizationsDetails;
import com.ais.jb.dao.model.OnlineProfileDetails;
import com.ais.jb.dao.model.ProjectsOrPapersPresentedDetails;
import com.ais.jb.dao.model.ResumeDetails;
import com.ais.jb.dao.model.RoleDetails;
import com.ais.jb.dao.model.SkillDetails;
import com.ais.jb.dao.model.UserDetails;
import com.ais.jb.dao.model.WorkExperienceDetails;
import com.ais.jb.email.EmailUtil;
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
import com.ais.jb.request.model.SearchJobRequest;
import com.ais.jb.request.model.SearchResumeRequest;
import com.ais.jb.response.model.CandidateProfileResponse;
import com.ais.jb.response.model.GetResumeDetailsResponse;
import com.ais.jb.response.model.WebAwardsOrAchievementsDetails;
import com.ais.jb.response.model.WebCertificationsAndLicensesDetails;
import com.ais.jb.response.model.WebEducationDetails;
import com.ais.jb.response.model.WebNonProfitStudentOrganizationsDetails;
import com.ais.jb.response.model.WebProjectsOrPapersPresentedDetails;
import com.ais.jb.response.model.WebSkillDetails;
import com.ais.jb.response.model.WebWorkExperienceDetails;
import com.ais.jb.util.AppUtil;
import com.ais.jb.util.AuthCodeGenerator;
import com.ais.jb.util.PasswordEncy;
import com.ais.jb.util.PdfUtil;
import com.ais.jb.util.UniversalUniqueCodeGenerator;
import com.ais.jb.util.ValidationUtil;

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
				String validationResult = ValidationUtil.getInstance().validateCandidateProfileDetails(saveCandidateProfileRequest);
				if(!Constants.SUCCESS.equalsIgnoreCase(validationResult)) {
					return getInvalidDataResponseEntity(validationResult);
				}
				existingUsers = userRepository.getUserByEmail(saveCandidateProfileRequest.getEmail());
				
				if(existingUsers != null && existingUsers.size() > 0) {
					response = new Response("Email already exists.", null);
				} else {
					userDetails = new UserDetails();
					String password = UniversalUniqueCodeGenerator.getInstance().getAutoGeneratedPassword();
					userDetails.setEmail(saveCandidateProfileRequest.getEmail().toLowerCase());
					userDetails.setPassword(PasswordEncy.getInstance().encrypt(password));
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
						ResumeDetails resumeDetails = new ResumeDetails();
						resumeDetails.setResumeCode(UniversalUniqueCodeGenerator.getInstance().getUniqueCode());
						resumeDetails.setHeadLine(saveCandidateProfileRequest.getHeadLine());
						resumeDetails.setObjective(saveCandidateProfileRequest.getObjective());
						resumeDetails.setCity(saveCandidateProfileRequest.getCity());
						resumeDetails.setState(saveCandidateProfileRequest.getState());
						resumeDetails.setCountry(saveCandidateProfileRequest.getCountry());
						resumeDetails.setPinCode(saveCandidateProfileRequest.getPinCode());
						resumeDetails.setRelocation(saveCandidateProfileRequest.getRelocate());
						resumeDetails.setStatus(Constants.ACTIVE);
						resumeDetails.setCreatedAt(new Date());
						resumeDetails.setUserDetails(userDetails);
						resumeDetails = resumeRepository.save(resumeDetails);
						
						AuthCodeDetails authCodeDetails = new AuthCodeDetails();
						authCodeDetails.setAuthCode(AuthCodeGenerator.getInstance().getGeneratedAuthCode());
						authCodeDetails.setUserDetails(userDetails);
						authCodeDetails.setLoginTime(new Date());
						authCodeDetails.setLogoutTime(new Date());
						authCodeDetails.setStatus(Constants.ACTIVE);
						authCodeDetails = authCodeRepository.save(authCodeDetails);
						
						CandidateProfileResponse candidateProfileResponse = new CandidateProfileResponse();
						candidateProfileResponse.setAuthCode(authCodeDetails.getAuthCode());
						candidateProfileResponse.setFistName(userDetails.getFirstName());
						candidateProfileResponse.setLastName(userDetails.getLastName());
						candidateProfileResponse.setUserDetailsId(userDetails.getUserDetailsId());
						candidateProfileResponse.setRoleId(userDetails.getRoleDetails().getRoleId()); 
						
						EmailUtil emailUtil = EmailUtil.getInstance();
						boolean isMailSent = emailUtil.send(emailUtil.populateCredenitalsMail(userDetails.getFirstName(), userDetails.getLastName(), userDetails.getEmail(), password));
						LOGGER.info("isMailSent : "+isMailSent);
						
						response = new Response("Candidate Profile saved successfully", candidateProfileResponse);
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
	public ResponseEntity<Response> buildCandidateResume(@Valid @RequestBody BuildCandidateResumeRequest buildCandidateResumeRequest,
		@RequestParam("authCode") String authCode) throws JBoradException {
		String logTag = "buildCandidateResume() :";
		LOGGER.info(AppUtil.getStartMethodMessage(logTag));
		AuthorizationDetails authorizationDetails = null;
		Response response = null;
		List<WorkExperienceDetails> workExperiences;
		List<EducationDetails> educations;
		List<SkillDetails> skills;
		List<AwardsOrAchievementsDetails> awardsOrAchievements;
		List<CertificationsAndLicensesDetails> certificationsAndLincenses;
		List<NonProfitStudentOrganizationsDetails> nonProfitStudentOrganizations;
		List<ProjectsOrPapersPresentedDetails> projectsOrPapersPresented;
		OnlineProfileDetails onlineProfileDetails;
		MilitaryServiceDetails militaryServiceDetails;
		UserDetails userDetails = null;
		int saveCount = 0;
		ValidationUtil validationUtil = null;
		
		try {
			authorizationDetails = validateAuthorization(authCode);
			
			if(authorizationDetails.isValidAuthCode()) {
				if(authorizationDetails.isValidAccess()) {
					validationUtil = ValidationUtil.getInstance();
					userDetails = new UserDetails();
					userDetails.setUserDetailsId(authorizationDetails.getUserDetailsId());
					
					workExperiences = buildCandidateResumeRequest.getWorkExperiences();
					educations = buildCandidateResumeRequest.getEducations();
					skills = buildCandidateResumeRequest.getSkills();
					awardsOrAchievements = buildCandidateResumeRequest.getAwardsOrAchievements();
					certificationsAndLincenses = buildCandidateResumeRequest.getCertificationsAndLincenses();
					nonProfitStudentOrganizations = buildCandidateResumeRequest.getNonProfitStudentOrganizations();
					projectsOrPapersPresented = buildCandidateResumeRequest.getProjectsOrPapersPresented();
					
					onlineProfileDetails = buildCandidateResumeRequest.getOnlineProfileDetails();
					militaryServiceDetails = buildCandidateResumeRequest.getMilitaryServiceDetails();
					
					if(workExperiences != null && !workExperiences.isEmpty()) {
						for(WorkExperienceDetails details : workExperiences) {
							String validationResult = validationUtil.validateWorkExperienceDetails(details);
							if(!Constants.SUCCESS.equalsIgnoreCase(validationResult)) {
								return getInvalidDataResponseEntity(validationResult);
							}
							details.setUserDetails(userDetails);
						}
						workExperienceDetailsRepository.saveAll(workExperiences);
						saveCount++;
					}
					
					if(educations != null && !educations.isEmpty()) {
						for(EducationDetails details : educations) {
							String validationResult = validationUtil.validateEducationDetails(details);
							if(!Constants.SUCCESS.equalsIgnoreCase(validationResult)) {
								return getInvalidDataResponseEntity(validationResult);
							}
							details.setUserDetails(userDetails);
						}
						educationDetailsRepository.saveAll(educations);
					}
					
					if(skills != null && !skills.isEmpty()) {
						for(SkillDetails details : skills) {
							String validationResult = validationUtil.validateSkillDetails(details);
							if(!Constants.SUCCESS.equalsIgnoreCase(validationResult)) {
								return getInvalidDataResponseEntity(validationResult);
							}
							details.setUserDetails(userDetails);
						}
						skillDetailsRepository.saveAll(skills);
						saveCount++;
					}
					
					if(awardsOrAchievements != null && !awardsOrAchievements.isEmpty()) {
						for(AwardsOrAchievementsDetails details : awardsOrAchievements) {
							String validationResult = validationUtil.validateAwardsOrAchievementsDetails(details);
							if(!Constants.SUCCESS.equalsIgnoreCase(validationResult)) {
								return getInvalidDataResponseEntity(validationResult);
							}
							details.setUserDetails(userDetails);
						}
						awardsOrAchiementsDetailsRepository.saveAll(awardsOrAchievements);
						saveCount++;
					}
					
					if(certificationsAndLincenses != null && !certificationsAndLincenses.isEmpty()) {
						for(CertificationsAndLicensesDetails details : certificationsAndLincenses) {
							String validationResult = validationUtil.validateCertificationsAndLicensesDetails(details);
							if(!Constants.SUCCESS.equalsIgnoreCase(validationResult)) {
								return getInvalidDataResponseEntity(validationResult);
							}
							details.setUserDetails(userDetails);
						}
						certificationsRepository.saveAll(certificationsAndLincenses);
						saveCount++;
					}
					
					if(nonProfitStudentOrganizations != null && !nonProfitStudentOrganizations.isEmpty()) {
						for(NonProfitStudentOrganizationsDetails details : nonProfitStudentOrganizations) {
							String validationResult = validationUtil.validateNonProfitStudentOrganizationsDetails(details);
							if(!Constants.SUCCESS.equalsIgnoreCase(validationResult)) {
								return getInvalidDataResponseEntity(validationResult);
							}
							details.setUserDetails(userDetails);
						}
						studentOrganizationsRepository.saveAll(nonProfitStudentOrganizations);
						saveCount++;
					}
					
					if(projectsOrPapersPresented != null && !projectsOrPapersPresented.isEmpty()) {
						for(ProjectsOrPapersPresentedDetails details : projectsOrPapersPresented) {
							String validationResult = validationUtil.validateProjectsOrPapersPresentedDetails(details);
							if(!Constants.SUCCESS.equalsIgnoreCase(validationResult)) {
								return getInvalidDataResponseEntity(validationResult);
							}
							details.setUserDetails(userDetails);
						}
						projectsRepository.saveAll(projectsOrPapersPresented);
						saveCount++;
					}
					
					if(onlineProfileDetails != null) {
						String validationResult = validationUtil.validateOnlineProfileDetails(onlineProfileDetails);
						if(!Constants.SUCCESS.equalsIgnoreCase(validationResult)) {
							return getInvalidDataResponseEntity(validationResult);
						}
						onlineProfileDetails.setUserDetails(userDetails);
						onlineProfileDetailsRepository.save(onlineProfileDetails);
						saveCount++;
					} 
					
					if(militaryServiceDetails != null) {
						String validationResult = validationUtil.validateMilitaryServiceDetails(militaryServiceDetails);
						if(!Constants.SUCCESS.equalsIgnoreCase(validationResult)) {
							return getInvalidDataResponseEntity(validationResult);
						}
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
	
	@GetMapping(URLConstants.Resume.GET_RESUME_DETAILS)
	public ResponseEntity<Response> getResumeDetails(@RequestParam("authCode") String authCode) throws JBoradException {
		String logTag = "getResumeDetails() :";
		LOGGER.info(AppUtil.getStartMethodMessage(logTag));
		AuthorizationDetails authorizationDetails = null;
		Response response = null;
		Long userDetailsId = null;
		GetResumeDetailsResponse resumeDetailsResponse = null;
		
		try {
			authorizationDetails = validateAuthorization(authCode);
			
			if(authorizationDetails.isValidAuthCode()) {
				if(authorizationDetails.isValidAccess()) {
					userDetailsId = authorizationDetails.getUserDetailsId();
					resumeDetailsResponse = getResumeDetails(authCode, userDetailsId);
					
					if(resumeDetailsResponse != null) {
						response = new Response("Resume Details", resumeDetailsResponse);
					} else {
						response = new Response("No Resume Details found for this user.", null);
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
			String exceptionMessage = logTag + "Exception while retrieving the candidate resume details";
			handleException(LOGGER, logTag, exceptionMessage, e, authorizationDetails); 
		}
		LOGGER.info(AppUtil.getEndMethodMessage(logTag));
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	//=========================================================================
	
	//http://zetcode.com/springboot/servepdf/
	@RequestMapping(value = URLConstants.Resume.DOWNLOAD_RESUME, method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> downloadCandidateResume(@RequestParam("authCode") String authCode) throws JBoradException {
		String logTag = "downloadCandidateResume() ";
		LOGGER.info(AppUtil.getStartMethodMessage(logTag));
        ByteArrayInputStream bis = null;
        String downloadFileName = "CandidateResume.pdf";
        HttpHeaders headers = new HttpHeaders();
        AuthorizationDetails authorizationDetails = null;
        Long userDetailsId = null;
        GetResumeDetailsResponse resumeDetailsResponse = null;
        String candidateName = null;
        
        try {
        	authorizationDetails = validateAuthorization(authCode);
        	
        	if(authorizationDetails.isValidAuthCode()) {
				if(authorizationDetails.isValidAccess()) {
					userDetailsId = authorizationDetails.getUserDetailsId();
					resumeDetailsResponse = getResumeDetails(authCode, userDetailsId);
					
					if(resumeDetailsResponse != null) {
						candidateName = resumeDetailsResponse.getName().concat(" ").concat(resumeDetailsResponse.getLastName());
						downloadFileName = candidateName.trim().replaceAll(" ", "_").concat(".pdf");
						headers.add("Content-Disposition", "inline; filename="+downloadFileName);
						bis = PdfUtil.getInstance().getResumeData(resumeDetailsResponse);
					}
				} else {
					LOGGER.info(logTag + "Unauthorized Access : "+authCode);
				}
			} else {
				LOGGER.info(logTag + "Invalid AuthCode : "+authCode);
			}
		} catch (Exception e) {
			String exceptionMessage = logTag + "Exception while creating the candidate resume pdf";
			handleException(LOGGER, logTag, exceptionMessage, e, authorizationDetails); 
		}
        LOGGER.info(AppUtil.getEndMethodMessage(logTag));
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bis));
    }
	
	//=========================================================================
	
	private GetResumeDetailsResponse getResumeDetails(String authCode, Long userDetailsId) throws JBoradException {
		String logTag = "getResumeDetails() ";
		GetResumeDetailsResponse resumeDetailsResponse = null;
		Optional<ResumeDetails> resumeDetails;
		List<WorkExperienceDetails> workExperiences;
		List<EducationDetails> educations;
		List<SkillDetails> skills;
		List<AwardsOrAchievementsDetails> awardsOrAchievements;
		List<CertificationsAndLicensesDetails> certificationsAndLincenses;
		List<NonProfitStudentOrganizationsDetails> nonProfitStudentOrganizations;
		List<ProjectsOrPapersPresentedDetails> projectsOrPapersPresented;
		Optional<OnlineProfileDetails> onlineProfileDetails;
		Optional<MilitaryServiceDetails> militaryServiceDetails;
		UserDetails userDetails = null;
		
		try {
			if(userDetailsId != null) {
				userDetails = userRepository.findByUserDetailsId(userDetailsId);
				
				if(userDetails != null) {
					resumeDetailsResponse = new GetResumeDetailsResponse();
					resumeDetailsResponse.setAuthCode(authCode);
					resumeDetailsResponse.setEmail(userDetails.getEmail());
					resumeDetailsResponse.setName(userDetails.getFirstName());
					resumeDetailsResponse.setLastName(userDetails.getLastName());
					resumeDetailsResponse.setPhoneNumber(userDetails.getPhoneNumber());
					
					resumeDetails = resumeRepository.findById(userDetailsId);
					if(resumeDetails.isPresent()) {
						ResumeDetails rd = resumeDetails.get();
						resumeDetailsResponse.setResumeCode(rd.getResumeCode()); 
						resumeDetailsResponse.setHeadLine(rd.getHeadLine());
						resumeDetailsResponse.setObjective(rd.getObjective());
						resumeDetailsResponse.setCity(rd.getCity());
						resumeDetailsResponse.setState(rd.getState());
						resumeDetailsResponse.setCountry(rd.getCountry());
						resumeDetailsResponse.setPinCode(rd.getPinCode());
						resumeDetailsResponse.setRelocate(rd.getRelocation());
					}
					
					workExperiences = workExperienceDetailsRepository.getWorkExperiences(userDetailsId);
					if(workExperiences != null && !workExperiences.isEmpty()) {
						List<WebWorkExperienceDetails> webWorkExperiences = new ArrayList<WebWorkExperienceDetails>();
						for (WorkExperienceDetails wd : workExperiences) { 
							webWorkExperiences.add(wd.getWebWorkExperienceDetails());
						}
						resumeDetailsResponse.setWorkExperiences(webWorkExperiences);
					}
					
					educations = educationDetailsRepository.getEducations(userDetailsId);
					if(educations != null && !educations.isEmpty()) {
						List<WebEducationDetails> webEducations = new ArrayList<WebEducationDetails>();
						for (EducationDetails a : educations) { 
							webEducations.add(a.getWebEducationDetails());
						}
						resumeDetailsResponse.setEducations(webEducations);
					}
					
					skills = skillDetailsRepository.getSkills(userDetailsId);
					if(skills != null && !skills.isEmpty()) {
						List<WebSkillDetails> webSkills = new ArrayList<WebSkillDetails>();
						for (SkillDetails a : skills) { 
							webSkills.add(a.getWebSkillDetails());
						}
						resumeDetailsResponse.setSkills(webSkills);
					}
					
					awardsOrAchievements = awardsOrAchiementsDetailsRepository.getAwardsOrAchievements(userDetailsId);
					if(awardsOrAchievements != null && !awardsOrAchievements.isEmpty()) {
						List<WebAwardsOrAchievementsDetails> webAwardsOrAchievements = new ArrayList<WebAwardsOrAchievementsDetails>();
						for (AwardsOrAchievementsDetails a : awardsOrAchievements) { 
							webAwardsOrAchievements.add(a.getWebAwardsOrAchievementsDetails());
						}
						resumeDetailsResponse.setAwardsOrAchievements(webAwardsOrAchievements);
					}
					
					certificationsAndLincenses = certificationsRepository.getCertifications(userDetailsId);
					if(certificationsAndLincenses != null && !certificationsAndLincenses.isEmpty()) {
						List<WebCertificationsAndLicensesDetails> webCertificationsAndLincenses = new ArrayList<WebCertificationsAndLicensesDetails>();
						for (CertificationsAndLicensesDetails a : certificationsAndLincenses) { 
							webCertificationsAndLincenses.add(a.getWebCertificationsAndLicensesDetails());
						}
						resumeDetailsResponse.setCertificationsAndLincenses(webCertificationsAndLincenses);
					}
					
					nonProfitStudentOrganizations = studentOrganizationsRepository.getNonProfitStudentOrganizations(userDetailsId);
					if(nonProfitStudentOrganizations != null && !nonProfitStudentOrganizations.isEmpty()) {
						List<WebNonProfitStudentOrganizationsDetails> webNonProfitStudentOrganizations = new ArrayList<WebNonProfitStudentOrganizationsDetails>();
						for (NonProfitStudentOrganizationsDetails a : nonProfitStudentOrganizations) { 
							webNonProfitStudentOrganizations.add(a.getWebNonProfitStudentOrganizationsDetails());
						}
						resumeDetailsResponse.setNonProfitStudentOrganizations(webNonProfitStudentOrganizations);
					}
					
					projectsOrPapersPresented = projectsRepository.getProjects(userDetailsId);
					if(projectsOrPapersPresented != null && !projectsOrPapersPresented.isEmpty()) {
						List<WebProjectsOrPapersPresentedDetails> webProjectsOrPapersPresented = new ArrayList<WebProjectsOrPapersPresentedDetails>();
						for (ProjectsOrPapersPresentedDetails a : projectsOrPapersPresented) { 
							webProjectsOrPapersPresented.add(a.getWebProjectsOrPapersPresentedDetails());
						}
						resumeDetailsResponse.setProjectsOrPapersPresented(webProjectsOrPapersPresented); 
					}
					
					onlineProfileDetails = onlineProfileDetailsRepository.findById(userDetailsId);
					if(onlineProfileDetails.isPresent()) {
						resumeDetailsResponse.setOnlineProfileDetails(onlineProfileDetails.get().getWebOnlineProfileDetails());
					}
					
					militaryServiceDetails = militaryServiceDetailsRepository.findById(userDetailsId);
					if(militaryServiceDetails.isPresent()) {
						resumeDetailsResponse.setMilitaryServiceDetails(militaryServiceDetails.get().getWebMilitaryServiceDetails());
					}
				}
			}
		} catch (Exception e) {
			String exceptionMessage = logTag + "Exception while retrieving the candidate resume details";
			handleException(LOGGER, logTag, exceptionMessage, e, null); 
		}
		return resumeDetailsResponse;
	}
	
	//=========================================================================
	
	@PostMapping(URLConstants.Resume.SEARCH_RESUME)
	public ResponseEntity<Response> searchResume(@RequestBody SearchResumeRequest searchResumeRequest, @RequestParam(value = "authCode", required = false) String authCode) throws JBoradException {
		String logTag = "searchResume() :";
		LOGGER.info(AppUtil.getStartMethodMessage(logTag));
		AuthorizationDetails authorizationDetails = null;
		Response response = null;
		UserDetails userDetails = null;
		
		try {
			String validationResult = ValidationUtil.getInstance().validateSearchResumeDetails(searchResumeRequest);
			
			if(Constants.SUCCESS.equalsIgnoreCase(validationResult)) {
				if(authCode != null ) {
					authorizationDetails = validateAuthorization(authCode);
					
					if(authorizationDetails.isValidAuthCode()) {
						if(authorizationDetails.isValidAccess()) {
							userDetails = new UserDetails();
							userDetails.setUserDetailsId(authorizationDetails.getUserDetailsId());
						} else {
							LOGGER.info(logTag + "Unauthorized Access : "+authCode);
							return new ResponseEntity<Response>(getUnAuthorizedAccessRespose(), HttpStatus.UNAUTHORIZED);
						}
					} else {
						LOGGER.info(logTag + "Invalid AuthCode : "+authCode);
						return new ResponseEntity<Response>(getInvalidAuthCodeRespose(authCode), HttpStatus.OK);
					}
				}
				String searchTermWhat = searchResumeRequest.getSearchTermWhat();
				String searchTermWhere = searchResumeRequest.getSearchTermWhere();
				String searchFields = searchResumeRequest.getSearchFields();
				List<String> searchFieldsList = null;
				
				if(searchTermWhat != null) {
					searchTermWhat = searchTermWhat.trim().replaceAll(" ", "|");
				}
				if(searchTermWhere != null) {
					searchTermWhere = searchTermWhere.trim().replaceAll(" ", "|");
				}
				
				if(searchFields != null && searchFields.trim().length() > 0) {
					if(searchFields.contains(",")) {
						searchFieldsList = Arrays.stream(searchFields.split(",")).collect(Collectors.toList());
						//searchFieldsList = Arrays.asList(searchFields.split(","));
					} else {
						searchFieldsList = new ArrayList<String>();
						searchFieldsList.add(searchFields);
					}
				}
				List<ResumeDetails> resumes = null;
				
				if(searchFieldsList != null && !searchFieldsList.isEmpty()) {
					for (String searchField : searchFieldsList) {
						if("jobtitle".equalsIgnoreCase(searchField)) {
							if(searchTermWhat != null && searchTermWhere != null) {
								resumes = resumeRepository.getResumesByHeadLineAndLocation(searchTermWhat, searchTermWhere, searchTermWhere, searchTermWhere);
							} else if(searchTermWhat != null) {
								resumes = resumeRepository.getResumesByHeadLine(searchTermWhat);
							} else if (searchTermWhere != null) {
								resumes = resumeRepository.getResumesByLocation(searchTermWhere, searchTermWhere, searchTermWhere);
							}
						} else if("skills".equalsIgnoreCase(searchField)) {
							
						} else if("companies".equalsIgnoreCase(searchField)) {
							
						} else if("fieldofstudy".equalsIgnoreCase(searchField)) {
							
						}
					}
				} else { // TODO: As the search fields are not provided need to search in Job Title, Skills, Company
					
				}
				
			} else {
				return getInvalidDataResponseEntity(validationResult);
			}
		} catch (Exception e) {
			String exceptionMessage = logTag + "Exception while building the candidate resume.";
			handleException(LOGGER, logTag, exceptionMessage, e, null);
		}
		LOGGER.info(AppUtil.getEndMethodMessage(logTag));
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
}
