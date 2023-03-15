import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;
import taras.yanishevskyi.DriverProvider;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import static taras.yanishevskyi.Constants.BASIC_URL;

/*
Модуль "Блок мотивации" v2.12.2 + тема Юни2(UltRu) v4.16.1b. Можно установить весь пакет темы Юни2.
Запустить тесты можно:
 1) Через файл testNG.xml
 2) Через Surefire отчёт: перейти в "Терминал" и ввести "mvn clean test". После этого в папке "target -> surefire reports"
 открыть файл "index.html" с помощью браузера (правая кнопка мыши -> Open in -> Browser).

Важно следить за версией файла chromedriver.exe который расположен в папке test -> resources. Версия этого файла должна совпадать с версией браузера Хром на ПК.
Если при запуске testNG.xml тесты падают на этапе открытия браузера, то значит версия файла chromedriver.exe устарела.
*/

public class TestRunner {

    @BeforeMethod
    public void beforeMethod() {
        DriverProvider.getDriver().get(BASIC_URL);
        //Увеличиваем размер окна браузера
        DriverProvider.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(4)); //Общая задержка
        DriverProvider.getDriver().manage().window().maximize();    //Размер браузера на весь экран
        DriverProvider.getDriver().findElement(By.cssSelector(".btn.btn-primary")).click();
        DriverProvider.getDriver().findElement(By.cssSelector(".cm-notification-close")).click();
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot)DriverProvider.getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) +  ".jpg"));
        }
        DriverProvider.getDriver().quit();
        DriverProvider.destroyDriver();
    }
}