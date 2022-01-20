package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertHandler {

    private static Alert alert;

    public static void acceptAlert(WebDriver driver){
        alert = driver.switchTo().alert();
        alert.accept();
    }

    public static void dismissAlert(WebDriver driver){
        alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public static void sendKeysToAlert(WebDriver driver, String keys){
        alert = driver.switchTo().alert();
        alert.sendKeys(keys);
    }

    public static String getAlertsText(WebDriver driver){
        alert = driver.switchTo().alert();
        return alert.getText();
    }
}