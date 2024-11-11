package com.automation.tests;

import com.automation.pages.FootWearPage;
import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PriceSortTest extends BaseTest{

    @Test
    public void sortProductsByPrice() throws InterruptedException {
        homePage.openWebsite();
        Thread.sleep(5000);
        homePage.selectReebokFootwear();

        Assert.assertTrue(footWearPage.isFootwearDeptPageDisplayed());

        footWearPage.sortProducts();
        Thread.sleep(1000);
        footWearPage.checkSorting();
        Assert.assertTrue(ConfigReader.getConfig("sort.list").equals(ConfigReader.getConfig("expected.list")));
    }
}
