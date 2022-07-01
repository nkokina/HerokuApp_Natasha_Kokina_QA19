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
        WebElement inputNumber = driver.findElement(By.tagName("input"));
        inputNumber.sendKeys("5");
        String expectedInput = "5";
        String actualInput = inputNumber.getAttribute("value");
        Assert.assertEquals(expectedInput, actualInput, "Number entered is incorrect");
        inputNumber.sendKeys(Keys.ARROW_UP);
        String expectedInputUp = "6";
        String actualInputUp = inputNumber.getAttribute("value");
        Assert.assertEquals(expectedInputUp, actualInputUp, "The number has not increased");
        inputNumber.sendKeys("Natasha");
        inputNumber.getAttribute("value");
        String expectedInputLetters = "6";
        String actualInputLetters = inputNumber.getAttribute("value");
        Assert.assertEquals(expectedInputLetters, actualInputLetters, "Letters entered");

    }
}


