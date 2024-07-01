package taras.workPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import taras.constants.AbstractPage;
import taras.constants.DriverProvider;

import java.util.List;

public class ProductPage extends AbstractPage {
    public ProductPage() {
        super();
    }

    @FindBy(css = "input[form='search_filters_form']")
    private WebElement searchFieldOfProduct;

    @FindBy(className = "products-list__image")
    public WebElement chooseAnyProduct;

    @FindBy(css = ".object-categories-add__picker")
    public WebElement pickerOfCategories;

    @FindBy(id = "input_cat_224")
    public WebElement categoryMenClothing;

    @FindBy(id = "input_cat_259")
    public WebElement categoryPlayStation;

    @FindBy(css = ".btn.cm-dialog-closer.btn-primary")
    public WebElement savePopup;

    @FindBy(css = ".dropdown-icon--tools")
    private WebElement gearwheelOfProduct;
    @FindBy(xpath = "//a[contains(text(), 'Предпросмотр')]")
    private WebElement previewButton;
    @FindBy(xpath = "//div[contains(@class, 'title-tab')]//span[text()='Наши преимущества']")
    private List<WebElement> elementOnProductPage_OurAdvantages;
    @FindBy(xpath = "//div[@class='ab-mb-horizontal__title-tab']/span[text()='Варианты оплаты']")
    private WebElement elementOnProductPage_PaymentMethods;
    @FindBy(css = "li[data-mb-id$='_4']")
    private WebElement elementOnProductPage_FindSimilar;
    @FindBy(className = "ab-mb-prod-categories-list")
    private List<WebElement> categoryListAtElement;
    @FindBy(css = ".ty-wysiwyg-content.ab-mb-style-presets")
    private List<WebElement> paymentMethodsAtElement;
    @FindBy(css = ".ty-menu__item.cm-menu-item-responsive.ty-menu-item__apparel")
    private WebElement apparelCategoryOnStorefront;
    @FindBy(css = ".ut2-subcategories > li")
    private WebElement menClothCategoryOnStorefront;
    @FindBy(xpath = "//div[contains(@class, 'ab__vertical_tabs')]")
    private WebElement verticalBlock;
    @FindBy(xpath = "//div[contains(@class, 'ab__horizontal_tabs')]")
    private WebElement horizontalBlock;
    @FindBy(css = "a[title='Samsung MV800']")
    private WebElement samsungOnHomePage;
    @FindBy(css = "a[title*='Nike']")
    private WebElement clothProduct;
    @FindBy(xpath = "//li[contains(@class, 'ab-mb-horizontal__item-tab')]")
    private List<WebElement> numberOfTabsOfBlock;



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



    public List<WebElement> getElementOnProductPage_OurAdvantages() {
        return elementOnProductPage_OurAdvantages;
    }

    public void clickElementOnProductPage_PaymentMethods() {
        elementOnProductPage_PaymentMethods.click();
    }

    public void clickElementOnProductPage_FindSimilar() {
        elementOnProductPage_FindSimilar.click();
    }

    public List<WebElement> getCategoryListAtElement() {
        return categoryListAtElement;
    }

    public List<WebElement> getPaymentMethodsAtElement() {
        return paymentMethodsAtElement;
    }

    public void navigateToMenClothCategoryOnStorefront() {
        menClothCategoryOnStorefront.click();
    }

    public WebElement getVerticalBlock() {
        return verticalBlock;
    }

    public WebElement getHorizontalBlock() {
        return horizontalBlock;
    }

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