package org.example.pages;


import com.codeborne.selenide.Condition;
import org.example.pages.popups.FiltersPopUp;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage extends BasePage {


    private By filterButton = By.xpath("//span[text() = 'Filter']/ancestor::button");

    public FiltersPopUp clickFilterButton() {
        $(filterButton).click();
        return new FiltersPopUp();
    }

    public SearchResultPage waitTillFilterButtonInteractive() {
        $(filterButton).shouldBe(Condition.interactable);
        return this;
    }
}