import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class FileDownloadTest {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("weddrive.chrome.driver", "C:/chromedriver/chromedriver.exe");
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/download");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void fileDownloadTest() throws InterruptedException {
        WebElement capture = driver.findElement(By.cssSelector("a[href='download/sample.pdf']"));
        capture.click();
        Thread.sleep(5000);

        File folder = new File(System.getProperty("user.dir"));
        File[] listOfFiles = folder.listFiles();
        boolean result = false;
        File fileDownload = null;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.matches("sample.pdf")) {
                    fileDownload = new File(fileName);
                    result = true;
                }
            }
        }
        Assert.assertTrue("Downloaded document is not found", result);
        fileDownload.deleteOnExit();
    }
}