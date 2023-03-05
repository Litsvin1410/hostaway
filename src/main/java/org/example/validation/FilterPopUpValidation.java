package org.example.validation;

import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;
import org.example.pages.popups.FiltersPopUp;
import org.testng.asserts.SoftAssert;

import java.util.function.Function;

public class FilterPopUpValidation {

    private final static int MAX_AMOUNT = 10;
    private final static int DEFAULT_AMOUNT = 0;

    private Function<String, Boolean> isNumericOrEmpty = string -> StringUtils.isNumeric(string) || StringUtils.isEmpty(string);

    @Step("Filters: verify that all checkboxes are uncheck initially")
    public void verifyCheckboxesInDefaultState(SoftAssert softAssert) {
        FiltersPopUp filtersPopUp = new FiltersPopUp();

        softAssert.assertFalse(filtersPopUp.isBeachFrontCheckboxSelected(), "Beach front check box: shouldn't be selected by default");
        softAssert.assertFalse(filtersPopUp.isFreeWiFiCheckBoxSelected(), "Free wi-fi check box: shouldn't be selected by default");
        softAssert.assertFalse(filtersPopUp.isAirConditioningCheckboxSelected(), "Air conditioning check box: shouldn't be selected by default");
        softAssert.assertFalse(filtersPopUp.isPetsAllowedCheckboxSelected(), "Pets allowed check box: shouldn't be selected by default");
        softAssert.assertFalse(filtersPopUp.isStreetParkingCheckboxSelected(), "Street parking check box: shouldn't be selected by default");
        softAssert.assertFalse(filtersPopUp.isSwimmingPoolCheckboxSelected(), "Swimming pool check box: shouldn't be selected by default");
        softAssert.assertFalse(filtersPopUp.isKitchenCheckboxSelected(), "Kitchen check box: shouldn't be selected by default");
        softAssert.assertFalse(filtersPopUp.isWashingMachineCheckboxSelected(), "Washing machine check box: shouldn't be selected by default");
        softAssert.assertFalse(filtersPopUp.isHotTubCheckboxSelected(), "Hot tube check box: shouldn't be selected by default");
        softAssert.assertFalse(filtersPopUp.isSuitableForChildrenCheckboxSelected(), "Suitable for children check box: shouldn't be selected by default");
    }

    @Step("Filters: verify that all checkboxes could be selected after being clicked")
    public void verifyAllCheckboxSelected(SoftAssert softAssert) {

        FiltersPopUp filtersPopUp = new FiltersPopUp();

        softAssert.assertTrue(filtersPopUp.isBeachFrontCheckboxSelected(), "Beach front check box: isn't selected after being clicked");
        softAssert.assertTrue(filtersPopUp.isFreeWiFiCheckBoxSelected(), "Free wi-fi check box: isn't selected after being clicked");
        softAssert.assertTrue(filtersPopUp.isAirConditioningCheckboxSelected(), "Air conditioning check box: isn't selected after being clicked");
        softAssert.assertTrue(filtersPopUp.isPetsAllowedCheckboxSelected(), "Pets allowed check box: isn't selected after being clicked");
        softAssert.assertTrue(filtersPopUp.isStreetParkingCheckboxSelected(), "Street parking check box: isn't selected after being clicked");
        softAssert.assertTrue(filtersPopUp.isSwimmingPoolCheckboxSelected(), "Swimming pool check box: isn't selected after being clicked");
        softAssert.assertTrue(filtersPopUp.isKitchenCheckboxSelected(), "Kitchen check box: isn't selected after being clicked");
        softAssert.assertTrue(filtersPopUp.isWashingMachineCheckboxSelected(), "Washing machine check box: isn't selected after being clicked");
        softAssert.assertTrue(filtersPopUp.isHotTubCheckboxSelected(), "Hot tube check box: isn't selected after being clicked");
        softAssert.assertTrue(filtersPopUp.isSuitableForChildrenCheckboxSelected(), "Suitable for children check box: isn't selected after being clicked");
    }

