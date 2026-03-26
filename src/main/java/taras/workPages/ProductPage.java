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
        CategoryPage categoryPage = new CategoryPage();

        if (DriverProvider.getDriver().findElements(By.cssSelector(".object-picker__simple--categories .select2-selection__choice")).size() < 2) {
            pickerOfCategories.click();
            Utils.waitForPopupPresence();
            if (!categoryPage.collapsedCategoryList.isEmpty()) {
                Utils.waitForElementToBeClickableAndClick(categoryPage.expandCategoryList);
                Utils.waitForElementToBeClickableAndClick(categoryPage.popup_category_apparel);
                Utils.waitForElementToBeClickableAndClick(categoryPage.categoryMenClothing);

                Utils.waitForElementToBeClickableAndClick(categoryPage.popup_category_multimedia);
                Utils.waitForElementToBeClickableAndClick(categoryPage.popup_category_videoGames);
                Utils.waitForElementToBeClickableAndClick(categoryPage.categoryPlayStation);
            } else {
                categoryPage.categoryMenClothing.click();
                categoryPage.categoryPlayStation.click();
            }
            savePopup.click();
            (new WebDriverWait((driver), Duration.ofSeconds(4)))
                    .until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-dialog-title")));
            adminPanel.saveButtonOnTopRight.click();
        }
    }
}