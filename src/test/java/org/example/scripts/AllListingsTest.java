package org.example.scripts;

import io.qameta.allure.Description;
import org.example.pages.AllListingsPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AllListingsTest extends BaseTest {

    @Description("All listings has the same amount of results that 'All' tag has")
    @Test
    public void allListingsTest() {

        AllListingsPage allListingsPage = new AllListingsPage().openPage();

        var allTagIndex = allListingsPage.getAmountOfEntitiesInAllTag();
        var totalAmountOfEntities = allListingsPage.waitTillEntitiesDisplayed()
                .getTotalResultEntitiesAmount();

        assertEquals(allTagIndex, totalAmountOfEntities, "Mismatch in total entities amount and 'All' tag index");
    }
}