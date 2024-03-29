package taras.yanishevskyi.WorkPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import taras.yanishevskyi.AbstractPage;
import java.util.List;

public class ProductPage extends AbstractPage {
    public ProductPage(){
        super();
    }
    @FindBy(xpath = "(//div[@class='sidebar-field']//input[@type='text'])[1]")
    private WebElement searchFieldForProduct;
    @FindBy(className = "products-list__image")
    private WebElement productGoPro;
    @FindBy(css = ".cs-icon.icon-reorder")
    private WebElement listOfCategories;
    @FindBy(xpath = "//div[@class=\" btn-bar btn-toolbar nav__actions-bar dropleft\"]//div[@class=\"btn-group dropleft\"]")
    private WebElement gearwheelOfProduct;
    @FindBy(xpath = "//a[contains(text(), 'Предпросмотр')]")
    private WebElement previewButton;
    @FindBy(xpath = "//div[contains(@class, 'ab__motivation_block')]")
    private WebElement motivationBlockOnProductPage;
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
    @FindBy(xpath = "//a[contains(@href, 'gopro-hero3-black-edition-camera')]")
    private WebElement productGoProOnStorefront;
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
    @FindBy(xpath = "//li[@class=\"ty-menu__item cm-menu-item-responsive ty-menu-item__apparel\"]")
    private WebElement menuMenApparel;

    
    public void clickAndTypeToSearchField(){
        searchFieldForProduct.click();
        searchFieldForProduct.sendKeys("GoPro");
        searchFieldForProduct.sendKeys(Keys.ENTER);
    }
    
    public void chooseProductGoPro(){
        productGoPro.click();
    }
    
    public void clickAtListOfCategories(){
        listOfCategories.click();
    }
    
    public void clickGearWheelOfProduct(){
        gearwheelOfProduct.click();
    }
    
    public void clickPreviewButton(){
        previewButton.click();
    }
    public WebElement getMotivationBlockOnProductPage(){
        return motivationBlockOnProductPage;
    }
    
    public List<WebElement> getElementOnProductPage_OurAdvantages(){
        return elementOnProductPage_OurAdvantages;
    }
    
    public void clickElementOnProductPage_PaymentMethods(){
        elementOnProductPage_PaymentMethods.click();
    }
    
    public void clickElementOnProductPage_FindSimilar(){
        elementOnProductPage_FindSimilar.click();
    }
    
    public List<WebElement> getCategoryListAtElement(){
        return categoryListAtElement;
    }
    public List<WebElement> getPaymentMethodsAtElement(){
        return paymentMethodsAtElement;
    }
    
    public void navigateToApparelCategoryOnStorefront(){
        apparelCategoryOnStorefront.click();
    }
    public void navigateToMenClothCategoryOnStorefront(){
        menClothCategoryOnStorefront.click();
    }
    
    public void chooseProductGoProOnStorefront(){
        productGoProOnStorefront.click();
    }
    
    public WebElement getVerticalBlock(){
        return verticalBlock;
    }
    
    public WebElement getHorizontalBlock(){
        return horizontalBlock;
    }
    
    public void chooseProductOnHomepage(){
        samsungOnHomePage.click();
    }
    public void chooseClothProduct(){
        clothProduct.click();
    }

    public List<WebElement> getNumberOfTabsOfBlock(){
        return numberOfTabsOfBlock;
    }

    public WebElement getMenuMenApparel(){
        return menuMenApparel;
    }
}