    @Step("Filters: number pickers verifications (Amount of beds, bedrooms and bathrooms)")
    public void verifyNumberPickers(SoftAssert softAssert) {

        FiltersPopUp filtersPopUp = new FiltersPopUp();
        softAssert.assertEquals(filtersPopUp.getBedsAmount(), DEFAULT_AMOUNT, "Beds amount: initial value isn't 0");
        softAssert.assertEquals(filtersPopUp.getBedroomsAmount(), DEFAULT_AMOUNT, "Bedrooms amount: initial value isn't 0");
        softAssert.assertEquals(filtersPopUp.getBathroomsAmount(), DEFAULT_AMOUNT, "Bathrooms amount: initial value isn't 0");

        var changedBedsAmount = filtersPopUp.clickRemoveBedFewTimes(1).getBedsAmount();
        softAssert.assertEquals(changedBedsAmount, DEFAULT_AMOUNT, "Beds amount: able to change to negative value");
        var changedBedroomsAmount = filtersPopUp.clickRemoveBedroomFewTimes(1).getBedroomsAmount();
        softAssert.assertEquals(changedBedroomsAmount, DEFAULT_AMOUNT, "Bedrooms amount: able to change to negative value");
        var changedBathroomsAmount = filtersPopUp.clickRemoveBedFewTimes(1).getBedsAmount();
        softAssert.assertEquals(changedBathroomsAmount, DEFAULT_AMOUNT, "Bathrooms amount: able to change to negative value");

        var amountToAdd = 6;
        changedBedsAmount = filtersPopUp.clickAddBedFewTimes(amountToAdd).getBedsAmount();
        softAssert.assertEquals(changedBedsAmount, DEFAULT_AMOUNT + amountToAdd, "Beds amount: incorrect calculation (increasing)");
        changedBedroomsAmount = filtersPopUp.clickAddBedroomFewTimes(amountToAdd).getBedroomsAmount();
        softAssert.assertEquals(changedBedroomsAmount, DEFAULT_AMOUNT + amountToAdd, "Bedrooms amount: incorrect calculation (increasing)");
        changedBathroomsAmount = filtersPopUp.clickAddBathroomFewTimes(amountToAdd).getBathroomsAmount();
        softAssert.assertEquals(changedBathroomsAmount, DEFAULT_AMOUNT + amountToAdd, "Bathrooms amount: incorrect calculation (increasing)");

        changedBedsAmount = filtersPopUp.clickAddBedFewTimes(amountToAdd).getBedsAmount();
        softAssert.assertEquals(changedBedsAmount, MAX_AMOUNT, "Beds amount: set value bigger than maximal");
        changedBedroomsAmount = filtersPopUp.clickAddBedroomFewTimes(amountToAdd).getBedroomsAmount();
        softAssert.assertEquals(changedBedroomsAmount, MAX_AMOUNT, "Bedrooms amount: set value bigger than maximal");
        changedBathroomsAmount = filtersPopUp.clickAddBathroomFewTimes(amountToAdd).getBathroomsAmount();
        softAssert.assertEquals(changedBathroomsAmount, MAX_AMOUNT, "Bathrooms amount: set value bigger than maximal");

        changedBedsAmount = filtersPopUp.clickRemoveBedFewTimes(amountToAdd).getBedsAmount();
        softAssert.assertEquals(changedBedsAmount, MAX_AMOUNT - amountToAdd, "Beds amount: incorrect calculation (decreasing)");
        changedBedroomsAmount = filtersPopUp.clickRemoveBedroomFewTimes(amountToAdd).getBedroomsAmount();
        softAssert.assertEquals(changedBedroomsAmount, MAX_AMOUNT - amountToAdd, "Bedrooms amount: incorrect calculation (decreasing)");
        changedBathroomsAmount = filtersPopUp.clickRemoveBathroomFewTimes(amountToAdd).getBathroomsAmount();
        softAssert.assertEquals(changedBathroomsAmount, MAX_AMOUNT - amountToAdd, "Bathrooms amount: incorrect calculation (decreasing)");
    }

    @Step("Filters: price limitation fields verifications")
    public void verifyPriceInputFields(SoftAssert softAssert) {

        FiltersPopUp filtersPopUp = new FiltersPopUp();

        var expectedMinValue = "100";
        var expectedMaxValue = "200";
        filtersPopUp.setMinPrice(expectedMinValue);
        filtersPopUp.setMaxPrice((expectedMaxValue));
        softAssert.assertEquals(filtersPopUp.getMinPriceValue(), expectedMinValue, "Minimal price isn't saved correctly");
        softAssert.assertEquals(filtersPopUp.getMaxPriceValue(), expectedMaxValue, "Maximal price isn't saved correctly");

        //TODO: to be clarified: in some case on attempt to enter invalid values (like text values, negative values, enter bigger number to 'From' field etc.)
        // the app performs some built-in logic (?)
//        expectedMinValue = "200";
//        expectedMaxValue = "100";
//        filtersPopUp.setMinPrice(expectedMinValue).setMaxPrice((expectedMaxValue));
//        softAssert.assertTrue(isNumericOrEmpty.apply(filtersPopUp.getMinPriceValue()), "Minimal price: able to enter string value");
//        softAssert.assertTrue(isNumericOrEmpty.apply(filtersPopUp.getMaxPriceValue()), "Maximal price: able to enter string value");

        expectedMinValue = "minimal";
        expectedMaxValue = "maximal";
        filtersPopUp.setMinPrice(expectedMinValue).setMaxPrice((expectedMaxValue));
        softAssert.assertTrue(isNumericOrEmpty.apply(filtersPopUp.getMinPriceValue()), "Minimal price: able to enter string value");
        softAssert.assertTrue(isNumericOrEmpty.apply(filtersPopUp.getMaxPriceValue()), "Maximal price: able to enter string value");

        expectedMinValue = "-200";
        expectedMaxValue = "-100";
        filtersPopUp.setMinPrice(expectedMinValue).setMaxPrice((expectedMaxValue));
        softAssert.assertTrue(isNumericOrEmpty.apply(filtersPopUp.getMinPriceValue()), "Minimal price: able to enter negative value");
        softAssert.assertTrue(isNumericOrEmpty.apply(filtersPopUp.getMaxPriceValue()), "Maximal price: able to enter negative value");

        expectedMinValue = "100&";
        expectedMaxValue = "$200";
        filtersPopUp.setMinPrice(expectedMinValue).setMaxPrice((expectedMaxValue));
        softAssert.assertTrue(isNumericOrEmpty.apply(filtersPopUp.getMinPriceValue()), "Minimal price: able to enter special characters");
        softAssert.assertTrue(isNumericOrEmpty.apply(filtersPopUp.getMaxPriceValue()), "Maximal price: able to enter special characters");
        filtersPopUp.clearMinPrice().clearMaxPrice();

        var expectedSameValue = "100";
        filtersPopUp.setMinPrice(expectedSameValue).setMaxPrice((expectedSameValue));
        softAssert.assertEquals(filtersPopUp.getMinPriceValue(), expectedSameValue, "Minimal price: fail in case of same values");
        softAssert.assertEquals(filtersPopUp.getMaxPriceValue(), expectedSameValue, "Maximal price: fail in case of same values");
    }
}
