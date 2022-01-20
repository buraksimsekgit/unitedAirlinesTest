package pages.unitedAirlinesPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UnitedAirlinesHomePage {

    public UnitedAirlinesHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    private String departurePoint = "Chicago, IL, US (ORD)";
    private String destinationPoint = "Miami, FL, US (MIA)";
    private String date = "Jan 30";

    public String getDeparturePoint() {
        return departurePoint;
    }

    public String getDestinationPoint() {
        return destinationPoint;
    }

    public String getDate() {
        return date;
    }

    @FindBy(xpath = "//div[@role='tablist']/a/span")
    public List<WebElement> navigationMenu;

    @FindBy(xpath = "//ul[@class='app-components-BookTravel-bookTravel__travelNav--3RNBj']/li/h2")
    public List<WebElement> bookTravelMenu;

    @FindBy(xpath = "//span[@class='app-components-BookFlightForm-bookFlightForm__checkmark--2DHJD']")
    public List<WebElement> tripRadioButtons;

    @FindBy(xpath = "//fieldset[@name='flightType']/div/label/input")
    public List<WebElement> tripRadioButtonsInput;

    @FindBy(xpath = "//div[contains(@class, 'app-components-BookFlightForm-bookFlightForm__c')]/label")
    public List<WebElement> checkBoxes;

    @FindBy(xpath = "//div[contains(@class, 'app-components-BookFlightForm-bookFlightForm__c')]/input")
    public List<WebElement> checkBoxesInput;

    @FindBy(xpath = "//input[contains(@class, 'app-components-Q')]")
    public List<WebElement> departureAndDestinationInput;

    @FindBy(id = "DepartDate")
    public WebElement travelDate;

    @FindBy(css = "div#passengerSelector>button")
    public WebElement passengerAmountButton;

    @FindBy(xpath = "//button[text()='+']")
    public WebElement passengerPlusButton;

    @FindBy(id = "cabinType")
    public WebElement cabinType;

    @FindBy(xpath = "//li[@id='cabinType_item-2']")
    public WebElement businessOrFirst;

    @FindBy(css = "form#bookFlightForm>div:nth-of-type(5)>div>div>div>div>button>span")
    public WebElement findFlightsButton;

    public void login(){
        tripRadioButtons.get(1).click();
        departureAndDestinationInput.get(0).clear();
        departureAndDestinationInput.get(0).sendKeys(departurePoint);
        departureAndDestinationInput.get(1).clear();
        departureAndDestinationInput.get(1).sendKeys(destinationPoint);
        travelDate.clear();
        travelDate.click();
        travelDate.sendKeys(date);
        passengerAmountButton.click();
        passengerPlusButton.click();
        cabinType.click();
        businessOrFirst.click();
        findFlightsButton.click();
    }
}
