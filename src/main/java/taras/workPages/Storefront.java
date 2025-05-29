package taras.workPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.FindBy;
import taras.constants.AbstractPage;
import taras.constants.DriverProvider;

import java.util.List;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class Storefront extends AbstractPage {
    public Storefront() {
        super();
    }

    @FindBy(css = ".ab__motivation_block")
    public WebElement motivationBlock;

    @FindBy(css = "a[id*='wrap_language']")
    WebElement languageButton;

    @FindBy(xpath = "//li[@class='ut2-menu__item ty-menu-item__apparel']")
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

    @FindBy(xpath = "//div[contains(@class, 'ab__motivation_block')]//*[text()='Доставка']")
    public List<WebElement> elements_Delivery;

    @FindBy(xpath = "//div[contains(@class, 'ab__motivation_block')]//*[text()='Гарантия и возврат']")
    public List<WebElement> element_WarrantyAndReturns;

    @FindBy(xpath = "//div[contains(@class, 'ab__motivation_block')]//*[text()='Варианты оплаты']")
    public WebElement element_PaymentMethods;

    @FindBy(xpath = "//div[contains(@class, 'ab__motivation_block')]//*[text()='Найдите похожие']")
    public WebElement element_FindSimilar;

    @FindBy(xpath = "//li[contains(text(), '— Банковская карта')]")
    public WebElement template_PaymentMethods;

    @FindBy(css = ".ab-mb-prod-categories-list")
    public WebElement template_CategoriesList;


    Actions actions = new Actions(DriverProvider.getDriver());

    public void scrollToTop() {
        ((JavascriptExecutor) DriverProvider.getDriver()).executeScript("window.scrollTo(0, 0);");
    }

    public void scrollToMotivationBlock() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.scrollFromOrigin(WheelInput.ScrollOrigin.fromElement(motivationBlock), 0, 450).perform();
    }

    public void selectLanguage(String arRuEn) {
        scrollToTop();
        actions.moveToElement(languageButton).perform();
        languageButton.click();
        DriverProvider.getDriver().findElement(By.cssSelector(".ty-select-block__list-item a[data-ca-name='" + arRuEn + "']")).click();
    }

    public void scrollTo_ApparelCategory() {
        scrollToTop();
        actions.moveToElement(menu_Apparel).perform();
    }

    public void navigateTo_MenClothCategory() {
        scrollTo_ApparelCategory();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(menu_MenCloth));
        menu_MenCloth.click();
    }
}