package taras.yanishevskyi.WorkPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import taras.yanishevskyi.AbstractPage;
import taras.yanishevskyi.DriverProvider;

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
    @FindBy(xpath = "//a[@href[substring(.,string-length(.) - string-length('preview') + 1) = 'preview']]")
    private WebElement previewButton;
    @FindBy(xpath = "//div[contains(@class, 'ab__motivation_block')]")
    private WebElement motivationBlockOnProductPage;
    @FindBy(xpath = "//div[@class='ab__mb_item'][1]")
    private WebElement elementOnProductPage_OurAdvantages;
    @FindBy(xpath = "//div[@class='ab__mb_item'][2]")
    private WebElement elementOnProductPage_PaymentMethods;
    @FindBy(xpath = "//div[@class='ab__mb_item'][4]")
    private WebElement elementOnProductPage_FindSimilar;
    @FindBy(className = "ab-mb-prod-categories-list")
    private WebElement categoryListAtElement;
    @FindBy(xpath = "//div[@class='ty-dropdown-box__title ']")
    private WebElement mainMenuOnStorefront;
    @FindBy(css = ".ty-menu__item.cm-menu-item-responsive.first-lvl.ty-menu-item__apparel")
    private WebElement apparelCategoryOnStorefront;
    @FindBy(xpath = "//a[contains(@href, 'gopro-hero3-black-edition-camera')]")
    private WebElement productGoProOnStorefront;
    @FindBy(xpath = "//div[contains(@class, 'ab__vertical_tabs')]")
    private WebElement verticalBlock;
    @FindBy(xpath = "//div[contains(@class, 'ab__horizontal_tabs')]")
    private WebElement horizontalBlock;
    @FindBy(className = "ut2-gl__image")
    private WebElement anyProductOnStorefront;



    
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
    
    public WebElement hoverMotivationBlockOnProductPage(){
        return motivationBlockOnProductPage;
    }
    
    public WebElement getElementOnProductPage_OurAdvantages(){
        return elementOnProductPage_OurAdvantages;
    }
    
    public void clickElementOnProductPage_PaymentMethods(){
        elementOnProductPage_PaymentMethods.click();
    }
    
    public void clickElementOnProductPage_FindSimilar(){
        elementOnProductPage_FindSimilar.click();
    }
    
    public WebElement getCategoryListAtElement(){
        return categoryListAtElement;
    }
    
    public void navigateToApparelCategoryOnStorefront(){
        apparelCategoryOnStorefront.click();
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
    
    public void chooseAnyProductOnStorefront(){
        anyProductOnStorefront.click();
    }
    
    public void clickMainMenuOnStorefront(){
        mainMenuOnStorefront.click();
    }
}