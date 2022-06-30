import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

public class AddRemoveElementsTests extends BaseTest{


    @Test
    public void test(){
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        List <WebElement> deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        addButton.click();
        addButton.click();
        Assert.assertTrue(deleteButtons.isEmpty(), "Items not added.");
        deleteButtons=driver.findElements(By.xpath("//button[text()='Delete']"));
        deleteButtons.get(0).click();
        Assert.assertEquals(deleteButtons.size(), 2, "Items are not removed");
        deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        deleteButtons.get(0).click();
        Assert.assertEquals(deleteButtons.size(), 1, "Items are not removed");
        deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        Assert.assertEquals(deleteButtons.size(), 0, "Items are not removed");


    }
}
