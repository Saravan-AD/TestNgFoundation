package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class FootWearPage extends BasePage{

    @FindBy(xpath = "//div[text()='Department']/following-sibling::div/div[text()='Footwear']")
    WebElement footwearDept;

    @FindBy(className = "ProductModule__dummyDiv")
    List<WebElement> shoesOpt;

//    @FindBy(xpath = "//div[@class='ProductDescription__discount ProductDescription__priceHolder']/h3[@class='ProductDescription__boldText']")
//    List<WebElement> prices;

    @FindBy(className = "SizeSelectNewPdp__sizeTexts")
    List<WebElement> sizeOpt;

    @FindBy(xpath = "//button[text()='Add To Bag']")
    WebElement addToBagBtn;

    @FindBy(xpath = "//div[@class='SelectBoxDesktop__base']/select")
    WebElement sortSelect;

    public boolean isFootwearDeptPageDisplayed(){
        return footwearDept.isDisplayed();
    }

    public void selectFirstThreeProducts() throws InterruptedException {
        String currentWindow=driver.getWindowHandle();
        for (int i=0;i<=2;i++){
            shoesOpt.get(i).click();
            Set<String> windows=driver.getWindowHandles();
            for (String window:windows){
                if(!window.equals(currentWindow)){
                    driver.switchTo().window(window);
                }
            }

            sizeOpt.get(1).click();
            addToBagBtn.click();
            Thread.sleep(5000);
            driver.close();
            driver.switchTo().window(currentWindow);
        }
    }

    public void sortProducts(){
        Select select=new Select(sortSelect);
        select.selectByValue("price-asc");
    }

    public void checkSorting(){
        List<WebElement> prices=driver.findElements(By.xpath("//div[@class='ProductDescription__discount ProductDescription__priceHolder']/h3[@class='ProductDescription__boldText']"));
        System.out.println(prices);
        List<String> actualPriceList=new ArrayList<>();
        for (WebElement price:prices){
            actualPriceList.add(price.getText().replace("₹",""));
        }
        List<Integer> actualPriceList2=new ArrayList<>();
        for (String price:actualPriceList){
            actualPriceList2.add(Integer.valueOf(price));
        }
        ConfigReader.setConfig("sort.list", actualPriceList.toString());
        Collections.sort(actualPriceList2);
        ConfigReader.setConfig("expected.list", actualPriceList2.toString());
    }
}
