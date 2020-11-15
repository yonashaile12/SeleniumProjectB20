package com.cybertek.tests.day14_excel_io;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteIntoExcelFile {

    public static void main(String[] args) throws IOException {
        //whenever you are writing data back to excel file, do not open it!
        String path = "vytrack_testusers.xlsx";
        //FileInputStream - read the file, same as File class but we have to close it at the end
        //FileOutputStream - write into the file, also has to be closed at the end
        FileInputStream file = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheet("QA2-short");
        Row row1 = sheet.getRow(1);
        //let's change N/A to PASSED
        Cell cell5 = row1.getCell(4);

        System.out.println("value: " + cell5);
        //to change value from n/a to PASSED
        cell5.setCellValue("PASSED");

        //FileOutputStream class used to write data into files
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        workbook.close();
        fileOutputStream.close();
        file.close();
    }
}
