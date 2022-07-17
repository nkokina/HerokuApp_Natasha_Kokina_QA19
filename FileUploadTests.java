import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FileUploadTests extends BaseTest {
    @Test
    public void fileUploadTest() {
        driver.get("http://the-internet.herokuapp.com/upload");
        driver.findElement(By.cssSelector("input[type=file]")).sendKeys(System.getProperty("user.dir") + "/pictures/monako.orig.jpg");
        String expectedResult = "monako.orig.jpg";
        driver.findElement(By.id("file-submit")).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".panel.text-center")));
        WebElement actualText = driver.findElement(By.cssSelector(".panel.text-center"));
        String actualResult = actualText.getText();
        Assert.assertEquals(expectedResult, actualResult, "The labels don't match");

    }
}
