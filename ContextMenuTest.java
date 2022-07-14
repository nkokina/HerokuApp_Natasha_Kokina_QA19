import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class ContextMenuTest extends BaseTest {

    @Test
    public void ContextMenuTest() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        WebElement hotShop = driver.findElement(By.id("hot-spot"));
        actions.contextClick(hotShop).perform();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        alert.accept();
        driver.switchTo().defaultContent();
    }
}