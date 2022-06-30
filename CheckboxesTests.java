import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

public class CheckboxesTests extends BaseTest {

    @Test
    public void test() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxs = driver.findElements(By.cssSelector("[type='checkbox']"));
        Assert.assertFalse(checkboxs.get(0).isSelected(), "Checkbox 1 is checked");
        Assert.assertTrue(checkboxs.get(1).isSelected(), "Checkbox 2 not clicked");
        checkboxs.get(0).click();
        checkboxs.get(1).click();
        Assert.assertTrue(checkboxs.get(0).isSelected(), "Checkbox 1 not clicked");
        Assert.assertFalse(checkboxs.get(1).isSelected(), "Checkbox 2 is checked");


    }
}
