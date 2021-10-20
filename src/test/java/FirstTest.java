import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FirstTest extends AbstractTest {

    public static final String pageURL = "https://www.instagram.com";
    public static final String login = "interpressspb";
    public static final String password = "t133ne78";
    public static final String email = "penumbraspbgmail.com@mail.ru";
    public static final By xpathLogin = By.xpath("//input[@aria-label='Phone number, username or email address']");
    public static final By xpathPassword = By.xpath("//input[@aria-label='Password']");
    public static final By getXpathButton = By.xpath("//button[@type='submit']");
    public static final By getXpathButton2 = By.xpath(
        "//div[@class='            qF0y9          Igw0E     IwRSH      eGOV_         _4EzTm                                                                                                              ']");
    public static final By xpathButtonNotNow = By.xpath("//button[@class='sqdOP yWX7d    y3zKF     ']");
    public static final By xpathButtonNotNow2 = By.xpath("//button[@class='aOOlW   HoLwm ']");
    public static final By  saveButton = By.xpath("//button[@class='sqdOP  L3NKy   y3zKF     ']");

    List<WebElement> likes;
    public static final By likesXpath = By.xpath("//button[@class='wpO6b  ']");
    @Test
    public void someTest() {
        System.out.println("TEST RUNNING!!!!");
        driver.navigate().to(pageURL);

        WebElement log = getWebElementByLocator(xpathLogin);
        log.sendKeys(login);
        WebElement pas = getWebElementByLocator(xpathPassword);
        pas.sendKeys(password);

        WebElement button = getWebElementByLocator(getXpathButton);
        button.click();

        WebElement buttonSave = getWebElementByLocator(saveButton);
        buttonSave.click();

        WebElement buttonNotNow2 = getWebElementByLocator(xpathButtonNotNow2);
        buttonNotNow2.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("<<LIKES>>!!!");
        likes = driver.findElements(likesXpath);
        System.out.println(likes.size());
        AtomicInteger counter = new AtomicInteger(0);
        WebElement myFirstLike = likes.stream().filter(l->counter.incrementAndGet() == 2).findFirst().orElseThrow();
        myFirstLike.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
