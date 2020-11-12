package modalWindows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WorkWithAllert {
    WebDriver driver;

    public WorkWithAllert(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToAllertOk() {
        Alert alertOK = driver.switchTo().alert();
        Assert.assertEquals(alertOK.getText(), "I am a JS Alert");
        alertOK.accept();
    }

    public void switchToAllertOkOrCancel() {
        Alert alertOkOrCancel = driver.switchTo().alert();
        Assert.assertEquals(alertOkOrCancel.getText(), "I am a JS Confirm");
        alertOkOrCancel.accept();
    }

    public String switchToAlertWithEnterText(String str) {
        Alert alertWithEnterText = driver.switchTo().alert();
        driver.switchTo().alert().sendKeys(str);
        alertWithEnterText.accept();
        return str;
    }
}
