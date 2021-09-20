import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class FirstTest extends AbstractTest {

    public static final  String pageURL = "https://www.instagram.com";
    public static final String login = "interpressspb";
    public static final String password = "t133ne78";
    public static final String email = "penumbraspbgmail.com@mail.ru";
    public static final By xpathLogin = By.xpath("//input[@aria-label='Phone number, username or email address']");
    public static final By xpathPassword = By.xpath("//input[@aria-label='Password']");
    public static final By getXpathButton = By.xpath("//button[@type='submit']");
    public static final By xpathButtonNotNow = By.xpath("//button[@class='sqdOP yWX7d    y3zKF     ']");
    public static final By xpathButtonNotNow2 = By.xpath("//button[@class='aOOlW   HoLwm ']");

    @Test
    public void someTest() {
        System.out.println("TEST RUNNING!!!!");
        driver.navigate().to(pageURL);
        waitForJSComplete();
        WebElement log = driver.findElement(xpathLogin);
        log.sendKeys(login);
        WebElement pas = driver.findElement(xpathPassword);
        pas.sendKeys(password);
        WebElement button = driver.findElement(getXpathButton);
        button.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement buttonNotNow = driver.findElement(xpathButtonNotNow);
        buttonNotNow.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement buttonNotNow2 = driver.findElement(xpathButtonNotNow2);
        buttonNotNow2.click();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
