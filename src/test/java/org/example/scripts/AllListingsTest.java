package org.example.scripts;

import io.qameta.allure.Description;
import org.example.pages.AllListingsPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;

@Listeners(TestListener.class)
public class AllListingsTest extends BaseTest {

    @Description("All listings has the same amount of results that 'All' tag has")
    @Test
    public void allListingsTest() {

        AllListingsPage allListingsPage = new AllListingsPage().openPage();

        var allTagIndex = allListingsPage.getAmountOfEntitiesInAllTag();
        var totalAmountOfEntities = allListingsPage.waitTillEntitiesDisplayed()
                .getTotalResultEntitiesAmount();

        assertEquals(1, 2, "Mismatch in total entities amount and 'All' tag index");
//        assertEquals(allTagIndex, totalAmountOfEntities, "Mismatch in total entities amount and 'All' tag index");
    }
}