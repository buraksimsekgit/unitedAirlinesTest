package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import texts.ExpectedTextsForUnitedApp;
import utilities.ConfigReader;

public class UnitedAirlinesTest extends Base {

    @Test(testName = "Validate \"Main menu\" navigation items", priority = 1)
    public void validateMainMenuNavigationItems() {

        driver.get(ConfigReader.getProperty("unitedAirlinesURL"));

        for (int i = 0; i < unitedAirlinesHomePage.navigationMenu.size(); i++) {
            Assert.assertEquals(unitedAirlinesHomePage.navigationMenu.get(i).getText(), ExpectedTextsForUnitedApp.navigationItems[i]);
        }
    }

    @Test(testName = "Validate \"Book travel menu\" navigation items", priority = 2)
    public void validateBookTravelMenuNavigationItems() {

        driver.get(ConfigReader.getProperty("unitedAirlinesURL"));

        for (int i = 0; i < unitedAirlinesHomePage.bookTravelMenu.size(); i++) {
            Assert.assertEquals(unitedAirlinesHomePage.bookTravelMenu.get(i).getText(), ExpectedTextsForUnitedApp.bookTravelMenu[i]);
        }
    }

    @Test(testName = "Validate \"Round-trip\" and \"One-way\" radio buttons", priority = 3)
    public void validateRoundTripAndOneWayRadioButtons() {

        driver.get(ConfigReader.getProperty("unitedAirlinesURL"));

        Assert.assertTrue(unitedAirlinesHomePage.tripRadioButtons.get(0).isDisplayed());
        Assert.assertTrue(unitedAirlinesHomePage.tripRadioButtonsInput.get(0).isEnabled());
        Assert.assertTrue(unitedAirlinesHomePage.tripRadioButtonsInput.get(0).isSelected());

        Assert.assertTrue(unitedAirlinesHomePage.tripRadioButtons.get(1).isDisplayed());
        Assert.assertTrue(unitedAirlinesHomePage.tripRadioButtonsInput.get(1).isEnabled());
        Assert.assertFalse(unitedAirlinesHomePage.tripRadioButtonsInput.get(1).isSelected());

        unitedAirlinesHomePage.clickRadioButtons(ExpectedTextsForUnitedApp.onewayButton);
        Assert.assertFalse(unitedAirlinesHomePage.tripRadioButtonsInput.get(0).isSelected());
    }

    @Test(testName = "Validate \"Book with miles\" and \"Flexible dates\" checkboxes", priority = 4)
    public void validateBookWithMilesAndFlexibleDatesCheckboxes() {

        driver.get(ConfigReader.getProperty("unitedAirlinesURL"));

        for (int i = 0; i < unitedAirlinesHomePage.checkBoxes.size(); i++) {
            Assert.assertTrue(unitedAirlinesHomePage.checkBoxes.get(i).isDisplayed());
            Assert.assertTrue(unitedAirlinesHomePage.checkBoxes.get(i).isEnabled());
            Assert.assertFalse(unitedAirlinesHomePage.checkBoxesInput.get(i).isSelected());
        }

        unitedAirlinesHomePage.clickCheckBoxes();
        for (WebElement radioButton : unitedAirlinesHomePage.checkBoxesInput) {
            Assert.assertTrue(radioButton.isSelected());
        }

        unitedAirlinesHomePage.clickCheckBoxes();
        for (WebElement radioButton : unitedAirlinesHomePage.checkBoxesInput) {
            Assert.assertFalse(radioButton.isSelected());
        }
    }

    @Test(testName = "Validate One-way ticket search results \"from Chicago, IL, US (ORD)\" to \"Miami, FL, US (MIA)\"", priority = 5)
    public void validateOnewayTicketSearchResults() {

        driver.get(ConfigReader.getProperty("unitedAirlinesURL"));

        unitedAirlinesHomePage.login();
        Assert.assertEquals(unitedAirlinesDepartPage.destination.getText(), ExpectedTextsForUnitedApp.departText);
    }
}