
import org.testng.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DropdownTest extends BaseTest {

    @Test
    public void selectDropdownTest() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdownElement);
        List<WebElement> options = select.getOptions();
        List<String> expectedOptions = new ArrayList<>();
        expectedOptions.add("Please select an option");
        expectedOptions.add("Option 1");
        expectedOptions.add("Option 2");
        List<String> actualOptions = options.stream().map(option -> option.getText()).toList();
        Assert.assertEquals(expectedOptions, actualOptions, "Not all dropdown elements");
        select.selectByValue("1");
        String expectedOptionOne = "Option 1";
        String actualOptionOne = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOptionOne, actualOptionOne, "Option 1 didn't get out");
        select.selectByValue("2");
        String expectedOptionTwo = "Option 2";
        String actualOptionTwo = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOptionTwo, actualOptionTwo, "Option 2 didn't get out");

    }
}
