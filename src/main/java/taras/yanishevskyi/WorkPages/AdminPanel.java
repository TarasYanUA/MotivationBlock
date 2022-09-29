package taras.yanishevskyi.WorkPages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import taras.yanishevskyi.AbstractPage;
import taras.yanishevskyi.DriverProvider;
import java.util.ArrayList;

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
    public void hoverToProductPage(AdminPanel adminPanelTwo){
        WebElement elementOfMenuProducts = hoverMenuProducts();
        Actions hoverMenuProducts = new Actions(DriverProvider.getDriver());
        hoverMenuProducts.moveToElement(elementOfMenuProducts);
        hoverMenuProducts.perform();
        //navigateToProductPage();
    }
    public void focusBrowserTab() {
        ArrayList tabs = new ArrayList<String> (DriverProvider.getDriver().getWindowHandles());
        for(int ii = 0; ii <= 1; ii++) {
            DriverProvider.getDriver().switchTo().window(tabs.get(ii).toString());
        }
    }

    @FindBy(css = ".btn.btn-primary")
    private WebElement buttonAuthorization;
    @FindBy(xpath = "(//a[@class=\"dropdown-toggle addons\"])[1]")
    private WebElement addonsDropDown;
    @FindBy(id = "elm_menu_addons_manage_addons")
    private WebElement addonsManagementPage;
    @FindBy(xpath = "//button[@class=\"close cm-notification-close cm-notification-close-ajax\"]")
    private WebElement closeWarning;
    @FindBy(xpath = "//tr[@id=\"addon_ab__motivation_block\"]//button[@class=\"btn dropdown-toggle\"]")
    private WebElement buttonOfAddon;
    @FindBy(xpath = "(//div[@class=\"btn-group dropleft open\"]//a[contains(@href, 'ab__motivation_block')])[2]")
    private WebElement generalSettings;
    @FindBy(xpath = "(//div[@class=\"btn-group dropleft open\"]//a[contains(@href, 'ab__motivation_block')])[1]")
    private WebElement dataManagementPage;
    @FindBy(id = "input_cat_224")
    private WebElement categoryMenClothing;
    @FindBy(id = "input_cat_259")
    private WebElement categoryPlayStation;
    @FindBy(css = ".btn.cm-dialog-closer.btn-primary")
    private WebElement savePopup;
    @FindBy(css = ".btn.btn-primary.cm-submit")
    private WebElement saveButtonOnTopRight;
    @FindBy(xpath = "//a[@class='btn cm-submit cm-addons-save-settings']")
    private WebElement saveButtonForAddonSettings;
    @FindBy(xpath = "//li[@class='dropdown nav__header-main-menu-item ']//a[@href='#products']")
    private WebElement menuProducts;
    @FindBy(xpath = "//li[contains(@class, 'products nav__header-main-menu-subitem')]//a[contains(@href, 'dispatch=products.manage')]")
    //@FindBy(xpath = "//span[text()='Товары']")
    private WebElement productPage;
    @FindBy(xpath = "//a[contains(@href, 'addon=geo_maps')][contains(@class, 'addons-addon-icon__wrapper')]")
    private WebElement geolocationAddon;
    @FindBy(xpath = "//select[contains(@id, 'addon_option_geo_maps_provider')]")
    private WebElement dropboxValueForGeolocation_Service;
    @FindBy(xpath = "//input[contains(@id, 'addon_option_geo_maps_show_shippings_on_product')]")
    private WebElement geolocationCheckbox_ShowShippingCost;
    @FindBy(id = "geo_maps_google")
    private WebElement geolocationTabGoogle;
    @FindBy(xpath = "//input[contains(@id, 'addon_option_geo_maps_google_api_key')]")
    private WebElement geolocation_ApiKey;
    @FindBy(id = "elm_addon")
    private WebElement searchFieldOfAddons;
    @FindBy(css = ".cs-icon.icon-shopping-cart")
    private WebElement storefrontMainButton;


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
    public void clickCloseWarning(){
        closeWarning.click();
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
    public MotivationBlock navigateToDataManagementPage(){
        dataManagementPage.click();
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
    public void clickSaveButtonForAddonSettings(){
        saveButtonForAddonSettings.click();
    }
    @Step
    public WebElement hoverMenuProducts(){
        return menuProducts;
    }
    @Step
/*    public ProductPage navigateToProductPage(){
        productPage.click();
        return new ProductPage();
    }*/
    public void navigateToProductPage(){
        productPage.click();
    }
    @Step
    public void chooseGeolocationAddon(){
        geolocationAddon.click();
    }
    @Step
    public Select getDropboxValueForGeolocation_Service(){
        return new Select(dropboxValueForGeolocation_Service);
    }
    @Step
    public String selectDropboxValueForGeolocation_Service(String value){
        getDropboxValueForGeolocation_Service().selectByValue(value);
        return value;
    }
    @Step
    public void clickGeolocationCheckbox_ShowShippingCost(){
        geolocationCheckbox_ShowShippingCost.click();
    }
    @Step
    public void clickGeolocationTabGoogle(){
        geolocationTabGoogle.click();
    }
    @Step
    public void clickAndTypeGeolocation_ApiKey(){
        geolocation_ApiKey.click();
        geolocation_ApiKey.sendKeys("AIzaSyBN51Tl05m8bPKtgHswOGtllu_TO3_bEN8");
    }
    @Step
    public void clickAndTypeSearchFieldOfAddons(){
        searchFieldOfAddons.click();
        searchFieldOfAddons.sendKeys("Геолокация");
        searchFieldOfAddons.sendKeys(Keys.ENTER);
    }
    @Step
    public void clickStorefrontMainButton(){
        storefrontMainButton.click();
    }
}