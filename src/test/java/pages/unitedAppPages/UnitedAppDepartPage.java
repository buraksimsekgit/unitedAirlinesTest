package pages.unitedAppPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UnitedAppDepartPage {

    public UnitedAppDepartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = " //div[contains(@class, 'ripOriginDestinatio')]")
    public WebElement destination;
}