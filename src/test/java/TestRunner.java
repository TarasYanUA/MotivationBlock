import io.qameta.allure.Attachment;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;
import taras.yanishevskyi.DriverProvider;
import java.time.Duration;
import static taras.yanishevskyi.Constants.BASIC_URL;

public class TestRunner {

    @BeforeMethod
    public void beforeMethod(){
        DriverProvider.getDriver().get(BASIC_URL);

        //Увеличиваю размер окна браузера
        DriverProvider.getDriver().manage().window().maximize();    //Размер браузера на весь экран
        DriverProvider.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(4)); //Общая задержка
    }
    @AfterMethod
    public void afterMethod(ITestResult result){
        if(! result.isSuccess()){
            //make screenshot
            saveScreenshot();
        }

        DriverProvider.getDriver().quit();
        DriverProvider.destroyDriver();
    }

    @Attachment (value = "Page screen", type = "image/png")
    public byte [] saveScreenshot (){
        return ((TakesScreenshot) DriverProvider.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
