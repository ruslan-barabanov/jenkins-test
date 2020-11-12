package modalWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPageModalWindows {

    WebDriver driver;

    public MainPageModalWindows(WebDriver driver) {
        this.driver = driver;
    }

    public String getResultTest() {
        String str = driver.findElement(By.id("result")).getText();
        return str;
    }

    public void firstButtonClick() {
        driver.findElement(By.xpath("//*[@id='content']/div/ul/li[1]/button")).click();

    }

    public void secondButtonClick() {
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
    }

    public void thirdButtonClick() {
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
    }

}
