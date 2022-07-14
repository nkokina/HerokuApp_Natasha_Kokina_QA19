import org.junit.Test;
import org.openqa.selenium.By;
import org.testng.Assert;


public class FramesTest extends BaseTest {

    @Test
    public void iFrameTest() {
        driver.get("http://the-internet.herokuapp.com/frames");
        driver.findElement(By.xpath("//a[contains( text(),'iFrame')]")).click();
        driver.switchTo().frame("mce_0_ifr");
        String frameText = driver.findElement(By.cssSelector("#tinymce p")).getText();
        String expectedResultText = "Your content goes here.";
        System.out.println(frameText);
        driver.switchTo().defaultContent();
        String hText = driver.findElement(By.cssSelector(".example h3")).getText();
        String expectedResultTitle = "An iFrame containing the TinyMCE WYSIWYG Editor";
        System.out.println(hText);
        Assert.assertEquals(frameText, expectedResultText, "Table text does not match");
        Assert.assertEquals(hText, expectedResultTitle,
                "Title text does not match");

    }
}
