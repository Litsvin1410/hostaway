package org.example.pages;


import com.codeborne.selenide.Condition;
import org.example.UrlProvider;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.xpath;

public class AllListingsPage extends BasePage implements IBasePageWithUrl{

    private By allTagIndex = xpath("//span[@class = 'sc-eGJWMs lkeyLH']/span");
    private By resultEntity = xpath("//div[@class = 'sc-gSYDnn wmfak']");

    public int getAmountOfEntitiesInAllTag() {
        return Integer.parseInt($(allTagIndex).getText().replace("(", "").replace(")", ""));
    }

    public int getTotalResultEntitiesAmount() {
        return $$(resultEntity).size();
    }

    public AllListingsPage waitTillEntitiesDisplayed(){
        $(resultEntity).shouldBe(Condition.visible, SHORT);
        return this;
    }

    @Override
    public AllListingsPage openPage() {
        return  open(new UrlProvider().getAllListingsUrl(), AllListingsPage.class);
    }
}