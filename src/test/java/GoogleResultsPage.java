import com.codeborne.selenide.ElementsCollection;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GoogleResultsPage {
    @FindBy(how = How.CSS, using = "#ires li.g")
    public List<WebElement> results;
}