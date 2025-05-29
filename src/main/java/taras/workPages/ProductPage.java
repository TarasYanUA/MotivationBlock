package taras.workPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import taras.constants.AbstractPage;

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
        searchInput.click();
        searchInput.sendKeys(value);
        (new WebDriverWait((getDriver()), Duration.ofSeconds(10)))
                .until(ExpectedConditions.elementToBeClickable(By.linkText(value)))
                .click();
    }

    public Storefront navigateToStorefront_ProductPage() {
        gearwheelOfProduct.click();
        previewButton.click();
        ArrayList<String> tabs = new ArrayList<> (getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));

        WebElement confirmCookies = getDriver().findElement(By.cssSelector(".cm-btn-success"));
        if (confirmCookies.isEnabled())
            confirmCookies.click();

        return new Storefront();
    }
}