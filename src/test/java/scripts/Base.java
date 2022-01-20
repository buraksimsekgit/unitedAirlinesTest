package scripts;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.unitedAirlinesPages.UnitedAirlinesDepartPage;
import pages.unitedAirlinesPages.UnitedAirlinesHomePage;
import utilities.Driver;

public class Base {

    WebDriver driver;
    Faker faker;
    UnitedAirlinesHomePage unitedAirlinesHomePage;
    UnitedAirlinesDepartPage unitedAirlinesDepartPage;

    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
        faker = new Faker();
        faker = new Faker();
        unitedAirlinesHomePage = new UnitedAirlinesHomePage(driver);
        unitedAirlinesDepartPage = new UnitedAirlinesDepartPage(driver);
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }
}