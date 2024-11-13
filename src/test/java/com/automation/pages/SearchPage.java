package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    String xpath= "//div[@class='Plp__plpHeading']/span[text()='%s\"']";

    public boolean isSearchedProdPageDisplayed(String product){
        WebElement prodElement= driver.findElement(By.xpath(String.format(xpath,product)));
        return prodElement.isDisplayed();
    }
}
