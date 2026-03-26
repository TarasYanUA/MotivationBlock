package taras.workPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import taras.constants.DriverProvider;

import java.time.Duration;

public class Utils {

    public static void setCheckboxState(WebElement checkbox, boolean value) {
        boolean isSelected = checkbox.isSelected();

        if (value != isSelected)
            checkbox.click();
    }

    public static void waitForElementToBeClickableAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverProvider.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        makePause(1000);
    }

    public static void makePause(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException ignored) {}
    }

    public static void waitForPopupPresence() {
        (new WebDriverWait((DriverProvider.getDriver()), Duration.ofSeconds(4)))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("ui-dialog-title")));
    }
}