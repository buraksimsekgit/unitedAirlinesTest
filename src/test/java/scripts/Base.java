package scripts;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.unitedAppPages.UnitedAppDepartPage;
import pages.unitedAppPages.UnitedAppHomePage;
import utilities.Driver;

public class Base {

    WebDriver driver;
    Faker faker;
    UnitedAppHomePage unitedAppHomePage;
    UnitedAppDepartPage unitedAppDepartPage;

    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
        faker = new Faker();
        faker = new Faker();
        unitedAppHomePage = new UnitedAppHomePage(driver);
        unitedAppDepartPage = new UnitedAppDepartPage(driver);
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }
}