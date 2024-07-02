package taras.workPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import taras.constants.AbstractPage;
import taras.constants.DriverProvider;

import java.time.Duration;
import java.util.List;

public class ProductPage extends AbstractPage {
    public ProductPage() {
        super();
    }

    @FindBy(css = "input[form='search_filters_form']")
    WebElement searchFieldOfProduct;

    @FindBy(className = "products-list__image")
    WebElement chooseAnyProduct;

    @FindBy(css = ".object-categories-add__picker")
    public WebElement pickerOfCategories;

    @FindBy(id = "input_cat_224")
    public WebElement categoryMenClothing;

    @FindBy(id = "input_cat_259")
    public WebElement categoryPlayStation;

    @FindBy(css = ".btn.cm-dialog-closer.btn-primary")
    public WebElement savePopup;

    @FindBy(css = ".dropdown-icon--tools")
    WebElement gearwheelOfProduct;
    @FindBy(xpath = "//a[contains(text(), 'Предпросмотр')]")
    WebElement previewButton;


    @FindBy(css = "a[title='Samsung MV800']")
    WebElement samsungOnHomePage;
    @FindBy(css = "a[title*='Nike']")
    WebElement clothProduct;
    @FindBy(xpath = "//li[contains(@class, 'ab-mb-horizontal__item-tab')]")
    List<WebElement> numberOfTabsOfBlock;



    public void clickAndType_SearchFieldOfProduct(String value) {
        searchFieldOfProduct.click();
        searchFieldOfProduct.sendKeys(value);
        searchFieldOfProduct.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void chooseAnyProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(chooseAnyProduct));
        chooseAnyProduct.click();
    }

    public Storefront navigateToStorefront_ProductPage() {
        gearwheelOfProduct.click();
        previewButton.click();
        DriverProvider.getDriver().switchTo().window(String.valueOf(1));
        if (DriverProvider.getDriver().findElement(By.cssSelector(".cm-btn-success")).isEnabled()) {
            DriverProvider.getDriver().findElement(By.cssSelector(".cm-btn-success")).click();
        }
        return new Storefront();
    }


    /////////////////////////////////////


    public void chooseProductOnHomepage() {
        samsungOnHomePage.click();
    }

    public void chooseClothProduct() {
        clothProduct.click();
    }

    public List<WebElement> getNumberOfTabsOfBlock() {
        return numberOfTabsOfBlock;
    }
}