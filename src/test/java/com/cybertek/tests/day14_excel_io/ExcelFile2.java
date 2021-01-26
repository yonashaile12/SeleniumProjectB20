package com.cybertek.tests.day14_excel_io;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;

public class ExcelFile2 {

    public static void main(String[] args) throws IOException {
        String path = "vytrack_testusers.xlsx";
        File file = new File(path);
        // create workbook object
        // XSSFWorkbook -- xlsx, new excel
        // HSSFWorkbook -- xls, old excel
       // Workbook workbook2 = new XSSFWorkbook(file);
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheet("QA3-short");
        // we know how to get data from row
        // get number of rows
        int rowNum = sheet.getLastRowNum();
        // get the number of columns
        int colNum = sheet.getRow(0).getLastCellNum();

        // first outer loop to iterate rows
        for(int rowIndex = 0; rowIndex <= rowNum; rowIndex++){
            // inner loop to iterate columns
            for(int columindex = 0; columindex < colNum; columindex++){
                String value = sheet.getRow(rowIndex).getCell(columindex).getStringCellValue();
                System.out.printf("%15s",value);
            }
            System.out.println();
        }
        System.out.println("#################### WITH FOR EACH LOOP");
        for(Row row: sheet){
            for(Cell cell:row){
                System.out.printf("%15s",cell.getStringCellValue());
            }
            System.out.println();
        }


    }
}
