package taras.yanishevskyi.WorkPages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import taras.yanishevskyi.AbstractPage;
import taras.yanishevskyi.DriverProvider;

public class AdminPanel extends AbstractPage {
    public AdminPanel(){
        super();
    }

    public void navigateToAddonsPage(AdminPanel adminPanel) {
        WebElement elementOfAddonsDropDown = hoverAddonsDropDown();
        Actions hoverAddonsDropDown = new Actions(DriverProvider.getDriver());
        hoverAddonsDropDown.moveToElement(elementOfAddonsDropDown);
        hoverAddonsDropDown.perform();
        navigateToAddonsManagementPage();
    }
    public void navigateToProductPage(AdminPanel adminPanelTwo){
        WebElement elementOfMenuProducts = hoverMenuProducts();
        Actions hoverMenuProducts = new Actions(DriverProvider.getDriver());
        hoverMenuProducts.moveToElement(elementOfMenuProducts);
        hoverMenuProducts.perform();
        navigateToProductPage();
    }

    @FindBy(css = ".btn.btn-primary")
    private WebElement buttonAuthorization;
    @FindBy(xpath = "(//a[@class=\"dropdown-toggle addons\"])[1]")
    private WebElement addonsDropDown;
    @FindBy(id = "elm_menu_addons_manage_addons")
    private WebElement addonsManagementPage;
    @FindBy(xpath = "//tr[@id=\"addon_ab__motivation_block\"]//button[@class=\"btn dropdown-toggle\"]")
    private WebElement buttonOfAddon;
    @FindBy(xpath = "(//div[@class=\"btn-group dropleft open\"]//a[contains(@href, 'ab__motivation_block')])[2]")
    private WebElement generalSettings;
    @FindBy(id = "input_cat_224")
    private WebElement categoryMenClothing;
    @FindBy(id = "input_cat_259")
    private WebElement categoryPlayStation;
    @FindBy(css = ".btn.cm-dialog-closer.btn-primary")
    private WebElement savePopup;
    @FindBy(css = ".btn.btn-primary.cm-submit")
    private WebElement saveButtonOnTopRight;
    @FindBy(xpath = "(//li[@class=\"dropdown nav__header-main-menu-item \"])[2]")
    private WebElement menuProducts;
    @FindBy(xpath = "//li[contains(@class, 'products nav__header-main-menu-subitem')]//a[contains(@href, '=products.manage')]")
    private WebElement productPage;



    @Step
    public void clickButtonAuthorization(){
        buttonAuthorization.click();
    }
    @Step
    public WebElement hoverAddonsDropDown(){
        return addonsDropDown;
    }
    @Step
    public void navigateToAddonsManagementPage(){
        addonsManagementPage.click();
    }
    @Step
    public void clickButtonOfAddon(){
        buttonOfAddon.click();
    }
    @Step
    public MotivationBlock navigateToGeneralSettings(){
        generalSettings.click();
        return new MotivationBlock();
    }

    @Step
    public void chooseCategoryMenClothing(){
        categoryMenClothing.click();
    }
    @Step
    public void chooseCategoryPlayStation(){
        categoryPlayStation.click();
    }
    @Step
    public void clickSavePopup(){
        savePopup.click();
    }
    @Step
    public void clickSaveButtonOnTopRight(){
        saveButtonOnTopRight.click();
    }

    @Step
    public WebElement hoverMenuProducts(){
        return menuProducts;
    }
    @Step
    public ProductPage navigateToProductPage(){
        productPage.click();
        return new ProductPage();
    }
}
