package org.example.pages;


import org.example.UrlProvider;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StartPage extends BasePage implements IBasePageWithUrl{


    private By checkInDateButton = By.xpath("//div[text()='Check-in']/ancestor::div[@class='sc-fuISkM cpwVzr']");
    private By searchButton = By.xpath("//*[@class = 'sc-giAqHp brmoYr']");

    public SearchResultPage clickSearchButton() {
        $(searchButton).click();
        return new SearchResultPage();
    }

    public StartPage clickCheckInDateButton() {
        $(checkInDateButton).click();
        return this;
    }

    @Override
    public StartPage openPage() {
        return open(new UrlProvider().getBaseUrl(), StartPage.class);
    }
}