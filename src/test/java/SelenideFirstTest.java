import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
public class SelenideFirstTest {

    @Test
    public void userCanLoginByUsername() {
        //open("/login");
        open("https://www.google.com/");
        WebElement a = $(By.name("q")).setValue("johny");
        a.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //$("#submit").click();
        //        $(".loading_progress").should(disappear); // Само подождёт, пока элемент исчезнет
        //        $("#username").shouldHave(text("Hello, Johny!")); // Само подождёт, пока у элемента появится нужный текст
    }

    @Test
    public  void googleTest(){
        GoogleSearchPage searchPage = new GoogleSearchPage();
        GoogleResultsPage resultsPage = searchPage.search("EPAM");
        resultsPage.results.forEach(WebElement::getText);
    }
}
