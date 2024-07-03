package taras.workPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import taras.constants.AbstractPage;
import taras.constants.DriverProvider;


public class AdminPanel extends AbstractPage implements CheckMenuToBeActive {
    public AdminPanel() {super();}

    @FindBy(css = ".btn.btn-primary.cm-submit")
    public WebElement saveButtonOnTopRight;


    //Меню -- Модули -- Скачанные модули
    @FindBy(xpath = "//span[text()='Модули']")
    WebElement menu_Addons;

    @FindBy(id = "addons_downloaded_add_ons")
    WebElement menu_DownloadedAddons;

    @FindBy(xpath = "//tr[@id='addon_ab__motivation_block']//button[@class='btn dropdown-toggle']")
    WebElement addonSectionsOnPage_DownloadedAddons;

    @FindBy(xpath = "//div[@class='btn-group dropleft open']//a[contains(@href, 'addon=ab__motivation_block')]")
    WebElement section_GeneralSettings;

    @FindBy(xpath = "//a[contains(@href, 'dispatch=ab__motivation_block.manage')]")
    WebElement section_DataManagementPage;

    @FindBy(id = "settings")
    WebElement tab_Settings;

    @FindBy(xpath = "//a[contains(@href, 'addon=geo_maps')][contains(@class, 'addons-addon-icon__wrapper')]")
    WebElement addon_MapsAndGeolocation;

    public void navigateTo_DownloadedAddonsPage() {
        checkMenuToBeActive("dispatch=addons.manage", menu_Addons);
        menu_DownloadedAddons.click();
    }

    public MotivationBlock navigateTo_MotivationBlock_Settings() {
        navigateTo_DownloadedAddonsPage();
        addonSectionsOnPage_DownloadedAddons.click();
        section_GeneralSettings.click();
        tab_Settings.click();
        return new MotivationBlock();
    }

    public MotivationBlock navigateTo_MotivationBlock_DataManagementPage(){
        navigateTo_DownloadedAddonsPage();
        addonSectionsOnPage_DownloadedAddons.click();
        section_DataManagementPage.click();
        return new MotivationBlock();
    }

    public MapsAndGeolocation navigateTo_MapsAndGeolocation_Settings(){
        navigateTo_DownloadedAddonsPage();
        if(DriverProvider.getDriver().findElement(By.cssSelector(".bp-panel-active")).isEnabled()){
            DriverProvider.getDriver().findElement(By.cssSelector("#bp_off_bottom_panel")).click();
        }
        addon_MapsAndGeolocation.click();
        tab_Settings.click();
        return new MapsAndGeolocation();
    }


    //Меню "Товары --Товары"
    @FindBy(id = "products_products")
    WebElement section_Products;

    public ProductPage navigateToSection_Products() {
        checkMenu_Products_ToBeActive();
        section_Products.click();
        return new ProductPage();
    }


    //Меню "Веб-сайт -- Темы -- Макеты"
    @FindBy(xpath = "//span[text()='Веб-сайт']")
    WebElement menu_Website;

    @FindBy(id = "website_themes")
    WebElement menu_Themes;

    @FindBy(css = ".nav__actions-bar a[href$='block_manager.manage']")
    WebElement section_Layouts;

    @FindBy(css = "a[href$='block_manager.manage&s_layout=6']")
    public WebElement layout_Lightv2;

    @FindBy(css = ".with-menu.active .dropdown-toggle")
    WebElement gearwheelOfActiveLayout;

    @FindBy(css = ".with-menu.active a[href*='block_manager.set_default_layout']")
    WebElement button_makeByDefault;

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
}