package pages.unitedAirlinesPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UnitedAirlinesDepartPage {

    public UnitedAirlinesDepartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = " //div[contains(@class, 'ripOriginDestinatio')]")
    public WebElement destination;
}