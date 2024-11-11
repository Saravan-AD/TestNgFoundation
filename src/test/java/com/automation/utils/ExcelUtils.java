package com.automation.utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    public ExcelUtils(String filename,String sheetname){
        try {
            workbook=new XSSFWorkbook("src/test/resources/data/"+filename);
            sheet=workbook.getSheet(sheetname);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getTotalColumnNumber(){
        return sheet.getRow(0).getLastCellNum();
    }

    public int getTotalRowNumber(){
        return sheet.getLastRowNum();
    }

    public List<List<String>> getData(){
        List<List<String>> tableData=new ArrayList<>();
        for (int i=1;i<=getTotalRowNumber();i++){
            XSSFRow row= sheet.getRow(i);
            List<String> rowData=new ArrayList<>();
            for(int j=0;j<getTotalColumnNumber();j++){
                rowData.add(row.getCell(j).getStringCellValue());
            }
            tableData.add(rowData);
        }
        System.out.println(tableData);
        return tableData;
    }
}
