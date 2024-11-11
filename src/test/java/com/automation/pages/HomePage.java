package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Set;

public class HomePage extends BasePage {

    Actions actions=new Actions(driver);
    @FindBy(xpath = "//div[text()='Brands']")
    WebElement brandDropDown;

    @FindBy(id = "search-text-input")
    WebElement searchBar;

    @FindBy(className = "DesktopHeader__myBagShow")
    WebElement cartIconBtn;

    public void openWebsite(){
        driver.get(ConfigReader.getConfig("application.url"));
    }

    @FindBy(className = "Plp__plpHeading")
    WebElement heading;

    public void selectReebokFootwear(){
        actions.moveToElement(brandDropDown).build().perform();
        WebElement footwearDropDown=brandDropDown.findElement(By.xpath(".//div[text()='Footwear']"));
        actions.moveToElement(footwearDropDown).build().perform();
        WebElement reebokButton=brandDropDown.findElement(By.xpath("//a[text()='Reebok']"));
        reebokButton.click();
//        searchBar.sendKeys("shoes");
    }

    public void clickCartIcon() {
        cartIconBtn.click();
    }

    public void searchProd(String prod){
        searchBar.sendKeys(prod);
        actions.keyDown(Keys.ENTER).build().perform();
        actions.keyUp(Keys.ENTER).build().perform();
    }
}
