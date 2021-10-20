import org.testng.annotations.Test;

public class YashaTest extends AbstractTest {

    private final String PAGE_URL = "https://yandex.ru/";

    @Test
    public void exampleTest() {

        System.out.println("TEST RUNNING!!!!");
        driver.navigate().to(PAGE_URL);

    }
}
