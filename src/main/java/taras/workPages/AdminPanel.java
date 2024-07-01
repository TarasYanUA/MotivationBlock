package taras.workPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import taras.constants.AbstractPage;
import taras.constants.DriverProvider;


public class AdminPanel extends AbstractPage implements CheckMenuToBeActive {
    public AdminPanel() {super();}

    @FindBy(css = ".btn.btn-primary.cm-submit")
    public WebElement saveButtonOnTopRight;

    //Меню -- Модули -- Скачанные модули
    @FindBy(xpath = "//span[text()='Модули']")
    private WebElement menu_Addons;

    @FindBy(id = "addons_downloaded_add_ons")
    private WebElement menu_DownloadedAddons;

    @FindBy(xpath = "//tr[@id='addon_ab__motivation_block']//button[@class='btn dropdown-toggle']")
    private WebElement addonSectionsOnPage_DownloadedAddons;

    @FindBy(xpath = "//div[@class=\"btn-group dropleft open\"]//a[contains(@href, 'addon=ab__motivation_block')]")
    private WebElement generalSettings;

    @FindBy(id = "settings")
    private WebElement tabSettings;

    public void navigateTo_DownloadedAddonsPage() {
        checkMenuToBeActive("dispatch=addons.manage", menu_Addons);
        menu_DownloadedAddons.click();
    }

    public MotivationBlock navigateTo_MotivationBlockSettings() {
        navigateTo_DownloadedAddonsPage();
        addonSectionsOnPage_DownloadedAddons.click();
        generalSettings.click();
        tabSettings.click();
        return new MotivationBlock();
    }


    //Меню "Товары --Товары"
    @FindBy(id = "products_products")
    private WebElement section_Products;

    public ProductPage navigateToSection_Products() {
        checkMenu_Products_ToBeActive();
        section_Products.click();
        return new ProductPage();
    }


    //Меню "Веб-сайт -- Темы -- Макеты"
    @FindBy(xpath = "//span[text()='Веб-сайт']")
    private WebElement menu_Website;

    @FindBy(id = "website_themes")
    private WebElement menu_Themes;

    @FindBy(css = ".nav__actions-bar a[href$='block_manager.manage']")
    private WebElement section_Layouts;

    @FindBy(css = "a[href$='block_manager.manage&s_layout=6']")
    public WebElement layout_Lightv2;

    @FindBy(css = ".with-menu.active .dropdown-toggle")
    private WebElement gearwheelOfActiveLayout;

    @FindBy(css = ".with-menu.active a[href*='block_manager.set_default_layout']")
    private WebElement button_makeByDefault;

    public void navigateToSection_WebsiteLayouts(){
        checkMenuToBeActive("dispatch=themes.manage", menu_Website);
        menu_Themes.click();
        section_Layouts.click();
    }

    public WebElement hoverGearwheelOfActiveLayout(){return gearwheelOfActiveLayout;}
    public void setLayout_Lightv2_AsDefault(){
        layout_Lightv2.click();
        WebElement element = hoverGearwheelOfActiveLayout();
        Actions hover = new Actions(DriverProvider.getDriver());
        hover.moveToElement(element);
        hover.perform();
        gearwheelOfActiveLayout.click();
        if(!DriverProvider.getDriver().findElements(By.cssSelector(".with-menu.active a[href*='block_manager.set_default_layout']")).isEmpty()){
            button_makeByDefault.click();
            try { Thread.sleep(1500);
            } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }



    ////////////////////////////
    @FindBy(id = "elm_menu_addons")
    private WebElement addonsDropDown;
    @FindBy(id = "elm_menu_addons_downloaded_add_ons")
    private WebElement addonsManagementPage;
    @FindBy(xpath = "//button[@class=\"close cm-notification-close cm-notification-close-ajax\"]")
    private WebElement closeWarning;
    @FindBy(xpath = "//tr[@id=\"addon_ab__motivation_block\"]//button[@class=\"btn dropdown-toggle\"]")
    private WebElement buttonOfAddon;
    @FindBy(xpath = "(//div[@class=\"btn-group dropleft open\"]//a[contains(@href, 'ab__motivation_block')])[1]")
    private WebElement dataManagementPage;
    @FindBy(xpath = "//a[@class='btn cm-submit cm-addons-save-settings']")
    private WebElement saveButtonForAddonSettings;
    @FindBy(xpath = "//li[@class='dropdown nav__header-main-menu-item ']//a[@href='#products']")
    private WebElement menuProducts;
    @FindBy(xpath = "//span[text()='Товары']")
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



    public WebElement hoverAddonsDropDown(){
        return addonsDropDown;
    }
    
    public void navigateToAddonsManagementPage(){
        addonsManagementPage.click();
        if(DriverProvider.getDriver().findElements(By.cssSelector(".cm-notification-close")).size() > 0){
            DriverProvider.getDriver().findElement(By.cssSelector(".cm-notification-close")).click();
        }
    }
    
    public MotivationBlock navigateToDataManagementPage(){
        dataManagementPage.click();
        return new MotivationBlock();
    }
    
    public void clickSaveButtonForAddonSettings(){
        saveButtonForAddonSettings.click();
    }
    
    public WebElement hoverMenuProducts(){
        return menuProducts;
    }
    
    public void chooseGeolocationAddon(){
        geolocationAddon.click();
    }
    
    public Select getDropboxValueForGeolocation_Service(){
        return new Select(dropboxValueForGeolocation_Service);
    }
    
    public String selectDropboxValueForGeolocation_Service(String value){
        getDropboxValueForGeolocation_Service().selectByValue(value);
        return value;
    }

    public void clickGeolocationCheckbox_ShowShippingCost(){
        geolocationCheckbox_ShowShippingCost.click();
    }
    
    public void clickGeolocationTabGoogle(){
        geolocationTabGoogle.click();
    }
    
    public void clickAndTypeGeolocation_ApiKey(){
        geolocation_ApiKey.click();
        geolocation_ApiKey.sendKeys("AIzaSyBN51Tl05m8bPKtgHswOGtllu_TO3_bEN8");
    }
    
    public void clickAndTypeSearchFieldOfAddons(){
        searchFieldOfAddons.click();
        searchFieldOfAddons.sendKeys("Геолокация");
        searchFieldOfAddons.sendKeys(Keys.ENTER);
    }
    
    public void clickStorefrontMainButton(){
        storefrontMainButton.click();
    }
}