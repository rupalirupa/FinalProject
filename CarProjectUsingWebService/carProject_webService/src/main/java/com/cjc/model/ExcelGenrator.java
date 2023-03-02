package com.cjc.model;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelGenrator {

    private  List<ViewEmi> emi;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelGenrator(List<ViewEmi> data) {
        this.emi = data;
        workbook = new XSSFWorkbook();
    }
    private void writeHeader() {
        sheet = workbook.createSheet("viewemi");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
//        createCell(row, 0, "ledgerId", style);
//        createCell(row, 1, "ledgerCreatedDate", style);
//        createCell(row, 2, "totalLoanAmount", style);
//        createCell(row, 3, "payableAmountwithInterest", style);
//        createCell(row, 4, "tenure", style);
//        createCell(row, 5, "monthlyEmi", style);
//        createCell(row, 6, "amountPaidTillDate", style);
//        createCell(row, 7, "reamainingAmount", style);
//        createCell(row, 8, "nextEmiStartDate", style);
//        createCell(row, 9, "nextEmiEnddate", style);
//        createCell(row, 10, "defaulterCount", style);
//        createCell(row, 11, "previousEmiStatus", style);
//        createCell(row, 12, "currentMonthEmiStatus", style);
//        createCell(row, 13, "loanEndDate", style);
//        createCell(row, 14, "loanStatus", style);
   
        createCell(row, 0, "emiid", style);
        createCell(row, 1, "num", style);
        createCell(row, 2, "customerId", style);
        createCell(row, 3, "agreementDate", style);
        createCell(row, 4, "loanAmtSanctioned", style);
        createCell(row, 5, "rateOfInterest", style);
        createCell(row, 6, "loanTenure", style);
        createCell(row, 7, "monthlyEmiAmount", style);
        createCell(row, 8, "status", style);
        
    }
    private void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (valueOfCell instanceof Integer) {
            cell.setCellValue((Integer) valueOfCell);
        } else if (valueOfCell instanceof Long) {
            cell.setCellValue((Long) valueOfCell);
        } else if (valueOfCell instanceof String) {
            cell.setCellValue((String) valueOfCell);
        }
        else if (valueOfCell instanceof Double) {
            cell.setCellValue((Double) valueOfCell);}
        
        else {
            cell.setCellValue((Boolean) valueOfCell);
        }
        cell.setCellStyle(style);
    }
    private void write() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
//        for (Ledger record: LedgerList) {
//            Row row = sheet.createRow(rowCount++);
//            int columnCount = 0;
//            createCell(row, columnCount++, record.getLedgerId(), style);
//            createCell(row, columnCount++, record.getLedgerCreatedDate(), style);
//            createCell(row, columnCount++, record.getTotalLoanAmount(), style);
//            createCell(row, columnCount++, record.getPayableAmountwithInterest(), style);
//            createCell(row, columnCount++, record.getTenure(), style);
//            createCell(row, columnCount++, record.getMonthlyEmi(), style);
//            createCell(row, columnCount++, record.getAmountPaidTillDate(), style);
//            createCell(row, columnCount++, record.getReamainingAmount(), style);
//            createCell(row, columnCount++, record.getNextEmiStartDate(), style);
//            createCell(row, columnCount++, record.getNextEmiEnddate(), style);
//            createCell(row, columnCount++, record.getDefaulterCount(), style);
//            createCell(row, columnCount++, record.getPreviousEmiStatus(), style);
//            createCell(row, columnCount++, record.getCurrentMonthEmiStatus(), style);
//            createCell(row, columnCount++, record.getLoanEndDate(), style);
//            createCell(row, columnCount++, record.getLoanStatus(), style);
//        }
        for (ViewEmi record: emi) {
//          Row row = sheet.createRow(rowCount++);
//          int columnCount = 0;
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, record.getEmiid(), style);
            createCell(row, columnCount++, record.getNum(), style);
            createCell(row, columnCount++, record.getCustomerId(), style);
            createCell(row, columnCount++, record.getAgreementDate(), style);
            createCell(row, columnCount++, record.getLoanAmtSanctioned(), style);
            createCell(row, columnCount++, record.getRateOfInterest(), style);
            createCell(row, columnCount++, record.getLoanTenure(), style);
            createCell(row, columnCount++, record.getMonthlyEmiAmount(), style);
            createCell(row, columnCount++, record.getStatus(), style);
        }            
    }
    public void generateExcelFile(HttpServletResponse response) throws IOException {
        writeHeader();
        write();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}