package com.cjc.model;


import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;



public class PdfGenerator {
	public void generate(List< ViewEmi> emilist, HttpServletResponse response) throws DocumentException, IOException {
	    // Creating the Object of Document
	    Document document = new Document(PageSize.LEDGER);
	    // Getting instance of PdfWriter
	    PdfWriter.getInstance(document, response.getOutputStream());
	    // Opening the created document to change it
	    document.open();
	    // Creating font
	    // Setting font style and size
	    Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	    fontTiltle.setSize(20);
	    // Creating paragraph
	    Paragraph paragraph1 = new Paragraph("List of the Emi", fontTiltle);
	    // Aligning the paragraph in the document
	    paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
	    // Adding the created paragraph in the document
	    document.add(paragraph1);
	    // Creating a table of the 4 columns
	    PdfPTable table = new PdfPTable(9);
	    // Setting width of the table, its columns and spacing
	    table.setWidthPercentage(100);
	    table.setWidths(new int[] {1,1,3,3,3,3,3,3,3});
	    table.setSpacingBefore(5);
	    // Create Table Cells for the table header
	    PdfPCell cell = new PdfPCell();
	    // Setting the background color and padding of the table cell
	    cell.setBackgroundColor(CMYKColor.BLUE);
	    cell.setPadding(5);
	    // Creating font
	    // Setting font style and size
	    Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	    font.setColor(CMYKColor.WHITE);
	    // Adding headings in the created table cell or  header
	    // Adding Cell to table
	    cell.setPhrase(new Phrase("emiid", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("num ", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("customerId", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("agreementDate", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("loanAmtSanctioned", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("rateOfInterest", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("loanTenure", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("monthlyEmiAmount", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("status", font));
	    table.addCell(cell);
	    // Iterating the list of ViewEmis
	    for (ViewEmi ViewEmi: emilist) {
	      // Adding ViewEmi id
	      table.addCell(String.valueOf(ViewEmi.getEmiid()));
	      // Adding ViewEmi name
	      table.addCell(String.valueOf(ViewEmi.getCustomerId()));
	      // Adding ViewEmi email
	      table.addCell(String.valueOf(ViewEmi.getNum()));
	      // Adding ViewEmi mobile
	      table.addCell(ViewEmi.getAgreementDate());
	      table.addCell(String.valueOf(ViewEmi.getLoanAmtSanctioned()));
	      table.addCell(String.valueOf(ViewEmi.getLoanTenure()));
	      table.addCell(String.valueOf(ViewEmi.getMonthlyEmiAmount()));
	      table.addCell(String.valueOf(ViewEmi.getRateOfInterest()));
	      table.addCell(ViewEmi.getStatus());
	      
	    }
	    // Adding the created table to the document
	    document.add(table);
	    // Closing the document
	    document.close();
	  }
	}
	

