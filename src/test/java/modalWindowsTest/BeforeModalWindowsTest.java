package modalWindowsTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import modalWindows.MainPageModalWindows;
import modalWindows.WorkWithAllert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BeforeModalWindowsTest {
    public WebDriver driver;
    MainPageModalWindows mainPageModalWindows;
    WorkWithAllert alert;

    @BeforeMethod
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPageModalWindows = new MainPageModalWindows(driver);
        alert = new WorkWithAllert(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}

