import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.PressEnter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GoogleSearchPage {
    @FindBy(how = How.NAME, using = "q")
    private WebElement searchBox;

    public GoogleSearchPage() {
        page(this);
    }

    public GoogleResultsPage search(String query) {
        open("https://www.google.com/");
        //searchBox.setValue(query).pressEnter();
        searchBox.sendKeys(query);
        searchBox.sendKeys(Keys.RETURN);
        return page(GoogleResultsPage.class);
    }
}