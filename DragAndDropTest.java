import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class DragAndDropTest extends BaseTest {

    @Test
    public void dragAndDropTest() {

        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
        WebElement aElement = driver.findElement(By.id("column-a"));
        WebElement bElement = driver.findElement(By.id("column-b"));
        Actions act = new Actions(driver);
        act.clickAndHold(bElement).moveToElement(aElement).release(aElement).build().perform();

        WebElement result = driver.findElement(By.xpath("//div[@id='column-a']//ancestor::header[text()='A']"));
        Assert.assertFalse("Element has not moved", result.isDisplayed());
    }
}
