package com.ais.jb.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import com.ais.jb.response.model.GetResumeDetailsResponse;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

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
	
	public ByteArrayInputStream getResumeData( GetResumeDetailsResponse resumeDetailsResponse) {
		Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        
        try {
        	PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(60);
            table.setWidths(new int[]{1, 3, 3});

            Font headFont = FontFactory.getFont(FontFactory.COURIER);

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Id", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Name", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Email", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            //for (City city : cities) {

                PdfPCell cell;

                cell = new PdfPCell(new Phrase(String.valueOf(1)));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(resumeDetailsResponse.getName()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(resumeDetailsResponse.getEmail()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell.setPaddingRight(5);
                table.addCell(cell);
            //}

            PdfWriter.getInstance(document, out);
            document.open();
            document.add(table);

            document.close();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
        return new ByteArrayInputStream(out.toByteArray());
	}
	
	// ========================================================================
}
