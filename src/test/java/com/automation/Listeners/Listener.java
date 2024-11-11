package com.automation.Listeners;

import com.automation.utils.DriverManager;
import io.qameta.allure.Allure;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class Listener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Allure.addAttachment("screenshot",takeSs());
    }

    public ByteArrayInputStream takeSs(){
        TakesScreenshot ts=(TakesScreenshot) DriverManager.getDriver();
        byte[] ss=ts.getScreenshotAs(OutputType.BYTES);
        return new ByteArrayInputStream(ss);
    }
}
