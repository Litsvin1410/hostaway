package org.example.scripts;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class TestListener extends BaseTest implements ITestListener {

//    @Attachment(type = "image/png")
//    public byte[] saveScreenshotPng(WebDriver driver) {
//        Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
//        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//    }

    @Attachment(type = "image/png")
    public byte[] takeScreenshot(WebDriver driver) {
        System.out.println("taking screenshot");
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult result){

//        Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
//        Allure.addAttachment("screenShot", new ByteArrayInputStream(((TakesScreenshot)result.getTestContext().getAttribute("WebDriver")).getScreenshotAs(OutputType.BYTES)));

        Object webDriverAttribute = result.getTestContext().getAttribute("WebDriver");
        takeScreenshot((WebDriver) webDriverAttribute);

////        Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
////        Object testClass = iTestResult.getInstance();
//        WebDriver webDriver = Selenide.webdriver().driver().getWebDriver();
////        saveScreenshotPng(webDriver);
//        Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES)));
    }
}
