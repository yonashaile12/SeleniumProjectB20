package com.cybertek.tests.day14_excel_io;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ReadExcelFile {

    public static void main(String[] args) throws IOException {
        String path = "vytrack_testusers.xlsx";
        File file = new File(path);
        //Step 1.Create excel file object
        //workbook object represents excel file
        //it has spreadsheets that we are going to read as well
        Workbook workbook = WorkbookFactory.create(file);
        int numOfSheets = workbook.getNumberOfSheets();
        System.out.println("Number of Sheets: " + numOfSheets);
        //Step 2. Create objects of spreadsheet
        Sheet sheet = workbook.getSheet("QA3-short");
        //Step 3. Read a row
        Row row1 = sheet.getRow(0);
        //Step 4. read cell
        Cell cell1 = row1.getCell(0);
        String value1 = cell1.getStringCellValue();
        //Step 6. use value
        System.out.println("Value of 1st row 1st column: "+value1);
        //to get each workbook by using forEach loop
        //sh - temporary variable name
        workbook.forEach(sh-> System.out.println(sh.getSheetName()));
        //how do we get a data from entire row?
        Iterator<Cell>cellIterator = row1.cellIterator();
        while(cellIterator.hasNext()){
            String value = cellIterator.next().getStringCellValue();
            System.out.print(value+" ");
        }
        System.out.println("\n##############################");
        //return iterator of rows
        Iterator<Row>rowIterator = sheet.rowIterator();
        while(rowIterator.hasNext()){
            Iterator<Cell> temCellIterator = rowIterator.next().cellIterator();
            while(temCellIterator.hasNext()){
                String value = temCellIterator.next().getStringCellValue();
                System.out.print(value+" ");
            }
            System.out.println();
        }
    }
}
