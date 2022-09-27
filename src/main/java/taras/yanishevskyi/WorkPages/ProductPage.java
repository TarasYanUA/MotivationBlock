package taras.yanishevskyi.WorkPages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import taras.yanishevskyi.AbstractPage;

import javax.swing.*;

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



    @Step
    public void clickAndTypeToSearchField(){
        searchFieldForProduct.click();
        searchFieldForProduct.sendKeys("GoPro");
        searchFieldForProduct.sendKeys(Keys.ENTER);
    }
    @Step
    public void chooseProductGoPro(){
        productGoPro.click();
    }
    @Step
    public void clickAtListOfCategories(){
        listOfCategories.click();
    }
    @Step
    public void clickGearWheelOfProduct(){
        gearwheelOfProduct.click();
    }
    @Step
    public void clickPreviewButton(){
        previewButton.click();
    }
    @Step
    public WebElement hoverMotivationBlockOnProductPage(){
        return motivationBlockOnProductPage;
    }
    @Step
    public WebElement getElementOnProductPage_OurAdvantages(){
        return elementOnProductPage_OurAdvantages;
    }
    @Step
    public void clickElementOnProductPage_PaymentMethods(){
        elementOnProductPage_PaymentMethods.click();
    }
    @Step
    public void clickElementOnProductPage_FindSimilar(){
        elementOnProductPage_FindSimilar.click();
    }
    @Step
    public WebElement getCategoryListAtElement(){
        return categoryListAtElement;
    }
    @Step
    public void navigateToApparelCategoryOnStorefront(){
        apparelCategoryOnStorefront.click();
    }
    @Step
    public void chooseProductGoProOnStorefront(){
        productGoProOnStorefront.click();
    }
    @Step
    public WebElement getVerticalBlock(){
        return verticalBlock;
    }
    @Step
    public WebElement getHorizontalBlock(){
        return horizontalBlock;
    }
    @Step
    public void chooseAnyProductOnStorefront(){
        anyProductOnStorefront.click();
    }
    @Step
    public void clickMainMenuOnStorefront(){
        mainMenuOnStorefront.click();
    }
}