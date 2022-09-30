import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import taras.yanishevskyi.DriverProvider;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import static taras.yanishevskyi.Constants.BASIC_URL;

public class TestRunner {

    @BeforeMethod
    public void beforeMethod() {
        DriverProvider.getDriver().get(BASIC_URL);
        //Увеличиваем размер окна браузера
        DriverProvider.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(4)); //Общая задержка
        DriverProvider.getDriver().manage().window().maximize();    //Размер браузера на весь экран
        DriverProvider.getDriver().findElement(By.cssSelector(".btn.btn-primary")).click();
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot)DriverProvider.getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) +  ".jpg"));
        }
        //DriverProvider.getDriver().quit();
        //DriverProvider.destroyDriver();
    }
}
