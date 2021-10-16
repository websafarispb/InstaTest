import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractTest {

    WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupTest() {
        driver = new ChromeDriver();
        //driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS)
        //driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS)
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //PageFactory.initElements(driver, bean);
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void waitForJSComplete() {
        long startTime = System.currentTimeMillis();
        try {
            new WebDriverWait(driver, 10)
                .until(jsReturnsValue("complete"));
        } catch (TimeoutException exception) {
            long endTime = System.currentTimeMillis();
            System.out.println("Page can't download completely time - " + (endTime - startTime));
        }
    }

    public WebElement getWebElementByLocator(By locator) {
        long startTime = System.currentTimeMillis();
        try {
            new WebDriverWait(driver, 10)
                .until(elementToBeClickable(locator));
        } catch (TimeoutException exception) {
            long endTime = System.currentTimeMillis();
            System.out.println("Element is not visible - " + (endTime - startTime));
        }

        return driver.findElement(locator);
    }
}
