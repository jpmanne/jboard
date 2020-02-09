package com.ais.jb.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import com.ais.jb.response.model.GetResumeDetailsResponse;
import com.ais.jb.response.model.WebAwardsOrAchievementsDetails;
import com.ais.jb.response.model.WebCertificationsAndLicensesDetails;
import com.ais.jb.response.model.WebEducationDetails;
import com.ais.jb.response.model.WebMilitaryServiceDetails;
import com.ais.jb.response.model.WebNonProfitStudentOrganizationsDetails;
import com.ais.jb.response.model.WebProjectsOrPapersPresentedDetails;
import com.ais.jb.response.model.WebSkillDetails;
import com.ais.jb.response.model.WebWorkExperienceDetails;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

public class PdfUtil {

	private static PdfUtil instance = null;

	// ========================================================================

	private PdfUtil() { }

	// ========================================================================

	public static synchronized PdfUtil getInstance() {
		if (instance == null) {
			instance = new PdfUtil();
		}
		return instance;
	}

	// ========================================================================
	
	String font = FontFactory.HELVETICA;
	Font resumeHeadingFont = FontFactory.getFont(font, 16f, Font.BOLD, BaseColor.BLACK);
	Font subHeadingFont = FontFactory.getFont(font, 12f, Font.NORMAL, BaseColor.GRAY);
	LineSeparator lineSeparator = new LineSeparator(1f, 95, BaseColor.LIGHT_GRAY, Element.ALIGN_LEFT, 0);
	Font boldBlackFont = FontFactory.getFont(font, 10f, Font.BOLD, BaseColor.BLACK);
	Font normalGrayFont = FontFactory.getFont(font, 9f, BaseColor.GRAY);
	Font normalBlueFont = FontFactory.getFont(font, 9f, BaseColor.BLUE);
	Font normalBlackFont = FontFactory.getFont(font, 9f, BaseColor.BLACK);
	
	// ========================================================================
	
