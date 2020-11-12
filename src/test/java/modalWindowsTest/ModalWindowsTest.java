package modalWindowsTest;

import modalWindows.GenerateRandomString;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class ModalWindowsTest extends BeforeModalWindowsTest {
    private static final Logger log = Logger.getLogger(String.valueOf(ModalWindowsTest.class));
    GenerateRandomString generator = new GenerateRandomString();

    @Test
    public void testClickForJSAlert() {
        mainPageModalWindows.firstButtonClick();
        log.info("The allert window appeared");
        alert.switchToAllertOk();
        log.info("The allert window closed");
        Assert.assertEquals(mainPageModalWindows.getResultTest(), "You successfuly clicked an alert");
    }

    @Test
    public void testIAmAJSConfirm() {
        mainPageModalWindows.secondButtonClick();
        log.info("The allert window appeared");
        alert.switchToAllertOkOrCancel();
        log.info("The allert window closed");
        Assert.assertEquals(mainPageModalWindows.getResultTest(), "You clicked: Ok");
    }

    @Test
    public void testClickForJSPrompt() {
        mainPageModalWindows.thirdButtonClick();
        String expectedMessage = generator.randomString();
        log.info(expectedMessage);
        alert.switchToAlertWithEnterText(expectedMessage);
        log.info("The allert window closed");
        String actualMessage = mainPageModalWindows.getResultTest();
        log.info(actualMessage);
        Assert.assertEquals(actualMessage, String.format("You entered: %s", expectedMessage));

    }
}



