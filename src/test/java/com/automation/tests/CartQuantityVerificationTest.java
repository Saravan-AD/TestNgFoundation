package com.automation.tests;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartQuantityVerificationTest extends BaseTest {

    @Test
    public void checkCartQtyIsCorrect() throws InterruptedException {
        homePage.openWebsite();
        Thread.sleep(5000);
        homePage.selectReebokFootwear();

        Assert.assertTrue(footWearPage.isFootwearDeptPageDisplayed());
        footWearPage.selectFirstThreeProducts();

        homePage.clickCartIcon();
        Assert.assertTrue(cartPage.isCartPageDisplayed());

        cartPage.checkCartQty();
        Assert.assertEquals(ConfigReader.getConfig("cart.qty"),"3");
    }

}
