package org.example.pages.popups;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.example.pages.BasePage;
import org.openqa.selenium.By;

public class DatePicker extends BasePage {


    private By clearAllButton = By.xpath("//span[text() = 'Clear dates']/ancestor::button");
    private By leftArrowButton = By.xpath("//*[@* = '#chevron-left']/ancestor::button[@class = 'sc-giAqHp fYuuJT']");

    public SelenideElement waitTillClearAllButtonDisplayed() {
        return Selenide.$(clearAllButton).shouldBe(Condition.interactable, SHORTEST);
    }

    public boolean isMonthYearTitleDisplayed(String text) {
        return Selenide.$(By.xpath(String.format("//div[@class = 'sc-dtLLSn dpehyt'][contains(text(), '%s')]", text))).isDisplayed();
    }

    public DatePicker clickDayByMonthAndYear(String monthYear, String date) {
        var xpath = "//div[@class = 'sc-dtLLSn dpehyt'][text() = '%s']/following-sibling::*[1]/div[contains(@class, 'CalendarDay')][text() = '%s']";
        Selenide.$(By.xpath(String.format(xpath, monthYear, date))).click();
        return this;
    }

    public DatePicker clickArrowLeftButton() {
        Selenide.$(leftArrowButton).click();
        return this;
    }


}