	public ByteArrayInputStream getResumeData(GetResumeDetailsResponse resumeDetails) {
		Document document = null;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		try {
			document = new Document(PageSize.A4, 55, 55, 55, 35);
			PdfWriter.getInstance(document, out);
			document.open();
			
			addResumeHeading(document, resumeDetails.getName().concat(" ").concat(resumeDetails.getLastName()), resumeDetails.getCity().concat(", ").concat(resumeDetails.getState()), resumeDetails.getEmail());
			document.add(new Paragraph("\n"));
			
			List<WebWorkExperienceDetails> workExperiences = resumeDetails.getWorkExperiences();
			List<WebEducationDetails> educations = resumeDetails.getEducations();
			List<WebSkillDetails> skills = resumeDetails.getSkills();
			List<WebAwardsOrAchievementsDetails> awardsOrAchievements = resumeDetails.getAwardsOrAchievements();
			List<WebCertificationsAndLicensesDetails> certificationsAndLincenses = resumeDetails.getCertificationsAndLincenses();
			List<WebNonProfitStudentOrganizationsDetails> nonProfitStudentOrganizations = resumeDetails.getNonProfitStudentOrganizations();
			List<WebProjectsOrPapersPresentedDetails> projectsOrPapersPresented = resumeDetails.getProjectsOrPapersPresented();
			WebMilitaryServiceDetails militaryServiceDetails = resumeDetails.getMilitaryServiceDetails();
			

			//=============================== Work Experience ===========================
			if (workExperiences != null && !workExperiences.isEmpty()) {
				addSubHeading(document, "Work Experience");
				
				for (WebWorkExperienceDetails details : workExperiences) {
					if (details != null) {
						StringBuilder contentLine2 = new StringBuilder(details.getCompany());
						contentLine2.append(" - ");
						contentLine2.append(details.getCity());
						
						StringBuilder contentLine3 = new StringBuilder(details.getTimePeriodFrom());
						if(details.getTimePeriodFrom().equalsIgnoreCase(details.getTimePeriodTo())) {
							contentLine3.append(" to Present ");
						} else {
							contentLine3.append(" - ");
							contentLine3.append(details.getTimePeriodTo());
							
						}
						addContent1(document, details.getJobTitle(), contentLine2.toString(), contentLine3.toString());
					} 
				}
				document.add(new Paragraph("\n"));
			}
			
			//=============================== Education ===========================
			if(educations != null && !educations.isEmpty()) {
				addSubHeading(document, "Education");
				
				for(WebEducationDetails details : educations) {
					if (details != null) {
						StringBuilder contentLine1 = new StringBuilder(details.getDegree());
						contentLine1.append(" in ");
						contentLine1.append(details.getFieldOfStudy());
						
						StringBuilder contentLine2 = new StringBuilder(details.getCollegeOrUniversity());
						contentLine2.append(" - ");
						contentLine2.append(details.getCity());
						
						StringBuilder contentLine3 = new StringBuilder(details.getTimePeriodFrom());
						contentLine3.append(" to ");
						contentLine3.append(details.getTimePeriodTo());
						addContent2(document, contentLine1.toString(), contentLine2.toString(), contentLine3.toString());
					}
				}
				document.add(new Paragraph("\n"));
			}
			
			//=============================== Skills ===========================
			if(skills != null && !skills.isEmpty()) {
				addSubHeading(document, "Skills");
				
				for(WebSkillDetails details : skills) {
					if (details != null) {
						addContent2(document, details.getSkill(), details.getExperience());
					}
				}
				document.add(new Paragraph("\n"));
			}
			
			//=============================== Awards or Achievements ===========================
			if(awardsOrAchievements != null && !awardsOrAchievements.isEmpty()) {
				addSubHeading(document, "Awards or Achievements");
				
				for(WebAwardsOrAchievementsDetails details : awardsOrAchievements) {
					if (details != null) {
						addContent2(document, details.getTitle(), details.getDateAwarded());
					}
				}
				document.add(new Paragraph("\n"));
			}
			
			//=============================== Certifications and Licenses ===========================
			if(certificationsAndLincenses != null && !certificationsAndLincenses.isEmpty()) {
				addSubHeading(document, "Certifications and Licenses");
				
				for(WebCertificationsAndLicensesDetails details : certificationsAndLincenses) {
					if (details != null) {
						StringBuilder contentLine1 = new StringBuilder(details.getTimePeriodFrom());
						if(details.getTimePeriodFrom().equalsIgnoreCase(details.getTimePeriodTo())) {
							contentLine1.append(" to Present ");
						} else {
							contentLine1.append(" - ");
							contentLine1.append(details.getTimePeriodTo());
							
						}
						addContent2(document, details.getTitle(), contentLine1.toString());
					}
				}
				document.add(new Paragraph("\n"));
			}
			
			//=============================== Non Profit Student Organizations ===========================
			if(nonProfitStudentOrganizations != null && !nonProfitStudentOrganizations.isEmpty()) {
				addSubHeading(document, "Non Profit Student Organizations");
				for(WebNonProfitStudentOrganizationsDetails details : nonProfitStudentOrganizations) {
					if (details != null) {
						StringBuilder contentLine1 = new StringBuilder(details.getTimePeriodFrom());
						if(details.getTimePeriodFrom().equalsIgnoreCase(details.getTimePeriodTo())) {
							contentLine1.append(" to Present ");
						} else {
							contentLine1.append(" - ");
							contentLine1.append(details.getTimePeriodTo());
							
						}
						addContent2(document, details.getTitle(), contentLine1.toString());
					}
				}
				document.add(new Paragraph("\n"));
			}
			
			//=============================== Projects or Papers Presented  ===========================
			if(projectsOrPapersPresented != null && !projectsOrPapersPresented.isEmpty()) {
				addSubHeading(document, "Projects or Papers Presented");
				for(WebProjectsOrPapersPresentedDetails details : projectsOrPapersPresented) {
					if (details != null) {
						if(details.getAdditionalInformation() != null && details.getAdditionalInformation().length() > 0) {
							addContent1(document, details.getTitle(), details.getDatePublished(), details.getAdditionalInformation());
						} else {
							addContent2(document, details.getTitle(), details.getDatePublished());
						}
					}
				}
				document.add(new Paragraph("\n"));
			}
			
			//=============================== Military Service Details ===========================
			if(militaryServiceDetails != null) {
				addSubHeading(document, "Military Service Details");
				
				StringBuilder contentLine2 = new StringBuilder(militaryServiceDetails.getBranch());
				contentLine2.append(" - ");
				contentLine2.append(militaryServiceDetails.getServiceCountry());
				
				StringBuilder contentLine3 = new StringBuilder(militaryServiceDetails.getTimePeriodFrom());
				contentLine3.append(" to ");
				contentLine3.append(militaryServiceDetails.getTimePeriodTo());
				addContent2(document, militaryServiceDetails.getRank(), contentLine2.toString(), contentLine3.toString());
				document.add(new Paragraph("\n"));
			}
			document.close();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
        return new ByteArrayInputStream(out.toByteArray());
	}
	
	// ========================================================================
	
	private void addResumeHeading(Document document, String heading1, String contentLine1, String contentLine2) {
		
		try {
			Paragraph resumeHeadingParagraph = new Paragraph(heading1, resumeHeadingFont);
			resumeHeadingParagraph.setAlignment(Element.ALIGN_LEFT);
			document.add(resumeHeadingParagraph);
			
			Paragraph contentParagraph1 = new Paragraph(contentLine1, normalBlackFont);
			contentParagraph1.setAlignment(Element.ALIGN_LEFT);
			document.add(contentParagraph1);
			
			Paragraph contentParagraph2 = new Paragraph(contentLine2, normalBlueFont);
			contentParagraph2.setAlignment(Element.ALIGN_LEFT);
			document.add(contentParagraph2);
		} catch (DocumentException e) {
			
		}
	}
	
	// =========================================================================
	
	private void addSubHeading(Document document, String subHeading) {
		try {
			Paragraph subHeadingParagraph = new Paragraph(subHeading, subHeadingFont);
			subHeadingParagraph.setAlignment(Element.ALIGN_LEFT);
			subHeadingParagraph.setSpacingAfter(-12);
			document.add(subHeadingParagraph);
			document.add(Chunk.NEWLINE);
			document.add(lineSeparator);
		} catch (Exception e) { }
	}
	
	// ========================================================================
	
	private void addContent1(Document document, String contentLine1, String contentLine2, String contentLine3) {
		
		try {
			Paragraph createParagraph2 = new Paragraph(contentLine1, boldBlackFont);
			createParagraph2.setAlignment(Element.ALIGN_LEFT);
			document.add(createParagraph2);

			Paragraph contentLine2Paragraph = new Paragraph(contentLine2, normalGrayFont);
			contentLine2Paragraph.setAlignment(Element.ALIGN_LEFT);
			document.add(contentLine2Paragraph);

			Paragraph contentLine3Paragraph = new Paragraph(contentLine3, normalGrayFont);
			contentLine3Paragraph.setAlignment(Element.ALIGN_LEFT);
			document.add(contentLine3Paragraph);
			
		} catch (Exception e) {
			
		}
	}
	
	// =========================================================================

	private void addContent2(Document document, String contentLine1, String contentLine2, String contentLine3) {
		
		try {
			Paragraph createParagraph2 = new Paragraph(contentLine1, boldBlackFont);
			createParagraph2.setAlignment(Element.ALIGN_LEFT);
			document.add(createParagraph2);

			Paragraph contentLine2Paragraph = new Paragraph(contentLine2, normalBlackFont);
			contentLine2Paragraph.setAlignment(Element.ALIGN_LEFT);
			document.add(contentLine2Paragraph);

			Paragraph contentLine3Paragraph = new Paragraph(contentLine3, normalGrayFont);
			contentLine3Paragraph.setAlignment(Element.ALIGN_LEFT);
			document.add(contentLine3Paragraph);
			
		} catch (Exception e) {
			
		}
	}

	// =========================================================================
	
	private void addContent2(Document document, String contentLine1, String contentLine2) {
		
		try {
			Paragraph contentLine2Paragraph = new Paragraph(contentLine1, normalBlackFont);
			contentLine2Paragraph.setAlignment(Element.ALIGN_LEFT);
			document.add(contentLine2Paragraph);

			Paragraph contentLine3Paragraph = new Paragraph(contentLine2, normalGrayFont);
			contentLine3Paragraph.setAlignment(Element.ALIGN_LEFT);
			document.add(contentLine3Paragraph);
			
		} catch (Exception e) {
			
		}
	}

	// =========================================================================
	
}