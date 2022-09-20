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
    @FindBy(xpath = "//div[contains(@class, 'ab__motivation_block')]//span[contains(text(), 'Наши преимущества')]")
    private WebElement motivationElementOnProductPage;
    @FindBy(xpath = "//li[@class='ty-menu__item cm-menu-item-responsive  ty-menu-item__apparel']")
    private WebElement apparelCategoryOnStorefront;
    @FindBy(xpath = "//div[@class='ty-grid-list__item-name']//a[contains(@title, 'GoPro')]")
    private WebElement productGoProOnStorefront;


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
    public WebElement getMotivationElementOnProductPage(){
        return motivationElementOnProductPage;
    }
    @Step
    public void navigateToApparelCategoryOnStorefront(){
        apparelCategoryOnStorefront.click();
    }
    @Step
    public void chooseProductGoProOnStorefront(){
        productGoProOnStorefront.click();
    }
}