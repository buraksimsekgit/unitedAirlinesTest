package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import texts.ExpectedTextsForUnitedApp;
import utilities.ConfigReader;
import utilities.Waiter;

public class UnitedAirlinesTest extends Base {


    @Test(testName = "Validate \"Main menu\" navigation items", priority = 1)
    public void validateMainMenu() {

        driver.get(ConfigReader.getProperty("unitedAppURL"));

        for (int i = 0; i < unitedAppHomePage.navigationMenu.size(); i++) {
            Assert.assertEquals(unitedAppHomePage.navigationMenu.get(i).getText(), ExpectedTextsForUnitedApp.navigationItems[i]);
        }
    }

    @Test(testName = "Validate \"Book travel menu\" navigation items", priority = 2)
    public void validateBookTravelMenu() {

        driver.get(ConfigReader.getProperty("unitedAppURL"));

        for (int i = 0; i < unitedAppHomePage.bookTravelMenu.size(); i++) {
            Assert.assertEquals(unitedAppHomePage.bookTravelMenu.get(i).getText(), ExpectedTextsForUnitedApp.bookTravelMenu[i]);
        }
    }

    @Test(testName = "Validate \"Round-trip\" and \"One-way\" radio buttons", priority = 3)
    public void validateRoundTripAndOneWayRadioButtons() {

        driver.get(ConfigReader.getProperty("unitedAppURL"));

        Waiter.pause(5);
        Assert.assertTrue(unitedAppHomePage.tripRadioButtons.get(0).isDisplayed());
        Assert.assertTrue(unitedAppHomePage.tripRadioButtonsInput.get(0).isEnabled());
        Assert.assertTrue(unitedAppHomePage.tripRadioButtonsInput.get(0).isSelected());

        Assert.assertTrue(unitedAppHomePage.tripRadioButtons.get(1).isDisplayed());
        Assert.assertTrue(unitedAppHomePage.tripRadioButtonsInput.get(1).isEnabled());
        Assert.assertFalse(unitedAppHomePage.tripRadioButtonsInput.get(1).isSelected());

        unitedAppHomePage.tripRadioButtons.get(1).click();
        Assert.assertFalse(unitedAppHomePage.tripRadioButtonsInput.get(0).isSelected());
    }

    @Test(testName = "Validate \"Book with miles\" and \"Flexible dates\" checkboxes", priority = 4)
    public void validateBookWithMilesAndFlexibleDatesCheckboxes() {

        driver.get(ConfigReader.getProperty("unitedAppURL"));

        int counter = 0;
        for (int i = 0; i < unitedAppHomePage.checkBoxes.size(); i++) {
            Assert.assertTrue(unitedAppHomePage.checkBoxes.get(i).isDisplayed());
            Assert.assertTrue(unitedAppHomePage.checkBoxes.get(i).isEnabled());
            Assert.assertFalse(unitedAppHomePage.checkBoxesInput.get(i).isSelected());
            unitedAppHomePage.checkBoxes.get(counter++).click();
        }
        counter = 0;
        for (WebElement radioButton : unitedAppHomePage.checkBoxesInput) {
            Assert.assertTrue(radioButton.isSelected());
            unitedAppHomePage.checkBoxes.get(counter++).click();
            Assert.assertFalse(radioButton.isSelected());
        }
    }

    @Test(testName = "Validate One-way ticket search results \"from Chicago, IL, US (ORD) to Miami, FL, US (MIA)", priority = 5)
    public void validateOnewayTicketSearchResults() {

        driver.get(ConfigReader.getProperty("unitedAppURL"));

        unitedAppHomePage.login();
        Assert.assertEquals(unitedAppDepartPage.destination.getText(), ExpectedTextsForUnitedApp.departText);

    }
}
