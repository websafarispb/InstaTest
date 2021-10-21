import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        WebDriver driver = (WebDriver) result.getAttribute("driver");
    }

    @Attachment(type = "image/png", fileExtension = ".png")
    private byte[] attachScreenShot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
