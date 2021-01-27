package com.cybertek.excelReading;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ExcelReader {
    @Test
    public void readExcel() throws IOException {

        String path = "vytrack_testusers.xlsx";
        File file = new File(path);
        Workbook workbook = WorkbookFactory.create(file);

        Sheet sheet = workbook.getSheet("QA2-all");
        int row = sheet.getLastRowNum();
        int col = sheet.getRow(0).getLastCellNum();

        for(int rowIndex = 0; rowIndex < row; rowIndex++){
            for(int colIndex = 0; colIndex < col; colIndex++){
                String value = sheet.getRow(rowIndex).getCell(colIndex).getStringCellValue();
                System.out.printf("%15s",value);
            }
        }
        System.out.println();



    }
}
