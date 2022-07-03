import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class TyposTest extends BaseTest {

    @Test
    public void spellCheckTextTest() {
        driver.get("http://the-internet.herokuapp.com/typos");
        List<WebElement> typos = driver.findElements(By.tagName("p"));
        String expectedResultBottomText = "Sometimes you'll see a typo, other times you won't.";
        String actualResultBottomText = typos.get(1).getText();
        Assert.assertEquals(expectedResultBottomText, actualResultBottomText,
                "There is a mistake in the bottom text");
        String expectedResultTopText = "This example demonstrates a typo being introduced." +
                " It does it randomly on each page load.";
        String actualResultTopText = typos.get(0).getText();
        Assert.assertEquals(expectedResultTopText, actualResultTopText, "There is a mistake in the top text");

    }
}

