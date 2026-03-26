package taras.workPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import taras.constants.AbstractPage;
import taras.constants.DriverProvider;

import java.util.List;


public class MotivationBlock extends AbstractPage {
    public MotivationBlock() {
        super();
    }

    @FindBy(css = ".btn-group.dropleft.ab__am-menu")
    public WebElement abMenuDropdown;

    //Меню "Настройки модуля"
    @FindBy(id = "ab__motivation_block_appearance")
    public WebElement tabAppearance;

    @FindBy(css = "select[id*='addon_option_ab__motivation_block_template_variant_']")
    WebElement settingTemplateVariant;

    @FindBy(xpath = "//select[contains(@id, 'addon_option_ab__motivation_block_appearance_type_styles')]")
    WebElement settingBlockStyle;

    @FindBy(xpath = "//input[contains(@id, 'addon_option_ab__motivation_block_use_contrast_style_elements_')]")
    public WebElement setting_ApplyContrastToElements;

    @FindBy(className = "sp-preview-inner")
    public WebElement settingBlockColor;

    @FindBy(xpath = "//span[@title='#9900ff']")
    public WebElement violetColorForBlock;

    @FindBy(xpath = "//span[@title='#cfe2f3']")
    public WebElement blueColorForBlock;

    @FindBy(className = "sp-choose")
    public WebElement submitColorForBlock;

    @FindBy(css = ".ab__mb_items.framed.colored")
    public List<WebElement> elementIsFramed;

    @FindBy(css = ".ab__mb_items.fill.colored")
    public List<WebElement> elementIsFilled;

    public void selectSettingTemplateVariant(String value) {
        Utils.makePause(1500);
        new Select(settingTemplateVariant).selectByValue(value);
    }

    public void selectSettingBlockStyle(String value) {
        new Select(settingBlockStyle).selectByValue(value);
    }

    public void selectColorForBlock(WebElement color) {
        settingBlockColor.click();
        color.click();
        submitColorForBlock.click();
    }


    //Меню "Управление данными"
    @FindBy(css = ".ab__am-menu a[href*='dispatch=ab__motivation_block.manage']")
    public WebElement abMenu_sectionDataManagement;

    @FindBy(xpath = "//a[text()='Доставка']")
    public WebElement elementShipment;

    @FindBy(xpath = "//a[text()='Варианты оплаты']")
    public WebElement elementPaymentMethods;

    @FindBy(xpath = "//a[text()='Гарантия и возврат']")
    public WebElement element_WarrantyAndReturns;

    @FindBy(id = "categories")
    public WebElement tabCategories;

    @FindBy(xpath = "//a[contains(@id, 'opener_picker_category_ids_')]")
    public WebElement addCategoriesButton;

    @FindBy(id = "ab__mb_template_path")
    WebElement elementPage_Template;

    @FindBy(id = "sw_select_4_wrap")
    public WebElement statusButton;

    @FindBy(xpath = "//div[contains(@class, 'dropleft open')]//a[contains(@class, 'status-link-a  cm-ajax')][@title='Вкл.']")
    public WebElement statusActive;

    @FindBy(css = ".cm-form-dialog-closer")
    public WebElement saveCategoriesAtPopup;


    public void selectElementPage_Template(String value) {
        new Select(elementPage_Template).selectByValue(value);
    }

    public void configureFindSimilarAsCategoryList() {
        abMenuDropdown.click();
        abMenu_sectionDataManagement.click();
        if (DriverProvider.getDriver().findElement(By.xpath("//a[@id='sw_select_4_wrap']")).getText().contains("Выкл.")) {
            statusButton.click();
            statusActive.click();
        }
    }

    public void addCategoriesToMotivationElement() {
        AdminPanel adminPanel = new AdminPanel();
        CategoryPage categoryPage = new CategoryPage();

        tabCategories.click();
        if (DriverProvider.getDriver().findElement(By.xpath("//p[text()='Все категории включены']")).isDisplayed()) {
            addCategoriesButton.click();
            Utils.waitForPopupPresence();
            if (!categoryPage.collapsedCategoryList.isEmpty()) {
                Utils.waitForElementToBeClickableAndClick(categoryPage.expandCategoryList);
                Utils.waitForElementToBeClickableAndClick(categoryPage.popup_category_apparel);
                Utils.waitForElementToBeClickableAndClick(categoryPage.categoryMenClothing);

                Utils.waitForElementToBeClickableAndClick(categoryPage.popup_category_electronics);
                Utils.waitForElementToBeClickableAndClick(categoryPage.popup_category_gameConsoles);
                Utils.waitForElementToBeClickableAndClick(categoryPage.popup_category_consoles);
                Utils.waitForElementToBeClickableAndClick(categoryPage.categoryConsolesMicrosoft);
            } else {
                categoryPage.categoryMenClothing.click();
                categoryPage.categoryConsolesMicrosoft.click();
            }
            saveCategoriesAtPopup.click();
            adminPanel.saveButtonOnTopRight.click();
        }
    }
}