import org.openqa.selenium.WebElement;

public class Utils {

    public static void setCheckboxState(WebElement checkbox, boolean value) {
        boolean isSelected = checkbox.isSelected();

        if (value != isSelected)
            checkbox.click();
    }
}