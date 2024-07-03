package taras.workPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import taras.constants.AbstractPage;
import taras.constants.DriverProvider;

import java.util.List;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Storefront extends AbstractPage {
    public Storefront() {super();}

    @FindBy(css = ".ab__motivation_block")
    public WebElement motivationBlock;

    @FindBy(css = "a[id*='wrap_language']")
    WebElement languageButton;

    @FindBy(xpath = "//li[@class='ty-menu__item cm-menu-item-responsive ty-menu-item__apparel']")
    public WebElement menu_Apparel;

    @FindBy(xpath = "//li[contains(@class, 'ty-menu-item__apparel')]//div[@data-elem-index='0']")
    WebElement menu_MenCloth;

    @FindBy(xpath = "//a[contains(@href, 'gopro-hero3-black-edition-camera')]")
    public WebElement productGoProOnStorefront;

    @FindBy(css = ".ut2-gl__image")
    public WebElement chooseFirstProduct;

    @FindBy(xpath = "//div[contains(@class, 'ab__vertical_tabs')]")
    public List<WebElement> verticalBlock;

    @FindBy(xpath = "//div[contains(@class, 'ab__horizontal_tabs')]")
    public List<WebElement> horizontalBlock;

    @FindBy(css = ".ty-geo-maps-shipping__wrapper")
    public WebElement template_ShippingMethod;

    @FindBy(css = ".ab__mb_items .ut2-icon-outline-local_shipping")
    public WebElement elementDelivery;

    @FindBy(css = ".ab__mb_items .ut2-icon-outline-new_releases")
    public WebElement element_OurAdvantages;

    @FindBy(css = ".ab__mb_items .ut2-icon-baseline-credit_card")
    public WebElement element_PaymentMethods;

    @FindBy(css = ".ab__mb_items .ut2-icon-outline-menu")
    public WebElement element_FindSimilar;


    private WebElement getMotivationBlock(){
        return motivationBlock;
    }
    public void scrollToMotivationBlock () {
        WebElement element = getMotivationBlock();
        Actions move = new Actions(DriverProvider.getDriver());
        move.moveToElement(element);
        move.perform();
    }

    private WebElement getLanguageButton(){return languageButton;}
    public void selectLanguage (String arRuEn){
        WebElement element = getLanguageButton();
        Actions move = new Actions(DriverProvider.getDriver());
        move.moveToElement(element);
        move.perform();
        languageButton.click();
        DriverProvider.getDriver().findElement(By.cssSelector(".ty-select-block__list-item a[data-ca-name='" + arRuEn + "']")).click();
    }

    private WebElement getMenu_Apparel() {
        return menu_Apparel;
    }
    public void scrollTo_ApparelCategory() {
        WebElement menuApparel = getMenu_Apparel();
        Actions hoverMotivationBlock = new Actions(DriverProvider.getDriver());
        hoverMotivationBlock.moveToElement(menuApparel);
        hoverMotivationBlock.perform();
    }
    public void navigateTo_MenClothCategory() {
        scrollTo_ApparelCategory();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(menu_MenCloth));
        menu_MenCloth.click();
    }
}