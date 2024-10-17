import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;
import taras.constants.DriverProvider;
import taras.workPages.AdminPanel;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import static taras.constants.Constants.BASIC_URL;

public class TestRunner {

    @BeforeMethod
    public void beforeMethod() {
        DriverProvider.getDriver().get(BASIC_URL);
        DriverProvider.getDriver().manage().window().maximize();    //Размер браузера на весь экран
        DriverProvider.getDriver().findElement(By.cssSelector(".btn.btn-primary")).click();
        //Настраиваем макет для каждого тест-кейса
        AdminPanel adminPanel = new AdminPanel();
        adminPanel.navigateToSection_WebsiteLayouts();
        adminPanel.setLayout_Lightv2_AsDefault();
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot)DriverProvider.getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("myError_Screenshots\\" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) + ".jpg"));
        }
        DriverProvider.getDriver().quit();
        DriverProvider.destroyDriver();
    }
    public void takeScreenShot(String screenshotName) throws IOException {
        File scrFile = ((TakesScreenshot) DriverProvider.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("mySuccess_Screenshots\\" + screenshotName + ".jpg"));
    }
}