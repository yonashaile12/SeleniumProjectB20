package com.cybertek.tests.day14_excel_io;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class excelReader_IO {

    public static void main(String[] args) throws IOException {

        String path = "vytrack_testusers.xlsx";
        File file = new File(path);
        // workbook help us to create the file or read from the xslx (excel) file
        Workbook workbook = WorkbookFactory.create(file);

        int numOfSheets = workbook.getNumberOfSheets();
        System.out.println("numOfSheets: " + numOfSheets);

        Sheet sheet = workbook.getSheet("QA3-short");

        Row row = sheet.getRow(0);
        Cell cell1 = row.getCell(0);

        String value = cell1 .getStringCellValue();
        System.out.println("value of 1st row 1st column: " + value);
        // to loop through the rows and cells using lambda
        workbook.forEach(sh-> System.out.println(sh.getSheetName()));
        // using regular for each loop
        for(Sheet sh: workbook){
            System.out.println(sh.getSheetName());
        }

        // how do we get all data from entire row
        Iterator<Cell> cellIterator = row.cellIterator();
        while(cellIterator.hasNext()){
            System.out.print(cellIterator.next().getStringCellValue()+ " ");
        }

        System.out.println("#############################");
        // this iterator returns rows
        Iterator<Row> rowIterator = sheet.rowIterator();
        while(rowIterator.hasNext()){
            Iterator<Cell> tempCellIterator = rowIterator.next().cellIterator();
            while(tempCellIterator.hasNext()){
                String value1 = tempCellIterator.next().getStringCellValue();
                System.out.print(value1+" ");
            }

            System.out.println();
        }


    }
}
