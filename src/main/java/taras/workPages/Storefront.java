package taras.workPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import taras.constants.AbstractPage;
import taras.constants.DriverProvider;

public class Storefront extends AbstractPage {
    public Storefront() {super();}

    @FindBy(css = ".ab__motivation_block")
    public WebElement motivationBlock;

    @FindBy(css = "a[id*='wrap_language']")
    WebElement languageButton;

    @FindBy(xpath = "//li[@class=\"ty-menu__item cm-menu-item-responsive ty-menu-item__apparel\"]")
    WebElement menu_Apparel;

    @FindBy(css = ".ty-menu-item__apparel div[id*='topmenu_'] .ty-menu__submenu-col")
    WebElement menu_MenCloth;

    @FindBy(xpath = "//a[contains(@href, 'gopro-hero3-black-edition-camera')]")
    public WebElement productGoProOnStorefront;

    @FindBy(xpath = "//div[contains(@class, 'ab__motivation_block')]")
    public WebElement motivationBlockOnProductPage;


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
    private void scrollTo_ApparelCategory() {
        WebElement menuApparel = getMenu_Apparel();
        Actions hoverMotivationBlock = new Actions(DriverProvider.getDriver());
        hoverMotivationBlock.moveToElement(menuApparel);
        hoverMotivationBlock.perform();
    }
    public void navigateTo_MenClothCategory() {
        scrollTo_ApparelCategory();
        menu_MenCloth.click();
    }
}