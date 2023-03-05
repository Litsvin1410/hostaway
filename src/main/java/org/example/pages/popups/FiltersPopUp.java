package org.example.pages.popups;


import org.example.pages.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FiltersPopUp extends BasePage {


    private By fromInputField = By.xpath("//input[@placeholder = 'From']");
    private By toInputField = By.xpath("//input[@placeholder = 'To']");
    private By applyButton = By.xpath("//span[text() = 'Apply']/ancestor::button");
    private By clearAllButton = By.xpath("//b[text() = 'Clear all']");//поменять на beTxt

    private String plusButtonCommonPart = "/..//button[@class = 'sc-fWWYYk sc-gzcbmu bZTTYU fKwyEY']";
    private By addBedButton = By.xpath("//div[text() = 'Beds']" + plusButtonCommonPart);
    private By addBedroomButton = By.xpath("//div[text() = 'Bedrooms']" + plusButtonCommonPart);
    private By addBathroomButton = By.xpath("//div[text() = 'Bathrooms']" + plusButtonCommonPart);

    private String minusButtonCommonPart = "/..//button[@class = 'sc-fWWYYk sc-fIxmyt bZTTYU cnkbFD']";
    private By removeBedButton = By.xpath("//div[text() = 'Beds']" + minusButtonCommonPart);
    private By removeBedroomButton = By.xpath("//div[text() = 'Bedrooms']" + minusButtonCommonPart);
    private By removeBathroomButton = By.xpath("//div[text() = 'Bathrooms']" + minusButtonCommonPart);

    private String valueCommonPart = "/..//span[@class = 'sc-gVFcvn gnLtVL']";
    private By bedsAmount = By.xpath("//div[text() = 'Beds']" + valueCommonPart);
    private By bedroomsAmount = By.xpath("//div[text() = 'Bedrooms']" + valueCommonPart);
    private By bathroomsAmount = By.xpath("//div[text() = 'Bathrooms']" + valueCommonPart);

    private String checkBoxInputCommonPart = "//span[text() = '%s']/preceding-sibling::input";
    private By beachFrontCheckBox = By.xpath(String.format(checkBoxInputCommonPart, "Beach front"));
    private By swimmingPoolCheckBox = By.xpath(String.format(checkBoxInputCommonPart, "Swimming pool"));
    private By freeWiFiCheckBox = By.xpath(String.format(checkBoxInputCommonPart, "Free WiFi"));
    private By kitchenCheckBox = By.xpath(String.format(checkBoxInputCommonPart, "Kitchen"));
    private By airConditioningCheckBox = By.xpath(String.format(checkBoxInputCommonPart, "Air conditioning"));
    private By washingMachineCheckBox = By.xpath(String.format(checkBoxInputCommonPart, "Washing Machine"));
    private By petsAllowedCheckBox = By.xpath(String.format(checkBoxInputCommonPart, "Pets allowed"));
    private By hotTubCheckBox = By.xpath(String.format(checkBoxInputCommonPart, "Hot tub"));
    private By streetParkingCheckBox = By.xpath(String.format(checkBoxInputCommonPart, "Street parking"));
    private By suitableForChildrenCheckBox = By.xpath(String.format(checkBoxInputCommonPart, "Suitable for children"));

    private String checkboxButtonCommonPart = "//span[text() = '%s']/ancestor::label";
    private By beachFrontCheckBoxButton = By.xpath(String.format(checkboxButtonCommonPart, "Beach front"));
    private By swimmingPoolCheckBoxButton = By.xpath(String.format(checkboxButtonCommonPart, "Swimming pool"));
    private By freeWiFiCheckBoxButton = By.xpath(String.format(checkboxButtonCommonPart, "Free WiFi"));
    private By kitchenCheckBoxButton = By.xpath(String.format(checkboxButtonCommonPart, "Kitchen"));
    private By airConditioningCheckBoxButton = By.xpath(String.format(checkboxButtonCommonPart, "Air conditioning"));
    private By washingMachineCheckBoxButton = By.xpath(String.format(checkboxButtonCommonPart, "Washing Machine"));
    private By petsAllowedCheckBoxButton = By.xpath(String.format(checkboxButtonCommonPart, "Pets allowed"));
    private By hotTubCheckBoxButton = By.xpath(String.format(checkboxButtonCommonPart, "Hot tub"));
    private By streetParkingCheckBoxButton = By.xpath(String.format(checkboxButtonCommonPart, "Street parking"));
    private By suitableForChildrenCheckBoxButton = By.xpath(String.format(checkboxButtonCommonPart, "Suitable for children"));

    public FiltersPopUp scrollPageToShowAllCheckboxes() {
        $(suitableForChildrenCheckBox).scrollIntoView(true);
        return this;
    }

    public boolean isBeachFrontCheckboxSelected() {
        return $(beachFrontCheckBox).isSelected();
    }

    public boolean isSwimmingPoolCheckboxSelected() {
        return $(swimmingPoolCheckBox).isSelected();
    }

    public boolean isFreeWiFiCheckBoxSelected() {
        return $(freeWiFiCheckBox).isSelected();
    }

    public boolean isKitchenCheckboxSelected() {
        return $(kitchenCheckBox).isSelected();
    }

    public boolean isAirConditioningCheckboxSelected() {
        return $(airConditioningCheckBox).isSelected();
    }

    public boolean isWashingMachineCheckboxSelected() {
        return $(washingMachineCheckBox).isSelected();
    }

    public boolean isPetsAllowedCheckboxSelected() {
        return $(petsAllowedCheckBox).isSelected();
    }

    public boolean isHotTubCheckboxSelected() {
        return $(hotTubCheckBox).isSelected();
    }

    public boolean isStreetParkingCheckboxSelected() {
        return $(streetParkingCheckBox).isSelected();
    }

    public boolean isSuitableForChildrenCheckboxSelected() {
        return $(suitableForChildrenCheckBox).isSelected();
    }

    public FiltersPopUp clickRemoveBedFewTimes(int amount) {
        for (int i = 0; i < amount; i++) {
            $(removeBedButton).click();
        }
        return this;
    }

    public FiltersPopUp clickRemoveBedroomFewTimes(int amount) {
        for (int i = 0; i < amount; i++) {
            $(removeBedroomButton).click();
        }
        return this;
    }

    public FiltersPopUp clickRemoveBathroomFewTimes(int amount) {
        for (int i = 0; i < amount; i++) {
            $(removeBathroomButton).click();
        }
        return this;
    }

    public FiltersPopUp clickAddBedFewTimes(int amount) {
        for (int i = 0; i < amount; i++) {
            $(addBedButton).click();
        }
        return this;
    }

    public FiltersPopUp clickAddBedroomFewTimes(int amount) {
        for (int i = 0; i < amount; i++) {
            $(addBedroomButton).click();
        }
        return this;
    }

    public FiltersPopUp clickAddBathroomFewTimes(int amount) {
        for (int i = 0; i < amount; i++) {
            $(addBathroomButton).click();
        }
        return this;
    }

    public FiltersPopUp clickBeachFrontCheckbox() {
        $(beachFrontCheckBoxButton).click();
        return this;
    }

    public FiltersPopUp clickSwimmingPoolCheckbox() {
        $(swimmingPoolCheckBoxButton).click();
        return this;
    }

    public FiltersPopUp clickFreeWiFiCheckbox() {
        $(freeWiFiCheckBoxButton).click();
        return this;
    }

    public FiltersPopUp clickKitchenCheckbox() {
        $(kitchenCheckBoxButton).click();
        return this;
    }

    public FiltersPopUp clickAirConditioningCheckbox() {
        $(airConditioningCheckBoxButton).click();
        return this;
    }

    public FiltersPopUp clickWashingMachineCheckbox() {
        $(washingMachineCheckBoxButton).click();
        return this;
    }

    public FiltersPopUp clickPetsAllowedCheckbox() {
        $(petsAllowedCheckBoxButton).click();
        return this;
    }

    public FiltersPopUp clickHotTubeCheckbox() {
        $(hotTubCheckBoxButton).click();
        return this;
    }

    public FiltersPopUp clickStreetParkingCheckbox() {
        $(streetParkingCheckBoxButton).click();
        return this;
    }

    public FiltersPopUp clickSuitableForChildrenCheckbox() {
        $(suitableForChildrenCheckBoxButton).click();
        return this;
    }

    public FiltersPopUp clickClearAllButton() {
        $(clearAllButton).click();
        return this;
    }

    public FiltersPopUp setMinPrice(String price) {
        $(fromInputField).val(price);
        return this;
    }

    public FiltersPopUp setMaxPrice(String price) {
        $(toInputField).val(price);
        return this;
    }

    public int getBedsAmount() {
        return Integer.parseInt($(bedsAmount).getText());
    }

    public int getBedroomsAmount() {
        return Integer.parseInt($(bedroomsAmount).getText());
    }

    public int getBathroomsAmount() {
        return Integer.parseInt($(bathroomsAmount).getText());
    }

    public String getMinPriceValue() {
        return $(fromInputField).getValue();
    }

    public String getMaxPriceValue() {
        return $(toInputField).getValue();
    }

    public FiltersPopUp clearMinPrice() {
        $(fromInputField).clear();
        return this;
    }

    public FiltersPopUp clearMaxPrice() {
        $(toInputField).clear();
        return this;
    }
}