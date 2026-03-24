package taras.workPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import taras.constants.AbstractPage;
import taras.constants.DriverProvider;
import java.time.Duration;
import java.util.ArrayList;

import static taras.constants.DriverProvider.getDriver;

public class ProductPage extends AbstractPage {
    public ProductPage() {
        super();
    }

    @FindBy(css = "input[form='search_filters_form']")
    WebElement searchInput;

    @FindBy(css = ".object-categories-add__picker")
    public WebElement pickerOfCategories;

    @FindBy(id = "input_cat_224")
    public WebElement categoryMenClothing;

    @FindBy(id = "input_cat_259")
    public WebElement categoryPlayStation;

    @FindBy(css = ".ui-dialog-content .btn.cm-dialog-closer.btn-primary")
    public WebElement savePopup;

    @FindBy(css = ".dropdown-icon--tools")
    WebElement gearwheelOfProduct;

    @FindBy(xpath = "//a[contains(text(), 'Предпросмотр')]")
    WebElement previewButton;


    public void searchProduct(String value) {
        AdminPanel.closeAllNotifications();
        searchInput.click();
        searchInput.sendKeys(value);
        (new WebDriverWait((getDriver()), Duration.ofSeconds(10)))
                .until(ExpectedConditions.elementToBeClickable(By.partialLinkText(value)))
                .click();
    }

    public Storefront navigateToStorefront_ProductPage() {
        gearwheelOfProduct.click();
        previewButton.click();
        ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));

        WebElement confirmCookies = getDriver().findElement(By.cssSelector(".cm-btn-success"));
        if (confirmCookies.isEnabled())
            confirmCookies.click();

        return new Storefront();
    }

    public void addCategoriesToProduct() {
        AdminPanel adminPanel = new AdminPanel();

        if (DriverProvider.getDriver().findElements(By.cssSelector(".object-picker__simple--categories .select2-selection__choice")).size() < 2) {
            pickerOfCategories.click();
            (new WebDriverWait((driver), Duration.ofSeconds(4)))
                    .until(ExpectedConditions.presenceOfElementLocated(By.className("ui-dialog-title")));
            if (!DriverProvider.getDriver().findElements(By.cssSelector
                    ("span[id*='off_comp'][class='hand cm-combination-cat cm-uncheck hidden']")).isEmpty()) {
                waitForElementToBeClickableAndClick(DriverProvider.getDriver().findElement(By.xpath
                        ("//span[text()='Магазин: CS-Cart']/..//span[contains(@class, 'icon-caret-right')]")));
                waitForElementToBeClickableAndClick(DriverProvider.getDriver().findElement(By.xpath
                        ("//tr[contains(@id, 'cat_223')]/..//span[contains(@class, 'icon-caret-right')]")));
                waitForElementToBeClickableAndClick(categoryMenClothing);

                waitForElementToBeClickableAndClick(DriverProvider.getDriver().findElement(By.xpath
                        ("//tr[contains(@id, 'cat_166')]/..//span[contains(@class, 'icon-caret-right')]")));
                waitForElementToBeClickableAndClick(DriverProvider.getDriver().findElement(By.xpath
                        ("//tr[contains(@id, 'cat_264')]/..//span[contains(@class, 'icon-caret-right')]")));
                waitForElementToBeClickableAndClick(DriverProvider.getDriver().findElement(By.xpath
                        ("//tr[contains(@id, 'cat_245')]/..//span[contains(@class, 'icon-caret-right')]")));
                waitForElementToBeClickableAndClick(categoryPlayStation);
            } else {
                categoryMenClothing.click();
                categoryPlayStation.click();
            }
            savePopup.click();
            (new WebDriverWait((driver), Duration.ofSeconds(4)))
                    .until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-dialog-title")));
            adminPanel.saveButtonOnTopRight.click();
        }
    }

    public void waitForElementToBeClickableAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}