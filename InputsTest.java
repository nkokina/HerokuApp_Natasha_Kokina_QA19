import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class InputsTest extends BaseTest {

    @Test
    public void selectInputsTest() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        inputs.get(0).sendKeys("5");
        String expectedInput = "5";
        String actualInput = inputs.get(0).getAttribute("value");
        Assert.assertEquals(expectedInput, actualInput, "Number entered is incorrect");
        inputs.get(0).sendKeys(Keys.ARROW_UP);
        String expectedInputUp = "6";
        String actualInputUp = inputs.get(0).getAttribute("value");
        Assert.assertEquals(expectedInputUp, actualInputUp, "The number has not increased");
        inputs.get(0).sendKeys("Natasha"); //11
        inputs.get(0).getAttribute("value");
        String expectedInputLetters = "6";
        String actualInputLetters = inputs.get(0).getAttribute("value");
        Assert.assertEquals(expectedInputLetters, actualInputLetters, "Letters entered");

    }
}


