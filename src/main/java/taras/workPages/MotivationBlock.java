package taras.workPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import taras.constants.AbstractPage;


public class MotivationBlock extends AbstractPage {
    public MotivationBlock(){
        super();
    }

    @FindBy(css = ".btn-group.dropleft.ab__am-menu")
    public WebElement abMenuDropdown;

    //Меню "Настройки модуля"
    @FindBy(id = "ab__motivation_block_appearance")
    public WebElement tabAppearance;

    @FindBy(xpath = "//select[contains(@id, 'addon_option_ab__motivation_block_description_type')]")
    WebElement dropboxValueForElements_description_type;

    @FindBy(xpath = "//input[contains(@id, 'addon_option_ab__motivation_block_use_additional_categories')]")
    public WebElement checkbox_UseAdditionalProductCategories;

    @FindBy(css = "select[id*='addon_option_ab__motivation_block_template_variant_']")
    WebElement settingTemplateVariant;

    @FindBy(xpath = "//select[contains(@id, 'addon_option_ab__motivation_block_appearance_type_styles')]")
    WebElement settingBlockStyle;

    @FindBy(className = "sp-preview-inner")
    public WebElement settingBlockColor;

    @FindBy(xpath = "//span[@title='#ff0000']")
    public WebElement redColorForBlock;

    @FindBy(xpath = "//span[@title='#cfe2f3']")
    public WebElement blueColorForBlock;

    @FindBy(className = "sp-choose")
    public WebElement submitColorForBlock;


    private Select getDropboxValueForElements_description_type(){
        return new Select(dropboxValueForElements_description_type);
    }
    public void selectDropboxValueForElements_description_type(String value) {
        getDropboxValueForElements_description_type().selectByValue(value);
    }

    private Select getSettingTemplateVariant(){
        return new Select(settingTemplateVariant);
    }
    public void selectSettingTemplateVariant(String value){
        getSettingTemplateVariant().selectByValue(value);
    }

    private Select getSettingBlockStyle(){
        return new Select(settingBlockStyle);
    }
    public void selectSettingBlockStyle(String value){
        getSettingBlockStyle().selectByValue(value);
    }


    //Меню "Управление данными"
    @FindBy(css = ".ab__am-menu a[href*='dispatch=ab__motivation_block.manage']")
    public WebElement abMenu_sectionDataManagement;

    @FindBy(xpath = "//a[text()='Доставка']")
    public WebElement elementDelivery;

    @FindBy(xpath = "//a[text()='Варианты оплаты']")
    public WebElement elementPaymentMethods;

    @FindBy(xpath = "//a[text()='Наши преимущества']")
    public WebElement elementOurAdvantages;

    @FindBy(id = "categories")
    public WebElement tabCategories;

    @FindBy(xpath = "//a[contains(@id, 'opener_picker_category_ids_')]")
    public WebElement addCategoriesButton;

    @FindBy(id = "input_cat_224")
    public WebElement chooseCategory_MenCloth;

    @FindBy(id = "input_cat_254")
    public WebElement chooseCategory_GameConsoles;

    @FindBy(id = "ab__mb_template_path")
    WebElement elementPage_Template;

    @FindBy(id = "sw_select_4_wrap")
    public WebElement statusButton;

    @FindBy(xpath = "//a[contains(@class, 'status-link-a  cm-ajax')][@title='Вкл.']")
    public WebElement statusActive;

    @FindBy(css = ".cm-form-dialog-closer")
    public WebElement saveCategoriesAtPopup;

    
    private Select getElementPage_Template(){
        return new Select(elementPage_Template);
    }
    public void selectElementPage_Template(String value){
        getElementPage_Template().selectByValue(value);
    }
}