package com.automation.tests;

import com.automation.utils.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest extends BaseTest {

    @Test(dataProvider = "prodList")
    public void searchTest(String data) throws InterruptedException {
        homePage.openWebsite();
        Thread.sleep(5000);
        homePage.searchProd(data);
    }

    @DataProvider
    public Object[][] prodList(){
        ExcelUtils excelUtils=new ExcelUtils("Book1.xlsx","Sheet1");
        List<List<String>> tableData=excelUtils.getData();
        Object[][] data=new Object[tableData.size()][tableData.get(0).size()];
        for(int i=0;i< tableData.size();i++){
            List<String> row=tableData.get(i);
            for (int j=0;j< row.size();j++){
                data[i][j]=row.get(j);
            }
        }
        return data;
    }
}
