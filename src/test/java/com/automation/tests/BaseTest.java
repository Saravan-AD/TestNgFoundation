package com.automation.tests;

import com.automation.pages.CartPage;
import com.automation.pages.FootWearPage;
import com.automation.pages.HomePage;
import com.automation.pages.SearchPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    HomePage homePage;
    CartPage cartPage;
    FootWearPage footWearPage;
    SearchPage searchPage;

    @BeforeMethod
    public void setUp(){
        ConfigReader.initConfig();
        DriverManager.createDriver();
        homePage=new HomePage();
        footWearPage=new FootWearPage();
        cartPage=new CartPage();
        searchPage=new SearchPage();
    }

    @AfterMethod
    public void cleanUp(){
//        DriverManager.getDriver().quit();
    }
}
