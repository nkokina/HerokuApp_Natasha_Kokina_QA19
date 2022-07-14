import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class DynamicControlsTests extends BaseTest {

    @Test
    public void dynamicControlsTest() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.cssSelector("input[type='checkbox']")).click();
        driver.findElement(By.cssSelector("button[type='button']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("message"), "It's gone!"));
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int checkboxOfElements = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
        Assert.assertEquals(checkboxOfElements, 0, "The element is present on the page");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement inputDisable = driver.findElement(By.cssSelector("input[type='text']"));
        Assert.assertEquals(inputDisable.isEnabled(), false, "Input no disabled");
        driver.findElement(By.cssSelector("button[onclick='swapInput()']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("message"), "It's enabled!"));
        Assert.assertEquals(inputDisable.isEnabled(), true, "Input disabled");
    }
}
