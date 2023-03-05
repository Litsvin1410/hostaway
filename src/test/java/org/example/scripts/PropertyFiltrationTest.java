package org.example.scripts;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;
import org.example.actions.CalendarActions;
import org.example.pages.StartPage;
import org.example.pages.popups.FiltersPopUp;
import org.example.validation.FilterPopUpValidation;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class PropertyFiltrationTest extends BaseTest {

    private final static int DURATION_OF_STAY = 3;
    private final static int DEFAULT_AMOUNT = 0;

    @Description("Filters form verification")
    @Test
    public void propertyFiltrationTest() {

        StartPage startPage = new StartPage().openPage();

        setCheckInOutDates(startPage)
                .clickSearchButton()
                .waitTillFilterButtonInteractive()
                .clickFilterButton();

        SoftAssert softAssert = new SoftAssert();
        FilterPopUpValidation filterPopUpValidation = new FilterPopUpValidation();
        filterPopUpValidation.verifyPriceInputFields(softAssert);
        filterPopUpValidation.verifyNumberPickers(softAssert);

        FiltersPopUp filtersPopUp = new FiltersPopUp();
        filtersPopUp.scrollPageToShowAllCheckboxes();
        filterPopUpValidation.verifyCheckboxesInDefaultState(softAssert);
        selectAllCheckboxes(filtersPopUp);
        filterPopUpValidation.verifyAllCheckboxSelected(softAssert);

        filtersPopUp.clickClearAllButton();

        verifyAllValuesReset(filtersPopUp, softAssert);
        softAssert.assertAll();
    }

    @Step("Filters: select all checkboxes")
    public void selectAllCheckboxes(FiltersPopUp filtersPopUp) {

        filtersPopUp.clickBeachFrontCheckbox()
                .clickFreeWiFiCheckbox()
                .clickAirConditioningCheckbox()
                .clickPetsAllowedCheckbox()
                .clickStreetParkingCheckbox()
                .clickSwimmingPoolCheckbox()
                .clickKitchenCheckbox()
                .clickWashingMachineCheckbox()
                .clickHotTubeCheckbox()
                .clickSuitableForChildrenCheckbox();
    }

    @Step("Filters: Clear all button verification")
    public void verifyAllValuesReset(FiltersPopUp filtersPopUp, SoftAssert softAssert) {

        softAssert.assertTrue(StringUtils.isEmpty(filtersPopUp.getMinPriceValue()), "Minimal price value isn't reset");
        softAssert.assertTrue(StringUtils.isEmpty(filtersPopUp.getMaxPriceValue()), "Maximal price value isn't reset");

        softAssert.assertEquals(filtersPopUp.getBedsAmount(), DEFAULT_AMOUNT, "Beds amount: value isn't reset");
        softAssert.assertEquals(filtersPopUp.getBedroomsAmount(), DEFAULT_AMOUNT, "Bedrooms amount: value isn't reset");
        softAssert.assertEquals(filtersPopUp.getBathroomsAmount(), DEFAULT_AMOUNT, "Bathrooms amount: value isn't reset");

        new FilterPopUpValidation().verifyCheckboxesInDefaultState(softAssert);
    }

    @Step("Set check-in and check-out dates")
    public StartPage setCheckInOutDates(StartPage startPage) {

        var startDate = LocalDateTime.now().plus(1, ChronoUnit.DAYS);
        startPage.clickCheckInDateButton();
        CalendarActions.setDate(startDate);

        var endDate = startDate.plus(DURATION_OF_STAY, ChronoUnit.DAYS);
        CalendarActions.setDate(endDate);
        return new StartPage();
    }
}