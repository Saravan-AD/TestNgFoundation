package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {
    @FindBy(xpath = "//div[@class='SizeQuantitySelectBox__header' and text()='Qty']/following-sibling::div/span")
    List<WebElement> qtyOfItem;

    @FindBy(className = "CartPage__myBag")
    WebElement cartPage;

    public void checkCartQty(){
        int quantity=0;
        for (WebElement qty:qtyOfItem){
            quantity+=Integer.parseInt(qty.getText());
        }
        ConfigReader.setConfig("cart.qty", String.valueOf(quantity));
    }

    public boolean isCartPageDisplayed(){
        return cartPage.isDisplayed();
    }
}
